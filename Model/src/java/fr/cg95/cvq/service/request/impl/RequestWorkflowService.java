package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.request.DataState;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestStep;
import fr.cg95.cvq.dao.request.IRequestActionDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.ICertificateService;

/**
 * This services handles workflow tasks for requests. Workflow-related calls to
 * {@link IRequestService} are delegated to this service. It is responsible for :
 * <ul>
 *  <li>Checking requested states changes are authorized</li>
 *  <li>Updating requests state and workflow information</li>
 *  <li>Creating and managing worklow action traces</li>
 * </ul>
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestWorkflowService {

    private static Logger logger = Logger.getLogger(RequestWorkflowService.class);
    
    private ICertificateService certificateService;

    private IRequestActionDAO requestActionDAO;
    private IRequestDAO requestDAO;
    
    // TODO : must we trace as request action 
    public void validData(Request request)
            throws CvqException, CvqInvalidTransitionException {
    
        // if no state change asked, just return silently
        if (request.getDataState().equals(DataState.VALID))
            return;
    
        if (request.getDataState().equals(DataState.PENDING))
            request.setDataState(DataState.VALID);
        else
            throw new CvqInvalidTransitionException();
    }
    
    // TODO : must we trace as request action 
    public void invalidData(Request request)
            throws CvqException, CvqInvalidTransitionException {
    
        // if no state change asked, just return silently
        if (request.getDataState().equals(DataState.INVALID))
            return;
    
        if (request.getDataState().equals(DataState.PENDING))
            request.setDataState(DataState.INVALID);
        else
            throw new CvqInvalidTransitionException();
    }
    
    public void complete(Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.COMPLETE))
            return;

        if (request.getState().equals(RequestState.PENDING)
                || request.getState().equals(RequestState.UNCOMPLETE)) {
            
            request.setState(RequestState.COMPLETE);
            Date date = new Date();
            updateLastModificationInformation(request, date);

            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.COMPLETE, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }
    
    public void specify(final Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException {

        if (request.getState().equals(RequestState.UNCOMPLETE))
            return;
        
        if (request.getState().equals(RequestState.PENDING)
            || request.getState().equals(RequestState.UNCOMPLETE)) {

            request.setState(RequestState.UNCOMPLETE);
            Date date = new Date();
            updateLastModificationInformation(request, date);
            
            addActionTrace(IRequestService.STATE_CHANGE_ACTION, motive, date, 
                    RequestState.UNCOMPLETE, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }

    public void validate(Request request, boolean generateCertificate, String fopConfig)
        throws CvqException, CvqInvalidTransitionException {
        
        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.VALIDATED))
            return;

        if (!request.getState().equals(RequestState.COMPLETE))
            throw new CvqInvalidTransitionException();

        request.setState(RequestState.VALIDATED);
        request.setDataState(DataState.VALID);
        request.setStep(RequestStep.DELIVERY);
        Date date = new Date();
        request.setValidationDate(date);
        updateLastModificationInformation(request, date);
       
        if (generateCertificate) {
            logger.debug("validate() Gonna generate a pdf of the request");
            byte[] pdfData = certificateService.generateRequestCertificate(request, fopConfig);
            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.VALIDATED, request, pdfData);
        } else {
            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.VALIDATED, request, null);
        }
    }
    
    public void notify(Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.NOTIFIED))
            return;

        if (!request.getState().equals(RequestState.VALIDATED))
            throw new CvqInvalidTransitionException();

        request.setState(RequestState.NOTIFIED);
        Date date = new Date();
        updateLastModificationInformation(request, date);

        addActionTrace(IRequestService.STATE_CHANGE_ACTION, motive, date, 
                RequestState.NOTIFIED, request, null);
    }   

    public void activate(final Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.ACTIVE))
            return;

        if (!request.getState().equals(RequestState.NOTIFIED))
            throw new CvqInvalidTransitionException();

        request.setState(RequestState.ACTIVE);
        Date date = new Date();
        updateLastModificationInformation(request, date);

        addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                RequestState.ACTIVE, request, null);
    }
    
    public void expire(final Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.EXPIRED))
            return;

        if (!request.getState().equals(RequestState.ACTIVE))
            throw new CvqInvalidTransitionException();

        request.setState(RequestState.EXPIRED);
        Date date = new Date();
        updateLastModificationInformation(request, date);

        addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                RequestState.EXPIRED, request, null);
    }
    
    public void cancel(final Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.CANCELLED))
            return;

        if (request.getState().equals(RequestState.COMPLETE)
                || request.getState().equals(RequestState.UNCOMPLETE)
                || request.getState().equals(RequestState.PENDING)) {
            request.setState(RequestState.CANCELLED);
            Date date = new Date();
            updateLastModificationInformation(request, date);

            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.CANCELLED, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }

    public void reject(final Request request, final String motive)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.REJECTED))
            return;

        if (request.getState().equals(RequestState.COMPLETE)
                || request.getState().equals(RequestState.UNCOMPLETE)
                || request.getState().equals(RequestState.PENDING)) {
            request.setState(RequestState.REJECTED);
            Date date = new Date();
            updateLastModificationInformation(request, date);

            addActionTrace(IRequestService.STATE_CHANGE_ACTION, motive, date, 
                    RequestState.REJECTED, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }
    
    public void close(Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.CLOSED))
            return;

        if (request.getState().equals(RequestState.NOTIFIED)) {
            request.setState(RequestState.CLOSED);
            Date date = new Date();
            updateLastModificationInformation(request, date);

            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.CLOSED, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }

    public void archive(final Request request)
        throws CvqException, CvqInvalidTransitionException {

        // if no state change asked, just return silently
        if (request.getState().equals(RequestState.ARCHIVED))
            return;

        if (request.getState().equals(RequestState.CANCELLED)
                || request.getState().equals(RequestState.REJECTED)
                || request.getState().equals(RequestState.NOTIFIED)
                || request.getState().equals(RequestState.CLOSED)) {

            request.setState(RequestState.ARCHIVED);
            Date date = new Date();
            updateLastModificationInformation(request, date);

            addActionTrace(IRequestService.STATE_CHANGE_ACTION, null, date, 
                    RequestState.ARCHIVED, request, null);
        } else {
            throw new CvqInvalidTransitionException();
        }
    }

    public RequestState[] getPossibleTransitions(RequestState rs) {

        List<RequestState> requestStateList = new ArrayList<RequestState>();

        if (rs.equals(RequestState.PENDING)) {
            requestStateList.add(RequestState.COMPLETE);
            requestStateList.add(RequestState.UNCOMPLETE);
            requestStateList.add(RequestState.REJECTED);
            requestStateList.add(RequestState.CANCELLED);
        } else if (rs.equals(RequestState.COMPLETE)) {
            requestStateList.add(RequestState.VALIDATED);
            requestStateList.add(RequestState.REJECTED);
            requestStateList.add(RequestState.CANCELLED);
        } else if (rs.equals(RequestState.UNCOMPLETE)) {
            requestStateList.add(RequestState.COMPLETE);
            requestStateList.add(RequestState.UNCOMPLETE);
            requestStateList.add(RequestState.CANCELLED);
            requestStateList.add(RequestState.REJECTED);
        } else if (rs.equals(RequestState.REJECTED)) {
            requestStateList.add(RequestState.ARCHIVED);
        } else if (rs.equals(RequestState.CANCELLED)) {
            requestStateList.add(RequestState.ARCHIVED);
        } else if (rs.equals(RequestState.ARCHIVED)) {
            // no more state transitions available from there
        } else if (rs.equals(RequestState.VALIDATED)) {
            requestStateList.add(RequestState.NOTIFIED);
        } else if (rs.equals(RequestState.NOTIFIED)) {
            requestStateList.add(RequestState.CLOSED);
            requestStateList.add(RequestState.ARCHIVED);
            requestStateList.add(RequestState.ACTIVE);
        } else if (rs.equals(RequestState.ACTIVE)) {
            requestStateList.add(RequestState.EXPIRED);
            requestStateList.add(RequestState.CLOSED);
        } else if (rs.equals(RequestState.EXPIRED)) {
            requestStateList.add(RequestState.ARCHIVED);
        } else if (rs.equals(RequestState.CLOSED)) {
            requestStateList.add(RequestState.ARCHIVED);
        }

        return (RequestState[]) requestStateList.toArray(new RequestState[0]);
    }

    public Set<RequestState> getStatesBefore(RequestState rs) {

        Set<RequestState> requestStateSet = new HashSet<RequestState>();

        if (rs.equals(RequestState.PENDING)) {
            // no state available before pending
        } else if (rs.equals(RequestState.COMPLETE)) {
            requestStateSet.add(RequestState.PENDING);
            requestStateSet.add(RequestState.UNCOMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.UNCOMPLETE));
        } else if (rs.equals(RequestState.UNCOMPLETE)) {
            requestStateSet.add(RequestState.PENDING);
        } else if (rs.equals(RequestState.REJECTED)) {
            requestStateSet.add(RequestState.PENDING);
            requestStateSet.add(RequestState.UNCOMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.UNCOMPLETE));
            requestStateSet.add(RequestState.COMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.COMPLETE));
        } else if (rs.equals(RequestState.CANCELLED)) {
            requestStateSet.add(RequestState.PENDING);
            requestStateSet.add(RequestState.UNCOMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.UNCOMPLETE));
            requestStateSet.add(RequestState.COMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.COMPLETE));            
        } else if (rs.equals(RequestState.ARCHIVED)) {
            requestStateSet.add(RequestState.NOTIFIED);
            requestStateSet.addAll(getStatesBefore(RequestState.NOTIFIED));
            requestStateSet.add(RequestState.CLOSED);
            requestStateSet.addAll(getStatesBefore(RequestState.CLOSED));
            requestStateSet.add(RequestState.EXPIRED);
            requestStateSet.addAll(getStatesBefore(RequestState.EXPIRED));
            requestStateSet.add(RequestState.REJECTED);
            requestStateSet.addAll(getStatesBefore(RequestState.REJECTED));
            requestStateSet.add(RequestState.CANCELLED);
            requestStateSet.addAll(getStatesBefore(RequestState.CANCELLED));
        } else if (rs.equals(RequestState.VALIDATED)) {
            requestStateSet.add(RequestState.COMPLETE);
            requestStateSet.addAll(getStatesBefore(RequestState.COMPLETE));
        } else if (rs.equals(RequestState.NOTIFIED)) {
            requestStateSet.add(RequestState.VALIDATED);
            requestStateSet.addAll(getStatesBefore(RequestState.VALIDATED));
        } else if (rs.equals(RequestState.CLOSED)) {
            requestStateSet.add(RequestState.NOTIFIED);
            requestStateSet.addAll(getStatesBefore(RequestState.NOTIFIED));
            requestStateSet.add(RequestState.ACTIVE);
            requestStateSet.addAll(getStatesBefore(RequestState.ACTIVE));
        } else if (rs.equals(RequestState.ACTIVE)) {
            requestStateSet.add(RequestState.NOTIFIED);
            requestStateSet.addAll(getStatesBefore(RequestState.NOTIFIED));
        } else if (rs.equals(RequestState.EXPIRED)) {
            requestStateSet.add(RequestState.ACTIVE);
            requestStateSet.addAll(getStatesBefore(RequestState.ACTIVE));
        }

        return requestStateSet;
    }

    public RequestState[] getStatesExcludedForRunningRequests() {
        RequestState[] excludedStates = 
            new RequestState[] { RequestState.ARCHIVED, RequestState.REJECTED,
                RequestState.CANCELLED, RequestState.CLOSED };
        return excludedStates;
    }
    
    public RequestState[] getStatesExcludedForRequestsCloning() {
        RequestState[] excludedStates = 
            new RequestState[] { RequestState.REJECTED, RequestState.CANCELLED };
        return excludedStates;
    }
    
    private void updateLastModificationInformation(Request request, final Date date)
        throws CvqException {

        // update request's last modification date
        if (date != null)
            request.setLastModificationDate(date);
        else
            request.setLastModificationDate(new Date());

        Long userId = SecurityContext.getCurrentUserId();
        request.setLastInterveningAgentId(userId);

        requestDAO.update(request);
    }

    private void addActionTrace(final String label, final String note, final Date date,
            final RequestState resultingState, final Request request, final byte[] pdfData)
        throws CvqException {

        // retrieve user or agent id according to context
        Long userId = null;
        if (request instanceof VoCardRequest) {
            VoCardRequest vocr = (VoCardRequest) request;
            // there can't be a logged in user at VO card request creation time
            userId = vocr.getHomeFolder().getHomeFolderResponsible().getId();
        } else {
            userId = SecurityContext.getCurrentUserId();
        }

        RequestAction requestAction = new RequestAction();
        requestAction.setAgentId(userId);
        requestAction.setLabel(label);
        requestAction.setNote(note);
        requestAction.setDate(date);
        requestAction.setResultingState(resultingState);
        requestAction.setRequest(request);
        requestAction.setFile(pdfData);

        requestActionDAO.create(requestAction);
    }

    public void setRequestActionDAO(IRequestActionDAO requestActionDAO) {
        this.requestActionDAO = requestActionDAO;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setCertificateService(ICertificateService certificateService) {
        this.certificateService = certificateService;
    }
}
