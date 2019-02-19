package pl.piotrowicki.lotto.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "ROLE")
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = -4783666319759511245L;
    
    @Column(name = "ROLE_NAME")
    private String roleName;
    
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
