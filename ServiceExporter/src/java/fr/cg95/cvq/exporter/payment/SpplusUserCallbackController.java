package fr.cg95.cvq.exporter.payment;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SpplusUserCallbackController extends AbstractController {

    private static Logger logger = Logger.getLogger(SpplusController.class);
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response)
        throws Exception {

        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            logger.debug("Got parameter " + parameterName + " with value " 
                    + request.getParameter(parameterName));
        }
        
        Map model = new HashMap();
        model.put("etat", request.getParameter("etat"));
        model.put("refsfp", request.getParameter("refsfp"));
        model.put("reference", request.getParameter("reference"));
        model.put("montant", request.getParameter("montant"));
        
        ModelAndView modelAndView = new ModelAndView("spplus_user_callback", model);

        return modelAndView;
    }
}
