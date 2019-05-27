package pl.piotrowicki.lotto.service;

import java.util.Arrays;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceTest {

    @Spy
    private  StatisticService service;

    @Test
    public void testCalculateStats() {
        // given
        DrawEntity draw1 = new DrawEntity();
        draw1.setNumbers("5 4 3 2 1 1");

        DrawEntity draw2 = new DrawEntity();
        draw2.setNumbers("9 8 7 6 5 4");

        // when
        Map<Integer, Long> stats = service.calculateStats(Arrays.asList(draw1, draw2));

        // then
        assertThat(stats.size(), is(9));
        assertThat(stats, IsMapContaining.hasEntry(1, Long.valueOf(2)));
        assertThat(stats, IsMapContaining.hasEntry(4, Long.valueOf(2)));
        assertThat(stats, IsMapContaining.hasEntry(7, Long.valueOf(1)));
        assertThat(stats, IsMapContaining.hasEntry(9, Long.valueOf(1)));
    }
}
