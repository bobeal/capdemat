package fr.capwebct.modules.payment.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsDateJsonValueProcessor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.util.CurrencyUtil;
import fr.capwebct.modules.payment.util.DateUtil;

public class InvoiceController extends AbstractController {

    private IInvoiceService invoiceService;
    private IExternalApplicationService externalApplicationService;
    
   @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        request.getSession().setAttribute("currentMenu", "invoiceManagement");
            
        String action = request.getParameter("action");
        if (action == null) {
            ModelAndView mav = new ModelAndView("invoice");
            mav.addObject("externalApplications", externalApplicationService.getAll());
            mav.addObject("brokers", externalApplicationService.getAllBrokers());
            return mav;
        }
        
        JSONObject resultObject = new JSONObject();

        if (action.equals("loadInvoices")) {
            String results = request.getParameter("results");
            String startIndex = request.getParameter("startIndex");
            String sort = request.getParameter("sort");
            String dir = request.getParameter("dir");

            long externalApplicationId = 0;
            try {
                externalApplicationId = Long.valueOf(request.getParameter("externalApplicationId"));
            } catch (NumberFormatException nfe) {
                // so keep with zero
            }
            List<Invoice> invoices = null;
            try {
                invoices = invoiceService.search(request.getParameter("id"), request.getParameter("label"),
                        DateUtil.processDate(request.getParameter("paymentDateStart")), 
                        DateUtil.processDate(request.getParameter("paymentDateEnd")),
                        request.getParameter("efaId"), externalApplicationId,
                        request.getParameter("broker"),
                        Integer.valueOf(results), Integer.valueOf(startIndex), sort, dir);
                JSONArray resultArray = new JSONArray();
                for (Invoice invoice : invoices) {
                    JSONObject invoiceObject = new JSONObject();
                    invoiceObject.put("invoiceId", invoice.getInvoiceId());
                    invoiceObject.put("invoiceLabel", 
                            new String(invoice.getInvoiceLabel().getBytes("utf-8")));
                    invoiceObject.put("invoiceValue", CurrencyUtil.getFormattedAmount(invoice.getInvoiceValue()));
                    if (invoice.getInvoicePaymentDate() != null)
                    	invoiceObject.put("invoicePaymentDate", 
                    			new JsDateJsonValueProcessor().processArrayValue(invoice.getInvoicePaymentDate()));
                    else
                    	invoiceObject.put("invoicePaymentDate", "");
                    invoiceObject.put("invoicePaid", invoice.isInvoicePayed());
                    Payment payment = invoice.getPayment();
                    invoiceObject.put("paymentAck", payment != null ? payment.getPaymentAck() : "");
                    invoiceObject.put("broker", payment != null ? payment.getBroker() : "");
                    invoiceObject.put("externalFamilyAccountId", 
                            invoice.getExternalFamilyAccount().getExternalFamilyAccountId());
                    invoiceObject.put("externalApplicationLabel", 
                            invoice.getExternalFamilyAccount().getExternalApplication().getLabel());
                    invoiceObject.put("externalApplicationId", 
                            invoice.getExternalFamilyAccount().getExternalApplication().getId());
                    resultArray.add(invoiceObject);                    
                }
                resultObject.put("invoiceList", resultArray);
                resultObject.put("totalRecords", 
                        invoiceService.getCountForSearch(request.getParameter("id"), request.getParameter("label"),
                        DateUtil.processDate(request.getParameter("paymentDateStart")), 
                        DateUtil.processDate(request.getParameter("paymentDateEnd")),
                        request.getParameter("efaId"), externalApplicationId, request.getParameter("broker"))); 
            } catch (ParseException pe) {
                // TODO
            }
        }

        response.getOutputStream().write(resultObject.toString().getBytes());
        response.setStatus(200);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void setExternalApplicationService(IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
