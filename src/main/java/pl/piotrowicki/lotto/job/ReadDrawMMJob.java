package pl.piotrowicki.lotto.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.entity.draw.DrawMMEntity;
import pl.piotrowicki.lotto.service.draw.DrawService;
import pl.piotrowicki.lotto.service.draw.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawMMJob extends BaseDrawJob<DrawMMEntity> {

    private static final Logger LOGGER = Logger.getLogger(ReadDrawMMJob.class);

    private static final String MULTI_MULTI_14 = "http://app.lotto.pl/wyniki/?type=mm14";
    private static final String MULTI_MULTI_22 = "http://app.lotto.pl/wyniki/?type=mm22";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawService service;

    @Schedule(hour = "*/4", persistent = false)
    public void run() {
        String input14 = jsoupReaderService.read(MULTI_MULTI_14);

        DrawMMEntity entity = null, result = null;
        try {
            entity = convertToEntity(DrawMMEntity.class, input14);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String of MULTI MULTI 14 into Entity: " + ex);
        }
        result = service.findByDrawAndDrawDate(DrawMMEntity.class, entity.getNumbers(), entity.getDrawDate());

        if (result == null) {
            service.save(entity);
        }

        String input22 = jsoupReaderService.read(MULTI_MULTI_22);
        try {
            entity = convertToEntity(DrawMMEntity.class, input22);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String of MULTI MULTI 22 into Entity: " + ex);
        }
        result = service.findByDrawAndDrawDate(DrawMMEntity.class, entity.getNumbers(), entity.getDrawDate());

        if (result == null) {
            service.save(entity);
        }
    }
}
