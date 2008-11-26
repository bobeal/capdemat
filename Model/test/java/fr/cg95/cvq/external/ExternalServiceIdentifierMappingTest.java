package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.external.ExternalServiceIndividualMapping;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class ExternalServiceIdentifierMappingTest extends ServiceTestCase {

    private IExternalService externalService;
    
    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";
    
    public void onSetUp() throws Exception {
        super.onSetUp();
        externalService = (IExternalService) getBean("externalService");
    }
    
    public void testAdd() throws CvqException {
    
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolder();

        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());

        // test the creation 
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        ExternalServiceIdentifierMapping esim = new ExternalServiceIdentifierMapping();
        esim.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        esim.setExternalId("External Id 1");
        esim.setHomeFolderId(homeFolder.getId());

        externalService.addHomeFolderMapping(esim);
        
        continueWithNewTransaction();
        
        ExternalServiceIdentifierMapping esimFromDb =
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esimFromDb);
        assertEquals(EXTERNAL_SERVICE_LABEL, esimFromDb.getExternalServiceLabel());
        assertEquals("External Id 1", esimFromDb.getExternalId());
        assertEquals(homeFolder.getId(), esimFromDb.getHomeFolderId());
        
        // test the business keys checks are correctly done
        
        externalService.addHomeFolderMapping(EXTERNAL_SERVICE_LABEL, 
                homeFolder.getId(), "New External Id 1");
        
        continueWithNewTransaction();
        
        esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esimFromDb);
        assertEquals(EXTERNAL_SERVICE_LABEL, esimFromDb.getExternalServiceLabel());
        assertEquals("New External Id 1", esimFromDb.getExternalId());
        assertEquals(homeFolder.getId(), esimFromDb.getHomeFolderId());
        assertNotNull(esimFromDb.getExternalCapDematId());
        
        // test the addition of individuals mappings
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Adult homeFolderResponsible = 
            iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        externalService.addIndividualMapping(EXTERNAL_SERVICE_LABEL, 
                homeFolder.getId(), homeFolderResponsible.getId(), 
                "External Individual Id 1");
        
        continueWithNewTransaction();
        
        esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esimFromDb);
        assertNotNull(esimFromDb.getIndividualsMappings());
        Set<ExternalServiceIndividualMapping> esimIndividuals = esimFromDb.getIndividualsMappings();
        assertEquals(1, esimIndividuals.size());
        ExternalServiceIndividualMapping esimIndividual = esimIndividuals.iterator().next();
        assertEquals(homeFolderResponsible.getId(), 
                esimIndividual.getIndividualId());
        assertEquals("External Individual Id 1", esimIndividual.getExternalId());
        assertNotNull(esimIndividual.getExternalCapDematId());
        
        // test the override of individuals
        
        externalService.addIndividualMapping(EXTERNAL_SERVICE_LABEL, 
                homeFolder.getId(), homeFolderResponsible.getId(), "External Individual Id 2");
        
        continueWithNewTransaction();
        
        esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esimFromDb);
        assertNotNull(esimFromDb.getIndividualsMappings());
        assertEquals(1, esimFromDb.getIndividualsMappings().size());
        
        // delete our traces
        
        externalService.deleteHomeFolderMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        externalService.deleteTraces(EXTERNAL_SERVICE_LABEL);
        
        continueWithNewTransaction();
        
        esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNull(esimFromDb);
        assertEquals(0, externalService.getTraces(null, null, null, null, null).size());
    }
    
    public void testGet() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());

        // create a mapping and test the retrieval
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        ExternalServiceIdentifierMapping esim = new ExternalServiceIdentifierMapping();
        esim.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        esim.setExternalId("External Id 1");
        esim.setHomeFolderId(homeFolder.getId());

        externalService.addHomeFolderMapping(esim);
        
        continueWithNewTransaction();
        
        ExternalServiceIdentifierMapping esimFromDb =
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esimFromDb);
        Set<ExternalServiceIdentifierMapping> esimSet =
            externalService.getIdentifiersMappings(EXTERNAL_SERVICE_LABEL);
        assertNotNull(esimSet);
        assertEquals(1, esimSet.size());
        
        SecurityContext.resetCurrentSite();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        cb = gimmeAnHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        esim = new ExternalServiceIdentifierMapping();
        esim.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        esim.setExternalId("External Id 2");
        esim.setHomeFolderId(homeFolder.getId());

        externalService.addHomeFolderMapping(esim);
        
        continueWithNewTransaction();
        
        esimSet = externalService.getIdentifiersMappings(EXTERNAL_SERVICE_LABEL);
        assertNotNull(esimSet);
        assertEquals(2, esimSet.size());
        
        esim = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNotNull(esim);
        esim =
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, "External Id 2");
        assertNotNull(esim);

        // delete our traces
        
        externalService.deleteHomeFoldersMappings(EXTERNAL_SERVICE_LABEL);
        externalService.deleteTraces(EXTERNAL_SERVICE_LABEL);
        
        continueWithNewTransaction();
        
        esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, homeFolder.getId());
        assertNull(esimFromDb);        
        assertEquals(0, externalService.getTraces(null, null, null, null, null).size());
    }
    
    public void testIdentifiersIntroduction() throws CvqException {
                
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IVoCardRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = context.mock(IExternalProviderService.class);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf (mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            oneOf(mockExternalService)
                .sendRequest(with(AllOf.<VoCardRequest>allOf(
                        HasInnerProperty.<VoCardRequest>hasProperty("homeFolder.externalId"),
                        HasInnerProperty.<VoCardRequest>hasProperty("homeFolder.externalCapDematId"))));
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);

        CreationBean cb = gimmeAnHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());

        // create a mapping and test the retrieval
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        ExternalServiceIdentifierMapping esim = new ExternalServiceIdentifierMapping();
        esim.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        esim.setExternalId("External Id 1");
        esim.setHomeFolderId(homeFolder.getId());

        externalService.addHomeFolderMapping(esim);
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        externalService.sendRequest(iRequestService.getById(cb.getRequestId()));
        
        context.assertIsSatisfied();
        
        externalService.deleteTraces(EXTERNAL_SERVICE_LABEL);
        lacb.unregisterExternalService(mockExternalService);

        continueWithNewTransaction();

        assertEquals(0, externalService.getTraces(null, null, null, null, null).size());
    }
}
