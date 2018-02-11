package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.enums.CalculatorOption;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService implements Serializable {

    @Inject
    private DrawService drawService;

    public BarChartModel process(CalculatorOption option) {
        List<Draw> draws = drawService.findAll();
        CalculationStrategyService strategy = null;

        switch (option) {
            case MODE:
                strategy = new CalculationStrategyService(new ModeStrategyCalculation(), new ModeStrategyConfiguration());
                break;
            default:
                throw new IllegalStateException("Not valid value: " + option);
        }

        Map<Integer, Long> statistic = strategy.doCalculate(draws);
        return strategy.doConfiguration(statistic);
    }
}
