package pl.piotrowicki.lotto.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Nowik
 */
@FacesConverter(value = "luckyNumbersConverter")
public class LuckyNumbersConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (StringUtils.isBlank(value)) {
            return Collections.EMPTY_LIST;
        }
        String[] split = value.split("-");
        return Arrays.stream(split).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        throw new UnsupportedOperationException("Not supported yet." + getClass().getEnclosingMethod().getName());
    }
    
}
