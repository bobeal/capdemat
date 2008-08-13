package fr.capwebct.modules.payment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;

public class FamilyAccountAssociateController extends AbstractController {

    private IFamilyAccountService familyAccountService;
    private IExternalApplicationService externalApplicationService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        request.getSession().setAttribute("currentMenu", "familyaccountAssociate");

        String action = request.getParameter("action");
        if (action == null) {
            ModelAndView mav = new ModelAndView("associate");
            mav.addObject("externalApplications", externalApplicationService.getAll());
            return mav;
        }
        
        JSONObject resultObject = new JSONObject();

        if (action.equals("searchEfa")) {
            String query = request.getParameter("query");
            String externalApplicationId = request.getParameter("externalApplicationId");
            List<ExternalFamilyAccount> efaList =
                familyAccountService.searchForAutocomplete(query, Long.valueOf(externalApplicationId));

            JSONArray jsArray = new JSONArray();
            for (ExternalFamilyAccount efa : efaList) {
                JSONObject jsObject = new JSONObject();
                jsObject.put("efaId", efa.getExternalFamilyAccountId());
                jsObject.put("efaResponsibleLastName", 
                        new String(efa.getExternalFamilyAccountResponsible().getBytes("utf-8")));
                jsObject.put("efaAddress", 
                        new String(efa.getAddress().getBytes("utf-8")));
                if (efa.getCapwebctFamilyAccount() != null)
                    jsObject.put("isAssociated", true);
                else
                    jsObject.put("isAssociated", false);
                jsArray.add(jsObject);
            }
            resultObject.put("efaList", jsArray);
            response.getOutputStream().write(resultObject.toString().getBytes());
            response.setStatus(200);

        } else if (action.equals("loadFamilyAccounts")) {

            String familyAccountType = request.getParameter("familyAccountType");
            String externalApplicationId = request.getParameter("externalApplicationId");
            String cfaResponsible = request.getParameter("cfaResponsible");
            
            String results = request.getParameter("results");
            String startIndex = request.getParameter("startIndex");
            String sort = request.getParameter("sort");
            String dir = request.getParameter("dir");
            
            if (familyAccountType.equals("not_associated")
                    || familyAccountType.equals("no_meaning")) {
                List<CapwebctFamilyAccount> cfaList =
                    familyAccountService.getForStateAndExternalApplication(familyAccountType, 
                            Long.valueOf(externalApplicationId), cfaResponsible,
                            Integer.valueOf(results), Integer.valueOf(startIndex), sort, dir);
                JSONArray resultArray = new JSONArray();
                for (CapwebctFamilyAccount cfa : cfaList) {
                    JSONObject cfaObject = new JSONObject();
                    cfaObject.put("cfaId", cfa.getCapwebctFamilyAccountId());
                    cfaObject.put("cfaResponsible", 
                            new String(cfa.getResponsibleFullName().getBytes("utf-8")));
                    cfaObject.put("cfaAddress", 
                            new String(cfa.getAddress().getBytes("utf-8")));
                    cfaObject.put("efaId", "");
                    cfaObject.put("efaResponsible", "");
                    cfaObject.put("efaAddress", "");
                    cfaObject.put("action", familyAccountType);
                    resultArray.add(cfaObject);
                }
                resultObject.put("cfaList", resultArray);
                resultObject.put("totalRecords", 
                        familyAccountService.getCountForStateAndExternalApplication(familyAccountType, 
                                Long.valueOf(externalApplicationId), cfaResponsible));
            } else {
                List<ExternalFamilyAccount> efaList =
                    familyAccountService.getAssociatedAccounts(Long.valueOf(externalApplicationId), 
                            cfaResponsible, Integer.valueOf(results), Integer.valueOf(startIndex), sort, dir);
                JSONArray resultArray = new JSONArray();
                for (ExternalFamilyAccount efa : efaList) {
                    JSONObject object = new JSONObject();
                    CapwebctFamilyAccount cfa = efa.getCapwebctFamilyAccount();
                    object.put("cfaId", cfa.getCapwebctFamilyAccountId());
                    object.put("cfaResponsible", 
                            new String(cfa.getResponsibleFullName().getBytes("utf-8")));
                    object.put("cfaAddress", 
                            new String(cfa.getAddress().getBytes("utf-8")));
                    object.put("efaId", efa.getExternalFamilyAccountId());
                    object.put("efaResponsible", 
                            new String(efa.getExternalFamilyAccountResponsible().getBytes("utf-8")));
                    object.put("efaAddress", 
                            new String(efa.getAddress().getBytes("utf-8")));
                    object.put("action", familyAccountType);
                    resultArray.add(object);
                }
                resultObject.put("cfaList", resultArray);
                resultObject.put("totalRecords", 
                        familyAccountService.getCountForAssociatedAccounts(Long.valueOf(externalApplicationId), 
                                cfaResponsible));
            }
            
            response.getOutputStream().write(resultObject.toString().getBytes());
            response.setStatus(200);
            
        } else if (action.equals("addFamilyAccountBinding")) {
            String cfaId = request.getParameter("cfaIdToAssociate");
            String efaId = request.getParameter("efaIdToAssociate");
            String externalApplicationId = request.getParameter("externalApplicationIdToAssociate");
            try {
                familyAccountService.bindFamilyAccounts(efaId, 
                        Long.valueOf(externalApplicationId), Long.valueOf(cfaId));
                response.getOutputStream().write(new String("OK").getBytes());
            } catch (DataAccessException dae) {
                response.getOutputStream().write(new String("KO").getBytes());                
            }
            
        } else if (action.equals("deleteFamilyAccountBinding")) {
            String externalApplicationId = request.getParameter("externalApplicationId");
            String efaId = 
                new String(request.getParameter("efaId").getBytes(), "UTF-8");
      
            try {
                familyAccountService.unbindFamilyAccount(efaId, Long.valueOf(externalApplicationId));
                response.getOutputStream().write(new String("OK").getBytes());
                response.setStatus(200);
            } catch (DataAccessException dae) {
                response.getOutputStream().write(new String("KO").getBytes());                
                response.setStatus(200);
            }
            
        } else if (action.equals("hideFamilyAccount")) {
            String cfaId = request.getParameter("cfaId");
            String externalApplicationId = request.getParameter("externalApplicationId");
            try {
                familyAccountService.hideFamilyAccount(Long.valueOf(cfaId), 
                        Long.valueOf(externalApplicationId));
                response.getOutputStream().write(new String("OK").getBytes());
            } catch (DataAccessException dae) {
                response.getOutputStream().write(new String("KO").getBytes());
            }
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
