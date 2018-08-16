package pl.piotrowicki.lotto.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
       
    public List<DrawEntity> findAll() {
        return em.createNamedQuery("DrawEntity.findAll").getResultList();
    }

    public void save(DrawEntity entity) {
        em.persist(entity);
    }

    public Optional<DrawEntity> findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return em.createNamedQuery("DrawEntity.findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst();
    }

    /**
     * For testing purposes only
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
