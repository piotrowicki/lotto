package pl.piotrowicki.lotto.service;

import java.io.IOException;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class JsoupReaderService {

    private static final Logger LOG = Logger.getLogger(JsoupReaderService.class);

    public String read(String url) {
        try {
            return Jsoup.connect(url).get().text();
        } catch (IOException ex) {
            LOG.info("ReadDrawJob couldn't connect to API {0}", ex.getCause());
        }
        return null;
    }
}
