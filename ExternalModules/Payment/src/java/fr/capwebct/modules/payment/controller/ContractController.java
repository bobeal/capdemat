package fr.capwebct.modules.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;

public class ContractController extends SimpleFormController {

    private IContractService contractService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        GenericAccountCommand contractCommand = (GenericAccountCommand) command;
        
        long externalApplicationId = 
            contractCommand.getExternalApplicationId().equals("") ? 0 : Long.valueOf(contractCommand.getExternalApplicationId());
        List<Contract> contracts = 
            contractService.search(contractCommand.getId(), contractCommand.getLabel(), 
                    contractCommand.getExternalIndividualId(), contractCommand.getEfaId(),
                    externalApplicationId);
        mav.addObject("contracts", contracts);
        mav.addObject("contractsSize", contracts.size());
        
        mav.addObject("contract", contractCommand);
        mav.addObject("paginate", true);
        mav.addObject("externalApplications", externalApplicationService.getAll());
        
        return mav;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> model = new HashMap<Object, Object>();
        model.put("externalApplications", externalApplicationService.getAll());

        request.getSession().setAttribute("currentMenu", "contractManagement");

        return model;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
