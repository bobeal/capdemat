package fr.cg95.cvq.service.request.ecitizen;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
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
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.SectionType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.dao.users.IHistoryEntryDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

/**
 * The tests for the home folder modification request service.
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderModificationRequestServiceTest extends RequestTestCase {

    @Resource(name="homeFolderModificationRequestService")
    protected IRequestService homeFolderModificationRequestService;
    @Resource(name="schoolRegistrationRequestService")
    protected IRequestService schoolRegistrationRequestService;
    @Autowired
    protected IHistoryEntryDAO historyEntryDAO;
    
    // define some objects that will be reused throughout the different tests
    private Address address;
    private List<Adult> adults;
    private List<Child> children;
    private HomeFolder homeFolder;
    private HomeFolderModificationRequest hfmr;
    private String proposedLogin;

    private Child newChild;
    private Adult newAdult;
    // Useful to clean individual who do not belong to homeFolder in onTearDown
    protected Set< Long> foreignOwnersIds = new HashSet<Long>();

    /**
     * Overrided to run invariant tests.
     */
    @Override
    public void onTearDown() throws Exception {

        continueWithNewTransaction();
        
        try {
            // check entries have been deleted from history table
            List<HistoryEntry> remainingEntries = historyEntryDAO.listByRequestId(hfmr.getId());
            assertEquals(0, remainingEntries.size());
        } catch (Exception e) {
            // just catch and let tear down go up to his parent
        }

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.delete(hfmr.getId());

        Iterator<Long> it = foreignOwnersIds.iterator();
        while (it.hasNext()) {
            Adult a = individualService.getAdultById(it.next());
            individualService.delete(a);
            it.remove();
        }

        super.onTearDown();
    }

    private void createModificationRequest() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();

        Long requestId = cb.getRequestId();
        proposedLogin = cb.getLogin();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestWorkflowService.updateRequestState(requestId, RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(requestId, RequestState.VALIDATED, null);

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        homeFolder = homeFolderService.getById(cb.getHomeFolderId());

        // create the home folder modification request
        hfmr = new HomeFolderModificationRequest();

        // prepare objects for modifications
        address = homeFolder.getAddress();
        List<Individual> individuals = homeFolder.getIndividuals();
        adults = new ArrayList<Adult>();
        children = new ArrayList<Child>();
        for (Individual individual : individuals) {
            if (individual instanceof Child)
                children.add((Child) individual);
            else
                adults.add((Adult) individual);
        }
    }

    @Test
    public void testMultiHibernateTransaction()
        throws CvqException {

        createModificationRequest();

        continueWithNewTransaction();

        List<Adult> copyAdults = new ArrayList<Adult>();
        List<Child> copyChildren = new ArrayList<Child>();

        for (Individual individual : homeFolder.getIndividuals()) {
            if (individual  instanceof Adult)
                copyAdults.add((Adult)individual);
            else if (individual  instanceof Child)
                copyChildren.add((Child)individual );
        }

        List<Adult> foreignOwners = new ArrayList<Adult>();
        foreignOwners.add(BusinessObjectsFactory.gimmeAdult(TitleType.MADAM, "TUTOR", "Foreign", 
                address.clone(), FamilyStatusType.OTHER));
        homeFolderService.addHomeFolderRole(foreignOwners.get(0), homeFolder.getId(), 
                RoleType.HOME_FOLDER_RESPONSIBLE);
        continueWithNewTransaction();

        requestWorkflowService.createAccountModificationRequest(hfmr, copyAdults, copyChildren, 
                foreignOwners, address, null, null);
        assertEquals(copyAdults.size() + copyChildren.size(), 
                homeFolder.getIndividuals().size());

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();

        for (Adult adult : foreignOwners)
            foreignOwnersIds.add(adult.getId());
    }
    
    private void prepareSimpleModifications()
        throws CvqException {

        createModificationRequest();

        // start modifications ...

        // ... on an adult
        homeFolderUncle.setFirstName("Yarglaa");
        homeFolderUncle.setFirstName3("Groumph");
        homeFolderUncle.setProfession("Entraineur du PSG");
        homeFolderUncle.setBirthDate(new Date());
        Address newAddress =
            BusinessObjectsFactory.gimmeAddress("1","Rue du centre",
                    "Drancy", "93700");
        homeFolderUncle.setAddress(newAddress);

        Adult testReloadedWoman = individualService.getAdultById(homeFolderWoman.getId());
        testReloadedWoman.setFirstName2("Angélique");
        List<Adult> newAdults = new ArrayList<Adult>();
        newAdults.add(homeFolderUncle);
        newAdults.add(homeFolderResponsible);
        newAdults.add(testReloadedWoman);

        // ... and on the address
        address.setPostalCode("75013");
        address.setCity("Paris Ville Lumière");
        
        requestWorkflowService.createAccountModificationRequest(hfmr, newAdults, children, 
                null, address, null, null);
    }

    @Test
    public void testSimpleModificationsValidated()
        throws CvqException {

        prepareSimpleModifications();

        continueWithNewTransaction();
        
        // now retrieve and display them
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) requestSearchService.getById(hfmr.getId(), false);
        homeFolder = homeFolderService.getById(hfmrFromDb.getHomeFolderId());
        address = homeFolder.getAddress();
        assertEquals(address.getPostalCode(), "75013");
        assertEquals(address.getCity(), "Paris Ville Lumière".toUpperCase());
        List<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            if (individual.getId().equals(homeFolderUncle.getId())) {
                assertEquals(homeFolderUncle.getFirstName3(), "Groumph");
                assertEquals(homeFolderUncle.getProfession(), "Entraineur du PSG");
            }
        }

        continueWithNewTransaction();
        
        // validate request and check we did not loose any information
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();

        // check modifications are still there
        hfmrFromDb =
            (HomeFolderModificationRequest) requestSearchService.getById(hfmr.getId(), false);
        homeFolder = homeFolderService.getById(hfmrFromDb.getHomeFolderId());
        address = homeFolder.getAddress();
        assertEquals(address.getPostalCode(), "75013");
        assertEquals(address.getCity(), "Paris Ville Lumière".toUpperCase());
    }

    @Test
    public void testSimpleModificationsCancelled()
        throws CvqException {

        prepareSimpleModifications();

        continueWithNewTransaction();
        
        // cancel request and check we got back to the original state
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();
        
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) requestSearchService.getById(hfmr.getId(), false);
        homeFolder = homeFolderService.getById(hfmrFromDb.getHomeFolderId());
        address = homeFolder.getAddress();
        assertEquals(address.getPostalCode(), "75012");
        assertEquals(address.getCity(), "Paris".toUpperCase());
        List<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            if (individual.getId().equals(homeFolderUncle.getId())) {
                assertEquals(individual.getLastName(), "LASTNAME");
                assertTrue(individual.getFirstName().startsWith("uncle"));
            }
        }
    }

    private void prepareChildAdultAddWithClr()
        throws CvqException {

        createModificationRequest();

        newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "adult", "new", 
                null, FamilyStatusType.SINGLE);
        adults.add(newAdult);
        homeFolderService.addIndividualRole(newAdult, child1, RoleType.CLR_TUTOR);
        
        homeFolderService.removeIndividualRole(homeFolderUncle, child1, 
                RoleType.CLR_TUTOR); 
        
        newChild = BusinessObjectsFactory.gimmeChild("child", "new");
        homeFolderService.addIndividualRole(homeFolderResponsible, 
                newChild, RoleType.CLR_FATHER);
        homeFolderService.addIndividualRole(newAdult, newChild, RoleType.CLR_TUTOR);
        children.add(newChild);

        requestWorkflowService.createAccountModificationRequest(hfmr, adults, children, 
                null, address, null, null);
    }

    @Test
    public void testChildAdultAddWithClrValidated()
        throws CvqException {
        
        prepareChildAdultAddWithClr();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        Adult adult = individualService.getAdultById(newAdult.getId());
        assertNotNull(adult);
        assertNotNull(adult.getIndividualRoles());
        assertEquals(2, adult.getIndividualRoles().size());
        IndividualRole individualRole = adult.getIndividualRoles().iterator().next();
        if (individualRole.getIndividualId().equals(child1.getId())) {
            assertEquals(RoleType.CLR_TUTOR, individualRole.getRole());
            assertEquals(child1.getId(), individualRole.getIndividualId());
        } else if (individualRole.getIndividualId().equals(newChild.getId())) {
            assertEquals(RoleType.CLR_TUTOR, individualRole.getRole());
            assertEquals(newChild.getId(), individualRole.getIndividualId());            
        } else {
            fail("should have been one of above");
        }
    }

    @Test
    public void testChildAdultAddWithClrCancelled()
        throws CvqException {

        prepareChildAdultAddWithClr();

        continueWithNewTransaction();

        List<Individual> individuals = 
            homeFolderService.getBySubjectRole(child1.getId(), RoleType.CLR_TUTOR);
        assertEquals(1, individuals.size());
        assertEquals(newAdult.getId(), individuals.get(0).getId());

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();

        try {
            individualService.getById(newAdult.getId());
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        individuals = homeFolderService.getBySubjectRole(child1.getId(), RoleType.CLR_TUTOR);
        assertEquals(1, individuals.size());
        assertEquals(homeFolderUncle.getId(), individuals.get(0).getId());
    }

    private void prepareChildrenAddRemove()
        throws CvqException {

        createModificationRequest();

        children.remove(child2);

        child1.setBirthCity("Paris");

        newChild = BusinessObjectsFactory.gimmeChild("Badiane", "XXXX");
        homeFolderService.addIndividualRole(homeFolderResponsible, 
                newChild, RoleType.CLR_FATHER);
        homeFolderService.addIndividualRole(homeFolderWoman, 
                newChild, RoleType.CLR_MOTHER);
        homeFolderService.addIndividualRole(homeFolderUncle, 
                newChild, RoleType.CLR_TUTOR);
        children.add(newChild);

        requestWorkflowService.createAccountModificationRequest(hfmr, adults, children, 
                null, address, null, null);
    }

    @Test
    public void testChildrenAddRemoveValidated()
        throws Exception {

        prepareChildrenAddRemove();

        continueWithNewTransaction();

        assertNotNull(newChild.getId());

        // used to resync home folder responsible wrt home folder state
        homeFolderResponsible =
            homeFolderService.getHomeFolderResponsible(hfmr.getHomeFolderId());
        SecurityContext.setCurrentEcitizen(homeFolderResponsible);

        // check modifications have been saved
        children = homeFolderService.getChildren(homeFolder.getId());
        assertEquals(2, children.size());
        RoleType[] roles = {RoleType.CLR_FATHER, RoleType.CLR_MOTHER, RoleType.CLR_TUTOR };
        for (Child child : children) {
            if (child.getFirstName().equals(child1.getFirstName())) {
                assertEquals(child.getBirthCity(), "Paris");
                assertEquals(3, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else if (child.getFirstName().equals(newChild.getFirstName())) {
                assertEquals(child.getLastName(), "Badiane");
                assertEquals(3, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else {
                fail("Don't know this child : " + child);
            }
        }

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();

        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // check modifications are still saved
        children = homeFolderService.getChildren(homeFolder.getId());
        assertEquals(2, children.size());
        for (Child child : children) {
            if (child.getFirstName().equals(child1.getFirstName())) {
                assertEquals(child.getBirthCity(), "Paris");
                assertEquals(3, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else if (child.getFirstName().equals(newChild.getFirstName())) {
                assertEquals(child.getLastName(), "Badiane");
                assertEquals(3, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else {
                fail("Don't know this child : " + child);
            }
        }
    }

    @Test
    public void testChildrenAddRemoveCancelled()
        throws Exception {

        prepareChildrenAddRemove();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();
        
        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // check modifications have been effectively cancelled
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) requestSearchService.getById(hfmr.getId(), false);
        homeFolder = homeFolderService.getById(hfmrFromDb.getHomeFolderId());
        children = homeFolderService.getChildren(homeFolder.getId());
        assertEquals(2, children.size());
        RoleType[] roles = {RoleType.CLR_FATHER, RoleType.CLR_MOTHER, RoleType.CLR_TUTOR };
        for (Child child : children) {
            assertNotSame(child.getFirstName(), "XXXX");
            assertNotNull(child.getAddress());
            assertEquals(child.getLastName(), "LASTNAME");
            if (child.getFirstName().equals("childone")) {
                assertEquals(3, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            } else if (child.getFirstName().equals("childtwo")) {
                assertEquals(1, homeFolderService.getBySubjectRoles(child.getId(), roles).size());
            }
        }
    }

    private void prepareSimpleAdultsAddRemove()
        throws CvqException {

        createModificationRequest();

        // remove an adult and add a new one

        adults.remove(homeFolderUncle);

        Address newAddress = 
            BusinessObjectsFactory.gimmeAddress("1","Rue des Ecoles", "Paris", "75005");
        Adult newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER,"adult",
                "new", newAddress, FamilyStatusType.SINGLE);
        newAdult.setPassword("toto");

        adults.add(newAdult);

        requestWorkflowService.createAccountModificationRequest(hfmr, adults, children, 
                null, address, null, null);
    }

    @Test
    public void testSimpleAdultsAddRemoveValidated()
        throws CvqException {

        prepareSimpleAdultsAddRemove();

        continueWithNewTransaction();

        // check modifications have been saved
        List<Adult> allAdults = homeFolderService.getAdults(homeFolder.getId());
        assertEquals(3, allAdults.size());
        assertFalse(allAdults.contains(homeFolderUncle));

        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        // check removed adult has been deleted from DB
        try {
            individualService.getById(homeFolderUncle.getId());
            fail("Adult should have been removed");
        } catch (CvqObjectNotFoundException confe) {
            // that's what we expected
        }

        // check new adult and its specific address are well stored
        allAdults = homeFolderService.getAdults(homeFolder.getId());
        assertEquals(3, allAdults.size());
        boolean foundNewAdult = false;
        for (Adult tempAdult : allAdults) {
            if (tempAdult.getLastName().equals("adult")) {
                foundNewAdult = true;
                assertNotNull(tempAdult.getAddress());
                assertEquals("75005", tempAdult.getAddress().getPostalCode());
            }
        }
        if (!foundNewAdult)
            fail("Newly added adult has not been found in home folder");
    }

    @Test
    public void testSimpleAdultsAddRemoveCancelled()
        throws CvqException {

        prepareSimpleAdultsAddRemove();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();
        // check removed adult has been restored
        try {
            individualService.getById(homeFolderUncle.getId());
        } catch (CvqObjectNotFoundException confe) {
            fail("Adult should have been restored");
        }
    }

    private void prepareHomeFolderResponsibleChange()
        throws CvqException {

        createModificationRequest();

        Adult responsibleToRemove = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        adults.remove(responsibleToRemove);

        homeFolderService.addHomeFolderRole(homeFolderUncle, homeFolder.getId(), 
                RoleType.HOME_FOLDER_RESPONSIBLE);
        homeFolderService.addIndividualRole(homeFolderUncle, child2, RoleType.CLR_FATHER);
        homeFolderUncle.setPassword("toto");

        homeFolderService.removeHomeFolderRole(responsibleToRemove, 
                homeFolder.getId(), RoleType.HOME_FOLDER_RESPONSIBLE);

        requestWorkflowService.createAccountModificationRequest(hfmr, adults, children, 
                null, address, null, null);
    }

    @Test
    public void testHomeFolderResponsibleChangeValidated()
        throws CvqException {

        prepareHomeFolderResponsibleChange();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();

        homeFolder = homeFolderService.getById(homeFolder.getId());
        adults = homeFolderService.getAdults(homeFolder.getId());
        assertEquals(adults.size(), 2);
        Adult homeFolderResponsible = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        assertEquals(homeFolderResponsible.getLastName(), homeFolderUncle.getLastName());
        assertEquals(homeFolderResponsible.getFirstName(), homeFolderUncle.getFirstName());
    }

    @Test
    public void testHomeFolderResponsibleChangeCancelled()
        throws CvqException {

        prepareHomeFolderResponsibleChange();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(hfmr.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();
        
        homeFolder = homeFolderService.getById(homeFolder.getId());
        adults = homeFolderService.getAdults(homeFolder.getId());
        assertEquals(adults.size(), 3);
        Adult homeFolderResponsible = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        assertEquals(homeFolderResponsible.getLastName(), "LASTNAME");
        assertEquals(homeFolderResponsible.getFirstName(), "responsible");
    }

    /**
     * A side effect noticed on production : an home folder with a child registered to school. 
     * if the home folder issue an home folder modification request then the child reappears
     * in the list of subjects authorized to issue a school registration request.
     * 
     * TODO - org.hibernate.StaleObjectStateException occur on iHomeFolderModificationRequestService.modify()
     */
    public void _testSchoolRegistrationsSideEffect()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolderWithRequest();

        Long requestId = cb.getRequestId();
        proposedLogin = cb.getLogin();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(requestId, RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(requestId, RequestState.VALIDATED, null);

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();
        assertNotNull(homeFolderId);

        // register a child to school

        // get a school for our school and canteen registrations
        List<School> schools = schoolService.getAll();
        if (schools == null || schools.isEmpty())
            fail("No school created in the system, can't go further");
        School school = schools.get(0);

        // fill the child with the most we can
        child1.setBirthPostalCode("93240");
        child1.setBirthCity("Livry-Gargan");
        child1.setSex(SexType.MALE);

        SchoolRegistrationRequest srr = new SchoolRegistrationRequest();
        srr.setCurrentSchoolName("Ecolde des Yarglas");
        srr.setSection(SectionType.CP);
        srr.setUrgencyPhone("0102030405");
        srr.setSchool(school);
        srr.setSubjectId(child1.getId());
        srr.setRequesterId(SecurityContext.getCurrentUserId());

        Long srrId = requestWorkflowService.create(srr, null, null, null);

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.updateRequestState(srrId, RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(srrId, RequestState.VALIDATED, null);

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        RequestType requestType = 
            requestTypeService.getRequestTypeByLabel(schoolRegistrationRequestService.getLabel());
        Set<Long> authorizedSchoolRegistrations =
            requestWorkflowService.getAuthorizedSubjects(requestType, homeFolderId).keySet();
        assertEquals(1, authorizedSchoolRegistrations.size());

        // create the home folder modification request
        homeFolder = homeFolderService.getById(homeFolderId);
        homeFolderResponsible = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        HomeFolderModificationRequest hfmr = new HomeFolderModificationRequest();

        List<Adult> adultSet = new ArrayList<Adult>();
        adultSet.add(homeFolderResponsible);
        adultSet.add(homeFolderWoman);
        adultSet.add(homeFolderUncle);
        List<Child> childSet = new ArrayList<Child>();
        childSet.add(child1);
        childSet.add(child2);
        Address newAddress =
            BusinessObjectsFactory.gimmeAddress("1","Rue du centre", "Drancy", "93700");

        requestWorkflowService.createAccountModificationRequest(hfmr, adultSet, childSet, 
                null, newAddress, null, null);

        continueWithNewTransaction();

        authorizedSchoolRegistrations =
            requestWorkflowService.getAuthorizedSubjects(requestType, homeFolderId).keySet();
        assertEquals(1, authorizedSchoolRegistrations.size());

        // that's ok, cancel the home folder modification request
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        requestWorkflowService.delete(srrId);
    }
}
