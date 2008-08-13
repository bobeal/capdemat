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
package fr.cg95.cvq.bo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.manager.SearchManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class FamilyAction extends BaseAction {

	/* (non-Javadoc)
	 * @see fr.cg95.cvq.bo.action.BaseAction#executeLogic(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Get the session variables
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
		StateManager stateManager = getStateManager(request);

        String action = request.getParameter("action");
        String wizard = request.getParameter("wizard");
        if ((wizard != null) && (Integer.parseInt(wizard) > 0)) {
            Long id = Long.valueOf(request.getParameter("id"));
            IResultRecord record = SearchManager.searchFamily(stateManager.getRequestManager(), id);
            
            stateManager.setWindowIndex(Integer.parseInt(wizard));
            stateManager.setSelectedRecord(record);
            
            request.setAttribute("tab", "1");
            return null;
        }
        stateManager.setWindowIndex(0);
        if (action.equals("view")) {
            IResultRecord record = stateManager.getSelectedRecord();
            if (record instanceof RequestRecord) {
                Long id = ((RequestRecord)record).getFamilyId();
                String url = request.getContextPath() + "/familyAction.do?wizard=1&name=family&id=" + id;
    
                request.setAttribute("url", url);
                request.setAttribute("popup", "");
                return mapping.findForward("redirect");
            }
        }

        if (action.equals("eCitizen")) {
            if (wizardState.isEmptyContent())
                request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");

            String url = stateManager.getFrontOfficeSite(request.getContextPath()) + "/personalContextServiceAction.do?create=account";

            request.setAttribute("url", url);
            request.setAttribute("popup", "");
            return mapping.findForward("redirect");
        }

		IResultRecord record = stateManager.getSelectedRecord();
		if ((record != null) && (record instanceof FamilyRecord)) {
			if (action.startsWith("request")) {

				String url =
					stateManager.getFrontOfficeSite(request.getContextPath())
						+ "/personalContextServiceAction.do?familyId="
						+ ((FamilyRecord) record).getId();
				url += "&agentId=" + stateManager.getCurrentUser().getLogin();

                if (action.equals("requestf"))
                    url += "&full";
                
				request.setAttribute("url", url);
				request.setAttribute("popup", "");
				return mapping.findForward("redirect");

			} else if (action.equals("meeting")) {
				return null;
			}
		}
		if (action.equals("request")) {
			setInfo("/jsp/bo/family/addrequestinfo");

		} else if (action.equals("meeting")) {
			setInfo("/jsp/bo/family/meetinginfo");
		}
		if (wizardState.isEmptyContent())
		    request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");
		
		return null;
	}

}
