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
package fr.cg95.cvq.fo.services.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ForwardConfig;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author Laurent MARQUEZ
 * 
 */
public class PersonalContextServiceAction extends BasePersonalAction {

    public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        cleanupSessionAttributes(session);
        session.invalidate();
        
        if (request.getParameter("create") != null) {
            ActionForward forward = new ActionForward();
            forward.setName("create");
            forward.setPath("/createRequest.do?name=eCitizen&returnUrl=closeSession.do?close");

            return forward;
        }
        if (request.getParameter(FAMILYID) == null)
            return null;

        FamilyHome familyHome = new FamilyHome(request.getSession());
        request.getSession().setAttribute(FamilyHome.SESSION_NAME, familyHome);
        
        // get the family home id from the url parameter
        Long familyHomeId = new Long(request.getParameter(FAMILYID));

        // we must have only one family home in the set
        // because with pass an equal citeria with unique id
        HomeFolder family = BusinessManager.getInstance().findFamilyHomeById(familyHomeId);

        // update family home in the session
        BusinessObjectFactory.setFamilyHomeForm(family, familyHome);

        // Set the login to the agents login
        String agentLogin = request.getParameter(AGENTID);

        LoginForm loginForm = getAgentLogin(agentLogin);
        if (loginForm == null)
            throw (new Exception("Agent inconnu"));

        loginForm.setContext(SecurityContext.BACK_OFFICE_CONTEXT);
        request.getSession().setAttribute(BaseAction.AUTHENTIFICATION, loginForm);

        BaseAction.setCurrentEcitizen(loginForm);

        if (request.getParameter("full") != null)
            request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "personal");
        else
            request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "backoffice");

        request.setAttribute(ManagerWizardState.RESET_REQUEST_PARAMETER, "");
        
        return null;

    }

    private LoginForm getAgentLogin(String login) {
        if (login != null) {
            LoginForm loginForm = new LoginForm();
            loginForm.setUserName(login);

            return loginForm;
        }
        return null;
    }

}