package fr.cg95.cvq.service.request;

import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestAdminAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestActionService {

    /**
     * Get a specific action by ID.
     */
    RequestAction getAction(@IsRequest final Long requestId, final Long id) throws CvqObjectNotFoundException;

    /**
     * Get the last RequestAction by type.
     * @param requestId
     * @param type
     * @param state
     * @return
     */
    RequestAction getLastAction(@IsRequest final Long requestId, final RequestActionType type, final RequestState state);

    /**
     * Get the first RequestAction by type.
     * @param requestId
     * @param type
     * @param state
     * @return
     */
    RequestAction getFirstAction(@IsRequest final Long requestId, final RequestActionType type, final RequestState state);

    /**
     * Return whether the given request has an action trace with the given type.
     */
    boolean hasAction(@IsRequest final Long requestId, final RequestActionType type)
        throws CvqException;

    void addDraftCreationAction(@IsRequest Long requestId, Date date);

    /**
     * Add a creation action for the given request.
     *
     * Separated from other workflow actions because of authorizations concerns.
     */
    void addCreationAction(final Long requestId, final Date date, final byte[] pdfData, final String note);

    /**
     * Add a workflow action for the given request.
     */
    void addWorfklowAction(@IsRequest final Long requestId, final String note, final Date date,
            final RequestState resultingState, final byte[] pdfData);

    /**
     * Add an (non-workflow) action trace for the given request.
     * @param filename TODO
     */
    void addAction(@IsRequest final Long requestId, final RequestActionType type,
        final String message, final String note, final byte[] pdfData, String filename);

    /**
     * Add a system action trace for the given request.
     */
    void addSystemAction(@IsRequest final Long requestId,
        final RequestActionType type);

    List<RequestAdminAction> getAdminActions();
}
