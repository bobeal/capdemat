/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 * Object : Display the list of request in the personal space
 */
package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.action.BaseAction;

/**
 */
public class DisplayRequestsTag extends BaseTag {
    private final static int MAX_LINES = 4;
    
	private String title;
    private String mode;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
			Object[] requests = null;
			try {
				Collection collection = (Collection) RequestUtils.lookup(pageContext, name, property, getScope());
				requests = collection.toArray();

                Arrays.sort(requests,new RequestsComparator());
                    
			} catch (Exception e) {
			}
            out.println("<script type=\"text/javascript\">\n");
            out.println("function printRequest(id) {\n");
            out.println("    var cancelWindow = window.confirm('Voulez-vous imprimer la demande avec le numéro '+ id +'?');\n");
            out.println("    if (null != cancelWindow) {\n");
            out.println("        if (true == cancelWindow) {\n");
            out.println("            document.location.href = 'personalPrintAction.do?id=' + id;\n");
            out.println("        }\n");
            out.println("    }\n");
            out.println("}\n");
            out.println("</script>\n");

            if (mode == null) {
                writeOldGui(out, requests);

            } else if (mode.equals("all")) {
                writeNewGui(out, requests);

            } else if (mode.equals("summary")) {
                writeSummary(out, requests);
            }
            
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

