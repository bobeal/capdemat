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

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.manager.TaskManager;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class SaveAction extends BaseAction {

    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Get the session variables
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        StateManager stateManager = getStateManager(request);

        SaveForm saveForm = (SaveForm) form;

        if ((saveForm.getSend() == null) && (saveForm.getPrint() == null)) {
            if (request.getParameter("paper") != null) {
                RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
                PaperRecord paper = (PaperRecord) record.getSelectedPaper();
    
                if ((saveForm.getState() != null) || !paper.getState().equals(IBusinessConstants.STATE_ABSENT)) {
                    paper.setExpirationDate(saveForm.getExpirationDate());
                    if (saveForm.getState() != null)
                        paper.setState(saveForm.getState());
                    else
                        saveForm.setState(paper.getState());
    
                    record.setSelectedPaper(null, null);
    
                    record.getTasks().updateTask(TaskManager.TASK_DOCUMENTS, saveForm.getState(),
                            paper.getType(), record.getPapers().size());
    
                    Date valid = BusinessManager.saveDocument(record, paper, saveForm.getState(), Utils
                            .getStringAsDate(saveForm.getExpirationDate()), "");
                    paper.setValidationDate(Utils.getDateAsString(valid));
                }
            } else if (request.getParameter("demand") != null) {
                RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
    
                // Save the request specific instruction data
                if (saveForm.getCheck() != null)
                    saveRecord(request, record);
    
                // Update the state of the request
                record.setState(saveForm.getState());
                if ((wizardState.getTabId() != null) && wizardState.getTabId().equals("delivery")) {
                    record.setDeliveryInternal(saveForm.getDeliveryInternal());
                    record.setDeliveryExternal(saveForm.getDeliveryExternal());
                } else {
                    record.setInstructionInternal(saveForm.getInstructionInternal());
                    record.setInstructionExternal(saveForm.getInstructionExternal());
                }
                BusinessManager.setRequestState(record, saveForm.getState(), "");
    
                record.getTasks().updateTask(TaskManager.TASK_REQUEST, saveForm.getState());
                
                // Refresh the numbers in the menu
                stateManager.refresh();

            } else if (request.getParameter("data") != null) {
                RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
                record.setDataState(saveForm.getState());
    
                record.getTasks().updateTask(TaskManager.TASK_DATA, saveForm.getState());
    
                BusinessManager.setDataState(record, saveForm.getState(), "");
    
                // Save the request specific form data modified by the agent
                if (!stateManager.getRequestManager().saveRequestData(record))
                    record.saveData();
            } else if (request.getParameter("family") != null) {
                FamilyRecord record = (FamilyRecord) stateManager.getSelectedRecord();
                
                if ((record.isEnabled() != saveForm.isEnabled()) ||
                    (record.isArchived() != saveForm.isArchived()) ||
                    !saveForm.getFamilyQuotient().equals(record.getFamilyQuotient())) {
                    record.setEnabled(saveForm.isEnabled());
                    record.setArchived(saveForm.isArchived());
                    record.setFamilyQuotient(saveForm.getFamilyQuotient());
                
                    BusinessManager.saveFamilyRecord(record);
                }
            }
        }
        if ((saveForm.getMail() == null) || (saveForm.getMail().length() == 0))
            if (stateManager.getSelectedRecord() instanceof RequestRecord)
                saveForm.setMail(((RequestRecord)stateManager.getSelectedRecord()).getEMail());
            
        request.setAttribute("SaveForm", saveForm);

        return null;
    }

    /**
     * Save the specific request instruction and delivery data.
     */
    protected void saveRecord(HttpServletRequest request, RequestRecord record) throws Exception {
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            try {
                String name = (String) names.nextElement();
                String value = request.getParameter(name);

                PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(record, name);
                if (propertyDescriptor != null) {
                    Object data = null;
                    Class type = propertyDescriptor.getPropertyType();
                    if (type.getName().equals("boolean")) {
                        if (value.equalsIgnoreCase("non")) {
                            data = new Boolean(false);
                        } else {
                            data = new Boolean(true);
                        }

                    } else if (type.getName().equals("long")) {
                        if (value.length() > 0)
                            data = new Long(value);

                    } else if (type.getName().equals("java.lang.Short")) {
                        if (value.length() > 0)
                            data = new Short(value);

                    } else {
                        data = value;
                    }
                    PropertyUtils.setProperty(record, name, data);
                }
            } catch (IllegalAccessException e) {
                e.getMessage();
            } catch (InvocationTargetException e) {
                e.getMessage();
            } catch (NoSuchMethodException e) {
                e.getMessage();
            }
        }
        StateManager stateManager = getStateManager(request);
        if (!stateManager.getRequestManager().saveRequest(record))
            record.saveRequest();
    }

}
