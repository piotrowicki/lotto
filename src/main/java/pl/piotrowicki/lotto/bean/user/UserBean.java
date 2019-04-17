
package pl.piotrowicki.lotto.bean.user;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.service.user.UserService;

/**
 *
 * @author nowik
 */
@Named
@RequestScoped
public class UserBean {
    
    private List<UserDto> users;
    
    @Inject
    private UserService userService;
    
    @PostConstruct
    public void init() {
        users = userService.findAll();
    }

    public List<UserDto> getUsers() {
        return users;
    }
 
}
