package fr.cg95.cvq.dao.users.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
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
 * @author maxence.veyret@bull.net
 */
public class PaymentDAO extends GenericDAO implements IPaymentDAO {
	  
    public PaymentDAO() {
        super();
    }

    public List findByHomeFolder(HomeFolder homeFolder) {
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

    public List search(final Date initDateFrom, final Date initDateTo, final Date commitDateFrom,
            final Date commitDateTo, final PaymentState paymentState, 
            final String cvqReference, final String bankReference, final String broker, 
            final Long homeFolderId, final String requesterLastName,final String sort, 
            final String dir, final int recordsReturned, final int startIndex) {

        StringBuffer sb = new StringBuffer()
            .append("from Payment as payment").append(" where 1 = 1 ");
        Map<String, Object> parametersValues = new TreeMap<String, Object>();
        Map<String, Type> parametersTypes = new TreeMap<String, Type>();

        if (initDateFrom != null) {
            sb.append(" and payment.initializationDate > :initializationDateFrom ");
            parametersValues.put("initializationDateFrom", initDateFrom);
            parametersTypes.put("initializationDateFrom", Hibernate.TIMESTAMP);
        }
        if (initDateTo != null) {
            sb.append(" and payment.initializationDate < :initializationDateTo");
            parametersValues.put("initializationDateTo", initDateTo);
            parametersTypes.put("initializationDateTo", Hibernate.TIMESTAMP);
        }
        if (commitDateFrom != null) {
            sb.append(" and payment.commitDate > :commitDateFrom");
            parametersValues.put("commitDateFrom", commitDateFrom);
            parametersTypes.put("commitDateFrom", Hibernate.TIMESTAMP);
        }
        if (commitDateTo != null) {
            sb.append(" and payment.commitDate < :commitDateTo");
            parametersValues.put("commitDateTo", commitDateTo);
            parametersTypes.put("commitDateTo", Hibernate.TIMESTAMP);
        }

        if (paymentState != null) {
            sb.append(" and payment.state = :state ");
            parametersValues.put("state",paymentState.toString());
            parametersTypes.put("state",Hibernate.STRING);
        }
        if (cvqReference != null) {
            sb.append(" and payment.cvqReference = :cvqReference");
            parametersValues.put("cvqReference",cvqReference);
            parametersTypes.put("cvqReference",Hibernate.STRING);
        }
        if (bankReference != null) {
            sb.append(" and payment.bankReference = :bankReference ");
            parametersValues.put("bankReference",bankReference);
            parametersTypes.put("bankReference",Hibernate.STRING);
        }
        if (broker != null) {
            sb.append(" and payment.broker = :broker ");
            parametersValues.put("broker",broker);
            parametersTypes.put("broker",Hibernate.STRING);
        }
        if (homeFolderId != null) {
            sb.append(" and payment.homeFolder = :homeFolder ");
            parametersValues.put("homeFolder",homeFolderId);
            parametersTypes.put("homeFolder",Hibernate.LONG);
        }
        if (requesterLastName != null) {
            String likeLastName = "%" + requesterLastName + "%";
            sb.append(" and lower(payment.requester.lastName) like lower(:requesterLastName)");
            parametersValues.put("requesterLastName",likeLastName);
            parametersTypes.put("requesterLastName",Hibernate.STRING);
        }

        if (sort != null) {
            if (sort.equals("commitDate"))
                sb.append("order by payment.commitDate");
            else if (sort.equals("state"))
                sb.append(" order by payment.state");
            else if (sort.equals("id"))
                sb.append(" order by payment.id");
            else if (sort.equals("initializationDate"))
                sb.append(" order by payment.initializationDate");
            else if (sort.equals("cvqReference"))
                sb.append(" order by payment.cvqReference");
            else if (sort.equals("bankReference"))
                sb.append(" order by payment.bankReference");
            else if (sort.equals("broker"))
                sb.append(" order by payment.broker");
            else if (sort.equals("homeFolderId"))
                sb.append("order by payment.homeFolder.id");
            else if (sort.equals("requesterLastName"))
                sb.append("order by payment.requester.lastName");

        } else {
            /** 
             * default sort order 
             * order payments by initialization date
             */
            sb.append(" order by payment.initializationDate desc ");
        }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");

        try {
            Query query = HibernateUtil.getSession().createQuery(sb.toString());
            for (String parameter : parametersValues.keySet()) {
                query.setParameter(parameter, parametersValues.get(parameter),
                        parametersTypes.get(parameter));
            }
            if (recordsReturned != -1)
                query.setMaxResults(recordsReturned);
            query.setFirstResult(startIndex);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public Long count(final Date initDateFrom, final Date initDateTo, final Date commitDateFrom,
            final Date commitDateTo, final PaymentState paymentState, final String cvqReference, 
            final String bankReference, final String broker, final Long homeFolderId, 
            final String requesterLastName) {

        StringBuffer sb = new StringBuffer()
            .append("select count(*) from Payment as payment").append(" where 1 = 1 ");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        if (initDateFrom != null) {
            sb.append(" and payment.initializationDate > ? ");
            objectList.add(initDateFrom);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (initDateTo != null) {
            sb.append(" and payment.initializationDate < ? ");
            objectList.add(initDateTo);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (commitDateFrom != null) {
            sb.append(" and payment.commitDate > ? ");
            objectList.add(commitDateFrom);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (commitDateTo != null) {
            sb.append(" and payment.commitDate < ? ");
            objectList.add(commitDateTo);
            typeList.add(Hibernate.TIMESTAMP);
        }
        if (paymentState != null) {
            sb.append(" and payment.state = ? ");
            objectList.add(paymentState.toString());
            typeList.add(Hibernate.STRING);
        }
        if (cvqReference != null) {
            sb.append(" and payment.cvqReference = ? ");
            objectList.add(cvqReference);
            typeList.add(Hibernate.STRING);
        }
        if (bankReference != null) {
            sb.append(" and payment.bankReference = ? ");
            objectList.add(bankReference);
            typeList.add(Hibernate.STRING);
        }
        if (broker != null) {
            sb.append(" and payment.broker = ? ");
            objectList.add(broker);
            typeList.add(Hibernate.STRING);
        }
        if (homeFolderId != null) {
            sb.append(" and payment.homeFolder = ? ");
            objectList.add(homeFolderId);
            typeList.add(Hibernate.LONG);
        }
        if (requesterLastName != null) {
            String likeLastName = "%" + requesterLastName + "%";
            sb.append(" and payment.requester.lastName like ? ");
            objectList.add(likeLastName);
            typeList.add(Hibernate.STRING);
        }
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return (Long) HibernateUtil.getSession()
                .createQuery(sb.toString())
                .setParameters(objectTab, typeTab)
                .iterate().next();
   
    }
    public List searchNotCommited() {

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
    
    public List<Payment> search(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex, final PaymentMode paymentMode) {

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
            }
        }
        
        // Deals with Payment Mode 
        if (paymentMode != null) {
            sb.append(" and payment.paymentMode " + Critere.EQUALS + " ?");
            parametersValues.add(paymentMode.toString());
            parametersTypes.add(Hibernate.STRING);
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
    
    public Long count(final Set<Critere> criteria, final PaymentMode paymentMode) {
        return searchCount(criteria, paymentMode).longValue();
    }
    
    /**
     * A customized search method for cases where we just want the payments
     * count.
     */
    protected Long searchCount(final Set<Critere> criteria, final PaymentMode paymentMode) {

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
            }
        }

        // Deals with Payment Mode 
        if (paymentMode != null) {
            sb.append(" and payment.paymentMode " + Critere.EQUALS + " ?");
            objectList.add(paymentMode.toString());
            typeList.add(Hibernate.STRING);
        }
        
        sbSelect.append(sb);
        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        return (Long) HibernateUtil.getSession()
            .createQuery(sbSelect.toString())
            .setParameters(objectTab, typeTab)
            .iterate().next(); 
    }
}
