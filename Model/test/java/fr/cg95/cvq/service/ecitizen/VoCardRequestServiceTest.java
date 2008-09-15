package fr.cg95.cvq.service.ecitizen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

/**
 * The tests for the VO card request service.
 *
 * @author bor@zenexity.fr
 */
public class VoCardRequestServiceTest extends ServiceTestCase {

    public void testAll()
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException, CvqAuthenticationFailedException,
               java.io.IOException, java.io.FileNotFoundException {

        startTransaction();
        
        /////////////////////////////////////////////
        // Create the VO Card request in DB        //
        /////////////////////////////////////////////

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        VoCardRequest dcvo = new VoCardRequest();
        MeansOfContact meansOfContact = iMeansOfContactService.getMeansOfContactByType(
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
        homeFolderResponsible.addHomeFolderResponsibleRole();

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

        Set<Adult> adultSet = new HashSet<Adult>();
        adultSet.add(mother);
        adultSet.add(adultGrandMother);
        adultSet.add(homeFolderResponsible);

        Child child1 = BusinessObjectsFactory.gimmeChild("LASTNAME", "Child1", null, 
                mother, null);
        child1.setBirthCity("Paris");
        child1.setBirthCountry("France");
        child1.setBirthDate(new Date());
        child1.setBirthPostalCode("75012");
        child1.setFirstName2("Yargla");
        child1.setFirstName3("Djaba");
        child1.setSex(SexType.MALE);

        Adult tutorNotInHomeFolder = 
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "TUTOR", "outside", null, 
                    FamilyStatusType.MARRIED);
        Address tutorAddress = BusinessObjectsFactory.gimmeAdress("1","Rue de Cotte", "Paris", "75012");
        tutorNotInHomeFolder.setAdress(tutorAddress);
        
        Child child2 = 
            BusinessObjectsFactory.gimmeChild("LASTNAME", "Child2", homeFolderResponsible, mother, 
                    tutorNotInHomeFolder);
        Set<Child> childSet = new HashSet<Child>();
        childSet.add(child1);
        childSet.add(child2);

        iVoCardRequestService.create(dcvo, adultSet, childSet, address);

        homeFolderVoCardRequestIds.put(dcvo.getHomeFolder().getId(), dcvo.getId()); 

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // now that we have an user, set it in the context
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        // retrieve a fresh new home folder
        Long requestId = dcvo.getId();
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(requestId);
        homeFolderResponsible = homeFolder.getHomeFolderResponsible();
        
        //////////////////////////////////////////////////
        // test addition of the request and its attributes
        //////////////////////////////////////////////////

        VoCardRequest dcvoFromDb = (VoCardRequest) iVoCardRequestService.getById(requestId);
        Assert.assertEquals(dcvoFromDb.getState(), RequestState.PENDING);
        Assert.assertNotNull(dcvoFromDb.getRequester());

        Assert.assertNotNull(iVoCardRequestService.getCertificate(dcvoFromDb.getId(), RequestState.PENDING));
        
        Adult homeFolderResponsibleFromDb = dcvoFromDb.getHomeFolder().getHomeFolderResponsible();
        Assert.assertNotNull("Associated object of class Adult not saved !", homeFolderResponsibleFromDb);
        Assert.assertEquals(homeFolderResponsibleFromDb.getLastName(),"LASTNAME");
        Assert.assertEquals(homeFolderResponsibleFromDb.getId(), dcvoFromDb.getRequester().getId());
        Assert.assertEquals(homeFolderResponsibleFromDb.getState(), ActorState.PENDING);
        
        Address adresseFromDb = homeFolderResponsibleFromDb.getAdress();
        Assert.assertNotNull("Associated object of class Adress not saved !", adresseFromDb);
        Assert.assertEquals(adresseFromDb.getCity(),"PARIS");

        homeFolder = dcvoFromDb.getHomeFolder();
        Assert.assertNotNull(homeFolder.getId());
        Assert.assertEquals(homeFolder.getState(), ActorState.PENDING);
        Assert.assertNotNull(homeFolder.getAdress());
        Assert.assertEquals(homeFolder.getBoundToRequest(), Boolean.FALSE);
        Assert.assertEquals(homeFolder.getIndividuals().size(), 5);
        
        HomeFolder homeFolderOtherWay = iHomeFolderService.getByRequestId(requestId);
        Assert.assertNotNull(homeFolderOtherWay.getId());
        Assert.assertEquals(homeFolder.getId(), homeFolderOtherWay.getId());
        
        //////////////////////////////////////////////////
        // Perform some searches                        //
        //////////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(homeFolderResponsibleFromDb.getLastName());
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        Critere crit2 = new Critere();
        crit2.setAttribut(Request.SEARCH_BY_CREATION_DATE);
        crit2.setComparatif(Critere.LT);
        crit2.setValue(new Date());
        criteriaSet.add(crit2);
        Critere crit3 = new Critere();
        crit3.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        crit3.setComparatif(Critere.EQUALS);
        crit3.setValue(homeFolder.getId());
        criteriaSet.add(crit3);
        Set carteVoList = iVoCardRequestService.get(criteriaSet, null, false);
        Assert.assertEquals(carteVoList.size(),1);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue("connaispascegarsla!");
        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        carteVoList = iVoCardRequestService.get(criteriaSet, null, true);
        Assert.assertEquals(carteVoList.size(),0);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUEST_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(requestId);
        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        carteVoList = iVoCardRequestService.get(criteriaSet, null, true);
        Assert.assertEquals(carteVoList.size(), 1);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.NEQUALS);
        crit.setValue(String.valueOf(homeFolder.getId()));
        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        carteVoList = iVoCardRequestService.get(criteriaSet, null, false);
        Iterator carteVoListIt = carteVoList.iterator();
        while (carteVoListIt.hasNext()) {
            Request req = (Request) carteVoListIt.next();
            Assert.assertFalse(req.getId() == homeFolder.getId());
        }

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
        doc.setDocumentType(iDocumentService.getDocumentTypeById(IDocumentService.IDENTITY_RECEIPT_TYPE));
        Long documentId = iDocumentService.create(doc, homeFolder.getId(), null);
        iVoCardRequestService.addDocument(requestId, documentId);

