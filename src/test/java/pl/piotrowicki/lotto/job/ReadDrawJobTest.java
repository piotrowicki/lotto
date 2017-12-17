package pl.piotrowicki.lotto.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReader;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class ReadDrawJobTest {
    
    private static final String DRAW = "2017-12-01 1 7 11 21 33 46";
    
    @Mock
    private JsoupReader jsoupReader;
    
    @Mock
    private DrawService drawService;
    
    @InjectMocks
    private ReadDrawJob drawJob;

    @Test
    public void testRun() {
        // given
        given(jsoupReader.read()).willReturn(DRAW);
        given(drawService.convertToEntity(DRAW)).willReturn(new Draw());
        
        // when
        drawJob.run();
        
        // then
        verify(drawService).convertToEntity(DRAW);
    }
}
