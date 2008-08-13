package fr.cg95.cvq.exporter.payment;

import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import fr.cg95.cvq.business.users.payment.Invoice;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentService;

public class SpplusTestFormController extends SimpleFormController {

    private static Logger logger = Logger.getLogger(SpplusTestFormController.class);

    private IPaymentService paymentService;
    
    public ModelAndView onSubmit(Object command)
        throws ServletException {

        UserData userData = (UserData) command;
        logger.debug("handle() Got Here !");

        String homeFolderId = userData.getHomeFolderId();
        String requestId = userData.getRequestId();
        String amount = userData.getAmount();
        
        logger.debug("initiating payment for home folder " + homeFolderId + " and request id "
                + requestId + " and an amount of " + amount);
        
        // FIXME PAYMENT
        PurchaseItem purchaseItem =
            new Invoice("Test bill", Double.valueOf(amount),
                    null, "Régie de la ville de Dummy", "AZERTYUIOP", new Date());
                
        URL url = null;
        try {
            Payment payment = paymentService.createPaymentContainer(purchaseItem, PaymentMode.INTERNET);
            url = paymentService.initPayment(payment);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (CvqException e) {
            e.printStackTrace();
        }
        
        // TODO : redirect to an error view if null URL
        if (url != null)
            return new ModelAndView(new RedirectView(url.toString()));
        else
            return null;
    }
    
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
