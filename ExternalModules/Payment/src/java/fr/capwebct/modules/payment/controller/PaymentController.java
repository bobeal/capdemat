package fr.capwebct.modules.payment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.service.IPaymentService;
import fr.capwebct.modules.payment.util.DateUtil;

public class PaymentController extends SimpleFormController {

    private IPaymentService paymentService;
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
            Object command, BindException errors) 
        throws Exception {

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        PaymentCommand paymentCommand = (PaymentCommand) command;
        
        long cfaId = 0;
        if (paymentCommand.getCfaId() != null
                && !paymentCommand.getCfaId().equals("")) {
            try {
                cfaId = Long.valueOf(paymentCommand.getCfaId());
            } catch (NumberFormatException nfe) {
                // invalid value entered, ignore
            }
        }
        
        List<Payment> payments = 
            paymentService.search(DateUtil.processDate(paymentCommand.getPaymentDateStart()),
                    DateUtil.processDate(paymentCommand.getPaymentDateEnd()),
                    paymentCommand.getPaymentAck(), paymentCommand.getCvqAck(), 
                    cfaId, paymentCommand.getBroker(), false);
        mav.addObject("payments", payments);
        mav.addObject("paymentsSize", payments.size());

        mav.addObject("payment", paymentCommand);
        mav.addObject("paginate", true);
        
        return mav;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        request.getSession().setAttribute("currentMenu", "paymentManagement");

        return null;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
