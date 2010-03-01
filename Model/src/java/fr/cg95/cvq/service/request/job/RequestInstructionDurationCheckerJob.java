package fr.cg95.cvq.service.request.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.request.GlobalRequestTypeConfiguration;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestActionService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.service.request.RequestUtils;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;

/**
 * A job that checks instruction duration for each request type. 
 * 
 * Set orange and red alerts and send email alerts if instruction is delayed.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestInstructionDurationCheckerJob {

    private static Logger logger = Logger.getLogger(RequestInstructionDurationCheckerJob.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestActionService requestActionService;
    private IRequestWorkflowService requestWorkflowService;

    private ITranslationService translationService;
    private IMailService mailService;
    
    private IRequestDAO requestDAO;
    private IRequestTypeService requestTypeService;
    
    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this,
                "checkLocalAuthRequestsInstructionDuration", null);
    }

    public void checkLocalAuthRequestsInstructionDuration()
        throws CvqException {

        LocalAuthority la = SecurityContext.getCurrentSite();
        GlobalRequestTypeConfiguration config =
            requestTypeService.getGlobalRequestTypeConfiguration();
        // get the list of states for which we consider instruction to be done
        logger.info("checkLocalAuthRequestsInstructionDuration() dealing with " + la.getName());
        if (!config.isInstructionAlertsEnabled()) {
            logger.info("checkLocalAuthRequestsInstructionDuration() " 
                    + "requests instruction alerts are disabled for "
                    + SecurityContext.getCurrentSite().getName() + ", returning");
            return;
        }

        Date now = new Date();
        List<RequestState> instructionDoneStates = requestWorkflowService.getInstructionDoneStates();
        Integer localAuthLevelAlertDelay = config.getInstructionAlertDelay();
        Integer localAuthLevelMaxDelay = config.getInstructionMaxDelay();
    
        // calculate the list of states that are "before" retrieved states
        Set<RequestState> statesToLookFor = new HashSet<RequestState>();
        for (RequestState state : instructionDoneStates) {
            statesToLookFor.addAll(requestWorkflowService.getStatesBefore(state));
        }
    
        // retrieve all requests currently in instruction
        List<Request> requestsToInspect = requestDAO.listByStates(statesToLookFor, false);
        Map<Category, List<Request>> requestsByService = 
            RequestUtils.groupByCategory(requestsToInspect);
        for (Category category : requestsByService.keySet()) {
            List<Request> requestList = requestsByService.get(category);
            RequestUtils.groupByRequestType(requestList);
            List<Request> orangeRequests = new ArrayList<Request>();
            List<Request> redRequests = new ArrayList<Request>();

            // for each one, get its instruction delay parameters, either from global configuration
            // or from request type configuration.  
            // if one of its delay parameter has expired, set alert flag accordingly.
            for (Request request : requestList) {
                Integer alertDelayToUse = null;
                Integer maxDelayToUse = null;
                if (request.getRequestType().getInstructionMaxDelay() != null)
                    maxDelayToUse = request.getRequestType().getInstructionMaxDelay();
                else
                    maxDelayToUse = localAuthLevelMaxDelay;
                if (request.getRequestType().getInstructionAlertDelay() != null)
                    alertDelayToUse = request.getRequestType().getInstructionAlertDelay();
                else
                    alertDelayToUse = localAuthLevelAlertDelay;
                if (maxDelayToUse != null) {
                    int workDaysSinceRequestCreation = 
                        DateUtils.getWorkDaysBetweenDates(request.getCreationDate(), now);
                    logger.debug("checkLocalAuthRequestsInstructionDuration() " 
                            + "days # since request creation " + workDaysSinceRequestCreation);
                    if (workDaysSinceRequestCreation >= maxDelayToUse.intValue()) {
                        logger.debug("checkLocalAuthRequestsInstructionDuration() " 
                                + "instruction delayed for request " + request.getId());
                        if (request.getRedAlert() == null || !request.getRedAlert()) {
                            request.setRedAlert(Boolean.TRUE);
                            request.setOrangeAlert(Boolean.FALSE);
                            requestDAO.update(request);
                        }
                        if (!requestActionService.hasAction(request.getId(),
                            RequestActionType.RED_ALERT_NOTIFICATION)) {
                            logger.debug("checkLocalAuthRequestsInstructionDuration() "
                                    + "scheduling red alert notification for request"
                                    + request.getId());
                            redRequests.add(request);
                        }
                    } else if (workDaysSinceRequestCreation >= 
                                    (maxDelayToUse.intValue() - alertDelayToUse.intValue())) {
                        logger.debug("checkLocalAuthRequestsInstructionDuration() "
                                + "instruction duration reached first level alert for request " 
                                + request.getId());
                        if (request.getOrangeAlert() == null || !request.getOrangeAlert()) {
                            request.setOrangeAlert(Boolean.TRUE);
                            requestDAO.update(request);
                        }
                        if (!requestActionService.hasAction(request.getId(),
                            RequestActionType.ORANGE_ALERT_NOTIFICATION)) {
                            logger.debug("checkLocalAuthRequestsInstructionDuration() "
                                    + "scheduling orange alert notification for request"
                                    + request.getId());
                            orangeRequests.add(request);
                        }
                    }
                }
            }

            if (category.getPrimaryEmail() != null && !category.getPrimaryEmail().equals("")
                    && (!orangeRequests.isEmpty() || !redRequests.isEmpty())) {
                StringBuffer body = new StringBuffer();
                body.append("Bonjour,\n\n")
                    .append("Voici le récapitulatif des alertes sur les téléservices :\n")
                    .append("\tAlertes oranges : ").append(orangeRequests.size()).append("\n")
                    .append("\tAlertes rouges : ").append(redRequests.size()).append("\n");

                if (config.isInstructionAlertsDetailed()) {
                    if (!orangeRequests.isEmpty()) {
                        body.append("\n").append("Détail des alertes oranges :\n");
                        for (Request request : orangeRequests) {
                            String requestTypeLabel = 
                                translationService.translateRequestTypeLabel(request.getRequestType().getLabel());
                            body.append("\t").append(requestTypeLabel)
                                .append(" : ").append(request.getId())
                                .append("\n");
                        }
                    }
                    if (!redRequests.isEmpty()) {
                        body.append("\n\n").append("Détail des alertes rouges :\n");
                        for (Request request : redRequests) {
                            String requestTypeLabel = 
                                translationService.translateRequestTypeLabel(request.getRequestType().getLabel());
                            body.append("\t").append(requestTypeLabel)
                                .append(" : ").append(request.getId())
                                .append("\n");
                        }
                    }
                }

                boolean alertSent = true;
                try {
                    mailService.send(null, category.getPrimaryEmail(),
                            category.getEmails() == null ? 
                                    null : category.getEmails().toArray(new String[category.getEmails().size()]), 
                                    "[CapDémat] Alerte traitement téléservices",
                                    body.toString());
                } catch (CvqException e) {
                    logger.error("checkLocalAuthRequestsInstructionDelay() got an error while "
                            + "sending email alert : " + e.getMessage());
                    alertSent = false;
                }

                if (alertSent) {
                    // email alert successfully sent, update requests accordingly
                    for (Request request : orangeRequests) {
                        requestActionService.addSystemAction(request.getId(),
                            RequestActionType.ORANGE_ALERT_NOTIFICATION);
                    }
                    for (Request request : redRequests) {
                        requestActionService.addSystemAction(request.getId(),
                            RequestActionType.RED_ALERT_NOTIFICATION);
                    }
                }
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestActionService(IRequestActionService requestActionService) {
        this.requestActionService = requestActionService;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }
}
