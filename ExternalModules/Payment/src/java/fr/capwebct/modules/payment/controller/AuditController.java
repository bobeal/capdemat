package fr.capwebct.modules.payment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.ExternalImportAudit;
import fr.capwebct.modules.payment.service.IAuditService;

public class AuditController extends AbstractController {

    private IAuditService auditService;
    
    public void setAuditService(IAuditService auditService) {
        this.auditService = auditService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        ModelAndView mav = new ModelAndView("audit");
        List<ExternalImportAudit> externalImportAudits = auditService.getAllAuditTraces();
        mav.addObject("externalImportAudits", externalImportAudits);
        mav.addObject("externalImportAuditsSize",externalImportAudits.size());
        mav.addObject("paginate", true);
        
        request.getSession().setAttribute("currentMenu", "audit");

        return mav;
    }
}
