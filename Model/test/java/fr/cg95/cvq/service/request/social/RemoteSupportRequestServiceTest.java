package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.document.*;
import fr.cg95.cvq.business.request.social.*;
import fr.cg95.cvq.exception.*;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.social.IRemoteSupportRequestService;
import fr.cg95.cvq.util.Critere;

import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;

/**
 * Generated by Velocity if not present, can be edited safely !
 */
public class RemoteSupportRequestServiceTest extends ServiceTestCase {

    protected IRemoteSupportRequestService iRemoteSupportRequestService;

    protected void onSetUp() throws Exception {
    	super.onSetUp();
        iRemoteSupportRequestService = 
            (IRemoteSupportRequestService) getBean(StringUtils.uncapitalize("RemoteSupportRequest") + "Service");
    }

    protected RemoteSupportRequest fillMeARequest() throws CvqException {

        RemoteSupportRequest request = new RemoteSupportRequest();
            if ("TrusteePhone".length() > 10)
        request.setTrusteePhone("TrusteePhone".substring(0, 10));
      else
        request.setTrusteePhone("TrusteePhone");
                request.setEmergency(Boolean.valueOf(true));
              if ("TrusteeName".length() > 38)
        request.setTrusteeName("TrusteeName".substring(0, 38));
      else
        request.setTrusteeName("TrusteeName");
                request.setAppartmentNumber(BigInteger.valueOf(1));
              request.setTrustee(TrusteeType.REQUESTER);
                  if ("ContactPhone".length() > 10)
        request.setContactPhone("ContactPhone".substring(0, 10));
      else
        request.setContactPhone("ContactPhone");
                request.setFloor(BigInteger.valueOf(1));
              request.setDwelling(RsrDwellingType.APPARTMENT);
                  if ("ContactFirstName".length() > 38)
        request.setContactFirstName("ContactFirstName".substring(0, 38));
      else
        request.setContactFirstName("ContactFirstName");
                  if ("TrusteeFirstName".length() > 38)
        request.setTrusteeFirstName("TrusteeFirstName".substring(0, 38));
      else
        request.setTrusteeFirstName("TrusteeFirstName");
                request.setTaxable(Boolean.valueOf(true));
            request.setSeniorAssitanceBeneficiary(Boolean.valueOf(true));
              if ("ContactName".length() > 38)
        request.setContactName("ContactName".substring(0, 38));
      else
        request.setContactName("ContactName");
                  request.setContact(RsrContactType.REQUESTER);
      
        // Means Of Contact
        MeansOfContact meansOfContact = iMeansOfContactService.getMeansOfContactByType(
                    MeansOfContactEnum.EMAIL);
        request.setMeansOfContact(meansOfContact);
        
        RemoteSupportRequestFeeder.feed(request);
        
        return request;
    }
        	
    protected void completeValidateAndDelete(RemoteSupportRequest request) 
    	throws CvqException, java.io.IOException {
    	
        // add a document to the request
        ///////////////////////////////

        Document doc = new Document();
        doc.setEcitizenNote("Ma carte d'identitÃ© !");
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setHomeFolderId(request.getHomeFolderId());
        doc.setIndividualId(request.getRequesterId());
        doc.setDocumentType(iDocumentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE));
        Long documentId = iDocumentService.create(doc);
        iRemoteSupportRequestService.addDocument(request.getId(), documentId);
        Set<RequestDocument> documentsSet =
            iRemoteSupportRequestService.getAssociatedDocuments(request.getId());
        assertEquals(documentsSet.size(), 1);

        // FIXME : test list of pending / in-progress registrations
        Critere testCrit = new Critere();
        testCrit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        testCrit.setComparatif(Critere.EQUALS);
        testCrit.setValue(request.getHomeFolderId());
        Set<Critere> testCritSet = new HashSet<Critere>();
        testCritSet.add(testCrit);
        List<Request> allRequests = iRequestService.get(testCritSet, null, null, -1, 0);
        assertNotNull(allRequests);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iRemoteSupportRequestService.complete(request.getId());
        iRemoteSupportRequestService.validate(request.getId());

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
        iRemoteSupportRequestService.delete(request.getId());
    }

    public void testWithHomeFolderPojo()
    		throws CvqException, CvqObjectNotFoundException,
                java.io.FileNotFoundException, java.io.IOException {

         SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

         // create a vo card request (to create home folder and associates)
         CreationBean cb = gimmeAnHomeFolder();

         SecurityContext.setCurrentEcitizen(cb.getLogin());

         // get the home folder id
         HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
         assertNotNull(homeFolder);
         Long homeFolderId = homeFolder.getId();
         assertNotNull(homeFolderId);

         // fill and create the request
         //////////////////////////////

         RemoteSupportRequest request = fillMeARequest();
         request.setRequesterId(SecurityContext.getCurrentUserId());
         request.setHomeFolderId(homeFolderId);
         RemoteSupportRequestFeeder.setSubject(request, 
             iRemoteSupportRequestService.getSubjectPolicy(), null, homeFolder);
         
         Long requestId =
              iRemoteSupportRequestService.create(request);

         RemoteSupportRequest requestFromDb =
        	 	(RemoteSupportRequest) iRemoteSupportRequestService.getById(requestId);
         assertEquals(requestId, requestFromDb.getId());
         assertNotNull(requestFromDb.getRequesterId());
         assertNotNull(requestFromDb.getRequesterLastName());
         if (requestFromDb.getSubjectId() != null)
             assertNotNull(requestFromDb.getSubjectLastName());
         
         completeValidateAndDelete(requestFromDb);

         HomeFolder homeFolderAfterDelete = iHomeFolderService.getById(homeFolderId);
         assertNotNull(homeFolderAfterDelete);
         assertNotNull(iHomeFolderService.getHomeFolderResponsible(homeFolderAfterDelete.getId()));
         
         SecurityContext.resetCurrentSite();
    }


    public void testWithoutHomeFolder()
        throws CvqException, CvqObjectNotFoundException,
               java.io.FileNotFoundException, java.io.IOException {

	      if (!iRemoteSupportRequestService.supportUnregisteredCreation())
	         return;

	      startTransaction();
	
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        RemoteSupportRequest request = fillMeARequest();

        Address address = BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012");
        Adult requester =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "requester", address,
                                              FamilyStatusType.MARRIED);
        requester.setPassword("requester");
        requester.setAdress(address);
        iHomeFolderService.addHomeFolderRole(requester, RoleEnum.HOME_FOLDER_RESPONSIBLE);
        RemoteSupportRequestFeeder.setSubject(request, 
            iRemoteSupportRequestService.getSubjectPolicy(), requester, null);

        Long requestId =
             iRemoteSupportRequestService.create(request, requester, requester);
        
        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // start testing request creation
        /////////////////////////////////

        RemoteSupportRequest requestFromDb =
            (RemoteSupportRequest) iRemoteSupportRequestService.getById(requestId);
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
            iHomeFolderService.getById(homeFolderId);
            fail("should not have found home folder");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }
        try {
            iIndividualService.getById(requesterId);
            fail("should not have found requester");
        } catch (CvqObjectNotFoundException confe) {
            // great, that was expected
        }

        SecurityContext.resetCurrentSite();
        
        commitTransaction();
    }
}
