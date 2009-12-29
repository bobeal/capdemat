package fr.cg95.cvq.service.request;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Node;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.DataState;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsRequester;
import fr.cg95.cvq.security.annotation.IsSubject;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestWorkflowService {

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

    /**
     * Dispatcher method to update request data  state.
     */
    void updateRequestDataState(@IsRequest final Long id, final DataState rs)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

    /**
     * Dispatcher method to update request state.
     */
    void updateRequestState(@IsRequest final Long id, RequestState rs, String motive)
        throws CvqException, CvqInvalidTransitionException,
            CvqObjectNotFoundException;

    /**
     * Set a request in pending state after edition by an ecitizen
     */
    void rewindWorkflow(@IsRequest Request request)
        throws CvqException, CvqInvalidTransitionException;

    /**
     * Get possible data state transitions from the given data state
     * (see {@link fr.cg95.cvq.business.request.DataState}).
     */
    DataState[] getPossibleTransitions(DataState ds);

    /**
     * Get possible state transitions from the given request state
     * (see {@link fr.cg95.cvq.business.request.RequestState}).
     *
     * @return an array of {@link fr.cg95.cvq.business.request.RequestState} objects
     */
    RequestState[] getPossibleTransitions(RequestState rs);

    /**
     * Return the list of states that precede the given state.
     */
    Set<RequestState> getStatesBefore(RequestState rs);

    /**
     * Get the list of states for which request edition in BO is authorized.
     */
    List<RequestState> getEditableStates();

    /**
     * Return whether the given request is editable in FO.
     * 
     * Currently, a request is editable if it is in pending or uncomplete state
     * and is not a account creation or modification request.
     */
    boolean isEditable(@IsRequest final Long requestId) throws CvqObjectNotFoundException;
    
    /**
     * Get the list of states for which instruction is done.
     */
    List<RequestState> getInstructionDoneStates();

    RequestState[] getStatesExcludedForRequestsCloning();

    RequestState[] getStatesExcludedForRunningRequests();

    void createAccountCreationRequest(VoCardRequest dcvo, List<Adult> adults, List<Child> children, 
            List<Adult> foreignRoleOwners, final Address address, List<Document> documents) 
            throws CvqException;

    /**
     * Check if account modification is possible for the given home folder.
     * 
     * @throws CvqModelException if account modification is not possible
     */
    void isAccountModificationRequestAuthorized(final HomeFolder homeFolder) 
        throws CvqModelException;
    
    void createAccountModificationRequest(final HomeFolderModificationRequest hfmr,
            final List<Adult> adults, List<Child> children, List<Adult> foreignRoleOwners, 
            final Address adress, List<Document> documents)
        throws CvqException;
    
    /**
     * Create a new request from given data.
     * 
     * It is meant to be used <strong>only</strong> by requests who require an home folder, 
     * requester will be the currently logged in ecitizen, eventual subject id must be set
     * directly on request object.
     * 
     * A default implementation suitable for requests types that do not have any specific stuff 
     * to perform upon creation is provided. For others, the default implementation will have to
     * be overrided.
     */
    Long create(@IsRequest Request request) throws CvqException;

    /**
     * The same as {@link #create(Request)} but with a provided documents list.
     */
    Long create(@IsRequest Request request, List<Document> documents) throws CvqException;

    /**
     * Create a new request from given data.
     * 
     * It is meant to be used by requests issued outside an home folder. An home folder
     * containing at least the requester will be created. The subject is optional.
     */
    Long create(@IsRequest Request request, @IsRequester Adult requester)
        throws CvqException;

    /**
     * The same as {@link #create(Request, Adult, Individual)} but with a provided
     * documents list.
     */
    Long create(@IsRequest Request request, @IsRequester Adult requester, List<Document> documents)
        throws CvqException;

    /**
     * Get a set of home folder subjects that are authorized to be the subject of a request
     * of the type handled by current service.
     *
     * @return a map of home folder subjects or the home folder itself and authorized
     *                seasons if a request of the given type is issuable or null if not.
     */
    Map<Long, Set<RequestSeason>> getAuthorizedSubjects(RequestType requestType, 
            @IsHomeFolder Long homeFolderId) 
        throws CvqException, CvqObjectNotFoundException;

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
   Node getRequestClone(@IsSubject Long subjectId, @IsHomeFolder Long homeFolderId, String requestLabel)
            throws CvqException;

    /**
     * Edit a request.
     */
    void rewindWorkflow(@IsRequest Request request, List<Document> documents) throws CvqException;

    /**
     * Modify a request.
     */
    void modify(@IsRequest Request request) throws CvqException;

    /**
     * Remove permanently a request.
     */
    void delete(@IsRequest Long id) throws CvqException, CvqObjectNotFoundException;
}
