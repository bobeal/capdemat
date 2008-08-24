package fr.cg95.cvq.service.request.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestActionDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.RequestUtils;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.util.mail.IMailService;

/**
 * A job that check instruction duration for each request type. Set orange and red alerts
 * and send email alerts if instruction is delayed.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RequestInstructionDurationCheckerJob {

    private static Logger logger = Logger.getLogger(RequestInstructionDurationCheckerJob.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService requestService;
    private ILocalizationService localizationService;
    private IMailService mailService;
    
    private IRequestDAO requestDAO;
    private IRequestActionDAO requestActionDAO;
    
    public void launchJob() throws CvqException {
        localAuthorityRegistry.browseAndCallback(this, 
                "checkLocalAuthRequestsInstructionDuration", null);
    }

    public void checkLocalAuthRequestsInstructionDuration(final String localAuthorityName)
        throws CvqException {

        // get the list of states for which we consider instruction to be done
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        logger.info("checkLocalAuthRequestsInstructionDuration() dealing with " + lacb.getName());
        if (!lacb.getInstructionAlertsEnabled().booleanValue()) {
            logger.info("checkLocalAuthRequestsInstructionDuration() " 
                    + "requests instruction alerts are disabled for "
                    + localAuthorityName + ", returning");
            return;
        }

        Date now = new Date();
        List instructionDoneStates = lacb.getInstructionDoneStates();
        Integer localAuthLevelAlertDelay = lacb.getInstructionDefaultAlertDelay();
        Integer localAuthLevelMaxDelay = lacb.getInstructionDefaultMaxDelay();
    
        // calculate the list of states that are "before" retrieved states
        Set<RequestState> statesToLookFor = new HashSet<RequestState>();
        for (Object state : instructionDoneStates) {
            RequestState requestState = RequestState.forString((String) state);
            statesToLookFor.addAll(requestService.getStatesBefore(requestState));
        }
    
        // retrieve all requests currently in instruction
        List requestsToInspect = requestDAO.listByStates(statesToLookFor);
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
                        if (request.getRedAlert() == null || !request.getRedAlert().booleanValue()) {
                            request.setRedAlert(Boolean.TRUE);
                            request.setOrangeAlert(Boolean.FALSE);
                            requestDAO.update(request);
                        }
                        if (!requestActionDAO.hasAction(request.getId(), 
                                IRequestService.REQUEST_RED_ALERT_NOTIFICATION)) {
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
                        if (request.getOrangeAlert() == null 
                                || !request.getOrangeAlert().booleanValue()) {
                            request.setOrangeAlert(Boolean.TRUE);
                            requestDAO.update(request);
                        }
                        if (!requestActionDAO.hasAction(request.getId(), 
                                IRequestService.REQUEST_ORANGE_ALERT_NOTIFICATION)) {
                            logger.debug("checkLocalAuthRequestsInstructionDuration() "
                                    + "scheduling orange alert notification for request"
                                    + request.getId());
                            orangeRequests.add(request);
                        }
                    }
                }
            }

            if (category.getPrimaryEmail() != null && !category.getPrimaryEmail().equals("")
                    && (orangeRequests.size() > 0 || redRequests.size() > 0)) {
                StringBuffer body = new StringBuffer();
                body.append("Bonjour,\n\n")
                    .append("Voici le récapitulatif des alertes sur les téléservices :\n")
                    .append("\tAlertes oranges : ").append(orangeRequests.size()).append("\n")
                    .append("\tAlertes rouges : ").append(redRequests.size()).append("\n");

                if (lacb.getInstructionAlertsDetailed().booleanValue()) {
                    if (orangeRequests.size() > 0) {
                        body.append("\n").append("Détail des alertes oranges :\n");
                        for (Request request : orangeRequests) {
                            String requestTypeLabel = 
                                localizationService.getRequestLabelTranslation(request.getClass().getName(), "fr", false);
                            body.append("\t").append(requestTypeLabel)
                                .append(" : ").append(request.getId())
                                .append("\n");
                        }
                    }
                    if (redRequests.size() > 0) {
                        body.append("\n\n").append("Détail des alertes rouges :\n");
                        for (Request request : redRequests) {
                            String requestTypeLabel = 
                                localizationService.getRequestLabelTranslation(request.getClass().getName(), "fr", false);
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
                                    null : (String[]) category.getEmails()
                                    .toArray(new String[category.getEmails().size()]), 
                                    "[CapDémat] Alerte traitement téléservices",
                                    body.toString());
                } catch (CvqException e) {
                    logger.error("checkLocalAuthRequestsInstructionDelay() got an error while "
                            + "sending email alert : " + e.getMessage());
                    alertSent = false;
                }

                if (alertSent) {
                    // email alert successfully sent, update requests accordingly
                    if (orangeRequests.size() > 0) {
                        for (Request request : orangeRequests) {
                            requestService.addAction(request, 
                                    IRequestService.REQUEST_ORANGE_ALERT_NOTIFICATION, null); 
                        }
                    }
                    if (redRequests.size() > 0) {
                        for (Request request : redRequests) {
                            requestService.addAction(request, 
                                    IRequestService.REQUEST_RED_ALERT_NOTIFICATION, null);
                        }
                    }
                }
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setLocalizationService(ILocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setRequestActionDAO(IRequestActionDAO requestActionDAO) {
        this.requestActionDAO = requestActionDAO;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

}
