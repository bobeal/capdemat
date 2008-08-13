package fr.capwebct.modules.payment.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.dao.IPaymentDAO;

public class PaymentDAO extends GenericHibernateDAO<Payment, Long> implements IPaymentDAO {

    public List<Payment> search(final Date paymentDateStart, final Date paymentDateEnd, 
            final String paymentAck, final String cvqAck, final long cfaId, 
            final String broker) throws DataAccessException {
        
        List<Criterion> criterionList = new ArrayList<Criterion>();

        Property paymentDateProperty = Property.forName("paymentDate");

        if (paymentAck != null && !paymentAck.equals(""))
            criterionList.add(Restrictions.ilike("paymentAck", paymentAck, MatchMode.ANYWHERE));
        if (cvqAck != null && !cvqAck.equals(""))
            criterionList.add(Restrictions.ilike("cvqAck", cvqAck, MatchMode.ANYWHERE));
        else
            criterionList.add(Restrictions.ne("cvqAck",""));
        if (paymentDateStart != null)
            criterionList.add(paymentDateProperty.ge(paymentDateStart));
        if (paymentDateEnd != null)
            criterionList.add(paymentDateProperty.le(paymentDateEnd));
        if (cfaId != 0)
            criterionList.add(Restrictions.eq("cfaId", cfaId));
        if (broker != null && !broker.equals(""))
            criterionList.add(Restrictions.ilike("broker", broker, MatchMode.ANYWHERE));

        return findByCriteria(criterionList.toArray(new Criterion[]{}));
    }

    public Payment findByPaymentAck(String paymentAck) throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Payment.class);
        crit.add(Restrictions.eq("paymentAck", paymentAck));
        
        return (Payment) crit.uniqueResult();
    }
}
