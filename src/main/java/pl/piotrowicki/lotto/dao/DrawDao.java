package pl.piotrowicki.lotto.dao;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import pl.piotrowicki.lotto.entity.BaseDrawEntity;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao extends BaseDao<DrawEntity, Long> {

    public <T extends BaseDrawEntity> List<T> findAll(Class<T> aClass) {
        return getEm().createNamedQuery(aClass.getSimpleName() + ".findAll").getResultList();
    }

    public <T extends BaseDrawEntity> T findByDrawAndDrawDate(Class<T> aClass, String numbers, LocalDate drawDate) {
        return (T) getEm().createNamedQuery(aClass.getSimpleName() + ".findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    /**
     * For testing purposes only
     * @param em - EntityManager
     */
    public void setEntityManager(EntityManager em) {
        setEm(em);
    }
}
