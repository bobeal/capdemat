package fr.cg95.cvq.service.payment.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.payment.IPaymentDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsUser;
import fr.cg95.cvq.service.payment.annotation.IsPayment;

@Aspect
public class PaymentContextAspect implements Ordered {

    private Logger logger = Logger.getLogger(PaymentContextAspect.class);

    @Autowired
    private IPaymentDAO paymentDAO;

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.payment..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        if (!ArrayUtils.contains(context.types(), ContextType.ECITIZEN)
            && !ArrayUtils.contains(context.types(), ContextType.AGENT))
            return;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (context.privilege().equals(ContextPrivilege.NONE)) {
            logger.debug("contextAnnotatedMethod() no special privilege asked"
                    + " on method " + signature.getMethod().getName() + ", returning");
            return;
        }

        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long individualId = null;
        int i = 0;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsUser.class)) {
                    if (argument instanceof Long) {
                        Long id = (Long) argument;
                        try {
                            paymentDAO.findById(Individual.class, id);
                            individualId = id;
                        } catch (CvqObjectNotFoundException e1) {
                            try {
                                paymentDAO.findById(HomeFolder.class, id);
                                homeFolderId = id;
                            } catch (CvqObjectNotFoundException e2) {
                                // no user with this id
                            }
                        }
                    } else if (argument instanceof Individual) {
                        individualId = ((Individual) argument).getId();
                    } else if (argument instanceof HomeFolder) {
                        homeFolderId = ((HomeFolder)argument).getId();
                    }
                } else if (parameterAnnotation.annotationType().equals(IsPayment.class)) {
                    if (argument instanceof Long) {
                        Object payment;
                        try {
                            payment = paymentDAO.findById(Payment.class, (Long) argument);
                            homeFolderId = ((Payment) payment).getHomeFolderId();
                            individualId = ((Payment) payment).getRequesterId();
                        } catch (CvqObjectNotFoundException confe) {
                            logger.error(confe.getMessage());
                        }
                    } else if (argument instanceof Payment) {
                        homeFolderId = ((Payment) argument).getHomeFolderId();
                        individualId= ((Payment) argument).getRequesterId();
                    }
                }
            }
            i++;
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, individualId, context.privilege()))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "access denied on home folder " + homeFolderId 
                        + " / individual " + individualId);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
