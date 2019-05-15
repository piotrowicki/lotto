package pl.piotrowicki.lotto.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Entity
@Table(name = "DRAWS")
@NamedQueries({
    @NamedQuery(
            name = "DrawEntity.findAll",
            query = "SELECT d FROM DrawEntity d ORDER BY d.drawDate desc"),
    @NamedQuery(
            name = "DrawEntity.findByDrawAndDrawDate",
            query = "SELECT d FROM DrawEntity d WHERE d.numbers = :numbers AND d.drawDate = :drawDate")
})
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "DrawDTO.findAll",
            query = "SELECT "
                    + " d.id as id," 
                    + " d.numbers as numbers," 
                    + " d.draw_date as drawDate" 
                    + " FROM Draws d ORDER BY d.draw_date desc",
            resultSetMapping = "DrawDTOMapping"
    )
})
public class DrawEntity extends BaseEntity {

    private static final long serialVersionUID = 3850344349208488641L;

    @Column(name = "NUMBERS")
    private String numbers;

    @Column(name = "DRAW_DATE", columnDefinition = "DATE")
    private LocalDate drawDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrawEntity that = (DrawEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 37;
    }

    @Override
    public String toString() {
        return "Draw{" + "id=" + super.getId() + ", numbers=" + numbers + ", drawDate=" + drawDate + '}';
    }
}
