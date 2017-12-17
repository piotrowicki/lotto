package pl.piotrowicki.lotto.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.jsoup.Jsoup;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class JsoupReader {
    
    private static final Logger LOGGER = Logger.getLogger(JsoupReader.class.getName());
    
    private static final String LOTTO_URL = "http://app.lotto.pl/wyniki/?type=dl";
    
    public String read() {
        try {
            return Jsoup.connect(LOTTO_URL).get().text();
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, "ReadDrawJob FAIL " + ex);
        }
        return null;
    }
}
