package fr.cg95.cvq.service.request;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Node;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.DataState;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsRequester;
import fr.cg95.cvq.security.annotation.IsSubject;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.annotation.IsRequestType;
import fr.cg95.cvq.util.Critere;

/**
 * High level service interface to deal with requests.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IRequestService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "requestService";
    
    String REQUEST_CREATION_NOTIFICATION = "REQUEST_CREATION_NOTIFICATION";
    String REQUEST_ORANGE_ALERT_NOTIFICATION = "REQUEST_ORANGE_ALERT_NOTIFICATION";
    String REQUEST_RED_ALERT_NOTIFICATION = "REQUEST_RED_ALERT_NOTIFICATION";
    String CREATION_ACTION = "CREATION_ACTION";
    String STATE_CHANGE_ACTION = "STATE_CHANGE_ACTION";
    String REQUEST_CONTACT_CITIZEN = "REQUEST_CONTACT_CITIZEN";
    
    /** 
     * Subject policy for request types that have a whole account (aka home folder) as subject.
     */
    String SUBJECT_POLICY_NONE = "SUBJECT_POLICY_NONE";
    /** 
     * Subject policy for request types that have an individual (adult or child) as subject.
     */
    String SUBJECT_POLICY_INDIVIDUAL = "SUBJECT_POLICY_INDIVIDUAL";
    /** 
     * Subject policy for request types that have an adult as subject.
     */
    String SUBJECT_POLICY_ADULT = "SUBJECT_POLICY_ADULT";
    /** 
     * Subject policy for request types that have a child as subject.
     */
    String SUBJECT_POLICY_CHILD = "SUBJECT_POLICY_CHILD";
    
    /** @deprecated */
    String VO_CARD_REGISTRATION_REQUEST = "VO Card Request";
    /** @deprecated */
    String HOME_FOLDER_MODIFICATION_REQUEST = "Home Folder Modification Request";

    //////////////////////////////////////////////////////////
    // CRUD related methods
    //////////////////////////////////////////////////////////

    /**
     * Create a new request from given data.
     * 
     * @param subject an optional individual for requests where it is applicable.
     */
    Long create(@IsRequest Request request, @IsRequester final Long requesterId, 
            @IsSubject Individual subject)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * @deprecated
     */
    Long create(final Node node) throws CvqException;

    /**
     * Get a clone of a request with the given label whose subject is either the given subject 
     * either the given home folder (depending on the subject policy supported by the associated
     * request type).
     * 
     * @param subjectId optional subject id
     * @param homeFolderId optional home folder id
     * @param requestLabel mandatory label of the request type
     * 
     * @return a new request without administrative and persistence information.
     * 
     * TODO REFACTORING : maybe return type will have to be migrated to a Request object
     */
    Node getRequestClone(@IsSubject final Long subjectId, @IsHomeFolder Long homeFolderId, 
            final String requestLabel) 
    	throws CvqException;
    
    /**
     * Modify a request.
     */
    void modify(@IsRequest Request request)
        throws CvqException;

    /**
     * Remove permanently a request.
     */
    void delete(@IsRequest final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get a constrained list of requests according to a set of criteria and requirements.
     *
     * @param criteriaSet a set of {@link Critere criteria} to be applied to the search
     * @param sort an ordering to apply to results. value is one of the SEARCH_* static
     *        string defined in this service (null to use default sort on requests ids)
     * @param dir the direction of the sort (asc or desc, asc by default)
     * @param recordsReturned the number of records to return (-1 to get all results)
     * @param startIndex the start index of the records to return
     */
    List<Request> get(Set<Critere> criteriaSet, final String sort, final String dir, 
            final int recordsReturned, final int startIndex)
        throws CvqException;

    /**
     * Get a count of requests matching the given criteria.
     */
    Long getCount(Set<Critere> criteriaSet) throws CvqException;
    
    /**
     * Get a request by id.
     */
    Request getById(@IsRequest final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get requests by requester's id.
     */
    List<Request> getByRequesterId(@IsRequester final Long requesterId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get requests by subject's id.
     */
    List<Request> getBySubjectId(@IsSubject final Long subjectId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get all requests of the given type issued for the given subject.
     * @param retrieveArchived
     */
    List<Request> getBySubjectIdAndRequestLabel(@IsSubject final Long subjectId, 
            final String requestLabel, final boolean retrieveArchived)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get all requests belonging to the given home folder.
     */
    List<Request> getByHomeFolderId(@IsHomeFolder final Long homeFolderId)
    		throws CvqException, CvqObjectNotFoundException;

    /**
     * Get all requests of the given type belonging to the given home folder.
     */
    List<Request> getByHomeFolderIdAndRequestLabel(@IsHomeFolder final Long homeFolderId, 
            final String requestLabel)
            throws CvqException, CvqObjectNotFoundException;
    
    //////////////////////////////////////////////////////////
    // Notes, actions and documents related methods
    //////////////////////////////////////////////////////////
    
    /**
     * Get notes related to a given request.
     *
     * @return a set of {@link fr.cg95.cvq.business.users.RequestNote} objects
     */
    List<RequestNote> getNotes(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Add a note to a request.
     *
     * @param requestId the request to which note has to be added
     * @param rnt the type of the note
     * @param note the body of the note itself
     */
    void addNote(@IsRequest final Long requestId, final RequestNoteType rnt, final String note)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Add a set of documents to a request.
     *
     * @param requestId the request to which documents have to be linked
     * @param documentsId a set of documents id that must have been created with
     *        the creation method provided by the
     *        {@link fr.cg95.cvq.service.document.IDocumentService} service
     */
    void addDocuments(@IsRequest final Long requestId, final Set<Long> documentsId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Add a single document to a request.
     *
     * @param requestId the request to which the document has to linked
     * @param documentId a document that must have been created with the creation
     *  method provided by the {@link fr.cg95.cvq.service.document.IDocumentService} service
     */
    void addDocument(@IsRequest final Long requestId, final Long documentId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get actions related to a given request.
     */
    List<RequestAction> getActions(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Add an (non-workflow) action trace for the given request.
     */
    void addAction(@IsRequest final Long requestId, final String label, final String note)
        throws CvqException;
    
    /**
     * Get references of documents associated to a request.
     *
     * As they are not automatically loaded from DB, they have to be explicitely
     * asked for.
     */
    Set<RequestDocument> getAssociatedDocuments(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Get the generated certificate for the given request at the given step.
     */
    byte[] getCertificate(@IsRequest final Long requestId, final RequestState requestState)
        throws CvqException;

    //////////////////////////////////////////////////////////
    // General request information related methods
    //////////////////////////////////////////////////////////

    /**
     * Get a list of all existing requests types.
     * 
     * TODO ACMF
     */
    List<RequestType> getAllRequestTypes()
        throws CvqException;

    /**
     * Get a request type by id.
     */
    RequestType getRequestTypeById(@IsRequestType final Long requestTypeId)
        throws CvqException;

    /**
     * Get a request type by label.
     * 
     * @deprecated use {@link #getRequestTypeById(Long)} instead
     */
    RequestType getRequestTypeByLabel(final String requestLabel)
        throws CvqException;

    /**
     * Get the list of requests types handled by the given category in the given activation state.
     * 
     * TODO ACMF
     */
    List<RequestType> getRequestsTypes(final Long categoryId, final Boolean active)
        throws CvqException;

    /**
     * Modify a request type properties.
     */
    void modifyRequestType(@IsRequestType RequestType requestType)
        throws CvqException;

    /**
     * Modify a requirement associated to a request type.
     */
    void modifyRequestTypeRequirement(@IsRequestType final Long requestTypeId, 
            Requirement requirement)
        throws CvqException;

    /**
     * Add a new requirement to the given request type.
     */
    void addRequestTypeRequirement(@IsRequestType final Long requestTypeId, 
            Requirement requirement)
        throws CvqException;
    
    /**
     * Remove the requirement between the given request type and document type.
     */
    void removeRequestTypeRequirement(@IsRequestType final Long requestTypeId, 
            Long documentTypeId)
        throws CvqException;
    
    /**
     * Get a list of documents types allowed for a given request type.
     */
    Set<DocumentType> getAllowedDocuments(@IsRequestType final Long requestTypeId)
        throws CvqException;

    //////////////////////////////////////////////////////////
    // Seasons related methods
    //////////////////////////////////////////////////////////

    boolean isRegistrationOpen(@IsRequestType final Long requestTypeId) throws CvqException;
    
    /**
     * Associate a new season to requestType
     * 
     * @throws CvqException
     * <br><br>
     * Expected business error code are :
     * <dl>
     *   <dt>request.season.not_supported</dt>
     *     <dd>Request Type don't support season management</dd>
     *   <dt>request.season.seasons_registration_overlapped</dt>
     *     <dd>Season registration dates overlap an other season registration dates</dd>
     *   <dt>request.season.seasons_effect_overlapped</dt>
     *     <dd>Season effect dates overlap an other season effect dates</dd>
     *   <dt>request.season.registration_start_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_end_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_start_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_end_required</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_start_after_registration_end</dt>
     *     <dd>-</dd>
     *   <dt>request.season.effect_start_after_effect_end</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_start_after_effect_start</dt>
     *     <dd>-</dd>
     *   <dt>request.season.registration_end_after_effect_end</dt>
     *     <dd>-</dd>
     *   <dt>registration_start_before_now</dt>
     *     <dd>Season registration start is define in past</dd>
     *   <dt>request.season.already_used_label</dt>
     *     <dd>-</dd>
     * </dl>
     */
    void addRequestTypeSeason(@IsRequestType final Long requestTypeId, RequestSeason requestSeason)
        throws CvqException;

    /**
     * Modify a season associate to requestType
     * 
     * @param requestSeason - Don't forget to set season's uuid. It's use to identify season.
     * @throws CvqException
     * <br><br>
     * Refer to createRequestTypeSeasons  business error code.
     * <br>
     * Specific business error code:
     * <dl>
     *   <dt>request.season.effect_ended</dt>
     *     <dd>Season effect end has been occured (only in modify season context)</dd>
     *   <dt>request.season.registration_started</dt>
     *     <dd>Season effect end has been occured (only in modify season context)</dd>
     * </dl>
     */
    void modifyRequestTypeSeason(@IsRequestType final Long requestTypeId, 
            RequestSeason requestSeason)
        throws CvqException;
    
    void removeRequestTypeSeason(@IsRequestType final Long requestTypeId, 
            final String requestSeasonUuid)
        throws CvqException;
    
    /**
     * Return the season associated to the given request, null if none.
     */
    RequestSeason getRequestAssociatedSeason(@IsRequest Long requestId) throws CvqException;
    
    //////////////////////////////////////////////////////////
    // RequestForm related Methods
    //////////////////////////////////////////////////////////
    
    /**
     * TODO ACMF
     */
    RequestForm getRequestFormById(Long id) throws CvqException;
    
    /**
     * TODO : make its contract more explicit.
     * TODO : ACMF
     */
    File getTemplateByName(String name);
    
    /**
     * TODO : make its contract more explicit.
     * TODO : ACMF
     */
    List<File> getMailTemplates(String pattern) throws CvqException;
    
    /**
     * Method that process request form update/creation. 
     * 
     * Defines by itself which kind of processing has to be produced.
     * 
     * @return request form id
     */
    Long modifyRequestTypeForm(@IsRequestType Long requestTypeId, 
            RequestForm requestForm) throws CvqException;
    
    /**
     * Remove a request form.
     * 
     * TODO : unused currently but should be
     */
    void removeRequestTypeForm(@IsRequestType final Long requestTypeId, final Long requestFormId)
        throws CvqException;
    
    /**
     * Remove a request form.
     * 
     * @deprecated use {@link #removeRequestTypeForm(Long, Long)} instead
     */
    void removeRequestTypeForm(final Long requestFormId) throws CvqException;
    
    /**
     * Get request forms by request type and type of request form.
     */
    List<RequestForm> getRequestTypeForms(@IsRequestType final Long requestTypeId, 
            RequestFormType requestFormType) throws CvqException;
    
    
    //////////////////////////////////////////////////////////
    // Payment & activities related methods
    //////////////////////////////////////////////////////////

    /**
     * Called by payment service on the reception of a payment operation status.
     *
     * If payment is successful, performs the following :
     * <ul>
     *  <li>Notify service associated to request type</li>
     *  <li>Notify external services</li>
     * </ul>
     */
    void notifyPaymentResult(final Payment payment) throws CvqException;
    
    /**
     * Return whether given request type can provide consumptions summary.
     */
    boolean hasMatchingExternalService(final String requestLabel)
        throws CvqException;

    /**
     * Get consumption events for a given request.
     */
    Map<Date, String> getConsumptionsByRequest(@IsRequest final Long requestId, 
            final Date dateFrom, final Date dateTo)
        throws CvqException;

    String getConsumptionsField()
        throws CvqException;

    //////////////////////////////////////////////////////////
    // Workflow related methods
    //////////////////////////////////////////////////////////

    /**
     * Dispatcher method to update request data  state.
     */
    void updateRequestDataState(@IsRequest final Long id, final DataState rs)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;
    
    /**
     * Get possible data state transitions from the given data state
     * (see {@link fr.cg95.cvq.business.request.DataState}).
     */
    DataState[] getPossibleTransitions(DataState ds);
    
    /**
     * Get a set of home folder subjects that are authorized to be the subject of a request
     * of the type handled by current service.
     *
     * @return a map of home folder subjects or the home folder itself and authorized
     *                seasons if a request of the given type is issuable or null if not.
     */
    Map<Object, Set<RequestSeason>> getAuthorizedSubjects(@IsHomeFolder final Long homeFolderId)
        throws CvqException, CvqObjectNotFoundException;
    
    /**
     * Dispatcher method to update request state.
     */
    void updateRequestState(@IsRequest final Long id, RequestState rs, String motive)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;
    
    /**
     * Set the request state to complete.
     * (see {@link fr.cg95.cvq.business.request.RequestState})
     */
    void complete(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    void complete(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;
    
    /**
     * Ask for more information about a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void specify(@IsRequest final Long id, final String motive)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    void specify(@IsRequest final Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    /**
     * Validate a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void validate(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    void validate(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    /**
     * Notify a user its request has been validated
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void notify(@IsRequest final Long id, final String motive)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    void notify(@IsRequest final Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException;

    /**
     * Cancel a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void cancel(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    void cancel(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException;
    
    /**
     * Activate a request.
     * 
     * @see RequestState#ACTIVE
     */
    void activate(@IsRequest final Long id) 
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;
    
    /**
     * Activate a request.
     * 
     * @see RequestState#ACTIVE
     */
    void activate(@IsRequest final Request request) 
        throws CvqException, CvqInvalidTransitionException;
    
    /**
     * Expire a request.
     * 
     * @see RequestState#EXPIRED
     */
    void expire(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    /**
     * Expire a request.
     * 
     * @see RequestState#EXPIRED
     */
    void expire(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException;
    
    /**
     * Reject the validation of a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void reject(@IsRequest final Long id, final String motive)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    void reject(@IsRequest final Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException;
    
    /**
     * Close a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void close(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException;

    void close(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    /**
     * Archive a request
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     */
    void archive(@IsRequest final Long id)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    void archive(@IsRequest final Request request)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    /**
     * Archive all requests belonging to the given {@link HomeFolder home folder}.
     */
    void archiveHomeFolderRequests(@IsHomeFolder final HomeFolder homeFolder)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    /**
     * Get possible state transitions from the given request state
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     *
     * @return an array of {@link fr.cg95.cvq.business.request.RequestState}
     *         objects
     */
    RequestState[] getPossibleTransitions(RequestState rs);

    /**
     * Return the list of states that precede the given state.
     */
    public Set<RequestState> getStatesBefore(RequestState rs);

    //////////////////////////////////////////////////////////////////
    // Properties set by configuration in Spring's application context
    //////////////////////////////////////////////////////////////////

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
     * {@link #SUBJECT_POLICY_NONE}, {@link #SUBJECT_POLICY_INDIVIDUAL},
     * {@link #SUBJECT_POLICY_ADULT} or {@link #SUBJECT_POLICY_CHILD}.
     * 
     * If not overrided in the service configuration, defaults to
     * {@link #SUBJECT_POLICY_NONE}.
     *   
     */
    String getSubjectPolicy();
    
    /**
     * Whether the request type handled by current service is of registration
     * kind.
     */
    boolean isOfRegistrationKind();

    // ////////////////////////////////////////////////////////
    // Methods to be overridden by implementing services
    // ////////////////////////////////////////////////////////

    /**
     * Chain of responsabilities pattern.
     */
    boolean accept(Request request);

    /**
     * Return a fresh new request object of the type managed by the implementing class.
     * This method must be implemented by classes implementing this interface.
     */
    Request getSkeletonRequest() throws CvqException;
    
    void onPaymentValidated(Request request, String paymentReference) throws CvqException;
    
    void onPaymentRefused(Request request) throws CvqException;

    void onPaymentCancelled(Request request) throws CvqException;

    /**
     * Realize specific task, just after the call 'sendRequest' method in
     * 'ExternalService'.
     */
    void onExternalServiceSendRequest(Request request, String sendRequestResult) 
        throws CvqException;
}
