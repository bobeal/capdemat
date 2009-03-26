package fr.cg95.cvq.service.request;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
import fr.cg95.cvq.testtool.ServiceTestCase;

public class RequestSeasonServiceTest extends ServiceTestCase {
    
    private RequestType requestType;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    
    @Override
    protected void onSetUp() throws Exception {
        
        super.onSetUp();
        
        schoolRegistrationRequestService = 
            (ISchoolRegistrationRequestService) getBean(ISchoolRegistrationRequestService.SERVICE_NAME);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        // find the first request type with registrations/seasons notions
        List<RequestType> requestTypesSet = iRequestTypeService.getAllRequestTypes();
        requestType = null;
        for (RequestType tempRequestType : requestTypesSet) {
            IRequestService service = 
                iRequestServiceRegistry.getRequestService(tempRequestType.getLabel());
            if (service.isOfRegistrationKind()) {
                requestType = tempRequestType;
                break;
            }
        }
        if (requestType == null)
            fail("Could not find a request service that supports seasons !");
    }
    
    @Override
    protected void onTearDown() throws Exception {
        // finally remove all seasons related settings

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        Set<RequestSeason> requestSeasons = 
            iRequestTypeService.getRequestTypeSeasons(requestType.getId());
        Set<String> uuids = new HashSet<String>();
        for (RequestSeason rs : requestSeasons) {
            uuids.add(rs.getUuid());
        }
        for (String uuid : uuids) {
            iRequestTypeService.removeRequestTypeSeason(requestType.getId(), uuid);            
        }
        
        continueWithNewTransaction();
        
        // test all seasons have been succesfully removed
        requestType = iRequestTypeService.getRequestTypeById(requestType.getId());
        assertEquals(0, requestType.getSeasons().size());
        
        super.onTearDown();
    }
    
    public void testGoodSeasonManagement() throws CvqException {

        // Create
        RequestSeason season1 =
            BusinessObjectsFactory.gimmeRequestSeason("saison 0123", 0, 1, 2, 3);
        iRequestTypeService.addRequestTypeSeason(requestType.getId(), season1);
        season1 = BusinessObjectsFactory.gimmeRequestSeason("saison 4567", 4, 5, 6, 7);
        iRequestTypeService.addRequestTypeSeason(requestType.getId(), season1);
        
        continueWithNewTransaction();
        
        assertEquals(2, requestType.getSeasons().size());
        
        // Get
        RequestSeason season3 = iRequestTypeService.getRequestTypeSeason(requestType.getId(), season1.getUuid());
        continueWithNewTransaction();
        assertEquals(season3.getLabel(), season1.getLabel());

        // Modify
        RequestSeason season2 = 
            BusinessObjectsFactory.gimmeRequestSeason("saison 5678", 5, 6, 7, 8);
        season2.setUuid(season1.getUuid());
  
        iRequestTypeService.modifyRequestTypeSeason(requestType.getId(), season2);

        continueWithNewTransaction();

        assertEquals(2, requestType.getSeasons().size());
        
        // Remove
        iRequestTypeService.removeRequestTypeSeason(requestType.getId(), season2.getUuid());

        continueWithNewTransaction();

        Set<RequestSeason> requestTypeSeasons =
            iRequestTypeService.getRequestTypeSeasons(requestType.getId());
        assertEquals(1, requestTypeSeasons.size());
        assertFalse(requestTypeSeasons.contains(season2));
    }
    
