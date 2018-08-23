package pl.piotrowicki.lotto.service;

import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author Nowik
 */
public abstract class Statistic {
    
    protected final BarChartModel doCalculate(List<DrawEntity> draws) {
        Map<Integer, Long> statistic = calculateStats(draws);
        return configureStats(statistic);
    }
    
    protected abstract Map<Integer, Long> calculateStats(List<DrawEntity> draws);
    
    protected abstract BarChartModel configureStats(Map<Integer, Long> statistic);  
}
