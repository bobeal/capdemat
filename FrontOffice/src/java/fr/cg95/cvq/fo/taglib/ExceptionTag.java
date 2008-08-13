/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
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
package fr.cg95.cvq.fo.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 */
public class ExceptionTag extends TagSupport {

	/**
	 */
	public ExceptionTag() {
		super();
	}

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			
			Throwable ex = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");
			if (ex == null)
				ex = (Throwable)request.getAttribute("javax.servlet.error.exception");
				
			if (ex != null) {
				out.println("<p>");
				out.println("EXCEPTION STACKTRACE");
				out.println("<p>");
				while (ex != null) {
					String message = (ex.getMessage() == null)? "" : ex.getMessage(); 
					out.println(ex.getClass() + ": " + message + "<p>");
					
					StackTraceElement elements[] = ex.getStackTrace();
					
					int i = 0;
					while ((i < elements.length) && !elements[i].getClassName().startsWith("fr.cg95.cvq")) {
						out.println(" at " + displayElement(elements[i]) + "<p>");
						i++;
					}
					while ((i < elements.length) && elements[i].getClassName().startsWith("fr.cg95.cvq")) {
						out.println(" at " + displayElement(elements[i]) + "<p>");
						i++;
					}
					ex = ex.getCause();
				}
			} else {
				Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
				String message = (String)request.getAttribute("javax.servlet.error.message");
				
				out.println("<p>");
				if (statusCode != null)
					out.println("HTTP Error " + statusCode.toString() + "<br>");
					
				if (message != null)
					out.println(message);
			}
			
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

	private String displayElement(StackTraceElement element) {
		return 	element.getClassName() + "." + 
						element.getMethodName()+ "(" + 
						element.getFileName() + ":" + 
						element.getLineNumber() + ")";
	}
	
}
