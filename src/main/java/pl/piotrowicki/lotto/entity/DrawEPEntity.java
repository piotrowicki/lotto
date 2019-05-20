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
@Table(name = "DRAWS_EP")
@NamedQueries({
    @NamedQuery(
            name = "DrawEPEntity.findAll",
            query = "SELECT d FROM DrawEPEntity d ORDER BY d.drawDate desc"),
    @NamedQuery(
            name = "DrawEPEntity.findByDrawAndDrawDate",
            query = "SELECT d FROM DrawEPEntity d WHERE d.numbers = :numbers AND d.drawDate = :drawDate")
})
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "DrawDTO.findAllEP",
            query = "SELECT "
                    + " d.id as id," 
                    + " d.numbers as numbers," 
                    + " d.draw_date as drawDate" 
                    + " FROM DRAWS_EP d ORDER BY d.draw_date desc",
            resultSetMapping = "DrawDTOMapping"
    )
})
public class DrawEPEntity extends BaseDrawEntity {
    
    private static final long serialVersionUID = 7611069553792619336L;
      
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrawEPEntity that = (DrawEPEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 37;
    }
    
}
