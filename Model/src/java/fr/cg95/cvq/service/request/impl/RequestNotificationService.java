package fr.cg95.cvq.service.request.impl;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestNotificationService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.util.mail.IMailService;

import org.apache.log4j.Logger;

/**
 *
 * @author bor@zenexity.fr
 */
public class RequestNotificationService implements IRequestNotificationService {

    private static Logger logger = Logger.getLogger(RequestNotificationService.class);

    private IIndividualService individualService;
    private IMailService mailService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private ILocalizationService localizationService;
    private IAgentService agentService;

    private IRequestDAO requestDAO;

    public void notifyRequestValidation(Long requestId, final byte[] pdfData)
        throws CvqException {

		LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();

        Request request = (Request) requestDAO.findById(Request.class, requestId);
        String requestTypeLabel = request.getRequestType().getLabel();

        // send notification to ecitizen if enabled
        Adult requester = (Adult) individualService.getById(request.getRequesterId());
        if (lacb.hasEcitizenValidationNotification(requestTypeLabel)
                && (requester.getEmail() != null && !requester.getEmail().equals(""))) {
            String mailData = lacb.getEcitizenValidationNotificationData(requestTypeLabel,
                    "mailData");
            Boolean attachPdf =
                Boolean.valueOf(lacb.getEcitizenValidationNotificationData(requestTypeLabel,
                        "attachPdf"));
            String mailDataBody =
                localAuthorityRegistry.getBufferedCurrentLocalAuthorityResource(
                        ILocalAuthorityRegistry.TXT_ASSETS_RESOURCE_TYPE, mailData, false);

            if (mailDataBody == null) {
                logger.warn("notifyRequestValidation() local authority has activated ecitizen "
                    + " notification for request type " + requestTypeLabel
                    + " but has no mail data for it !");
                return;
            }

            StringBuffer mailSubject = new StringBuffer();
            mailSubject.append("[").append(SecurityContext.getCurrentSite().getDisplayTitle()).append("] ")
                .append(localizationService.getRequestLabelTranslation(request.getClass().getName(), "fr", false))
                .append(" validée");

            if (pdfData != null && attachPdf.booleanValue()) {
                mailService.send(null, requester.getEmail(), null,
                        mailSubject.toString(), mailDataBody, pdfData, "Attestation_Demande.pdf");
            } else {
                mailService.send(null, requester.getEmail(), null,
                        mailSubject.toString(), mailDataBody);
            }
        }
    }

    public void notifyAgentNote(Long requestId, RequestNote note)
        throws CvqException {
        if (note.getType().equals(RequestNoteType.PUBLIC)) {
            Request request = (Request) requestDAO.findById(Request.class, requestId);
            Agent agent = agentService.getById(note.getUserId());
            Adult requester = individualService.getAdultById(request.getRequesterId());
            if (requester.getEmail() != null) {
                mailService.send(request.getRequestType().getCategory().getPrimaryEmail(),
                    requester.getEmail(), null,
                    "[" + SecurityContext.getCurrentSite().getDisplayTitle() + "] " +
                    "Une note a été ajoutée à votre demande",
                    "L'agent " + agent.getFirstName() + " " + agent.getLastName() +
                    "a ajouté la note suivante sur votre demande n°" + request.getId() + " :\n\n"
                    + note.getNote());
            }
        }
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
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

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }
}
