package pl.piotrowicki.lotto.service;

import pl.piotrowicki.lotto.enums.StatisticOption;

/**
 *
 * @author Nowik
 */
public class StatisticFactory {

    public static Statistic getStatisticFromOption(StatisticOption option) {
        switch (option) {
            case MODE:
                return new ModeStatistic();
            case PERCENTAGE:
                return new PercentageStatistic();
            default:
                throw new IllegalStateException("Not valid value: " + option);
        }
    }
}
