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

package fr.cg95.cvq.fo.personal.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

/**
 * @author René le CLERCQ
 */
public class ResetPasswordAction extends BaseAction {

	protected ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		LoginForm loginForm = (LoginForm) form;
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        request.getSession().removeAttribute(LOGIN_ERROR_KEY);

        if (request.getParameter("cancel") == null) {
            if (familyHome.getLogin().getAcknowledge().equals(loginForm.getAnswer())) {
    			request.getSession().setAttribute(
    				LOGIN_ERROR_KEY,
    				BusinessManager.getInstance().resetPassword(
                            SessionManager.getRequestManager(request), familyHome.getLogin().getAdultId()));
    		} else {
                request.setAttribute("ResetPassword", "");
    			request.getSession().setAttribute(LOGIN_ERROR_KEY, RESET_PASSWORD_VALUE);
    		}
        }
		loginForm.setUserName(familyHome.getLogin().getUserName());
		loginForm.setPassword(null);
		request.setAttribute("loginForm", loginForm);

        if (ProcessWizardState.getWizardState(request) != null)
            return mapping.findForward("processlogin");

        return mapping.findForward("login");
	}

}
