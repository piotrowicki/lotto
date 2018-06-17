package pl.piotrowicki.lotto.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "DRAW")
@NamedQueries({
    @NamedQuery(name = "Draw.findAll",
            query = "SELECT d FROM Draw d ORDER BY d.drawDate desc"),
    @NamedQuery(name = "Draw.findByDrawAndDrawDate",
            query = "SELECT d FROM Draw d WHERE d.numbers = :numbers AND d.drawDate = :drawDate")
})
public class Draw implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Integer id;
    
    @Column(name = "NUMBERS")
    private String numbers;
    
    @Column(name = "DRAW_DATE", columnDefinition = "DATE")
    private LocalDate drawDate;
    
    @Column(name = "CREATE_DATE", columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime createDate;
    
    @Column(name = "UPDATE_DATE", columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime updateDate;

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

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
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
