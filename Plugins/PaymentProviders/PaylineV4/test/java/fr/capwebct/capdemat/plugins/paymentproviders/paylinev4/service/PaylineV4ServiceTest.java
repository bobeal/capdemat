package fr.capwebct.capdemat.plugins.paymentproviders.paylinev4.service;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.payment.InternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.PaymentTestCase;
import fr.cg95.cvq.util.Critere;

public class PaylineV4ServiceTest extends PaymentTestCase {

    public void testAll() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create an home folder and associates
        CreationBean cb = gimmeAnHomeFolder();
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        InternalInvoiceItem invoice1 =
            new InternalInvoiceItem("PaylineV4 Invoice 1", Double.valueOf("300"),
                    "key", "keyOwner", "PaylineV4", Integer.valueOf(1), 
                    Double.valueOf(2));
        Payment payment = iPaymentService.createPaymentContainer(invoice1, PaymentMode.INTERNET);
        InternalInvoiceItem invoice2 =
            new InternalInvoiceItem("PaylineV4 Invoice 2", Double.valueOf("600"),
                    "key", "keyOwner", "PaylineV4", Integer.valueOf(1), 
                    Double.valueOf(2));
        iPaymentService.addPurchaseItemToPayment(payment, invoice2);

        payment.addPaymentSpecificData("domainName", "localhost");

        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);

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
