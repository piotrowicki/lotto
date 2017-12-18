package pl.piotrowicki.lotto.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Draw> findAll() {
        return em.createNamedQuery("Draw.findAll").getResultList();
    }

    public void save(Draw entity) {
        em.persist(entity);
    }

    public Optional<Draw> findByDrawAndDrawDate(String numbers, Date drawDate) {
        return em.createNamedQuery("Draw.findByDrawAndDrawDate")
                .setParameter("numbers", numbers)
                .setParameter("drawDate", drawDate)
                .getResultList()
                .stream()
                .findFirst();
    }
}
