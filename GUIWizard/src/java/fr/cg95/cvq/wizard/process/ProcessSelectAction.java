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
package fr.cg95.cvq.wizard.process;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.wizard.GuiWizardException;
import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.wizard.StageFormList;
import fr.cg95.cvq.wizard.process.xmlbean.SelectType;
import fr.cg95.cvq.wizard.process.xmlbean.StageType;

/**
 * @author René le CLERCQ
 */
public class ProcessSelectAction extends ProcessStageAction {

	public ProcessSelectAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
        if (checkRequestedStage(request)) {
    		ProcessWizardState wizardState = updateWizardState(request);
    
    		StageFormList list = getCollection(request, wizardState, request.getParameter("list"));
    		
            if (list != null) {
        		if (request.getParameter("get") != null)
        			selectListItem(session, wizardState, list, request.getParameter("get"), request.getParameter("transition"));
        		else if (request.getParameter("new") != null)
        			newListItem(request, wizardState, list, request.getParameter("transition"));
        		else if (request.getParameter("del") != null)
        			delListItem(session, wizardState, list);
                else if (request.getParameter("save") == null)
                    selectListItem(session, wizardState, list, null, request.getParameter("transition"));
            }
        }
		return super.execute(mapping, form, request, response);
	}

    protected void process(HttpServletRequest request) {
        super.process(request);

        if (request.getParameter("save") != null) {
            HttpSession session = request.getSession();
            ProcessWizardState wizardState = getWizardState(request);

            StageFormList list = getCollection(request, wizardState, request.getParameter("list"));
            if (list != null) {
                list.save(getStageForm(session));
                saveListItem(session, wizardState, list);
            }
        }
    }

	private StageFormList getCollection(HttpServletRequest request, ProcessWizardState wizardState, String list) {
		try {
		    HttpSession session = request.getSession();
            if (list != null) {
                // Check list in select array
                StageType xmlStage = wizardState.getStageArray(wizardState.getStage());
                for (int i = 0; i < xmlStage.sizeOfSelectArray(); i++) {
                    if (list.equals(xmlStage.getSelectArray(i).getProperty())) {
                        SelectType xmlSelect = xmlStage.getSelectArray(i);
                        
                        Object data = session.getAttribute(xmlSelect.getName());
                        Object listData = PropertyUtils.getProperty(data, xmlSelect.getProperty());
                        if (listData instanceof StageFormList) {
                            if (!list.equals(wizardState.getList()) && (request.getParameter("index") == null))
                                wizardState.resetIndex();
                            
                            wizardState.setList(list);
                            return (StageFormList)listData;
                        }
                    }
                }
                
                // Otherwise find in current stage form
                IStageForm stageForm = getStageForm(session);
                if (stageForm != null) {
                    if (!list.equals(wizardState.getList()) && (request.getParameter("index") == null))
                        wizardState.resetIndex();
                    
                    wizardState.setList(list);
                    return (StageFormList)PropertyUtils.getProperty(stageForm, list);
                }
                // List not taken as StageFormList reset wizardState.
                wizardState.setList("");
            } else {
                StageType xmlStage = wizardState.getStageArray(wizardState.getStage());
                if (xmlStage.sizeOfSelectArray() > 0) {
                    SelectType xmlSelect = xmlStage.getSelectArray(0);
                    if (xmlSelect.isSetProperty()) {
                        Object data = session.getAttribute(xmlSelect.getName());
                        Object listData = PropertyUtils.getProperty(data, xmlSelect.getProperty());
                        if (listData instanceof StageFormList) { 
                            if (!xmlSelect.getProperty().equals(wizardState.getList()) && (request.getParameter("index") == null))
                                wizardState.resetIndex();
                            
                            wizardState.setList(xmlSelect.getProperty());
                            return (StageFormList)listData;
                        }
                    }
                }
                // List not taken as StageFormList reset wizardState.
                wizardState.setList("");
            }
		} catch (NullPointerException npe) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}

		return null;
	}
	
	private void selectListItem(HttpSession session, ProcessWizardState wizardState, StageFormList list, String getIndex, String transition) {
        String context = wizardState.getStateContext(transition);
	    int index = -1;
        try {
            index = Integer.parseInt(getIndex);
        } catch (NumberFormatException nfe) {
        }
        if (index >=0) {
            wizardState.setHomeAction(wizardState.getDisplayState());
            
            Object selected = list.select(index);
            if (selected instanceof IStageForm) {
                IStageForm stageForm = (IStageForm)selected; 
                session.setAttribute(context, stageForm);
            }
        } else if (wizardState.getIndex() >= 0) {
            Object selected = list.select(wizardState.getIndex());
            if (selected instanceof IStageForm) {
        		IStageForm stageForm = (IStageForm)selected;
        		setStageForm(session, wizardState, stageForm);
            }
        }
	}
	
	private void newListItem(HttpServletRequest request, ProcessWizardState wizardState, StageFormList list,
            String transition) {
		try {
		    String context = wizardState.getStateContext(transition);
            if (context != null) {
                wizardState.setHomeAction(wizardState.getDisplayState());
                IStageForm stageForm = newStageForm(request, wizardState, context);
                request.getSession().setAttribute(context, stageForm);
                list.create(stageForm);
            } else {
    			IStageForm stageForm = newStageForm(request, wizardState, wizardState.getStageName());
    			setStageForm(request.getSession(), wizardState, stageForm);
    			wizardState.setIndex(-1);
    			list.create(stageForm);
            }
		} catch (GuiWizardException e) {
		}
	}
	
	private void saveListItem(HttpSession session, ProcessWizardState wizardState, StageFormList list) {
        String context = wizardState.getStateContext(wizardState.getDisplayState());
        if (context != null) {
            IStageForm stageForm = (IStageForm)session.getAttribute(context);
            if (!list.contains(stageForm)) {
                list.add(stageForm);
            }
            
        } else if (wizardState.getIndex() == -1) {
            IStageForm stageForm = getStageForm(session);
            // Check form is not already in the list
            if (list.contains(stageForm)) {
                wizardState.setIndex(list.indexOf(stageForm));
            } else {
                list.add(stageForm);
    			wizardState.setIndex(list.size() - 1);
            }
        }
	}
	
	private void delListItem(HttpSession session, ProcessWizardState wizardState, StageFormList list) {
        String context = wizardState.getStateContext(wizardState.getDisplayState());
        if (context != null) {
            IStageForm stageForm = (IStageForm)session.getAttribute(context);
            list.remove(stageForm);
        } else {
            setStageForm(session, wizardState, null);
            list.remove(wizardState.getIndex());
            if (list.size() == 0)
                wizardState.resetIndex();
            else
                wizardState.setIndex(0);
        }
	}

}
