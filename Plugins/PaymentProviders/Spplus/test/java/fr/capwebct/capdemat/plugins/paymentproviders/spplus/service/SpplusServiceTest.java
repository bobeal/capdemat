package fr.capwebct.capdemat.plugins.paymentproviders.spplus.service;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.payment.Invoice;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class SpplusServiceTest extends ServiceTestCase {

    public void testAll() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        Invoice invoice1 =
            new Invoice("Spplus Invoice 1", Double.valueOf("300"),
                    null, "Spplus", "AZERTYUIOP1", new Date());
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.INTERNET);
        Invoice invoice2 =
            new Invoice("Spplus Invoice 2", Double.valueOf("600"),
                    null, "Spplus", "AZERTYUIOP2", new Date());
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);

        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", payment.getCvqReference());
        parameters.put("bankReference", "BANK-1234567890");
        parameters.put("refsfp", "BANK-1234567890");
        parameters.put("etat", "10");
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        Assert.assertEquals(PaymentResultStatus.OK, returnStatus);
   }
}
