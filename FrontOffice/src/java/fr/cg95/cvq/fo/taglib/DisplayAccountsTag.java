package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.fo.account.action.AccountGroup;
import fr.cg95.cvq.fo.account.action.CaddyManager;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.fo.util.TimeHandler;
import fr.cg95.cvq.payment.PaymentUtils;

public class DisplayAccountsTag extends BaseTag {
    
    private String mode = null;

    private DecimalFormat formatter = new DecimalFormat("#,##0.00"); 
    
    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
            List<AccountGroup> accountGroups = (List<AccountGroup>) RequestUtils.lookup(pageContext, name, property, getScope());
            Payment caddy = (Payment)pageContext.getSession().getAttribute(Constants.CADDY);
            
            if (getMode().equals("groups"))
                writeGroups(out, accountGroups);
            
            else if (getMode().equals("accounts"))
                writeAccounts(out, accountGroups, caddy);
            
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    private void writeGroups(JspWriter out, List<AccountGroup> accountGroups) throws IOException {
        out.println("<ul class=\"list_type4\">");
        for (int g = 0; g < accountGroups.size(); g++) {
            AccountGroup group = accountGroups.get(g);
            out.println("  <li class=\"row\">");
            out.println("    <p class=\"item child\"><a href=\"managerWizard.do?group=" + g + "&transition=tickets\" title=\"\">" + group.getLabel() + "</a>");
            out.println("  </li>");
        }
        out.println("</ul>");
        
    }
    
    private void writeAccounts(JspWriter out, List<AccountGroup> accountGroups, Payment caddy) throws IOException {
        int index = 0;
        AccountGroup group = null;
        try {
            index = Integer.parseInt(pageContext.getRequest().getParameter("group"));
            group = accountGroups.get(index);

            out.println("<h1 class=\"title document\">CONTRATS DE : <strong>" + group.getLabel().toUpperCase() + "</strong></h1>");

        } catch (NumberFormatException nfe) {
            group = accountGroups.get(0);

            out.println("<h1 class=\"title document\">" + group.getLabel().toUpperCase() + "</h1>");
        }

        out.println("<table class=\"table_type6\">");
        out.println("  <tr>");
        out.println("    <th class=\"th th1\"><h1 class=\"title\">LIBELLE</h1></th>");
        out.println("    <th class=\"th th2\"><h1 class=\"title\">DATE</h1></th>");
        out.println("    <th class=\"th th3\"><h1 class=\"title\">VALEUR</h1></th>");
        out.println("    <th class=\"th th4\"><h1 class=\"title\">REFERENCE</h1></th>");
        out.println("    <th class=\"th th5\"><h1 class=\"title\">EN ATTENTE</h1></th>");
        out.println("  </tr>");
        out.println("</table>");

        int tr = 0;
        String trClass = null;
        out.println("<div class=\"overflow\">");
        out.println("  <table id=\"accounts\" class=\"table_type7\">");
        for (int i = 0; i < group.getAccounts().size(); i++) {
            ExternalAccountItem account = group.getAccounts().get(i);
            
            if (trClass == null)
                trClass = " class=\"tr_first\"";
            else
                trClass = "";

            String href = "javascript:openTableRow('accounts', " + tr + ")";

            out.println("  <tr" + trClass + ">");
            out.println("      <td class=\"td td1\"><p class=\"paragraph document\"><a href=\"" + href + "\" title=\"\">" + account.getLabel() + "</a></p></td>");
            out.println("      <td class=\"td td2\"><p class=\"paragraph\"><a href=\"" + href + "\" title=\"\">" + typeDate(account) + "</a></p></td>");
            out.println("      <td class=\"td td3\"><p class=\"paragraph\"><a href=\"" + href + "\" title=\"\">" + typeValue(account) + "</a></p></td>");
            out.println("      <td class=\"td td4\"><p class=\"paragraph\"><a href=\"" + href + "\" title=\"\">n° " + account.getExternalItemId() + "</a></p></td>");
            out.println("      <td class=\"td td5\"><p class=\"paragraph\"><a href=\"" + href + "\" title=\"\" class=\"caution\">" + typeCaddy(caddy, account) + "</a></p></td>");
            out.println("    </tr>");
            tr++;
            out.println("    <tr class=\"selected_notice\" style=\"display:none;\">");
            typeDetail(out, index, i, group, caddy, account);
            out.println("    </tr>");
            tr++;
        }
        out.println("    <tr class=\"tr_last\">");
        out.println("      <td colspan=\"5\" class=\"td\"></td>");
        out.println("    </tr>");
        out.println("  </table>");
        out.println("</div>");
    }
    
