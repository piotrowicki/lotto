package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.service.StatisticService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class BarChartBean implements Serializable {

    private BarChartModel barChartModel;
    
    @Inject
    private StatisticService statisticService;

    @PostConstruct
    public void init() {
        barChartModel = statisticService.process();
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }
}
