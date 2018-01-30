package pl.piotrowicki.lotto.util;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class StatisticUtilTest {

    @Test
    public void testMaxValue() {
        // given
        Map<Integer, Long> mode = new HashMap();
        mode.put(1, 1L);
        mode.put(2, 4L);
        mode.put(3, 4L);

        // when
        Long maxValue = StatisticUtil.calculateAxisYSize(mode);

        // then
        assertThat(maxValue, is(4L));
    }
}
