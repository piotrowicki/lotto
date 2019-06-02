package pl.piotrowicki.lotto.dao;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao extends BaseDao {

    @PersistenceContext
    private EntityManager em;
    
    public <T extends BaseDrawEntity> List<T> findAll(Class<T> aClass) {
        return em.createNamedQuery(aClass.getSimpleName() + ".findAll").getResultList();
    }

    public <T extends BaseDrawEntity> T findByDrawAndDrawDate(Class<T> aClass, String numbers, LocalDate drawDate) {
        return (T) em.createNamedQuery(aClass.getSimpleName() + ".findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
    
    /**
     * For testing purposes only
     * @param em - EntityManager
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
