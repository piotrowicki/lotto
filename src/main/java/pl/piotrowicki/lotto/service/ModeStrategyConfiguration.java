package pl.piotrowicki.lotto.service;

import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pl.piotrowicki.lotto.util.StatisticUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class ModeStrategyConfiguration implements ConfigurationStrategy {
    
    private final String TITLE = "MODE STATISTIC";

    @Override
    public BarChartModel configureModel(Map<Integer, Long> statistic) {
        BarChartModel model = new BarChartModel();
        ChartSeries chartSeries = new ChartSeries();
        model.setTitle(TITLE);
        model.setShowPointLabels(true);
        model.setShowDatatip(false);
        model.setAnimate(true);

        Axis axisY = model.getAxis(AxisType.Y);
        axisY.setTickFormat("%d");
        axisY.setTickInterval("1");
        axisY.setMin(0);
        axisY.setMax(StatisticUtil.calculateAxisYSizeWithAdditionalSpace(statistic, 1));

        model.getAxes().put(AxisType.Y, axisY);

        statistic.forEach(chartSeries::set);
        model.addSeries(chartSeries);
        return model;
    }
}
