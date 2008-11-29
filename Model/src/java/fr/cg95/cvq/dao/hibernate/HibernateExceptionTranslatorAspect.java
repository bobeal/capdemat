package fr.cg95.cvq.dao.hibernate;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;

import fr.cg95.cvq.dao.CvqDaoException;

@Aspect
public class HibernateExceptionTranslatorAspect {

    @AfterThrowing(pointcut="fr.cg95.cvq.SystemArchitecture.dataAccessOperation()",
            throwing="hibernateEx")
    public void translateException(HibernateException hibernateEx) {
        throw new CvqDaoException("Unexpected DAO exception", hibernateEx);
    }
}
