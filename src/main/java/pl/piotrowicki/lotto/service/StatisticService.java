package pl.piotrowicki.lotto.service;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;
import pl.piotrowicki.lotto.enums.DrawType;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService<T extends BaseDrawEntity> {

    @Inject
    private DrawService drawService;

    private List<T> draws = new ArrayList<>();

    public BarChartModel generateChart(DrawType type) {
        draws = drawService.findAll(drawService.getClass(type));
        return generateBarChart(draws, type);
    }

    public BarChartModel generateBarChart(List<T> data, DrawType type) {
        Map<Integer, Long> stats = calculateStats(data);
        return configure(stats, type);
    }

    protected Map<Integer, Long> calculateStats(List<T> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);
        return allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );
    }

    private BarChartModel configure(Map<Integer, Long> statistic, DrawType type) {
        BarChartModel barModel = new BarChartModel();
        ChartData data = new ChartData();
        
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel(type.getDescription());
        barDataSet.setData(Lists.newArrayList(statistic.values()));
        barDataSet.setBackgroundColor("rgba(54, 162, 235, 0.2)");
        barDataSet.setBorderColor("rgb(54, 162, 235)");
        barDataSet.setBorderWidth(1);
     
        data.addChartDataSet(barDataSet);
         
        List<String> labels = new ArrayList<>();
        statistic.keySet().forEach((integer) -> {
            labels.add(String.valueOf(integer));
        });
        data.setLabels(labels);
        barModel.setData(data);
        
        // Options:
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
        
        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("bottom");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
        
        barModel.setOptions(options);
      
        return barModel;
    }

    public String getLatestResult() {
        Optional<T> latestResult = (Optional<T>) getLatestResult(draws);
        return latestResult.isPresent() ? latestResult.get().getNumbers() + " " + latestResult.get().getCreateDate() : "";
    }

    private Optional<T> getLatestResult(List<T> draws) {
        return draws.stream().max(Comparator.comparing(T::getDrawDate));
    }
}
