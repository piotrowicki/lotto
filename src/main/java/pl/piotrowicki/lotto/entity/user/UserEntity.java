package pl.piotrowicki.lotto.entity.user;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.entity.BaseEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USERS")
@SqlResultSetMapping(
        name = "UserDTOMapping",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "username", type = String.class),
                    @ColumnResult(name = "email", type = String.class),
                    @ColumnResult(name = "city", type = String.class),
                    @ColumnResult(name = "lastLogin", type = LocalDateTime.class),
                    @ColumnResult(name = "role", type = String.class)
                }
        )
)
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "UserDTO.findAll",
            query = "SELECT DISTINCT"
                    + " u.id as id," 
                    + " u.username as username," 
                    + " u.email as email," 
                    + " u.city as city," 
                    + " u.last_login as lastLogin," 
                    + " (select GROUP_CONCAT(ur.role_name SEPARATOR ', ') from USER_ROLES ur) as role" 
                    + " FROM USERS u, USER_ROLES ur",
            resultSetMapping = "UserDTOMapping"
    )
})
public class UserEntity extends BaseEntity {

    @Transient
    private static final long serialVersionUID = -5170288537131044056L;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Embedded
    private Address address;

    @Column(name = "LAST_LOGIN")
    private LocalDateTime lastLogin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return this.username.equals(userEntity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }
}
