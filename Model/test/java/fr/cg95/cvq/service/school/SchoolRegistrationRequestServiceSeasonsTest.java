package fr.cg95.cvq.service.school;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument;

public class SchoolRegistrationRequestServiceSeasonsTest 
    extends SchoolRegistrationRequestServiceTest {

    public void testWithOpenSeason() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        Long voCardRequestId = cb.getRequestId();
        String proposedLogin = cb.getLogin();

        // close current session and re-open a new one
        continueWithNewTransaction();
    
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Assert.assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        // add a season to request type
        RequestType requestType = 
            iRequestService.getRequestTypeByLabel(iSchoolRegistrationRequestService.getLabel());
        RequestSeason requestSeason = new RequestSeason();
        requestSeason.setLabel("Année scolaire 2007/2008");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date registrationStart = calendar.getTime();
        requestSeason.setRegistrationStart(registrationStart);
        calendar.add(Calendar.MONTH, 2);
        Date registrationEnd = calendar.getTime();
        requestSeason.setRegistrationEnd(registrationEnd);
        requestSeason.setEffectStart(registrationEnd);
        calendar.add(Calendar.MONTH, 10);
        Date effectEnd = calendar.getTime();
        requestSeason.setEffectEnd(effectEnd);
        Set<RequestSeason> seasons = new HashSet<RequestSeason>();
        seasons.add(requestSeason);
        iRequestService.modifyRequestTypeSeasons(requestType, seasons);
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get list of authorized subjects before any registration
        Set authorizedSubjects = 
            iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();
        Assert.assertEquals(authorizedSubjects.size(), 2);
        
        // register a child to this season
        SchoolRegistrationRequest request = fillMeARequest();
        homeFolder = iHomeFolderService.getById(homeFolderId);
        request.setRequester(homeFolder.getHomeFolderResponsible());
        SchoolRegistrationRequestFeeder.setSubject(request, homeFolder);
        SchoolRegistrationRequestDocument requestDoc =
            (SchoolRegistrationRequestDocument) request.modelToXml();
        Long requestId = iSchoolRegistrationRequestService.create(requestDoc.getDomNode());

        // check the season's association
        continueWithNewTransaction();
        SchoolRegistrationRequest requestFromDb = 
            (SchoolRegistrationRequest) iSchoolRegistrationRequestService.getById(requestId);
        Assert.assertEquals(requestId, requestFromDb.getId());
        Assert.assertNotNull(requestFromDb.getSeasonUuid());
        
        // get and check list of authorized subjects after the registration
        Set newAuthorizedSubjets = 
            iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();
        Assert.assertEquals(newAuthorizedSubjets.size(), 1);

        // try to register the same child and check for exception
        try {
            iSchoolRegistrationRequestService.create(requestDoc.getDomNode());
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            // that was expected
        }
        
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        // reset seasons
        seasons.clear();
        iRequestService.modifyRequestTypeSeasons(requestType, seasons);
        commitTransaction();
    }
}
