package fr.cg95.cvq.payment;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.InternalRequestItem;
import fr.cg95.cvq.business.users.payment.Invoice;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

public class PaymentServiceTest extends ServiceTestCase {

    private IExternalProviderService fakeExternalService;

    public void onSetUp() throws Exception {
        super.onSetUp();
        fakeExternalService = (IExternalProviderService) getBean("fakeExternalService");

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
    }
    
    public void onTearDown() throws Exception {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.unregisterExternalService(fakeExternalService);
        super.onTearDown();
    }

    private Payment gimmePayment(final Long requestId) throws CvqException {
        
        Map<String, String> brokers = iPaymentService.getAllBrokers();
        Assert.assertNotNull(brokers);
        Assert.assertFalse(brokers.isEmpty());
        String broker = null;
        for (String b : brokers.keySet()) {
            if (b.indexOf("Dummy") > 0)
                broker = b;
        }
        Assert.assertNotNull(broker);
        
        Invoice invoice1 =
            new Invoice("Invoice 1", Double.valueOf("300"),
                    null, broker, "AZERTYUIOP1", new Date());
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.INTERNET);
        
        Invoice invoice2 =
            new Invoice("Invoice 2", Double.valueOf("600"),
                    null, broker, "AZERTYUIOP2", new Date());
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);
        
        Request request = iRequestService.getById(requestId);
        InternalRequestItem internalRequestItem1 =
            new InternalRequestItem("IRI 1", Double.valueOf("154"),
                    request, null, 2, Double.valueOf("77"));
        iPaymentService.addPurchaseItemToPayment(payment, internalRequestItem1);
        
        InternalRequestItem internalRequestItem2 =
            new InternalRequestItem("IRI 2", Double.valueOf("140"),
                    request, null, 2, Double.valueOf("70"));
        iPaymentService.addPurchaseItemToPayment(payment, internalRequestItem2);

        ExternalAccountItem eai = 
            new ExternalDepositAccountItem("eai", Double.valueOf("30"), fakeExternalService.getLabel(), 
                    "Deposit Account Label", new Date(), Double.valueOf("70"));
        eai.addExternalServiceSpecificData("externalFamilyAccountId", "EFA-ID");
        eai.addExternalServiceSpecificData("externalApplicationLabel", "Cantine");
        iPaymentService.addPurchaseItemToPayment(payment, eai);
        
        
        return payment;
    }
    
    
    public void testPaymentSuccessFlow() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        
        Payment payment = gimmePayment(cb.getRequestId());

        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);
        
        continueWithNewTransaction();
        
        List<Payment> payments = iPaymentService.getByHomeFolder(homeFolder);
        Assert.assertEquals(1, payments.size());
        payment = payments.get(0);
        Assert.assertEquals(5, payment.getPurchaseItems().size());
        Assert.assertEquals(payment.getState(), PaymentState.INITIALIZED);
        Assert.assertNotNull(payment.getCvqReference());
        Assert.assertNotNull(payment.getId());
        
        Set<PurchaseItem> purchaseItems = payment.getPurchaseItems();
        for (PurchaseItem purchaseItem : purchaseItems) {
            if (purchaseItem instanceof ExternalDepositAccountItem) {
                ExternalDepositAccountItem edai = (ExternalDepositAccountItem) purchaseItem;
                Assert.assertEquals("EFA-ID", 
                        edai.getExternalServiceSpecificDataByKey("externalFamilyAccountId"));
                Assert.assertEquals("Cantine", 
                        edai.getExternalServiceSpecificDataByKey("externalApplicationLabel"));
            }
        }
        
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        Assert.assertEquals(returnStatus, PaymentResultStatus.OK);
        
        continueWithNewTransaction();
        
        payment = iPaymentService.getById(payment.getId());
        Assert.assertEquals(5, payment.getPurchaseItems().size());
        Assert.assertEquals(payment.getState(), PaymentState.VALIDATED);

        iPaymentService.delete(payment.getId());
        
        continueWithNewTransaction();
        
        try {
            iPaymentService.getById(payment.getId());
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        Assert.assertEquals(0, iPaymentService.getByHomeFolder(homeFolder).size());

        commitTransaction();
    }

    public void testPaymentsSearch() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        Request request = iRequestService.getById(cb.getRequestId());
        Adult requester = iIndividualService.getAdultById(request.getRequesterId());

        Payment payment = gimmePayment(cb.getRequestId());
        
        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        iPaymentService.commitPayment(parameters);
        
        commitTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        Set <Critere> criteria = new HashSet<Critere>();
        
        Critere crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getHomeFolderId());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_REQUESTER_LASTNAME);
        crit.setComparatif(Critere.STARTSWITH);
        crit.setValue(requester.getLastName());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_CVQ_REFERENCE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(payment.getCvqReference());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_BANK_REFERENCE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(payment.getBankReference());
        criteria.add(crit);
       
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_INITIALIZATION_DATE);
        crit.setComparatif(Critere.GTE);
        crit.setValue(payment.getInitializationDate());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_INITIALIZATION_DATE);
        crit.setComparatif(Critere.LTE);
        crit.setValue(payment.getInitializationDate());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_PAYMENT_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(payment.getState().toString());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_BROKER);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(payment.getBroker());
        criteria.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_PAYMENT_MODE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(payment.getPaymentMode().toString());
        criteria.add(crit);
        
        List<Payment> payments = iPaymentService.get(criteria, null, null, -1, 0);

        Assert.assertEquals(1, payments.size());
        
        continueWithNewTransaction();

        iPaymentService.delete(payment.getId());
        
        commitTransaction();
    }
}
