package fr.capwebct.modules.payment.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Payment;

public interface IPaymentDAO extends IGenericDAO<Payment,Long>{

    Payment findByPaymentAck(final String paymentAck)
        throws DataAccessException;
    
    List<Payment> search(final Date paymentDateStart, final Date paymentDateEnd,
            final String paymentAck, final String cvqAck, final long cfaId, 
            final String broker) throws DataAccessException;
}
