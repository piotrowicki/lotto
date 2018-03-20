package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class LoginService implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(LoginService.class.getName());

    public String login(String username, String password) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(username, password);
            return "/menu/statistics";
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed:", "Login or password incorrect please try again."));
            LOGGER.log(Level.INFO, MessageFormat.format("Login failed for user {0} with password {1}.", username, password));
        }
        return null;
    }

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
