package fr.capwebct.modules.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;

public class AccountController extends SimpleFormController {

    private IAccountService accountService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        GenericAccountCommand accountCommand = (GenericAccountCommand) command;
        
        long externalApplicationId = 
            accountCommand.getExternalApplicationId().equals("") ? 0 : Long.valueOf(accountCommand.getExternalApplicationId());
        List<Account> accounts = 
            accountService.search(accountCommand.getId(), accountCommand.getLabel(), null, null,
                    accountCommand.getEfaId(), externalApplicationId);
        mav.addObject("accounts", accounts);
        mav.addObject("accountsSize", accounts.size());
        
        mav.addObject("account", accountCommand);
        mav.addObject("paginate", true);
        mav.addObject("externalApplications", externalApplicationService.getAll());
        
        return mav;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> model = new HashMap<Object, Object>();
        model.put("externalApplications", externalApplicationService.getAll());

        request.getSession().setAttribute("currentMenu", "accountManagement");

        return model;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
