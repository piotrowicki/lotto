package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.enums.StatisticOption;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class StatisticService implements Serializable {

    @Inject
    private DrawService drawService;

    private List<DrawEntity> draws;
    
    @PostConstruct
    private void init() {
        draws = drawService.findAll();
    }
    
    public BarChartModel process(StatisticOption option) {
        Statistic statistic = StatisticFactory.getStatisticFromOption(option);
        return statistic.doCalculate(draws);
    }

    public String getLatestResult() {
        Optional<DrawEntity> max = draws.stream().max(Comparator.comparing(DrawEntity::getCreateDate));    
        return max.isPresent() ? max.get().getNumbers() + " " + max.get().getCreateDate() : "";
    }
}
