package pl.piotrowicki.lotto.service;

import java.util.Map;
import org.primefaces.model.chart.BarChartModel;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public interface ConfigurationStrategy {
    public BarChartModel configureModel(Map<Integer, Long> statistic); 
}
