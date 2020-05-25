package pl.piotrowicki.lotto.converter;
import java.time.LocalDate;
import java.time.Month;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class LocalDateConverterTest {
    
    @Mock
    private FacesContext context;
    
    @Mock
    private UIComponent component;
    
    @InjectMocks
    private LocalDateConverter converter;

    @Test
    public void testGetAsObject() {
        // given
        String value = "2017-12-12";
         
        // when
        LocalDate date = (LocalDate) converter.getAsObject(context, component, value);
        
        // then
        assertThat(date.getYear(), is(2017));
        assertThat(date.getMonth(), is(Month.DECEMBER));
        assertThat(date.getDayOfMonth(), is(12));      
    }
    
        @Test
    public void testGetAsObjectWithEmptyString() {
        // given
        String value = "";
         
        // when
        LocalDate date = (LocalDate) converter.getAsObject(context, component, value);
        
        // then
        assertThat(date, nullValue());
    }

    @Test
    public void testGetAsString() {
        // given
        LocalDate date = LocalDate.parse("2017-12-12");
        
        // when
        String asString = converter.getAsString(context, component, date);
        
        // then
        assertThat(asString, is("2017-12-12"));
    }
    
    @Test
    public void testGetAsStringWithNull() {
        // given
        LocalDate date = null;
        
        // when
        String asString = converter.getAsString(context, component, date);
        
        // then
        assertThat(asString, is(""));
    }
}
