package fr.cg95.cvq.service.request.job;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SectionType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class RequestSeasonsJobTest extends ServiceTestCase {
 
    private RequestSeasonsJob requestSeasonsJob;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    private RequestType requestType;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        requestSeasonsJob =
            super.<RequestSeasonsJob>getApplicationBean("requestSeasonsJob");
        schoolRegistrationRequestService =
            super.<ISchoolRegistrationRequestService>
                getApplicationBean("schoolRegistrationRequestService");
    }
    
    /**
     * Bypass service business rules
     * (like "request.season.registration_started")
     * Add month's offset to registration and effect dates
     */
    private void daoUpdateSeason(RequestSeason requestSeason,
        int registrationStartOffset, int registrationEndOffset,
        int effectStartOffset, int effectEndOffset) {
        requestSeason.setRegistrationStart(
            requestSeason.getRegistrationStart()
                .plusMonths(registrationStartOffset));
        requestSeason.setRegistrationEnd(
            requestSeason.getRegistrationEnd()
                .plusMonths(registrationEndOffset));
        requestSeason.setEffectStart(
            requestSeason.getEffectStart()
                .plusMonths(effectStartOffset));
        requestSeason.setEffectEnd(
            requestSeason.getEffectEnd()
                .plusMonths(effectEndOffset));
        GenericDAO genericDAO = super.getApplicationBean("genericDAO");
        genericDAO.update(requestSeason);
        continueWithNewTransaction();
    }

    public void testJob() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        requestType = 
            iRequestTypeService.getRequestTypeByLabel(
                schoolRegistrationRequestService.getLabel());
        
        /* Create a season */
        RequestSeason season = BusinessObjectsFactory
            .gimmeRequestSeason("Saison 1235", 1, 2, 3, 5);
        iRequestTypeService.addRequestSeason(requestType.getId(), season);
        continueWithNewTransaction();
        season = iRequestTypeService.getRequestSeasons(requestType.getId())
            .iterator().next();
        /* Make season registration start */
        daoUpdateSeason(season, -2, 0, 0, 0); // season =[-1, 2, 3, 5];

        /* Request for a school registration (in FrontOffice) */
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        String proposedLogin = cb.getLogin();

        // close current session and re-open a new one
        continueWithNewTransaction();
    
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder =
            iHomeFolderService.getById(cb.getHomeFolderId());
        Assert.assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        Long requestIds[] = new Long[2];
        int i = 0;
        for (Individual individual : homeFolder.getIndividuals()) {
            if (individual instanceof Child) {
                SchoolRegistrationRequest request =
                    new SchoolRegistrationRequest();
                request.setRequestSeason(season);
                request.setSection(SectionType.BEFORE_FIRST_SECTION);
                request.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
                request.setSchool(schoolService.getAll().iterator().next());
                request.setUrgencyPhone("0101010101");
                request.setCurrentSection(SectionType.BEFORE_FIRST_SECTION);
                request.setCurrentSchoolAddress("CurrentSchoolAddress");
                request.setCurrentSchoolName("CurrentSchoolName");
                request.setRequesterId(
                    iHomeFolderService.getHomeFolderResponsible(
                        homeFolder.getId()).getId());
                request.setSubjectId(individual.getId());
                MeansOfContact meansOfContact =
                    iMeansOfContactService
                        .getMeansOfContactByType(MeansOfContactEnum.EMAIL);
                request.setMeansOfContact(meansOfContact);
                requestIds[i++] =
                    schoolRegistrationRequestService.create(request);
            }
        }

        continueWithNewTransaction();
        
        /* Treat the school registration request (in BackOffice) */
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iRequestWorkflowService.updateRequestState(requestIds[0],
            RequestState.COMPLETE, null);
        iRequestWorkflowService.updateRequestState(requestIds[0],
            RequestState.VALIDATED, null);
        iRequestWorkflowService.updateRequestState(requestIds[1],
            RequestState.COMPLETE, null);
        iRequestWorkflowService.updateRequestState(requestIds[1],
            RequestState.VALIDATED, null);
        iRequestWorkflowService.updateRequestState(requestIds[1],
            RequestState.NOTIFIED, "Bon pour inscription");

        /* Must not change requestState (season's effect isn't started) */
        requestSeasonsJob.launchJob();
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request requestFromDb = iRequestService.getById(requestIds[0]);
        Assert.assertEquals(requestFromDb.getState(), RequestState.VALIDATED);
        requestFromDb = iRequestService.getById(requestIds[1]);
        Assert.assertEquals(requestFromDb.getState(), RequestState.NOTIFIED);
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        /* Make season effect end */
        daoUpdateSeason(season, -5, -6, -6, -6); // season =[-6, -4, -3, -1];
        
        /* Must archive all the requests */
        requestSeasonsJob.launchJob();
        
        // the job clauses the current transaction, so re-open a new one
        startTransaction();
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestFromDb = iRequestService.getById(requestIds[0]);
        Assert.assertEquals(requestFromDb.getState(), RequestState.ARCHIVED);
        iRequestService.delete(requestIds[0]);
        requestFromDb = iRequestService.getById(requestIds[1]);
        Assert.assertEquals(requestFromDb.getState(), RequestState.ARCHIVED);
        iRequestService.delete(requestIds[1]);

        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        iRequestTypeService
            .removeRequestSeason(requestType.getId(), season.getId());
    }
}
