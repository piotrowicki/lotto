package pl.piotrowicki.lotto.job;

import java.text.ParseException;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReaderService;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class ReadDrawJobTest {
    
    private static final String DRAW = "2017-12-01 1 7 11 21 33 46";
    
    @Mock
    private JsoupReaderService jsoupReader;
    
    @Mock
    private DrawService drawService;
    
    @InjectMocks
    private ReadDrawJob drawJob;

    @Test
    public void testRunWithSave() throws ParseException {
        // given
        DrawEntity draw = DrawConverterUtil.convertToEntity(DRAW);
        given(jsoupReader.read()).willReturn(DRAW);
        given(drawService.findByDrawAndDrawDate(draw.getNumbers(), draw.getDrawDate())).willReturn(Optional.empty());
        
        // when
        drawJob.run();
        
        // then
        verify(drawService).save(draw);
    }
    
     @Test
    public void testRunWithoutSave() throws ParseException {
        // given
        DrawEntity draw = DrawConverterUtil.convertToEntity(DRAW);
        given(jsoupReader.read()).willReturn(DRAW);
        given(drawService.findByDrawAndDrawDate(draw.getNumbers(), draw.getDrawDate())).willReturn(Optional.of(new DrawEntity()));
        
        // when
        drawJob.run();
        
        // then
        verify(drawService, never()).save(draw);
    }
}
