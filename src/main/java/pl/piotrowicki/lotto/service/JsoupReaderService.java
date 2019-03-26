package pl.piotrowicki.lotto.service;

import java.io.IOException;
import java.io.Serializable;
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

    private static final String LOTTO_URL = "http://app.lotto.pl/wyniki/?type=dl";

    public String read() {
        try {
            return Jsoup.connect(LOTTO_URL).get().text();
        } catch (IOException ex) {
            LOG.info("ReadDrawJob couldn't connect to API {0}", ex.getCause());
        }
        return null;
    }
}
