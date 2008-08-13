package fr.cg95.cvq.exporter.payment;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class FakePaymentInputController extends AbstractController {

    private static Logger logger = Logger.getLogger(FakePaymentInputController.class);
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        // DEBUG
        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            logger.debug("Got parameter " + parameterName + " with value " 
                    + request.getParameter(parameterName));
        }
        
        Map<String, String> model = new HashMap<String, String>();
        model.put("cvqReference", request.getParameter("cvqReference"));
        model.put("email", request.getParameter("email"));
        model.put("amount", request.getParameter("amount"));
        model.put("callbackUrl", request.getParameter("callbackUrl"));
        
        request.removeAttribute("cvqReference");
        request.removeAttribute("email");
        request.removeAttribute("amount");
        request.removeAttribute("callbackUrl");
        request.removeAttribute("capDematFake");
        
        return new ModelAndView("fake_payment_form", model);
    }
}
