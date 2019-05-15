package pl.piotrowicki.lotto.dao.user;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import pl.piotrowicki.lotto.dao.BaseDao;
import pl.piotrowicki.lotto.entity.DrawEPEntity;

/**
 *
 * @author nowik
 */
@Stateless
public class DrawEPDao extends BaseDao<DrawEPEntity, Long> {
    public List<DrawEPEntity> findAll() {
        return getEm().createNamedQuery("DrawEPEntity.findAll").getResultList();
    }

    public DrawEPEntity findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return (DrawEPEntity) getEm().createNamedQuery("DrawEPEntity.findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    } 
}
