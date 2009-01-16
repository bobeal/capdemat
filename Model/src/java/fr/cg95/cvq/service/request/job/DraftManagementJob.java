package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.mail.IMailService;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Permits to mamage drafts 
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */

public class DraftManagementJob {
    
    private IRequestService requestService;
    private Integer liveDuration;
    private Integer notificationBeforeDelete;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IMailService mailService;
    private IIndividualService individualService;

    public void launchJob() {
        
    }
    
    public void deleteExpiredDrafts() throws CvqException {
        Set<Critere> criterias = this.prepareQueryParams(liveDuration+1);
        List<Request> requests = this.requestService.get(criterias,null,null,0,0);
        for(Request r : requests) this.requestService.delete(r.getId());
    }
    
    public Integer sendNotifications() throws CvqException {
        Integer counter = 0;
        Set<Critere> criterias = this.prepareQueryParams(
            (liveDuration+1)+notificationBeforeDelete);
        
        List<Request> requests = this.requestService.get(criterias,null,null,0,0);
        for(Request r : requests) {
            counter ++;
            Adult adult = (Adult)this.individualService.getById(r.getId());
            String from = r.getRequestType().getCategory().getPrimaryEmail();
            mailService.send(from,adult.getEmail(),null,null,this.buildMailTemplate(r));
        }
        return counter;
    }
    
    protected String buildMailTemplate(Request request) throws CvqException {
        String template = this.localAuthorityRegistry.getBufferedCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.TXT_ASSETS_RESOURCE_TYPE,
            "NotificationBeforeDraftDelete.txt",
            false
        );
        
        template = template.replace("${requestType}",request.getRequestType().getLabel());
        template = template.replace("${requestId}",request.getId().toString());
        template = template.replace("${creationDate}", DateUtils.format(request.getCreationDate()));
        template = template.replace(
            "${expirationDate}",
            DateUtils.format(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,liveDuration+1))
        );
        
        return template;
    }
    
    protected Set<Critere> prepareQueryParams(Integer dateInterval) {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.SEARCH_BY_CREATION_DATE);
        criteria.setComparatif(Critere.LTE);
        criteria.setValue(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,(dateInterval)));
        criterias.add(criteria);
        
        criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);
        
        return criterias;
    }

    public IRequestService getRequestService() {
        return requestService;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public Integer getLiveDuration() {
        return liveDuration;
    }

    public void setLiveDuration(Integer liveDuration) {
        this.liveDuration = liveDuration;
    }

    public Integer getNotificationBeforeDelete() {
        return notificationBeforeDelete;
    }

    public void setNotificationBeforeDelete(Integer notificationBeforeDelete) {
        this.notificationBeforeDelete = notificationBeforeDelete;
    }

    public ILocalAuthorityRegistry getLocalAuthorityRegistry() {
        return localAuthorityRegistry;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public IMailService getMailService() {
        return mailService;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public IIndividualService getIndividualService() {
        return individualService;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }
}
