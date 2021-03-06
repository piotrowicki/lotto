package pl.piotrowicki.lotto.dto.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = 5002729881930837058L;

    private Long id;
    private String username;
    private String email;
    private String city;
    private LocalDateTime lastLogin;
    private String roles;
    
    public UserDto() {}

    public UserDto(Long id, String username, String email, String city, LocalDateTime lastLogin, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.city = city;
        this.lastLogin = lastLogin;
        this.roles = roles;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRole() {
        return roles;
    }

    public void setRole(String role) {
        this.roles = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(this.username, userDto.username)
                && Objects.equals(this.email, userDto.email)
                && Objects.equals(this.lastLogin, userDto.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.email, this.lastLogin);
    }
}
