package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService implements Serializable {

    private List<Draw> draws = new ArrayList<>();
    
    @Inject
    private DrawService drawService;
    
    @PostConstruct
    public void init() {
        draws = drawService.findAll();
    }
    
    public BarChartModel process() {
        BaseCalculatorService calculator = new BarChartModeCalculatorService(draws);
        calculator.configuration();
        Map<Integer, Long> calculatedStatistic = calculator.calculate();
        return calculator.setSeries(calculatedStatistic);       
    }
}
