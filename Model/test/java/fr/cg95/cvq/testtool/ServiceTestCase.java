package fr.cg95.cvq.testtool;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.service.authority.ILocalReferentialService;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.service.request.IMeansOfContactService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestStatisticsService;
import fr.cg95.cvq.service.request.ecitizen.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.ICardService;
import fr.cg95.cvq.service.users.ICertificateService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.mail.IMailService;

public class ServiceTestCase
    extends MyAbstractDependencyInjectionSpringContextTests {

    protected static Logger logger = Logger.getLogger(ServiceTestCase.class);

    // some tests data that can (have to) be used inside tests
    public String localAuthorityName = "dummy";
    public String agentNameWithCategoriesRoles = "demo";
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
    protected Long voCardRequestId;
    protected Map<Long, Long> homeFolderVoCardRequestIds = new HashMap<Long, Long>();

    protected static IIndividualService iIndividualService;
    protected static IHomeFolderService iHomeFolderService;
    protected static IAuthenticationService iAuthenticationService;
    protected static IDocumentService iDocumentService;
    protected static IDocumentTypeService iDocumentTypeService;
    protected static IAdultService iAdultService;
    protected static IChildService iChildService;
    protected static ICardService iCardService;
    protected static ICertificateService iCertificateService;
    protected static IPaymentService iPaymentService;

    protected static ICategoryService iCategoryService;
    protected static ISchoolService schoolService;
    protected static IRecreationCenterService recreationCenterService;
    protected static IAgentService iAgentService;
    protected static ILocalReferentialService localReferentialService;
    protected static IPlaceReservationService placeReservationService;
    
    protected static IRequestServiceRegistry iRequestServiceRegistry;
    protected static IRequestService iRequestService;
    protected static IHomeFolderModificationRequestService iHomeFolderModificationRequestService;
    protected static IRequestStatisticsService iRequestStatisticsService;
    protected static IVoCardRequestService iVoCardRequestService;
    
    protected static IPaymentProviderService iFakePaymentProviderService;
    
    protected static IMeansOfContactService iMeansOfContactService;

    protected static IMailService iMailService;
    
    private static SessionFactory sessionFactory;
    
    private static Boolean isInitialized = Boolean.FALSE;

    protected String[] getConfigLocations() {
        return new String[] { "/applicationContext.xml",
                              "/applicationContext-deployment.xml",
                              "/applicationContext-test.xml",
                              "/applicationContext-admin.xml",
                              "classpath*:pluginContext.xml",
                              "classpath:/localAuthority-dummy.xml"};
    }

    protected void onSetUp() throws Exception {
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        
        synchronized(isInitialized) {
            if (!isInitialized.booleanValue()) {
                // as beans are autowired by type with spring test framework,
                // we have to set some manually because there is more than one bean
                // with their respective type
                iRequestService = (IRequestService) cac.getBean("defaultRequestService");

                iFakePaymentProviderService = 
                    (IPaymentProviderService) cac.getBean("fakePaymentProviderService");

                iIndividualService = (IIndividualService) cac.getBean("individualService");
                iAdultService = (IAdultService) cac.getBean("adultService");
                iChildService = (IChildService) cac.getBean("childService");
                
                iMeansOfContactService = 
                    (IMeansOfContactService) cac.getBean(IMeansOfContactService.SERVICE_NAME);

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
                SiteRoles siteRoles = new SiteRoles();
                siteRoles.setAgent(admin);
                siteRoles.setProfile(SiteProfile.ADMIN);
                Set<SiteRoles> siteRolesSet = new HashSet<SiteRoles>();
                siteRolesSet.add(siteRoles);
                admin.setSitesRoles(siteRolesSet);
                genericDAO.create(admin);

                SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

                Category category = new Category();
                category.setName("General");
                List<RequestType> requestTypesSet = iRequestService.getAllRequestTypes();
                for (RequestType requestType : requestTypesSet) {
                    requestType.setCategory(category);
                    genericDAO.update(requestType);
                }
                category.setRequestTypes(new HashSet<RequestType>(requestTypesSet));
                genericDAO.create(category);
                                
                Agent agent = bootstrapAgent(agentNameWithCategoriesRoles, category,
                        CategoryProfile.READ_WRITE);
                genericDAO.create(agent);
                
                Agent manager = bootstrapAgent(agentNameWithManageRoles, category, 
                        CategoryProfile.MANAGER);
                genericDAO.create(manager);
                
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

    private Agent bootstrapAgent(String agentName, Category category, CategoryProfile categoryProfile) {

        Agent agent = new Agent();
        agent.setActive(Boolean.TRUE);
        agent.setLogin(agentName);

        SiteRoles siteRoles = new SiteRoles();
        siteRoles.setAgent(agent);
        siteRoles.setProfile(SiteProfile.AGENT);
        Set<SiteRoles> siteRolesSet = new HashSet<SiteRoles>();
        siteRolesSet.add(siteRoles);
        agent.setSitesRoles(siteRolesSet);

        CategoryRoles categoryRoles = new CategoryRoles();
        categoryRoles.setAgent(agent);
        categoryRoles.setCategory(category);
        categoryRoles.setProfile(categoryProfile);
        Set<CategoryRoles> categoryRolesSet = new HashSet<CategoryRoles>();
        categoryRolesSet.add(categoryRoles);
        agent.setCategoriesRoles(categoryRolesSet);
        
        return agent;
    }

    protected void startTransaction() throws CvqException {
        try {
            HibernateUtil.setSessionFactory(sessionFactory);
            HibernateUtil.beginTransaction();
        } catch (Exception e) {
            logger.error("got exception while starting new tx");
            e.printStackTrace();
            throw new CvqException();
        }
    }

    protected void commitTransaction() throws CvqException {
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();
    }
    
    protected void rollbackTransaction() throws CvqException {
        try {
            HibernateUtil.rollbackTransaction();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            throw new CvqException();
        }         
    }
    
    protected void continueWithNewTransaction() throws CvqException {
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();
        HibernateUtil.beginTransaction();
    }
    
    protected void onTearDown() throws Exception {

        try {
            continueWithNewTransaction();
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
            // only delete for those who asked us for an home folder at the beginning of their tests
            for (Long homeFolderId : homeFolderVoCardRequestIds.keySet()) {
                iRequestService.delete(homeFolderVoCardRequestIds.get(homeFolderId));
                iHomeFolderService.delete(homeFolderId);
                try {
                    iHomeFolderService.getById(homeFolderId);
                    fail("should have thrown an exception");
                } catch (CvqObjectNotFoundException confe) {
                    // ok, that was expected
                }
            }

            voCardRequestId = null;
            homeFolderVoCardRequestIds.clear();

            continueWithNewTransaction();

            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            // to force re-association of agent within current session
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

            // ensure all requests have been deleted after each test
            assertEquals(0, iRequestService.get(new HashSet<Critere>(), null, null, -1, 0).size());
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
    
    public void setCategoryService(ICategoryService categoryService) {
        iCategoryService = categoryService;
    }

    public void setAgentService(IAgentService agentService) {
        iAgentService = agentService;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        iHomeFolderService = homeFolderService;
    }

    public void setDocumentService(IDocumentService documentService) {
        iDocumentService = documentService;
    }
    
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        iDocumentTypeService = documentTypeService;
    }
    
    public void setCardService(ICardService cardService) {
        iCardService = cardService;
    }

    public void setCertificateService(ICertificateService certificateService) {
        iCertificateService = certificateService;
    }

    public void setPaymentService(IPaymentService paymentService) {
        iPaymentService = paymentService;
    }
    
    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        iRequestServiceRegistry = requestServiceRegistry;
    }
    
    public void setRequestStatisticsService(IRequestStatisticsService requestStatisticsService) {
        iRequestStatisticsService = requestStatisticsService;
    }

    public void setVoCardRequestService(IVoCardRequestService voCardRequestService) {
        iVoCardRequestService = voCardRequestService;
    }

    public void setHomeFolderModificationRequestService(IHomeFolderModificationRequestService homeFolderModificationRequestService) {
        iHomeFolderModificationRequestService = homeFolderModificationRequestService;
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

    /**
     * Utility method used to easily get an home folder and individuals while running services
     * related tests
     */
    public CreationBean gimmeAnHomeFolder()
        throws CvqException {

        VoCardRequest request = new VoCardRequest();

        address = BusinessObjectsFactory.gimmeAdress("12","Rue d'Aligre", "Paris", "75012");

        homeFolderResponsible =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "responsible", address,
                    FamilyStatusType.MARRIED);
        iHomeFolderService.addHomeFolderRole(homeFolderResponsible, null, 
                RoleEnum.HOME_FOLDER_RESPONSIBLE);
        homeFolderResponsible.setPassword("toto");

        homeFolderWoman =
            BusinessObjectsFactory.gimmeAdult(TitleType.MADAM, "LASTNAME", "wife", address,
                    FamilyStatusType.MARRIED);
        homeFolderUncle =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "uncle", address,
                    FamilyStatusType.SINGLE);
        Set<Adult> adultSet = new HashSet<Adult>();
        adultSet.add(homeFolderResponsible);
        adultSet.add(homeFolderWoman);
        adultSet.add(homeFolderUncle);

        child1 = BusinessObjectsFactory.gimmeChild("LASTNAME", "childone");
        child1.setSex(SexType.MALE);
        iHomeFolderService.addIndividualRole(homeFolderResponsible, child1, RoleEnum.CLR_FATHER);
        iHomeFolderService.addIndividualRole(homeFolderWoman, child1, RoleEnum.CLR_MOTHER);
        iHomeFolderService.addIndividualRole(homeFolderUncle, child1, RoleEnum.CLR_TUTOR);
        
        child2 = BusinessObjectsFactory.gimmeChild("LASTNAME", "childtwo");
        child2.setSex(SexType.MALE);
        iHomeFolderService.addIndividualRole(homeFolderResponsible, child2, RoleEnum.CLR_FATHER);

        Set<Child> childSet = new HashSet<Child>();
        childSet.add(child1);
        childSet.add(child2);

        iVoCardRequestService.create(request, adultSet, childSet, address);

        CreationBean cb = new CreationBean();
        cb.setRequestId(request.getId());
        voCardRequestId = request.getId();
        cb.setHomeFolderId(request.getHomeFolderId());
        cb.setLogin(homeFolderResponsible.getLogin());
        
        homeFolderVoCardRequestIds.put(request.getHomeFolderId(), voCardRequestId);

        return cb;
    }
}
