package pl.piotrowicki.lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pl.piotrowicki.lotto.entity.BaseDrawEntity;
import pl.piotrowicki.lotto.entity.DrawELEntity;
import pl.piotrowicki.lotto.entity.DrawEPEntity;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.entity.DrawKAEntity;
import pl.piotrowicki.lotto.entity.DrawMMEntity;
import pl.piotrowicki.lotto.enums.DrawType;
import pl.piotrowicki.lotto.util.DrawConverterUtil;
import pl.piotrowicki.lotto.util.StatisticUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService<T extends BaseDrawEntity> {

    @Inject
    private DrawService drawService;

    private final Map<DrawType, Class<T>> mapper = new HashMap<>();
    
    @PostConstruct
    private void init() {
        mapper.put(DrawType.KASKADA, (Class<T>) DrawKAEntity.class);
        mapper.put(DrawType.MULTI_MULTI, (Class<T>) DrawMMEntity.class);
        mapper.put(DrawType.DUZY_LOTEK, (Class<T>) DrawEntity.class);
        mapper.put(DrawType.EKSTRA_PENSJA, (Class<T>) DrawEPEntity.class);
        mapper.put(DrawType.MINI_LOTTO, (Class<T>) DrawELEntity.class);
    }

    public BarChartModel generateChart(DrawType type) {
        List<T> draws = drawService.findAll(getClass(type));
        return generateBarChart(draws, type);
    }
    
    public <T extends BaseDrawEntity> BarChartModel generateBarChart(List<T> data, DrawType type) {
        Map<Integer, Long> stats = calculateStats(data);
        return configure(stats, type);      
    }
    
     protected <T extends BaseDrawEntity> Map<Integer, Long> calculateStats(List<T> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);
        return allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );
    }
     
    private BarChartModel configure(Map<Integer, Long> statistic, DrawType type) {
        BarChartModel model = new BarChartModel();
        ChartSeries chartSeries = new ChartSeries();
        model.setTitle(type.getDescription());
        model.setShowPointLabels(true);
        model.setShowDatatip(false);
        model.setAnimate(true);

        Axis axisY = model.getAxis(AxisType.Y);
        axisY.setTickFormat("%d");
        axisY.setTickInterval(String.valueOf(StatisticUtil.calculateAxisYTickInterval(statistic)));
        axisY.setMin(0);
        axisY.setMax(StatisticUtil.calculateAxisYSizeWithAdditionalSpace(statistic, 2));

        model.getAxes().put(AxisType.Y, axisY);

        statistic.forEach(chartSeries::set);
        model.addSeries(chartSeries);
        return model;
    }

    public String getLatestResult() {
      //  Optional<DrawEntity> max = draws.stream().max(Comparator.comparing(DrawEntity::getCreateDate));
      // return max.isPresent() ? max.get().getNumbers() + " " + max.get().getCreateDate() : "";
      return null;
    }

    private Class<T> getClass(DrawType type) {
        return mapper.get(type);
    }
}