    private void typeDetail(JspWriter out, int groupId, int itemId, 
            AccountGroup group, Payment caddy, ExternalAccountItem account) throws IOException {
        String script = "validateRow('accounts', '" + groupId + "', '" + itemId;

        String caddyValue = caddyValue(caddy, account);
        if (caddyValue == null)
            caddyValue = "";
        
        if (account instanceof ExternalInvoiceItem) {
            script +=  "', '', 1)";

            out.println("      <td colspan=\"3\" class=\"td\"></td>");
            out.print("      <td colspan=\"2\" class=\"td\">");
            out.print("<p class=\"paragraph submit\">");
            out.println("<a href=\"javascript:" + script + "\" title=\"\">Régler cette facture</a></p></td>");

        } else if (account instanceof ExternalDepositAccountItem) {
            String id = "depot" + account.getExternalItemId();
            script +=  "', '" + id + "', 2)";

            out.print("      <td colspan=\"4\" class=\"td td1\">");
            out.print("<p class=\"paragraph\"> Montant en euros : ");
            out.print("<span class=\"input_inline\">");
            out.print("<input type=\"text\" id=\"" + id + "\" value=\"" + caddyValue + "\" />");
            out.println("</span> &euro;</p></td>");
            out.print("      <td class=\"td td5\">");
            out.print("<p class=\"paragraph submit\">");
            out.println("<a href=\"javascript:" + script + "\" title=\"\">Déposer</a></p></td>");

        } else if (account instanceof ExternalTicketingContractItem) {
            String id = "achat" + account.getExternalItemId();
            String unitPrice = formatter.format(((ExternalTicketingContractItem)account).getUnitPrice() / 100);
            script +=  "', '" + id + "', 3)";

            out.print("      <td colspan=\"4\" class=\"td td1\">");
            out.print("<p class=\"paragraph\"> Nombre de tickets à acheter : ");
            out.print("<span class=\"input_inline\">");
            out.print("<input type=\"text\" id=\"" + id + "\" value=\"" + caddyValue + "\" />");
            out.println("</span> (prix d'un ticket : " + unitPrice + " &euro;)</p></td>");
            out.print("      <td class=\"td td5\">");
            out.print("<p class=\"paragraph submit\">");
            out.println("<a href=\"javascript:" + script + "\" title=\"\">Acheter</a></p></td>");
        }
    }
    
    private void writeOldAccounts(JspWriter out, List<AccountGroup> accountGroups, Payment caddy) throws IOException {
        if (accountGroups != null) {
            for (int g = 0; g < accountGroups.size(); g++) {
                AccountGroup group = accountGroups.get(g);
                
                out.println("<div class=\"text\" style=\"margin-top:10px;\">");
                out.println(group.getLabel());
                out.println("</div>");
                
                out.print("<div style=\"width:100%;height:auto;\"><table id=\"" + group.getName() + "\" width=\"100%\" border=\"0\">");

                int tr = 0;

                typeHeader(out, group);
                tr++;
                
                int parity = 0;
                
                for (int i = 0; i < group.getAccounts().size(); i++) {
                    ExternalAccountItem account = group.getAccounts().get(i);
                    
                    String detail = "detail";
                    
                    parity++;
                    String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";
                    String href = "onclick=\"javascript:openTableRow('" + group.getName() + "', " + tr + ")\"";
                    out.println("<tr class=\"" + clazz + "\" " + href + ">");
                    out.println("<td class=\"" + detail + "\">" + account.getLabel() + "</td>");
                    out.println("<td>" + typeDate(account) + "</td>");
                    out.println("<td>" + typeValue(account) + "</td>");
                    out.println("<td>n° " + account.getExternalItemId() + "</td>");
                    out.println("<td>" + typeCaddy(caddy, account) + "</td>");
                    out.println("</tr>");
                    tr++;
                    
                    out.println("<tr style=\"display:none;\">");
                    out.println("<td colspan=\"2\">&nbsp;</td>");
                    out.println("<td colspan=\"3\">");
                    typeDetailOld(out, g, i, group, caddy, account);
                    out.println("</td>");
                    out.println("</tr>");
                    tr++;
                }
                out.println("</table></div>");
            }
        }
    }
    
