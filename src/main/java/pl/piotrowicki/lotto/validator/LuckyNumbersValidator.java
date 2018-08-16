package pl.piotrowicki.lotto.validator;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Nowik
 */
@FacesValidator(value = "luckyNumbersValidator")
public class LuckyNumbersValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List list = (List) value;
        if (list.isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: ", "Insert your favorite numbers.");
            throw new ValidatorException(msg);
        }
    }
}
