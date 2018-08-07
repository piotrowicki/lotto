package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Nowik
 */
@Named
@RequestScoped
public class LuckyNumbersBean implements Serializable {
    
    private List<Integer> luckyNumbers;

    public void calculateStatistic() {
        if (luckyNumbers.isEmpty())  {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Insert your favorite numbers.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        System.out.println(luckyNumbers);
    }

    public List<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }

    public void setLuckyNumbers(List<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }
}
