package fr.capwebct.capdemat.plugins.paymentproviders.payline.service;

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

public class PaylineServiceTest extends ServiceTestCase {

    public void testAll() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        Invoice invoice1 =
            new Invoice("Payline Invoice 1", Double.valueOf("300"),
                    null, "Payline", "AZERTYUIOP1", new Date());
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.INTERNET);
        Invoice invoice2 =
            new Invoice("Payline Invoice 2", Double.valueOf("600"),
                    null, "Payline", "AZERTYUIOP2", new Date());
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);
        
        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("sessionid", "1234567890");
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        Assert.assertEquals(returnStatus, PaymentResultStatus.OK);
    }
}
