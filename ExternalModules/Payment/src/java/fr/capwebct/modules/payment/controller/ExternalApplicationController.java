package fr.capwebct.modules.payment.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.service.IExternalApplicationService;


public class ExternalApplicationController extends SimpleFormController {

    private static Log log = LogFactory.getLog(ExternalApplicationController.class);

    private IExternalApplicationService externalApplicationService;

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        String action = request.getParameter("action");
        log.debug("onSubmit() action : " + request.getParameter("action"));
        
        ExternalApplicationCommand externalApplicationCommand =
            (ExternalApplicationCommand) command;
        if (action.equals("createOrUpdate")) {
            if (externalApplicationCommand.getId() == null 
                    || externalApplicationCommand.getId().equals("")) {
                // it is a creation
                Set<String> brokers = new HashSet<String>();
                brokers.add(externalApplicationCommand.getBroker1());
                if (!externalApplicationCommand.getBroker2().equals(""))
                    brokers.add(externalApplicationCommand.getBroker2());
                if (!externalApplicationCommand.getBroker3().equals(""))
                    brokers.add(externalApplicationCommand.getBroker3());
                ExternalApplication externalApplication = 
                    externalApplicationService.create(externalApplicationCommand.getLabel(), 
                            externalApplicationCommand.getDescription(), brokers);
                externalApplicationCommand.setId(String.valueOf(externalApplication.getId()));
            } else {
                // it is an update
                Set<String> brokers = new HashSet<String>();
                brokers.add(externalApplicationCommand.getBroker1());
                if (!externalApplicationCommand.getBroker2().equals(""))
                    brokers.add(externalApplicationCommand.getBroker2());
                if (!externalApplicationCommand.getBroker3().equals(""))
                    brokers.add(externalApplicationCommand.getBroker3());
                externalApplicationService.update(Long.valueOf(externalApplicationCommand.getId()), 
                        externalApplicationCommand.getLabel(), 
                        externalApplicationCommand.getDescription(), brokers);
            }
            mav.addObject("externalApplication", new ExternalApplicationCommand());
        } 
        
        List<ExternalApplication> allExternalApplications = externalApplicationService.getAll();
        mav.addObject("allExternalApplications", allExternalApplications);
        mav.addObject("allExternalApplicationsSize", allExternalApplications.size());
        
        return mav;
    }
    
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> model = new HashMap<Object, Object>();

        String action = request.getParameter("action");
        if (action != null && action.equals("load")) {
            String externalApplicationId = request.getParameter("externalApplicationId");
            ExternalApplication externalApplication =
                externalApplicationService.getById(Long.valueOf(externalApplicationId));
            ExternalApplicationCommand externalApplicationCommand = 
                new ExternalApplicationCommand(externalApplication);
            model.put("externalApplication", externalApplicationCommand);            
        }
        
        List<ExternalApplication> allExternalApplications = externalApplicationService.getAll();
        model.put("allExternalApplications", allExternalApplications);
        model.put("allExternalApplicationsSize", allExternalApplications.size());

        request.getSession().setAttribute("currentMenu", "externalApplication");
        
        return model;
    }
    
    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
