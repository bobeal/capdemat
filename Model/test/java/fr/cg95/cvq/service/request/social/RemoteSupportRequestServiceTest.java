
package fr.cg95.cvq.service.request.social;

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
import fr.cg95.cvq.business.request.social.*;
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
public class RemoteSupportRequestServiceTest extends RequestTestCase {
    
    @Resource(name="remoteSupportRequestService")
    protected IRequestService requestService;

    protected RemoteSupportRequest fillMeARequest() {
        RemoteSupportRequest request = new RemoteSupportRequest();
        
          
          
            
              if ("ContactFirstName".length() > 38)
                  request.setContactFirstName("ContactFirstName".substring(0, 38));
              else
                  request.setContactFirstName("ContactFirstName");
            
          
        
          
          
            
              request.setContactKind(RsrContactKindType.REQUESTER);
            
          
        
          
          
            
              if ("ContactLastName".length() > 38)
                  request.setContactLastName("ContactLastName".substring(0, 38));
              else
                  request.setContactLastName("ContactLastName");
            
          
        
          
          
            
              if ("ContactPhone".length() > 10)
                  request.setContactPhone("ContactPhone".substring(0, 10));
              else
                  request.setContactPhone("ContactPhone");
            
          
        
          
          
               request.setRequestInformationEmergency(Boolean.valueOf(true));
          
        
          
          
            
              if ("RequestInformationEmergencyMotive".length() > 180)
                  request.setRequestInformationEmergencyMotive("RequestInformationEmergencyMotive".substring(0, 180));
              else
                  request.setRequestInformationEmergencyMotive("RequestInformationEmergencyMotive");
            
          
        
          
          
            
              request.setRequestInformationRequestKind(RsrRequestInformationRequestKindType.INDIVIDUAL);
            
          
        
          
          
            
              if ("SecondContactFirstName".length() > 38)
                  request.setSecondContactFirstName("SecondContactFirstName".substring(0, 38));
              else
                  request.setSecondContactFirstName("SecondContactFirstName");
            
          
        
          
          
            
              if ("SecondContactLastName".length() > 38)
                  request.setSecondContactLastName("SecondContactLastName".substring(0, 38));
              else
                  request.setSecondContactLastName("SecondContactLastName");
            
          
        
          
          
            
              if ("SecondContactPhone".length() > 10)
                  request.setSecondContactPhone("SecondContactPhone".substring(0, 10));
              else
                  request.setSecondContactPhone("SecondContactPhone");
            
          
        
          
          
               request.setSpouseBirthDate(new Date());
          
        
          
          
            
              if ("SpouseFirstName".length() > 38)
                  request.setSpouseFirstName("SpouseFirstName".substring(0, 38));
              else
                  request.setSpouseFirstName("SpouseFirstName");
            
          
        
          
          
               request.setSpouseIsDisabledPerson(Boolean.valueOf(true));
          
        
          
          
            
              if ("SpouseLastName".length() > 38)
                  request.setSpouseLastName("SpouseLastName".substring(0, 38));
              else
                  request.setSpouseLastName("SpouseLastName");
            
          
        
          
          
            
              request.setSpouseTitle(TitleType.MISTER);
            
          
        
          
          
               request.setSubjectBirthDate(new Date());
          
        
          
          
               request.setSubjectIsAPABeneficiary(Boolean.valueOf(true));
          
        
          
          
               request.setSubjectIsDisabledPerson(Boolean.valueOf(true));
          
        
          
          
               request.setSubjectIsTaxable(Boolean.valueOf(true));
          
        
          
          
            
              request.setSubjectResideWith(RsrSubjectResideWithType.ALONE);
            
          
        
          
          
            
              request.setSubjectTitle(TitleType.MISTER);
            
          
        
          
          
            
              if ("TrusteeFirstName".length() > 38)
                  request.setTrusteeFirstName("TrusteeFirstName".substring(0, 38));
              else
                  request.setTrusteeFirstName("TrusteeFirstName");
            
          
        
          
          
            
              if ("TrusteeLastName".length() > 38)
                  request.setTrusteeLastName("TrusteeLastName".substring(0, 38));
              else
                  request.setTrusteeLastName("TrusteeLastName");
            
          
        
          
          
            
              if ("TrusteePhone".length() > 10)
                  request.setTrusteePhone("TrusteePhone".substring(0, 10));
              else
                  request.setTrusteePhone("TrusteePhone");
            
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        RemoteSupportRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(RemoteSupportRequest request)
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
        RemoteSupportRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        RemoteSupportRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request, null);
        RemoteSupportRequest requestFromDb = (RemoteSupportRequest) requestSearchService.getById(requestId, true);
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
        RemoteSupportRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        RemoteSupportRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        RemoteSupportRequest requestFromDb = (RemoteSupportRequest) requestSearchService.getById(requestId, true);
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
