package pl.piotrowicki.lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

/**
 *
 * @author Nowik
 */
public class PercentageStatistic extends Statistic {
    
     private static final String TITLE = "PERCENTAGE STATISTIC";

    @Override
    protected Map<Integer, Long> calculateStats(List<DrawEntity> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);

        Map<Integer, Long> collect = allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );

        collect.entrySet().forEach((entry) -> {
            BigDecimal currentNumberQuntity = BigDecimal.valueOf(entry.getValue());
            BigDecimal howMAnyNumbers = BigDecimal.valueOf(allNumbers.size());

            long result = currentNumberQuntity
                    .multiply(BigDecimal.valueOf(100))
                    .divide(howMAnyNumbers, RoundingMode.HALF_EVEN)
                    .longValue();

            entry.setValue(result);
         });

        return collect;
    }

    @Override
    protected BarChartModel configureStats(Map<Integer, Long> statistic) {
        BarChartModel model = new BarChartModel();
        ChartSeries chartSeries = new ChartSeries();
        model.setTitle(TITLE);
        model.setShowPointLabels(true);
        model.setShowDatatip(false);
        model.setAnimate(true);

        Axis axisY = model.getAxis(AxisType.Y);
        axisY.setTickFormat("%d");
        axisY.setTickInterval("20");
        axisY.setMin(0);
        axisY.setMax(100);

        model.getAxes().put(AxisType.Y, axisY);

        statistic.forEach(chartSeries::set);
        model.addSeries(chartSeries);
        return model;
    }
}
