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
    List search(final Date initDateFrom,final Date initDateTo, final Date commitDateFrom,
            final Date commitDateTo, final PaymentState paymentState, final String cvqReference, 
            final String bankReference, final String broker, final Long homeFolderId, 
            final String requesterLastName, final String sort, final String dir, 
            final int recordsReturned, final int startIndex);
    
    /**
     * Same as search method but only returns a count of total results.
     */
    Long count(final Date initDateFrom, final Date initDateTo, final Date commitDateFrom, 
            final Date commitDateTo, final PaymentState paymentState, final String cvqReference, 
            final String bankReference, final String broker, final Long homeFolderId, 
            final String requesterLastName);

    /**
     * Initialized but not commited search amongst payments.
     */
    List searchNotCommited();    
}
