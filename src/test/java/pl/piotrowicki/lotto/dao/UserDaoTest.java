package pl.piotrowicki.lotto.dao;

import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Before;
import org.junit.Test;
import pl.piotrowicki.lotto.dao.user.UserDao;
import pl.piotrowicki.lotto.dto.user.UserDto;
import pl.piotrowicki.lotto.entity.user.UserEntity;
import pl.piotrowicki.lotto.entity.user.UserRoleEntity;
import pl.piotrowicki.lotto.enums.UserRole;

public class UserDaoTest extends BaseDaoTest {
    
    private static final String USER_1 = "USER1";
    
    private final UserDao dao = new UserDao();
    
    @Before
    public void setUp() {
        dao.setEntityManager(em);
    }
    
    @Test
    public void testUserRoleIsUniqueInResult() {
        // given
        UserEntity firstUser = new UserEntity();
        firstUser.setUsername(USER_1);
        
        UserRoleEntity firstRole = new UserRoleEntity();
        firstRole.setUsername(USER_1);
        firstRole.setRoleName(UserRole.ADMIN);
        
        UserEntity secondUser = new UserEntity();
        secondUser.setUsername(USER_1);
        
        UserRoleEntity secondRole = new UserRoleEntity();
        secondRole.setUsername(USER_1);
        secondRole.setRoleName(UserRole.USER);
        
        dao.save(firstUser, firstRole, secondUser, secondRole);
        
        // when
        List<UserDto> users = dao.findAll();
        
        // then
        assertThat(users.size(), is(2));
        assertThat(users.get(0).getRole(), containsString(UserRole.ADMIN.name()));
        assertThat(users.get(1).getRole(), containsString(UserRole.USER.name())); 
    }
}
