package pl.piotrowicki.lotto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Ignore
public class BaseDaoTest {

    private static EntityManagerFactory emf;
    protected EntityManager em;

    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("lotto-test");
    }
    
    @Before
    public void init() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    @After
    public void rollback() {
        em.getTransaction().rollback();
        em.close();
    }
}
