
package fr.cg95.cvq.service.request.school;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.cg95.cvq.business.document.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.school.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

/**
 * Generated class file, do not edit !
 * Extend it to define your own specific test cases.
 */
public class StudyGrantRequestServiceTest extends RequestTestCase {
    
    @Resource(name="studyGrantRequestService")
    protected IRequestService requestService;

    protected StudyGrantRequest fillMeARequest() {
        StudyGrantRequest request = new StudyGrantRequest();
        
          
          
               request.setAbroadInternship(Boolean.valueOf(true));
          
        
          
          
               request.setAbroadInternshipEndDate(new Date());
          
        
          
          
            
              request.setAbroadInternshipSchoolCountry(CountryType.UNKNOWN);
            
          
        
          
          
            
               request.setAbroadInternshipSchoolName("AbroadInternshipSchoolName");
            
          
        
          
          
               request.setAbroadInternshipStartDate(new Date());
          
        
          
          
               request.setAccountHolderBirthDate(new Date());
          
        
          
          
            
               request.setAccountHolderEdemandeId("AccountHolderEdemandeId");
            
          
        
          
          
            
              if ("AccountHolderFirstName".length() > 38)
                  request.setAccountHolderFirstName("AccountHolderFirstName".substring(0, 38));
              else
                  request.setAccountHolderFirstName("AccountHolderFirstName");
            
          
        
          
          
            
              if ("AccountHolderLastName".length() > 38)
                  request.setAccountHolderLastName("AccountHolderLastName".substring(0, 38));
              else
                  request.setAccountHolderLastName("AccountHolderLastName");
            
          
        
          
          
            
              request.setAccountHolderTitle(TitleType.MISTER);
            
          
        
          
          
            
              request.setAlevels(ALevelsType.ES);
            
          
        
          
          
            
              if ("AlevelsDate".length() > 4)
                  request.setAlevelsDate("AlevelsDate".substring(0, 4));
              else
                  request.setAlevelsDate("AlevelsDate");
            
          
        
          
          
            
              if ("CurrentSchoolCity".length() > 32)
                  request.setCurrentSchoolCity("CurrentSchoolCity".substring(0, 32));
              else
                  request.setCurrentSchoolCity("CurrentSchoolCity");
            
          
        
          
          
            
              request.setCurrentSchoolCountry(CountryType.UNKNOWN);
            
          
        
          
          
            
            
          
        
          
          
            
               request.setCurrentSchoolNamePrecision("CurrentSchoolNamePrecision");
            
          
        
          
          
            
              if ("CurrentSchoolPostalCode".length() > 5)
                  request.setCurrentSchoolPostalCode("CurrentSchoolPostalCode".substring(0, 5));
              else
                  request.setCurrentSchoolPostalCode("CurrentSchoolPostalCode");
            
          
        
          
          
            
              request.setCurrentStudiesDiploma(CurrentStudiesType.LICENCE);
            
          
        
          
          
            
              request.setCurrentStudiesLevel(CurrentStudiesLevelType.FIRST_YEAR);
            
          
        
          
          
            
              request.setDistance(DistanceType.LESS_THAN30KMS);
            
          
        
          
          
            
               request.setEdemandeId("EdemandeId");
            
          
        
          
          
            
            
          
        
          
          
               request.setHasCROUSHelp(Boolean.valueOf(true));
          
        
          
          
               request.setHasEuropeHelp(Boolean.valueOf(true));
          
        
          
          
               request.setHasOtherHelp(Boolean.valueOf(true));
          
        
          
          
               request.setHasRegionalCouncilHelp(Boolean.valueOf(true));
          
        
          
          
               request.setIsSubjectAccountHolder(Boolean.valueOf(true));
          
        
          
          
            
               request.setOtherStudiesLabel("OtherStudiesLabel");
            
          
        
          
          
               request.setSandwichCourses(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setSubjectAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setSubjectBirthDate(new Date());
          
        
          
          
            
               request.setSubjectEmail("SubjectEmail");
            
          
        
          
          
               request.setSubjectFirstRequest(Boolean.valueOf(true));
          
        
          
          
            
              if ("SubjectMobilePhone".length() > 10)
                  request.setSubjectMobilePhone("SubjectMobilePhone".substring(0, 10));
              else
                  request.setSubjectMobilePhone("SubjectMobilePhone");
            
          
        
          
          
            
              if ("SubjectPhone".length() > 10)
                  request.setSubjectPhone("SubjectPhone".substring(0, 10));
              else
                  request.setSubjectPhone("SubjectPhone");
            
          
        
          
          
            
            
          
        
          
          
            
               request.setTaxHouseholdCityPrecision("TaxHouseholdCityPrecision");
            
          
        
          
          
            
              if ("TaxHouseholdFirstName".length() > 38)
                  request.setTaxHouseholdFirstName("TaxHouseholdFirstName".substring(0, 38));
              else
                  request.setTaxHouseholdFirstName("TaxHouseholdFirstName");
            
          
        
          
          
        
          
          
            
              if ("TaxHouseholdLastName".length() > 38)
                  request.setTaxHouseholdLastName("TaxHouseholdLastName".substring(0, 38));
              else
                  request.setTaxHouseholdLastName("TaxHouseholdLastName");
            
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        StudyGrantRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(StudyGrantRequest request)
        throws CvqException, IOException {
        // add a document to the request
        ///////////////////////////////
        Document doc = new Document();
        doc.setEcitizenNote("Ma carte d'identité !");
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setHomeFolderId(request.getHomeFolderId());
        doc.setIndividualId(request.getRequesterId());
        doc.setDocumentType(documentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        Long documentId = documentService.create(doc);
        requestDocumentService.addDocument(request.getId(), documentId);
        Set<RequestDocument> documentsSet = requestDocumentService.getAssociatedDocuments(request.getId());
        assertEquals(documentsSet.size(), 1);
        // FIXME : test list of pending / in-progress registrations
        Critere testCrit = new Critere();
        testCrit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        testCrit.setComparatif(Critere.EQUALS);
        testCrit.setValue(request.getHomeFolderId());
        Set<Critere> testCritSet = new HashSet<Critere>();
        testCritSet.add(testCrit);
        List<Request> allRequests = requestSearchService.get(testCritSet, null, null, -1, 0, false);
        assertNotNull(allRequests);
        // close current session and re-open a new one
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        byte[] generatedCertificate = requestSearchService.getCertificate(request.getId(), RequestState.PENDING);
        if (generatedCertificate == null)
            fail("No certificate found");
        //     Write tele-service xml data file
        File xmlFile = File.createTempFile("tmp" + request.getId(), ".xml");
        FileOutputStream xmlFos = new FileOutputStream(xmlFile);
        xmlFos.write(requestSearchService.getById(request.getId(), true).modelToXmlString().getBytes());
        File file = File.createTempFile("tmp" + request.getId(), ".pdf");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(generatedCertificate);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // delete request
        requestWorkflowService.delete(request.getId());
    }
    
    @Test
    public void testWithHomeFolderPojo()
        throws CvqException, CvqObjectNotFoundException, FileNotFoundException, IOException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        // get the home folder id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);
        // fill and create the request
        //////////////////////////////
        StudyGrantRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        StudyGrantRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request, null);
        StudyGrantRequest requestFromDb = (StudyGrantRequest) requestSearchService.getById(requestId, true);
        assertEquals(requestId, requestFromDb.getId());
        assertNotNull(requestFromDb.getRequesterId());
        assertNotNull(requestFromDb.getRequesterLastName());
        if (requestFromDb.getSubjectId() != null)
            assertNotNull(requestFromDb.getSubjectLastName());
        completeValidateAndDelete(requestFromDb);
        HomeFolder homeFolderAfterDelete = homeFolderService.getById(homeFolderId);
        assertNotNull(homeFolderAfterDelete);
        assertNotNull(homeFolderService.getHomeFolderResponsible(homeFolderAfterDelete.getId()));
    }
    
    @Test
    public void testWithoutHomeFolder()
        throws CvqException, CvqObjectNotFoundException, FileNotFoundException, IOException {
        if (!requestService.supportUnregisteredCreation())
            return;
        startTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        StudyGrantRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        StudyGrantRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        StudyGrantRequest requestFromDb = (StudyGrantRequest) requestSearchService.getById(requestId, true);
        assertEquals(requestId, requestFromDb.getId());
        assertNotNull(requestFromDb.getRequesterId());
        assertNotNull(requestFromDb.getRequesterLastName());
        if (requestFromDb.getSubjectId() != null)
            assertNotNull(requestFromDb.getSubjectLastName());
        Long homeFolderId = requestFromDb.getHomeFolderId();
        Long requesterId = requestFromDb.getRequesterId();
        // close current session and re-open a new one
        continueWithNewTransaction();
        completeValidateAndDelete(requestFromDb);
        // close current session and re-open a new one
        continueWithNewTransaction();
        try {
            homeFolderService.getById(homeFolderId);
            fail("should not have found home folder");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        try {
            individualService.getById(requesterId);
            fail("should not have found requester");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        SecurityContext.resetCurrentSite();
        commitTransaction();
    }
}
