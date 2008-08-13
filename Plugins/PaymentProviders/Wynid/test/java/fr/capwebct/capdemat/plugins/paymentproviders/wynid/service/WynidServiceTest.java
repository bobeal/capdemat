package fr.capwebct.capdemat.plugins.paymentproviders.wynid.service;

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

public class WynidServiceTest extends ServiceTestCase {

    public void testAll() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        Invoice invoice1 =
            new Invoice("Wynid Invoice 1", Double.valueOf("300"),
                    null, "Wynid", "AZERTYUIOP1", new Date());
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.CARD);
        Invoice invoice2 =
            new Invoice("Wynid Invoice 2", Double.valueOf("600"),
                    null, "Wynid", "AZERTYUIOP2", new Date());
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);
        payment.addPaymentSpecificData("terminal", "Dummy-borne1");
        
        URL url = iPaymentService.initPayment(payment);
        String urlString = url.toString();
        System.err.println("urlString : " + urlString);
        int beginIndex = urlString.indexOf("transaction=");
        int endIndex = urlString.indexOf("&", beginIndex + 12);
        String reference = urlString.substring(beginIndex + 12, endIndex);
        System.err.println("reference : " + reference);

        Assert.assertNotNull(url);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("wynidid", payment.getCvqReference() + "/ACCEPTED");
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        Assert.assertEquals(PaymentResultStatus.OK, returnStatus);
    }
}
