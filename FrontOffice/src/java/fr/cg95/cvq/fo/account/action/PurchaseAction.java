package fr.cg95.cvq.fo.account.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.CvqInvalidBrokerException;


public class PurchaseAction extends CaddyManager {

    private static Logger logger = Logger.getLogger(PurchaseAction.class);

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest request,
            HttpServletResponse pResponse) throws Exception {

        try {
            String action = request.getParameter("action");
            if ((action != null) && action.equals("remove"))
                removeSelectedItem(request);
            else 
                addSelectedItem(request);
            
        } catch (NumberFormatException e) {
            logger.error(logParameters(request), e);
            pResponse.setStatus(400);
        } catch (CvqInvalidBrokerException e) {
            if (e.getMessage().equals("payment.incompatible_broker"))
                pResponse.setStatus(502);
            else if (e.getMessage().equals("payment.missing_broker"))
                pResponse.setStatus(501);
        } catch (Exception e) {
            logger.error(logParameters(request), e);
            pResponse.setStatus(500);
        }
        return null;
    }

    private String logParameters(HttpServletRequest request) {
        String params = "Parameters: ";
        params += "group=" + request.getParameter("group") + ", ";
        params += "id=" + request.getParameter("id") + ", ";
        params += "value=" + request.getParameter("value");
        
        return params;
    }
    
    private void addSelectedItem(HttpServletRequest request) throws CvqException, NumberFormatException {
        List<AccountGroup> accountGroups = 
            (List<AccountGroup>) request.getSession().getAttribute("accountGroups");
        
        int groupId = Integer.parseInt(request.getParameter("group"));
        int id = Integer.parseInt(request.getParameter("id"));
        String value = request.getParameter("value");

        AccountGroup group = accountGroups.get(groupId);
        ExternalAccountItem item = group.getAccounts().get(id);
        if (item instanceof ExternalDepositAccountItem) {
            value = value.replaceAll(",", ".");
            Double amount = Double.valueOf(value) * 100;
            item.setAmount(amount);
            addPurchaseItem(request, item);
        } else if (item instanceof ExternalTicketingContractItem) {

            ExternalTicketingContractItem individualItem = (ExternalTicketingContractItem)item;
            
            int nbTickets = Integer.parseInt(value);
            if (nbTickets < individualItem.getMinBuy() || nbTickets > individualItem.getMaxBuy())
                throw new NumberFormatException();
            individualItem.setQuantity(nbTickets);
            addPurchaseItem(request, individualItem);
        } else if (item instanceof ExternalInvoiceItem) {
            ExternalInvoiceItem invoiceItem = (ExternalInvoiceItem) item;
            invoiceItem.setIsPaid(false);
            addPurchaseItem(request, invoiceItem);
        }
    }
    
    private void removeSelectedItem(HttpServletRequest request) {
        int line = Integer.parseInt(request.getParameter("line"));
        
        removePurchaseItem(request.getSession(), line);
    }
    
}
