package pl.piotrowicki.lotto.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;
import pl.piotrowicki.lotto.entity.draw.DrawEntity;
import pl.piotrowicki.lotto.enums.DrawType;
import pl.piotrowicki.lotto.service.draw.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class DrawTableBean {
    
    @Inject
    private DrawService drawService;
    
    private List<? extends BaseDrawEntity> draws = new ArrayList<>();
    private DrawType drawType;
    
    @PostConstruct
    public void init() {
        draws = drawService.findAll(DrawEntity.class);
    }
    
    public <T extends BaseDrawEntity> void changeDrawType() {
        Class<T> aClass = drawService.getClass(drawType);
        draws = drawService.findAll(aClass);
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Not supported yet.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<? extends BaseDrawEntity> getDraws() {
        return draws;
    }

    public void setDraws(List<? extends BaseDrawEntity> draws) {
        this.draws = draws;
    }

    public DrawType getDrawType() {
        return drawType;
    }

    public void setDrawType(DrawType drawType) {
        this.drawType = drawType;
    }
}
