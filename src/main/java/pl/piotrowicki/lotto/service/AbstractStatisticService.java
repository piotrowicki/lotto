package pl.piotrowicki.lotto.service;

import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author Nowik
 */
public abstract class AbstractStatisticService {
    
    protected abstract Map<Integer, Long> calculate(List<DrawEntity> draws);
    
    protected abstract BarChartModel configure(Map<Integer, Long> statistic);  
}
