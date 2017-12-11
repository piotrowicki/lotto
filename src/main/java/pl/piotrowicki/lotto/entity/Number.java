package pl.piotrowicki.lotto.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "NUMBER")
@NamedQueries({
    @NamedQuery(name = "Number.findAll",
            query = "SELECT n FROM Number n")
})
public class Number implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "DRAW")
    private String draw;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", columnDefinition = "DATETIME")
    private Date createDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE", columnDefinition = "DATETIME")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, draw, createDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return id == number.id &&
                Objects.equals(draw, number.draw) &&
                Objects.equals(createDate, number.createDate);
    }

    @Override
    public String toString() {
        return "Number{" + "id=" + id + ", draw=" + draw + ", createDate=" + createDate + '}';
    }
}
