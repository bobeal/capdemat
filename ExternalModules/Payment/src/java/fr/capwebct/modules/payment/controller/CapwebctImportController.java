package fr.capwebct.modules.payment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.exception.CpmWebServiceException;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.capwebct.modules.payment.webservice.client.ICapwebctWebServiceClient;

public class CapwebctImportController extends SimpleFormController {

    private ICapwebctWebServiceClient capwebctWebServiceClient;
    private IFamilyAccountService familyAccountService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        List<CapwebctFamilyAccount> capWebctFamilyAccounts = null;
        try {
            capWebctFamilyAccounts = capwebctWebServiceClient.getCapwebctFamilyAccounts();
        } catch (CpmWebServiceException cwse) {
            mav.addObject("error_message", "admin.capwebct_import.error.web_service");
            mav.addObject("error_message_param", cwse.getLocalizedMessage());            
            return mav;           
        }
 
        long[] importResults = 
            familyAccountService.importCapwebctFamilyAccounts(capWebctFamilyAccounts);
        
        mav.addObject("success_message", "admin.capwebct_import.success_message");
        mav.addObject("success_message_param_created", importResults[0]);
        mav.addObject("success_message_param_modified", importResults[1]);
      
        return mav;
    }
    
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        request.getSession().setAttribute("currentMenu", "capwebctImport");
        return null;
    }

    public void setCapwebctWebServiceClient(ICapwebctWebServiceClient capwebctWebServiceClient) {
        this.capwebctWebServiceClient = capwebctWebServiceClient;
    }

    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }
}
