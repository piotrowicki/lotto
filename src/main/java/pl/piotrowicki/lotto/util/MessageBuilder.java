package pl.piotrowicki.lotto.util;

import java.util.PropertyResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author nowik
 */
public final class MessageBuilder {
    private final FacesContext ctx = FacesContext.getCurrentInstance();
    
    private String title;
    private String message;
    private FacesMessage.Severity severity;
    private FacesMessage fm;
    
    private MessageBuilder() {}
    
    public static MessageBuilder aFacesMessage() {
        return new MessageBuilder();
    }
    
    public MessageBuilder withSeverity(FacesMessage.Severity severity) {
        this.severity = severity;
        return this;    
    }
    
    public MessageBuilder withTitle(String title) {
        this.title = title;
        return this;       
    }
    
    public MessageBuilder withMessage(String message) {
        this.message = message;
        return this;
    } 
    
    public MessageBuilder withBundleMessage(String messagePath) {
        PropertyResourceBundle prb = ctx.getApplication().evaluateExpressionGet(ctx, "#{msg}", PropertyResourceBundle.class);
        this.message = prb.getString(messagePath);
        return this;
    }
    
    public void add() {
        fm = new FacesMessage(severity, title, message);
        ctx.addMessage(null, fm);
    }
}
