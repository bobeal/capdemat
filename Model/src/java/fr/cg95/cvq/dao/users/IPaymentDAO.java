package fr.cg95.cvq.dao.users;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public interface IPaymentDAO extends IGenericDAO {

    /**
     * Find all payments associated to the given home folder.
     */
    List<Payment> findByHomeFolder(HomeFolder homeFolder);
    
    /**
     * Find the payment with the given internal reference.
     */
    Payment findByCvqReference(final String cvqReference);
    
    /**
     * Look up payments given a set of search criteria.
     *
     * @param criteria a set of {@link fr.cg95.cvq.util.Critere} criteria
     * @param sort an optional string to sort results on
     * @param dir sort direction (asc or desc)
     * @param recordsReturned number of records to return (-1 for all)
     * @param startIndex start index of the records to return
     */    
    List<Payment> search(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex);

    /**
     * Initialized but not commited search amongst payments.
     */
    List<Payment> searchNotCommited();   
    
    /**
     * Return the number of payments that match a set of search criteria.
     */
    Long count(final Set<Critere> criteria);
    
}
