package pl.piotrowicki.lotto.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -5170288537131044056L;
   
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Embedded
    private Address address;
    
    @Column(name = "LAST_LOGON")
    private LocalDateTime lastLogon;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoleEntity> roles;

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

    public LocalDateTime getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(LocalDateTime lastLogon) {
        this.lastLogon = lastLogon;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
