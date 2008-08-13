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

package fr.cg95.cvq.fo.personal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class ChangePasswordAction extends BasePersonalAction {

	protected ActionForward doExecute(
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {

        LoginForm loginForm = (LoginForm) pForm;

        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);
		if (pRequest.getParameter("changepassword") == null) {
		    if ( pRequest.getParameter("oldPassword") != null) {
        
        		try {
        			BusinessManager.changePassword(
        				familyHome.getFamilyHomeResponsible().getId(),
        				loginForm.getOldPassword(),
        				loginForm.getPassword());
                    
                    ManagerWizardState wizardState = ManagerWizardState.getWizardState(pRequest); 
        
                    wizardState.setAlert("Mot de passe changé.");
        
        		} catch (Exception e) {
        			if (e.getMessage().indexOf("Old password") != -1)
        				pRequest.setAttribute(LOGIN_ERROR_KEY, "Erreur d'authentification avec l'ancien mot de passe.");
        			else
        				pRequest.setAttribute(LOGIN_ERROR_KEY, e);
                    pRequest.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, "password");
                    pRequest.setAttribute("changepassword", "");
        		}
            }
        } else {
            loginForm.setOldPassword("");
            loginForm.setPassword("");
            loginForm.setPasswordConfirm("");
        }
		return null;
	}

}
