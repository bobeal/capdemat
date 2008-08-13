package fr.capwebct.modules.payment.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.dao.IInvoiceDAO;

public class InvoiceDAO extends GenericHibernateDAO<Invoice, Long> implements IInvoiceDAO {

	public List<Invoice> search(String invoiceId, String invoiceLabel,
			Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId) throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Invoice.class);

        if (invoiceId != null)
            crit.add(Restrictions.like("invoiceId", invoiceId, MatchMode.ANYWHERE));
        if (invoiceLabel != null)
            crit.add(Restrictions.ilike("invoiceLabel", invoiceLabel, MatchMode.ANYWHERE));
        if (invoicePaymentDateStart != null)
            crit.add(Restrictions.ge("invoicePaymentDate", invoicePaymentDateStart));
        if (invoicePaymentDateEnd != null)
            crit.add(Restrictions.le("invoicePaymentDate", invoicePaymentDateEnd));
        if ((efaId != null && !efaId.equals(""))
                || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (efaId != null && !efaId.equals(""))
                efaCriteria.add(Restrictions.ilike("externalFamilyAccountId", efaId, 
                        MatchMode.ANYWHERE));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }

        return crit.list();
	}

	public List<Invoice> findByExternalId(String externalFamilyAccountId , 
            long externalApplicationId) throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Invoice.class);
        
        if (externalFamilyAccountId != null || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null)
                efaCriteria.add(Restrictions.eq("externalFamilyAccountId", externalFamilyAccountId));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
            return crit.list();
        } else {
            return null;
        }
	}

    public Invoice findByExternalAndInvoiceId(String externalFamilyAccountId, 
            long externalApplicationId, String invoiceId) throws DataAccessException {

        Criteria crit = getSession().createCriteria(Invoice.class);
        
        if (invoiceId != null)
            crit.add(Restrictions.eq("invoiceId", invoiceId));
        if (externalFamilyAccountId != null || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null)
                efaCriteria.add(Restrictions.eq("externalFamilyAccountId", externalFamilyAccountId));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }

        return (Invoice) crit.uniqueResult();
    }

    public List<Invoice> findByPaymentId(long paymentId) throws DataAccessException {
        Criteria crit = getSession().createCriteria(Invoice.class);
        crit.createCriteria("payment").add(Restrictions.eq("id", paymentId));
        
        return crit.list();
    }
}
