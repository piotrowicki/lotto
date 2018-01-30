package pl.piotrowicki.lotto.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class DrawConverterUtilTest {

    @Test
    public void testConvertToEntity() {
        // given
        LocalDate date = LocalDate.parse("2017-12-16");
        String input = "2017-12-16 13 27 41 1 33 31";

        // when
        Draw entity = DrawConverterUtil.convertToEntity(input);

        // then
        assertThat(entity.getDrawDate(), is(equalTo(date)));
        assertThat(entity.getNumbers(), is(equalTo("13 27 41 1 33 31")));
    }

    @Test
    public void testConvertToIntegers() {
        // given
        Draw draw1 = new Draw();
        draw1.setNumbers("1 2 3 4 5");
        
        Draw draw2 = new Draw();
        draw2.setNumbers("6 7 8 9 10");
        
        // when
        List<Integer> integers = DrawConverterUtil.convertToIntegers(Arrays.asList(draw1, draw2));
        
        // then
        assertThat(integers, containsInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
    
    @Test
    public void testConvertToIntegerEmptyList() {
        // when
        List<Integer> integers = DrawConverterUtil.convertToIntegers(new ArrayList<>());
        
        // then
        assertThat(integers.size(), is(0));
    }
}
