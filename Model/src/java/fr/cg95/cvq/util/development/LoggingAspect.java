package fr.cg95.cvq.util.development;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    private static Logger logger = Logger.getRootLogger();

    @Before("fr.cg95.cvq.SystemArchitecture.businessService()")
    public void doLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        
        StringBuffer sb = new StringBuffer();
        sb.append("entering ").append(signature.getDeclaringType().getName())
            .append(".").append(signature.getName());

        sb.append("(");
        Object[] args = joinPoint.getArgs();
        for (int i = 0, length = args.length; i < length; i++) {
            Object arg = args[i];
            sb.append(arg);
            if (i != length - 1)
                sb.append(",");
        }
        sb.append(")");
        
        logger.debug(sb.toString());
    }
}
