
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
public class DomesticHelpRequestServiceTest extends RequestTestCase {
    
    @Resource(name="domesticHelpRequestService")
    protected IRequestService requestService;

    protected DomesticHelpRequest fillMeARequest() {
        DomesticHelpRequest request = new DomesticHelpRequest();
        
          
          
            
            
          
        
          
          
            
              request.setDhrSpousePrincipalPensionPlan(DhrPrincipalPensionPlanType.C_N_A_V);
            
          
        
          
          
            
               request.setDhrSpouseProfession("DhrSpouseProfession");
            
          
        
          
          
               request.setDhrNetIncome(BigInteger.valueOf(1));
          
        
          
          
               request.setProfessionalTaxes(BigInteger.valueOf(1));
          
        
          
          
               request.setDhrIsSpouseRetired(Boolean.valueOf(true));
          
        
          
          
            
              request.setDhrSpouseTitle(TitleType.MISTER);
            
          
        
          
          
               request.setDhrRequesterBirthDate(new Date());
          
        
          
          
               request.setDhrRealEstateInvestmentIncome(BigInteger.valueOf(1));
          
        
          
          
               request.setDhrRequesterIsFrenchResident(Boolean.valueOf(true));
          
        
          
          
            
            
              
                request.setDhrCurrentDwellingAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setDhrSpouseFranceArrivalDate(new Date());
          
        
          
          
            
            
          
        
          
          
            
              request.setDhrRequesterNationality(NationalityType.FRENCH);
            
          
        
          
          
               request.setDhrCurrentDwellingArrivalDate(new Date());
          
        
          
          
               request.setDhrIncomesAnnualTotal(BigInteger.valueOf(1));
          
        
          
          
            
              if ("DhrReferentFirstName".length() > 38)
                  request.setDhrReferentFirstName("DhrReferentFirstName".substring(0, 38));
              else
                  request.setDhrReferentFirstName("DhrReferentFirstName");
            
          
        
          
          
               request.setDhrRequesterHaveGuardian(Boolean.valueOf(true));
          
        
          
          
               request.setDhrIncomeTax(BigInteger.valueOf(1));
          
        
          
          
        
          
          
            
               request.setDhrSpouseBirthPlace("DhrSpouseBirthPlace");
            
          
        
          
          
               request.setDhrSpouseBirthDate(new Date());
          
        
          
          
               request.setDhrRequesterFranceArrivalDate(new Date());
          
        
          
          
            
              request.setDhrCurrentDwellingStatus(DhrDwellingStatusType.OWNER);
            
          
        
          
          
            
              if ("DhrSpouseFirstName".length() > 38)
                  request.setDhrSpouseFirstName("DhrSpouseFirstName".substring(0, 38));
              else
                  request.setDhrSpouseFirstName("DhrSpouseFirstName");
            
          
        
          
          
            
              request.setDhrSpouseFamilyStatus(FamilyStatusType.MARRIED);
            
          
        
          
          
               request.setDhrFurnitureInvestmentIncome(BigInteger.valueOf(1));
          
        
          
          
            
            
              
                request.setDhrGuardianAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
            
              if ("DhrReferentName".length() > 38)
                  request.setDhrReferentName("DhrReferentName".substring(0, 38));
              else
                  request.setDhrReferentName("DhrReferentName");
            
          
        
          
          
               request.setLocalRate(BigInteger.valueOf(1));
          
        
          
          
            
               request.setDhrSpouseEmployer("DhrSpouseEmployer");
            
          
        
          
          
            
              request.setDhrRequestKind(DhrRequestKindType.INDIVIDUAL);
            
          
        
          
          
            
              request.setDhrPrincipalPensionPlan(DhrPrincipalPensionPlanType.C_N_A_V);
            
          
        
          
          
            
               request.setDhrComplementaryPensionPlan("DhrComplementaryPensionPlan");
            
          
        
          
          
            
            
              
                request.setDhrReferentAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setPropertyTaxes(BigInteger.valueOf(1));
          
        
          
          
            
              if ("DhrGuardianName".length() > 38)
                  request.setDhrGuardianName("DhrGuardianName".substring(0, 38));
              else
                  request.setDhrGuardianName("DhrGuardianName");
            
          
        
          
          
               request.setPensions(BigInteger.valueOf(1));
          
        
          
          
            
              request.setDhrCurrentDwellingKind(DhrDwellingKindType.PLACE_OF_RESIDENCE);
            
          
        
          
          
        
          
          
            
              if ("DhrCurrentDwellingPhone".length() > 10)
                  request.setDhrCurrentDwellingPhone("DhrCurrentDwellingPhone".substring(0, 10));
              else
                  request.setDhrCurrentDwellingPhone("DhrCurrentDwellingPhone");
            
          
        
          
          
            
              request.setDhrGuardianMeasure(DhrGuardianMeasureType.SAFEGUARDING_JUSTICE);
            
          
        
          
          
               request.setDhrSpouseIsFrenchResident(Boolean.valueOf(true));
          
        
          
          
               request.setDhrAllowances(BigInteger.valueOf(1));
          
        
          
          
            
              request.setDhrSpouseNationality(NationalityType.FRENCH);
            
          
        
          
          
            
            
          
        
          
          
            
              if ("DhrSpouseMaidenName".length() > 38)
                  request.setDhrSpouseMaidenName("DhrSpouseMaidenName".substring(0, 38));
              else
                  request.setDhrSpouseMaidenName("DhrSpouseMaidenName");
            
          
        
          
          
            
               request.setDhrSpousePensionPlanDetail("DhrSpousePensionPlanDetail");
            
          
        
          
          
            
              if ("DhrSpouseName".length() > 38)
                  request.setDhrSpouseName("DhrSpouseName".substring(0, 38));
              else
                  request.setDhrSpouseName("DhrSpouseName");
            
          
        
          
          
            
               request.setDhrRequesterBirthPlace("DhrRequesterBirthPlace");
            
          
        
          
          
            
            
              
                request.setDhrSpouseAddress(BusinessObjectsFactory.gimmeAdress("1", "Unit test address", "Paris", "75012"));
              
            
          
        
          
          
               request.setDhrHaveFamilyReferent(Boolean.valueOf(true));
          
        
          
          
            
               request.setDhrSpouseComplementaryPensionPlan("DhrSpouseComplementaryPensionPlan");
            
          
        
          
          
            
               request.setDhrPensionPlanDetail("DhrPensionPlanDetail");
            
          
        
        // Means Of Contact
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        DomesticHelpRequestFeeder.feed(request);
        return request;
    }

    protected void completeValidateAndDelete(DomesticHelpRequest request)
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
        DomesticHelpRequest request = fillMeARequest();
        request.setRequesterId(SecurityContext.getCurrentUserId());
        request.setHomeFolderId(homeFolderId);
        DomesticHelpRequestFeeder.setSubject(request, requestService.getSubjectPolicy(), null, homeFolder);
        Long requestId = requestWorkflowService.create(request);
        DomesticHelpRequest requestFromDb = (DomesticHelpRequest) requestSearchService.getById(requestId, true);
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
        DomesticHelpRequest request = fillMeARequest();
        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address, FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE);
        DomesticHelpRequestFeeder
            .setSubject(request, requestService.getSubjectPolicy(), requester, null);
        Long requestId = requestWorkflowService.create(request, requester);
        // close current session and re-open a new one
        continueWithNewTransaction();
        // start testing request creation
        /////////////////////////////////
        DomesticHelpRequest requestFromDb = (DomesticHelpRequest) requestSearchService.getById(requestId, true);
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
