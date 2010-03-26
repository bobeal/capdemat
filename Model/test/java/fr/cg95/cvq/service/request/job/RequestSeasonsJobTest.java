package fr.cg95.cvq.service.request.job;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

public class RequestSeasonsJobTest extends RequestTestCase {
 
    @Autowired
    protected RequestSeasonsJob requestSeasonsJob;
    
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

    @Test
    public void testJob() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        RequestType requestType = 
            requestTypeService.getRequestTypeByLabel("School Registration");
        assertNotNull(requestType);
        
        /* Create a season */
        RequestSeason season = BusinessObjectsFactory.gimmeRequestSeason("Saison 1235", 1, 2, 3, 5);
        requestTypeService.addRequestSeason(requestType.getId(), season);
        continueWithNewTransaction();
        season = requestTypeService.getRequestSeasons(requestType.getId()).iterator().next();
        /* Make season registration start */
        daoUpdateSeason(season, -2, 0, 0, 0); // season =[-1, 2, 3, 5];

        /* Request for a school registration (in FrontOffice) */
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();
        String proposedLogin = cb.getLogin();

        // close current session and re-open a new one
        continueWithNewTransaction();
    
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder =
            homeFolderService.getById(cb.getHomeFolderId());

        Long requestIds[] = new Long[2];
        int i = 0;
        for (Individual individual : homeFolder.getIndividuals()) {
            if (individual instanceof Child) {
                SchoolRegistrationRequest request = new SchoolRegistrationRequest();
                request.setRequestSeason(season);
                request.setSection(SectionType.BEFORE_FIRST_SECTION);
                request.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
                request.setSchool(schoolService.getAll().iterator().next());
                request.setUrgencyPhone("0101010101");
                request.setCurrentSection(SectionType.BEFORE_FIRST_SECTION);
                request.setCurrentSchoolAddress("CurrentSchoolAddress");
                request.setCurrentSchoolName("CurrentSchoolName");
                request.setRequesterId(
                    homeFolderService.getHomeFolderResponsible(
                        homeFolder.getId()).getId());
                request.setSubjectId(individual.getId());
                MeansOfContact meansOfContact =
                    meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
                request.setMeansOfContact(meansOfContact);
                requestIds[i++] =
                    requestWorkflowService.create(request);
            }
        }

        continueWithNewTransaction();
        
        /* Treat the school registration request (in BackOffice) */
        SecurityContext.setCurrentSite(localAuthorityName,
            SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        requestWorkflowService.updateRequestState(requestIds[0],
            RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(requestIds[0],
            RequestState.VALIDATED, null);
        requestWorkflowService.updateRequestState(requestIds[1],
            RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(requestIds[1],
            RequestState.VALIDATED, null);
        requestWorkflowService.updateRequestState(requestIds[1],
            RequestState.NOTIFIED, "Bon pour inscription");

        continueWithNewTransaction();
        
        /* Must not change requestState (season's effect isn't started) */
        requestSeasonsJob.launchJob();
        
        startTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request requestFromDb = requestSearchService.getById(requestIds[0], false);
        assertEquals(RequestState.VALIDATED, requestFromDb.getState());
        requestFromDb = requestSearchService.getById(requestIds[1], false);
        assertEquals(RequestState.NOTIFIED, requestFromDb.getState());

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        /* Make season effect end */
        daoUpdateSeason(season, -5, -6, -6, -6); // season =[-6, -4, -3, -1];
        
        continueWithNewTransaction();
        
        /* Must archive all the requests */
        requestSeasonsJob.launchJob();
        
        // the job clauses the current transaction, so re-open a new one
        startTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestFromDb = requestSearchService.getById(requestIds[0], false);
        assertEquals(RequestState.ARCHIVED, requestFromDb.getState());
        requestWorkflowService.delete(requestIds[0]);
        requestFromDb = requestSearchService.getById(requestIds[1], false);
        assertEquals(RequestState.ARCHIVED, requestFromDb.getState());
        requestWorkflowService.delete(requestIds[1]);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        requestTypeService.removeRequestSeason(requestType.getId(), season.getId());
    }
}
