/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and René le Clercq 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.bo.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.record.PaperRecord;

/**
 * @author René le CLERCQ
 */
public class DocumentDisplayTag extends BaseTag {

	private static final long serialVersionUID = -2943138911549930885L;

	private String property;
	private String scope;

	public int doEndTag() {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			PaperRecord record = (PaperRecord) RequestUtils.lookup(pageContext, name, property, getScope());

			if (record != null) {
				// Load document data on demand
                HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
                HttpSession session = pageContext.getSession();
                
                // Load document data on demand
                if (record.getDataFile() == null)
                    BusinessManager.getDocumentData(session, record);

				if ((record.getDataFile() != null) && (record.getNbPages() > 1)) {
					request = (HttpServletRequest) pageContext.getRequest();
					String context = request.getContextPath();
					String query = request.getQueryString();

					String forward = "";
					if (query != null) {
                        int start = query.indexOf("forward=");
    					if (start != -1) {
    						int end = query.indexOf('&', start);
    						if (end == -1)
    							end = query.length();
    
    						forward = "&" + query.substring(start, end);
    					}
                    }
					String href = context + "/selectAction.do?select=paper" + forward + "&page=";
					int page = record.getPage();
					out.println("<div class=\"titre3\">");
					out.println(
						"<input type=\"button\" class=\"bouton\" onclick=\"document.location.href='"
							+ href
							+ (page - 1)
							+ "'\" value=\"<\"/>");
					out.println(
						"<input type=\"button\" class=\"bouton\" onclick=\"document.location.href='"
							+ href
							+ (page + 1)
							+ "'\" value=\">\"/>");
					out.println(" page " + (page + 1) + "/" + record.getNbPages());
					out.println("</div><br>");
				}

				out.println(
					"<img src=\""
						+ StartupServlet.getFileContextName(
							(HttpServletRequest) pageContext.getRequest(),
							record.getDataFile())
						+ "\" alt=\""
						+ record.getType()
						+ "\" width=\"700\" />");
			}

		} catch (Exception ignored) {
			ignored.getMessage();
		}
		return EVAL_PAGE;
	}

	public String getProperty() {
		return property;
	}

	public String getScope() {
		if (scope == null)
			scope = "session";

		return scope;
	}

	public void setProperty(String string) {
		property = string;
	}

	public void setScope(String string) {
		scope = string;
	}

}
