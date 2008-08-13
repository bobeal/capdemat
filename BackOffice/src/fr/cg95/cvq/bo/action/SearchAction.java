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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.manager.SearchManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class SearchAction extends BaseAction {

    /** Commons Logging instance. */
    protected static Logger log = Logger.getLogger(SearchAction.class);
    
	public ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

	    log.debug("Start search");
	    
	    // Get the session variables
		StateManager stateManager = getStateManager(request);

		SearchForm searchForm = (SearchForm) form;
		ArrayList al = (searchForm != null) ? searchForm.getWholeResultsList() : null;

		if (request.getParameter("request") != null) {
            // Set the current search in progres
            stateManager.setCurrentSearch(searchForm);

			al = null;

			// get the agent Id
			searchForm.setLastAgentId(stateManager.getAgentId(searchForm.getLastAgent()));
			
			// look for specific requests
			String kind = request.getParameter("request");
			if (kind.equals("open")) {
				searchForm.reset();
				al = SearchManager.searchStateTransitionRequests(stateManager.getRequestManager(), IBusinessConstants.STATE_PENDING);

			} else if (kind.equals("validate")) {
				searchForm.reset();
				searchForm.setState(IBusinessConstants.STATE_PENDING);

			} else if (kind.equals("notify")) {
				searchForm.reset();
				searchForm.setState(IBusinessConstants.STATE_VALIDATED);
			}
			if (al == null)
				al = SearchManager.searchRequest(stateManager.getRequestManager(), searchForm);
			searchForm.setSearch("request");

			searchForm.setWholeResultsList(al);
			// Reset the currently selected record
			stateManager.setSelectedRecord(null);
			
            ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);

            if (kind.length() > 0)
                wizardState.setTab(0);
            
            // Export search results have a completed form so mark the last contents as empty
			if ((wizardState.getTabId() != null) && wizardState.getTabId().equals("export"))
	            request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");
			

        } else if (request.getParameter("family") != null) {
            // Set the current search in progres
            stateManager.setAccountSearch(searchForm);

            // We are looking for families, so we display the family manager
            request.setAttribute("name", "family");

            al = SearchManager.searchIndividual(searchForm);
            searchForm.setSearch("family");

            searchForm.setWholeResultsList(al);
            // Reset the currently selected record
            stateManager.setSelectedRecord(null);

        } else if (request.getParameter("card") != null) {
            // Set the current search in progres
            stateManager.setAccountSearch(searchForm);

            // We are looking for cards, so we display the card manager
            request.setAttribute("name", "card");

            searchForm.setSearch("card");
            al = SearchManager.searchIndividual(searchForm);

            searchForm.setWholeResultsList(al);
            // Reset the currently selected record
            stateManager.setSelectedRecord(null);
		}

		String action = request.getParameter("action");
		if ((action != null) && action.equals("sortBy")) {
			String field = request.getParameter("field");
			Object search = getSearchList(request);
            if (search != null) {
                Collection list = null;
                if (search instanceof SearchForm)
                    searchForm = (SearchForm)search;
                else if (search instanceof Collection)
                    list = (Collection)search;

                if (field != null)
    				SearchManager.sortResults(stateManager.getRequestManager(), searchForm, field, list);
            }
		} else if (al != null) {
			searchForm.setTotalRecordNb(al.size());

		} else {
			searchForm.setTotalRecordNb(0);
		}
		searchForm.setCurrentRecord(0);
		searchForm.setDisplayedPage(1);

		// Refresh the numbers in the menu
		stateManager.refresh();

        log.debug("End search");
		// This will recall the Manager Wizard
		return null;
	}

    private Object getSearchList(HttpServletRequest request) {
        StateManager stateManager = getStateManager(request);
        String property = request.getParameter("list");

        try {
            if (property != null)
                return PropertyUtils.getProperty(stateManager, property);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