    /* Bypass service business rules (like "request.season.registration_started")
     * Add month's offset to registration and effect dates
     */
    private void daoUpdateSeason(String seasonUuid, int registrationStartOffset, 
            int registrationEndOffset, int effectStartOffset, int effectEndOffset) 
        throws CvqException {
       try {
           GenericDAO genericDAO = (GenericDAO) getBean("genericDAO");
       
           Calendar calendar = new GregorianCalendar();
           
           Set<RequestSeason> seasonSet = requestType.getSeasons();
           for (RequestSeason season : seasonSet)
               if (season.getUuid().equals(seasonUuid)) {
                   // registration start
                   calendar.setTime(season.getRegistrationStart());
                   calendar.add(Calendar.MONTH, registrationStartOffset);
                   season.setRegistrationStart(calendar.getTime());
                   // registration end
                   calendar.setTime(season.getRegistrationEnd());
                   calendar.add(Calendar.MONTH, registrationEndOffset);
                   season.setRegistrationEnd(calendar.getTime());
                   // effect start
                   calendar.setTime(season.getEffectStart());
                   calendar.add(Calendar.MONTH, effectStartOffset);
                   season.setEffectStart(calendar.getTime());
                   // effect end
                   calendar.setTime(season.getEffectEnd());
                   calendar.add(Calendar.MONTH, effectEndOffset);
                   season.setEffectEnd(calendar.getTime());
               }
           
           genericDAO.update(requestType);
           continueWithNewTransaction();
       } catch (Exception e) {
           throw new CvqException(e.getMessage());
       }
    }
    
    private void checkCreateSeasonError(RequestSeason season, String errorMessage) throws CvqException {
        try {
            iRequestTypeService.addRequestTypeSeason(requestType.getId(), season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    private void checkModifySeasonError(RequestSeason season, String errorMessage) throws CvqException {
        try {
            iRequestTypeService.modifyRequestTypeSeason(requestType.getId(), season);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals(errorMessage, cme.getMessage());
        }
    }
    
    public void testErrorSeasonManagement() throws CvqException {
        // Create
        RequestSeason season =
            BusinessObjectsFactory.gimmeRequestSeason("saison 0235", 0, 2, 3, 5);
        iRequestTypeService.addRequestTypeSeason(requestType.getId(), season);

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
        
        // request.season.seasons_registration_overlapped
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 1389", 1, 3, 8, 9);
        checkCreateSeasonError(badSeason, "request.season.seasons_registration_overlapped");
        
        // request.season.seasons_effect_overlapped
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 3446", 3, 4 ,4 ,6 );
        checkCreateSeasonError(badSeason, "request.season.seasons_effect_overlapped");
        
        // request.season.already_used_label
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 0235", 6, 7, 8, 9);
        checkCreateSeasonError(badSeason, "request.season.already_used_label");
        
        // request.season.registration_started
        daoUpdateSeason(season.getUuid(), -1 , 0, 0, 0); // season=[-1, 2, 3, 5]
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 1235", 1, 2, 3, 5);
        badSeason.setUuid(season.getUuid());
        checkModifySeasonError(badSeason, "request.season.registration_started");
        
        continueWithNewTransaction();
        
        // request.season.effect_ended
        daoUpdateSeason(season.getUuid(), -5 , -6, -6, -6); // season=[-6, -4, -3, -1]
        badSeason = BusinessObjectsFactory.gimmeRequestSeason("saison 1235", 1, 2, 3, 5);
        badSeason.setUuid(season.getUuid());
        checkModifySeasonError(badSeason, "request.season.effect_ended");
    }
    
    public void testGetRequestAssociatedSeason() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        requestType = 
            iRequestTypeService.getRequestTypeByLabel(schoolRegistrationRequestService.getLabel());
        
        /* Create a season */
        RequestSeason season = BusinessObjectsFactory.gimmeRequestSeason("Saison 0235", 0, 2, 3, 5);
        iRequestTypeService.addRequestTypeSeason(requestType.getId(), season);
        
        continueWithNewTransaction();
        
        /* Make season registration start */
        daoUpdateSeason(season.getUuid(), -1, 0, 0, 0); // season =[0, 2, 3, 5];

        /* Request for a school registration (in FrontOffice) */
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
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
        request.setRequesterId(iHomeFolderService.getHomeFolderResponsible(homeFolderId).getId());
        SchoolRegistrationRequestFeeder.setSubject(request, 
                schoolRegistrationRequestService.getSubjectPolicy(), null, homeFolder);

        Long requestId = schoolRegistrationRequestService.create(request);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        /* Test season associated to the school registration request */
        RequestSeason srrSeason = iRequestService.getRequestAssociatedSeason(requestId);
        assertEquals(season, srrSeason);
        
        srrSeason = iRequestService.getRequestAssociatedSeason(voCardRequestId);
        assertNull(srrSeason);
        
        iRequestService.delete(requestId);
    }
}
