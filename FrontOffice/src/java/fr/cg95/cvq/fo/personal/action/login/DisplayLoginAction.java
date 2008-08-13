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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.card.LPAuthServer;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.util.Constants;

/**
 * @author René le CLERCQ
 */
public class DisplayLoginAction extends Action implements Constants {

	private static Logger logger = Logger.getLogger(DisplayLoginAction.class);

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		logger.debug("execute()");

		String action = request.getParameter("action");
		
		if (action == null) { 
			HttpSession session = request.getSession();
	
			session.removeAttribute(FamilyHome.SESSION_NAME);
			session.removeAttribute(ADULT_FORM);
			session.removeAttribute(CHILD_FORM);
			session.removeAttribute(LOGIN_ERROR_KEY);
			session.removeAttribute(BAD_FILE_FORMAT_KEY);

			if (isOnTerminal(request)) {
				// Generate challenge
				byte[] challenge = LPAuthServer.generateChallenge(128);

				// Add the challenge to the session
				session.setAttribute("challenge", new String(Base64.encodeBase64(challenge)));
				session.setAttribute("challengeDigestAlgorithm", LPAuthServer.DIGEST_SHA256_OID);
			}	
           	return mapping.findForward("login");
		}
		else if (action.equalsIgnoreCase("update")) {
			return mapping.findForward("authentify");
		}
		return null;
	}

	private boolean hasCookie(HttpServletRequest pRequest, String pName) {
		Cookie cookies[] = pRequest.getCookies();
		if (cookies == null)
			return false;

		int i = 0;
		while ((i < cookies.length) && !cookies[i++].getName().equals(pName));

		return (i < cookies.length);
	}

	private boolean isOnTerminal(HttpServletRequest pRequest) {
		return hasCookie(pRequest, Constants.COOKIE_NAME);
	}

}