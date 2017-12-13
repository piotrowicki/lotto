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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "DRAW")
@NamedQueries({
    @NamedQuery(name = "Draw.findAll",
            query = "SELECT n FROM Draw n")
})
public class Draw implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NUMBERS")
    private String numbers;
    
    @Column(name = "DRAW_DATE")
    private Date drawDate;
    
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

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @PrePersist
    public void setCreateDate() {
        this.createDate = new Date();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numbers, drawDate, createDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        
        if (!(obj instanceof Draw)) {
            return false;
        }
        Draw number = (Draw) obj;
        return id == number.id &&
                Objects.equals(numbers, number.numbers) &&
                Objects.equals(drawDate, number.drawDate) &&
                Objects.equals(createDate, number.createDate);
    }

    @Override
    public String toString() {
        return "Draw{" + "id=" + id + ", numbers=" + numbers + ", drawDate=" + drawDate + ", createDate=" + createDate + '}';
    }
}
