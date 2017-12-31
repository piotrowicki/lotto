package pl.piotrowicki.lotto.util;

import java.time.LocalDate;
import java.util.logging.Logger;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawConverterUtil {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());

    public static Draw convertToEntity(String input) {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        Draw entity = new Draw();
        entity.setDrawDate(LocalDate.parse(splittedDraw[0]));
        entity.setNumbers(input.substring(firstSpace));
        return entity;
    }
}
