
package pl.piotrowicki.lotto.bean.user;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.service.user.LoginService;
import pl.piotrowicki.lotto.service.user.UserService;

/**
 *
 * @author nowik
 */
@Named
@RequestScoped
public class UserBean {
    
    private List<UserDto> users;
    private Long userId;
    private String password;
    
    @Inject
    private UserService userService;
    
    @Inject
    private LoginService loginService;
    
    @PostConstruct
    public void init() {
        users = userService.findAll();
    }
    
    public String login(String username, String password) {
        return loginService.login(username, password);
    }

    public String logout() {
        return loginService.logout();
    }
    
    public void updatePassword(Long id, String password) {     
        userService.updatePassword(id, password);
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
