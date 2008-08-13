package fr.capwebct.modules.payment.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.dao.IExternalApplicationDAO;

public class ExternalApplicationDAO 
    extends GenericHibernateDAO<ExternalApplication, Long> 
    implements IExternalApplicationDAO {

    public ExternalApplication findByLabel(String label) throws DataAccessException {

        if (label == null || label.equals(""))
            return null;
        
        Criteria crit = getSession().createCriteria(ExternalApplication.class);
        crit.add(Restrictions.eq("label", label));

        return (ExternalApplication) crit.uniqueResult();
    }

    public List<ExternalApplication> findAll() {
        Criteria crit = getSession().createCriteria(ExternalApplication.class);
        crit.addOrder(Order.asc("label"));
        return crit.list();
    }
}
