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
package fr.cg95.cvq.fo.common.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.StartupServlet;

/**
 * @author René le CLERCQ
 */
public class PrintRequestAction extends BaseAction {

	public ActionForward doExecute(
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {

        Long requestId = null;
        String href = "";
		Request cvqRequest = (Request)pRequest.getSession().getAttribute(Request.class.getName());
        if (cvqRequest != null) {
            requestId = cvqRequest.getId();
            href="processWizard.do";
        }

        if (requestId != null) {
            if (!isAuthentified(pRequest)) {
                LoginForm login = new LoginForm();
                login.setUserName(cvqRequest.getLogin());
                setCurrentEcitizen(login);
            }
            
            File data = StartupServlet.getTempContextFile(pRequest.getSession(), "tmp", ".pdf");
    		BusinessManager.getInstance().printRequest(data, requestId);
    
    		String pdf = StartupServlet.getFileContextName(pRequest,data);
    
    		if (!isOnTerminal(pRequest) && (null != pdf)) {
    
    			pRequest.setAttribute(URL, pdf);
    			pRequest.setAttribute(POPUP, "");
    			pRequest.setAttribute(HREF, href);
    
    			return pMapping.findForward(POPUP);
    		}
    		// Print the pdf file directly
    		addAutoPrint(data);
    		printPdf(pdf);
        }
		// GUI Wizard doesn't use the ActionForward
		return null;
	}

}