package fr.cg95.cvq.testtool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.development.BusinessObjectsFactory;

@ContextConfiguration({ "/applicationContext.xml",  "/applicationContext-deployment.xml",
    "/applicationContext-test.xml", "/applicationContext-admin.xml",
    "classpath*:pluginContext.xml", "classpath:/localAuthority-dummy.xml"})
public class ServiceTestCase extends AbstractJUnit4SpringContextTests {

    // some tests data that can (have to) be used inside tests
    public String localAuthorityName = "dummy";
    public String agentNameWithCategoriesRoles = "agent";
    public String agentNameWithManageRoles = "manager";
    public String agentNameWithSiteRoles = "admin";

    // some ecitizen-related objects that can be reused in tests
    // they are created by the {@link #gimmeAnHomeFolder} method
    protected Child child1;
    protected Child child2;
    protected Adult homeFolderResponsible;
    protected Adult homeFolderWoman;
    protected Adult homeFolderUncle;
    protected Address address;
    protected List<Long> homeFolderIds = new ArrayList<Long>();

    // users related services
    @Resource(name="individualService")
    protected IIndividualService individualService;
    @Autowired
    protected IHomeFolderService homeFolderService;
    @Autowired
    protected IAuthenticationService authenticationService;

    // authority related services
    @Autowired
    protected ISchoolService schoolService;
    @Autowired
    protected IRecreationCenterService recreationCenterService;
    @Autowired
    protected IAgentService agentService;
    @Autowired
    protected ILocalAuthorityRegistry localAuthorityRegistry;

    @Resource(name="sessionFactory_dummy")
    private SessionFactory sessionFactory;
    
    protected static Boolean isInitialized = Boolean.FALSE;

    @Before
    public void onSetUp() throws Exception {
        
        synchronized(isInitialized) {
            if (!isInitialized.booleanValue()) {
                
                startTransaction();
                
                IGenericDAO genericDAO = getApplicationBean("genericDAO");
                
                SecurityContext.setCurrentSite(localAuthorityName, 
                        SecurityContext.BACK_OFFICE_CONTEXT);
                try {
                    SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
                    logger.debug("onSetUp() fixture data already created");
                    rollbackTransaction();
                    isInitialized = Boolean.TRUE;
                    startTransaction();
                    return;
                } catch (CvqObjectNotFoundException confe) {
                    // ok, so we have to add fixture data
                }

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

                commitTransaction();
                
                isInitialized = Boolean.TRUE;
            }
        }
        
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

            for (Long homeFolderId : homeFolderIds) {
                homeFolderService.delete(homeFolderId);
                try {
                    homeFolderService.getById(homeFolderId);
                    fail("should have thrown an exception");
                } catch (CvqObjectNotFoundException confe) {
                    // ok, that was expected
                }
            }

            homeFolderIds.clear();

            continueWithNewTransaction();

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            // ensure all requests have been deleted after each test
            assertEquals(0, individualService.get(new HashSet<Critere>(), null, true).size());

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

    public CreationBean gimmeMinimalHomeFolder() throws CvqException {
        
        // keep current context to reset it after home folder creation
        String currentContext = SecurityContext.getCurrentContext();
        Agent currentAgent = SecurityContext.getCurrentAgent();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        address = BusinessObjectsFactory.gimmeAdress("12","Rue d'Aligre", "Paris", "75012");
        homeFolderResponsible = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "lastName", 
                "firstName", address, FamilyStatusType.SINGLE);
        homeFolderResponsible.setAdress(address);
        homeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);
        
        HomeFolder homeFolder = homeFolderService.create(homeFolderResponsible);

        CreationBean cb = new CreationBean();
        cb.setHomeFolderId(homeFolder.getId());
        cb.setLogin(homeFolderResponsible.getLogin());

        homeFolderIds.add(homeFolder.getId());
        
        if (currentContext != null)
            SecurityContext.setCurrentContext(currentContext);
        if (currentAgent != null)
            SecurityContext.setCurrentAgent(currentAgent);
        
        continueWithNewTransaction();
        
        return cb;
    }
    
    public CreationBean gimmeAnHomeFolder() throws CvqException {

        // keep current context to reset it after home folder creation
        String currentContext = SecurityContext.getCurrentContext();
        Agent currentAgent = SecurityContext.getCurrentAgent();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        address = BusinessObjectsFactory.gimmeAdress("12","Rue d'Aligre", "Paris", "75012");
        
        homeFolderResponsible = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "lastName", 
                "firstName", address, FamilyStatusType.SINGLE);
        homeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);
        
        homeFolderWoman = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "lastName", 
                "woman", address, FamilyStatusType.SINGLE);
        List<Adult> adults = new ArrayList<Adult>();
        adults.add(homeFolderResponsible);
        adults.add(homeFolderWoman);
        HomeFolder homeFolder = homeFolderService.create(adults, null, new Address());

        CreationBean cb = new CreationBean();
        cb.setHomeFolderId(homeFolder.getId());
        cb.setLogin(homeFolderResponsible.getLogin());

        homeFolderIds.add(homeFolder.getId());
        
        if (currentContext != null)
            SecurityContext.setCurrentContext(currentContext);
        if (currentAgent != null)
            SecurityContext.setCurrentAgent(currentAgent);
        
        continueWithNewTransaction();
        
        return cb;
    }    
}
