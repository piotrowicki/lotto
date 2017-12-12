package pl.piotrowicki.lotto.job;

import java.io.Serializable;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Singleton
public class ReadDrawJob implements Serializable {
    
    @Schedule(hour = "0", minute = "0", persistent = false)
    public void run() {
        
    }
    
}
