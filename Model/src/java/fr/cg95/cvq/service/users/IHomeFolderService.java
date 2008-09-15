package fr.cg95.cvq.service.users;

import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * Service related to the management of home folders.
 *
 * @author bor@zenexity.fr
 */
public interface IHomeFolderService {

    /** service name used by Spring's application context. */
    String SERVICE_NAME = "homeFolderService";

    /**
     * Create a fresh new home folder containing only the given adult.
     */
    HomeFolder create(final Adult adult)
        throws CvqException;

    /**
     * Create a fresh new home folder from a set of adults and children
     */
    HomeFolder create(Set<Adult> adults, Set<Child> children, Address address)
        throws CvqException, CvqModelException;
    
    /**
     * Initialize home folder's common attributes (state, ...).
     */
    void initializeCommonAttributes(HomeFolder homeFolder)
        throws CvqException;
    
    Set<HomeFolder> getAll()
        throws CvqException;

    HomeFolder getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    HomeFolder getByRequestId(final Long requestId)
        throws CvqException;

    /**
     * Get documents associated to an home folder.
     *
     * As they are not automatically loaded from DB, they have to be explicitely
     * asked for.
     *
     * @return a set of {@link fr.cg95.cvq.business.document.Document documents}.
     */
    Set getAssociatedDocuments(final Long homeFolderId)
        throws CvqException, CvqObjectNotFoundException;

    void modify(final HomeFolder homeFolder)
        throws CvqException;

    void delete(final Long id)
    		throws CvqException, CvqObjectNotFoundException;

    void delete(final HomeFolder homeFolder)
    		throws CvqException, CvqObjectNotFoundException;

    Set<Child> getChildren(final Long homeFolderId)
        throws CvqException;

    Set<Adult> getAdults(final Long homeFolderId)
        throws CvqException;
    
    /**
     * Get external accounts information and state for the given home folder. Designed
     * to be called by an ecitizen from the Front Office.
     *
     * @param type the "account type" for which we want information (one of
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_INVOICES}, 
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS},
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_TICKETING_ACCOUNTS}
     *
     */
    Set<ExternalAccountItem> getExternalAccounts(final Long homeFolderId, final String type)
        throws CvqException;

    Map<Individual, Map<String, String> > getIndividualExternalAccountsInformation(final Long homeFolderId)
        throws CvqException;
    
    /**
     * Load the details of operations performed on this deposit account. Details
     * are directly loaded into the provided object.
     */
    void loadExternalDepositAccountDetails(ExternalDepositAccountItem edai)
        throws CvqException;
    
    /**
     * Load the details of items paid along with this invoice. Details
     * are directly loaded into the provided object.
     */
    void loadExternalInvoiceDetails(ExternalInvoiceItem eii)
        throws CvqException;

    /**
     * Validate an home folder and its associated individuals.
     */
    void validate(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Validate an home folder and its associated individuals.
     */
    void validate(HomeFolder homeFolder)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Invalidate an home folder and its associated individuals.
     */
    void invalidate(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Invalidate an home folder and its associated individuals.
     */
    void invalidate(HomeFolder homeFolder)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Disable an home folder and its associated individuals and requests.
     */
    void archive(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Disable an home folder and its associated individuals and requests.
     */
    void archive(HomeFolder homeFolder)
        throws CvqException, CvqObjectNotFoundException;
    
	/**
	 * Send a confirmation mail to the HomeFolder Responsible when the paymen is commited
	 */
    public void notifyPaymentByMail(Payment payment)
    	throws CvqException;
}
