package pl.piotrowicki.lotto.service;

import java.util.Map;
import org.primefaces.model.chart.BarChartModel;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public interface BaseCalculatorService {

    /**
     * Should be implemented and invoked in class constructor 
     */
    void configuration();

    BarChartModel setSeries(Map<Integer, Long> allNumbers);

    Map<Integer, Long> calculate();
}
