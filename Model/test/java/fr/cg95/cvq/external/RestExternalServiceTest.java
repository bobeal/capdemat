package fr.cg95.cvq.external;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.InternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.technical.TechnicalInterventionRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.util.Critere;

public class RestExternalServiceTest extends ExternalServiceTestCase {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private IExternalProviderService restExternalService;

    @Autowired
    @Qualifier("technicalInterventionRequestService")
    private IRequestService service;

    @Autowired
    private IRequestExternalService requestExternalService;

    private CreationBean cb;

    private TechnicalInterventionRequest request;

    @Before
    public void bootstrap()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setRequestTypes(Arrays.asList(new String[]{service.getLabel()}));
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(restExternalService, esb);
        continueWithNewTransaction();
        cb = gimmeMinimalHomeFolder();
        continueWithNewTransaction();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(homeFolderResponsible);
        request = (TechnicalInterventionRequest)
            requestWorkflowService.getSkeletonRequest(service.getLabel());
        requestWorkflowService.create(request, null, null, null);
        continueWithNewTransaction();
    }

    @After
    public void clean()
        throws CvqException {
        requestWorkflowService.delete(request.getId());
    }

    private Payment gimmePayment()
        throws CvqException {
        Map<String, String> brokers = paymentService.getAllBrokers();
        assertNotNull(brokers);
        assertFalse(brokers.isEmpty());
        String broker = null;
        for (String b : brokers.keySet()) {
            if (b.indexOf("Dummy") > 0)
                broker = b;
        }
        assertNotNull(broker);
        InternalInvoiceItem internalRequestItem1 =
            new InternalInvoiceItem("IRI 1", Double.valueOf("154"), "key", "keyOwner", broker, 2,
                Double.valueOf("77"));
        Payment payment =
            paymentService.createPaymentContainer(internalRequestItem1, PaymentMode.INTERNET);
        InternalInvoiceItem internalRequestItem2 =
            new InternalInvoiceItem("IRI 2", Double.valueOf("140"), "key", "keyOwner", broker, 2,
                Double.valueOf("70"));
        paymentService.addPurchaseItemToPayment(payment, internalRequestItem2);
        ExternalAccountItem eai = new ExternalDepositAccountItem("eai", Double.valueOf("30"),
            restExternalService.getLabel(), "Deposit Account Label", new Date(),
            Double.valueOf("70"), broker);
        eai.setExternalHomeFolderId("EFA-ID");
        eai.setExternalApplicationId("123");
        paymentService.addPurchaseItemToPayment(payment, eai);
        return payment;
    }

    @Test
    public void checkExternalReferential()
        throws CvqException {
        request.setInterventionDescription("error");
        requestWorkflowService.rewindWorkflow(request, null, null);
        continueWithNewTransaction();
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        List<String> errors = requestExternalService.checkExternalReferential(request);
        assertEquals(1, errors.size());
        assertEquals("error", errors.get(0));
        request.setInterventionDescription("OK");
        requestWorkflowService.modify(request);
        continueWithNewTransaction();
        errors = requestExternalService.checkExternalReferential(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void creditHomeFolderAccounts()
        throws CvqException {
        Payment payment = gimmePayment();
        paymentService.initPayment(payment);
        continueWithNewTransaction();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        assertEquals(PaymentResultStatus.OK, paymentService.commitPayment(parameters));
    }

    @Test
    public void sendRequest()
        throws CvqException {
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        continueWithNewTransaction();
        Set<Critere> criterias = new HashSet<Critere>();
        criterias.add(new Critere(RequestExternalAction.SEARCH_BY_KEY,
            String.valueOf(request.getId()), Critere.EQUALS));
        List<RequestExternalAction> traces = requestExternalActionService.getTraces(criterias, null, null, 0, 0);
        assertEquals(1, traces.size());
        assertEquals(RequestExternalAction.Status.SENT, traces.get(0).getStatus());
    }

    @Test
    public void getAccountsByHomeFolder()
        throws CvqException {
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        continueWithNewTransaction();
        assertEquals(1, paymentExternalService.getExternalAccounts(cb.getHomeFolderId(),
            IPaymentService.EXTERNAL_INVOICES).size());
    }

    @Test
    public void getConsumptions()
        throws CvqException {
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        continueWithNewTransaction();
        assertEquals(1, requestExternalService.getConsumptions(
                request.getId(), new Date(), new Date()).size());
    }

    @Test
    public void loadDepositAccountDetails()
        throws CvqException {
        ExternalDepositAccountItem edai = new ExternalDepositAccountItem("test", Double.valueOf(10), restExternalService.getLabel(), "ext", new Date(), Double.valueOf(5), "fake");
        edai.setExternalHomeFolderId("ext");
        edai.setExternalHomeFolderId("extFID");
        assertNull(edai.getAccountDetails());
        paymentExternalService.loadDepositAccountDetails(edai);
        assertNotNull(edai.getAccountDetails());
        assertEquals(1, edai.getAccountDetails().size());
    }

    @Test
    public void loadExternalInformations()
        throws CvqException {
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        assertEquals(3, requestExternalService.loadExternalInformations(request).size());
    }

    @Test
    public void loadInvoiceDetails()
        throws CvqException {
        ExternalInvoiceItem eii = new ExternalInvoiceItem("test", Double.valueOf(10), Double.valueOf(20), restExternalService.getLabel(), "ext", new Date(), new Date(), new Date(), true, "fake");
        eii.setExternalApplicationId("ext");
        eii.setExternalHomeFolderId("extFID");
        assertNull(eii.getInvoiceDetails());
        paymentExternalService.loadInvoiceDetails(eii);
        assertNotNull(eii.getInvoiceDetails());
        assertEquals(1, eii.getInvoiceDetails().size());
    }
}
