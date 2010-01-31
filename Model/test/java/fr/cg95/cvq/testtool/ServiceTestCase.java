package fr.cg95.cvq.testtool;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
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
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.service.request.IDisplayGroupService;
import fr.cg95.cvq.service.request.IMeansOfContactService;
import fr.cg95.cvq.service.request.IPlaceReservationService;
import fr.cg95.cvq.service.request.IRequestActionService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestStatisticsService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.mail.IMailService;

public class ServiceTestCase
    extends AbstractDependencyInjectionSpringContextTests {

    protected static Logger logger = Logger.getLogger(ServiceTestCase.class);

    // some tests data that can (have to) be used inside tests
    public String localAuthorityName = "dummy";
    public String agentNameWithCategoriesRoles = "agent";
    public String agentNameWithManageRoles = "manager";
    public String agentNameWithSiteRoles = "admin";

    // some ecitizen-related objects that can be reused in tests
    // they are created by the {@link BusinessObjectsFactory#gimmeAnHomeFolder} method
    protected Child child1;
    protected Child child2;
    protected Adult homeFolderResponsible;
    protected Adult homeFolderWoman;
    protected Adult homeFolderUncle;
    protected Address address;
    protected List<Long> homeFolderIds = new ArrayList<Long>();

    // users related services
    protected static IIndividualService iIndividualService;
    protected static IHomeFolderService iHomeFolderService;
    protected static IAuthenticationService iAuthenticationService;

    // authority related services
    protected static ISchoolService schoolService;
    protected static IRecreationCenterService recreationCenterService;
    protected static IAgentService iAgentService;
    protected static ILocalReferentialService localReferentialService;
    protected static IPlaceReservationService placeReservationService;
    protected static ILocalAuthorityRegistry iLocalAuthorityRegistry;

    // requests related services
    protected static IRequestServiceRegistry iRequestServiceRegistry;
    protected static IRequestActionService iRequestActionService;
    protected static IRequestStatisticsService iRequestStatisticsService;
    protected static IMeansOfContactService iMeansOfContactService;
    protected static IDisplayGroupService iDisplayGroupService;
    
    protected static IMailService iMailService;
    
    private static SessionFactory sessionFactory;
    
    protected static Boolean isInitialized = Boolean.FALSE;

    @Override
    protected String[] getConfigLocations() {
        return new String[] { "/applicationContext.xml",
                              "/applicationContext-deployment.xml",
                              "/applicationContext-test.xml",
                              "/applicationContext-admin.xml",
                              "classpath*:pluginContext.xml",
                              "classpath:/localAuthority-dummy.xml"};
    }

    @Override
    protected void onSetUp() throws Exception {
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        
        synchronized(isInitialized) {
            if (!isInitialized.booleanValue()) {
                // as beans are autowired by type with spring test framework,
                // we have to set some manually because there is more than one bean
                // with their respective type

                iIndividualService = (IIndividualService) cac.getBean("individualService");
                
                iMeansOfContactService = 
                    (IMeansOfContactService) cac.getBean("meansOfContactService");

                sessionFactory = (SessionFactory) cac.getBean("sessionFactory_dummy");
                
                logger.debug("onSetUp() storing session factory " + sessionFactory);
                
                startTransaction();
                
                IGenericDAO genericDAO = (IGenericDAO) cac.getBean("genericDAO");
                
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
                
                School school = new School();
                school.setActive(Boolean.TRUE);
                school.setName("Ecole Jean Jaurès");
                genericDAO.create(school);
                
                RecreationCenter recreationCenter = new RecreationCenter();
                recreationCenter.setActive(Boolean.TRUE);
                recreationCenter.setName("Centre de loisirs Louise Michel");
                genericDAO.create(recreationCenter);

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
        iAgentService.create(agent);
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
    
    @Override
    protected void onTearDown() throws Exception {

        try {
            continueWithNewTransaction();
            
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            for (Long homeFolderId : homeFolderIds) {
                iHomeFolderService.delete(homeFolderId);
                try {
                    iHomeFolderService.getById(homeFolderId);
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
            assertEquals(0, iIndividualService.get(new HashSet<Critere>(), null, true).size());

            rollbackTransaction();
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error during tear down : " + e.getMessage());
        }
    }
    
    public Object getBean(final String beanName) throws Exception {
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        return cac.getBean(beanName);
    }

    @SuppressWarnings("unchecked")
    protected <T> T getApplicationBean(String beanName) {
        return (T)this.getApplicationContext().getBean(beanName);
    }

    public void setAuthenticationService(IAuthenticationService authenticationService) {
        iAuthenticationService = authenticationService;
    }

    public void setMailService(IMailService mailService) {
        iMailService = mailService;
    }

    public void setLocalReferentialService(ILocalReferentialService iLocalReferentialService) {
        localReferentialService = iLocalReferentialService;
    }
    
    public void setPlaceReservationService(IPlaceReservationService iPlaceReservationService) {
        placeReservationService = iPlaceReservationService;
    }
    
    public void setSchoolService(ISchoolService iSchoolService) {
        schoolService = iSchoolService;
    }
    
    public void setRecreationCenterService(IRecreationCenterService iRecreationCenterService) {
        recreationCenterService = iRecreationCenterService;
    }
    
    public void setAgentService(IAgentService agentService) {
        iAgentService = agentService;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        iHomeFolderService = homeFolderService;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        iRequestServiceRegistry = requestServiceRegistry;
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        iLocalAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestStatisticsService(IRequestStatisticsService requestStatisticsService) {
        iRequestStatisticsService = requestStatisticsService;
    }

    public void setRequestActionService(IRequestActionService requestActionService) {
        iRequestActionService = requestActionService;
    }

    public void setDisplayGroupService(IDisplayGroupService displayGroupService) {
        iDisplayGroupService = displayGroupService;
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
        iHomeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);
        
        HomeFolder homeFolder = iHomeFolderService.create(homeFolderResponsible);

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
        iHomeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);
        
        homeFolderWoman = BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "lastName", 
                "woman", address, FamilyStatusType.SINGLE);
        List<Adult> adults = new ArrayList<Adult>();
        adults.add(homeFolderResponsible);
        adults.add(homeFolderWoman);
        HomeFolder homeFolder = iHomeFolderService.create(adults, null, new Address());

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
