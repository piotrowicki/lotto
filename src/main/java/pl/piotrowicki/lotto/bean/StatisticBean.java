package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class StatisticBean implements Serializable {
    
    private String mode;
    
    @Inject
    private DrawService drawService;
    
    @PostConstruct
    public void init() {
        mode = "TEST";
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
