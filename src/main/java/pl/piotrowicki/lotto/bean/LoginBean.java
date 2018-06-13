package pl.piotrowicki.lotto.bean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.piotrowicki.lotto.service.LoginService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@RequestScoped
public class LoginBean implements Serializable {

    @Inject
    private LoginService loginService;

    public String login(String username, String password) {
        return loginService.login(username, password);
    }
}
