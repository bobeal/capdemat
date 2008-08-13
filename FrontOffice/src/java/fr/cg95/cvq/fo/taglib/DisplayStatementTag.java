package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.account.action.StatementLine;
import fr.cg95.cvq.fo.common.action.BaseAction;

public class DisplayStatementTag extends BaseTag {

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
            List<StatementLine> statement = null;
            try {
                statement = (List<StatementLine>) RequestUtils.lookup(pageContext, name, property, getScope());

                writeNewStatement(out, statement);
            } catch (Exception e) {
            }

        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    private void writeNewStatement(JspWriter out, List<StatementLine> statement) throws IOException {
        if (statement != null) {
            out.println("<table class=\"table_type4\">");

            out.println("<tr>");
            out.println("  <th class=\"th th1\"><h1 class=\"title\">DATE</h1></th>");
            out.println("  <th class=\"th th2\"><h1 class=\"title\">TYPE</h1></th>");
            out.println("  <th class=\"th th3\"><h1 class=\"title\">LIBELLE</h1></th>");
            out.println("  <th class=\"th th4\"><h1 class=\"title\">MONTANT</h1></th>");
            out.println("</tr>");
            out.println("</table>");

            out.println("<div class=\"overflow\">");
            out.println("<table id=\"statement\" class=\"table_type5\">");

            int tr = 0;
            String trClass = null;
            for (int i = 0; i < statement.size(); i++) { 
                StatementLine line = statement.get(i);

                if (trClass == null)
                    trClass = " class=\"tr_first\"";
                else
                    trClass = "";

                out.println("  <tr" + trClass + ">");
                out.println("    <td class=\"td td1\"><p class=\"paragraph\">" +
                        "<a href=\"javascript:openTableRow('statement', " + tr + ")\" title=\"\">" + line.getDate() + "</a></p></td>");
                out.println("    <td class=\"td td2\"><p class=\"paragraph document\">" +
                        "<a href=\"javascript:openTableRow('statement', " + tr + ")\" title=\"\">" + line.getType() + "</a></p></td>");
                out.println("    <td class=\"td td3\"><p class=\"paragraph\">" +
                        "<a href=\"javascript:openTableRow('statement', " + tr + ")\" title=\"\">" + line.getLabel() + "</a></p></td>");
                out.println("    <td class=\"td td4\"><p class=\"paragraph\">" +
                        "<a href=\"javascript:openTableRow('statement', " + tr + ")\" title=\"\">" + line.getAmount() + " &euro;</a></p></td>");
                out.println("  </tr>");
                tr++;
                out.println("  <tr class=\"selected_notice\" style=\"display:none;\">");
                out.println("    <td colspan=\"4\" class=\"td\"><table class=\"paragraph\">");

                List<StatementLine> details = line.getDetail();
                for (int l = 0; l < details.size(); l++) {
                    StatementLine detailLine = details.get(l);
                    out.print("<tr><td>");
                    out.print(detailLine.getLabel() + "</td><td>" + detailLine.getValue());
                    out.println("</td></tr>");
                }
                out.println("</table></td>");
                out.println("  </tr>");
                tr++;
            }
            out.println("  <tr class=\"tr_last\">");
            out.println("    <td colspan=\"4\" class=\"td\"></td>");
            out.println("  </tr>");
            out.println("</table>");
            out.println("</div>");
        }
    }
    
    private void writeOldStatement(JspWriter out, List<StatementLine> statement) throws IOException {
        if (statement != null) {
            out.print("<table id=\"statement\" width=\"100%\" border=\"0\">");
            
            int tr = 0;
            out.print("<tr class=\"table-header\">");
            out.print("<td width=\"20%\"><b>Date</b></td>");
            out.print("<td width=\"15%\"><b>Type</b></td>");
            out.print("<td width=\"55%\"><b>Libellé</b></td>");
            out.print("<td width=\"10%\"><b>Montant</b></td>");
            out.println("</tr>");

            int parity = 0;
            
            for (int i = 0; i < statement.size(); i++) { 
                StatementLine line = statement.get(i);

                String detail = "detail";
                parity++;

                tr++;
                String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";
                String href = "onclick=\"javascript:openTableRow('statement', " + tr + ")\"";
                out.println("<tr class=\"" + clazz + "\" " + href + ">");
                out.println("<td class=\"" + detail + "\">" + line.getDate() + "</td>");
                out.println("<td>" + line.getType() + "</td>");
                out.println("<td>" + line.getLabel() + "</td>");
                out.println("<td align=\"right\">" + line.getAmount() + " &euro;</td>");
                out.println("</tr>");
                
                tr++;
                out.println("<tr style=\"display:none;\">");
                out.println("<td>&nbsp;</td>");
                out.println("<td colspan=\"2\">");
                out.println("<table width=\"100%\" border=\"0\">");
                
                List<StatementLine> details = line.getDetail();
                for (int l = 0; l < details.size(); l++) {
                    StatementLine detailLine = details.get(l);
                    out.println("<tr>");
                    out.println("<td width=\"35%\">" + detailLine.getLabel() + "</td>");
                    out.println("<td align=\"left\">" + detailLine.getValue() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }
}
