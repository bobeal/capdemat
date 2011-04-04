package fr.cg95.cvq.service.payment;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.InternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.util.Critere;

public class PaymentServiceTest extends PaymentTestCase {

    @Resource(name="fakeExternalService")
    private IExternalProviderService fakeExternalService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

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
            new InternalInvoiceItem("IRI 1", Double.valueOf("154"),
                    "key", "keyOwner", broker, 2, Double.valueOf("77"));
        Payment payment = 
            paymentService.createPaymentContainer(internalRequestItem1, PaymentMode.INTERNET);
        
        InternalInvoiceItem internalRequestItem2 =
            new InternalInvoiceItem("IRI 2", Double.valueOf("140"),
                    "key", "keyOwner", broker, 2, Double.valueOf("70"));
        paymentService.addPurchaseItemToPayment(payment, internalRequestItem2);

        ExternalAccountItem eai = 
            new ExternalDepositAccountItem("eai", Double.valueOf("30"), fakeExternalService.getLabel(), 
                    "Deposit Account Label", new Date(), Double.valueOf("70"), broker);
        eai.addExternalServiceSpecificData("externalFamilyAccountId", "EFA-ID");
        eai.addExternalServiceSpecificData("externalApplicationLabel", "Cantine");
        paymentService.addPurchaseItemToPayment(payment, eai);
        
        return payment;
    }    
    
    @Test
    public void testPaymentCreate() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);

        Payment payment = gimmePayment();
        
        paymentService.initPayment(payment);
        
        continueWithNewTransaction();
        
        List<Payment> payments = paymentService.getByHomeFolder(fake.id);
        assertNotNull(payments);
        assertEquals(1, payments.size());
        
        payment = payments.get(0);
        Individual homeFolderResponsible = userSearchService.getById(fake.responsibleId);
        assertEquals(homeFolderResponsible.getId(), payment.getRequesterId());
        assertEquals(homeFolderResponsible.getFirstName(), payment.getRequesterFirstName());
        assertEquals(homeFolderResponsible.getLastName(), payment.getRequesterLastName());
        assertEquals(PaymentMode.INTERNET, payment.getPaymentMode());
        assertEquals(PaymentState.INITIALIZED, payment.getState());

        paymentService.delete(payment.getId());
    }
    
    @Test
    public void testPaymentSuccessFlow() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        
        Payment payment = gimmePayment();

        URL url = paymentService.initPayment(payment);
        assertNotNull(url);
        
        continueWithNewTransaction();
        
        List<Payment> payments = paymentService.getByHomeFolder(fake.id);
        assertEquals(1, payments.size());
        payment = payments.get(0);
        assertEquals(3, payment.getPurchaseItems().size());
        assertEquals(payment.getState(), PaymentState.INITIALIZED);
        assertNotNull(payment.getCvqReference());
        assertNotNull(payment.getId());
        
        Set<PurchaseItem> purchaseItems = payment.getPurchaseItems();
        for (PurchaseItem purchaseItem : purchaseItems) {
            if (purchaseItem instanceof ExternalDepositAccountItem) {
                ExternalDepositAccountItem edai = (ExternalDepositAccountItem) purchaseItem;
                assertEquals("EFA-ID", 
                        edai.getExternalServiceSpecificDataByKey("externalFamilyAccountId"));
                assertEquals("Cantine", 
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
        PaymentResultStatus returnStatus = paymentService.commitPayment(parameters);
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        assertEquals(returnStatus, PaymentResultStatus.OK);
        
        continueWithNewTransaction();
        
        payment = paymentService.getById(payment.getId());
        assertEquals(3, payment.getPurchaseItems().size());
        assertEquals(payment.getState(), PaymentState.VALIDATED);

        paymentService.delete(payment.getId());
        
        continueWithNewTransaction();
        
        try {
            paymentService.getById(payment.getId());
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        assertEquals(0, paymentService.getByHomeFolder(fake.id).size());
    }

    @Test
    public void testPaymentSearch() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);

        Payment payment = gimmePayment();
        
        paymentService.initPayment(payment);

        continueWithNewTransaction();
        
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        paymentService.commitPayment(parameters);
        
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        List<Payment> payments = paymentService.get(null, null, null, -1, 0);
        assertEquals(1, payments.size());
        
        payment = payments.get(0);
        
        Set <Critere> criteria = new HashSet<Critere>();
        
        Critere crit = new Critere();
        crit.setAttribut(Payment.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(fake.id);
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
        
        payments = paymentService.get(criteria, null, null, -1, 0);

        assertEquals(1, payments.size());
        
        paymentService.delete(payment.getId());
    }
}
