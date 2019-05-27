package pl.piotrowicki.lotto.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.enums.DrawType;
import pl.piotrowicki.lotto.service.StatisticService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class StatisticBean {

    private String latestResult;
    private DrawType drawType;
    private BarChartModel barChartModel;

    @Inject
    private StatisticService statisticService;

    @PostConstruct
    public void init() {
        barChartModel = statisticService.generateChart(DrawType.DUZY_LOTEK);
        latestResult = statisticService.getLatestResult();
    }
    
    public void changeDrawType() {
        barChartModel = statisticService.generateChart(drawType);
    }
    
    public DrawType[] getDrawTypes() {
        return DrawType.values();
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public String getLatestResult() {
        return latestResult;
    }

    public DrawType getDrawType() {
        return drawType;
    }

    public void setDrawType(DrawType drawType) {
        this.drawType = drawType;
    }
}
