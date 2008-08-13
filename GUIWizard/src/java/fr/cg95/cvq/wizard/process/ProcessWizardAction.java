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

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.IStageForm;

/**
 * @author René le CLERCQ
 */
public class ProcessWizardAction extends Action {

    private String pdfFile;
    private String message;
	
	public ProcessWizardAction() {
		super();
	}

    protected void printPdf(String pdf) {
        pdfFile = pdf;
    }
    
    protected void displayMessage(String msg) {
        message = msg;
    }
    
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

        response.setContentType("text/html; charset=utf-8");

        // Display the current step of the current proces 
		JspFactory jspFactory = JspFactory.getDefaultFactory();
		PageContext pageContext = jspFactory.getPageContext(servlet, request, response, null, true, 8192, true);
		
		// Find the process in the XML definition, look for name definition in the request parameters and attributes
		ProcessWizard process = getProcessWizard(ProcessWizardPlugin.getParameter(request, "name"));

        checkRequestedStage(request);

        ProcessWizardState wizardState = updateWizardState(request);
        
		// If no process defined take the one in the wizardState
		if ((process == null) && (wizardState != null))
			// Get the Xml definition based on the process name in the wizardState
			process = getProcessWizard(wizardState.getProcess().getName());

		if (process != null) {
			// We have a Xml definition so we allow stage processing and generate a page on the fly...
            process.init(pageContext);
            process(request);
			process.page(pageContext);
        }
		jspFactory.releasePageContext(pageContext);
		return null;
	}
    
	protected void initialiseProcess(Servlet servlet, HttpServletRequest request, HttpServletResponse response) {
	    String processName = ProcessWizardPlugin.getParameter(request, "name");
        if (processName == null)
            processName = (String)request.getSession().getAttribute(IProcessWizard.PROCESS_NAME);

        if (processName != null) {
            ProcessWizard process = getProcessWizard(processName);
            process.init(servlet, request, response);
        }
    }
    
    protected void process(HttpServletRequest request) {
    }

    protected ProcessWizardState getWizardState(HttpServletRequest request) {
        return (ProcessWizardState) request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
    }

    protected ProcessWizard getProcessWizard(String name) {
        return (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(name);
    }
    
    protected boolean checkRequestedStage(HttpServletRequest request) {
        ProcessWizardState wizardState = getWizardState(request);
        if ((wizardState != null) && (wizardState.getWizardListener() != null)) {
            if (!wizardState.isFrozen()) {
                int stage = wizardState.getStage();
                try {
                    String stageValue = ProcessWizardPlugin.getParameter(request, ProcessWizardState.STAGE_REQUEST_PARAMETER);
                    if (stageValue.equals("next"))
                        stage++;
                    else if (stageValue.equals("prev"))
                        stage--;
                    else
                        stage = Integer.parseInt(stageValue);
                } catch (Exception e) {
                }
    
                if (stage != wizardState.getStage()) {
                    IStageForm stageForm = ProcessStageAction.getStageForm(request.getSession());
                    String message = 
                        wizardState.getWizardListener().onStageChange(request, stageForm, 
                                                                               wizardState.getStageName());
                    if (message != null) {
                        displayMessage(message);

                        wizardState.setFrozen(true);
                        return false;
                    }
               }
            }
        }
        return true;
    }
    
	protected ProcessWizardState updateWizardState(HttpServletRequest request) {
		// Update the wizardState if present		
		ProcessWizardState wizardState = getWizardState(request);
		if (wizardState != null) {
            if (!wizardState.isFrozen()) {
                // Avoid double updates
                wizardState.setFrozen(true);
                wizardState.setEndStage(false);
                int stage = wizardState.getStage();
    			try {
    				String stageValue = ProcessWizardPlugin.getParameter(request, ProcessWizardState.STAGE_REQUEST_PARAMETER);
                    if (stageValue.equals("next"))
                        stage++;
                    else if (stageValue.equals("prev"))
                        stage--;
                    else if (stageValue.equals("end"))
                        wizardState.setEndStage(true);
                    else
    					stage = Integer.parseInt(stageValue);
    			} catch (Exception e) {
    			}
    			wizardState.setStage(stage);
    
    			int index = wizardState.getIndex();
    			try {
    				index =
    					Integer.parseInt(
    						ProcessWizardPlugin.getParameter(request, ProcessWizardState.INDEX_REQUEST_PARAMETER));
    			} catch (Exception e) {
    			}
    			wizardState.setIndex(index);
    
    			String state = wizardState.getTransition();
    			if (state == null) {
    				state = wizardState.getState();
    				try {
    					state =
    						ProcessWizardPlugin.getParameter(
    							request,
    							ProcessWizardState.TRANSITION_REQUEST_PARAMETER);
    				} catch (Exception e) {
    				}
    			}
    			if (state != null) {
                    if (state.length() > 0)
                        wizardState.setState(state);
                    else if (wizardState.getHomeAction() != null) {
                        wizardState.setState(wizardState.getHomeAction());
                        wizardState.setHomeAction(null);
                    }
                }
    			wizardState.setTransition(null);
            }    			
            if (pdfFile != null) {
                wizardState.setPdfFile(pdfFile);
                pdfFile = null;
            }
            if (message != null) {
                wizardState.setMessage(message);
                message = null;
            }
		}
		return wizardState;
	}

}
