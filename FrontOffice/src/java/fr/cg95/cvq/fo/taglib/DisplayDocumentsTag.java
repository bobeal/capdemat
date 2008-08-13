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
 */
package fr.cg95.cvq.fo.taglib;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;

/**
 */
public class DisplayDocumentsTag extends BaseTag {

	protected String _title;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
			Collection documents = null;
			try {
				documents = (Collection) RequestUtils.lookup(pageContext, name, property, getScope());
			} catch (Exception e) {
			}

            out.print("<table width=\"100%\" border=\"0\">");

			out.print("<caption>");
			out.print("<strong>");
			out.print(_title);
			out.print("</strong>");
			out.print("</caption>");
			out.print("<tr class=\"table-header\">");
            out.print("<td width=\"35%\"><b>Nature du justificatif</b></td>");
            out.print("<td width=\"25%\"><b>Personne</b></td>");
            out.print("<td width=\"10%\"><b>Etat</b></td>");
            out.print("<td width=\"10%\"><b>Expire le</b></td>");
            out.print("<td width=\"10%\"><b>Validé le</b></td>");
            out.print("<td width=\"10%\"><b>Déposé le</b></td>");
			out.print("</tr>");

			if (documents != null) {

				Iterator it = documents.iterator();

				int parity = 0;
				while (it.hasNext()) {
					DocumentForm document = (DocumentForm) it.next();
                    String detail = "detail";
                    if (document.isCertified())
                        detail = "certified";
                    
					parity++;
					String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";
					String href = "onclick=\"document.location.href='documentDisplayAction.do?transition=displayall&id=" + document.getId() + "'\"";
                    out.println("<tr class=\"" + clazz + "\" " + href + ">");
                    out.println("<td class=\"" + detail + "\">" + document.getType() + "</td>");
                    out.println("<td>" + document.getPersonName() + "</td>");
                    out.println("<td>" + document.getState() + "</td>");
                    out.println("<td>" + document.getExpirationDate() + "</td>");
                    out.println("<td>" + document.getValidationDate() + "</td>");
                    out.println("<td>" + document.getSubmissionDate() + "</td>");
					out.println("</tr>");
				}

			}
			out.println("</table>");
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param pTitle
	 *            The title to set.
	 */
	public void setTitle(String pTitle) {
		_title = pTitle;
	}

}