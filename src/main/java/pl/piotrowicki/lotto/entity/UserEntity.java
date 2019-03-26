package pl.piotrowicki.lotto.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -5170288537131044056L;

    @NaturalId
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Embedded
    private Address address;

    @Column(name = "LAST_LOGON")
    private LocalDateTime lastLogon;

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
