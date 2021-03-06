package pl.piotrowicki.lotto.service.user;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pl.piotrowicki.lotto.dao.user.UserDao;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.entity.user.UserEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class UserService {

    @Inject
    private UserDao userDao;

    public UserDto getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public UserEntity findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public void save(UserEntity user) {
        userDao.save(user);
    }

    public List<UserDto> findAll() {
        return userDao.findAll();
    }

    public void updatePassword(Long id, String password) {
        userDao.updatePassword(id, password);
    }
}
