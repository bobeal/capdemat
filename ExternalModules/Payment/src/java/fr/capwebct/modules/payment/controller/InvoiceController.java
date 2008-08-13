package fr.capwebct.modules.payment.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.util.DateUtil;

public class InvoiceController extends SimpleFormController {

    private IInvoiceService invoiceService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        GenericAccountCommand invoiceCommand = (GenericAccountCommand) command;
        
        long externalApplicationId = 
            invoiceCommand.getExternalApplicationId().equals("") ? 0 : Long.valueOf(invoiceCommand.getExternalApplicationId());
        List<Invoice> invoices = null;
        try {
            invoices = invoiceService.search(invoiceCommand.getId(), invoiceCommand.getLabel(),
                    DateUtil.processDate(invoiceCommand.getPaymentDateStart()), 
                    DateUtil.processDate(invoiceCommand.getPaymentDateEnd()),
                    invoiceCommand.getEfaId(), externalApplicationId);

            mav.addObject("invoices", invoices);
            mav.addObject("invoicesSize", invoices.size());
            
            mav.addObject("paginate", true);
        } catch (ParseException pe) {
            mav.addObject("error_message", "error.invalid_date");
            mav.addObject("error_message_param", pe.getLocalizedMessage());                
        }
        
        mav.addObject("externalApplications", externalApplicationService.getAll());
        mav.addObject("invoice", invoiceCommand);

        return mav;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> model = new HashMap<Object, Object>();
        model.put("externalApplications", externalApplicationService.getAll());

        request.getSession().setAttribute("currentMenu", "invoiceManagement");

        return model;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
