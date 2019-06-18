package pl.piotrowicki.lotto.bean.user;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import pl.piotrowicki.lotto.dto.user.UserDto;

/**
 *
 * @author nowik
 */
@Named
@SessionScoped
public class UserSettingsBean implements Serializable {

    private static final long serialVersionUID = -1375813888201627968L;

    private boolean cookieModalVisible = true;
    
    private Locale locale;
    private UserDto loggedUser;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public String changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }
    
    public UserDto getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserDto loggedUser) {
        this.loggedUser = loggedUser;
    }
   
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public boolean isCookieModalVisible() {
        return cookieModalVisible;
    }

    public void setCookieModalVisible(boolean cookieModalVisible) {
        this.cookieModalVisible = cookieModalVisible;
    }
}
