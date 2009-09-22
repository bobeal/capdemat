package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestActionService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.translation.ITranslationService;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Job dedicated to the management of drafts.
 * 
 * Performs two tasks :
 * <ul>
 *   <li>Delete expired drafts</li>
 *   <li>Send a notification to e-citizens when one of their drafts is about to expire</li>
 * </ul>
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DraftManagementJob {
    
    private static Logger logger = Logger.getLogger(DraftManagementJob.class);

    private IRequestDAO requestDAO;
    private IRequestActionService requestActionService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IMailService mailService;
    private IIndividualService individualService;
    private ITranslationService translationService;

    private static String DRAFT_NOTIFICATION_SUBJECT = 
        "[CapDémat] Expiration d'une demande sauvée en tant que brouillon";
    
    public void launchNotificationJob() {
        localAuthorityRegistry.browseAndCallback(this, "sendNotifications", null);
    }
    
    public void launchRemovalJob() {
        localAuthorityRegistry.browseAndCallback(this, "deleteExpiredDrafts", null);
    }
    
    public void deleteExpiredDrafts() {
        LocalAuthority authority = SecurityContext.getCurrentSite();
        
        Set<Critere> criterias = prepareQueryParams(authority.getDraftLiveDuration());
        List<Request> requests = requestDAO.search(criterias,null,null,0,0);
        for (Request r : requests) 
            requestDAO.delete(r);
    }
    
    /**
     * Send drafts expiration notification to ecitizens.
     * 
     * @return the number of email notifications sent.
     */
    public Integer sendNotifications() throws CvqException {
        Integer counter = 0; 
        LocalAuthority authority = SecurityContext.getCurrentSite();
        Integer limit =
            authority.getDraftLiveDuration() - authority.getDraftNotificationBeforeDelete();
        
        List<Request> requests = requestDAO.listDraftedByNotificationAndDate(
            RequestActionType.DRAFT_DELETE_NOTIFICATION,
            DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR, -limit));
        
        for (Request r : requests) {
            Adult adult = this.individualService.getAdultById(r.getRequesterId());
            String from = null;
            if (r.getRequestType().getCategory() != null)
                from = r.getRequestType().getCategory().getPrimaryEmail();
            else
                from = authority.getAdminEmail();
            boolean sent = false;
            
            try {
                String mailBody =
                    this.buildMailTemplate(r, authority.getDraftLiveDuration());
                if (mailBody != null) {
                    try {
                        mailService.send(from, adult.getEmail(), null,
                            new String(DRAFT_NOTIFICATION_SUBJECT.getBytes(), "UTF-8"),
                            mailBody);
                    } catch (UnsupportedEncodingException e) {
                        // unlikely to happen
                    }
                }
                logger.debug("sendNotifications() sent for request " + r.getId());
                sent = true;
                counter ++;
            } catch (CvqException e) {
                logger.error("sendNotifications() " + e.getMessage());
            } finally {
                if (sent)
                    requestActionService.addSystemAction(r.getId(),
                        RequestActionType.DRAFT_DELETE_NOTIFICATION);
            }
        }
        return counter;
    }
    
    protected String buildMailTemplate(Request request, Integer liveDuration) {
        String template =
            this.localAuthorityRegistry.getBufferedLocalAuthorityResource(
                Type.TXT, "NotificationBeforeDraftDelete", false);

        if (template == null)
            return null;
        
        template = template.replace("${requestType}", 
            translationService.translateRequestTypeLabel(request.getRequestType().getLabel()));
        template = template.replace("${requestId}",request.getId().toString());
        template = template.replace("${creationDate}", 
                DateUtils.format(request.getCreationDate()));
        template = template.replace("${expirationDate}",
            DateUtils.format(DateUtils.getShiftedDate(request.getCreationDate(), 
                    Calendar.DAY_OF_YEAR, liveDuration + 1))
        );
        
        return template;
    }
    
    protected Set<Critere> prepareQueryParams(Integer dateInterval) {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.SEARCH_BY_CREATION_DATE);
        criteria.setComparatif(Critere.LTE);
        criteria.setValue(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR, -dateInterval));
        criterias.add(criteria);
        
        criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);
        
        return criterias;
    }

    public void setRequestActionService(IRequestActionService requestActionService) {
        this.requestActionService = requestActionService;
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }
}
