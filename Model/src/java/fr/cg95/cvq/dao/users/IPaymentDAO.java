package fr.cg95.cvq.dao.users;

import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public interface IPaymentDAO extends IGenericDAO {

    /**
     * Find all payments associated to the given home folder.
     */
    List findByHomeFolder(HomeFolder homeFolder);
    
    /**
     * Find the payment with the given internal reference.
     */
    Payment findByCvqReference(final String cvqReference);
    
    /**
     * Multi-criteria search amongst payments.
     */
    List search(Date initDateFrom, Date initDateTo, final Date commitDateFrom,
            final Date commitDateTo, final PaymentState paymentState, final String cvqReference, 
            final String bankReference, final String broker, final Long homeFolderId, 
            final String lastName);
    
    /**
     * Initialized but not commited search amongst payments
     */
    List searchNotCommited();
}
