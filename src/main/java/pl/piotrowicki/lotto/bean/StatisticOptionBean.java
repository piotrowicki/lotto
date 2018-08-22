package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import pl.piotrowicki.lotto.enums.StatisticOption;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@ApplicationScoped
public class StatisticOptionBean implements Serializable {
    public StatisticOption[] getStatisticOptions() {
        return StatisticOption.values();
    }
}
