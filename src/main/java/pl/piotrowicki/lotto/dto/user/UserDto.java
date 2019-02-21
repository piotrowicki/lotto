package pl.piotrowicki.lotto.dto.user;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String city;
    private LocalDateTime lastLogon;

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
    
    public LocalDateTime getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(LocalDateTime lastLogon) {
        this.lastLogon = lastLogon;
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
                && Objects.equals(this.lastLogon, userDto.lastLogon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.email, this.lastLogon);
    }
}
