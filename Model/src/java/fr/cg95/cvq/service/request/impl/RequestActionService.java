package fr.cg95.cvq.service.request.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestAdminAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestActionDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.IRequestActionService;

/**
 *
 * @author bor@zenexity.fr
 */
public class RequestActionService implements IRequestActionService {

    private IRequestActionDAO requestActionDAO;
    private IRequestDAO requestDAO;

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public RequestAction getAction(final Long requestId, final Long id)
        throws CvqObjectNotFoundException {
        // do not directly use requestActionDAO to enforce request access rights
        Request request = requestDAO.findById(requestId, false);
        for (RequestAction action : request.getActions()) {
            if (action.getId().equals(id))
                return action;
        }
        throw new CvqObjectNotFoundException();
    }

    @Override
    public boolean hasAction(final Long requestId, final RequestActionType type)
        throws CvqException {
        return requestActionDAO.hasAction(requestId, type);
    }

    @Override
    @Context(types = {ContextType.AGENT, ContextType.EXTERNAL_SERVICE}, privilege = ContextPrivilege.WRITE)
    public void addAction(final Long requestId, final RequestActionType type,
        final String message, final String note, final byte[] pdfData, String filename)
        throws CvqException {

        addActionTrace(type, message, note, new Date(), null, requestId, pdfData, filename);
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN}, privilege = ContextPrivilege.WRITE)
    public void addSystemAction(final Long requestId,
        final RequestActionType type)
        throws CvqException {

        addActionTrace(type, null, null, new Date(), null, requestId, null, null);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN}, privilege = ContextPrivilege.WRITE)
    public void addDraftCreationAction(Long requestId, Date date)
        throws CvqException {
        addActionTrace(RequestActionType.CREATION, null, null, date,
            RequestState.DRAFT, requestId, null, null);
    }

    @Override
    public void addCreationAction(Long requestId, Date date, byte[] pdfData, String note)
        throws CvqException {
        addActionTrace(RequestActionType.CREATION, null, note, date,
            RequestState.PENDING, requestId, pdfData, null);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT, ContextType.EXTERNAL_SERVICE},
            privilege = ContextPrivilege.WRITE)
    public void addWorfklowAction(final Long requestId, final String note, final Date date,
            final RequestState resultingState, final byte[] pdfData)
        throws CvqException {

        addActionTrace(RequestActionType.STATE_CHANGE, null, note, date,
            resultingState, requestId, pdfData, null);
    }

    private void addActionTrace(final RequestActionType type, final String message,
        final String note, final Date date, final RequestState resultingState,
        final Long requestId, final byte[] pdfData, String filename)
        throws CvqException {

        Request request = (Request) requestDAO.findById(Request.class, requestId);

        // retrieve user or agent id according to context
        Long userId = SecurityContext.getCurrentUserId();
        RequestAction requestAction = new RequestAction();
        requestAction.setAgentId(userId);
        requestAction.setType(type);
        requestAction.setMessage(message);
        requestAction.setNote(note);
        requestAction.setDate(date);
        requestAction.setResultingState(resultingState);
        requestAction.setFile(pdfData);
        requestAction.setFilename(filename);

        if (request.getActions() == null) {
            Set<RequestAction> actionsSet = new HashSet<RequestAction>();
            actionsSet.add(requestAction);
            request.setActions(actionsSet);
        } else {
            request.getActions().add(requestAction);
        }

        requestDAO.update(request);
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.READ)
    public List<RequestAdminAction> getAdminActions() {
        return requestActionDAO.getAdminActions();
    }

    public void setRequestActionDAO(IRequestActionDAO requestActionDAO) {
        this.requestActionDAO = requestActionDAO;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }
}
