package pl.piotrowicki.lotto.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.enums.StatisticOption;
import pl.piotrowicki.lotto.service.StatisticService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class BarChartBean {

    private BarChartModel barChartModel;

    private String latestResult;

    @Inject
    private StatisticService statisticService;

    @PostConstruct
    public void init() {
        barChartModel = statisticService.process(StatisticOption.MODE);
        latestResult = statisticService.getLatestResult();
    }

    public void handleChange(ValueChangeEvent event) {
        StatisticOption option = StatisticOption.valueOf(event.getNewValue().toString());
        if (option == StatisticOption.AVG) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        barChartModel = statisticService.process(option);
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
}
