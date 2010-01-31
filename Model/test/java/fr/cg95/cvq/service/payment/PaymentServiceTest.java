package fr.cg95.cvq.service.payment;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.InternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.util.Critere;

public class PaymentServiceTest extends PaymentTestCase {

    private IExternalProviderService fakeExternalService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        fakeExternalService = (IExternalProviderService) getBean("fakeExternalService");

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, new ExternalServiceBean());
    }
    
    @Override
    public void onTearDown() throws Exception {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.unregisterExternalService(fakeExternalService);
        super.onTearDown();
    }

    private Payment gimmePayment() throws CvqException {
        
        Map<String, String> brokers = iPaymentService.getAllBrokers();
        Assert.assertNotNull(brokers);
        Assert.assertFalse(brokers.isEmpty());
        String broker = null;
        for (String b : brokers.keySet()) {
            if (b.indexOf("Dummy") > 0)
                broker = b;
        }
        Assert.assertNotNull(broker);
        
        InternalInvoiceItem internalRequestItem1 =
            new InternalInvoiceItem("IRI 1", Double.valueOf("154"),
                    "key", "keyOwner", broker, 2, Double.valueOf("77"));
        Payment payment = 
            iPaymentService.createPaymentContainer(internalRequestItem1, PaymentMode.INTERNET);
        
        InternalInvoiceItem internalRequestItem2 =
            new InternalInvoiceItem("IRI 2", Double.valueOf("140"),
                    "key", "keyOwner", broker, 2, Double.valueOf("70"));
        iPaymentService.addPurchaseItemToPayment(payment, internalRequestItem2);

        ExternalAccountItem eai = 
            new ExternalDepositAccountItem("eai", Double.valueOf("30"), fakeExternalService.getLabel(), 
                    "Deposit Account Label", new Date(), Double.valueOf("70"), broker);
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
        
        Payment payment = gimmePayment();

        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);
        
        continueWithNewTransaction();
        
        List<Payment> payments = iPaymentService.getByHomeFolder(cb.getHomeFolderId());
        Assert.assertEquals(1, payments.size());
        payment = payments.iterator().next();
        Assert.assertEquals(3, payment.getPurchaseItems().size());
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
            } else if (purchaseItem instanceof InternalInvoiceItem) {
                InternalInvoiceItem iii = (InternalInvoiceItem) purchaseItem;
                assertEquals("key", iii.getKey());
                assertEquals("keyOwner", iii.getKeyOwner());
            }
        }
        
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        Assert.assertEquals(returnStatus, PaymentResultStatus.OK);
        
        continueWithNewTransaction();
        
        payment = iPaymentService.getById(payment.getId());
        Assert.assertEquals(3, payment.getPurchaseItems().size());
        Assert.assertEquals(payment.getState(), PaymentState.VALIDATED);

        iPaymentService.delete(payment.getId());
        
        continueWithNewTransaction();
        
        try {
            iPaymentService.getById(payment.getId());
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        Assert.assertEquals(0, iPaymentService.getByHomeFolder(cb.getHomeFolderId()).size());

        commitTransaction();
    }

    public void testPaymentsSearch() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        Payment payment = gimmePayment();
        
        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        iPaymentService.commitPayment(parameters);
        commitTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Set <Critere> criteria = new HashSet<Critere>();
        
        Critere crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(cb.getHomeFolderId());
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
