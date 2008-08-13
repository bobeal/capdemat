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

package fr.cg95.cvq.bo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le Clercq
 */
public class LoginAction extends BaseAction {

	protected static Logger log = Logger.getLogger(LoginAction.class.getName());

	public ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Get the session variables
//		StateManager stateManager = getStateManager(request);
//
//		LoginForm loginForm = (LoginForm) form;
//
//		if (loginForm.getCancel() != null) {
//			loginForm.setUsername("");
//			loginForm.setPassword("");
//			request.setAttribute("LoginForm", loginForm);
//
//			return mapping.getInputForward();
//		}
//
//		String name = loginForm.getUsername();
//		String password = loginForm.getPassword();
//
//		UserRecord user = getUser(request, name, password);
//
//		stateManager.setCurrentUser(user);
//
//		if (user == null) {
//			ActionErrors errors = null;
//			if ((name == null && password == null)) {
//				errors = new ActionErrors();
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.login"));
//				saveErrors(request, errors);
//
//				return mapping.findForward("error");
//			}
//
//			if ((password != null)
//				&& !password.equals(ProfileManager.PROFILE_STRING_ADMIN)
//				&& !password.equals(ProfileManager.PROFILE_STRING_RW)) {
//
//				errors = new ActionErrors();
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.login"));
//				saveErrors(request, errors);
//
//				return mapping.getInputForward();
//			}
//			stateManager.setProfile(password);
//		} else;
//			stateManager.setProfile(user.getProfile());
//
		// We will call the wizard with the request manager
		request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "request");
        request.setAttribute(ManagerWizardState.RESET_REQUEST_PARAMETER, "");
        request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");

		// Uncomment to test transaction strategies
		// 		BusinessManager.testTransactionLazyInitialization();
		// 		BusinessManager.testTransactionRollback();
		// End Test

		return null;
	}

	private UserRecord getUser(HttpServletRequest request, String name, String password) {

		if ((name != null) && (password != null)) {
			// Set the user for the manager
			request.setAttribute(ManagerWizardState.USER_REQUEST_PARAMETER, name);

			return BusinessManager.checkUser(name);
		}
		return null;
//		// This was used with the old 1.0 CAS server ...
//		// String id = (String) request.getSession().getAttribute("netID");
//
//		// we now use the brand new CAS 3.0 server, isn't that fun ?
//		log.debug("getUser() searching attribute " + CASFilter.CAS_FILTER_USER);
//		String id = (String) request.getSession().getAttribute(CASFilter.CAS_FILTER_USER);
//		log.debug("getUser() got uid " + id);
//
//		// that's a fucking dirty hack !
//        if ((id != null) && (id.indexOf(";") != -1)) {
//
//            // we are receiving a chain with user and groups information
//            Map userAttrMap = new HashMap();
//            String[] splitted = id.split(";");
//            for (int i = 0; i < splitted.length; i++) {
//                String token = splitted[i];
//                if (token.indexOf("=") != -1) {
//                    String[] keyVal = token.split("=");
//                    String key = keyVal[0];
//                    String value = keyVal[1];
//                    if (!userAttrMap.containsKey(key))
//                        userAttrMap.put(key,new ArrayList());
//                    ((List) userAttrMap.get(key)).add(value);
//                }
//            }
//            if (!userAttrMap.containsKey("username"))
//                return null;
//            id = (String) ((List) userAttrMap.get("username")).get(0);
//        }
//		log.debug("getUser() uid is now " + id);
//        
//		// Set the user for the manager
//		request.setAttribute(ManagerWizardState.USER_REQUEST_PARAMETER, id);
//
//		return BusinessManager.checkUser(id);
	}
}
