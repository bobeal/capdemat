package fr.cg95.cvq.service.request.job;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.SectionType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.request.school.SchoolRegistrationRequestFeeder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class RequestSeasonsJobTest extends ServiceTestCase {
 
    private RequestSeasonsJob requestSeasonsJob;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    private RequestType requestType;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        requestSeasonsJob = super.<RequestSeasonsJob>getApplicationBean("requestSeasonsJob");
        schoolRegistrationRequestService =
            super.<ISchoolRegistrationRequestService>getApplicationBean("schoolRegistrationRequestService");
    }
    
    /**
     * Bypass service business rules (like "request.season.registration_started")
     * Add month's offset to registration and effect dates
     */
    private void daoUpdateSeason(String seasonUuid, int registrationStartOffset,
        int registrationEndOffset, int effectStartOffset, int effectEndOffset) {

        GenericDAO genericDAO = super.<GenericDAO>getApplicationBean("genericDAO");

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
    }

    public void testJob() throws CvqException {
       
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
        String proposedLogin = cb.getLogin();

        // close current session and re-open a new one
        continueWithNewTransaction();
    
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Assert.assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        SchoolRegistrationRequest request = new SchoolRegistrationRequest();
        request.setSection(SectionType.BEFORE_FIRST_SECTION);
        request.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
        request.setSchool(schoolService.getAll().iterator().next());
        request.setUrgencyPhone("0101010101");
        request.setCurrentSection(SectionType.BEFORE_FIRST_SECTION);
        request.setCurrentSchoolAddress("CurrentSchoolAddress");
        request.setCurrentSchoolName("CurrentSchoolName");
        request.setRequesterId(iHomeFolderService.getHomeFolderResponsible(homeFolderId).getId());
        SchoolRegistrationRequestFeeder.setSubject(request, 
                schoolRegistrationRequestService.getSubjectPolicy(), null, homeFolder);

        MeansOfContact meansOfContact = 
            iMeansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);

        Long requestId = schoolRegistrationRequestService.create(request);

        continueWithNewTransaction();
        
        /* Treat the school registration request (in BackOffice) */
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iRequestWorkflowService.updateRequestState(requestId, RequestState.COMPLETE, null);
        iRequestWorkflowService.updateRequestState(requestId, RequestState.VALIDATED, null);
        iRequestWorkflowService.updateRequestState(requestId, RequestState.NOTIFIED,
            "Bon pour inscription");

        /* Must not change requestState (season's effect isn't started) */
        requestSeasonsJob.launchJob();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request requestFromDb = iRequestService.getById(requestId);
        Assert.assertEquals(requestFromDb.getState(), RequestState.NOTIFIED);
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        /* Make season effect start */
        daoUpdateSeason(season.getUuid(), -3, -4, -4, -4); // season =[-4, -2, -1, 1];
        
        /* Must set requestState to 'ACTIVE' */
        requestSeasonsJob.launchJob();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestFromDb = iRequestService.getById(requestId);
        Assert.assertEquals(requestFromDb.getState(), RequestState.ACTIVE);
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        /* Make season effect end */
        daoUpdateSeason(season.getUuid(), -2, -2, -2, -2); // season =[-6, -4, -3, -1];
        
        /* Must set requestState to 'EXPIRE' */
        requestSeasonsJob.launchJob();
        
        // the job clauses the current transaction, so re-open a new one
        startTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestFromDb = iRequestService.getById(requestId);
        assertEquals(requestFromDb.getState(), RequestState.EXPIRED);
        iRequestService.delete(requestId);
        
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        iRequestTypeService.removeRequestTypeSeason(requestType.getId(), season.getUuid());
    }
}
