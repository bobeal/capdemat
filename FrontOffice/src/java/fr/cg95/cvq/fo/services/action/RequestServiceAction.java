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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.action.BaseAction;

/**
 * @author René le CLERCQ
 */
public class RequestServiceAction extends BaseAction {

	public ActionForward doExecute(
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {

		// Check for a demand for the installation off a cookie
		String value = pRequest.getParameter(COOKIE_REQUEST);
		if (value != null) {
			// See if cookie is already installed
			if (!hasCookie(pRequest, COOKIE_NAME)) {
				Cookie cookie = new Cookie(COOKIE_NAME, value);
				cookie.setMaxAge(10 * 60 * 60 * 24 * 365); // Valid for one year
				pResponse.addCookie(cookie);
			}
			return pMapping.findForward("success");
		}

		throw new Exception("Request not treated");
	}

}