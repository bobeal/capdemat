package fr.cg95.cvq.testtool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.business.users.UserSecurityProfile;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.users.IMeansOfContactService;
import fr.cg95.cvq.service.users.IUserNotificationService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.IUserSecurityService;
import fr.cg95.cvq.service.users.IUserService;
import fr.cg95.cvq.service.users.IUserWorkflowService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

@ContextConfiguration({ "/applicationContext.xml",  "/applicationContext-deployment.xml",
    "/applicationContext-test.xml", "/applicationContext-admin.xml",
    "classpath*:pluginContext.xml", "classpath:/localAuthority-dummy.xml"})
public class ServiceTestCase extends AbstractJUnit4SpringContextTests {

    protected class FakeHomeFolder {
        public Long id;
        public Long addressId;
        public Long responsibleId;
        public Long womanId;
        public Long uncleId;
        public Long childId;

        public FakeHomeFolder()
            throws CvqException {
            this(true);
        }

        public FakeHomeFolder(boolean full)
            throws CvqException {
            // keep current context to reset it after home folder creation
            String currentContext = SecurityContext.getCurrentContext();
            Agent currentAgent = SecurityContext.getCurrentAgent();
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
            Adult homeFolderResponsible = BusinessObjectsFactory.gimmeAdult(
                TitleType.MISTER, "lastName", "firstName", BusinessObjectsFactory.gimmeAddress("12","Rue d'Aligre", "Paris", "75012"), FamilyStatusType.SINGLE);
            homeFolderResponsible.setPassword("toto");
            userWorkflowService.create(homeFolderResponsible, false);
            SecurityContext.setCurrentEcitizen(homeFolderResponsible);
            id = homeFolderResponsible.getHomeFolder().getId();
            responsibleId = homeFolderResponsible.getId();
            addressId = homeFolderResponsible.getHomeFolder().getAddress().getId();
            Adult homeFolderWoman = BusinessObjectsFactory.gimmeAdult(
                TitleType.MADAM, "LASTNAME", "wife", null, FamilyStatusType.MARRIED);
            userWorkflowService.add(homeFolderResponsible.getHomeFolder(), homeFolderWoman, false);
            womanId = homeFolderWoman.getId();
            if (full) {
                Adult homeFolderUncle = BusinessObjectsFactory.gimmeAdult(
                    TitleType.MISTER, "LASTNAME", "uncle", null, FamilyStatusType.SINGLE);
                userWorkflowService.add(homeFolderResponsible.getHomeFolder(), homeFolderUncle, false);
                Child child = BusinessObjectsFactory.gimmeChild("LASTNAME", "childone");
                child.setSex(SexType.MALE);
                userWorkflowService.add(homeFolderResponsible.getHomeFolder(), child);
                userWorkflowService.link(homeFolderResponsible, child, Collections.singleton(RoleType.CLR_FATHER));
                userWorkflowService.link(homeFolderWoman, child, Collections.singleton(RoleType.CLR_MOTHER));
                userWorkflowService.link(homeFolderUncle, child, Collections.singleton(RoleType.CLR_TUTOR));
                uncleId = homeFolderUncle.getId();
                childId = child.getId();
            }
            continueWithNewTransaction();
            if (currentContext != null)
                SecurityContext.setCurrentContext(currentContext);
            if (currentAgent != null)
                SecurityContext.setCurrentAgent(currentAgent);
        }
    }

    // some tests data that can (have to) be used inside tests
    public String localAuthorityName = "dummy";
    public String agentNameWithCategoriesRoles = "agent";
    public String agentNameWithManageRoles = "manager";
    public String agentNameWithSiteRoles = "admin";

    @Autowired
    protected IAuthenticationService authenticationService;
    @Autowired
    protected IMeansOfContactService meansOfContactService;
    @Autowired
    protected IUserService userService;
    @Autowired
    protected IUserNotificationService userNotificationService;
    @Autowired
    protected IUserSearchService userSearchService;
    @Autowired
    protected IUserWorkflowService userWorkflowService;

