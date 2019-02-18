package pl.piotrowicki.lotto.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -5170288537131044056L;
   
    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Embedded
    private Address address;
    
    @Column(name = "LAST_LOGON")
    private LocalDateTime lastLogon;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserRoleEntity role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }
}