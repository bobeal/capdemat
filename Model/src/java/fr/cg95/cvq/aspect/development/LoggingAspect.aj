package fr.cg95.cvq.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.Signature;

public aspect LoggingAspect extends CapDematAbstractBaseAspect {
    
    private static Logger logger = Logger.getRootLogger();
    
    public pointcut exceptionLogMethods() : call(* *.*(..)) && !within(LoggingAspect);
    
    before() : serviceCalls() && !execution(String *.toString()) {
        Signature signature = thisJoinPointStaticPart.getSignature();
        
        StringBuffer sb = new StringBuffer();
        sb.append("entering ").append(signature.getDeclaringType().getName())
            .append(".").append(signature.getName());

        sb.append("(");
        Object[] args = thisJoinPoint.getArgs();
        for (int i = 0, length = args.length; i < length; i++) {
            Object arg = args[i];
            sb.append(arg);
            if (i != length - 1)
                sb.append(",");
        }
        sb.append(")");
        
        logger.debug(sb.toString());
    }
    
    after() throwing(Throwable ex) : serviceCalls() {
        Signature signature = thisJoinPointStaticPart.getSignature();
        
        StringBuffer sb = new StringBuffer();
        sb.append("exception in ").append(signature.getDeclaringType().getName())
            .append(".").append(signature.getName())
            .append(" : ").append(ex);
        
        logger.debug(sb.toString());
    }
}