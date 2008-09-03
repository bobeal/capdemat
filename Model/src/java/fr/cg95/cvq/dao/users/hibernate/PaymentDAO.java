package fr.cg95.cvq.dao.users.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IPaymentDAO;
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
            parametersValues.put("initializationDateFrom",initDateFrom);
            parametersTypes.put("initializationDateFrom",Hibernate.DATE);
        }
        if (initDateTo != null) {
            sb.append(" and payment.initializationDate < :initializationDateTo");
            parametersValues.put("initializationDateTo",initDateTo);
            parametersTypes.put("initializationDateTo",Hibernate.DATE);
        }
        if (commitDateFrom != null) {
            sb.append(" and payment.commitDate > :commitDateFrom");
            parametersValues.put("commitDateFrom",commitDateFrom);
            parametersTypes.put("commitDateFrom",Hibernate.DATE);
        }
        if (commitDateTo != null) {
            sb.append(" and payment.commitDate < :commitDateTo");
            parametersValues.put("commitDateTo",commitDateTo);
            parametersTypes.put("commitDateTo",Hibernate.DATE);
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
}
