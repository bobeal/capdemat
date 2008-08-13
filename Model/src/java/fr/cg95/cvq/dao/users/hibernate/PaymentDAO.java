package fr.cg95.cvq.dao.users.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
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
            final Long homeFolderId, final String lastName) {

        StringBuffer sb = new StringBuffer()
            .append("from Payment as payment").append(" where 1 = 1 ");
       
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
        if (lastName != null) {
            String likeLastName = "%" + lastName + "%";
            sb.append(" and payment.requester.lastName like ? ");
            objectList.add(likeLastName);
            typeList.add(Hibernate.STRING);
        }
        
        // order payments by initialization date
        sb.append(" order by payment.initializationDate desc ");
        
        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);
       return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
    }
    
    public List searchNotCommited(){

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
