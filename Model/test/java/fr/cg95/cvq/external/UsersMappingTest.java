package fr.cg95.cvq.external;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.request.technical.TechnicalInterventionRequestDocument;

public class UsersMappingTest extends ExternalServiceTestCase {

    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";

    @Override
    public void onTearDown() throws Exception {
        for (RequestExternalAction trace :
            requestExternalActionService.getTraces(new HashSet<Critere>(), null, null, 0, 0)) {
            HibernateUtil.getSession().delete(trace);
        }
        continueWithNewTransaction();
        HomeFolderMapping esimFromDb = 
            externalHomeFolderService.getHomeFolderMapping(EXTERNAL_SERVICE_LABEL, (Long) null);
        assertNull(esimFromDb);        
        assertEquals(0, requestExternalActionService.getTracesCount(new HashSet<Critere>()).longValue());
        super.onTearDown();
    }

    @Test
    public void testIdentifiersIntroduction() throws CvqException {
                
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(tirLabel);
        esb.setRequestTypes(requestTypes);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = 
            context.mock(IExternalProviderService.class);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf(mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)), with(localAuthorityName));
            oneOf(mockExternalService).checkExternalReferential(with(any(TechnicalInterventionRequestDocument.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            oneOf(mockExternalService).handlesTraces();
            oneOf(mockExternalService)
                .sendRequest(with(AllOf.<TechnicalInterventionRequestDocument>allOf(
                        HasInnerProperty.<TechnicalInterventionRequestDocument>hasProperty("homeFolder.externalId"),
                        HasInnerProperty.<TechnicalInterventionRequestDocument>hasProperty("homeFolder.externalCapDematId"))));
            allowing(mockExternalService).handlesTraces();
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
        externalHomeFolderService.deleteHomeFolderMappings(EXTERNAL_SERVICE_LABEL, fake.id);
    }

    @Test
    public void testSetExternalId() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);

        continueWithNewTransaction();
        
        externalHomeFolderService.setExternalId(fakeExternalService.getLabel(), fake.id,
                fake.responsibleId, "external ID");
        
        continueWithNewTransaction();
        
        HomeFolderMapping esimFromDb =
            externalHomeFolderService.getHomeFolderMapping(fakeExternalService.getLabel(), fake.id);
        assertNotNull(esimFromDb);
        assertNotNull(esimFromDb.getIndividualsMappings());
        List<IndividualMapping> esimIndividuals = esimFromDb.getIndividualsMappings();
        assertEquals(4, esimIndividuals.size());
        IndividualMapping esimIndividual = null;
        for (IndividualMapping m : esimIndividuals) {
            if (m.getIndividualId().equals(fake.responsibleId))
                esimIndividual = m;
        }
        assertNotNull(esimIndividual);
        assertEquals("external ID", esimIndividual.getExternalId());

        externalHomeFolderService.deleteHomeFolderMappings(fakeExternalService.getLabel(), fake.id);
    }
}