    private void writeOldGui(JspWriter out, Object[] requests) throws IOException {
        
        out.print("<table width=\"100%\" border=\"0\">");

        out.print("<caption>");
        out.print("<strong>");
        out.print(title);
        out.print("</strong>");
        out.print("</caption>");
        out.print("<tr class=\"table-header\">");
        out.print("<td width=\"12%\"><b>Numéro</b></td>");
        out.print("<td width=\"20%\"><b>Type</b></td>");
        out.print("<td width=\"20%\"><b>Personne</b></td>");
        out.print("<td width=\"23%\"><b>Créée le</b></td>");
        out.print("<td width=\"15%\"><b>Etat</b></td>");
        out.print("</tr>");

        if (requests != null) {
            int parity = 0;
            for (int i = 0; i < requests.length; i++) {
                Request request = (Request)requests[i];
                parity++;
                String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";

                out.println("<tr class=\"" + clazz + "\" " + onclick(request.getId()) + ">");
                out.println("<td class=\"detail\">" + request.getId() + "</td>");
                out.println("<td>" + request.getType() + "</td>");
                out.println("<td>" + notNull(request.getSubjectName()) + "</td>");
                out.println("<td>" + request.getCreationDate() + "</td>");
                out.println("<td>" + request.getState() + "</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
    }
    
    private void writeNewGui(JspWriter out, Object[] requests) throws IOException {
        
        out.println("<div class=\"block_type6_header\">");
        out.println("<table class=\"table_type1\">");
        out.println("<tr>");
        out.println("  <th class=\"th th1\"><h1 class=\"title\">" + "Numéro".toUpperCase() + "</h1></th>");
        out.println("  <th class=\"th th2\"><h1 class=\"title\">TYPE</h1></th>");
        out.println("  <th class=\"th th3\"><h1 class=\"title\">" + "Créee le".toUpperCase() + "</h1></th>");
        out.println("  <th class=\"th th4\"><h1 class=\"title\">" + "Personne concernée".toUpperCase() + "</h1></th>");
        out.println("  <th class=\"th th5\"><h1 class=\"title\">" + "état".toUpperCase() + "</h1></th>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</div>");

        if (requests != null) {
            out.println("<div class=\"block_type6\">");
            out.println("<table class=\"table_type1\">");
            for (int i = 0; i < requests.length; i++) {
                Request request = (Request)requests[i];
                int status = getStatusValue(request.getState());
                String pictoClass = "paragraph document_ok custom_color";
                String paragraph = "paragraph custom_color";    
                if (status < 0) {
                    pictoClass = "paragraph document_error caution";
                    paragraph = "paragraph caution";    
                }
                out.println("<tr>");
                out.println("  <td class=\"td td1\"><p class=\"" + pictoClass + "\"><a href=\"" + href(request.getId()) + "\" title=\"\">" + request.getId() + "</a></p></td>");
                out.println("  <td class=\"td td2\"><p class=\"" + paragraph + "\">" + request.getType() + "</p></td>");
                out.println("  <td class=\"td td3\"><p class=\"" + paragraph + "\">" + request.getCreationDate() + "</p></td>");
                out.println("  <td class=\"td td4\"><p class=\"" + paragraph + "\">" + notNull(request.getSubjectName()) + "</p></td>");
                out.println("  <td class=\"td td5\">");
                out.println("    <ul class=\"list_status\">\n" + getStatus(status) + "</ul>");
                out.println("  </td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
        }
    }
    
    private void writeSummary(JspWriter out, Object[] requests) throws IOException {
        
        if (requests != null) {
            out.println("<ul class=\"list_type3\">");
            
            int nbLines = Math.min(requests.length, MAX_LINES);
            for (int i = 0; i < nbLines; i++) {
                Request request = (Request)requests[i];
                
                int status = getStatusValue(request.getState());
                String pictoClass = "item document";
                if (status < 0)
                    pictoClass = "item document_error error";
                else if (status == 4)
                    pictoClass = "item document_ok";

                out.println("  <li class=\"row\">");
                out.println("    <ul class=\"list_status\">\n" + getStatus(status) + "</ul>");
                out.println("    <p class=\"" + pictoClass + "\"><a href=\"managerWizard.do?tab=3\" title=\"\">" + request.getType() + "</a></p>");
                out.println("  </li>");
            }
            out.println("</ul>");
        }
    }
    
    private String onclick(Long id) {
        if (isOnTerminal((HttpServletRequest)pageContext.getRequest()))
            return "onclick=\"printRequest(" + id + ")\"";
        else
            return "onclick=\"document.location.href='personalPrintAction.do?id=" + id + "'\"";
//        return "";
    }
    
    private String href(Long id) {
        if (isOnTerminal((HttpServletRequest)pageContext.getRequest()))
            return "javascript:printRequest(" + id + ");";
        else
            return "personalPrintAction.do?id=" + id;
    }
    
    private int getStatusValue(String status) {
        if (status.equals("En attente"))
            return 1;

        if (status.equals("Complet"))
            return 2;

        if (status.equals("Validé"))
            return 3;

        if (status.equals("Notifié"))
            return 4;

        if (status.equals("Active"))
            return 0;

        if (status.equals("Expiré"))
            return -5;

        if (status.equals("Fermé"))
            return 0;

        if (status.equals("Archivé"))
            return 0;

        if (status.equals("Refusé"))
            return -1;

        if (status.equals("Incomplet"))
            return -2;

        if (status.equals("Annulé"))
            return 0;

        return 0;
    }
    
    private String getStatus(int status) {
        String result = "";
        
        if (status > 0)
            result += "      <li class=\"status status01\"></li>\n";
        else
            result += "      <li class=\"status status\"></li>\n";
            
        if (status > 1)
            result += "      <li class=\"status status02\"></li>\n";
        else if (status < 0)
            result += "      <li class=\"status caution\"></li>\n";
        else
            result += "      <li class=\"status status\"></li>\n";
            
        if (status > 2)
            result += "      <li class=\"status status03\"></li>\n";
        else
            result += "      <li class=\"status status\"></li>\n";
            
        if (status > 3)
            result += "      <li class=\"status ok\"></li>\n";
        else
            result += "      <li class=\"status status\"></li>\n";
        
        return result;
    }
    
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param pTitle
	 *            The title to set.
	 */
	public void setTitle(String pTitle) {
		title = pTitle;
	}

	private class RequestsComparator implements Comparator {
		public RequestsComparator() {
		}

		public int compare(Object o1, Object o2) {
			// get the values to compare
			if (o1 == null) {
				if (o2 == null)
					return 0;
				return 1;
			} else if (o2 == null) {
				return -1;
			} else if ((o1 instanceof Request) && (o2 instanceof Request)) {
				Long id1 = ((Request)o1).getId();
				Long id2 = ((Request)o2).getId();

				return id2.compareTo(id1);
			}
			return 0;
		}
	}

    private boolean hasCookie(HttpServletRequest pRequest, String pName) {
        Cookie cookies[] = pRequest.getCookies();
        if (cookies == null)
            return false;

        int i = 0;
        while ((i < cookies.length) && !cookies[i++].getName().equals(pName))
            ;

        return (i < cookies.length);
    }

    private boolean isOnTerminal(HttpServletRequest pRequest) {
        return hasCookie(pRequest, COOKIE_NAME);
    }

    private String notNull(String value) {
        return (value == null) ? "" : value;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}