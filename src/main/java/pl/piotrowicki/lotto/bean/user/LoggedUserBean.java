package pl.piotrowicki.lotto.bean.user;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import pl.piotrowicki.lotto.dto.user.UserDto;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Named
@SessionScoped
public class LoggedUserBean implements Serializable {

    private static final long serialVersionUID = 3448553453688248850L;

    private UserDto user;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
