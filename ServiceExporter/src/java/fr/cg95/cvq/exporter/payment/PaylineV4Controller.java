package fr.cg95.cvq.exporter.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;

public class PaylineV4Controller extends AbstractController {

    private static Logger logger = Logger.getLogger(PaylineV4Controller.class);

    private IPaymentService paymentService;

    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) {

        if (logger.isDebugEnabled()) {
            for (Map.Entry<String, String[]> parameter :
                (Set<Map.Entry<String, String[]>>)
                request.getParameterMap().entrySet()) {
                if (parameter.getValue().length == 0) {
                    logger.debug("Got parameter " + parameter.getKey()
                        + " without any value");
                } else if (parameter.getValue().length == 1) {
                    logger.debug("Got parameter " + parameter.getKey()
                        + " with value " + parameter.getValue()[0]);
                } else {
                    logger.debug(new StringBuffer("Got parameter ")
                        .append(parameter.getKey()).append(" with values {\"")
                        .append(StringUtils.join(parameter.getValue(), "\",\""))
                        .append("\"}").toString());
                }
            }
        }

        String token = request.getParameter("token");
        try {
            Map<String, String> paylineParameters = new HashMap<String, String>();
            paylineParameters.put("token", token);
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
