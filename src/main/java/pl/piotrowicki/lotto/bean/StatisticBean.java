package pl.piotrowicki.lotto.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.charts.bar.BarChartModel;
import pl.piotrowicki.lotto.enums.DrawType;
import pl.piotrowicki.lotto.service.draw.StatisticService;

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

    public void changeDrawType() {
        barChartModel = statisticService.generateChart(drawType);
        latestResult = statisticService.getLatestResult();
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
