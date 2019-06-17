package pl.piotrowicki.lotto.entity.draw;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import pl.piotrowicki.lotto.dto.DrawDto;
import pl.piotrowicki.lotto.entity.BaseEntity;

/**
 *
 * @author nowik
 */
@MappedSuperclass
@SqlResultSetMapping(
        name = "DrawDTOMapping",
        classes = @ConstructorResult(
                targetClass = DrawDto.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "numbers", type = String.class),
                    @ColumnResult(name = "drawDate", type = LocalDate.class)
                }
        )
)
public class BaseDrawEntity extends BaseEntity {

    private static final long serialVersionUID = 1962826784522529622L;
    
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
}
