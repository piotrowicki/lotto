package pl.piotrowicki.lotto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawConverterUtil {
    
    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
     public static Draw convertToEntity(String input) {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        Draw entity = new Draw();
        try {
            entity.setDrawDate(DATE_FORMAT.parse(splittedDraw[0]));
            entity.setNumbers(input.substring(firstSpace));
        } catch (ParseException ex) {
            LOGGER.log(Level.WARNING, "Date parsing FAIL {0}", ex);
        }
        return entity;
    }
}
