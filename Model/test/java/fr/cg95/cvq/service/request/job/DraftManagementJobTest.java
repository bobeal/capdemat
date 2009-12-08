package fr.cg95.cvq.service.request.job;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

/**
 * Test suite for {@link fr.cg95.cvq.service.request.job.DraftManagementJob }
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DraftManagementJobTest extends ServiceTestCase {
    
    private IBirthDetailsRequestService requestService;
    private DraftManagementJob draftManagementJob;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.requestService = this.getApplicationBean("birthDetailsRequestService");
        this.draftManagementJob = this.getApplicationBean("draftManagementJob");
    }
    
    public void testRequestDraftRemoval() throws CvqException {
        this.createDrafts(4);
        SecurityContext.getCurrentSite().setDraftLiveDuration(4);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(2);
        this.continueWithNewTransaction();
        
        int before = this.getDrafts().size();
        this.draftManagementJob.deleteExpiredDrafts();
        int after = this.getDrafts().size();
        assertEquals(before-1,after);
        
        SecurityContext.getCurrentSite().setDraftLiveDuration(3);
        this.continueWithNewTransaction();
        
        this.draftManagementJob.deleteExpiredDrafts();
        assertEquals(after-1,this.getDrafts().size());
        
        SecurityContext.getCurrentSite().setDraftLiveDuration(1);
        this.continueWithNewTransaction();
        
        this.draftManagementJob.deleteExpiredDrafts();
        assertEquals(0,this.getDrafts().size());
    }
    
    public void testDraftMailSending() throws CvqException {
        this.createDrafts(8);
        SecurityContext.getCurrentSite().setDraftLiveDuration(4);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(2);
        this.continueWithNewTransaction();
        
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        SecurityContext.getCurrentSite().setDraftLiveDuration(9);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(4);
        this.continueWithNewTransaction();
        
        int mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(4, mailsCount);
        mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(0, mailsCount);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(5);
        this.continueWithNewTransaction();
        
        mailsCount = this.draftManagementJob.sendNotifications();
        assertEquals(1, mailsCount);
    }

    protected List<Request> getDrafts() throws CvqException {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);

        return this.requestService.get(criterias,null,null,0,0);
    }
    
    void createDrafts(int step) throws CvqException {
        CreationBean bean = this.gimmeAnHomeFolder();
        
        for (int i = 1;i<=step;i++) {
            SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(bean.getLogin());
            Request request = new BirthDetailsRequest();
            request.setRequesterId(SecurityContext.getCurrentEcitizen().getId());
            request.setHomeFolderId(SecurityContext.getCurrentEcitizen().getHomeFolder().getId());
            Long id = this.requestService.processDraft(request);
            request = this.requestService.getById(id);
            request.setCreationDate(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,i*(-1)));
            
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);
            this.requestService.modify(request);
        }
    }
    
    @Override
    protected void onTearDown() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);
        List<Request> requests = this.getDrafts();
        
        try {
            for (Request r : requests) 
                this.requestService.delete(r.getId());
        } catch(CvqObjectNotFoundException e) {
            e.printStackTrace();
//            for(Request r : requests) this.requestDAO.delete(r);
        }
        
        super.onTearDown();
    }
}
