package fr.cg95.cvq.service.users.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationListener;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.business.users.UserEvent;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.service.users.IMeansOfContactService;
import fr.cg95.cvq.service.users.IUserNotificationService;
import fr.cg95.cvq.util.JSONUtils;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.sms.ISmsService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class UserNotificationService implements IUserNotificationService, ApplicationListener<UserEvent> {

    private IIndividualService individualService;
    private IMeansOfContactService meansOfContactService;
    private IMailService mailService;
    private ISmsService smsService;
    private ITranslationService translationService;
    private IHomeFolderDAO homeFolderDAO;

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void contact(Adult adult, MeansOfContactEnum type, String recipient, String message, String note)
        throws CvqException {
        if (!meansOfContactService.isAvailable(type, adult)) throw new CvqModelException("");
        if (MeansOfContactEnum.EMAIL.equals(type)) {
            notifyByEmail(SecurityContext.getCurrentAgent().getEmail(), recipient,
                translationService.translate("mail.ecitizenContact.subject"),
                message, null, null);
        } else if (MeansOfContactEnum.SMS.equals(type)) {
            notifyBySms(recipient, message);
        }
        JsonObject payload = new JsonObject();
        JsonObject contact = new JsonObject();
        contact.addProperty("meansOfContact", type.toString());
        contact.addProperty("message", message);
        if (!StringUtils.isBlank(recipient)) contact.addProperty("recipient", recipient);
        payload.add("contact", contact);
        UserAction action = new UserAction(UserAction.Type.CONTACT, adult.getId(), payload);
        action.setNote(note);
        adult.getHomeFolder().getActions().add(action);
        homeFolderDAO.update(adult.getHomeFolder());
    }

    @Override
    public void notifyByEmail(String from, String to, String subject,
        String body, byte[] data, String attachmentName)
        throws CvqException {
        String fullSubject =
            "[" + SecurityContext.getCurrentSite().getDisplayTitle() + "] "
            + subject;
        mailService.send(from, to, null, fullSubject, body, data, attachmentName);
    }

    @Override
    public void notifyBySms(String to, String body)
        throws CvqException {
        if (smsService.isEnabled()) {
            smsService.send(to, body);
        } else {
            throw new CvqException("sms_service.not.enabled");
        }
    }

    @Override
    public void onApplicationEvent(UserEvent event) {
        if (UserAction.Type.CREATION.equals(event.getAction().getType())
            || UserAction.Type.MODIFICATION.equals(event.getAction().getType())) {
            try {
                Adult adult = individualService.getAdultById(event.getAction().getTargetId());
                JsonObject payload = JSONUtils.deserialize(event.getAction().getData());
                if (!StringUtils.isEmpty(adult.getLogin())
                    && (UserAction.Type.CREATION.equals(event.getAction().getType())
                        || (payload.has("atom")
                            && payload.get("atom").getAsJsonObject().get("fields").getAsJsonObject()
                                .has("login")
                            && !payload.get("atom").getAsJsonObject()
                                .get("fields").getAsJsonObject().get("login").getAsJsonObject()
                                    .get("to").isJsonNull()))) {
                    try {
                        mailService.send(
                            SecurityContext.getCurrentSite().getAdminEmail(),
                            adult.getEmail(),
                            null,
                            translationService.translate("homeFolder.adult.notification.loginAssigned.subject",
                                new Object[]{SecurityContext.getCurrentSite().getDisplayTitle()}),
                            translationService.translate("homeFolder.adult.notification.loginAssigned.body",
                                new Object[]{SecurityContext.getCurrentSite().getDisplayTitle(), adult.getLogin()})
                        );
                    } catch (CvqException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (CvqObjectNotFoundException e) {
                // nothing to do for home folder or child events
                return;
            }
        }
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }

    public void setMeansOfContactService(IMeansOfContactService meansOfContactService) {
        this.meansOfContactService = meansOfContactService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setSmsService(ISmsService smsService) {
        this.smsService = smsService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    public void setHomeFolderDAO(IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }
}