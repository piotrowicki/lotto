package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class LineChartBean implements Serializable {

    private LineChartModel model;

    @PostConstruct
    public void init() {
        model = initLinearModel();
        model.setTitle("Line Chart");
        model.setAnimate(true);
        model.setLegendPosition("se");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public LineChartModel getModel() {
        return model;
    }

    public void setModel(LineChartModel model) {
        this.model = model;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series = new LineChartSeries();
        series.setLabel("Series 1");

        series.set(1, 2);
        series.set(2, 1);
        series.set(3, 3);
        series.set(4, 6);
        series.set(5, 8);
        
        model.addSeries(series);
        
        return model;
    }
}
