package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.external.ExternalServiceIndividualMapping;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.request.ecitizen.VoCardRequestDocument;

/**
 * FIXME : dependency on request test case has to be fixed
 */
public class ExternalServiceIdentifierMappingTest extends ExternalServiceTestCase {

    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
    }

    @Override
    public void onTearDown() throws Exception {
        for (ExternalServiceTrace trace :
            externalService.getTraces(Collections.<Critere>emptySet(),
                null, null)) {
            HibernateUtil.getSession().delete(trace);
        }
        continueWithNewTransaction();
        ExternalServiceIdentifierMapping esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, (Long) null);
        assertNull(esimFromDb);        
        assertEquals(0, externalService.getTraces(Collections.<Critere>emptySet(), null, null).size());
        super.onTearDown();
    }

    public void testIdentifiersIntroduction() throws CvqException {
                
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = 
            context.mock(IExternalProviderService.class);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf(mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)));
            oneOf(mockExternalService).checkExternalReferential(with(any(VoCardRequestDocument.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            oneOf(mockExternalService).handlesTraces();
            oneOf(mockExternalService)
                .sendRequest(with(AllOf.<VoCardRequestDocument>allOf(
                        HasInnerProperty.<VoCardRequestDocument>hasProperty("homeFolder.externalId"),
                        HasInnerProperty.<VoCardRequestDocument>hasProperty("homeFolder.externalCapDematId"))));
            allowing(mockExternalService).handlesTraces();
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);

        CreationBean cb = gimmeAnHomeFolderWithRequest();
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

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Request request = requestSearchService.getById(cb.getRequestId());
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
        externalService.deleteIdentifierMappings(EXTERNAL_SERVICE_LABEL, cb.getHomeFolderId());
    }

    public void testSetExternalId() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        final CreationBean cb = gimmeAnHomeFolderWithRequest();
        registerFakeExternalService();
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        Request request = requestSearchService.getById(cb.getRequestId());
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        externalService.setExternalId(fakeExternalService.getLabel(), cb.getHomeFolderId(), 
                homeFolderResponsible.getId(), "external ID");
        
        continueWithNewTransaction();
        
        ExternalServiceIdentifierMapping esimFromDb =
            externalService.getIdentifierMapping(fakeExternalService.getLabel(), cb.getHomeFolderId());
        assertNotNull(esimFromDb);
        assertNotNull(esimFromDb.getIndividualsMappings());
        Set<ExternalServiceIndividualMapping> esimIndividuals = esimFromDb.getIndividualsMappings();
        assertEquals(5, esimIndividuals.size());
        ExternalServiceIndividualMapping esimIndividual = null;
        for (ExternalServiceIndividualMapping m : esimIndividuals) {
            if (m.getIndividualId().equals(iHomeFolderService.getHomeFolderResponsible(cb.getHomeFolderId()).getId()))
                esimIndividual = m;
        }
        assertNotNull(esimIndividual);
        assertEquals("external ID", esimIndividual.getExternalId());
        
        unregisterFakeExternalService();
        externalService.deleteIdentifierMappings(fakeExternalService.getLabel(), cb.getHomeFolderId());
    }
}
