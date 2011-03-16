
package fr.cg95.cvq.service.request.military;

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
import fr.cg95.cvq.business.request.military.*;
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
public class MilitaryCensusRequestServiceTest extends RequestTestCase {
    
    @Resource(name="militaryCensusRequestService")
    protected IRequestService requestService;

    protected MilitaryCensusRequest fillMeARequest() {
        MilitaryCensusRequest request = new MilitaryCensusRequest();
        
          
          
               request.setAffectionOrDisease(Boolean.valueOf(true));
          
        
          
          
               request.setAliveChildren(BigInteger.valueOf(1));
          
        
          
          
            
              request.setChildBirthCountry(CountryType.UNKNOWN);
            
          
        
          
          
            
              if ("ChildConvention".length() > 255)
                  request.setChildConvention("ChildConvention".substring(0, 255));
              else
                  request.setChildConvention("ChildConvention");
            
          
        
          
          
            
              request.setChildCountry(FullNationalityType.NONE);
            
          
        
          
          
            
              request.setChildDiploma(ChildDiplomaType.B_A_C);
            
          
        
          
          
            
               request.setChildMail("ChildMail");
            
          
        
          
          
            
              request.setChildOtherCountry(FullNationalityType.NONE);
            
          
        
          
          
            
              if ("ChildPhone".length() > 10)
                  request.setChildPhone("ChildPhone".substring(0, 10));
              else
                  request.setChildPhone("ChildPhone");
            
          
        
          
          
            
               request.setChildProfession("ChildProfession");
            
          
        
          
          
            
              request.setChildResidenceCountry(CountryType.UNKNOWN);
            
          
        
          
          
            
              request.setChildSituation(ChildSituationType.COLLEGE);
            
          
        
          
          
            
               request.setChildSpeciality("ChildSpeciality");
            
          
        
          
          
            
              request.setChildStatus(FamilyStatusType.MARRIED);
            
          
        
          
          
            
              request.setChildTitle(TitleType.MISTER);
            
          
        
          
          
               request.setChildrenInCharge(BigInteger.valueOf(1));
          
        
          
          
            
               request.setFatherBirthCity("FatherBirthCity");
            
          
        
          
          
            
              request.setFatherBirthCountry(CountryType.UNKNOWN);
            
          
        
          
          
               request.setFatherBirthDate(new Date());
          
        
          
          
            
              request.setFatherBirthDepartment(InseeDepartementCodeType.NONE);
            
          
        
          
          
            
              if ("FatherFirstName".length() > 38)
                  request.setFatherFirstName("FatherFirstName".substring(0, 38));
              else
                  request.setFatherFirstName("FatherFirstName");
            
          
        
          
          
            
              if ("FatherLastName".length() > 38)
                  request.setFatherLastName("FatherLastName".substring(0, 38));
              else
                  request.setFatherLastName("FatherLastName");
            
          
        
          
          
            
              request.setFatherNationality(FullNationalityType.NONE);
            
          
        
          
          
               request.setHighlyInfirm(Boolean.valueOf(true));
          
        
          
          
               request.setJapdExemption(Boolean.valueOf(true));
          
        
          
          
            
              if ("MaidenName".length() > 38)
                  request.setMaidenName("MaidenName".substring(0, 38));
              else
                  request.setMaidenName("MaidenName");
            
          
        
          
          
            
               request.setMotherBirthCity("MotherBirthCity");
            
          
        
          
          
            
              request.setMotherBirthCountry(CountryType.UNKNOWN);
            
          
        
          
          
               request.setMotherBirthDate(new Date());
          
        
          
          
            
              request.setMotherBirthDepartment(InseeDepartementCodeType.NONE);
            
          
        
          
          
            
              if ("MotherFirstName".length() > 38)
                  request.setMotherFirstName("MotherFirstName".substring(0, 38));
              else
                  request.setMotherFirstName("MotherFirstName");
            
          
        
          
          
            
              if ("MotherLastName".length() > 38)
                  request.setMotherLastName("MotherLastName".substring(0, 38));
              else
                  request.setMotherLastName("MotherLastName");
            
          
        
          
          
            
              request.setMotherNationality(FullNationalityType.NONE);
            
          
        
          
          
            
               request.setOtherSituation("OtherSituation");
            
          
        
          
          
               request.setPrefectPupil(Boolean.valueOf(true));
          
        
          
          
            
              request.setPrefectPupilDepartment(InseeDepartementCodeType.NONE);
            
          
        
          
          
               request.setStatePupil(Boolean.valueOf(true));
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        MilitaryCensusRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(MilitaryCensusRequest request)
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
        MilitaryCensusRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        MilitaryCensusRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request, null);
        MilitaryCensusRequest requestFromDb = (MilitaryCensusRequest) requestSearchService.getById(requestId, true);
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
        MilitaryCensusRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        MilitaryCensusRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester, null);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        MilitaryCensusRequest requestFromDb = (MilitaryCensusRequest) requestSearchService.getById(requestId, true);
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
