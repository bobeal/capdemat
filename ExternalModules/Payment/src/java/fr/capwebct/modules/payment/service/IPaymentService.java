package fr.capwebct.modules.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.ws.PaymentTransaction;

public interface IPaymentService {

    Payment getByPaymentAck(final String paymentAck) throws DataAccessException;
    
    List<Payment> getAllPayments() throws DataAccessException;

    /**
     * @fixme externalApplicationId is currently unused
     */
    List<Payment> search(final Date paymentDateStart, final Date paymentDateEnd, 
            final String paymentAck, final String cvqAck, final long externalApplicationId, 
            final String broker) 
        throws DataAccessException;
    
    void savePayment(Payment payment) throws DataAccessException;
    
    void deletePayment(Payment payment) throws DataAccessException;
    
    void deleteAllPayments() throws DataAccessException;
    
    /**
     * Called upon credit operations received from CapWebCT.
     */
    void creditFamilyAccount(PaymentTransaction paymentTransaction) throws DataAccessException;
    
    void exportPayments() throws DataAccessException;
}
