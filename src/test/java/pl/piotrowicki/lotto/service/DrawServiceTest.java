package pl.piotrowicki.lotto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class DrawServiceTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DrawService drawService;

    @Before
    public void setUp() {
        drawService = new DrawService();
    }

    @Test
    public void testConvertToEntity() throws ParseException {
        // given
        String input = "2017-12-16 13 27 41 1 33 31";

        // when
        Draw entity = drawService.convertToEntity(input);

        // then
        assertThat(entity.getDrawDate(), is(equalTo(DATE_FORMAT.parse("2017-12-16"))));
        assertThat(entity.getNumbers(), is(equalTo("13 27 41 1 33 31")));
    }
}
