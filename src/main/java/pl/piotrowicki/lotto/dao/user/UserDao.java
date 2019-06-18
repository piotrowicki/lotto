package pl.piotrowicki.lotto.dao.user;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.transform.Transformers;
import pl.piotrowicki.lotto.dao.BaseDao;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.entity.user.UserEntity;
import pl.piotrowicki.lotto.util.MessageBuilder;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class UserDao extends BaseDao {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    
    @PersistenceContext
    private EntityManager em;

    public UserEntity findUserByUsername(String username) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);

        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.where(
                builder.equal(root.get("username"), username)
        );

        return em.createQuery(criteria).getSingleResult();
    }

    @SuppressWarnings("deprecation")
    public UserDto getUserByUsername(String username) {
        UserDto user = (UserDto) em.createQuery(
                "select "
                + "     u.id as id, "
                + "     u.username as username, "
                + "     u.email as email, "
                + "     u.address.city as city, "
                + "     u.lastLogon as lastLogon "
                + "from UserEntity u "
                + "where u.username like :username")
                .setParameter("username", username)
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(UserDto.class))
                .getSingleResult();
        return user;
    }

    public List<UserDto> findAll() {
        return em.createNamedQuery("UserDTO.findAll").getResultList();
    }

    public void updatePassword(Long id, String password) {      
        try {
            UserEntity user = (UserEntity) findById(UserEntity.class, id);
            user.setPassword(password);
            save(user);
            MessageBuilder.aFacesMessage()
                    .withSeverity(FacesMessage.SEVERITY_INFO)
                    .withTitle("INFO")
                    .withBundleMessage("common.updateSuccessful")
                    .add();
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
            MessageBuilder.aFacesMessage()
                    .withSeverity(FacesMessage.SEVERITY_ERROR)
                    .withMessage("Something went wrong.")
                    .add();
        }
    }

    @Override
    protected EntityManager getEM() {
        return em;
    }
}
