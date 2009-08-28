package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;
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
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.request.ecitizen.VoCardRequestDocument;

public class ExternalServiceIdentifierMappingTest extends ServiceTestCase {

    private IExternalService externalService;

    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";
    private Long homeFolderId;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        externalService =
            super.<IExternalService>getApplicationBean("externalService");
        homeFolderId = null;
    }

    @Override
    public void onTearDown() throws Exception {
        if (homeFolderId != null) {
            HibernateUtil.getSession()
                .delete(externalService.getIdentifierMapping(
                    EXTERNAL_SERVICE_LABEL, homeFolderId));
        }
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
        requestTypes.add(IRequestService.VO_CARD_REGISTRATION_REQUEST);
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

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Request request = iRequestService.getById(cb.getRequestId());
        iRequestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        iRequestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);

        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
    }

    public void testSetExternalId() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        final CreationBean cb = gimmeAnHomeFolder();
        homeFolderId = cb.getHomeFolderId();
        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        IExternalProviderService externalProviderService = new IExternalProviderService() {
            public boolean supportsConsumptions() { return false; }
            public String sendRequest(XmlObject requestXml) throws CvqException {
                externalService.setExternalId(
                    getLabel(), cb.getHomeFolderId(),
                    iHomeFolderService.getHomeFolderResponsible(cb.getHomeFolderId()).getId(), "external ID");
                return null;
            }
            public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {}
            public Map<String, Object> loadExternalInformations(XmlObject requestXml) throws CvqException {
                return Collections.emptyMap();
            }
            public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {}
            public String helloWorld() throws CvqException { return ""; }
            public boolean handlesTraces() { return true; }
            public String getLabel() { return EXTERNAL_SERVICE_LABEL; }
            public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId,
                String externalHomeFolderId, String externalId) throws CvqException {
                return Collections.emptyMap();
            }
            public Map<Date, String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo)
                throws CvqException {
                return Collections.emptyMap();
            }
            public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
                String externalHomeFolderId, String externalId) throws CvqException {
                return Collections.emptyMap();
            }
            public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
                String cvqReference, String bankReference, Long homeFolderId,
                String externalHomeFolderId, String externalId, Date validationDate)
                throws CvqException {}
            public List<String> checkExternalReferential(XmlObject requestXml) {
                return Collections.emptyList();
            }
            public void checkConfiguration(ExternalServiceBean externalServiceBean)
                throws CvqConfigurationException {}
        };
        SecurityContext.getCurrentConfigurationBean().registerExternalService(externalProviderService, esb);
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        Request request = iRequestService.getById(cb.getRequestId());
        iRequestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        iRequestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        SecurityContext.getCurrentConfigurationBean().unregisterExternalService(externalProviderService);
        continueWithNewTransaction();
        ExternalServiceIdentifierMapping esimFromDb =
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, cb.getHomeFolderId());
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
    }
}