        // add binary data
        DocumentBinary docBin = new DocumentBinary();
        docBin.setPageNumber(new Integer(1));
        File file = getResourceFile("family_notebook.jpg");
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        docBin.setData(data);
        iDocumentService.addPage(documentId, docBin);

        // retrieve the associated document
        Set docSetFromDb = iVoCardRequestService.getAssociatedDocuments(requestId);
        Assert.assertEquals(docSetFromDb.size(),1);
        Iterator docSetIt = docSetFromDb.iterator();
        Document docFromDb = (Document) docSetIt.next();
        Assert.assertNotNull("Associated object of class Document not saved !", docFromDb);

        /////////////////////////////////////////////////////////
        // Authenticate and retrieve home folder               //
        /////////////////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        homeFolder = iAuthenticationService.authenticate(homeFolderResponsible.getLogin(),"totopwd");
        Assert.assertNotNull("Retrieved home folder is null !", homeFolder);
        Adult respHomeFolderRetr = homeFolder.getHomeFolderResponsible();
        Assert.assertNotNull("Retrieved home folder responsible is null !", respHomeFolderRetr);
        Set individuSetRetr = homeFolder.getIndividuals();
        Assert.assertEquals(individuSetRetr.size(),5);
        Set folderRequests = iRequestService.getByRequesterId(homeFolderResponsible.getId());
        Assert.assertEquals("", folderRequests.size(), 1);
        VoCardRequest dcvoRetr = (VoCardRequest) folderRequests.iterator().next();
        Assert.assertNotNull("Retrieved cartevaloise request is null !", dcvoRetr);

        // test attachment of the documents
        Set homeFolderDocuments = iHomeFolderService.getAssociatedDocuments(homeFolder.getId());
        Assert.assertEquals(homeFolderDocuments.size(), 1);
        Document homeFolderDoc = (Document) homeFolderDocuments.iterator().next();
        Assert.assertEquals(homeFolderDoc.getEcitizenNote(), "Mon livret de famille");

        /////////////////////////////////////////////////////////
        // Complete & Validate the home folder                 //
        /////////////////////////////////////////////////////////

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iVoCardRequestService.complete(dcvoFromDb.getId());
        RequestState[] rs = iVoCardRequestService.getPossibleTransitions(RequestState.COMPLETE);
        Assert.assertEquals(rs.length, 3);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(SecurityContext.getCurrentAgent().getId());
        criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        carteVoList = iRequestService.get(criteriaSet, null, true);
        Assert.assertTrue(carteVoList.size() > 0);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // become back an ecitizen to test permission exception
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        String noteMsg = "Une petite note pour CVQ, une grande note pour le CG95";
        try {
            iVoCardRequestService.addNote(dcvoFromDb.getId(),
                    RequestNoteType.INSTRUCTION_EXTERNAL, noteMsg);
            fail("should have thrown an exception");
        } catch (CvqPermissionException ce) {
            // ok
        }

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // be an agent and add the note
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iVoCardRequestService.addNote(dcvoFromDb.getId(),
                RequestNoteType.DELIVERY_EXTERNAL, noteMsg);

        iRequestService.validate(dcvoFromDb.getId());
        iRequestService.notify(dcvoFromDb.getId(), "Close me baby");
        iRequestService.close(dcvoFromDb.getId());

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // test certificate generation
        byte[] generatedCertificate = 
            iRequestService.getCertificate(dcvoFromDb.getId(), RequestState.VALIDATED);
        if (generatedCertificate == null)
            fail("No certificate found");

        // DEBUG ONLY : and print it out on the disk
        File tempFile = File.createTempFile("tmp" + dcvoFromDb.getId(), ".pdf");
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(generatedCertificate);
        // END DEBUG

        Set actionsSet = iVoCardRequestService.getActions(dcvoFromDb.getId());
        Assert.assertEquals(actionsSet.size(), 5);

        // close current session and re-open a new one
        continueWithNewTransaction();
        
        // become back an ecitizen
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible.getLogin());

        Request yaRequest = iVoCardRequestService.getById(dcvoFromDb.getId());

        // test addition and modification of the note
        Set notes = yaRequest.getNotes();
        Assert.assertNotNull(notes);
        Assert.assertEquals(notes.size(), 1);
        RequestNote requestNote = (RequestNote) notes.iterator().next();
        Assert.assertEquals(requestNote.getNote(), noteMsg);

        /////////////////////////////////////////////////////////
        // Change user's password                              //
        /////////////////////////////////////////////////////////
        
        homeFolderResponsible = yaRequest.getHomeFolder().getHomeFolderResponsible();
        String generatedPassword = iAuthenticationService.generatePassword();
        iAdultService.modifyPassword(homeFolderResponsible, "totopwd", generatedPassword);
        try {
            iAuthenticationService.authenticate(homeFolderResponsible.getLogin(), generatedPassword);
        } catch (CvqAuthenticationFailedException cafe) {
            fail("Unable to authenticate user with its new password !");
        }
    }
}
