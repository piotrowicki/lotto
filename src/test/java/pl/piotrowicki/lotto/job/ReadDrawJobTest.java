package pl.piotrowicki.lotto.job;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

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
        DrawEntity draw = drawJob.convertToEntity(DRAW);
        given(jsoupReader.read(anyString())).willReturn(DRAW);
        given(drawService.findByDrawAndDrawDate(draw.getNumbers(), draw.getDrawDate())).willReturn(Optional.empty());
        
        // when
        drawJob.run();
        
        // then
        verify(drawService).save(draw);
    }
       
     @Test
    public void testRunWithoutSave() throws ParseException {
        // given
        DrawEntity draw = drawJob.convertToEntity(DRAW);
        given(jsoupReader.read(anyString())).willReturn(DRAW);
        given(drawService.findByDrawAndDrawDate(draw.getNumbers(), draw.getDrawDate())).willReturn(Optional.of(new DrawEntity()));
        
        // when
        drawJob.run();
        
        // then
        verify(drawService, never()).save(draw);
    }
    
       @Test
    public void testConvertToEntity() {
        // given
        LocalDate date = LocalDate.parse("2017-12-16");
        String input = "2017-12-16 13 27 41 1 33 31";

        // when
        DrawEntity entity = drawJob.convertToEntity(input);

        // then
        assertThat(entity.getDrawDate(), is(equalTo(date)));
        assertThat(entity.getNumbers(), is(equalTo("13 27 41 1 33 31")));
    }
}
