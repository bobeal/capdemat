package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleEnum;
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
     * 
     * FIXME : unused ?
     */
    HomeFolder create(Adult adult)
        throws CvqException;

    /**
     * Create a fresh new home folder from a set of adults and children.
     * It is called upon the issuing of an home folder creation request.
     */
    HomeFolder create(Set<Adult> adults, Set<Child> children, Address address)
        throws CvqException, CvqModelException;

    Long addChild(final Long homeFolderId, Child child, Address address)
        throws CvqException;
    
    Long addAdult(final Long homeFolderId, Adult adult, Address address)
        throws CvqException;

    Set<HomeFolder> getAll()
        throws CvqException;

    HomeFolder getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    void modify(final HomeFolder homeFolder)
        throws CvqException;

    void delete(final Long id)
    	throws CvqException, CvqObjectNotFoundException;

    void deleteIndividual(final Long individualId)
        throws CvqException, CvqObjectNotFoundException;
    
    Set<Child> getChildren(final Long homeFolderId)
        throws CvqException;

    Set<Adult> getAdults(final Long homeFolderId)
        throws CvqException;
    
    List<Individual> getIndividuals(final Long homeFolderId)
        throws CvqException;
    
    // Role-related methods
    /////////////////////////////////////
    
    void addHomeFolderRole(final Long ownerId, final Long homeFolderId, final RoleEnum role)
        throws CvqException;
    
    void addHomeFolderRole(final Individual owner, final Long homeFolderId, final RoleEnum role)
        throws CvqException;

    void addIndividualRole(final Long ownerId, final Individual individual, final RoleEnum role)
        throws CvqException;
    
    void addIndividualRole(final Individual owner, final Individual individual, final RoleEnum role)
        throws CvqException;

    void removeRolesOnSubject(final Long homeFolderId, final Long individualId)
        throws CvqException;    

    boolean removeHomeFolderRole(final Long ownerId, final Long homeFolderId,
            final RoleEnum role)
        throws CvqException;
    
    boolean removeIndividualRole(final Long ownerId, final Individual individual, 
            final RoleEnum role)
        throws CvqException;
    
    /**
     * Perform the checking and finalization on the roles each of the given individual 
     * has on this home folder.
     * 
     * For roles on transient objects (home folder or individual), it will set the correct
     * identifier values.
     */
    void checkAndFinalizeRoles(Long homeFolderId, Set<Adult> adults, Set<Child> children)
        throws CvqException, CvqModelException;

    boolean hasHomeFolderRole(final Long ownerId, final Long homeFolderId, final RoleEnum role)
        throws CvqException;
    
    boolean hasIndividualRole(final Long ownerId, final Individual individual, final RoleEnum role)
        throws CvqException;
    
    /**
     * Get the adult that has the 
     * {@link RoleEnum#HOME_FOLDER_RESPONSIBLE home folder responsible role} on the
     * given home folder.
     */
    Adult getHomeFolderResponsible(final Long homeFolderId)
        throws CvqException;
    
    List<Individual> getByHomeFolderRole(Long homeFolderId, RoleEnum role);

    List<Individual> getBySubjectRole(Long subjectId, RoleEnum role);

    List<Individual> getBySubjectRoles(Long subjectId, RoleEnum[] roles);

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
     * Called by the request service to notify that a request has been validated.
     * 
     * It is then up to the home folder service to take the correct decisions : either delete
     * the associated, either do nothing.
     */
    void onRequestValidated(final Long homeFolderId, final Long requestId)
        throws CvqException;
    
    /**
     * Called by the request service to notify that a request has been cancelled.
     * 
     * It is then up to the home folder service to take the correct decisions : either delete
     * the associated, either do nothing.
     */
    void onRequestCancelled(final Long homeFolderId, final Long requestId)
        throws CvqException;
    
    /**
     * Called by the request service to notify that a request has been rejected.
     * 
     * It is then up to the home folder service to take the correct decisions : either delete
     * the associated, either do nothing.
     */
    void onRequestRejected(final Long homeFolderId, final Long requestId)
        throws CvqException;
    
    /**
     * Called by the request service to notify that a request has been archived.
     * 
     * It is then up to the home folder service to take the correct decisions : either delete
     * the associated, either do nothing.
     */
    void onRequestArchived(final Long homeFolderId, final Long requestId)
        throws CvqException;
    
    /**
     * Called by the request service to notify that a request has been deleted.
     * 
     * It is then up to the home folder service to take the correct decisions : either delete
     * the associated, either do nothing.
     */
    void onRequestDeleted(final Long homeFolderId, final Long requestId)
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
	 * Send a confirmation mail to the home folder's responsible when the payment is commited.
	 */
    void notifyPaymentByMail(Payment payment)
    	throws CvqException;
}
