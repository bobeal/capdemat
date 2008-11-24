package fr.cg95.cvq.service.users;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.authority.SectionType;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * The tests for the home folder modification request service.
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderModificationRequestServiceTest extends ServiceTestCase {

    protected ISchoolRegistrationRequestService iSchoolRegistrationRequestService;

    protected void onSetUp() throws Exception {
        super.onSetUp();
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        iSchoolRegistrationRequestService = 
            (ISchoolRegistrationRequestService) cac.getBean("schoolRegistrationRequestService");
    }

    // define some objects that will be reused throughout the different tests
    private Address adress;
    private Set<Adult> adults;
    private Set<Child> children;
    private HomeFolder homeFolder;
    private HomeFolderModificationRequest hfmr;
    private Long hfmrId;
    private String proposedLogin;

    private Child newChild;
    private Adult newAdult;

    /**
     * Overrided to run invariant tests.
     */
    protected void onTearDown() 
        throws Exception {

        logger.debug("onTearDown()");
        
        try {
            // check entries have been deleted from history table
            Set<HistoryEntry> remainingEntries =
                iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
            Assert.assertEquals(0, remainingEntries.size());
        } catch (Exception e) {
            // just catch and let tear down go up to his parent
        }

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        iHomeFolderModificationRequestService.delete(hfmrId);
        
        super.onTearDown();
    }
    
    private Long createModificationRequest()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        Long requestId = cb.getRequestId();
        proposedLogin = cb.getLogin();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iRequestService.complete(requestId);
        iRequestService.validate(requestId);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        // create the home folder modification request
        hfmr = iHomeFolderModificationRequestService.create(homeFolderId,
                iHomeFolderService.getHomeFolderResponsible(homeFolderId).getId());

        // prepare objects for modifications
        adress = homeFolder.getAdress();
        Set<Individual> individuals = homeFolder.getIndividuals();
        adults = new HashSet<Adult>();
        children = new HashSet<Child>();
        for (Individual individual : individuals) {
            if (individual instanceof Child)
                children.add((Child) individual);
            else
                adults.add((Adult) individual);
        }

        return hfmr.getId();
    }

    private void prepareSimpleModifications()
        throws CvqException {

        hfmrId = createModificationRequest();

        // start modifications ...

        // ... on an adult
        homeFolderUncle.setFirstName("Yarglaa");
        homeFolderUncle.setFirstName3("Groumph");
        homeFolderUncle.setProfession("Entraineur du PSG");
        homeFolderUncle.setSex(SexType.FEMALE);
        homeFolderUncle.setBirthDate(new Date());
        Address newAdress =
            BusinessObjectsFactory.gimmeAdress("1","Rue du centre",
                    "Drancy", "93700");
        homeFolderUncle.setAdress(newAdress);

        Adult testReloadedWoman = iIndividualService.getAdultById(homeFolderWoman.getId());
        testReloadedWoman.setFirstName2("Angélique");
        Set<Adult> newAdults = new HashSet<Adult>();
        newAdults.add(homeFolderUncle);
        newAdults.add(homeFolderResponsible);
        newAdults.add(testReloadedWoman);

        // ... and on the adress
        adress.setPostalCode("75013");
        adress.setCity("Paris Ville Lumière");

        iHomeFolderModificationRequestService.modify(hfmr, newAdults, children, adress);
    }

    public void testSimpleModificationsValidated()
        throws CvqException {

        try {
            
        prepareSimpleModifications();

        continueWithNewTransaction();
        
        // debug only
        Set<HistoryEntry> entries =
            iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
        for (HistoryEntry historyEntry : entries) {
            logger.debug("got history entry : " + historyEntry);
        }
        
        // now retrieve and display them
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) iHomeFolderModificationRequestService.getById(hfmrId);
        homeFolder = iHomeFolderService.getById(hfmrFromDb.getHomeFolderId());
        adress = homeFolder.getAdress();
        Assert.assertEquals(adress.getPostalCode(), "75013");
        Assert.assertEquals(adress.getCity(), "Paris Ville Lumière".toUpperCase());
        Set<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            if (individual.getId().equals(homeFolderUncle.getId())) {
                Assert.assertEquals(homeFolderUncle.getFirstName3(), "Groumph");
                Assert.assertEquals(homeFolderUncle.getProfession(), "Entraineur du PSG");
            }
        }

        continueWithNewTransaction();
        
        // validate request and check we did not loose any information
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();

        // check modifications are still there
        hfmrFromDb =
            (HomeFolderModificationRequest) iHomeFolderModificationRequestService.getById(hfmrId);
        homeFolder = iHomeFolderService.getById(hfmrFromDb.getHomeFolderId());
        adress = homeFolder.getAdress();
        Assert.assertEquals(adress.getPostalCode(), "75013");
        Assert.assertEquals(adress.getCity(), "Paris Ville Lumière".toUpperCase());
        
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testSimpleModificationsCancelled()
        throws CvqException {

        prepareSimpleModifications();

        continueWithNewTransaction();
        
        // cancel request and check we got back to the original state
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) iHomeFolderModificationRequestService.getById(hfmrId);
        homeFolder = iHomeFolderService.getById(hfmrFromDb.getHomeFolderId());
        adress = homeFolder.getAdress();
        Assert.assertEquals(adress.getPostalCode(), "75012");
        Assert.assertEquals(adress.getCity(), "Paris".toUpperCase());
        Set<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            if (individual.getId().equals(homeFolderUncle.getId())) {
                Assert.assertEquals(individual.getLastName(), "LASTNAME");
                Assert.assertTrue(individual.getFirstName().startsWith("uncle"));
            }
        }
    }

    private void prepareChildAdultAddWithClr()
        throws CvqException {

        hfmrId = createModificationRequest();

        newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "adult", "new", 
                null, FamilyStatusType.SINGLE);
        adults.add(newAdult);
        iHomeFolderService.addIndividualRole(newAdult, child1, RoleEnum.CLR_TUTOR);
        
        iHomeFolderService.removeIndividualRole(homeFolderUncle.getId(), child1, 
                RoleEnum.CLR_TUTOR); 
        
        newChild = BusinessObjectsFactory.gimmeChild("child", "new");
        iHomeFolderService.addIndividualRole(homeFolderResponsible.getId(), 
                newChild, RoleEnum.CLR_FATHER);
        iHomeFolderService.addIndividualRole(newAdult, newChild, RoleEnum.CLR_TUTOR);
        children.add(newChild);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testChildAdultAddWithClrValidated()
        throws CvqException {

        prepareChildAdultAddWithClr();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
        
        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        Adult adult = iIndividualService.getAdultById(newAdult.getId());
        assertNotNull(adult);
        assertNotNull(adult.getIndividualRoles());
        assertEquals(2, adult.getIndividualRoles().size());
        IndividualRole individualRole = adult.getIndividualRoles().iterator().next();
        if (individualRole.getIndividualId().equals(child1.getId())) {
            assertEquals(RoleEnum.CLR_TUTOR, individualRole.getRole());
            assertEquals(child1.getId(), individualRole.getIndividualId());
        } else if (individualRole.getIndividualId().equals(newChild.getId())) {
            assertEquals(RoleEnum.CLR_TUTOR, individualRole.getRole());
            assertEquals(newChild.getId(), individualRole.getIndividualId());            
        } else {
            fail("should have been one of above");
        }
    }

    public void testChildAdultAddWithClrCancelled()
        throws CvqException {

        try {

            prepareChildAdultAddWithClr();

            continueWithNewTransaction();

            List<Individual> individuals = 
                iHomeFolderService.getBySubjectRole(child1.getId(), RoleEnum.CLR_TUTOR);
            assertEquals(1, individuals.size());
            assertEquals(newAdult.getId(), individuals.get(0).getId());

            // be an agent to perform request state changes
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            iHomeFolderModificationRequestService.cancel(hfmr.getId());

            continueWithNewTransaction();

            try {
                iIndividualService.getById(newAdult.getId());
                fail("should have thrown an exception");
            } catch (CvqObjectNotFoundException confe) {
                // that was expected
            }

            individuals = iHomeFolderService.getBySubjectRole(child1.getId(), RoleEnum.CLR_TUTOR);
            assertEquals(1, individuals.size());
            assertEquals(homeFolderUncle.getId(), individuals.get(0).getId());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void prepareChildrenAddRemove()
        throws CvqException {

        hfmrId = createModificationRequest();

        children.remove(child2);

        child1.setBirthCity("Paris");

        newChild = BusinessObjectsFactory.gimmeChild("Badiane", "XXXX");
        iHomeFolderService.addIndividualRole(homeFolderResponsible.getId(), 
                newChild, RoleEnum.CLR_FATHER);
        iHomeFolderService.addIndividualRole(homeFolderWoman.getId(), 
                newChild, RoleEnum.CLR_MOTHER);
        iHomeFolderService.addIndividualRole(homeFolderUncle.getId(), 
                newChild, RoleEnum.CLR_TUTOR);
        children.add(newChild);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testChildrenAddRemoveValidated()
        throws Exception {

        try {

            prepareChildrenAddRemove();

            continueWithNewTransaction();

            // check modifications have been saved
            children = iHomeFolderService.getChildren(homeFolder.getId());
            assertEquals(2, children.size());
            RoleEnum[] roles = {RoleEnum.CLR_FATHER, RoleEnum.CLR_MOTHER, RoleEnum.CLR_TUTOR };
            for (Child child : children) {
                if (child.getFirstName().equals(child1.getFirstName())) {
                    assertEquals(child.getBirthCity(), "Paris");
                    //                assertEquals(3, iIndividualService.getBySubjectRoles(child.getId(), roles).size());
                } else if (child.getFirstName().equals(newChild.getFirstName())) {
                    assertEquals(child.getLastName(), "Badiane");
                    assertEquals(3, iHomeFolderService.getBySubjectRoles(child.getId(), roles).size());
                } else {
                    fail("Don't know this child : " + child);
                }
            }

            continueWithNewTransaction();

            // be an agent to perform request state changes
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            iHomeFolderModificationRequestService.complete(hfmr.getId());
            iHomeFolderModificationRequestService.validate(hfmr.getId());

            continueWithNewTransaction();

            // become back an ecitizen to retrieve information
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(proposedLogin);

            // check modifications are still saved
            children = iHomeFolderService.getChildren(homeFolder.getId());
            assertEquals(2, children.size());
            for (Child child : children) {
                if (child.getFirstName().equals(child1.getFirstName())) {
                    assertEquals(child.getBirthCity(), "Paris");
                    assertEquals(3, iHomeFolderService.getBySubjectRoles(child.getId(), roles).size());
                } else if (child.getFirstName().equals(newChild.getFirstName())) {
                    assertEquals(child.getLastName(), "Badiane");
                    assertEquals(3, iHomeFolderService.getBySubjectRoles(child.getId(), roles).size());
                } else {
                    fail("Don't know this child : " + child);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Argh");
        }
    }

    public void testChildrenAddRemoveCancelled()
        throws Exception {

        prepareChildrenAddRemove();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // check modifications have been effectively cancelled
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) iHomeFolderModificationRequestService.getById(hfmrId);
        homeFolder = iHomeFolderService.getById(hfmrFromDb.getHomeFolderId());
        children = iHomeFolderService.getChildren(homeFolder.getId());
        assertEquals(2, children.size());
        RoleEnum[] roles = {RoleEnum.CLR_FATHER, RoleEnum.CLR_MOTHER, RoleEnum.CLR_TUTOR };
        for (Child child : children) {
            Assert.assertNotSame(child.getFirstName(), "XXXX");
            Assert.assertNotNull(child.getAdress());
            Assert.assertEquals(child.getLastName(), "LASTNAME");
            if (child.getFirstName().equals("childone")) {
                assertEquals(3, iHomeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else if (child.getFirstName().equals("childtwo")) {
                assertEquals(1, iHomeFolderService.getBySubjectRoles(child.getId(), roles).size());
            }
        }
    }

    private void prepareSimpleAdultsAddRemove()
        throws CvqException {

        hfmrId = createModificationRequest();

        // remove an adult and add a new one

        adults.remove(homeFolderUncle);

        Address newAdress = 
            BusinessObjectsFactory.gimmeAdress("1","Rue des Ecoles", "Paris", "75005");
        Adult newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER,"adult",
                "new", newAdress, FamilyStatusType.SINGLE);
        newAdult.setPassword("toto");

        adults.add(newAdult);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testSimpleAdultsAddRemoveValidated()
        throws CvqException {

        prepareSimpleAdultsAddRemove();

        continueWithNewTransaction();

        // check modifications have been saved
        Set<Adult> allAdults = iHomeFolderService.getAdults(homeFolder.getId());
        assertEquals(3, allAdults.size());
        assertFalse(allAdults.contains(homeFolderUncle));

        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
        
        // check removed adult has been deleted from DB
        try {
            iIndividualService.getById(homeFolderUncle.getId());
            fail("Adult should have been removed");
        } catch (CvqObjectNotFoundException confe) {
            // that's what we expected
        }

        // check new adult and its specific adress are well stored
        allAdults = iHomeFolderService.getAdults(homeFolder.getId());
        assertEquals(3, allAdults.size());
        boolean foundNewAdult = false;
        for (Adult tempAdult : allAdults) {
            if (tempAdult.getLastName().equals("adult")) {
                foundNewAdult = true;
                assertNotNull(tempAdult.getAdress());
                assertEquals("75005", tempAdult.getAdress().getPostalCode());
            }
        }
        if (!foundNewAdult)
            fail("Newly added adult has not been found in home folder");
    }

    public void testSimpleAdultsAddRemoveCancelled()
        throws CvqException {

        prepareSimpleAdultsAddRemove();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        // check removed adult has been restored
        try {
            iIndividualService.getById(homeFolderUncle.getId());
        } catch (CvqObjectNotFoundException confe) {
            fail("Adult should have been restored");
        }
    }

    private void prepareHomeFolderResponsibleChange()
        throws CvqException {

        hfmrId = createModificationRequest();

        Adult responsibleToRemove = 
            iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        adults.remove(responsibleToRemove);

        iHomeFolderService.addHomeFolderRole(homeFolderUncle.getId(), homeFolder.getId(), 
                RoleEnum.HOME_FOLDER_RESPONSIBLE);
        iHomeFolderService.addIndividualRole(homeFolderUncle.getId(), child2, RoleEnum.CLR_FATHER);
        homeFolderUncle.setPassword("toto");

        iHomeFolderService.removeHomeFolderRole(responsibleToRemove.getId(), 
                homeFolder.getId(), RoleEnum.HOME_FOLDER_RESPONSIBLE);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testHomeFolderResponsibleChangeValidated()
        throws CvqException {

        try {
            prepareHomeFolderResponsibleChange();

            continueWithNewTransaction();

            // be an agent to perform request state changes
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            iHomeFolderModificationRequestService.complete(hfmr.getId());
            iHomeFolderModificationRequestService.validate(hfmr.getId());

            continueWithNewTransaction();

            homeFolder = iHomeFolderService.getById(homeFolder.getId());
            adults = iHomeFolderService.getAdults(homeFolder.getId());
            Assert.assertEquals(adults.size(), 2);
            Adult homeFolderResponsible = 
                iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
            Assert.assertEquals(homeFolderResponsible.getLastName(), homeFolderUncle.getLastName());
            Assert.assertEquals(homeFolderResponsible.getFirstName(), homeFolderUncle.getFirstName());
        
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testHomeFolderResponsibleChangeCancelled()
        throws CvqException {

        prepareHomeFolderResponsibleChange();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        homeFolder = iHomeFolderService.getById(homeFolder.getId());
        adults = iHomeFolderService.getAdults(homeFolder.getId());
        Assert.assertEquals(adults.size(), 3);
        Adult homeFolderResponsible = 
            iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        Assert.assertEquals(homeFolderResponsible.getLastName(), "LASTNAME");
        Assert.assertEquals(homeFolderResponsible.getFirstName(), "responsible");
    }

    /**
     * A side effect noticed on production : an home folder with a child registered to school. 
     * if the home folder issue an home folder modification request then the child reappears
     * in the list of subjects authorized to issue a school registration request.
     */
    public void testSchoolRegistrationsSideEffect()
        throws CvqException {

        try {
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

            // create a vo card request (to create home folder and associates)
            CreationBean cb = gimmeAnHomeFolder();

            Long requestId = cb.getRequestId();
            proposedLogin = cb.getLogin();

            continueWithNewTransaction();
            
            // be an agent to perform request state changes
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
            
            iRequestService.complete(requestId);
            iRequestService.validate(requestId);

            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(proposedLogin);

            // get the home folder id
            homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
            Long homeFolderId = homeFolder.getId();
            assertNotNull(homeFolderId);

            // register a child to school

            // get a school for our school and canteen registrations
            Set schoolsSet = schoolService.getAll();
            if (schoolsSet == null || schoolsSet.size() == 0)
                fail("No school created in the system, can't go further");
            School school = (School) schoolsSet.iterator().next();

            // fill the child with the most we can
            child1.setNote("Coucou, je suis l'enfant child1");
            child1.setBirthPostalCode("93240");
            child1.setBirthCity("Livry-Gargan");
            child1.setSex(SexType.MALE);
            child1.setBadgeNumber("XXX111GGG");

            SchoolRegistrationRequest srr = new SchoolRegistrationRequest();
            srr.setCurrentSchoolName("Ecolde des Yarglas");
            srr.setSection(SectionType.CP);
            srr.setUrgencyPhone("0102030405");
            srr.setSchool(school);
            srr.setSubjectId(child1.getId());
            srr.setRequesterId(SecurityContext.getCurrentUserId());
            
            Long srrId =
                iSchoolRegistrationRequestService.create(srr);

            continueWithNewTransaction();

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            iSchoolRegistrationRequestService.complete(srrId);
            iSchoolRegistrationRequestService.validate(srrId);

            continueWithNewTransaction();

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
            SecurityContext.setCurrentEcitizen(proposedLogin);

            Set<Long> authorizedSchoolRegistrations =
                iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();
            assertEquals(1, authorizedSchoolRegistrations.size());

            // create the home folder modification request
            homeFolder = iHomeFolderService.getById(homeFolderId);
            homeFolderResponsible = 
                iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
            hfmr = iHomeFolderModificationRequestService.create(homeFolderId,
                    homeFolderResponsible.getId());
            hfmrId = hfmr.getId();

            Set<Adult> adultSet = new HashSet<Adult>();
            adultSet.add(homeFolderResponsible);
            adultSet.add(homeFolderWoman);
            adultSet.add(homeFolderUncle);
            Set<Child> childSet = new HashSet<Child>();
            childSet.add(child1);
            childSet.add(child2);
            Address newAdress =
                BusinessObjectsFactory.gimmeAdress("1","Rue du centre", "Drancy", "93700");

            iHomeFolderModificationRequestService.modify(hfmr, adultSet, childSet, newAdress);

            continueWithNewTransaction();

            authorizedSchoolRegistrations =
                iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();
            assertEquals(1, authorizedSchoolRegistrations.size());

            // that's ok, cancel the home folder modification request
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            iHomeFolderModificationRequestService.cancel(hfmr.getId());
            iSchoolRegistrationRequestService.delete(srrId);

            continueWithNewTransaction();
        
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
