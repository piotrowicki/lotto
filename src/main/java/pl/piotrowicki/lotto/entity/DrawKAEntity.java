package pl.piotrowicki.lotto.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nowik
 */
@Entity
@Table(name = "DRAW_KA")
@NamedQueries({
    @NamedQuery(
            name = "DrawKAEntity.findAll",
            query = "SELECT d FROM DrawKAEntity d ORDER BY d.drawDate desc"),
    @NamedQuery(
            name = "DrawKAEntity.findByDrawAndDrawDate",
            query = "SELECT d FROM DrawKAEntity d WHERE d.numbers = :numbers AND d.drawDate = :drawDate")
})
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "DrawDTO.findAllKA",
            query = "SELECT "
                    + " d.id as id," 
                    + " d.numbers as numbers," 
                    + " d.draw_date as drawDate" 
                    + " FROM DRAW_KA d ORDER BY d.draw_date desc",
            resultSetMapping = "DrawDTOMapping"
    )
})
public class DrawKAEntity extends BaseDrawEntity {
    
    private static final long serialVersionUID = 7611069553792619336L;
      
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrawELEntity that = (DrawELEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
