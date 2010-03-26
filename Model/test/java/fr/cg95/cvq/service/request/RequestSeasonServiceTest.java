package fr.cg95.cvq.service.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

public class RequestSeasonServiceTest extends RequestTestCase {
    
    private Long requestTypeId;
    
    @Autowired
    protected IRequestServiceRegistry requestServiceRegistry;

    @Override
    public void onSetUp() throws Exception {
        
        super.onSetUp();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        // find the first request type with registrations/seasons notions
        List<RequestType> requestTypesSet = requestTypeService.getAllRequestTypes();
        for (RequestType tempRequestType : requestTypesSet) {
            IRequestService service = 
                requestServiceRegistry.getRequestService(tempRequestType.getLabel());
            if (service.isOfRegistrationKind() 
                    && service.getSubjectPolicy().equals(IRequestWorkflowService.SUBJECT_POLICY_CHILD)) {
                requestTypeId = tempRequestType.getId();
                break;
            }
        }
        if (requestTypeId == null)
            fail("Could not find a request service that supports seasons !");
    }
    
    @Override
    public void onTearDown() throws Exception {
        // finally remove all seasons related settings

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        Set<Long> ids = new HashSet<Long>();
        for (RequestSeason rs :
            requestTypeService.getRequestSeasons(requestTypeId)) {
            ids.add(rs.getId());
        }
        for (Long id : ids) {
            requestTypeService.removeRequestSeason(requestTypeId, id);
        }
        continueWithNewTransaction();
        
        // test all seasons have been succesfully removed
        assertEquals(0, requestTypeService.getRequestSeasons(requestTypeId).size());
        
        super.onTearDown();
    }
    
    @Test
    public void testGoodSeasonManagement() throws CvqException {

        // Create
        RequestSeason season1 =
            BusinessObjectsFactory.gimmeRequestSeason("saison 1234", 1, 2, 3, 4);
        requestTypeService.addRequestSeason(requestTypeId, season1);
        continueWithNewTransaction();
        RequestSeason season2 = BusinessObjectsFactory.gimmeRequestSeason("saison 5678", 5, 6, 7, 8);
        requestTypeService.addRequestSeason(requestTypeId, season2);

        continueWithNewTransaction();
        
        Set<RequestSeason> seasons = requestTypeService.getRequestSeasons(requestTypeId);
        assertEquals(2, seasons.size());
        // refresh seasons from DB
        for (RequestSeason s : seasons) {
            if (s.getLabel().equals(season1.getLabel()))
                season1 = s;
            else season2 = s;
        }
        
        // Get
        RequestSeason season3 = requestTypeService.getRequestSeason(requestTypeId, season1.getId());
        continueWithNewTransaction();
        assertEquals(season3.getLabel(), season1.getLabel());

        // Modify
        season1 = requestTypeService.getRequestSeason(requestTypeId, season1.getId());
        updateSeason(season1, "saison 6789", 6, 7, 8, 9);
  
        requestTypeService.modifyRequestSeason(requestTypeId, season1);

        continueWithNewTransaction();

        assertEquals(2, requestTypeService.getRequestSeasons(requestTypeId).size());
        
        // Remove
        requestTypeService.removeRequestSeason(requestTypeId, season2.getId());

        continueWithNewTransaction();

        Set<RequestSeason> requestTypeSeasons =
            requestTypeService.getRequestSeasons(requestTypeId);
        assertEquals(1, requestTypeSeasons.size());
        assertFalse(requestTypeSeasons.contains(season2));
    }

    private void daoUpdateSeason(RequestSeason requestSeason, String label, int registrationStartOffset,
            int registrationEndOffset, int effectStartOffset, int effectEndOffset) {
        updateSeason(requestSeason, label, registrationStartOffset,
            registrationEndOffset, effectStartOffset, effectEndOffset);
        GenericDAO genericDAO = super.getApplicationBean("genericDAO");
        genericDAO.update(requestSeason);
        continueWithNewTransaction();
    }

    /* Bypass service business rules (like "request.season.registration_started")
     * Add month's offset to registration and effect dates
     */
    private void updateSeason(RequestSeason requestSeason, String label, int registrationStartOffset,
        int registrationEndOffset, int effectStartOffset, int effectEndOffset) {
        requestSeason.setRegistrationStart(
            requestSeason.getRegistrationStart()
                .plusMonths(registrationStartOffset));
        requestSeason.setRegistrationEnd(
            requestSeason.getRegistrationEnd()
                .plusMonths(registrationEndOffset));
        requestSeason.setEffectStart(
            requestSeason.getEffectStart().plusMonths(effectStartOffset));
        requestSeason.setEffectEnd(
            requestSeason.getEffectEnd().plusMonths(effectEndOffset));
        requestSeason.setLabel(label);
    }
    
