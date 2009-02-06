package fr.cg95.cvq.dao.users;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 * @author maxence.veyret@bull.net
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

    /**
     * Look up payments given a set of search criteria.
     *
     * @param criteria a set of {@link fr.cg95.cvq.util.Critere} criteria
     * @param sort an optional string to sort results on
     * @param dir sort direction (asc or desc)
     * @param recordsReturned number of records to return (-1 for all)
     * @param startIndex start index of the records to return
     * @param paymentMode (Internet or Card, null for all) 
     */    
    public List<Payment> search(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex, final PaymentMode paymentMode);
    
    /**
     * Return the number of payments that match a set of search criteria.
     */
    Long count(final Set<Critere> criteria, final PaymentMode paymentMode);
}
