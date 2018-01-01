package pl.piotrowicki.lotto.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@FacesConverter(value = "localDateTimeConverter")
public class LocalDateTimeConverter implements Converter {
    
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value.isEmpty() 
               ? null
               : LocalDateTime.parse(value, DateTimeFormatter.ofPattern(PATTERN));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Optional<LocalDateTime> localDateTime = Optional.ofNullable((LocalDateTime) value);
        
        return localDateTime.isPresent() 
                ? localDateTime.get().format(DateTimeFormatter.ofPattern(PATTERN))
                : "";
    }
}
