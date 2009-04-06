package fr.cg95.cvq.service.request.job;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;

/**
 * A job that can be used to go automatically through some workflow states.
 * 
 * Configurable parameters (in applicationContext-admin.xml) are :
 * <ul>
 *  <li>local authority</li>
 *  <li>request type label</li>
 *  <li>start state</li>
 *  <li>end state</li>
 * </ul>
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @deprecated must be migrated and enhanced
 */
public class RequestWorkflowNavigatorJob {

    private Logger logger = Logger.getLogger(RequestWorkflowNavigatorJob.class);
    
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestServiceRegistry requestServiceRegistry;
    private IRequestDAO requestDAO;
    
    /**
     * Entry point for the <b>requestWorkflowSimulatorJob</b>.
     * 
     * @see #doRequestWorkflowChange(String, String, String, String)
     */
    public void launchJob(String localAuthorityName, String requestTypeLabel,
            String startState, String endState) {
        Object[] args = new Object[3];
        args[0] = requestTypeLabel;
        args[1] = startState;
        args[2] = endState;
        localAuthorityRegistry.callback(localAuthorityName, this, "doRequestWorkflowChange", args);
    }

    /**
     * For a given local authority, change state of requests whose type and current state match
     * those provided to the specified end state. 
     */
//    public void doRequestWorkflowChange(String requestTypeLabel, String startState,
//        String endState) throws Exception {
//
//        logger.debug("doRequestWorkflowChange() starting job for local authority "
//                + SecurityContext.getCurrentSite().getName());
//        logger.debug("doRequestWorkflowChange() from state " + startState + " to "
//                + endState);
//        RequestState requestState = RequestState.forString(startState);
//        Set<RequestState> requestStateSet = new HashSet<RequestState>();
//        requestStateSet.add(requestState);
//
//        RequestState requestEndState = RequestState.forString(endState);
//        List<Request> requestList =
//            requestDAO.listByStatesAndType(requestStateSet, requestTypeLabel);
//        logger.debug("doRequestWorkflowChange() got " + requestList.size()
//            + " matching request(s)");
//        for (Request request : requestList) {
//            IRequestService dynamicRequestService =
//                requestServiceRegistry.getRequestService(request);
//            logger.debug("doRequestWorkflowChange() using service " + dynamicRequestService);
//            while (!request.getState().equals(requestEndState)) {
//                try {
//                    if (request.getState().equals(RequestState.PENDING))
//                        dynamicRequestService.complete(request);
//                    else if (request.getState().equals(RequestState.COMPLETE))
//                        dynamicRequestService.validate(request);
//                    else if (request.getState().equals(RequestState.VALIDATED))
//                        dynamicRequestService.notify(request.getId(), "Automatic notification");
//                    else if (request.getState().equals(RequestState.NOTIFIED))
//                        dynamicRequestService.close(request.getId());
//                    else if (request.getState().equals(RequestState.CLOSED))
//                        dynamicRequestService.archive(request);
//                } catch (CvqInvalidTransitionException cite) {
//                    // this is unlikely to happen
//                } catch (CvqException ce) {
//                    logger.error("doRequestWorkflowChange() Unexpected error : " + ce);
//                    ce.printStackTrace();
//                    throw new Exception("Error while changing state of request "
//                            + request.getId());
//                }
//            }
//        }
//    }

    public void setLocalAuthorityRegistry(
            ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestServiceRegistry(
            IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }
}
