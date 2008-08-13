package fr.cg95.cvq.dao.hibernate;

import fr.cg95.cvq.dao.CvqDaoException;

import org.hibernate.HibernateException;

public class HibernateExceptionTranslator {

    public void translateException(HibernateException hibernateEx) {
        throw new CvqDaoException("Unexpected DAO exception", hibernateEx);
    }
}
