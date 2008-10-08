package fr.cg95.cvq.service.school;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.school.*;
import fr.cg95.cvq.exception.*;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.util.Critere;

import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.testtool.TestUtils;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;

import junit.framework.Assert;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;

/**
 * Generated by Velocity if not present, can be edited safely !
 */
public class SchoolRegistrationRequestServiceTest extends ServiceTestCase {

    protected ISchoolRegistrationRequestService iSchoolRegistrationRequestService;

    protected void onSetUp() throws Exception {
    	super.onSetUp();
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        iSchoolRegistrationRequestService = 
            (ISchoolRegistrationRequestService) cac.getBean(StringUtils.uncapitalize("SchoolRegistrationRequest") + "Service");
    }

    protected SchoolRegistrationRequest fillMeARequest() throws CvqException {

        SchoolRegistrationRequest request = new SchoolRegistrationRequest();
              request.setCurrentSchoolAddress("CurrentSchoolAddress");
                   request.setSchool((School) schoolService.getAll().iterator().next());
                request.setRulesAndRegulationsAcceptance(Boolean.valueOf(true));
                request.setCurrentSchoolName("CurrentSchoolName");
                  if ("UrgencyPhone".length() > 10)
        request.setUrgencyPhone("UrgencyPhone".substring(0, 10));
      else
        request.setUrgencyPhone("UrgencyPhone");
                  request.setCurrentSection(SectionType.BEFORE_FIRST_SECTION);
                  request.setSection(SectionType.BEFORE_FIRST_SECTION);
      
        // Means Of Contact
        MeansOfContact meansOfContact = iMeansOfContactService.getMeansOfContactByType(
                    MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        
        SchoolRegistrationRequestFeeder.feed(request);
        
        return request;
    }
        	
    protected void completeValidateAndDelete(SchoolRegistrationRequest request) 
    	throws CvqException, java.io.IOException {
    	
        // add a document to the request
        ///////////////////////////////

        Document doc = new Document();
        doc.setEcitizenNote("Ma carte d'identité !");
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.IDENTITY_RECEIPT_TYPE));
        Long documentId = iDocumentService.create(doc, request.getHomeFolder().getId(), 
        					  request.getRequester().getId());
        iSchoolRegistrationRequestService.addDocument(request.getId(), documentId);
        Set documentsSet =
            iSchoolRegistrationRequestService.getAssociatedDocuments(request.getId());
        Assert.assertEquals(documentsSet.size(), 1);

        // FIXME : test list of pending / in-progress registrations
        Critere testCrit = new Critere();
        testCrit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
        testCrit.setComparatif(Critere.EQUALS);
        testCrit.setValue(request.getRequester().getLastName());
        Set testCritSet = new HashSet();
        testCritSet.add(testCrit);
        Set allRequests = iRequestService.get(testCritSet, null, false);
        Assert.assertNotNull(allRequests);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iSchoolRegistrationRequestService.complete(request.getId());
        iSchoolRegistrationRequestService.validate(request.getId());

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        byte[] generatedCertificate = iRequestService.getCertificate(request.getId(),
                                                                     RequestState.PENDING);

        if (generatedCertificate == null)
            fail("No certificate found");
            
        //     Write tele-service xml data file
        File xmlFile = File.createTempFile("tmp" + request.getId(), ".xml");
        FileOutputStream xmlFos = new FileOutputStream(xmlFile);
        xmlFos.write(iRequestService.getById(request.getId()).modelToXmlString().getBytes());

        File file = File.createTempFile("tmp" + request.getId(), ".pdf");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(generatedCertificate);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // delete request
        iSchoolRegistrationRequestService.delete(request.getId());
    }


    public void testWithHomeFolderXml() throws CvqException,
			CvqObjectNotFoundException, java.io.FileNotFoundException,
			java.io.IOException {

        startTransaction();
        
	SecurityContext.setCurrentSite(localAuthorityName,
					SecurityContext.FRONT_OFFICE_CONTEXT);

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

	// fill and create the request
	// ////////////////////////////

	SchoolRegistrationRequest request = fillMeARequest();
	request.setRequester(homeFolder.getHomeFolderResponsible());
        SchoolRegistrationRequestFeeder.setSubject(request, homeFolder);

        Set authorizedSubjects = iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();

	SchoolRegistrationRequestDocument requestDoc =
		(SchoolRegistrationRequestDocument) request.modelToXml();
	Long requestId = iSchoolRegistrationRequestService.create(requestDoc.getDomNode());

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        Map newAuthorizedSubjectsMap = iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId);
        if (newAuthorizedSubjectsMap == null) 
            Assert.assertEquals(authorizedSubjects.size(), 1);
        else
            Assert.assertEquals(newAuthorizedSubjectsMap.size(), authorizedSubjects.size() - 1);

	SchoolRegistrationRequest requestFromDb = 
		(SchoolRegistrationRequest) iSchoolRegistrationRequestService.getById(requestId);
	Assert.assertEquals(requestId, requestFromDb.getId());
	Adult requester = requestFromDb.getRequester();
	Assert.assertNotNull(requester);
	Assert.assertNotNull(requestFromDb.getMeansOfContact());
    Assert.assertEquals(requestFromDb.getMeansOfContact().getType(), MeansOfContactEnum.EMAIL);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
	completeValidateAndDelete(requestFromDb);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        HomeFolder homeFolderAfterDelete = iHomeFolderService.getById(homeFolderId);
        Assert.assertNotNull(homeFolderAfterDelete);
        Assert.assertNotNull(homeFolderAfterDelete.getHomeFolderResponsible());
    }

    public void testWithoutHomeFolder()
        throws CvqException, CvqObjectNotFoundException,
               java.io.FileNotFoundException, java.io.IOException {

	if (!iSchoolRegistrationRequestService.supportUnregisteredCreation())
	    return;

	startTransaction();
	
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.FRONT_OFFICE_CONTEXT);
        
        SchoolRegistrationRequest request = fillMeARequest();

        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address,
                                              FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        request.setRequester(requester);
        requester.setAdress(address);
        SchoolRegistrationRequestFeeder.setSubject(request, null);

        SchoolRegistrationRequestDocument requestDoc = 
            (SchoolRegistrationRequestDocument) request.modelToXml();
        Long requestId =
             iSchoolRegistrationRequestService.create(requestDoc.getDomNode());
        
        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // start testing request creation
        /////////////////////////////////

        SchoolRegistrationRequest requestFromDb =
            (SchoolRegistrationRequest) iSchoolRegistrationRequestService.getById(requestId);
        Assert.assertEquals(requestId, requestFromDb.getId());
        requester = requestFromDb.getRequester();
        Assert.assertNotNull(requester);
        
        Long homeFolderId = requestFromDb.getHomeFolder().getId();
        Long requesterId = requestFromDb.getRequester().getId();

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        completeValidateAndDelete(requestFromDb);
        
        // close current session and re-open a new one
        continueWithNewTransaction();
        
        try {
            iHomeFolderService.getById(homeFolderId);
            fail("should not have found home folder");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        try {
            iAdultService.getById(requesterId);
            fail("should not have found requester");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }

        SecurityContext.resetCurrentSite();
        
        commitTransaction();
    }
}
