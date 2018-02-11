package pl.piotrowicki.lotto.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import pl.piotrowicki.lotto.enums.CalculatorOption;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@ApplicationScoped
public class CalculatorOptionBean {
    public CalculatorOption[] getCalculatorOptions() {
        return CalculatorOption.values();
    }
}
