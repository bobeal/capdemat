/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq 
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

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.manager.ProfileManager;

public class DateTag extends BaseTag {

	private static final long serialVersionUID = -7754915785811344317L;

	private String period = null;
		
	public int doEndTag() throws JspException {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			if (period != null)
				writePeriod(out);
			else
				writeDate(out);

		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}
	
	private void writeDate(JspWriter out) throws IOException, JspException {
		String value = null;
		try {
			value = (String)RequestUtils.lookup(pageContext, name, property, getScope());
		} catch (JspException je) {
		}
		if (value == null) value = "";

		ProfileManager profileManager = getProfileManager();

		out.println("<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">");
		out.println("<tr>");
		out.print("<td><input type=\"text\" name=\"" + property + "\" id=\"" + property + "\" value=\"" + value + "\"");
		if (styleClass != null)
			out.print(" class=\"" + styleClass + "\"");
		if (profileManager != null) {
			if (profileManager.isReadonly())
				out.print(" disabled");
		}
		out.println(" width='126'></td>");
		out.print("<td valign=\"middle\"><div class=\"link\" ");
		if ((profileManager == null) || !profileManager.isReadonly())
				out.print("onclick=\"fShowTable(event,'" + property + "');\" style=\"position:relative;\"");
		out.print(">");
		out.print("<img src=\"img/calendar/c_b.gif\" border=\"0\" alt=\"\"/>");
		out.println("</div>");
		out.println("<div id=ecran></div>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}

	public void writePeriod(JspWriter out) throws IOException {
		String value = null;
		try {
			value = (String)RequestUtils.lookup(pageContext, name, property + "Begin", getScope());
		} catch (JspException je) {
		}
		if (value == null) value = "";
		
		out.println("<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">");
		out.println("<tr>");
		out.print("<td><input type=\"text\" name=\"" + property + "Begin\" id=\"" + property + "Begin\" value=\"" + value + "\"");
		if (styleClass != null)
			out.print(" class=\"" + styleClass + "\"");
		out.println(" width='126'></td>");
		out.print("<td valign=\"middle\"><div class=\"link\" onclick=\"fShowTable(event,'" + property + "Begin');\" style=\"position:relative;\">");
		out.print("<img src=\"img/calendar/c_b.gif\" border=\"0\" alt=\"\"/>");
		out.println("</div>");
		out.println("</td>");

		out.println("<td class=\"titre3\">&nbsp;&nbsp;au&nbsp;&nbsp;</td>");

		value = null;
		try {
			value = (String)RequestUtils.lookup(pageContext, name, property + "End", getScope());
		} catch (JspException je) {
		}
		if (value == null) value = "";

		out.print("<td><input type=\"text\" name=\"" + property + "End\" id=\"" + property + "End\" value=\"" + value + "\"");
		if (styleClass != null)
			out.print(" class=\"" + styleClass + "\"");
		out.print(" width='126'></td>");
		out.print("<td valign=\"middle\"><div class=\"link\" onclick=\"fShowTable(event,'" + property + "End');\" style=\"position:relative;\">");
		out.print("<img src=\"img/calendar/c_b.gif\" border=\"0\" alt=\"\"/>");
		out.println("</div>");
		out.println("<div id=ecran></div>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}
			
	public String getPeriod()  {
		return period;
	}

	public void setPeriod(String string) {
		period = string;
	}

	/**
	 */
	public String getProperty() {
		return property;
	}

	/**
	 */
	public String getScope() {
		if (scope == null)
			scope = "session";
			
		return scope;
	}

	/**
	 */
	public void setProperty(String string) {
		property = string;
	}

	/**
	 */
	public void setScope(String string) {
		scope = string;
	}

}
