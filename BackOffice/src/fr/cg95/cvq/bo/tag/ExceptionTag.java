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
package fr.cg95.cvq.bo.tag;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.action.ErrorAction;
import fr.cg95.cvq.exception.CvqRemoteException;

/**
 */
public class ExceptionTag extends TagSupport {

    public static final String ID = "fr.cg95.cvq.bo.tag.ExceptionTag";

    private static final long serialVersionUID = -1472075552994806698L;

    private MessageResources messageResources = MessageResources.getMessageResources("ApplicationResourcesBO");
    
	/**
	 */
	public ExceptionTag() {
		super();
	}

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			
			Throwable ex = (Throwable)request.getAttribute(ID);
			if (ex == null)
				ex = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");

			if (ex == null)
				ex = (Throwable)request.getAttribute("javax.servlet.error.exception");
				
			if (ex != null) {
                String message = "";
                if (ex instanceof CvqRemoteException) {
                    message = "Un service externe n'est pas en mesure de traiter la demande.";

                } else {
                    message = messageResources.getMessage(ex.getMessage());
                    if (message == null)
                        message = ex.getMessage();
                }
                if (message != null) {
                    out.println("<p>");
                    out.println(message);
                    out.println("</p>");
                }                
				out.println("<!--");
				while (ex != null) {
					message = (ex.getMessage() == null)? "" : ex.getMessage(); 
					out.println(ex.getClass() + ": " + message);
					
					StackTraceElement elements[] = ex.getStackTrace();
					
					int i = 0;
					while ((i < elements.length) && !elements[i].getClassName().startsWith("fr.cg95.cvq")) {
						out.println(" at " + displayElement(elements[i]));
						i++;
					}
					while ((i < elements.length) && elements[i].getClassName().startsWith("fr.cg95.cvq")) {
						out.println(" at " + displayElement(elements[i]));
						i++;
					}
					ex = ex.getCause();
				}
                out.println("-->");
                
			} else if (request.getAttribute("javax.servlet.error.status_code") != null){
				Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
				
				String message = (String)request.getAttribute("javax.servlet.error.message");
				
				out.println("<p>");
				if (statusCode != null)
					out.println("HTTP Error " + statusCode.toString() + "<br>");
					
				if (message != null)
					out.println(message);

			} else if (request.getAttribute("org.apache.struts.action.ERROR") != null) {
				ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
				Iterator iter = errors.get();
				while (iter.hasNext()) {
					ActionError error = (ActionError)iter.next();

					out.println("<p>");
					out.println(RequestUtils.message(pageContext, null, null,error.getKey()));
				}
			}
			
            request.removeAttribute(ID);
            
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
