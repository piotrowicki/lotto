package pl.piotrowicki.lotto.converter;

import java.time.LocalDate;
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
@FacesConverter(value = "localDateConverter")
public class LocalDateConverter implements Converter {
    
    private static final String PATTERN = "yyyy-MM-dd";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         return value.isEmpty() 
               ? null
               : LocalDate.parse(value, DateTimeFormatter.ofPattern(PATTERN));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Optional<LocalDate> localDate = Optional.ofNullable((LocalDate) value);

        return localDate.isPresent()
                ? localDate.get().format(DateTimeFormatter.ofPattern(PATTERN))
                : "";
    }
}
