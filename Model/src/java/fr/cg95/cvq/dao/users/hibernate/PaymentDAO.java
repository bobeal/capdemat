package fr.cg95.cvq.dao.users.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IPaymentDAO;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

/**
 * Hibernate implementation of the {@link IPaymentDAO} interface.
 * 
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public class PaymentDAO extends GenericDAO implements IPaymentDAO {
	  
    public PaymentDAO() {
        super();
    }

    public List<Payment> findByHomeFolder(HomeFolder homeFolder) {
        return HibernateUtil.getSession()
            .createQuery("from Payment as payment where payment.homeFolder = :folder "
                    + "order by payment.initializationDate desc")
            .setParameter("folder", homeFolder)
            .list(); 
    }

    public Payment findByCvqReference(final String cvqReference) {
        return (Payment) HibernateUtil.getSession()
            .createQuery("from Payment as payment where payment.cvqReference = :cvqReference")
            .setParameter("cvqReference", cvqReference)
            .uniqueResult(); 
    }

    public List<Payment> search(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Payment as payment").append(" where 1 = 1 ");

        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();

        // go through all the criteria and create the query
        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_HOME_FOLDER_ID)) {
                sb.append(" and payment.homeFolder " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_REQUESTER_LASTNAME)) {
                sb.append(" and lower(payment.requester.lastName) " + searchCrit.getSqlComparatif()
                        + " lower(?)");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_CVQ_REFERENCE)) {
                sb.append(" and payment.cvqReference " + searchCrit.getComparatif() + " ? ");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);

            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_BANK_REFERENCE)) {
                sb.append(" and payment.bankReference " + searchCrit.getComparatif() + " ? ");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_INITIALIZATION_DATE)) {
                sb.append(" and payment.initializationDate " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_PAYMENT_STATE)) {
                sb.append(" and payment.state " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_BROKER)) {
                sb.append(" and payment.broker " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_PAYMENT_MODE)) {
                sb.append(" and payment.paymentMode " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            }
        }
        
        if (sort != null) {
            if (sort.equals(Payment.SEARCH_BY_HOME_FOLDER_ID))
                sb.append(" order by payment.homeFolder");
            else if (sort.equals(Payment.SEARCH_BY_REQUESTER_LASTNAME))
                sb.append(" order by payment.requester.lastName");
            else if (sort.equals(Payment.SEARCH_BY_INITIALIZATION_DATE))
                sb.append(" order by payment.initializationDate");
            else
                sb.append(" order by payment.id");
        } else {
            // default sort order
            sb.append(" order by payment.id");
        }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));

        if (recordsReturned > 0)
            query.setMaxResults(recordsReturned);
        query.setFirstResult(startIndex);
        return query.list();
    }
    
    public List<Payment> searchNotCommited() {

        StringBuffer sb = new StringBuffer()
            .append("from Payment as payment").append(" where 1 = 1 ");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        Date dateTest = DateUtils.getShiftedDate(Calendar.HOUR, -3);

        sb.append("and payment.initializationDate < ? ");
        objectList.add(dateTest);
        typeList.add(Hibernate.TIMESTAMP);

        sb.append("and payment.state = ? ");
        objectList.add(PaymentState.INITIALIZED.toString());
        typeList.add(Hibernate.STRING);

        sb.append("and payment.commitAlert = ?");
        objectList.add(false);
        typeList.add(Hibernate.BOOLEAN);

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);


        return HibernateUtil.getSession()
                .createQuery(sb.toString())
                .setParameters(objectTab, typeTab)
                .list();
    }
   
    /**
     * A customized search method for cases where we just want the payments
     * count.
     */
    protected Long searchCount(final Set<Critere> criteria) {

        StringBuffer sbSelect = new StringBuffer();
        sbSelect.append("select count(*) from Payment as payment");

        StringBuffer sb = new StringBuffer(" where 1 = 1 ");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();
        
        // go through all the criteria and create the query
        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_HOME_FOLDER_ID)) {
                sb.append(" and payment.homeFolder " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);

            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_REQUESTER_LASTNAME)) {
                sb.append(" and lower(payment.requester.lastName) " + searchCrit.getSqlComparatif()
                        + " lower(?)");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
            
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_CVQ_REFERENCE)) {
                sb.append(" and payment.cvqReference " + searchCrit.getComparatif() + " ? ");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);

            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_BANK_REFERENCE)) {
                sb.append(" and payment.bankReference " + searchCrit.getComparatif() + " ? ");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_INITIALIZATION_DATE)) {
                sb.append(" and payment.initializationDate " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getDateValue());
                typeList.add(Hibernate.TIMESTAMP);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_PAYMENT_STATE)) {
                sb.append(" and payment.state " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_BROKER)) {
                sb.append(" and payment.broker " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
                
            } else if (searchCrit.getAttribut().equals(Payment.SEARCH_BY_PAYMENT_MODE)) {
                sb.append(" and payment.paymentMode " + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
            }
        }
        
        sbSelect.append(sb);
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        return (Long) HibernateUtil.getSession()
            .createQuery(sbSelect.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next(); 
    }
    
    public Long count(final Set<Critere> criteria) {
        return searchCount(criteria).longValue();
    }

}
