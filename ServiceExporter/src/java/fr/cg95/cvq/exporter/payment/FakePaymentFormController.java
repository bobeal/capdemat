package fr.cg95.cvq.exporter.payment;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

public class FakePaymentFormController extends SimpleFormController {

    private static Logger logger = Logger.getLogger(FakePaymentFormController.class);

    public ModelAndView onSubmit(Object command) throws ServletException {

        PaymentData paymentData = (PaymentData) command;

        String cardNumber = paymentData.getCardNumber();
        logger.debug("onSubmit() Card number : " + cardNumber);
        String cvqReference = paymentData.getCvqReference();
        logger.debug("onSubmit() Reference : " + cvqReference);
        
        StringBuffer redirectUrl = new StringBuffer().append(paymentData.getCallbackUrl())
            .append("?cvqReference=").append(cvqReference)
            .append("&bankReference=").append(cvqReference)
            .append("&capDematFake=true")
            .append("&status=");
    
        if (cardNumber.equals("0123456789"))
            redirectUrl.append("OK");
        else if (cardNumber.equals("0000000000"))
            redirectUrl.append("CANCELLED");
        else if (cardNumber.equals("9999999999"))
            redirectUrl.append("REFUSED");

        return new ModelAndView(new RedirectView(redirectUrl.toString()));
    }
}
