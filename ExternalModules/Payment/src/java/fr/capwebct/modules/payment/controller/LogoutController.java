package fr.capwebct.modules.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.service.IAgentService;
import fr.capwebct.modules.payment.web.filter.CASFilter;

public class LogoutController extends AbstractController {

    private IAgentService agentService;
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        request.getSession().removeAttribute(CASFilter.CAS_FILTER_RECEIPT);
        request.getSession().removeAttribute(CASFilter.CAS_FILTER_USER);
        
        ModelAndView mav = new ModelAndView("redirect:" + agentService.getLogoutUrl());
        return mav;
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }
}

