package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@ConversationScoped
public class DrawTableBean implements Serializable {
    
    private List<DrawEntity> draws;
    
    @Inject
    private DrawService drawService;
    
    @PostConstruct
    public void init() {
        draws = drawService.findAll();
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<DrawEntity> getDraws() {
        return draws;
    }

    public void setDraws(List<DrawEntity> draws) {
        this.draws = draws;
    }
}
