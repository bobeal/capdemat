/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.security.SecurityContext;

/**
 * @author René le CLERCQ
 *  
 */
public class CloseSessionAction extends BaseAction {

	private static Logger logger = Logger.getLogger(CloseSessionAction.class);

	public ActionForward doExecute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		HttpSession session = request.getSession();
        

        LoginForm login = (LoginForm)request.getSession().getAttribute(BaseAction.AUTHENTIFICATION);

        // Logout the user
//        LassoServlet.singleSignOff(session, lasso.HTTP_METHOD_SOAP);

        cleanupSessionAttributes(session);
		session.invalidate();
		
		if (request.getParameter("close") != null)
            return mapping.findForward(Constants.CLOSE);
        
        // forward to the appropriate view
		if ((login != null) && login.getContext().equals(SecurityContext.BACK_OFFICE_CONTEXT))
            return mapping.findForward(Constants.CLOSE);
        
        return mapping.findForward(Constants.SUCCESS);

	}

	public ActionForward execute(
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {
		return doExecute(pMapping, pForm, pRequest, pResponse);
	}

}