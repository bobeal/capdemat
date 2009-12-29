package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.ecitizen.VoCardRequestDocument;

public class ExternalServiceInteractionsTest extends ExternalServiceTestCase {
   
    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";
    
    public void testInteractions() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolder();
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        final HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        esb.setSupportAccountsByHomeFolder(true);
        Mockery context = new Mockery();
        final IExternalProviderService mockExternalService = 
            context.mock(IExternalProviderService.class);
        
        final ExternalInvoiceItem eii = new ExternalInvoiceItem();
        eii.setExternalServiceLabel(EXTERNAL_SERVICE_LABEL);
        eii.setAmount(10.0);
        eii.setIssueDate(new Date());
        
        Set<PurchaseItem> purchaseItems = new HashSet<PurchaseItem>();
        purchaseItems.add(eii);
        final Payment payment = new Payment();
        payment.setPurchaseItems(purchaseItems);
        payment.setState(PaymentState.VALIDATED);
        payment.setHomeFolderId(homeFolder.getId());
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf(mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)));
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
        }});
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(mockExternalService, esb);

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Set<IExternalProviderService> externalProviderServices = 
            new HashSet<IExternalProviderService>();
        externalProviderServices.add(mockExternalService);
        VoCardRequestDocument vocrDocument = VoCardRequestDocument.Factory.newInstance();
        RequestType requestType = vocrDocument.addNewVoCardRequest();
        requestType.setHomeFolder(homeFolder.modelToXml());
        externalService.sendRequest(vocrDocument, externalProviderServices);

        continueWithNewTransaction();

        externalService.getExternalAccounts(homeFolder.getId(), IPaymentService.EXTERNAL_INVOICES);
        externalService.loadInvoiceDetails(eii);
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
        
        HibernateUtil.getSession().delete(
                externalService.getIdentifierMapping(EXTERNAL_SERVICE_LABEL,
                        cb.getHomeFolderId()));

        for (ExternalServiceTrace trace :
            externalService.getTraces(Collections.<Critere>emptySet(),
                    null, null)) {
            HibernateUtil.getSession().delete(trace);
        }
        continueWithNewTransaction();
    }
}
