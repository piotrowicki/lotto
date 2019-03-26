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

    private static final long serialVersionUID = -6014382080713253271L;
    
    public StatisticOption[] getStatisticOptions() {
        return StatisticOption.values();
    }
}