    private void checkCreateSeasonError(RequestSeason season, String errorMessage) throws CvqException {
        try {
            requestTypeService.addRequestSeason(requestTypeId, season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    private void checkModifySeasonError(RequestSeason season, String errorMessage) throws CvqException {
        try {
            requestTypeService.modifyRequestSeason(requestTypeId, season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    @Test
    public void testErrorSeasonManagement() throws CvqException {
        // Create
        RequestSeason season =
            BusinessObjectsFactory.gimmeRequestSeason("saison 1235", 1, 2, 3, 5);
        requestTypeService.addRequestSeason(requestTypeId, season);
        continueWithNewTransaction();
        // refresh season from db
        Set<RequestSeason> seasons =
            requestTypeService.getRequestSeasons(requestTypeId);
        assertEquals(1, seasons.size());
        season = seasons.iterator().next();

        RequestSeason badSeason;
        
        // request.season.registration_start_required
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6789", 6, 7, 8, 9);
        badSeason.setRegistrationStart(null);
        checkCreateSeasonError(badSeason, "request.season.registration_start_required");
        
        // request.season.registration_end_required
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6789", 6, 7, 8, 9);
        badSeason.setRegistrationEnd(null);
        checkCreateSeasonError(badSeason, "request.season.registration_end_required");
        
        // request.season.effect_start_required
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6789", 6, 7, 8, 9);
        badSeason.setEffectStart(null);
        checkCreateSeasonError(badSeason, "request.season.effect_start_required");
        
        // request.season.effect_end_required
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6789", 6, 7, 8, 9);
        badSeason.setEffectEnd(null);
        checkCreateSeasonError(badSeason, "request.season.effect_end_required");
        
        // request.season.registration_start_before_now
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison -1789", -1, 7, 8, 9);
        checkCreateSeasonError(badSeason, "request.season.registration_start_before_now");
        
        // request.season.registration_start_after_registration_end
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 7689", 7, 6, 8, 9);
        checkCreateSeasonError(badSeason, "request.season.registration_start_after_registration_end");
        
        // request.season.effect_start_after_effect_end
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6798", 6, 7, 9, 8);
        checkCreateSeasonError(badSeason, "request.season.effect_start_after_effect_end");
        
        // request.season.registration_start_after_effect_start
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 7868", 7, 8, 6, 8);
        checkCreateSeasonError(badSeason, "request.season.registration_start_after_effect_start");
        
        // request.season.registration_end_after_effect_end
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 6978", 6, 9, 7, 8);
        checkCreateSeasonError(badSeason, "request.season.registration_end_after_effect_end");
        
        // request.season.already_used_label
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 1235", 6, 7, 8, 9);
        checkCreateSeasonError(badSeason, "request.season.already_used_label");
        
        // request.season.registration_started
        continueWithNewTransaction();
        daoUpdateSeason(season, season.getLabel(), -2 , 0, 0, 0); // season=[-1, 2, 3, 5]
        continueWithNewTransaction();
        season = requestTypeService.getRequestSeason(requestTypeId, season.getId());
        continueWithNewTransaction();
        badSeason = BusinessObjectsFactory.gimmeRequestSeason(season.getLabel(), 0, 2, 3, 5);
        badSeason.setId(season.getId());
        checkModifySeasonError(badSeason, "request.season.registration_started");
        
        continueWithNewTransaction();
        
        // request.season.effect_ended
        daoUpdateSeason(season, season.getLabel(), -5 , -6, -6, -6); // season=[-6, -4, -3, -1]
        continueWithNewTransaction();
        season = requestTypeService.getRequestSeason(requestTypeId, season.getId());
        continueWithNewTransaction();
        badSeason = BusinessObjectsFactory.gimmeRequestSeason(season.getLabel(), -7, -4, -3, -1);
        badSeason.setId(season.getId());
        checkModifySeasonError(badSeason, "request.season.effect_ended");
    }
    
    @Test
    public void testGetRequestAssociatedSeason() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        /* Create a season */
        RequestSeason season = BusinessObjectsFactory.gimmeRequestSeason("Saison 1235", 1, 2, 3, 5);
        requestTypeService.addRequestSeason(requestTypeId, season);
        
        continueWithNewTransaction();
        // refresh season from db
        Set<RequestSeason> seasons = requestTypeService.getRequestSeasons(requestTypeId);
        assertEquals(1, seasons.size());
        season = seasons.iterator().next();
        
        /* Make season registration start */
        daoUpdateSeason(season, season.getLabel(), -2, 0, 0, 0); // season =[0, 2, 3, 5];

        /* Request for a school registration (in FrontOffice) */
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();
        Long voCardRequestId = cb.getRequestId();
        String proposedLogin = cb.getLogin();

        // close current session and re-open a new one
        continueWithNewTransaction();
    
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);
        
        RequestType requestType = requestTypeService.getRequestTypeById(requestTypeId);
        IRequestService requestService = 
            requestServiceRegistry.getRequestService(requestType.getLabel());
        Request request = requestService.getSkeletonRequest();
        request.setRequestSeason(season);
        request.setRequesterId(homeFolderService.getHomeFolderResponsible(homeFolderId).getId());
        request.setSubjectId(child1.getId());

        Long requestId = requestWorkflowService.create(request);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        /* Test season associated to the school registration request */
        assertEquals(season, requestSearchService.getById(requestId, false).getRequestSeason());
        
        assertNull(requestSearchService.getById(voCardRequestId, false).getRequestSeason());
        
        requestWorkflowService.delete(requestId);
        continueWithNewTransaction();
        requestTypeService.removeRequestSeason(requestTypeId, season.getId());
    }
}
