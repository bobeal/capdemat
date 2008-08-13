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

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.util.LassoServlet;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class LoginAction extends BasePersonalAction {

	private static String JMETER_LOGIN = "jmeter.";
	private static String JMETER_PWSTART = "f.id=";

	private static Logger _logger = Logger.getLogger(LoginAction.class);

	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (familyHome == null) {
            familyHome = new FamilyHome(request.getSession());
            request.getSession().setAttribute(FamilyHome.SESSION_NAME, familyHome);
        }
		LoginForm login = (LoginForm) form;

		_logger.debug("doExecute");

		String failure = "failure";

        String id = request.getParameter(LassoServlet.LASSO_ID);
        if (id != null) {
            Adult individual = (Adult)BusinessManager.getInstance().getIndividualService().getByFederationKey(id);
            login.setUserName(individual.getLogin());
            login.setMethod(null);
            
            familyHome.setId(individual.getHomeFolder().getId());
        }
        
		// test login and password
		try {
			if ((login.getMethod() != null) && login.getMethod().equals("card")) {
				login = (LoginForm) request.getSession().getAttribute(BaseAction.AUTHENTIFICATION);
			
			}	else if ((login.getMethod() != null) && login.getMethod().equals("update")) {
				failure = "authentify";
                String userName = (String)request.getSession().getAttribute("authentify.username");
                if ((userName != null) && (login.getUserName() == null))
                    login.setUserName(userName);
                
				HomeFolder authHome = BusinessManager.getInstance().getAuthenticationService().authenticate(
					login.getUserName(),
					login.getPassword());

				familyHome.setLogin(login);

				AdultForm adult = BusinessObjectFactory.convertAdultFromBusiness(authHome.getHomeFolderResponsible());
				request.getSession().setAttribute(ADULT_FORM,adult);

				return mapping.findForward("update"); 
			}
	
			
			// get the login from the form
			getLoginContents(login);
			
            // remove the session attribute
            request.getSession().removeAttribute(LOGIN_ERROR_KEY);

			if ((login.getMethod() != null) && login.getMethod().equals("reset")) {
			    if ((login.getQuestion() == null) || (login.getAcknowledge() == null)) {
                    _logger.debug("Login Exception: User is not account manager");
                    // set the error login message in the session
                    request.getSession().setAttribute(LOGIN_ERROR_KEY, NOT_ACCOUNT_MANAGER);
                    // forward failure to the appropriate view

                    ActionForward forward = mapping.findForward(failure);

                    if (isOnTerminal(request)) {
                        String url = request.getContextPath() + forward.getPath();
                        response.addHeader("CVQ-URL", url);
                    }
                    return forward;
                }
                familyHome.setLogin(login);
                request.setAttribute("loginForm", login);
                request.setAttribute("ResetPassword", "");
				return mapping.findForward("reset"); 
			}
	
			HomeFolder authHome = null;

			// get the family home by authentication of public key
			if (login.getPublicKey() != null) {
				authHome = BusinessManager.getInstance().getAuthenticationService().authenticate(login.getPublicKey());
				login.setUserName(authHome.getHomeFolderResponsible().getLogin());

				// RCLCQ JMeter login -------------------------
			} else if (login.getUserName().startsWith(JMETER_LOGIN)) {

				try {
					StringTokenizer tokens = new StringTokenizer(login.getUserName(), ".");
					if (tokens.countTokens() == 3) {
						// skip jmeter
						tokens.nextToken();

						String firstName = tokens.nextToken();
						String name = tokens.nextToken();

						authHome = BusinessManager.getInstance().findFamilyHome(name, firstName);

						login.setUserName(authHome.getHomeFolderResponsible().getLogin());
						login.setPassword(authHome.getHomeFolderResponsible().getPassword());
					} else
						throw new CvqAuthenticationFailedException("Home folder not found for " + login.getUserName());

				} catch (Exception jme) {
					throw new CvqAuthenticationFailedException("Home folder not found for " + login.getUserName());
				}

			} else if (familyHome.getId() != null) {
				authHome = BusinessManager.getInstance().findFamilyHomeById(familyHome.getId());
				
				// get the family home by authentication
			} else {
				authHome =
					BusinessManager.getInstance().getAuthenticationService().authenticate(
						login.getUserName(),
						login.getPassword());
			}

            SecurityContext.setCurrentEcitizen(login.getUserName());

			// set the family home object from the facade
			// into family home form
			BusinessObjectFactory.setFamilyHomeForm(authHome, familyHome);

			// set the login form
			request.getSession().setAttribute(BaseAction.AUTHENTIFICATION, login);

		} catch (CvqUnknownUserException e) {

			_logger.debug("Login Exception:" + e.getMessage());
			// set the error login message in the session
			request.getSession().setAttribute(LOGIN_ERROR_KEY, BAD_USER_VALUE);
			// forward failure to the appropriate view

			ActionForward forward = mapping.findForward(failure);

			if (isOnTerminal(request)) {
				String url = request.getContextPath() + forward.getPath();
				response.addHeader("CVQ-URL", url);
			}
			return forward;

		} catch (CvqBadPasswordException e) {
			_logger.debug("Login Exception:" + e.getMessage());
			// set the error password message in the session
			request.getSession().setAttribute(LOGIN_ERROR_KEY, WRONG_PASSWORD_VALUE);

			// forward failure to the appropriate view
			ActionForward forward = mapping.findForward(failure);

			if (isOnTerminal(request)) {
				String url = request.getContextPath() + forward.getPath();
				response.addHeader("CVQ-URL", url);
			}
			return forward;

        } catch (CvqAuthenticationFailedException e) {
            _logger.debug("Login Exception:" + e.getMessage());
            // set the error password message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, AUTHENTICATION_FAILED_VALUE);

            // forward failure to the appropriate view
            ActionForward forward = mapping.findForward(failure);

            if (isOnTerminal(request)) {
                String url = request.getContextPath() + forward.getPath();
                response.addHeader("CVQ-URL", url);
            }
            return forward;

        } catch (CvqDisabledAccountException e) {
            _logger.debug("Login Exception:" + e.getMessage());
            // set the error disabled message in the session
            request.getSession().setAttribute(LOGIN_ERROR_KEY, DISABLED_ACCOUNT_VALUE);

            // forward failure to the appropriate view
            ActionForward forward = mapping.findForward(failure);

            if (isOnTerminal(request)) {
                String url = request.getContextPath() + forward.getPath();
                response.addHeader("CVQ-URL", url);
            }
            return forward;

		} catch (CvqException e) {

			_logger.debug("Login Exception:" + e.getMessage());
			// set the error login message in the session
			request.getSession().setAttribute(LOGIN_ERROR_KEY, BAD_USER_VALUE);
			// forward failure to the appropriate view

			ActionForward forward = mapping.findForward(failure);
			login.setPassword(null);			

			if (isOnTerminal(request)) {
				String url = request.getContextPath() + forward.getPath();
				response.addHeader("CVQ-URL", url);
			}
			return forward;

		}
		// Display the wizard page "personal" defined in managers.xml
        request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, GUIWIZARD_MANAGER_PERSONAL);
        request.setAttribute(ManagerWizardState.RESET_REQUEST_PARAMETER, "");

		if (isOnTerminal(request)) {
			String url = request.getContextPath() + "/managerWizard.do?name=" + GUIWIZARD_MANAGER_PERSONAL;
			response.addHeader("CVQ-URL", url);
		}
		// GUI Wizard doesn't use the ActionForward
		return null;

	}
	
	private void getLoginContents(LoginForm loginForm) throws CvqException, CvqException {
		if (loginForm.getCertificate() == null) {
			Adult adult = (Adult)BusinessManager.getInstance().getIndividualService().getByLogin(loginForm.getUserName().toLowerCase());
			if (adult == null)
				throw new CvqException();
				 
			loginForm.setQuestion(adult.getQuestion());
			loginForm.setAcknowledge(adult.getAnswer());
			loginForm.setAdultId(adult.getId());
		}			
	}

}
