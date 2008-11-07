package fr.cg95.cvq.service.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.LegalResponsibleRole;
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
            Set remainingEntries =
                iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
            Assert.assertEquals(0, remainingEntries.size());
        } catch (Exception e) {
            // just catch and let tear down go up to his parent
        }

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
        Assert.assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        // create the home folder modification request
        homeFolder = iHomeFolderService.getById(homeFolderId);
        hfmr = iHomeFolderModificationRequestService.create(homeFolderId,
                homeFolder.getHomeFolderResponsible().getId());

        // prepare objects for modifications
        adress = homeFolder.getAdress();
        Set individuals = homeFolder.getIndividuals();
        Iterator individualsIt = individuals.iterator();
        adults = new HashSet<Adult>();
        children = new HashSet<Child>();
        while (individualsIt.hasNext()) {
            Object object = individualsIt.next();
            if (object instanceof Child)
                children.add((Child) object);
            else
                adults.add((Adult) object);
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
                                               "Drancy",
                                               "93700");
        homeFolderUncle.setAdress(newAdress);

        Adult testReloadedWoman = iAdultService.getById(homeFolderWoman.getId());
        testReloadedWoman.setFirstName2("Angélique");
        Set<Adult> newAdults = new HashSet<Adult>();
        newAdults.add(homeFolderUncle);
        newAdults.add(homeFolderResponsible);
        newAdults.add(testReloadedWoman);

        // ... and on the adress
        adress.setPostalCode("75013");
        adress.setCity("Paris Ville Lumière");

        iHomeFolderModificationRequestService.modify(hfmr,
                                                     newAdults, children,
                                                     adress);
        
    }

    public void testSimpleModificationsValidated()
        throws CvqException {

        prepareSimpleModifications();

        continueWithNewTransaction();
        
        Set entries =
            iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            logger.debug("got history entry : " + it.next());
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

        iHomeFolderModificationRequestService.getOriginalHomeFolder(hfmr.getId());

        continueWithNewTransaction();
        
        // validate request and check we did not loose any information
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
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
    }

    public void testSimpleModificationsCancelled()
        throws CvqException {

        prepareSimpleModifications();

        continueWithNewTransaction();
        
        iHomeFolderModificationRequestService.getOriginalHomeFolder(hfmr.getId());

        // cancel request and check we got back to the original state
        // (be an agent to perform this state change)
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        HomeFolderModificationRequest hfmrFromDb =
            (HomeFolderModificationRequest) iHomeFolderModificationRequestService.getById(hfmrId);
        homeFolder = iHomeFolderService.getById(hfmrFromDb.getHomeFolderId());
        adress = homeFolder.getAdress();
        Assert.assertEquals(adress.getPostalCode(), "75012");
        Assert.assertEquals(adress.getCity(), "Paris".toUpperCase());
        Set individuals = homeFolder.getIndividuals();
        Iterator individualsIt = individuals.iterator();
        while (individualsIt.hasNext()) {
            Individual individual = (Individual) individualsIt.next();
            if (individual.getId().equals(homeFolderUncle.getId())) {
                Assert.assertEquals(individual.getLastName(), "LASTNAME");
                Assert.assertTrue(individual.getFirstName().startsWith("uncle"));
            }
        }
    }

    private void prepareChildAdultAddWithClr()
        throws CvqException {

        hfmrId = createModificationRequest();

        newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER,"adult","new",null, FamilyStatusType.SINGLE);
        adults.add(newAdult);

        newChild =
            BusinessObjectsFactory.gimmeChild("child", "new", homeFolderResponsible, null, newAdult);
        children.add(newChild);

        iHomeFolderModificationRequestService.modify(hfmr,
                                                     adults, children,
                                                     adress);
    }

    public void testChildAdultAddWithClrValidated()
        throws CvqException {

        prepareChildAdultAddWithClr();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
    }

    public void testChildAdultAddWithClrCancelled()
        throws CvqException {

        prepareChildAdultAddWithClr();

        continueWithNewTransaction();

        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
    }

    private void prepareChildAdultAddWithClrOutOfFolder()
        throws CvqException {

        hfmrId = createModificationRequest();
        Assert.assertNotNull(homeFolder);

        newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "adult", "new", null, 
                FamilyStatusType.SINGLE);

        newChild = BusinessObjectsFactory.gimmeChild("child", "new", homeFolderResponsible, null,
                newAdult);
        children.add(newChild);
        Assert.assertNotNull(homeFolder);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testChildAdultAddWithClrOutOfFolderValidated()
        throws CvqException {

        prepareChildAdultAddWithClrOutOfFolder();
        Assert.assertNotNull(homeFolder);

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

        // check entries have been deleted from history table
        Set remainingEntries =
            iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
        Assert.assertEquals(remainingEntries.size(), 0);

        // modify new child to remove its CLR that is not from the home folder
        Set newChildClrSet = newChild.getLegalResponsibles();
        Iterator newChildClrSetIt = newChildClrSet.iterator();
        ChildLegalResponsible clrToRemove = null;
        while (newChildClrSetIt.hasNext()) {
            ChildLegalResponsible clr =
                (ChildLegalResponsible) newChildClrSetIt.next();
            if (clr.getLegalResponsible().equals(newAdult))
                clrToRemove = clr;
        }
        newChildClrSet.remove(clrToRemove);
        Assert.assertNotNull(homeFolder);
        
        continueWithNewTransaction();
        
        hfmr = iHomeFolderModificationRequestService.create(homeFolder.getId(),
                homeFolder.getHomeFolderResponsible().getId());
        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);

        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
    }

    public void testChildAdultAddWithClrOutOfFolderCancelled()
        throws CvqException {

        prepareChildAdultAddWithClrOutOfFolder();
        Assert.assertNotNull(homeFolder);

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

        // check entries have been deleted from history table
        Set remainingEntries =
            iHomeFolderModificationRequestService.getHistoryEntries(hfmr.getId());
        Assert.assertEquals(remainingEntries.size(), 0);

        // modify new child to remove its CLR that is not from the home folder
        Set newChildClrSet = newChild.getLegalResponsibles();
        Iterator newChildClrSetIt = newChildClrSet.iterator();
        ChildLegalResponsible clrToRemove = null;
        while (newChildClrSetIt.hasNext()) {
            ChildLegalResponsible clr =
                (ChildLegalResponsible) newChildClrSetIt.next();
            if (clr.getLegalResponsible().equals(newAdult))
                clrToRemove = clr;
        }
        newChildClrSet.remove(clrToRemove);

        continueWithNewTransaction();
        
        hfmr = iHomeFolderModificationRequestService.create(homeFolder.getId(),
                homeFolder.getHomeFolderResponsible().getId());
        
        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
        
        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        // setComplete();
    }

    private void prepareChildrenAddRemove()
        throws CvqException {

        hfmrId = createModificationRequest();

        // remove a child, change legal responsibles for the remaining
        // and finally add a new child

        children.remove(child2);

        Set child1LR = child1.getLegalResponsibles();
        child1LR.clear();
        ChildLegalResponsible clr = new ChildLegalResponsible();
        clr.setRole(LegalResponsibleRole.TUTOR);
        clr.setLegalResponsible(homeFolderUncle);
        clr.setChild(child1);
        child1LR.add(clr);
        child1.setBirthCity("Paris");

        newChild =
            BusinessObjectsFactory.gimmeChild("Badiane", "XXXX", homeFolderResponsible, 
                    homeFolderWoman, homeFolderUncle);
        children.add(newChild);

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testChildrenAddRemoveValidated()
        throws Exception {

        prepareChildrenAddRemove();

        continueWithNewTransaction();

        // check modifications have been saved
        children = iHomeFolderService.getChildren(homeFolder.getId());
        Assert.assertEquals(children.size(), 2);
        for (Child child : children) {
            if (child.getFirstName().equals(child1.getFirstName())) {
                Assert.assertEquals(child.getBirthCity(), "Paris");
                Assert.assertEquals(child.getLegalResponsibles().size(), 1);
            } else if (child.getFirstName().equals(newChild.getFirstName())) {
                Assert.assertEquals(child.getLastName(), "Badiane");
                Assert.assertEquals(child.getLegalResponsibles().size(), 3);
            } else {
                fail("Don't know this child : " + child);
            }
        }

        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
        
        // become back an ecitizen to retrieve information
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);
        
        // check modifications are still saved
        children = iHomeFolderService.getChildren(homeFolder.getId());
        Assert.assertEquals(children.size(), 2);
        for (Child child : children) {
            if (child.getFirstName().equals(child1.getFirstName())) {
                Assert.assertEquals(child.getBirthCity(), "Paris");
                Assert.assertEquals(child.getLegalResponsibles().size(), 1);
            } else if (child.getFirstName().equals(newChild.getFirstName())) {
                Assert.assertEquals(child.getLastName(), "Badiane");
                Assert.assertEquals(child.getLegalResponsibles().size(), 3);
            } else {
                fail("Don't know this child : " + child);
            }
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
        Assert.assertEquals(children.size(), 2);
        for (Child child : children) {
            Assert.assertNotSame(child.getFirstName(), "XXXX");
            Assert.assertNotNull(child.getAdress());
            Assert.assertEquals(child.getLastName(), "LASTNAME");
            if (child.getFirstName().equals("childone")) {
                Assert.assertEquals(child.getLegalResponsibles().size(), 3);
            } else if (child.getFirstName().equals("childtwo")) {
                Assert.assertEquals(child.getLegalResponsibles().size(), 1);                
            }
        }
    }

    private void prepareSimpleAdultsAddRemove()
        throws CvqException {

        hfmrId = createModificationRequest();

        // remove an adult and add a new one

        adults.remove(homeFolderUncle);

        // removing this adult from children's legal responsibles
        // will be necessary be done in the Front Office since adult
        // will no longer be available for adding as a legal responsible
        Set lrSet = child1.getLegalResponsibles();
        Iterator lrSetIt = lrSet.iterator();
        while (lrSetIt.hasNext()) {
            ChildLegalResponsible clr =
                (ChildLegalResponsible) lrSetIt.next();
            if (clr.getLegalResponsible().equals(homeFolderUncle)) {
                lrSet.remove(clr);
                break;
            }
        }
        child1.setLegalResponsibles(lrSet);

        Address newAdress = BusinessObjectsFactory.gimmeAdress("1","Rue des Ecoles", "Paris", "75005");
        Adult newAdult = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER,"adult","new",null, FamilyStatusType.SINGLE);
        newAdult.setAdress(newAdress);
        newAdult.setPassword("toto");

        adults.add(newAdult);

        iHomeFolderModificationRequestService.modify(hfmr,
                                                     adults, children,
                                                     adress);
    }

    public void testSimpleAdultsAddRemoveValidated()
        throws CvqException {

        prepareSimpleAdultsAddRemove();

        continueWithNewTransaction();

        // check modifications have been saved
        Set allAdults = iHomeFolderService.getAdults(homeFolder.getId());
        Assert.assertEquals(allAdults.size(), 3);
        Assert.assertFalse(allAdults.contains(homeFolderUncle));

        continueWithNewTransaction();
        
        // be an agent to perform request state changes
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.complete(hfmr.getId());
        iHomeFolderModificationRequestService.validate(hfmr.getId());

        continueWithNewTransaction();
        
        // check removed adult has been deleted from DB
        try {
            iAdultService.getById(homeFolderUncle.getId());
            fail("Adult should have been removed");
        } catch (CvqObjectNotFoundException confe) {
            // that's what we expected
        }

        // check new adult and its specific adress are well stored
        allAdults = iHomeFolderService.getAdults(homeFolder.getId());
        Assert.assertEquals(allAdults.size(), 3);
        boolean foundNewAdult = false;
        Iterator allAdultsIt = allAdults.iterator();
        while (allAdultsIt.hasNext()) {
            Adult tempAdult = (Adult) allAdultsIt.next();
            logger.debug("got : " + tempAdult.getFirstName() + " "
                         + tempAdult.getLastName());
            if (tempAdult.getLastName().equals("adult")) {
                foundNewAdult = true;
                Assert.assertNotNull(tempAdult.getAdress());
                Assert.assertEquals(tempAdult.getAdress().getPostalCode(), "75005");
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
        SecurityContext.setCurrentSite(localAuthorityName,
                                        SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());

        continueWithNewTransaction();
        
        // check removed adult has been restored
        try {
            iAdultService.getById(homeFolderUncle.getId());
        } catch (CvqObjectNotFoundException confe) {
            fail("Adult should have been restored");
        }
    }

    private void prepareHomeFolderResponsibleChange()
        throws CvqException {

        hfmrId = createModificationRequest();

        Adult responsibleToRemove = homeFolder.getHomeFolderResponsible();
        adults.remove(responsibleToRemove);
        responsibleToRemove.removeHomeFolderResponsibleRole();
        responsibleToRemove.removeHomeFolderFinancialResponsibleRole();

        // removing this adult from children's legal responsibles
        // will be necessary done in the Front Office since adult
        // will no longer be available for adding as a legal responsible
        Set lrSet = child1.getLegalResponsibles();
        lrSet.clear();
        ChildLegalResponsible clr = new ChildLegalResponsible();
        clr.setRole(LegalResponsibleRole.FATHER);
        clr.setLegalResponsible(homeFolderUncle);
        clr.setChild(child1);
        lrSet.add(clr);
        clr = new ChildLegalResponsible();
        clr.setRole(LegalResponsibleRole.MOTHER);
        clr.setLegalResponsible(homeFolderWoman);
        clr.setChild(child1);
        lrSet.add(clr);

        lrSet = child2.getLegalResponsibles();
        lrSet.clear();
        clr = new ChildLegalResponsible();
        clr.setRole(LegalResponsibleRole.FATHER);
        clr.setLegalResponsible(homeFolderUncle);
        clr.setChild(child2);
        lrSet.add(clr);

        homeFolderUncle.addHomeFolderResponsibleRole();
        homeFolderUncle.setPassword("toto");

        iHomeFolderModificationRequestService.modify(hfmr, adults, children, adress);
    }

    public void testHomeFolderResponsibleChangeValidated()
        throws CvqException {

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
        Adult homeFolderResponsible = homeFolder.getHomeFolderResponsible();
        Assert.assertEquals(homeFolderResponsible.getLastName(), homeFolderUncle.getLastName());
        Assert.assertEquals(homeFolderResponsible.getFirstName(), homeFolderUncle.getFirstName());
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
        Adult homeFolderResponsible = homeFolder.getHomeFolderResponsible();
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
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

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

        Long srrId =
            iSchoolRegistrationRequestService.create(srr, homeFolderResponsible.getId(), null);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iSchoolRegistrationRequestService.complete(srrId);
        iSchoolRegistrationRequestService.validate(srrId);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(proposedLogin);

        Set authorizedSchoolRegistrations =
            iSchoolRegistrationRequestService.getAuthorizedSubjects(homeFolderId).keySet();
        Assert.assertEquals(authorizedSchoolRegistrations.size(), 1);

        // create the home folder modification request
        homeFolder = iHomeFolderService.getById(homeFolderId);
        hfmr = iHomeFolderModificationRequestService.create(homeFolderId,
                homeFolder.getHomeFolderResponsible().getId());
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
        Assert.assertEquals(authorizedSchoolRegistrations.size(), 1);
        
        // that's ok, cancel the home folder modification request
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        iHomeFolderModificationRequestService.cancel(hfmr.getId());
        continueWithNewTransaction();
    }
}
