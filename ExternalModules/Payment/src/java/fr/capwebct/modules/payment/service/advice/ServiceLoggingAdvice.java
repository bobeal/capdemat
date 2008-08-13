package fr.capwebct.modules.payment.service.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class ServiceLoggingAdvice implements MethodBeforeAdvice {

    private static Log log = LogFactory.getLog(ServiceLoggingAdvice.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("calling method ").append(method.getName())
                .append(" on service ").append(target.getClass().getName());
        
        /*
        stringBuffer.append(" with args ");
        for (Object arg : args) {
            stringBuffer.append(arg).append(",");
        }
        */
        
        log.debug(stringBuffer.toString());
    }
}
