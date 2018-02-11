package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import pl.piotrowicki.lotto.enums.CalculatorOption;
import pl.piotrowicki.lotto.service.StatisticService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class BarChartBean implements Serializable {

    private BarChartModel barChartModel;

    @Inject
    private StatisticService statisticService;

    @PostConstruct
    public void init() {
        barChartModel = statisticService.process(CalculatorOption.MODE);
    }

    public void handleChange(ValueChangeEvent event) {
        CalculatorOption calculatorOption = CalculatorOption.valueOf(event.getNewValue().toString());
        if (calculatorOption == CalculatorOption.AVG) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        barChartModel = statisticService.process(calculatorOption);
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }
}
