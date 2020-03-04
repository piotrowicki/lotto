package pl.piotrowicki.lotto.entity.user;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import pl.piotrowicki.lotto.entity.BaseEntity;
import pl.piotrowicki.lotto.enums.UserRole;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoleEntity extends BaseEntity {

    private static final long serialVersionUID = -4783666319759511245L;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    private UserRole roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRole roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRoleEntity)) {
            return false;
        }
        UserRoleEntity userRolesEntity = (UserRoleEntity) o;
        return this.username.equals(userRolesEntity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }
}
