package fr.capwebct.modules.payment.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.dao.IInvoiceDAO;

public class InvoiceDAO extends GenericHibernateDAO<Invoice, Long> implements IInvoiceDAO {

    @SuppressWarnings("unchecked")
    public List<Invoice> search(String invoiceId, String invoiceLabel,
        Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
        String efaId, long externalApplicationId, String broker,
        final int results, final int startIndex, final String sort, final String dir)
        throws DataAccessException {
        
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("from Invoice invoice ")
                .append("where 1 = 1 ");
            
            if (invoiceId != null && !invoiceId.equals("")) {
                sb.append("and invoice.invoiceId = ? ");
                objectList.add(invoiceId);
                typeList.add(Hibernate.STRING);
            }
            
            if (invoiceLabel != null && !invoiceLabel.equals("")) {
                sb.append("and lower(invoice.invoiceLabel) like lower(?) ");
                objectList.add("%" + invoiceLabel + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (invoicePaymentDateStart != null) {
                sb.append("and invoice.invoicePaymentDate > ? ");
                objectList.add(invoicePaymentDateStart);
                typeList.add(Hibernate.TIMESTAMP);
            }
            
            if (invoicePaymentDateEnd != null) {
                sb.append("and invoice.invoicePaymentDate < ? ");
                objectList.add(invoicePaymentDateEnd);
                typeList.add(Hibernate.TIMESTAMP);
            }
            
            if (efaId != null && !efaId.equals("")) {
                sb.append("and invoice.externalFamilyAccount.externalFamilyAccountId = ? ");
                objectList.add(efaId);
                typeList.add(Hibernate.STRING);
            }

            if (externalApplicationId != 0) {
                sb.append("and invoice.externalFamilyAccount.externalApplication.id = ? ");
                objectList.add(externalApplicationId);
                typeList.add(Hibernate.LONG);
            }

            if (broker != null && !broker.equals("")) {
                sb.append("and invoice.payment.broker = ? ");
                objectList.add(broker);
                typeList.add(Hibernate.STRING);            	
            }
            
            if (sort != null) {
                if (sort.equals("invoiceId"))
                    sb.append("order by invoice.invoiceId ");
                else if (sort.equals("invoicePaymentDate"))
                    sb.append("order by invoice.invoicePaymentDate ");
                else if (sort.equals("externalFamilyAccountId"))
                    sb.append("order by invoice.externalFamilyAccount.externalFamilyAccountId ");
                else
                    sb.append("order by invoice.invoiceId ");
            } else {
                sb.append("order by invoice.invoiceId ");
            }
            
            if (dir != null && dir.equals("desc"))
                sb.append(" desc");

            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);
            query.setFirstResult(startIndex);
            query.setMaxResults(results);

            return (List<Invoice>)query.list();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public Long countForSearch(String invoiceId, String invoiceLabel, Date invoicePaymentDateStart, 
            Date invoicePaymentDateEnd, String efaId, long externalApplicationId, String broker) 
        throws DataAccessException {
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(invoice) from Invoice invoice ")
                .append("where 1 = 1 ");
            
            if (invoiceId != null && !invoiceId.equals("")) {
                sb.append("and invoice.invoiceId = ? ");
                objectList.add(invoiceId);
                typeList.add(Hibernate.STRING);
            }
            
            if (invoiceLabel != null && !invoiceLabel.equals("")) {
                sb.append("and invoice.invoiceLabel like ? ");
                objectList.add(invoiceLabel + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (invoicePaymentDateStart != null) {
                sb.append("and invoice.invoicePaymentDate > ? ");
                objectList.add(invoicePaymentDateStart);
                typeList.add(Hibernate.TIMESTAMP);
            }
            
            if (invoicePaymentDateEnd != null) {
                sb.append("and invoice.invoicePaymentDate < ? ");
                objectList.add(invoicePaymentDateEnd);
                typeList.add(Hibernate.TIMESTAMP);
            }
            
            if (efaId != null && !efaId.equals("")) {
                sb.append("and invoice.externalFamilyAccount.externalFamilyAccountId = ? ");
                objectList.add(efaId + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (externalApplicationId != 0) {
                sb.append("and invoice.externalFamilyAccount.externalApplication.id = ? ");
                objectList.add(externalApplicationId);
                typeList.add(Hibernate.LONG);
            }
            
            if (broker != null && !broker.equals("")) {
            	sb.append("and invoice.payment.broker = ? ");
            	objectList.add(broker);
            	typeList.add(Hibernate.STRING);
            }
            
            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);

            return (Long) query.iterate().next();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
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

    public List<Invoice> findByExternalApplicationAndBroker(long externalApplicationId, 
            String broker) throws DataAccessException {
        
        if (externalApplicationId == 0 || (broker == null || broker.equals("")))
            return null;
        
        StringBuffer sb = new StringBuffer();
        sb.append("from Invoice invoice ")
            .append("where invoice.broker = :broker ")
            .append("and invoice.externalFamilyAccount.externalApplication.id = :id");
        
        Query query = getSession().createQuery(sb.toString())
            .setString("broker", broker)
            .setLong("id", externalApplicationId);

        return query.list();
    }
}
