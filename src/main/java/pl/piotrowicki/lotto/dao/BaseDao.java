package pl.piotrowicki.lotto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.piotrowicki.lotto.entity.BaseEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class BaseDao<T extends BaseEntity, Long> {
    
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
    
    public T findById(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
