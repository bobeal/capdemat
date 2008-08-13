package fr.capwebct.modules.payment.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;

/**
 * @deprecated remove if new way of managing family account is confirmed
 */
public class HomefolderManageController extends SimpleFormController {

    private static Log log = LogFactory.getLog(HomefolderManageController.class);
   
    private IFamilyAccountService familyAccountService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

//        String action = request.getParameter("action");
//        log.debug("onSubmit() action : " + request.getParameter("action"));
//
//        FamilyAccountCommand familyAccountCommandObject = 
//            (FamilyAccountCommand) command;
//        ModelAndView mav = new ModelAndView(getSuccessView());
//        
//        if (action.equals("associate")) {
//            // we are adding an association
//            //   -> either a CapWebCT family with an external family
//            //   -> either a CapWebCT individual with an external individual
//            
//            String cfaId = familyAccountCommandObject.getCfaId();
//            CapwebctFamilyAccount cfa = 
//                familyAccountService.getCfaByCapwebctId(Long.valueOf(cfaId));
//
//            String efaId = familyAccountCommandObject.getEfaId();
//            String externalApplicationId = familyAccountCommandObject.getExternalApplicationId();
//            if (efaId == null 
//                    || (externalApplicationId == null || externalApplicationId.equals(""))) {
//                // not enough information, go away !
//                mav.addObject("error_message", "homefolder.associate.require_efa_data");
//                mav.addObject("mode", "bindAccounts");
//            } else {
//                
//                String mode = request.getParameter("mode");
//                
//                ExternalFamilyAccount efa = null;
//                if (mode.equals("bindAccounts")) {
////                    efa = familyAccountService.bindFamilyAccounts(efaId, 
////                            Long.valueOf(externalApplicationId), cfa);
//                } else if (mode.equals("bindIndividuals")) {
//                    efa = familyAccountService.getExternalFamilyAccount(efaId, 
//                            Long.valueOf(externalApplicationId));
//                    Enumeration parameters = request.getParameterNames();
//                    while (parameters.hasMoreElements()) {
//                        String parameter = (String) parameters.nextElement();
//                        if (!parameter.startsWith("EI-"))
//                            continue;
//                        String capwebctIndividualId = parameter.substring(3);
//                        String externalIndividualId = request.getParameter(parameter);
//                        familyAccountService.bindIndividuals(efa, externalIndividualId, cfa, 
//                                Long.valueOf(capwebctIndividualId));
//                    }
//                }
//
//                mav.addObject("efa", efa);
//                mav.addObject("mode", "bindIndividuals");
//            }
//            
//            mav.addObject("cfa", cfa);
//            mav.addObject("familyaccount", familyAccountCommandObject);
//
//            List<ExternalFamilyAccount> fab = 
//                familyAccountService.getByCapWebctFamilyAccountId(Long.valueOf(cfaId));
//            mav.addObject("bindings", fab);
//            mav.addObject("bindingsSize", fab.size());
//            
//            mav.addObject("externalApplications", externalApplicationService.getAll());
//            
//            return mav;
//        } else if (action.equals("load")) {
//            String efaId = request.getParameter("efaId");
//            String externalApplicationId = request.getParameter("externalApplicationId");
//            ExternalFamilyAccount efa = familyAccountService.getExternalFamilyAccount(efaId, 
//                    Long.valueOf(externalApplicationId));
//
//            mav.addObject("efa", efa);
//            mav.addObject("mode", "bindIndividuals");
//
//            mav.addObject("cfa", efa.getCapwebctFamilyAccount());
//            mav.addObject("familyaccount", familyAccountCommandObject);
//            List<ExternalFamilyAccount> fab = 
//                familyAccountService.getByCapWebctFamilyAccountId(efa.getCapwebctFamilyAccount().getCapwebctFamilyAccountId());
//            mav.addObject("bindings", fab);
//            mav.addObject("bindingsSize", fab.size());
//            
//            mav.addObject("externalApplications", externalApplicationService.getAll());
//            
//            return mav;
//        }
//        
        return null;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

//        String action = request.getParameter("action");
//        if (action == null)
//            return super.referenceData(request);
//        
//        if (action.equals("manage")) {
//            Map<Object, Object> model = new HashMap<Object, Object>();
//
//            String cfaId = request.getParameter("cfaId");
//            CapwebctFamilyAccount cfa = 
//                familyAccountService.getCfaByCapwebctId(Long.valueOf(cfaId));
//            model.put("cfa", cfa);
//            List<ExternalFamilyAccount> fab = 
//                familyAccountService.getByCapWebctFamilyAccountId(cfa.getCapwebctFamilyAccountId());
//            model.put("bindings", fab);
//            model.put("bindingsSize", fab.size());
//            model.put("externalApplications", externalApplicationService.getAll());
//
//            String efaId = request.getParameter("efaId");
//            if (efaId != null) {
//                String externalApplicationId = request.getParameter("externalApplicationId");
//                ExternalFamilyAccount efa = familyAccountService.getExternalFamilyAccount(efaId, 
//                        Long.valueOf(externalApplicationId));
//
//                model.put("efa", efa);
//                if (efa.hasContracts())
//                    model.put("mode", "bindIndividuals");
//                else
//                    // FIXME : need a new mode ?
//                    model.put("mode", "bindAccounts");
//            } else {
//                model.put("mode", "bindAccounts");                
//            }
//            
//            return model;
//        } 

        return super.referenceData(request);
    }
    
    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
