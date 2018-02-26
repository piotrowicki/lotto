package pl.piotrowicki.lotto.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Before;

/**
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class BaseDaoTest {

    protected EntityManager em;

    @Before
    public void init() {
        em = Persistence.createEntityManagerFactory("lotto-test").createEntityManager();
        em.getTransaction().begin();
    }
}
