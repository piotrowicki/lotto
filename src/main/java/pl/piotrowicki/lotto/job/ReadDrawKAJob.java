package pl.piotrowicki.lotto.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.bean.annotation.Log;
import pl.piotrowicki.lotto.entity.draw.DrawKAEntity;
import pl.piotrowicki.lotto.service.draw.DrawService;
import pl.piotrowicki.lotto.service.draw.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawKAJob extends BaseDrawJob<DrawKAEntity> {

    private static final Logger LOGGER = Logger.getLogger(ReadDrawKAJob.class);

    private static final String KASKADA = "http://app.lotto.pl/wyniki/?type=ka";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawService drawService;

    @Log
    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReaderService.read(KASKADA);

        DrawKAEntity entity = null;
        try {
            entity = convertToEntity(DrawKAEntity.class, input);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String of KASKADA into Entity: " + ex);
        }

        DrawKAEntity result = drawService.findByDrawAndDrawDate(DrawKAEntity.class, entity.getNumbers(), entity.getDrawDate());

        if (result == null) {
            drawService.save(entity);
        }
    }
}
