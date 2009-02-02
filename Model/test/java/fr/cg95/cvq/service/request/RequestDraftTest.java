package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.leisure.music.IMusicSchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Request service draft test case
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class RequestDraftTest extends ServiceTestCase {
    private IRequestDAO requestDAO;
    private IMusicSchoolRegistrationRequestService requestService;
    private IHomeFolderService homeFolderService;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        requestDAO = this.getApplicationBean("requestDAO");
        requestService = this.getApplicationBean("musicSchoolRegistrationRequestService");
        homeFolderService = this.getApplicationBean("homeFolderService");
    }
    
    public void testDrafts() throws CvqException {
        int draftStep = 2;
        this.createDrafts(draftStep);
        List<Request> drafts = this.getDrafts();
        assertEquals(draftStep,drafts.size());
        
        List<Adult> adults = this.homeFolderService.getAdults(drafts.get(0).getHomeFolderId());
        if(adults.size() > 0) {
            Request draft1 = drafts.get(0);
            Adult adult1 = adults.get(0);
            this.continueWithNewTransaction();
            draft1.setSubjectId(adult1.getId());
            draft1.setSubjectLastName(adult1.getLastName());
            draft1.setSubjectFirstName(adult1.getFirstName());
            this.requestService.processDraft(draft1);
            
            Request draft2 = drafts.get(1);
            
            try {
                this.continueWithNewTransaction();
                draft2.setSubjectId(adult1.getId());
                this.requestService.processDraft(draft2);
                fail();
            }catch (CvqModelException e) {}
            
            this.requestService.delete(draft1.getId());
            this.continueWithNewTransaction();
            this.requestService.processDraft(draft2);
            this.requestService.finalizeDraft(draft2);
            
            try {
                this.getDraftById(draft2.getId());
                fail();
            }catch (IndexOutOfBoundsException e) {}
            this.requestService.delete(draft2.getId());
        }
    }
    
    List<Request> getDrafts() {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);

        return this.requestDAO.search(criterias,null,null,0,0);
    }
    
    Request getDraftById(Long id) {
        Set<Critere> criterias = new HashSet<Critere>();
        
        Critere criteria = new Critere();
        criteria.setAttribut(Request.DRAFT);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(true);
        criterias.add(criteria);
        
        criteria = new Critere();
        criteria.setAttribut(Request.SEARCH_BY_REQUEST_ID);
        criteria.setComparatif(Critere.EQUALS);
        criteria.setValue(id);
        criterias.add(criteria);
        
        List<Request> reqs = this.requestDAO.search(criterias,null,null,0,0);
        
        return reqs.get(0);
    }
    
    void createDrafts(int step) throws CvqException {
        CreationBean bean = this.gimmeAnHomeFolder();
        
        for(int i = 1;i<=step;i++) {
            SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(bean.getLogin());
            List<Individual> indivs = 
                SecurityContext.getCurrentEcitizen().getHomeFolder().getIndividuals();
            
            Request request = new MusicSchoolRegistrationRequest();
            request.setRequesterId(SecurityContext.getCurrentEcitizen().getId());
            request.setSubjectId(indivs.get(i).getId());
            this.requestService.prepareDraft(request);
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
            for(Request r : requests) this.requestService.delete(r.getId());
        } catch(CvqObjectNotFoundException e) {
            e.printStackTrace();
            for(Request r : requests) this.requestDAO.delete(r);
        }
        super.onTearDown();
    }
    
    
}