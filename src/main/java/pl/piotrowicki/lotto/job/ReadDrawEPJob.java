package pl.piotrowicki.lotto.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.entity.DrawEPEntity;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawEPJob extends BaseDrawJob<DrawEPEntity> {

    private static final Logger LOGGER = Logger.getLogger(ReadDrawEPJob.class);

    private static final String EKSTRA_PENSJA = "http://app.lotto.pl/wyniki/?type=ep";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawService service;

    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReaderService.read(EKSTRA_PENSJA);

        DrawEPEntity entity = null;
        try {
            entity = convertToEntity(DrawEPEntity.class, input);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String of EKSTRA PENSJA into Entity: " + ex);
        }
        DrawEPEntity result = service.findByDrawAndDrawDate(DrawEPEntity.class, entity.getNumbers(), entity.getDrawDate());

        if (result == null) {
            service.save(entity);
        }
    }
}
