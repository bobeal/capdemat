package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.annotation.IsRequestAction;

import java.util.Date;
import java.util.List;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestActionService {

    /**
     * Get all actions related to a given request.
     */
    List<RequestAction> getActions(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Get a specific action by ID.
     */
    RequestAction getAction(@IsRequestAction final Long id)
        throws CvqObjectNotFoundException;

    /**
     * Get the last workflow action related to the request, or null if it has none.
     */
    RequestAction getLastWorkflowAction(@IsRequest final Long requestId)
        throws CvqException;

    /**
     * Get action related to given request and resulting state.
     */
    RequestAction getActionByResultingState(@IsRequest final Long requestId,
            final RequestState requestState)
        throws CvqException;

    /**
     * Return whether the given request has an action trace with the given type.
     */
    boolean hasAction(final Long requestId, final RequestActionType type)
        throws CvqException;

    /**
     * Add a creation action for the given request.
     *
     * Separated from other workflow actions because of authorizations concerns.
     */
    void addCreationAction(final Long requestId, final Date date, final byte[] pdfData)
        throws CvqException;

    /**
     * Add a workflow action for the given request.
     */
    void addWorfklowAction(@IsRequest final Long requestId, final String note, final Date date,
            final RequestState resultingState, final byte[] pdfData)
        throws CvqException;

    /**
     * Add an (non-workflow) action trace for the given request.
     */
    void addAction(@IsRequest final Long requestId, final RequestActionType type,
        final String message, final String note, final byte[] pdfData)
        throws CvqException;

    /**
     * Add a system action trace for the given request.
     */
    void addSystemAction(@IsRequest final Long requestId,
        final RequestActionType type)
        throws CvqException;
}
