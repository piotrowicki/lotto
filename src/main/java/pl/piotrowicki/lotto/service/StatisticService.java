package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.enums.CalculatorOption;
import pl.piotrowicki.lotto.service.calculation.impl.ModeStrategyCalculation;
import pl.piotrowicki.lotto.service.calculation.impl.PercentageStrategyCalculation;
import pl.piotrowicki.lotto.service.configuration.impl.ModeStrategyConfiguration;
import pl.piotrowicki.lotto.service.configuration.impl.PercentageStrategyConfiguration;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService implements Serializable {

    @Inject
    private DrawService drawService;

    private List<Draw> draws = new ArrayList<>();

    public BarChartModel process(CalculatorOption option) {
        draws = drawService.findAll();
        CalculationStrategyService strategy = null;

        switch (option) {
            case MODE:
                strategy = new CalculationStrategyService(new ModeStrategyCalculation(), new ModeStrategyConfiguration());
                break;
            case PERCENTAGE:
                strategy = new CalculationStrategyService(new PercentageStrategyCalculation(), new PercentageStrategyConfiguration());
                break;
            default:
                throw new IllegalStateException("Not valid value: " + option);
        }

        Map<Integer, Long> statistic = strategy.doCalculate(draws);
        return strategy.doConfiguration(statistic);
    }

    public String getLatestResult() {
        Optional<Draw> max = draws.stream().max(Comparator.comparing(Draw::getCreateDate));
        
        return max.isPresent() ? max.get().getNumbers() + " " + max.get().getCreateDate() : "";
    }
}
