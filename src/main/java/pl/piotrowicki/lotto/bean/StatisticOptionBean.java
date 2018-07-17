package pl.piotrowicki.lotto.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import pl.piotrowicki.lotto.enums.StatisticOption;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@ApplicationScoped
public class StatisticOptionBean {
    public StatisticOption[] getStatisticOptions() {
        return StatisticOption.values();
    }
}
