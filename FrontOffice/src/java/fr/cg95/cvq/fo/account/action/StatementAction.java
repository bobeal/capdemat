package fr.cg95.cvq.fo.account.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.users.IHomeFolderService;

public class StatementAction extends BasePersonalAction {

    private static Logger _logger = Logger.getLogger(StatementAction.class);

    private DecimalFormat formatter = new DecimalFormat("#,##0.00"); 

    public ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse)
        throws Exception {

        _logger.debug("doExecute");

// TODO Comments to be removed when Horanet is treating statement lines for Parmain and Franconville
        List<StatementLine> lines = new ArrayList<StatementLine>();
        
        IHomeFolderService homeFolderService = 
            BusinessManager.getInstance().getHomeFolderService();
        Set accounts = 
            homeFolderService.getExternalAccounts(SessionManager.getFamilyHome(pRequest).getId(), 
                    IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS);
        for (Iterator i = accounts.iterator(); i.hasNext();) {
            ExternalDepositAccountItem item = (ExternalDepositAccountItem)i.next();
            homeFolderService.loadExternalDepositAccountDetails(item);
            Set<ExternalDepositAccountItemDetail> details = item.getAccountDetails();
            if (details != null)
                for (Iterator<ExternalDepositAccountItemDetail> j = details.iterator(); j.hasNext();) {
                    ExternalDepositAccountItemDetail detail = j.next();
                    StatementLine line = new StatementLine();
                    line.setDate(detail.getDate());
                    line.setType("Dépôt");
                    line.setLabel(item.getLabel());
                    line.setAmount(detail.getValue() / 100.0);
                    
                    StatementLine detailLine = new StatementLine();
                    detailLine.setLabel("Référence");
                    detailLine.setValue(detail.getPaymentId());
                    
                    line.addDetail(detailLine);

                    detailLine = new StatementLine();
                    detailLine.setLabel("Type");
                    detailLine.setValue(detail.getPaymentType());
                    
                    line.addDetail(detailLine);

                    detailLine = new StatementLine();
                    detailLine.setLabel("Montant");
                    detailLine.setValue(formatter.format(detail.getValue() / 100.0) + " &euro;");
                    
                    line.addDetail(detailLine);

                    lines.add(line);
                }
        }
        
        Set invoices = 
            homeFolderService.getExternalAccounts(SessionManager.getFamilyHome(pRequest).getId(), 
                    IPaymentService.EXTERNAL_INVOICES);
        for (Iterator i = invoices.iterator(); i.hasNext();) {
            ExternalInvoiceItem item = (ExternalInvoiceItem)i.next();
            if (item.isPaid()) {
                StatementLine line = new StatementLine();
                line.setDate(item.getPaymentDate());
                line.setType("Facture");
                line.setLabel(item.getLabel());
                line.setAmount(item.getEuroAmount());
                
                lines.add(line);
                
                StatementLine detailLine = new StatementLine();
                detailLine.setLabel("Référence");
                detailLine.setValue(item.getExternalItemId());
                
                line.addDetail(detailLine);

                homeFolderService.loadExternalInvoiceDetails(item);
                Set<ExternalInvoiceItemDetail> details = item.getInvoiceDetails();
                if (details != null)
                    for (Iterator<ExternalInvoiceItemDetail> j = details.iterator(); j.hasNext();) {
                        ExternalInvoiceItemDetail detail = j.next();
                        detailLine = new StatementLine();
                        detailLine.setLabel(detail.getLabel());
                        detailLine.setValue(formatter.format(detail.getValue() / 100.0) + " &euro;");
                        
                        line.addDetail(detailLine);
                    }
            }
        }
        Collections.sort(lines);
        
        pRequest.setAttribute("statement", lines);
//        pRequest.setAttribute("error", "Les relevés de comptes détaillés seront prochainement disponibles.");
        return null;
    }
}
