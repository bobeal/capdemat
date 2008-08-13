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

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.manager.SearchManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.IPaperHolder;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class SelectAction extends BaseAction {

	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Get the session variables
		StateManager stateManager = getStateManager(request);
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);

        SearchForm searchForm = null;
        if (wizardState.getManager().equals("request"))
            searchForm = stateManager.getCurrentSearch();

        else if (wizardState.getManager().equals("family"))
            searchForm = stateManager.getAccountSearch();

        else if (wizardState.getManager().equals("card"))
            searchForm = stateManager.getAccountSearch();

		String select = request.getParameter("select");
		if (select.equals("request")) {
			Long id = Long.valueOf(request.getParameter("id"));
			IResultRecord record = SearchManager.search(stateManager.getRequestManager(), searchForm, "requestid", id);

            stateManager.setSelectedRecord(record);
			if ((searchForm != null) && select.equals(searchForm.getSearch()))
                stateManager.setPreviousRecord(record);
            
            if (stateManager.inUseBy(record).length() > 0)
                wizardState.setAlert("\t\tATTENTION ! \nLes utilisateurs suivants traitent actuellement cette demande:" + stateManager.inUseBy(record), true);
            
            if (form != null)
                form.reset(mapping, request);
            
            request.setAttribute("name", "request");
			// After a group we select the first tab by default
			request.setAttribute("tab", "1");
        } else if (select.equals("family")) {
            Long id = Long.valueOf(request.getParameter("id"));
            IResultRecord record = SearchManager.search(stateManager.getRequestManager(), searchForm, "familyid", id);

            stateManager.setSelectedRecord(record);
            if (select.equals(searchForm.getSearch()))
                stateManager.setPreviousRecord(record);
            
            request.setAttribute("name", "family");
            // After a group we select the first tab by default
            request.setAttribute("tab", "1");
        } else if (select.equals("card")) {
            try {
                Long id = Long.valueOf(request.getParameter("id"));
                IResultRecord record = SearchManager.search(stateManager.getRequestManager(), searchForm, "cardid", id);

                stateManager.setSelectedRecord(record);
                if (select.equals(searchForm.getSearch()))
                    stateManager.setPreviousRecord(record);
                
                request.setAttribute("name", "card");
                // After a group we select the first tab by default
                request.setAttribute("tab", "1");
            } catch (NumberFormatException nfe) {
                return null;
            }
		} else if (select.equals("paper")) {
			String type = request.getParameter("id");
			String page = request.getParameter("page");

			IPaperHolder record = (IPaperHolder) stateManager.getSelectedRecord();
			IResultRecord paper = null;
			if (type != null)
				paper = SearchManager.search(record, "papertype", type);
			else
				paper = record.getSelectedPaper();

			record.setSelectedPaper(paper, page);

            if (((PaperRecord)paper).getDataFile() == null)
                BusinessManager.getDocumentData(request.getSession(), (PaperRecord)paper);

            String forward = request.getParameter("forward");
			if (forward != null)
				return mapping.findForward(forward);
		}

		return null;
	}

}
