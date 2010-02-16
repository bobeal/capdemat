package fr.cg95.cvq.dao.request;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

/**
 * An aspect before GenericDAO method calls to prevent using it on requests,
 * and enforce necessary composition happening in RequestDAO
 *
 * @author jsb@zenexity.fr
 */
@Aspect
public class RequestCompositionEnforcingAspect {

    @Before("execution(* fr.cg95.cvq.dao.hibernate.GenericDAO.*(..)) && !target(fr.cg95.cvq.dao.request.hibernate.RequestDAO)")
    public void check(JoinPoint point) throws CvqException {
        Object arguments[] = point.getArgs();
        if (arguments != null && arguments.length > 0) {
            Object argument = arguments[0];
            if (argument instanceof Request
                || (argument instanceof Class<?>
                    && Request.class.isAssignableFrom(((Class<?>)argument)))) {
                throw new CvqException("Do not use GenericDAO for Request manipulation, use RequestDAO !");
            }
        }
    }
}
