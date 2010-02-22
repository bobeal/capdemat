package fr.cg95.cvq.service.request.impl;

import java.util.Map;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestEvent;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.request.RequestEvent.COMP_DATA;
import fr.cg95.cvq.business.request.RequestEvent.EVENT_TYPE;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestNotificationService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

/**
 *
 * @author bor@zenexity.fr
 */
public class RequestNotificationService implements IRequestNotificationService, 
    ApplicationListener<RequestEvent> {

    private static Logger logger = Logger.getLogger(RequestNotificationService.class);

    private IIndividualService individualService;
    private IMailService mailService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IAgentService agentService;
    private ITranslationService translationService;

    private IRequestDAO requestDAO;

    public void notifyRequestCreation(Request request, byte[] pdfData)
        throws CvqException {

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Adult requester = (Adult) individualService.getById(request.getRequesterId());
        if (requester.getEmail() != null && !requester.getEmail().equals("")) {
            Map<String, String> ecitizenCreationNotifications =
                lacb.getEcitizenCreationNotifications();
            if (ecitizenCreationNotifications == null) {
                logger.warn("notifyRequestCreation() ecitizen creation notifications not configured !");
                return;
            }
            String mailData = ecitizenCreationNotifications.get("mailData");
            Boolean attachPdf =
                Boolean.valueOf(ecitizenCreationNotifications.get("attachPdf"));
            String mailDataBody =
                localAuthorityRegistry.getBufferedLocalAuthorityResource(
                        Type.TXT, mailData, false);

            if (mailDataBody == null) {
                logger.warn("notifyRequestCreation() no mail data for ecitizen request creation notification");
            } else {
                mailDataBody = mailDataBody.replaceAll("__ecitizenLogin__", requester.getLogin());
                StringBuffer mailSubject = new StringBuffer();
                mailSubject.append("[").append(SecurityContext.getCurrentSite().getDisplayTitle()).append("] ")
                .append(ecitizenCreationNotifications.get("mailSubject"));

                if (attachPdf) {
                    mailService.send(null, requester.getEmail(), null,
                            mailSubject.toString(), mailDataBody, pdfData, "Recu_Demande.pdf");
                } else {
                    mailService.send(null, requester.getEmail(), null,
                            mailSubject.toString(), mailDataBody);
                }
            }
        }
    }

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
                localAuthorityRegistry.getBufferedLocalAuthorityResource(
                        Type.TXT, mailData, false);

            if (mailDataBody == null) {
                logger.warn("notifyRequestValidation() local authority has activated ecitizen "
                    + " notification for request type " + requestTypeLabel
                    + " but has no mail data for it !");
                return;
            }

            String mailSubject = translationService.translate(
                "request.notification.validation.subject",
                new Object[] {
                    SecurityContext.getCurrentSite().getDisplayTitle(),
                    translationService.translateRequestTypeLabel(request.getRequestType().getLabel())
                });

            if (pdfData != null && attachPdf.booleanValue()) {
                mailService.send(null, requester.getEmail(), null,
                        mailSubject, mailDataBody, pdfData, "Attestation_Demande.pdf");
            } else {
                mailService.send(null, requester.getEmail(), null,
                        mailSubject, mailDataBody);
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
                    translationService.translate("request.notification.agentNote.subject",
                        new Object[]{SecurityContext.getCurrentSite().getDisplayTitle()}),
                    translationService.translate("request.notification.agentNote.body",
                        new Object[] {
                            agent.getFirstName(), agent.getLastName(), request.getId(), note.getNote()
                        }));
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

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public void onApplicationEvent(RequestEvent requestEvent) {
        logger.debug("onApplicationEvent() got a request event of type " + requestEvent.getEvent());
        try {
            if (requestEvent.getEvent().equals(EVENT_TYPE.REQUEST_CREATED)) {
                notifyRequestCreation(requestEvent.getRequest(),
                    (byte[])requestEvent.getComplementaryData(COMP_DATA.PDF_FILE));
            } else if (requestEvent.getEvent().equals(EVENT_TYPE.REQUEST_VALIDATED)) {
                notifyRequestValidation(requestEvent.getRequest().getId(), 
                    (byte[])requestEvent.getComplementaryData(COMP_DATA.PDF_FILE));
            } else if (requestEvent.getEvent().equals(EVENT_TYPE.NOTE_ADDED)) {
                notifyAgentNote(requestEvent.getRequest().getId(), 
                        ((RequestNote) requestEvent.getComplementaryData(COMP_DATA.REQUEST_NOTE)));
            }
        } catch (CvqException e) {
            // FIXME we have nothing to handle this
            logger.error("onApplicationEvent() got an error while notifying request creation");
            e.printStackTrace();
        }
    }
}
