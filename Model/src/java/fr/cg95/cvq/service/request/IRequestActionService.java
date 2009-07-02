package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

import java.util.Date;
import java.util.List;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestActionService {

    String DRAFT_DELETE_NOTIFICATION = "DRAFT_DELETE_NOTIFICATION";
    String REQUEST_CREATION_NOTIFICATION = "REQUEST_CREATION_NOTIFICATION";
    String REQUEST_ORANGE_ALERT_NOTIFICATION = "REQUEST_ORANGE_ALERT_NOTIFICATION";
    String REQUEST_RED_ALERT_NOTIFICATION = "REQUEST_RED_ALERT_NOTIFICATION";
    String CREATION_ACTION = "CREATION_ACTION";
    String STATE_CHANGE_ACTION = "STATE_CHANGE_ACTION";
    String REQUEST_CONTACT_CITIZEN = "REQUEST_CONTACT_CITIZEN";

    /**
     * Get all actions related to a given request.
     */
    List<RequestAction> getActions(@IsRequest final Long requestId)
        throws CvqException;

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
     * Return whether the given request has an action trace with the given label.
     */
    boolean hasAction(final Long requestId, final String label)
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
    void addAction(@IsRequest final Long requestId, final String label, final String note,
            final byte[] pdfData) throws CvqException;

    /**
     * Add a system action trace for the given request.
     */
    void addSystemAction(@IsRequest final Long requestId, final String label)
        throws CvqException;
}
