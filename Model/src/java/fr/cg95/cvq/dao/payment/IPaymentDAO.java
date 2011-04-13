package fr.cg95.cvq.dao.payment;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.dao.jpa.IJpaTemplate;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public interface IPaymentDAO extends IJpaTemplate<Payment,Long> {

    /**
     * Find all payments associated to the given home folder.
     */
    List<Payment> findByHomeFolder(final Long homeFolderId);
    
    /**
     * Find the payment with the given internal reference.
     */
    Payment findByCvqReference(final String cvqReference);

    /**
     * Find the payment with the given bank reference.
     */
    Payment findByBankReference(final String bankReference);

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
     * Return the number of payments that match a set of search criteria.
     */
    Long count(final Set<Critere> criteria);

    Long invoicesCount(final Set<Critere> criteria);

    Long depositAccountsCount(final Set<Critere> criteria);

    Long ticketingContractsCount(final Set<Critere> criteria);

    /**
     * Search payments older than 3 hours that are still in initialized state.
     */
    List<Payment> searchNotCommited();

    List<ExternalAccountItem> searchTicketingContracts(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex);

    List<ExternalAccountItem> searchDepositAccounts(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex);

    List<ExternalAccountItem> searchInvoices(final Set<Critere> criteria, final String sort, String dir,
            int recordsReturned, int startIndex);
}
