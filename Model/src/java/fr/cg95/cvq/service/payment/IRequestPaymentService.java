package fr.cg95.cvq.service.payment;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

/**
 * Request that needs to redirect citizen to payment provider page
 * just after form's filling must implement this interface
 */
public interface IRequestPaymentService {

    Payment buildPayment(Request request) throws CvqException;

}
