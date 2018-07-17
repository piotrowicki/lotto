package pl.piotrowicki.lotto.service;

import pl.piotrowicki.lotto.enums.StatisticOption;

/**
 *
 * @author Nowik
 */
public class StatisticFactory {

    public static AbstractStatisticService getStatisticFromOption(StatisticOption option) {
        switch (option) {
            case MODE:
                return new ModeStatisticService();
            case PERCENTAGE:
                return new PercentageStatisticService();
            default:
                throw new IllegalStateException("Not valid value: " + option);
        }
    }
}
