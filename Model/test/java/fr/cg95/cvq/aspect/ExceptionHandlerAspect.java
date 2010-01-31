package fr.cg95.cvq.aspect;

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

    @Around("execution(* fr.cg95.cvq.testtool.ServiceTestCase+.test*(..))")
    public Object aroundUnitTest(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unit test threw an exception, see it above");
        }
    }
}
