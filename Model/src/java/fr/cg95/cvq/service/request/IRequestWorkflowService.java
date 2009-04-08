package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.DataState;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.service.request.annotation.IsRequest;

import java.util.List;
import java.util.Set;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestWorkflowService {

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
     * Archive all requests belonging to the given {@link HomeFolder home folder}.
     */
    void archiveHomeFolderRequests(@IsHomeFolder final Long homeFolderId)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException;

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
     * Get the list of states for which request edition is authorized.
     */
    List<RequestState> getEditableStates();

    /**
     * Get the list of states for which instruction is done.
     */
    List<RequestState> getInstructionDoneStates();

    RequestState[] getStatesExcludedForRequestsCloning();

    RequestState[] getStatesExcludedForRunningRequests();

}
