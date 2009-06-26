package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.ecitizen.VoCardRequestDocument;

public class ExternalServiceInteractionsTest extends ServiceTestCase {

    protected IExternalService externalService;
    
    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";
    
    public void onSetUp() throws Exception {
        super.onSetUp();
        externalService = (IExternalService) getBean("externalService");
    }
    
    public void onTearDown() throws Exception {
        
        externalService.deleteHomeFoldersMappings(EXTERNAL_SERVICE_LABEL);
        externalService.deleteTraces(EXTERNAL_SERVICE_LABEL);

        continueWithNewTransaction();

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        assertEquals(0, lacb.getExternalServices().size());

        ExternalServiceIdentifierMapping esimFromDb = 
            externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL, (Long) null);
        assertNull(esimFromDb);        
        assertEquals(0, externalService.getTraces((String) null, null, null, null, null).size());
        
        super.onTearDown();
    }
    
    public void testInteractions() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        final HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IVoCardRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        esb.setSupportAccountsByHomeFolder(true);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = context.mock(IExternalProviderService.class);
        
        final ExternalInvoiceItem eii = new ExternalInvoiceItem();
        eii.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        eii.setAmount(10.0);
        eii.setIssueDate(new Date());
        
        Set<PurchaseItem> purchaseItems = new HashSet<PurchaseItem>();
        purchaseItems.add(eii);
        final Payment payment = new Payment();
        payment.setPurchaseItems(purchaseItems);
        payment.setState(PaymentState.VALIDATED);
        payment.setHomeFolder(homeFolder);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf (mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            oneOf(mockExternalService).handlesTraces();
            oneOf(mockExternalService)
                .sendRequest(with(AllOf.<VoCardRequestDocument>allOf(
                        HasInnerProperty.<VoCardRequestDocument>hasProperty("homeFolder.externalId"),
                        HasInnerProperty.<VoCardRequestDocument>hasProperty("homeFolder.externalCapDematId"))));
            allowing(mockExternalService).handlesTraces();
            oneOf(mockExternalService).getAccountsByHomeFolder(with(any(Long.class)), 
                    with(any(String.class)), with(any(String.class)));
            will(returnValue(new HashMap<String, List<ExternalAccountItem>>()));
            oneOf(mockExternalService).loadInvoiceDetails(eii);
            oneOf(mockExternalService).creditHomeFolderAccounts(with(any(Collection.class)), with(any(String.class)), 
                    with(any(String.class)), with(any(Long.class)), with(any(String.class)), with(any(String.class)), 
                    with(any(Date.class)));
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        externalService.sendRequest(iRequestService.getById(cb.getRequestId()));
        externalService.getExternalAccounts(homeFolder.getId(), 
                new HashSet<String>(requestTypes), IPaymentService.EXTERNAL_INVOICES);
        externalService.loadInvoiceDetails(eii);
        externalService.creditHomeFolderAccounts(payment);
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
    }
    
    public void testNoInteractions() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add("School Registration");
        esb.setRequestTypes(requestTypes);
        esb.setSupportAccountsByHomeFolder(true);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = 
            context.mock(IExternalProviderService.class);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf (mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            never(mockExternalService).handlesTraces();
            never(mockExternalService).sendRequest(with(any(RequestType.class)));
            never(mockExternalService).handlesTraces();
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        externalService.sendRequest(iRequestService.getById(cb.getRequestId()));
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
    }
}
