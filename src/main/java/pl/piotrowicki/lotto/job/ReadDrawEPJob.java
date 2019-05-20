package pl.piotrowicki.lotto.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import pl.piotrowicki.lotto.entity.DrawEPEntity;
import pl.piotrowicki.lotto.service.DrawEPService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawEPJob extends BaseDrawJob<DrawEPEntity> {

    private static final String EKSTRA_PENSJA = "http://app.lotto.pl/wyniki/?type=ep";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawEPService service;

    @Schedule(hour = "*/7", persistent = false)
    public void run() throws InstantiationException, IllegalAccessException {
        String input = jsoupReaderService.read(EKSTRA_PENSJA);

        DrawEPEntity entity = convertToEntity(DrawEPEntity.class, input);
        DrawEPEntity result = service.findByDrawAndDrawDate(entity.getNumbers(), entity.getDrawDate());

        if (result != null) {
            service.save(entity);
        }
    }
}
