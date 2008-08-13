package fr.capwebct.modules.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.service.IExternalApplicationService;

/**
 * Handles AJAX calls related to external applications :
 * <ul>
 *   <li>delete an external application</li>
 *   <li>load brokers associated to an external application</li>
 * </ul>
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class ExternalApplicationJsonController extends AbstractController {

    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String action = request.getParameter("action");
        if (action == null || action.equals(""))
            return null;
        
        if (action.equals("deleteExternalApplication")) {
            String externalApplicationId = request.getParameter("externalApplicationId");
            try {
                externalApplicationService.delete(Long.valueOf(externalApplicationId));
                response.getOutputStream().write(new String("OK").getBytes());
            } catch (DataAccessException dae) {
                response.getOutputStream().write(new String("KO").getBytes());                
            }
        } else if (action.equals("loadExternalApplicationBrokers")) {
            String externalApplicationId = request.getParameter("externalApplicationId");
            JSONObject resultObject = new JSONObject();

            if (externalApplicationId == null || externalApplicationId.equals("")) {
                resultObject.put("brokers", new JSONArray());
            } else {
                ExternalApplication externalApplication = 
                    externalApplicationService.getById(Long.valueOf(externalApplicationId));
                JSONArray jsArray = new JSONArray();
                for (String broker : externalApplication.getBrokers()) {
                    JSONObject jsObject = new JSONObject();
                    // JS only knows UTF-8
                    jsObject.put("broker", new String(broker.getBytes("UTF-8")));
                    jsArray.add(jsObject);
                }
                resultObject.put("brokers", jsArray);
            }
            
            response.getOutputStream().write(resultObject.toString().getBytes());
        }

        response.setStatus(200);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
