package pl.piotrowicki.lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class DrawConverterUtilTest {

    @Test
    public void testConvertToIntegers() {
        // given
        DrawEntity draw1 = new DrawEntity();
        draw1.setNumbers("1 2 3 4 5");
        
        DrawEntity draw2 = new DrawEntity();
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
