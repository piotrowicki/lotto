package pl.piotrowicki.lotto.job;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReader;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Singleton
public class ReadDrawJob implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ReadDrawJob.class.getName());

    @Inject
    private JsoupReader jsoupReader;

    @Inject
    private DrawService drawService;

    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReader.read();

        Draw entity = drawService.convertToEntity(input);

        Optional<Draw> result = drawService.findByDrawAndDrawDate(entity.getNumbers(), entity.getDrawDate());

        if (!result.isPresent()) {
            drawService.save(entity);
        }
    }
}
