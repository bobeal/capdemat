package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;
import org.hamcrest.core.AllOf;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.testtool.HasInnerProperty;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.request.technical.TechnicalInterventionRequestDocument;

public class ExternalServiceInteractionsTest extends ExternalServiceTestCase {
   
    private final String EXTERNAL_SERVICE_LABEL = "Dummy External Service";
    
    @Test
    public void testInteractions() throws CvqException {
        // initialize the mock external provider service
        final ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(tirLabel);
        esb.setRequestTypes(requestTypes);
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
        payment.setHomeFolderId(fake.id);
        
        // set up the mock expectations
        context.checking(new Expectations() {{
            oneOf(mockExternalService).checkConfiguration(with(any(ExternalServiceBean.class)), with(localAuthorityName));
            oneOf(mockExternalService).checkExternalReferential(with(any(XmlObject.class)));
            allowing(mockExternalService).getLabel();will(returnValue(EXTERNAL_SERVICE_LABEL));
            oneOf(mockExternalService).handlesTraces();
            oneOf(mockExternalService)
                .sendRequest(with(AllOf.<TechnicalInterventionRequestDocument>allOf(
                        HasInnerProperty.<TechnicalInterventionRequestDocument>hasProperty("homeFolder.externalId"),
                        HasInnerProperty.<TechnicalInterventionRequestDocument>hasProperty("homeFolder.externalCapDematId"))));
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

        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, "");
        // requestExternalService.sendRequest is called here
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, "");

        continueWithNewTransaction();

        paymentExternalService.getExternalAccounts(fake.id, IPaymentService.EXTERNAL_INVOICES);
        paymentExternalService.loadInvoiceDetails(eii);
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        
        context.assertIsSatisfied();
        
        lacb.unregisterExternalService(mockExternalService);
        
        HibernateUtil.getSession().delete(
            externalHomeFolderService.getHomeFolderMapping(EXTERNAL_SERVICE_LABEL, fake.id));

        for (RequestExternalAction trace :
            requestExternalActionService.getTraces(Collections.<Critere>emptySet(), null, null, 0, 0)) {
            HibernateUtil.getSession().delete(trace);
        }
        continueWithNewTransaction();
    }
}
