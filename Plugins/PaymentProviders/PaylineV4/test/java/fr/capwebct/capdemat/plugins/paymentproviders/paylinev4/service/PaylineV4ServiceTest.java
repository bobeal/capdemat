package fr.capwebct.capdemat.plugins.paymentproviders.paylinev4.service;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.payment.Invoice;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

public class PaylineV4ServiceTest extends ServiceTestCase {

    public void testAll() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        Invoice invoice1 =
            new Invoice("Spplus Invoice 1", Double.valueOf("300"),
                    null, "PaylineV4", "AZERTYUIOP1", new Date());
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.INTERNET);
        Invoice invoice2 =
            new Invoice("Spplus Invoice 2", Double.valueOf("600"),
                    null, "PaylineV4", "AZERTYUIOP2", new Date());
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);

        payment.addPaymentSpecificData("domainName", "localhost");

        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);
        System.err.println("********* Got URL " + url);

        continueWithNewTransaction();

        Set<Critere> criterias = new HashSet<Critere>();
        criterias.add(new Critere(Payment.SEARCH_BY_HOME_FOLDER_ID,
            cb.getHomeFolderId(), Critere.EQUALS));
        List<Payment> payments =
            iPaymentService.get(criterias, null, null, 0, 0);
        assertEquals(1, payments.size());
        Payment finalPayment = payments.get(0);
        assertNotNull(finalPayment.getBankReference());
        assertNotNull(finalPayment.getCvqReference());

//        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("token", payment.getBankReference());
//        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
//        Assert.assertEquals(PaymentResultStatus.OK, returnStatus);
   }
}
