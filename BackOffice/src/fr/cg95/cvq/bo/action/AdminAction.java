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
import fr.cg95.cvq.bo.form.AdminForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class AdminAction extends BaseAction {

        /* (non-Javadoc)
         * @see fr.cg95.cvq.bo.action.BaseAction#executeLogic(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
         */
        protected ActionForward executeLogic(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
                throws Exception {

                // Update the wizard with the request parameters
                updateWizardState(request);

                // Get the session variables
                ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
                StateManager stateManager = getStateManager(request);

                AdminForm adminForm = (AdminForm) form;

                if (adminForm == null)
                        adminForm = new AdminForm();

                adminForm.init(stateManager.getRequestManager());

                String save = request.getParameter("save");
                if (save != null) {
                        if (save.equals("user"))
                                BusinessManager.saveUser(adminForm);
                        else if (save.equals("category")) {
                                        if (adminForm.getSaveChoice() != null)
                                                BusinessManager.saveCategory(adminForm);
                                        else if (adminForm.getDeleteChoice() != null)
                                                BusinessManager.deleteCategory(adminForm);
                                        else if (adminForm.getCreateChoice() != null) {
                                                adminForm.setSelection(null, request.getParameter(ManagerWizardState.INDEX_REQUEST_PARAMETER));
                                                stateManager.setSelectedRecord(null);

                                                // Update the wizard state indirectly with additional specific parameters,
                                                request.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, "create_category");

                                                // We are looking for administration, so we display the admin manager
                                                request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "administration");
                                                return null;

                                        }
                        }
                }

                String create = request.getParameter("create");
                if (create != null && create.equals("category")) {
                                if (adminForm.getSaveChoice() != null)
                                        BusinessManager.createCategory(adminForm);
                }

                String state = request.getParameter(ManagerWizardState.TRANSITION_REQUEST_PARAMETER);

                // If there is no admin parameter in the request, find the id from the current tab
                if (state == null)
                        state = wizardState.getTabId();

                // Set the selected item based on the wizardstate and the index
                adminForm.setSelection(state, request.getParameter(ManagerWizardState.INDEX_REQUEST_PARAMETER));

                stateManager.setSelectedRecord(null);

                // Update the wizard state indirectly with additional specific parameters,
                request.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, state);

                // We are looking for administration, so we display the admin manager
                request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "administration");

                return null;
        }

}
