/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.fo.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.AccountManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.util.FileManager;

/**
 */
public class SessionManager implements HttpSessionListener {

	private static Logger _logger = Logger.getLogger(SessionManager.class);

	/**
	 */
	public SessionManager() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent pHttpSessionEvent) {
		HttpSession session = pHttpSessionEvent.getSession();
        session.setAttribute(RequestManager.class.getName(), new RequestManager());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent pHttpSessionEvent) {

		_logger.debug("sessionDestroyed()");

		HttpSession session = pHttpSessionEvent.getSession();

		long curTime = System.currentTimeMillis();
		long lastAccess = session.getLastAccessedTime();
		long maxInactive = session.getMaxInactiveInterval();

		long timeOut = (curTime - lastAccess) / 1000;
		if (timeOut > maxInactive) {
			// Session timed-out
		}

		// Remove temporary files created for this session
		FileManager.removeDir(StartupServlet.getTempContextDir(session));
        
	}

    public static RequestManager getRequestManager(HttpServletRequest request) {
        return getRequestManager(request.getSession());
    }

    public static RequestManager getRequestManager(HttpSession session) {
        return (RequestManager) session.getAttribute(RequestManager.class.getName());
    }

    public static AccountManager getAccountManager(HttpServletRequest request) {
        return getAccountManager(request.getSession());
    }

    public static AccountManager getAccountManager(HttpSession session) {
        return (AccountManager) session.getAttribute(AccountManager.SESSION_NAME);
    }

    public static FamilyHome getFamilyHome(HttpServletRequest request) {
        return (FamilyHome)request.getSession().getAttribute(FamilyHome.SESSION_NAME);
    }
    
}