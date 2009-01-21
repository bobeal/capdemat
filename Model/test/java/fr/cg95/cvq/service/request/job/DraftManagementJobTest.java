package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.util.mail.IMailService;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Test suite for {@link fr.cg95.cvq.service.request.job.DraftManagementJob }
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DraftManagementJobTest extends ServiceTestCase {
    
    private IRequestDAO requestDAO;
    private IRequestService requestService;
    private IBirthDetailsRequestService birthDetailsRequestService;
    private DraftManagementJob draftManagementJob;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        Integer liveDuration = 4;
        Integer notificationBeforeDelete = 2;
        this.requestService = this.getApplicationBean("defaultRequestService");
        IIndividualService individualService = this.getApplicationBean("individualService");
        this.draftManagementJob = this.getApplicationBean("draftManagementJob");
        IMailService mailService = this.getApplicationBean("mailService");
        this.requestDAO = this.getApplicationBean("requestDAO");
        ILocalizationService localizationService = this.getApplicationBean("localizationService");
        ILocalAuthorityRegistry localAuthorityRegistry = this.getApplicationBean("localAuthorityRegistry");
        this.birthDetailsRequestService = this.getApplicationBean("birthDetailsRequestService");
        
        this.draftManagementJob.setIndividualService(individualService);
        this.draftManagementJob.setLiveDuration(liveDuration);
        this.draftManagementJob.setLocalAuthorityRegistry(localAuthorityRegistry);
        this.draftManagementJob.setLocalizationService(localizationService);
        this.draftManagementJob.setMailService(mailService);
        this.draftManagementJob.setNotificationBeforeDelete(notificationBeforeDelete);
        this.draftManagementJob.setRequestDAO(requestDAO);
        this.draftManagementJob.setRequestService(requestService);
    }
    
    public void testRequestDraftRemoval() throws CvqException {
        this.createDrafts(4);
//        List<Request> requests = this.getDrafts();
        int before = this.getDrafts().size();
        this.draftManagementJob.deleteExpiredDrafts();
        int after = this.getDrafts().size();
        assertEquals(before-1,after);
        
        this.draftManagementJob.setLiveDuration(3);
        this.draftManagementJob.deleteExpiredDrafts();
        assertEquals(after-1,this.getDrafts().size());
        
        this.draftManagementJob.setLiveDuration(1);
        this.draftManagementJob.deleteExpiredDrafts();
        assertEquals(0,this.getDrafts().size());
    }
    
    public void testDraftMailSending() throws CvqException {
        this.createDrafts(8);
        
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        this.draftManagementJob.setLiveDuration(9);
        this.draftManagementJob.setNotificationBeforeDelete(4);
        int mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(mailsCount,4);
        mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(mailsCount,0);
        this.draftManagementJob.setNotificationBeforeDelete(5);
        mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(mailsCount,1);
    }

    protected List<Request> getDrafts() {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);

        return this.requestDAO.search(criterias,null,null,0,0);
    }
    
    void createDrafts(int step) throws CvqException {
        CreationBean bean = this.gimmeAnHomeFolder();
        
        for(int i = 1;i<=step;i++) {
            SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(bean.getLogin());
            Request request = new BirthDetailsRequest();
            this.birthDetailsRequestService.prepareDraft(request);
            Long id = this.birthDetailsRequestService.processDraft(request);
            request = this.birthDetailsRequestService.getById(id);
            request.setCreationDate(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,i*(-1)));
            
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);
            this.birthDetailsRequestService.modify(request);
        }
    }
    
    @Override
    protected void onTearDown() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);
        List<Request> requests = this.getDrafts();
        
        try {
            for(Request r : requests) this.requestService.delete(r.getId());
        } catch(CvqObjectNotFoundException e) {
            e.printStackTrace();
            for(Request r : requests) this.requestDAO.delete(r);
        }
        
        super.onTearDown();
    }
}
