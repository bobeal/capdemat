package fr.cg95.cvq.service.request;

import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * High level service interface to deal with requests.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IRequestService {

    /////////////////////////////////////
    // Methods handled by the base class
    /////////////////////////////////////

    /**
     * Return a string used to uniquely identify the service.
     */
    String getLabel();

    /**
     * Return name of the XSL-FO file used to render request certificate.
     */
    String getXslFoFilename();
    
    /**
     * Return the file name of local referential data specific to this request type (or null if
     * none defined).
     */
    String getLocalReferentialFilename();

    /**
     * Return the file name of place reservation referential data specific to this request type 
     * (or null if none defined).
     */
    String getPlaceReservationFilename();

    /**
     * Return the file name of external referential data specific to this request type (or null
     * if not defined)
     */
    String getExternalReferentialFilename();
    
    /**
     * Whether the request type handled by current service authorizes creation operation without 
     * having already an account.
     */
    boolean supportUnregisteredCreation();
    
    /**
     * Return the subject policy supported by the current service, one of
     * {@link IRequestWorkflowService#SUBJECT_POLICY_NONE}, {@link IRequestWorkflowService#SUBJECT_POLICY_INDIVIDUAL},
     * {@link IRequestWorkflowService#SUBJECT_POLICY_ADULT} or {@link IRequestWorkflowService#SUBJECT_POLICY_CHILD}.
     * 
     * If not overrided in the service configuration, defaults to
     * {@link IRequestWorkflowService#SUBJECT_POLICY_NONE}.
     *   
     */
    String getSubjectPolicy();
    
    /**
     * Whether the request type handled by current service is of registration
     * kind.
     */
    boolean isOfRegistrationKind();

    String getDefaultDisplayGroup();

    Map<String,IConditionChecker> getConditions();

    ///////////////////////////////////////////////////////////
    // Methods that must be overridden by implementing services
    ///////////////////////////////////////////////////////////

    /**
     * Chain of responsabilities pattern.
     */
    boolean accept(Request request);

    /**
     * Return a fresh new request object of the type managed by the implementing class.
     * This method must be implemented by classes implementing this interface.
     */
    Request getSkeletonRequest() throws CvqException;
    
    ///////////////////////////////////////////////////////////
    // Methods that may be overridden by implementing services
    ///////////////////////////////////////////////////////////

    /**
     * Hook called after common business checks and before persisting the request.
     * 
     * Can be used to perform specific business checks or logic.
     */
    void onRequestCreated(Request request) throws CvqException;

    void onRequestModified(Request request) throws CvqException;
    
    /**
     * Hook called before validating the request.
     * 
     * Can be used to perform specific business checks or logic.
     */
    void onRequestValidated(Request request) throws CvqException;

    void onRequestCancelled(Request request) throws CvqException;
    
    void onRequestRejected(Request request) throws CvqException;

    /**
     * Hook called after a validated payment is received.
     * 
     * @return true if associated request has to be validated.
     */
    boolean onPaymentValidated(Request request, String paymentReference) throws CvqException;
    
    /**
     * Hook called after a refused payment is received.
     * 
     * @return true if associated request has to be rejected.
     */
    boolean onPaymentRefused(Request request) throws CvqException;

    /**
     * Hook called after a cancelled payment is received.
     * 
     * @return true if associated request has to be cancelled.
     */
    boolean onPaymentCancelled(Request request) throws CvqException;

    /**
     * Hook called just after the request has been sent to an external service.
     * 
     * @param sendRequestResult the result returned by the external service.
     */
    void onExternalServiceSendRequest(Request request, String sendRequestResult) 
        throws CvqException;
}
