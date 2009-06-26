package fr.cg95.cvq.aspect;

import org.apache.log4j.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * An aspect wrapping unit tests and catching all unwantedly thrown exceptions
 * that otherwise swallowed by Junit 3.8.
 *  
 * @author bor@zenexity.fr
 */
@Aspect
public class ExceptionHandlerAspect {

    private Logger logger = Logger.getLogger(ExceptionHandlerAspect.class);
    
    @Around("execution(* fr.cg95.cvq.testtool.ServiceTestCase+.test*(..))")
    public Object aroundUnitTest(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Exception e) {
            logger.error("aroundUnitTest() Unit tests threw an exception with message : " 
                + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
