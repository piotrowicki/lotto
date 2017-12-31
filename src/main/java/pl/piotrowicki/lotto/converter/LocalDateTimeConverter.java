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

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDateTime.parse(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Optional<LocalDateTime> localDateTime = Optional.ofNullable((LocalDateTime) value);
        
        return localDateTime.isPresent() 
                ? localDateTime.get().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                : "";
    }
}
