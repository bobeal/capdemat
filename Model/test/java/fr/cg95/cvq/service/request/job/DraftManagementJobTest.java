package fr.cg95.cvq.service.request.job;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

/**
 * Test suite for {@link fr.cg95.cvq.service.request.job.DraftManagementJob }
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DraftManagementJobTest extends RequestTestCase {
    
    @Autowired
    protected DraftManagementJob draftManagementJob;
    
    @Override
    public void onTearDown() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);

        List<Request> requests = this.getDrafts(true);
        try {
            for (Request r : requests) 
                requestWorkflowService.delete(r.getId());
        } catch(CvqObjectNotFoundException e) {
            e.printStackTrace();
//            for(Request r : requests) this.requestDAO.delete(r);
        }
        
        super.onTearDown();
    }

    @Test
    public void testRequestDraftRemoval() throws CvqException {

        this.createDrafts(4);

        SecurityContext.getCurrentSite().setDraftLiveDuration(4);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(2);
        continueWithNewTransaction();
        
        int before = this.getDrafts(false).size();
        draftManagementJob.deleteExpiredDrafts();
        
        continueWithNewTransaction();
        
        int after = this.getDrafts(false).size();
        assertEquals(before-1,after);
        
        SecurityContext.getCurrentSite().setDraftLiveDuration(3);
        continueWithNewTransaction();
        
        draftManagementJob.deleteExpiredDrafts();
        
        continueWithNewTransaction();
        assertEquals(after-1,this.getDrafts(false).size());
        
        SecurityContext.getCurrentSite().setDraftLiveDuration(1);
        continueWithNewTransaction();
        
        draftManagementJob.deleteExpiredDrafts();
        
        continueWithNewTransaction();
        assertEquals(0,this.getDrafts(false).size());
    }
    
    @Test
    public void testDraftMailSending() throws CvqException {
        
        this.createDrafts(8);
        
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        SecurityContext.getCurrentSite().setDraftLiveDuration(9);
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(4);
        continueWithNewTransaction();
        
        int mailsCount = draftManagementJob.sendNotifications();
        
        continueWithNewTransaction();
        assertEquals(4, mailsCount);
        
        mailsCount = draftManagementJob.sendNotifications();
        assertEquals(0, mailsCount);
        
        SecurityContext.getCurrentSite().setDraftNotificationBeforeDelete(5);
        continueWithNewTransaction();
        
        mailsCount = draftManagementJob.sendNotifications();
        
        continueWithNewTransaction();
        assertEquals(1, mailsCount);
    }

    protected List<Request> getDrafts(boolean full) throws CvqException {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.SEARCH_BY_STATE);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(RequestState.DRAFT);
        criterias.add(criteria);

        return requestSearchService.get(criterias,null,null,0,0, full);
    }
    
    void createDrafts(int step) throws CvqException {
        CreationBean bean = this.gimmeAnHomeFolderWithRequest();
        
        for (int i = 1;i<=step;i++) {
            SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(bean.getLogin());
            Request request = new BirthDetailsRequest();
            request.setRequesterId(SecurityContext.getCurrentEcitizen().getId());
            request.setHomeFolderId(SecurityContext.getCurrentEcitizen().getHomeFolder().getId());
            request.setState(RequestState.DRAFT);
            Long id = requestWorkflowService.create(request);
            request = requestSearchService.getById(id, true);
            request.setCreationDate(DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR,i*(-1)));
            
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(this.agentNameWithManageRoles);
            requestWorkflowService.modify(request);
        }
        
        continueWithNewTransaction();
    }
}
