package fr.cg95.cvq.service.document;

import java.util.Date;
import java.util.Set;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.exception.CvqBadPageNumberException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "documentService";

    String CREATION_ACTION = "CREATION_ACTION";
    String STATE_CHANGE_ACTION = "STATE_CHANGE_ACTION";
    
    Integer NO_TYPE = new Integer(0);
    Integer OLD_CNI_TYPE = new Integer(1);
    Integer SCHOOL_INSURANCE_TYPE = new Integer(2);
    Integer INSURANCE_CERTIFICATE_TYPE = new Integer(3);
    Integer VITAL_CARD_CERTIFICATE_TYPE = new Integer(4);
    Integer EXSPOUSE_PERMISSION_TYPE = new Integer(5);
    Integer TAXES_NOTIFICATION_TYPE = new Integer(6);
    Integer PAYROLL_TYPE = new Integer(7);
    Integer HEALTH_NOTEBOOK_TYPE = new Integer(8);
    Integer VACATING_CERTIFICATE_TYPE = new Integer(9);
    Integer SCHOOL_CERTIFICATE_TYPE = new Integer(10);
    Integer MEDICAL_CERTIFICATE_TYPE = new Integer(11);
    Integer FRENCH_NATIONALITY_ACQUISITION_TYPE = new Integer(12);
    Integer TUTOR_APPOINTMENT_DECLARATION_TYPE = new Integer(13);
    Integer ID_CARD_LOSS_DECLARATION_TYPE = new Integer(14);
    Integer BIRTH_CERTIFICATE_TYPE = new Integer(15);
    Integer ADOPTION_JUDGMENT_TYPE = new Integer(16);
    Integer SPECIFIC_REQUEST_RECEIPT_TYPE = new Integer(17);
    Integer FRENCH_NATIONALITY_RECEIPT_TYPE = new Integer(18);
    Integer FAMILY_NOTEBOOK_TYPE = new Integer(19);
    Integer BANK_IDENTITY_RECEIPT_TYPE = new Integer(20);
    Integer DOMICILE_RECEIPT_TYPE = new Integer(21);
    Integer IDENTITY_RECEIPT_TYPE = new Integer(22);
    Integer INDIVIDUAL_ALIGNMENT_CERTIFICATE_TYPE = new Integer(23);
    Integer BUILDING_SITUATION_PLAN_TYPE = new Integer(24);
    Integer GROUND_SITUATION_PLAN_TYPE = new Integer(25);
    Integer MASS_PLAN_TYPE = new Integer(26);
    Integer BANK_STATEMENT_TYPE = new Integer(27);
    Integer SAVING_ACCOUNT_TYPE = new Integer(28);
    Integer LOCATION_RECEIPT_TYPE = new Integer(29);
    Integer HOUSING_TAXES_NOTIFICATION_TYPE = new Integer(30);
    Integer REVENUE_TAXES_NOTIFICATION_TYPE = new Integer(31);
    Integer HANDICAP_CARD_TYPE = new Integer(32);
    Integer FAMILY_HELP_CERTIFICATE_TYPE = new Integer(33);
    Integer IDENTITY_PHOTO_TYPE = new Integer(34);
    
    /**
     * Add a document to the system.
     *
     * This step is only used to create the document's administrative information.
     * To add the document's binary data, use the {@link #addPage} method.
     *
     * @param document the document to add
     * @param homeFolderId an optional home folder to which this document
                           can be added
     * @param individualId an optional individual to which this document can
     *                     also be added
     *
     * @return the document's id
     */
    Long create(final Document document, final Long homeFolderId, final Long individualId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Modify an existing document
     *
     * @todo needs SSO to be finished
     */
    void modify(final Document document)
        throws CvqException;
	/**
     * Delete an existing document
     *
     * @todo needs SSO to be finished
     */
    void delete(final Long id)
        throws CvqException, CvqObjectNotFoundException;
    
    Set getAll()
        throws CvqException;

    Set get(final Set criteriaSet)
        throws CvqException;

    Document getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Add a page to an existing document.
     *
     * If no page is specified, add document binary at the last page
     *
     * @throws CvqBadPageNumberException if a page is specified for the
     *         binary but page already exists
     */
    Long addPage(final Long documentId,
                 final DocumentBinary documentBinary)
        throws CvqException, CvqObjectNotFoundException,
               CvqBadPageNumberException;

    /**
     * Modify a page of an existing document
     */
    void modifyPage(final Long documentId,
                    final DocumentBinary documentBinary)
        throws CvqException, CvqBadPageNumberException;

    /**
     * Remove a page from an existing document
     */
    void deletePage(final Long documentId,
                    final Integer pageId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get a specific page of an existing document
     */
    DocumentBinary getPage(final Long documentId,
                           final Integer pageId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get a the number of pages associated to an existing document
     */
    Integer getPagesNumber(final Long documentId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get all binary data associated to a document
     *
     * @return a set of {@link DocumentBinary} objects
     */
    Set getAllPages(final Long documentId)
        throws CvqException;

    /**
     * Get a document type by its id
     *
     * @param id the id of the document type, one among the (long) list of static
     *           integer constant defined in this class
     */
    DocumentType getDocumentTypeById(final Integer id)
        throws CvqException;

    /**
     * Get all known document types
     */
    Set getAllDocumentTypes()
        throws CvqException;

    /**
     * Get already provided documents for the given
     *       {@link fr.cg95.cvq.business.document.DocumentType}
     *
     * @param docType the document type to search for
     * @param homeFolderId the home folder for which we are searching
     * @param individualId an optional individual to restrict the search to
     *
     * @return a set of {@link fr.cg95.cvq.business.document.Document} objects
     */
    Set getProvidedDocuments(final DocumentType docType,
                             final Long homeFolderId,
                             final Long individualId)
        throws CvqException;

    /**
     * Check, for all known local authorities, that the end validity date of documents 
     * in state PENDING, CHECKED or VALIDATED has not been reached. If it has been reached,
     * the document state is set to OUTDATED.
     * 
     * This method is currently used by an internal job.
     */
    void checkDocumentsValidity() throws CvqException;

    /**
     * Validate a document
     *
     * @param id the document's id
     * @param validityDate the document's validity date. If none is provided, the
     *                     default value is used
     * @param message a optional message associated with the validation
     */
    void validate(final Long id, final Date validityDate,
                  final String message)
        throws CvqException, CvqObjectNotFoundException,
               CvqInvalidTransitionException;

    /**
     * Refuse the validation of a document
     *
     * @param id the document's id
     * @param message a mandatory message associated with the refusal
     */
    void refuse(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException,
               CvqInvalidTransitionException;

    /**
     * Notify that the document has been checked
     *
     * @param id the document's id
     * @param message a optional message (eg 'bring the original ones')
     */
    void check(final Long id, final String message)
        throws CvqException, CvqObjectNotFoundException,
               CvqInvalidTransitionException;

    /**
     * Set the document state to out of date when its validity duration has
     * been reached. This method should not be called directly. Instead, an
     * autonomous validity checker should do this stuff ...
     */
    void outDated(final Long id)
        throws CvqException, CvqObjectNotFoundException,
               CvqInvalidTransitionException;

    /**
     * Get possible state transitions from the given document state
     *
     * @return an array of {@link fr.cg95.cvq.business.document.DocumentState}
     *         objects
     * @see fr.cg95.cvq.business.document.DocumentState
     */
    DocumentState[] getPossibleTransitions(DocumentState rs)
        throws CvqException;
}
