package fr.cg95.cvq.service.users.impl;

import org.springframework.context.ApplicationListener;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UsersEvent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class UserNotificationService implements ApplicationListener<UsersEvent> {

    private IIndividualService individualService;
    private IMailService mailService;
    private ITranslationService translationService;

    @Override
    public void onApplicationEvent(UsersEvent event) {
        switch (event.getEvent()) {
            case LOGIN_ASSIGNED :
                try {
                    notifyLogin(individualService.getById(event.getIndividualId()));
                } catch (CvqException e) {
                    throw new RuntimeException(e);
                }
                break;
            default :
                break;
        }
    }

    private void notifyLogin(Individual individual)
        throws CvqException {
        if (individual instanceof Adult) {
            mailService.send(
                SecurityContext.getCurrentSite().getAdminEmail(),
                ((Adult)individual).getEmail(),
                null,
                translationService.translate("homeFolder.adult.notification.loginAssigned.subject",
                    new Object[]{SecurityContext.getCurrentSite().getDisplayTitle()}),
                translationService.translate("homeFolder.adult.notification.loginAssigned.body",
                    new Object[]{SecurityContext.getCurrentSite().getDisplayTitle(), individual.getLogin()})
            );
        }
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }
}