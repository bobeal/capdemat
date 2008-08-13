package fr.capwebct.modules.payment.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import fr.capwebct.modules.payment.business.ExternalImportAudit;
import fr.capwebct.modules.payment.dao.IExternalImportAuditDAO;

public class ExternalImportAuditDAO 
    extends GenericHibernateDAO<ExternalImportAudit, Long> 
    implements IExternalImportAuditDAO {

    public List<ExternalImportAudit> findAll() {
        Criteria crit = getSession().createCriteria(ExternalImportAudit.class);
        crit.addOrder(Order.desc("date"));
        return crit.list();        
    }
}
