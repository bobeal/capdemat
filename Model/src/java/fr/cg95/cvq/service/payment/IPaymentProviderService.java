package fr.cg95.cvq.service.payment;

import java.net.URL;
import java.util.Map;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;

public interface IPaymentProviderService {

    /**
     * Called whenever a new payment is asked for. 
     * 
     * Providers must set the internal payment reference 
     * ({@link Payment#setCvqReference(String)}) and return the URL to which the
     * payment will be done.
     */
    URL doInitPayment(final Payment payment, final PaymentServiceBean paymentServiceBean) 
        throws CvqException;
    
    /**
     * Called whenever a payment result is received. 
     * 
     * Providers must return the payment status (one of 
     * {@link IPaymentService#OK_RETURN}, {@link IPaymentService#CANCELLED_RETURN},
     * {@link IPaymentService#REFUSED_RETURN} or {@link IPaymentService#UNKNOWN_RETURN}).
     *
     * @param parameters parameters specific to the current payment provider.
     */
    PaymentResultBean doCommitPayment(final Map<String, String> parameters, 
            final PaymentServiceBean paymentServiceBean) 
        throws CvqException;
    
    /**
     * Initialization callback called for each declared local authority.
     *
     * It's then up to the payment service to check that it has all the configuration
     * parameters required to function properly.
     */
    void checkConfiguration(final PaymentServiceBean paymentServiceBean)
        throws CvqConfigurationException;
    
    /**
     * Get the payment mode this provider is associated to.
     * 
     * @see PaymentMode
     */
    PaymentMode getPaymentMode();
    
    boolean handleParameters(final Map<String, String> parameters);
    
    PaymentResultStatus getStateFromParameters(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException;
}
