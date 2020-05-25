package pl.piotrowicki.lotto.service.user;

import java.time.LocalDateTime;
import java.util.function.Function;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.bean.user.UserSettingsBean;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.entity.user.UserEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginService.class);
    
    @Inject
    private UserService userService;
    
    @Inject
    private UserSettingsBean settings;

    @Inject
    private FacesContext facesContext;

    public String login(String username, String password) {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            request.login(username, password);
            
            UserEntity user = userService.findUserByUsername(username);
            user.setLastLogin(LocalDateTime.now());
            userService.save(user);
            
            UserDto userDto = mapUserToDto().apply(user);
            settings.setLoggedUser(userDto);
            
            return "/draws.xhtml?i=1&faces-redirect=true";
        } catch (ServletException ex) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed:", "Login or password incorrect please try again."));
        }
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
    
    private Function<UserEntity, UserDto> mapUserToDto() {
        return (UserEntity t) -> {
            UserDto dto = new UserDto();
            dto.setId(t.getId());
            dto.setUsername(t.getUsername());
            dto.setEmail(t.getEmail());
            dto.setCity(t.getAddress().getCity());
            dto.setLastLogin(t.getLastLogin());
            return dto;
        };
    }
}
