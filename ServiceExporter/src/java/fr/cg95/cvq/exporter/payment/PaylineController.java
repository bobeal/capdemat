package fr.cg95.cvq.exporter.payment;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;

public class PaylineController extends AbstractController {

    private static Logger logger = Logger.getLogger(PaylineController.class);
    
    private IPaymentService paymentService;
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        // DEBUG
        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            logger.debug("Got parameter " + parameterName + " with value " 
                    + request.getParameter(parameterName));
        }
        
        String sessionid = request.getParameter("sessionid");
        try {
            Map<String, String> paylineParameters = new HashMap<String, String>();
            paylineParameters.put("sessionid", sessionid);
            SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
            paymentService.commitPayment(paylineParameters);
        } catch (CvqException e) {
            logger.error("handleRequestInternal() Error while commiting payment " + e);
            e.printStackTrace();
        }
        
        return null;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
