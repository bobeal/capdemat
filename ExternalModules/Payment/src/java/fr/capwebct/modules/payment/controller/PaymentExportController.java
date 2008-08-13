package fr.capwebct.modules.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IPaymentService;
import fr.capwebct.modules.payment.util.DateUtil;

public class PaymentExportController extends SimpleFormController {

    private IPaymentService paymentService;
    private IExternalApplicationService externalApplicationService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        PaymentCommand paymentCommand = (PaymentCommand) command;
        
        long externalApplicationId = 
            paymentCommand.getExternalApplicationId().equals("") ? 0 : Long.valueOf(paymentCommand.getExternalApplicationId());
        List<Payment> payments = 
            paymentService.search(DateUtil.processDate(paymentCommand.getPaymentDateStart()),
                    DateUtil.processDate(paymentCommand.getPaymentDateEnd()),
                    paymentCommand.getPaymentAck(),
                    paymentCommand.getCvqAck(), 
                    externalApplicationId, null);
        mav.addObject("payments", payments);
        mav.addObject("paymentsSize", payments.size());

        mav.addObject("externalApplications", externalApplicationService.getAll());
        mav.addObject("payment", paymentCommand);
        mav.addObject("paginate", true);
        
        return mav;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> model = new HashMap<Object, Object>();
        model.put("externalApplications", externalApplicationService.getAll());

        request.getSession().setAttribute("currentMenu", "paymentExport");

        return model;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
