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
    RequestAction getAction(@IsRequest final Long requestId, final Long id)
        throws CvqObjectNotFoundException;

    /**
     * Return whether the given request has an action trace with the given type.
     */
    boolean hasAction(@IsRequest final Long requestId, final RequestActionType type)
        throws CvqException;

    void addDraftCreationAction(@IsRequest Long requestId, Date date)
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
     * @param filename TODO
     */
    void addAction(@IsRequest final Long requestId, final RequestActionType type,
        final String message, final String note, final byte[] pdfData, String filename)
        throws CvqException;

    /**
     * Add a system action trace for the given request.
     */
    void addSystemAction(@IsRequest final Long requestId,
        final RequestActionType type)
        throws CvqException;

    List<RequestAdminAction> getAdminActions();
}
