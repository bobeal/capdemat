package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.security.SecurityContext;
import org.apache.log4j.Logger;

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
    private IRequestService requestService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IMailService mailService;
    private IIndividualService individualService;
    private ILocalizationService localizationService;
    
    public void launchNotificationJob() {
        localAuthorityRegistry.browseAndCallback(this, "sendNotifications", null);
    }
    
    public void launchRemovalJob() {
        localAuthorityRegistry.browseAndCallback(this, "deleteExpiredDrafts", null);
    }
    
    public void deleteExpiredDrafts() throws CvqException {
        LocalAuthority authority = SecurityContext.getCurrentSite();
        
        Set<Critere> criterias = this.prepareQueryParams(authority.getDraftLiveDuration());
        List<Request> requests = this.requestDAO.search(criterias,null,null,0,0);
        for (Request r : requests) 
            this.requestService.delete(r.getId());
    }
    
    public Integer sendNotifications() throws CvqException {
        Integer counter = 0; 
        LocalAuthority authority = SecurityContext.getCurrentSite();
        Integer limit =
            authority.getDraftLiveDuration() - authority.getDraftNotificationBeforeDelete();
        
        List<Request> requests = this.requestDAO.listDraftedByNotificationAndDate(
            IRequestService.DRAFT_DELETE_NOTIFICATION,
            DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR, -limit));
        
        for (Request r : requests) {
            Adult adult = this.individualService.getAdultById(r.getRequesterId());
            String from = r.getRequestType().getCategory().getPrimaryEmail();
            boolean sent = false;
            
            try {
                String mailBody =
                    this.buildMailTemplate(r, authority.getDraftLiveDuration());
                if (mailBody != null) {
                    mailService.send(from, adult.getEmail(), null,
                        "[CapDémat] Expiration d'une demande sauvée en tant que brouillon",
                        this.buildMailTemplate(r, authority.getDraftLiveDuration()));
                }
                sent = true;
                counter ++;
            } catch (CvqException e) {
                logger.error("sendNotifications() "+e.getMessage());
            } finally {
                if (sent)
                    requestService.addSystemAction(r.getId(),
                        IRequestService.DRAFT_DELETE_NOTIFICATION);
            }
        }
        return counter;
    }
    
    protected String buildMailTemplate(Request request, Integer liveDuration) throws CvqException {
        String template = this.localAuthorityRegistry.getBufferedCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.TXT_ASSETS_RESOURCE_TYPE,
            "NotificationBeforeDraftDelete.txt",
            false
        );

        if (template == null)
            return null;
        template = template.replace("${requestType}", 
            localizationService.getRequestLabelTranslation(
                request.getClass().getName(), "fr", false));
        template = template.replace("${requestId}",request.getId().toString());
        template = template.replace("${creationDate}", DateUtils.format(request.getCreationDate()));
        template = template.replace("${expirationDate}",
            DateUtils.format(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,liveDuration+1))
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

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
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

    public void setLocalizationService(ILocalizationService localizationService) {
        this.localizationService = localizationService;
    }
}
