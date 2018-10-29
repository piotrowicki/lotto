package pl.piotrowicki.lotto.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class BaseDao<T, PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = -5059287681052464835L;
    
    @PersistenceContext
    private EntityManager em;
    
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }
    
    public T merge(T entity) {
        return em.merge(entity);
    }
    
    public void remove(T entity) {
        em.remove(entity);
    }
    
    public T findById(Class<T> clazz, PK id) {
        return em.find(clazz, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
