package fr.cg95.cvq.service.request.job;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.RequestUtils;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.util.mail.IMailService;

/**
 * A job that sends email notifications of the newly created requests to category managers.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestCreationNotificationJob {

    private static Logger logger = Logger.getLogger(RequestCreationNotificationJob.class);

    private IRequestService requestService;
    private ILocalizationService localizationService;
    private IMailService mailService;
    private ILocalAuthorityRegistry localAuthorityRegistry;

    private IRequestDAO requestDAO;

    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "notifyLocalAuthRequestsCreation", null);
    }

    public void notifyLocalAuthRequestsCreation(final String localAuthorityName)
            throws CvqException {

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        logger.info("notifyLocalAuthRequestsCreation() dealing with " + lacb.getName());
        if (!lacb.getRequestsCreationNotificationEnabled().booleanValue()) {
            logger.info("notifyLocalAuthRequestsCreation() requests creation notification are disabled for "
                    + lacb.getName() + ", returning");
            return;
        }

        List requestsToNotify = 
            requestDAO.listByNotMatchingActionLabel(IRequestService.REQUEST_CREATION_NOTIFICATION);
        logger.debug("notifyLocalAuthRequestsCreation() got "
                + requestsToNotify.size() + " requests to notify");
        Map<Category, List<Request>> requestsByService = RequestUtils.groupByCategory(requestsToNotify);
        for (Category category : requestsByService.keySet()) {
            if (category.getPrimaryEmail() != null && !category.getPrimaryEmail().equals("")) {
                List<Request> requestList = requestsByService.get(category);
                RequestUtils.groupByRequestType(requestList);
                StringBuffer body = new StringBuffer();
                body.append("Bonjour,\n\n")
                    .append("Voici la liste des derniers télé-services créés :\n");
                for (Request request : requestList) {
                    String requestTypeLabel = 
                        localizationService.getRequestLabelTranslation(request.getClass().getName(), "fr", false);
                    body.append("\t").append(requestTypeLabel).append(" : ")
                        .append(request.getId()).append("\n");
                }

                boolean alertSent = true;
                try {
                    mailService.send(null, category.getPrimaryEmail(), 
                            category.getEmails() == null ? null : (String[]) category
                            .getEmails().toArray(new String[category.getEmails().size()]),
                            "[CapDémat] Alerte nouveaux téléservices", body.toString());
                } catch (CvqException e) {
                    logger.error("notifyLocalAuthRequestsCreation() got an error while sending email alert "
                            + e.getMessage());
                    alertSent = false;
                }
                if (alertSent) {
                    // email alert successfully sent, update request accordingly
                    for (Request request : requestList) {
                        requestService.addAction(request, 
                                IRequestService.REQUEST_CREATION_NOTIFICATION, null);
                    }
                }
            } else {
                logger.warn("notifyLocalAuthRequestsCreation() category "
                        + category.getName() + " has no email adress configured");
            }
        }
    }

    public void setLocalizationService(ILocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public void setLocalAuthorityRegistry(
            ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}
