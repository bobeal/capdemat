package fr.cg95.cvq.service.users.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.QoS;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.request.GlobalRequestTypeConfiguration;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.mail.IMailService;

public class UserInstructionDurationCheckerJob {

    private static Logger logger = Logger.getLogger(UserInstructionDurationCheckerJob.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;

    private IMailService mailService;

    private IIndividualDAO individualDAO;

    private IRequestTypeService requestTypeService;

    @Context(types = {ContextType.SUPER_ADMIN})
    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "check", null);
    }

    @Context(types = {ContextType.SUPER_ADMIN})
    public void check() {
        LocalAuthority la = SecurityContext.getCurrentSite();
        // FIXME : we're still relying on request configuration
        GlobalRequestTypeConfiguration config = requestTypeService.getGlobalRequestTypeConfiguration();
        logger.info("UserInstructionDurationCheckerJob : dealing with " + la.getName());
        if (!config.isInstructionAlertsEnabled()) {
            logger.info("UserInstructionDurationCheckerJob : requests instruction alerts are disabled for "
                + SecurityContext.getCurrentSite().getName() + ", returning");
            return;
        }
        Date now = new Date();
        List<Individual> individuals = individualDAO.searchTasks(now);
        List<Individual> urgent = new ArrayList<Individual>();
        List<Individual> late = new ArrayList<Individual>();
        List<Individual> tasks = new ArrayList<Individual>();
        for (Individual individual : individuals) {
            int delay = DateUtils.getWorkDaysBetweenDates(individual.getLastModificationDate(), now);
            if (config.getInstructionMaxDelay() > 0 && delay >= config.getInstructionMaxDelay()
                && !QoS.LATE.equals(individual.getQoS())) {
                individual.setQoS(QoS.LATE);
                late.add(individual);
                tasks.add(individual);
            } else if (config.getInstructionAlertDelay() > 0
                && delay >= config.getInstructionAlertDelay()
                && QoS.GOOD.equals(individual.getQoS())) {
                individual.setQoS(QoS.URGENT);
                urgent.add(individual);
                tasks.add(individual);
            }
        }
        boolean notified = false;
        if (!StringUtils.isBlank(la.getAdminEmail()) && !tasks.isEmpty()) {
            StringBuffer body = new StringBuffer();
            body.append("Bonjour,\n\n")
                .append("Voici le récapitulatif des alertes sur les usagers :\n")
                .append("\tAlertes oranges : ").append(urgent.size()).append("\n")
                .append("\tAlertes rouges : ").append(late.size()).append("\n");
            if (config.isInstructionAlertsDetailed()) {
                if (!urgent.isEmpty()) {
                    body.append("\n").append("Détail des alertes oranges :\n");
                    for (Individual individual : urgent) {
                        body.append("\t").append(individual.getFullName())
                            .append(" (").append(individual.getId()).append(")\n");
                    }
                }
                if (!late.isEmpty()) {
                    body.append("\n\n").append("Détail des alertes rouges :\n");
                    for (Individual individual : late) {
                        body.append("\t").append(individual.getFullName())
                            .append(" (").append(individual.getId()).append(")\n");
                    }
                }
            }
            try {
                mailService.send(null, la.getAdminEmail(), null,
                    "[CapDémat] Alerte traitement comptes", body.toString());
                notified = true;
            } catch (CvqException e) {
                logger.error("checkLocalAuthRequestsInstructionDelay() got an error while "
                        + "sending email alert : " + e.getMessage());
            }
        }
        for (Individual i : tasks) {
            JsonObject payload = new JsonObject();
            payload.addProperty("quality", i.getQoS().toString());
            payload.addProperty("notified", notified);
            i.getHomeFolder().getActions().add(new UserAction(UserAction.Type.QoS, i.getId(), payload));
            individualDAO.update(i.getHomeFolder());
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }
}