    // authority related services
    @Autowired
    protected ISchoolService schoolService;
    @Autowired
    protected IRecreationCenterService recreationCenterService;
    @Autowired
    protected IAgentService agentService;
    @Autowired
    protected ILocalAuthorityRegistry localAuthorityRegistry;
    @Autowired
    protected IUserSecurityService userSecurityService;

    @Resource(name="sessionFactory_dummy")
    private SessionFactory sessionFactory;

    protected FakeHomeFolder fake;

    @Before
    public void onSetUp() throws Exception {
        startTransaction();
        IGenericDAO genericDAO = getApplicationBean("genericDAO");
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        try {
            SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
            logger.debug("onSetUp() fixture data already created");
            rollbackTransaction();
            startTransaction();
        } catch (CvqObjectNotFoundException confe) {
            Agent admin = new Agent();
            admin.setActive(Boolean.TRUE);
            admin.setLogin(agentNameWithSiteRoles);
            SiteRoles siteRoles = new SiteRoles(SiteProfile.ADMIN, admin);
            Set<SiteRoles> siteRolesSet = new HashSet<SiteRoles>();
            siteRolesSet.add(siteRoles);
            admin.setSitesRoles(siteRolesSet);
            genericDAO.create(admin);
            continueWithNewTransaction();
            SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
            bootstrapAgent(agentNameWithCategoriesRoles, SiteProfile.AGENT);
            bootstrapAgent(agentNameWithManageRoles, SiteProfile.AGENT);
            genericDAO.create(BusinessObjectsFactory.gimmeSchool("École Jean Jaurès"));
            genericDAO.create(BusinessObjectsFactory.gimmeRecreationCenter("Centre de loisirs Louise Michel"));
            continueWithNewTransaction();
        }
        fake = new FakeHomeFolder();
        commitTransaction();
        startTransaction();
    }

    private void bootstrapAgent(String agentName, SiteProfile siteProfile) throws CvqException {

        Agent agent = new Agent();
        agent.setActive(Boolean.TRUE);
        agent.setLogin(agentName);

        SiteRoles siteRoles = new SiteRoles(siteProfile, agent);
        Set<SiteRoles> siteRolesSet = new HashSet<SiteRoles>();
        siteRolesSet.add(siteRoles);
        agent.setSitesRoles(siteRolesSet);
        agentService.create(agent);
        userSecurityService.allow(agent.getId(), UserSecurityProfile.MANAGE);
    }

    protected void startTransaction() throws CvqException {
        try {
            HibernateUtil.setSessionFactory(sessionFactory);
            HibernateUtil.beginTransaction();
        } catch (Exception e) {
            logger.error("got exception while starting new tx");
            e.printStackTrace();
            throw new CvqException("");
        }
    }

    protected void commitTransaction() {
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();
    }
    
    protected void rollbackTransaction() throws CvqException {
        try {
            HibernateUtil.rollbackTransaction();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            throw new CvqException("");
        }         
    }
    
    protected void continueWithNewTransaction() {
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();
        HibernateUtil.beginTransaction();
    }
    
    @After
    public void onTearDown() throws Exception {

        try {
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            userWorkflowService.delete(fake.id);
            try {
                userSearchService.getHomeFolderById(fake.id);
                fail("should have thrown an exception");
            } catch (CvqObjectNotFoundException confe) {
                // ok, that was expected
            }

            continueWithNewTransaction();

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            // ensure all requests have been deleted after each test
            assertEquals(0, userSearchService.get(new HashSet<Critere>(), null, true).size());

            rollbackTransaction();
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error during tear down : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    protected <T> T getApplicationBean(String beanName) {
        return (T)  applicationContext.getBean(beanName);
    }

    /**
     * Returns a file descriptor to a file that resides in the test
     * hierarchy. The base directory is taken from the
     * "test.resource.dir" system property.
     */
    protected static File getResourceFile(String path) {
        return new File(System.getProperty("test.resource.dir"), path);
    }

    /**
     * Returns a file descriptor to a file that resides in the test
     * data hierarchy. The base directory is taken from the
     * "test.data.dir" system property.
     */
    protected static File getTestDataFile(String path) {
        return new File(System.getProperty("test.data.dir"), path);
    }
}
