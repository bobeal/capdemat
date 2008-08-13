package fr.capwebct.modules.payment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccountSearchResult;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;

public class FamilyAccountSearchController extends AbstractController {

    private IFamilyAccountService familyAccountService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        request.getSession().setAttribute("currentMenu", "familyaccountAssociate");

        String action = request.getParameter("action");
        
        if (action.equals("initCapwebct")) {
            request.getSession().setAttribute("currentMenu", "cfaSearch");
            ModelAndView mav = new ModelAndView("search_capwebct");
            return mav;
        } else if (action.equals("initExternal")) {
            request.getSession().setAttribute("currentMenu", "efaSearch");
            ModelAndView mav = new ModelAndView("search_external");
            mav.addObject("externalApplications", externalApplicationService.getAll());
            return mav;            
        }
    
        String results = request.getParameter("results");
        String startIndex = request.getParameter("startIndex");
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");

        JSONObject resultObject = new JSONObject();

        if (action.equals("searchCapwebct")) {
            String cfaId = request.getParameter("cfaId");
            String cfaResponsible = request.getParameter("cfaResponsible");
            long parsedCfaId = 0;
            try {
                parsedCfaId = Long.valueOf(cfaId);
            } catch (NumberFormatException nfe) {
                // invalid value entered, ignore
            }
            List<CapwebctFamilyAccount> cfaList =
                familyAccountService.searchCapwebctFamilyAccount(parsedCfaId, 
                        cfaResponsible, Integer.valueOf(results),
                        Integer.valueOf(startIndex), sort, dir);
            JSONArray resultArray = new JSONArray();
            for (CapwebctFamilyAccount cfa : cfaList) {
                JSONObject cfaObject = new JSONObject();
                cfaObject.put("cfaId", cfa.getCapwebctFamilyAccountId());
                cfaObject.put("cfaResponsible", 
                        new String(cfa.getResponsibleFullName().getBytes("utf-8")));
                cfaObject.put("cfaAddress", 
                        new String(cfa.getAddress().getBytes("utf-8")));
                resultArray.add(cfaObject);
            }
            resultObject.put("cfaList", resultArray);
            resultObject.put("totalRecords", 
                    familyAccountService.getCountForSearchCapwebctFamilyAccount(parsedCfaId, 
                            cfaResponsible));

            response.getOutputStream().write(resultObject.toString().getBytes());
            response.setStatus(200);

        } else if (action.equals("searchExternal")) {
            String efaId = request.getParameter("efaId");
            String efaResponsible = request.getParameter("efaResponsible");
            String externalApplicationId = request.getParameter("externalApplicationId");
            Long parsedExternalApplicationId = 
                externalApplicationId.equals("") ? 0 : Long.valueOf(externalApplicationId);
            
            List<ExternalFamilyAccountSearchResult> efaList =
                familyAccountService.searchExternalFamilyAccount(efaId, efaResponsible, 
                        parsedExternalApplicationId, 0, null, 
                        Integer.valueOf(results), Integer.valueOf(startIndex), sort, dir);

            JSONArray resultArray = new JSONArray();
            for (ExternalFamilyAccountSearchResult efasr : efaList) {
                JSONObject cfaObject = new JSONObject();
                cfaObject.put("efaId", efasr.getEfaId());
                cfaObject.put("efaResponsible",
                        new String(efasr.getEfaFullName().getBytes("utf-8")));
                cfaObject.put("efaAddress", 
                        new String(efasr.getEfaAddress().getBytes("utf-8")));
                cfaObject.put("externalApplication",
                        new String(efasr.getExternalApplicationLabel().getBytes("utf-8")));
                cfaObject.put("cfaId", efasr.getCfaId());
                cfaObject.put("cfaResponsible", 
                        new String(efasr.getCfaResponsible().getBytes("utf-8")));
                resultArray.add(cfaObject);
            }
            resultObject.put("efaList", resultArray);
            resultObject.put("totalRecords", 
                    familyAccountService.getCountForSearchExternalFamilyAccount(efaId, 
                            efaResponsible, parsedExternalApplicationId, 0, null));

            response.getOutputStream().write(resultObject.toString().getBytes());
            response.setStatus(200);
            
        }
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return null;
    }
        
    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
