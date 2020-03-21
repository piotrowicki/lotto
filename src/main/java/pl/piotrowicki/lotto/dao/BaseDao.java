package pl.piotrowicki.lotto.dao;

import javax.persistence.EntityManager;
import pl.piotrowicki.lotto.entity.BaseEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public abstract class BaseDao<T extends BaseEntity, Long> {

    public T save(T entity) {
        T result = null;
        if (entity != null) {
            if (entity.getId() == null) {
                getEM().persist(entity);
                result = entity;
            } else {
                result = getEM().merge(entity);
            }
        }
        return result;
    }
    
    public void save(T... entites) {
        for (T entity : entites) {
            if (entity != null) {
                if (entity.getId() == null) {
                    getEM().persist(entity);
                } else {
                    getEM().merge(entity);
                }
            }
        }
    }
    
    public void remove(T entity) {
        getEM().remove(entity);
    }
    
    public T findById(Class<T> clazz, Long id) {
        return getEM().find(clazz, id);
    }

    protected abstract EntityManager getEM();
}
