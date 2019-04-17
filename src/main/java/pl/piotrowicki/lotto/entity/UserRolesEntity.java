package pl.piotrowicki.lotto.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import pl.piotrowicki.lotto.enums.UserRole;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRolesEntity extends BaseEntity {

    private static final long serialVersionUID = -4783666319759511245L;

    @NaturalId
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
        if (!(o instanceof UserRolesEntity)) {
            return false;
        }
        UserRolesEntity userRolesEntity = (UserRolesEntity) o;
        return this.username.equals(userRolesEntity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }
}
