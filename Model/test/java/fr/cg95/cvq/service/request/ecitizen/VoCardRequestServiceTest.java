package fr.cg95.cvq.service.request.ecitizen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

/**
 * The tests for the VO card request service.
 *
 * @author bor@zenexity.fr
 */
public class VoCardRequestServiceTest extends RequestTestCase {

    @Test
    public void testAll() throws Exception {

        /////////////////////////////////////////////
        // Create the VO Card request in DB        //
        /////////////////////////////////////////////

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        VoCardRequest dcvo = new VoCardRequest();
        MeansOfContact meansOfContact = meansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.EMAIL);
        dcvo.setMeansOfContact(meansOfContact);

        Address address = BusinessObjectsFactory.gimmeAdress("12","Rue d'Aligre", "Paris", "75012");

        Adult homeFolderResponsible = new Adult();
        homeFolderResponsible.setTitle(TitleType.MISTER);
        homeFolderResponsible.setLastName("LASTNAME");
        homeFolderResponsible.setFirstName("Vedad");
        homeFolderResponsible.setFamilyStatus(FamilyStatusType.MARRIED);
        homeFolderResponsible.setAdress(address);
        homeFolderResponsible.setQuestion("Qui est magique ?");
        homeFolderResponsible.setAnswer("Paris !");
        homeFolderResponsible.setPassword("totopwd");
        homeFolderResponsible.setHomePhone("0101010101");
        homeFolderResponsible.setOfficePhone("0101010101");
        homeFolderResponsible.setMobilePhone("0606060606");
        homeFolderResponsible.setBirthCity("Paris");
        homeFolderResponsible.setBirthCountry("France");
        homeFolderResponsible.setBirthDate(new Date());
        homeFolderResponsible.setBirthPostalCode("75012");
        homeFolderResponsible.setFirstName2("Branko");
        homeFolderResponsible.setFirstName3("Safet");
        homeFolderResponsible.setCfbn("5050505E");
        homeFolderResponsible.setEmail("bor@zenexity.fr");
        homeFolderResponsible.setNameOfUse("NAMEOFUSE");
        homeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);

        Adult mother = new Adult();
        mother.setTitle(TitleType.MADAM);
        mother.setLastName("LASTNAME");
        mother.setFirstName("Tania");
        mother.setFamilyStatus(FamilyStatusType.MARRIED);
        mother.setAdress(address);
        mother.setQuestion("Qui est magique ?");
        mother.setAnswer("Paris !");
        mother.setPassword("totopwd");
        mother.setHomePhone("0101010101");
        mother.setOfficePhone("0101010101");
        mother.setMobilePhone("0606060606");
        mother.setBirthCity("Paris");
        mother.setBirthCountry("France");
        mother.setBirthDate(new Date());
        mother.setBirthPostalCode("75012");
        mother.setFirstName2("Irina");
        mother.setFirstName3("Natacha");
        mother.setSex(SexType.FEMALE);
        mother.setCfbn("5050505E");
        mother.setEmail("bor@zenexity.fr");
        mother.setNameOfUse("NAMEOFUSE");
        mother.setMaidenName("SUSIC");
        
        Adult adultGrandMother = 
            BusinessObjectsFactory.gimmeAdult(TitleType.MADAM, "LASTNAME","josiane", null, 
                    FamilyStatusType.WIDOW);
        homeFolderService.addIndividualRole(mother, adultGrandMother, RoleType.TUTOR);

        List<Adult> adultSet = new ArrayList<Adult>();
        adultSet.add(mother);
        adultSet.add(adultGrandMother);
        adultSet.add(homeFolderResponsible);

        Child child1 = BusinessObjectsFactory.gimmeChild("LASTNAME", "Child1");
        child1.setBirthCity("Paris");
        child1.setBirthCountry("France");
        child1.setBirthDate(new Date());
        child1.setBirthPostalCode("75012");
        child1.setFirstName2("Yargla");
        child1.setFirstName3("Djaba");
        child1.setSex(SexType.MALE);
        homeFolderService.addIndividualRole(homeFolderResponsible, child1, RoleType.CLR_FATHER);
        homeFolderService.addIndividualRole(mother, child1, RoleType.CLR_MOTHER);

        Adult tutorNotInHomeFolder = 
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "TUTOR", "outside", null, 
                    FamilyStatusType.MARRIED);
        Address tutorAddress = BusinessObjectsFactory.gimmeAdress("1","Rue de Cotte", "Paris", "75012");
        tutorNotInHomeFolder.setAdress(tutorAddress);
        
        Child child2 = BusinessObjectsFactory.gimmeChild("LASTNAME", "Child2");
        List<Child> childSet = new ArrayList<Child>();
        childSet.add(child1);
        childSet.add(child2);
        homeFolderService.addIndividualRole(homeFolderResponsible, child2, RoleType.CLR_FATHER);
        homeFolderService.addIndividualRole(mother, child2, RoleType.CLR_MOTHER);
        homeFolderService.addIndividualRole(tutorNotInHomeFolder, child2, RoleType.CLR_TUTOR);

        requestWorkflowService.createAccountCreationRequest(dcvo, adultSet, childSet, 
                null, address, null);

        homeFolderVoCardRequestIds.put(dcvo.getHomeFolderId(), dcvo.getId()); 
        homeFolderIds.add(dcvo.getHomeFolderId());
        
        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // now that we have an user, set it in the context
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        // retrieve a fresh new home folder
        assertNotNull(dcvo.getHomeFolderId());
        HomeFolder homeFolder = homeFolderService.getById(dcvo.getHomeFolderId());
        homeFolderResponsible = homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        assertNotNull(homeFolderResponsible);
        assertEquals("Vedad", homeFolderResponsible.getFirstName());
        
        //////////////////////////////////////////////////
        // test addition of the request and its attributes
        //////////////////////////////////////////////////

        Long requestId = dcvo.getId();
        VoCardRequest dcvoFromDb = (VoCardRequest) requestSearchService.getById(requestId, true);
        assertEquals(dcvoFromDb.getState(), RequestState.PENDING);
        assertNotNull(dcvoFromDb.getRequesterId());
        assertEquals(homeFolderResponsible.getId(), dcvoFromDb.getRequesterId());
        assertNotNull(dcvoFromDb.getRequesterLastName());
        assertEquals(homeFolderResponsible.getLastName(), dcvoFromDb.getRequesterLastName());
        assertNull(dcvoFromDb.getSubjectId());
        assertNull(dcvoFromDb.getSubjectLastName());
        assertEquals(dcvoFromDb.getHasTiedHomeFolder(), false);
        
        assertNotNull(requestSearchService.getCertificate(dcvoFromDb.getId(), RequestState.PENDING));
        assertEquals(1, dcvoFromDb.getActions().size());
        
        Adult homeFolderResponsibleFromDb = 
            individualService.getAdultById(dcvoFromDb.getRequesterId());
        assertNotNull("Associated object of class Adult not saved !", homeFolderResponsibleFromDb);
        assertEquals(homeFolderResponsibleFromDb.getLastName(),"LASTNAME");
        assertEquals(homeFolderResponsibleFromDb.getId(), dcvoFromDb.getRequesterId());
        assertEquals(homeFolderResponsibleFromDb.getState(), ActorState.PENDING);
        
        Address adresseFromDb = homeFolderResponsibleFromDb.getAdress();
        assertNotNull("Associated object of class Adress not saved !", adresseFromDb);
        assertEquals(adresseFromDb.getCity(),"PARIS");

        homeFolder = homeFolderService.getById(dcvoFromDb.getHomeFolderId());
        assertNotNull(homeFolder.getId());
        assertEquals(homeFolder.getState(), ActorState.PENDING);
        assertNotNull(homeFolder.getAdress());
        assertEquals(homeFolder.getIndividuals().size(), 5);
        
        HomeFolder homeFolderOtherWay = homeFolderService.getById(dcvo.getHomeFolderId());
        assertNotNull(homeFolderOtherWay.getId());
        assertEquals(homeFolder.getId(), homeFolderOtherWay.getId());

        /////////////////////////////////////////////
        // Add the necessary pieces                //
        /////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        // create a document and attach it to the request
        Document doc = new Document();
        doc.setEcitizenNote("Mon livret de famille");
        doc.setDepositOrigin(DepositOrigin.ECITIZEN);
        doc.setDepositType(DepositType.PC);
        doc.setIndividualId(homeFolderResponsible.getId());
        doc.setHomeFolderId(homeFolder.getId());
        DocumentType documentType = 
            documentTypeService.getDocumentTypeByType(IDocumentTypeService.IDENTITY_RECEIPT_TYPE);
        doc.setDocumentType(documentType);
        Long documentId = documentService.create(doc);
        requestDocumentService.addDocument(requestId, documentId);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        File file = getResourceFile("family_notebook.jpg");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        docBin.setData(data);
        documentService.addPage(documentId, docBin);

        continueWithNewTransaction();
        
        // retrieve the associated document
        Set<RequestDocument> docSetFromDb = requestDocumentService.getAssociatedDocuments(requestId);
        assertEquals(1, docSetFromDb.size());
        RequestDocument docFromDb = docSetFromDb.iterator().next();
        assertEquals(documentId, docFromDb.getDocumentId());

        /////////////////////////////////////////////////////////
        // Authenticate and retrieve home folder               //
        /////////////////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        homeFolder = authenticationService.authenticate(homeFolderResponsible.getLogin(),"totopwd");
        assertNotNull("Retrieved home folder is null !", homeFolder);
        Adult respHomeFolderRetr = homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        assertNotNull("Retrieved home folder responsible is null !", respHomeFolderRetr);
        List<Individual> individuSetRetr = homeFolder.getIndividuals();
        assertEquals(individuSetRetr.size(),5);
        List<Request> folderRequests = requestSearchService.getByHomeFolderId(homeFolder.getId(), true);
        assertEquals(1, folderRequests.size());
        VoCardRequest dcvoRetr = (VoCardRequest) folderRequests.get(0);
        assertNotNull("Retrieved cartevaloise request is null !", dcvoRetr);
        assertEquals(homeFolderResponsible.getId(), dcvoRetr.getRequesterId());
        // test attachment of the documents
        List<Document> homeFolderDocuments = documentService.getHomeFolderDocuments(homeFolder.getId(), -1);
        assertEquals(1, homeFolderDocuments.size());
        Document homeFolderDoc = homeFolderDocuments.get(0);
        assertEquals("Mon livret de famille", homeFolderDoc.getEcitizenNote());

        /////////////////////////////////////////////////////////
        // Complete & Validate the home folder                 //
        /////////////////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(dcvoFromDb.getId(), RequestState.COMPLETE, null);
        
        continueWithNewTransaction();
        
        RequestState[] rs = requestWorkflowService.getPossibleTransitions(RequestState.COMPLETE);
        assertEquals(rs.length, 3);

        Set<Critere> criteriaSet = new HashSet<Critere>();
        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_LAST_INTERVENING_USER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(SecurityContext.getCurrentAgent().getId());
        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        List<Request> carteVoList = requestSearchService.get(criteriaSet, null, null, -1, 0, false);
        assertTrue(carteVoList.size() > 0);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        requestWorkflowService.updateRequestState(dcvoFromDb.getId(), RequestState.VALIDATED, null);
        continueWithNewTransaction();
        requestWorkflowService.updateRequestState(dcvoFromDb.getId(), RequestState.NOTIFIED,
            "Close me baby");
        continueWithNewTransaction();
        requestWorkflowService.updateRequestState(dcvoFromDb.getId(), RequestState.CLOSED, null);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // test certificate generation
        byte[] generatedCertificate = 
            requestSearchService.getCertificate(dcvoFromDb.getId(), RequestState.VALIDATED);
        if (generatedCertificate == null)
            fail("No certificate found");

        // DEBUG ONLY : and print it out on the disk
        File tempFile = File.createTempFile("tmp" + dcvoFromDb.getId(), ".pdf");
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(generatedCertificate);
        // END DEBUG

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // become back an ecitizen
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        Request yaRequest = requestSearchService.getById(dcvoFromDb.getId(), false);

        /////////////////////////////////////////////////////////
        // Change user's password                              //
        /////////////////////////////////////////////////////////
        
        homeFolderResponsible = 
            individualService.getAdultById(yaRequest.getRequesterId());
        String generatedPassword = authenticationService.generatePassword();
        individualService.modifyPassword(homeFolderResponsible, "totopwd", generatedPassword);
        continueWithNewTransaction();
        try {
            authenticationService.authenticate(homeFolderResponsible.getLogin(), generatedPassword);
        } catch (CvqAuthenticationFailedException cafe) {
            fail("Unable to authenticate user with its new password !");
        }
    }
}
