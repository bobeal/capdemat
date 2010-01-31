package fr.cg95.cvq.service.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.request.school.SchoolRegistrationRequestFeeder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

public class RequestSeasonServiceTest extends RequestTestCase {
    
    private Long requestTypeId;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    
    @Override
    protected void onSetUp() throws Exception {
        
        super.onSetUp();
        
        schoolRegistrationRequestService = 
            super.<ISchoolRegistrationRequestService>getApplicationBean("schoolRegistrationRequestService");
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        // find the first request type with registrations/seasons notions
        List<RequestType> requestTypesSet = iRequestTypeService.getAllRequestTypes();
        for (RequestType tempRequestType : requestTypesSet) {
            IRequestService service = 
                iRequestServiceRegistry.getRequestService(tempRequestType.getLabel());
            if (service.isOfRegistrationKind()) {
                requestTypeId = tempRequestType.getId();
                break;
            }
        }
        if (requestTypeId == null)
            fail("Could not find a request service that supports seasons !");
    }
    
    @Override
    protected void onTearDown() throws Exception {
        // finally remove all seasons related settings

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        Set<Long> ids = new HashSet<Long>();
        for (RequestSeason rs :
            iRequestTypeService.getRequestSeasons(requestTypeId)) {
            ids.add(rs.getId());
        }
        for (Long id : ids) {
            iRequestTypeService.removeRequestSeason(requestTypeId, id);
        }
        continueWithNewTransaction();
        
        // test all seasons have been succesfully removed
        assertEquals(0, iRequestTypeService.getRequestSeasons(requestTypeId).size());
        
        super.onTearDown();
    }
    
    public void testGoodSeasonManagement() throws CvqException {

        // Create
        RequestSeason season1 =
            BusinessObjectsFactory.gimmeRequestSeason("saison 1234", 1, 2, 3, 4);
        iRequestTypeService.addRequestSeason(requestTypeId, season1);
        continueWithNewTransaction();
        RequestSeason season2 = BusinessObjectsFactory.gimmeRequestSeason("saison 5678", 5, 6, 7, 8);
        iRequestTypeService.addRequestSeason(requestTypeId, season2);

        continueWithNewTransaction();
        
        Set<RequestSeason> seasons = iRequestTypeService.getRequestSeasons(requestTypeId);
        assertEquals(2, seasons.size());
        // refresh seasons from DB
        for (RequestSeason s : seasons) {
            if (s.getLabel().equals(season1.getLabel()))
                season1 = s;
            else season2 = s;
        }
        
        // Get
        RequestSeason season3 = iRequestTypeService.getRequestSeason(requestTypeId, season1.getId());
        continueWithNewTransaction();
        assertEquals(season3.getLabel(), season1.getLabel());

        // Modify
        season1 = iRequestTypeService.getRequestSeason(requestTypeId, season1.getId());
        updateSeason(season1, "saison 6789", 6, 7, 8, 9);
  
        iRequestTypeService.modifyRequestSeason(requestTypeId, season1);

        continueWithNewTransaction();

        assertEquals(2, iRequestTypeService.getRequestSeasons(requestTypeId).size());
        
        // Remove
        iRequestTypeService.removeRequestSeason(requestTypeId, season2.getId());

        continueWithNewTransaction();

        Set<RequestSeason> requestTypeSeasons =
            iRequestTypeService.getRequestSeasons(requestTypeId);
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
            iRequestTypeService.addRequestSeason(requestTypeId, season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    private void checkModifySeasonError(RequestSeason season, String errorMessage) throws CvqException {
        try {
            iRequestTypeService.modifyRequestSeason(requestTypeId, season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    public void testErrorSeasonManagement() throws CvqException {
        // Create
        RequestSeason season =
            BusinessObjectsFactory.gimmeRequestSeason("saison 1235", 1, 2, 3, 5);
        iRequestTypeService.addRequestSeason(requestTypeId, season);
        continueWithNewTransaction();
        // refresh season from db
        Set<RequestSeason> seasons =
            iRequestTypeService.getRequestSeasons(requestTypeId);
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
        season = iRequestTypeService.getRequestSeason(requestTypeId, season.getId());
        continueWithNewTransaction();
        badSeason = BusinessObjectsFactory.gimmeRequestSeason(season.getLabel(), 0, 2, 3, 5);
        badSeason.setId(season.getId());
        checkModifySeasonError(badSeason, "request.season.registration_started");
        
        continueWithNewTransaction();
        
        // request.season.effect_ended
        daoUpdateSeason(season, season.getLabel(), -5 , -6, -6, -6); // season=[-6, -4, -3, -1]
        continueWithNewTransaction();
        season = iRequestTypeService.getRequestSeason(requestTypeId, season.getId());
        continueWithNewTransaction();
        badSeason = BusinessObjectsFactory.gimmeRequestSeason(season.getLabel(), -7, -4, -3, -1);
        badSeason.setId(season.getId());
        checkModifySeasonError(badSeason, "request.season.effect_ended");
    }
    
    public void testGetRequestAssociatedSeason() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        requestTypeId =
            iRequestTypeService.getRequestTypeByLabel(schoolRegistrationRequestService.getLabel()).getId();
        
        /* Create a season */
        RequestSeason season = BusinessObjectsFactory.gimmeRequestSeason("Saison 1235", 1, 2, 3, 5);
        iRequestTypeService.addRequestSeason(requestTypeId, season);
        
        continueWithNewTransaction();
        // refresh season from db
        Set<RequestSeason> seasons =
            iRequestTypeService.getRequestSeasons(requestTypeId);
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
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        SchoolRegistrationRequest request = new SchoolRegistrationRequest();
        request.setRequestSeason(season);
        request.setRequesterId(iHomeFolderService.getHomeFolderResponsible(homeFolderId).getId());
        SchoolRegistrationRequestFeeder.setSubject(request, 
                schoolRegistrationRequestService.getSubjectPolicy(), null, homeFolder);

        Long requestId = schoolRegistrationRequestService.create(request);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        /* Test season associated to the school registration request */
        assertEquals(season, iRequestService.getById(requestId).getRequestSeason());
        
        assertNull(iRequestService.getById(voCardRequestId).getRequestSeason());
        
        iRequestService.delete(requestId);
        iRequestTypeService.removeRequestSeason(requestTypeId, season.getId());
    }
}
