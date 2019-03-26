package pl.piotrowicki.lotto.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao extends BaseDao<DrawEntity, Long> {

    public List<DrawEntity> findAll() {
        return getEm().createNamedQuery("DrawEntity.findAll").getResultList();
    }

    public Optional<DrawEntity> findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return getEm().createNamedQuery("DrawEntity.findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst();
    }

    /**
     * For testing purposes only
     * @param em - EntityManager
     */
    public void setEntityManager(EntityManager em) {
        setEm(em);
    }
}
