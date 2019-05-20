package pl.piotrowicki.lotto.job;

import java.util.Optional;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.bean.annotation.Log;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Singleton
public class ReadDrawJob extends BaseDrawJob<DrawEntity>  {
    
    private static final Logger LOGGER = Logger.getLogger(ReadDrawJob.class);
    
    private static final String LOTTO_URL = "http://app.lotto.pl/wyniki/?type=dl";
   
    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawService drawService;

    @Log
    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReaderService.read(LOTTO_URL);

        DrawEntity entity = null;
        try {
            entity = convertToEntity(DrawEntity.class, input);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String into Entity: " + ex);
        } 

        Optional<DrawEntity> result = drawService.findByDrawAndDrawDate(entity.getNumbers(), entity.getDrawDate());

        if (!result.isPresent()) {
            drawService.save(entity);
        }
    } 
}
