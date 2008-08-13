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
package fr.cg95.cvq.bo.dispatcher;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizard;

/**
 */
public class HttpSessionEventListener implements HttpSessionListener {

    private HashMap<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
    private static HashMap<String, HashMap<Long, HashMap<String, HttpSession>>> siteMap = 
        new HashMap<String, HashMap<Long, HashMap<String, HttpSession>>>();
    
    /**
	 */
	public HttpSessionEventListener() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		sessionMap.put(session.getId(), session);
        ManagerWizard.loadSessionObject(session,true);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		long curTime = System.currentTimeMillis(); 
		long lastAccess = session.getLastAccessedTime();
		long maxInactive = session.getMaxInactiveInterval();
		
		long timeOut = (curTime - lastAccess) / 1000; 
		if ( timeOut > maxInactive) {
		// Session timed-out
		}
		
		// Remove temporary files created for this session
		Utils.removeDir(StartupServlet.getTempContextDir(session));

		try {
            StateManager stateManager = (StateManager)session.getAttribute(StateManager.STATE_MANAGER);
            if (stateManager != null) {
                if ((stateManager.getSelectedRecord() != null) && (stateManager.getCurrentUser() != null))
                    unRegisterRecord(session, stateManager.getSelectedRecord());
                
                session.removeAttribute(StateManager.STATE_MANAGER);
            }
        } catch (Exception e) {
        }
        sessionMap.remove(session.getId());
	}
    
    public static void removeFaultySession(HttpSession session) {
        try {
            for (Entry<String, HashMap<Long, HashMap<String, HttpSession>>> siteEntry : siteMap.entrySet()) {    
                HashMap<Long, HashMap<String, HttpSession>> records = siteEntry.getValue();
                for (Entry<Long,HashMap<String, HttpSession>> recordEntry : records.entrySet()) {
                    HashMap<String, HttpSession> users = recordEntry.getValue();
                    users.remove(session.getId());
//                    if  (users.isEmpty())
//                        records.remove(recordEntry.getKey());
                }
            }
        } catch (Exception e) {
        }
    }

    public static void registerRecord(HttpSession session, IResultRecord record) {
        if (record instanceof RequestRecord) {
            String site = (String)session.getAttribute("currentSiteName");
            HashMap<Long, HashMap<String, HttpSession>> records = siteMap.get(site);
            if (records == null) {
                records = new HashMap<Long, HashMap<String, HttpSession>>();
                siteMap.put(site, records);
            }
            
            HashMap<String, HttpSession> users = records.get(((RequestRecord)record).getId());
            if (users == null) {
                users = new HashMap<String, HttpSession>();
                records.put(((RequestRecord)record).getId(), users);
            }
            users.put(session.getId(), session);
        }
    }

    public static void unRegisterRecord(HttpSession session, IResultRecord record) {
        if (record instanceof RequestRecord) {
            String site = (String)session.getAttribute("currentSiteName");
            HashMap<Long, HashMap<String, HttpSession>> records = siteMap.get(site);
            if (records != null) {
                HashMap<String, HttpSession> users = records.get(((RequestRecord)record).getId());
                if (users != null) {
                    users.remove(session.getId());
                    if  (users.isEmpty())
                        records.remove(((RequestRecord)record).getId());
                }
            }
        }
    }

    public static HashMap<String, HttpSession> getRecordReqistration(HttpSession session, IResultRecord record) {
        if (record instanceof RequestRecord) {
            String site = (String)session.getAttribute("currentSiteName");
            HashMap<Long, HashMap<String, HttpSession>> records = siteMap.get(site);
            if (records != null) {
                return records.get(((RequestRecord)record).getId());
            }
        }
        return null;
    }

}
