package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.util.Constants;

public class DisplayCaddyTag extends BaseTag {

    private DecimalFormat formatter = new DecimalFormat("#,##0.00"); 

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
            Payment caddy = (Payment)pageContext.getSession().getAttribute(Constants.CADDY);
            
            writeCaddy(out, caddy);
            
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    private void writeCaddy(JspWriter out, Payment caddy) throws IOException {
        out.println("<table class=\"table_type8h\">");
        out.println("  <tr>");
        out.println("    <th class=\"th th1\"><h1 class=\"title\">REFERENCE</h1></th>");
        out.println("    <th class=\"th th2\"><h1 class=\"title\">LIBELLE</h1></th>");
        out.println("    <th class=\"th th3\"><h1 class=\"title\">VALEUR</h1></th>");
        out.println("    <th class=\"th th4\"><h1 class=\"title\"></h1></th>");
        out.println("  </tr>");
        out.println("</table>");

        String trClass = null;
        int i = 0;

        out.println("<div class=\"overflow\">");
        out.println("  <table class=\"table_type8\">");

        Iterator iter = caddy.getPurchaseItems().iterator();
        while (iter.hasNext()) {
            ExternalAccountItem purchaseItem = (ExternalAccountItem) iter.next();

            if (trClass == null)
                trClass = " class=\"tr_first\"";
            else
                trClass = "";
            
            out.println("    <tr" + trClass + ">");
            out.println("      <td class=\"td td1\"><p class=\"paragraph document\">N° : " + purchaseItem.getExternalItemId() + "</p></td>");
            out.println("      <td class=\"td td2\"><p class=\"paragraph\">" + purchaseItem.getLabel() + "</p></td>");
            out.println("      <td class=\"td td3\"><p class=\"paragraph\">" + formatter.format(purchaseItem.getEuroAmount()) + " &euro;</p></td>");
            out.println("      <td class=\"td td4\"><p class=\"paragraph\"><a href=\"purchase.do?action=remove&transition=caddy&line=" + i + "\" title=\"\">supprimer</a></p></td>");
            out.println("    </tr>");
            i++;
        }
        out.println("    <tr class=\"tr_none\">");
        out.println("      <td class=\"td td1\"></td>");
        out.println("      <td class=\"td td2\"></td>");
        out.println("      <td class=\"td td3\"></td>");
        out.println("      <td class=\"td td4\"></td>");
        out.println("    </tr>");
        out.println("    <tr class=\"tr_last\">");
        out.println("      <td class=\"td td1\"></td>");
        out.println("      <td class=\"td td2\"><p class=\"paragraph\">TOTAL</p></td>");
        out.println("      <td class=\"td td3\"><p class=\"paragraph caution\">" + formatter.format(caddy.getEuroAmount()) + " &euro;</p></td>");
        out.println("      <td class=\"td td4\"></td>");
        out.println("    </tr>");
        out.println("  </table>");
        out.println("</div>");
    }
    
    private void writeOldCaddy(JspWriter out, Payment caddy) throws IOException {
        out.println("<table width=\"90%\">");
        int i = 0;
        Iterator iter = caddy.getPurchaseItems().iterator();
        while (iter.hasNext()) {
            PurchaseItem purchaseItem = (PurchaseItem) iter.next();
            out.println("<tr>");
            out.println("<td class=\"text_bis\">");
            out.println(purchaseItem.getFriendlyLabel());
            out.println("</td>");
            out.println("<td class=\"text\" align=\"right\">");
            out.println(formatter.format(purchaseItem.getEuroAmount()));
            out.println("</td>");
            out.println("<td class=\"text_bis\">");
            out.println("&euro;");
            out.println("</td>");
            out.println("<td class=\"text\">");
            out.println("<a href=\"purchase.do?action=remove&transition=caddy&line=" + i + "\">supprimer</a>");
            out.println("</td>");
            out.println("</tr>");
            i++;
        }
        out.println("<tr>");
        out.println("<td colspan=\"2\" class=\"text\" align=\"right\">");
        out.println("--------");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"text\" align=\"right\">");
        out.println("Total:");
        out.println("</td>");
        out.println("<td class=\"text\" align=\"right\">");
        out.println(formatter.format(caddy.getEuroAmount()));
        out.println("</td>");
        out.println("<td class=\"text_bis\">");
        out.println("&euro;");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
    }
    
}
