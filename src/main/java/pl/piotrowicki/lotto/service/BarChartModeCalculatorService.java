package pl.piotrowicki.lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.util.DrawConverterUtil;
import pl.piotrowicki.lotto.util.StatisticUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public final class BarChartModeCalculatorService implements BaseCalculatorService {

    private static final String TITLE = "MODE STATISTIC";
    
    private BarChartModel barChartModel = new BarChartModel();
    private List<Draw> draws = new ArrayList<>();

    public BarChartModeCalculatorService(List<Draw> draws) {
        this.draws = draws;
    }
    
    @Override
    public void configuration() {
        barChartModel.setTitle(TITLE);
        barChartModel.setShowPointLabels(true);
        barChartModel.setShowDatatip(false);
        barChartModel.setAnimate(true);
        
        Axis axisY = barChartModel.getAxis(AxisType.Y);
        axisY.setTickFormat("%d");
        axisY.setTickInterval("1");
        axisY.setMin(0);
        axisY.setMax(StatisticUtil.calculateAxisYSizeWithAdditionalSpace(calculate(), 1));
        
        barChartModel.getAxes().put(AxisType.Y, axisY);
    }

    @Override
    public Map<Integer, Long> calculate() {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);

        return allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );
    }

    @Override
    public BarChartModel setSeries(Map<Integer, Long> numbersMode) {
        ChartSeries chartSeries = new ChartSeries();
        numbersMode.forEach(chartSeries::set);

        barChartModel.addSeries(chartSeries);
        return barChartModel;
    }
}
