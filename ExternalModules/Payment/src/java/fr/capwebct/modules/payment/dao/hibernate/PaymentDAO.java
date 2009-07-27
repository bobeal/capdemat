package fr.capwebct.modules.payment.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.dao.IPaymentDAO;

public class PaymentDAO extends GenericHibernateDAO<Payment, Long> implements IPaymentDAO {

    public List<Payment> search(final Date paymentDateStart, final Date paymentDateEnd, 
            final String paymentAck, final String cvqAck, final long cfaId, 
            final String broker, boolean filterExported) throws DataAccessException {
        
    	Criteria criteria = getSession().createCriteria(Payment.class);

        if (paymentAck != null && !paymentAck.equals(""))
        	criteria.add(Restrictions.ilike("paymentAck", paymentAck, MatchMode.ANYWHERE));
        if (cvqAck != null && !cvqAck.equals(""))
        	criteria.add(Restrictions.ilike("cvqAck", cvqAck, MatchMode.ANYWHERE));
        if (paymentDateStart != null)
        	criteria.add(Restrictions.ge("paymentDate", paymentDateStart));
        if (paymentDateEnd != null)
        	criteria.add(Restrictions.le("paymentDate", paymentDateEnd));
        if (cfaId != 0)
        	criteria.add(Restrictions.eq("cfaId", cfaId));
        if (broker != null && !broker.equals(""))
        	criteria.add(Restrictions.ilike("broker", broker, MatchMode.ANYWHERE));
        if (filterExported)
        	criteria.add(Restrictions.eq("exported", false));
        
        criteria.addOrder(Order.desc("paymentDate"));

        return criteria.list();
    }

    public Payment findByPaymentAck(String paymentAck) throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Payment.class);
        crit.add(Restrictions.eq("paymentAck", paymentAck));
        
        return (Payment) crit.uniqueResult();
    }
}
