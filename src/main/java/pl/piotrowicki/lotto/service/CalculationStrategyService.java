package pl.piotrowicki.lotto.service;

import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class CalculationStrategyService {

    private CalculationStrategy calcStrategy;
    private ConfigurationStrategy configStrategy;

    public CalculationStrategyService(CalculationStrategy calcStrategy, ConfigurationStrategy configStrategy) {
        this.calcStrategy = calcStrategy;
        this.configStrategy = configStrategy;
    }

    public Map<Integer, Long> doCalculate(List<Draw> draws) {
        return calcStrategy.calculate(draws);
    }   

    public BarChartModel doConfiguration(Map<Integer, Long> statistic) {
        return configStrategy.configureModel(statistic);
    }
}
