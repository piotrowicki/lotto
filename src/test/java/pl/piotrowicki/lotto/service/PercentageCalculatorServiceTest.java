package pl.piotrowicki.lotto.service;

import java.util.Arrays;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class PercentageCalculatorServiceTest {

    private PercentageStatisticService statistic = new PercentageStatisticService();

    @Test
    public void testCalculate() {
        // given
        DrawEntity draw1 = new DrawEntity();
        draw1.setNumbers("5 4 3 2 1 1");

        // when
        Map<Integer, Long> calculatedMode = statistic.calculate(Arrays.asList(draw1));

        // then
        assertThat(calculatedMode.size(), is(5));
        assertThat(calculatedMode, IsMapContaining.hasEntry(1, Long.valueOf(33)));
        assertThat(calculatedMode, IsMapContaining.hasEntry(2, Long.valueOf(17)));
        assertThat(calculatedMode, IsMapContaining.hasEntry(3, Long.valueOf(17)));
        assertThat(calculatedMode, IsMapContaining.hasEntry(4, Long.valueOf(17)));
        assertThat(calculatedMode, IsMapContaining.hasEntry(5, Long.valueOf(17)));
    }
}
