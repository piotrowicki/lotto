package pl.piotrowicki.lotto.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.util.DrawConverterUtil;
import pl.piotrowicki.lotto.util.StatisticUtil;

/**
 *
 * @author Nowik
 */
public class ModeStatisticService extends AbstractStatisticService {
    
    private static final String TITLE = "MODE STATISTIC";

    @Override
    protected Map<Integer, Long> calculate(List<DrawEntity> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);
        return allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );
    }

    @Override
    protected BarChartModel configure(Map<Integer, Long> statistic) {
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
