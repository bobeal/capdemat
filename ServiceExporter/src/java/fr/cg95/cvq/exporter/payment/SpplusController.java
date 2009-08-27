package fr.cg95.cvq.exporter.payment;

import java.io.PrintWriter;
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

public class SpplusController extends AbstractController {

    private static Logger logger = Logger.getLogger(SpplusController.class);
    
    private IPaymentService paymentService;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        // DEBUG
        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            logger.debug("Got parameter " + parameterName + " with value " 
                    + request.getParameter(parameterName));
        }
        
        String reference = request.getParameter("reference");
        String etat = request.getParameter("etat");
        String refsfp = request.getParameter("refsfp");
        Map<String, String> parametersMap = new HashMap<String, String>();
        parametersMap.put("cvqReference", reference);
        parametersMap.put("bankReference", refsfp);
        parametersMap.put("refsfp", refsfp);
        parametersMap.put("etat", etat);
        
        try {
            SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
            paymentService.commitPayment(parametersMap);
        } catch (CvqException e) {
            logger.error("handleRequestInternal() Error while commiting payment " + e);
            e.printStackTrace();
        }
        
        PrintWriter printWriter = response.getWriter();
        printWriter.print("spcheckok");
        printWriter.flush();
        printWriter.close();
        
        return null;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
