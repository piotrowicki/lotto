package pl.piotrowicki.lotto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity extends BaseEntity {

    private static final long serialVersionUID = -4783666319759511245L;
    
    @Column(name = "ROLE_NAME")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
