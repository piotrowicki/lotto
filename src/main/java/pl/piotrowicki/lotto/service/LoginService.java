package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.text.MessageFormat;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginService.class);

    public String login(String username, String password) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(username, password);
            return "/menu/statistics";
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed:", "Login or password incorrect please try again."));
            LOGGER.info(MessageFormat.format("Login failed for user {0} with password {1}.", username, password));
        }
        return null;
    }
}
