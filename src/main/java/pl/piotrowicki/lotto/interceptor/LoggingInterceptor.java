package pl.piotrowicki.lotto.interceptor;

import java.text.MessageFormat;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.bean.annotation.Log;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Log
@Interceptor
public class LoggingInterceptor {
   
    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        LOG.info(MessageFormat.format("Method {0} started.", context.getMethod().getName()));
        return context.proceed();
    }
}
