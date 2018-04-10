package pl.piotrowicki.lotto.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Before;
import org.junit.Test;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawDaoTest extends BaseDaoTest {

    private static final String NUMBERS = "1 2 3 4 5 6";
    
    private final DrawDao dao = new DrawDao();

    @Before
    public void setUp() {
        dao.setEntityManager(em);
    }

    @Test
    public void findAllDaoTest() {
        // given
        Draw draw = new Draw();
        draw.setNumbers(NUMBERS);
        draw.setDrawDate(LocalDate.parse("2018-01-01"));

        dao.save(draw);

        // when
        List<Draw> findAll = dao.findAll();

        // then
        assertThat(findAll.size(), is(1));
        assertThat(findAll.get(0).getNumbers(), is(NUMBERS));
    }

    @Test
    public void findByDrawAndDrawDate() {
        // given
        Draw draw = new Draw();
        draw.setNumbers(NUMBERS);
        draw.setDrawDate(LocalDate.parse("2018-01-01"));

        dao.save(draw);
        
        // when
        Optional<Draw> result = dao.findByDrawAndDrawDate(NUMBERS, LocalDate.parse("2018-01-01"));
        
        // then
        assertThat(result.isPresent(), is(true));
    }
}
