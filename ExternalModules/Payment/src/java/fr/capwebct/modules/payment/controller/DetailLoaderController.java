package fr.capwebct.modules.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsDateJsonValueProcessor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IInvoiceService;

public class DetailLoaderController extends AbstractController {

    private IInvoiceService invoiceService;
    private IAccountService accountService;
    
    public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String action = request.getParameter("action");
        if (action != null && action.equals("loadInvoiceDetails")) {
            Invoice invoice = 
                invoiceService.getByExternalAndInvoiceId(request.getParameter("externalFamilyAccountId"),
                        Long.valueOf(request.getParameter("externalApplicationId")), 
                        request.getParameter("invoiceId"));
            JSONArray jsArray = new JSONArray();
            for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetailList()) {
                JSONObject jsObject = new JSONObject();
                jsObject.put("label", 
                        new String(invoiceDetail.getLabel().getBytes("utf-8")));
                jsObject.put("subject",
                        new String(invoiceDetail.getChildName().getBytes("utf-8")) + " "
                        + new String(invoiceDetail.getChildSurname().getBytes("utf-8")));
                jsObject.put("unitPrice", invoiceDetail.getUnitPrice());
                jsObject.put("quantity", invoiceDetail.getQuantity());
                jsObject.put("value", invoiceDetail.getValue());
                jsArray.add(jsObject);
            }
            response.getOutputStream().write(jsArray.toString().getBytes());
            response.setStatus(200);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            return null;
        } else if (action != null && action.equals("loadAccountDetails")) {
            Account account = 
                accountService.getByExternalAndAccountId(request.getParameter("externalFamilyAccountId"),
                        Long.valueOf(request.getParameter("externalApplicationId")), 
                        request.getParameter("accountId"));
            JSONArray jsArray = new JSONArray();
            for (AccountDetail accountDetail : account.getAccountDetailList()) {
                JSONObject jsObject = new JSONObject();
                if (accountDetail.getHolderName() != null
                        && accountDetail.getHolderSurname() != null) {
                    jsObject.put("subject", 
                            new String(accountDetail.getHolderName().getBytes("utf-8")) + " " 
                            + new String(accountDetail.getHolderSurname().getBytes("utf-8")));
                }else {
                    jsObject.put("subject", "");
                }
                Payment payment = accountDetail.getPayment();
                jsObject.put("date", 
                        new JsDateJsonValueProcessor().processArrayValue(payment.getPaymentDate()));
                jsObject.put("value", accountDetail.getValue());
                if (payment.getPaymentType() != null) {
                    jsObject.put("paymentType", 
                            new String(payment.getPaymentType().getBytes("utf-8")));
                } else {
                    jsObject.put("paymentType", "");
                }
                if (payment.getPaymentAck() != null) {
                    jsObject.put("paymentAck", 
                            new String(payment.getPaymentAck().getBytes("utf-8")));
                } else {
                    jsObject.put("paymentAck", "");
                }
                if (payment.getCvqAck() != null) {
                    jsObject.put("cvqAck",
                            new String(payment.getCvqAck().getBytes("utf-8")));
                } else {
                    jsObject.put("cvqAck", "");
                }
                jsArray.add(jsObject);
            }
            response.getOutputStream().write(jsArray.toString().getBytes());
            response.setStatus(200);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            return null;
        }
        
        return null;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
