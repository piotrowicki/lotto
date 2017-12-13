package pl.piotrowicki.lotto.dao;

import java.io.Serializable;
import java.util.List;
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
}