    private void typeDetailOld(JspWriter out, int groupId, int itemId, 
            AccountGroup group, Payment caddy, ExternalAccountItem account) throws IOException {
        String script = "validateRow('" + group.getName() + "', '" + groupId + "', '" + itemId;

        String caddyValue = caddyValue(caddy, account);
        if (caddyValue == null)
            caddyValue = "";
        
        if (account instanceof ExternalInvoiceItem) {
            script +=  "', '', 1)";
            out.println("<div class=\"detail\" onclick=\"javascript:" + script + "\">Régler cette facture</div>");        

        } else if (account instanceof ExternalDepositAccountItem) {
            String id = "depot" + account.getExternalItemId();
            script +=  "', '" + id + "', 2)";
            out.println("Montant en euros : <input type=\"text\" id=\"" + id + "\" size=\"6\" value=\"" + caddyValue + "\"/> &euro;"); 
            out.println("<div class=\"detail\" onclick=\"javascript:" + script + "\">Déposer</div>");

        } else if (account instanceof ExternalTicketingContractItem) {
            String id = "achat" + account.getExternalItemId();
            String unitPrice = formatter.format(((ExternalTicketingContractItem)account).getUnitPrice() / 100);
            script +=  "', '" + id + "', 3)";

            out.println("Prix d'un ticket : " + unitPrice + " &euro;<br>");
            out.println("Nombre de tickets à acheter : <input type=\"text\" id=\"" + id + "\" size=\"6\" value=\"" + caddyValue + "\"/>");
            out.println("<div class=\"detail\" onclick=\"javascript:" + script + "\">Acheter</div>");
        }
    }
    
    private String typeCaddy(Payment caddy, ExternalAccountItem account) {
        String result = "&nbsp;";
        
        String caddyValue = caddyValue(caddy, account);

        if (caddyValue != null) {
            if (account instanceof ExternalDepositAccountItem)
                result = "Dépôt : " + caddyValue + " &euro;"; 
            
            else if (account instanceof ExternalInvoiceItem)
                result = "Facture : " + caddyValue + " &euro;"; 
    
            else if (account instanceof ExternalTicketingContractItem)
                result = "Achat : " + caddyValue + " tickets"; 
        }        
        return result;
    }

    private String caddyValue(Payment caddy, ExternalAccountItem account) {
        String result = null;
        ExternalAccountItem caddyItem = null;
        if (caddy != null)
            caddyItem = CaddyManager.findPurchase(caddy, account);
        
        if (caddyItem != null) {
            if (caddyItem instanceof ExternalDepositAccountItem)
                result = formatter.format(caddyItem.getAmount()/100); 
            
            else if (caddyItem instanceof ExternalInvoiceItem)
                result = formatter.format(caddyItem.getAmount()/100); 
    
            else if (caddyItem instanceof ExternalTicketingContractItem)
                result = ((ExternalTicketingContractItem)caddyItem).getQuantity().toString(); 
        }
        return result;
    }
    
    private void typeHeader(JspWriter out, AccountGroup group) throws IOException {
        out.print("<tr class=\"table-header\">");
        out.print("<td width=\"29%\"><b>Libellé</b></td>");
        out.print("<td width=\"14%\"><b>Date</b></td>");
        out.print("<td width=\"12%\"><b>Valeur</b></td>");
        out.print("<td width=\"26%\"><b>Référence</b></td>");
        out.print("<td width=\"19%\">&nbsp;</td>");
        out.println("</tr>");
    }
    
    private String typeDate(ExternalAccountItem account) {
        String result = "";
        if (account instanceof ExternalDepositAccountItem)
            result =  
                TimeHandler.parseDate(
                    ((ExternalDepositAccountItem)account).getOldValueDate(),TimeHandler.SHORT_DATE_FORMAT);
        
        else if (account instanceof ExternalInvoiceItem)
            result =  
                TimeHandler.parseDate(
                    ((ExternalInvoiceItem)account).getIssueDate(),TimeHandler.SHORT_DATE_FORMAT);
        
        else if (account instanceof ExternalTicketingContractItem)
            result =  
                TimeHandler.parseDate(
                    ((ExternalTicketingContractItem)account).getCreationDate(),TimeHandler.SHORT_DATE_FORMAT);
        
        return result;
    }
    
    private String typeValue(ExternalAccountItem account) {
        String result = "";
        if (account instanceof ExternalDepositAccountItem)
            result = 
                PaymentUtils.formatPrice(((ExternalDepositAccountItem)account).getOldValue().intValue()) + " &euro;"; 

        else if (account instanceof ExternalInvoiceItem)
            result = 
                PaymentUtils.formatPrice(((ExternalInvoiceItem)account).getAmount().intValue()) + " &euro;"; 

        else if (account instanceof ExternalTicketingContractItem) {

            if (((ExternalTicketingContractItem)account).getOldQuantity() < 0) {
                result = "<span style=\"color:red\">";
            } else {
                result = "<span>";
            }
            result += ((ExternalTicketingContractItem)account).getOldQuantity() + " tickets</span>";
        }        
        return result;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
}
