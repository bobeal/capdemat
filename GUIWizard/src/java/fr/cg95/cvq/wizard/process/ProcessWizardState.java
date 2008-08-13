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

import java.io.File;
import java.util.Collection;
import java.util.Stack;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import fr.cg95.cvq.wizard.VelocityUtils;
import fr.cg95.cvq.wizard.WizardListener;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;
import fr.cg95.cvq.wizard.process.xmlbean.SelectType;
import fr.cg95.cvq.wizard.process.xmlbean.StageDefType;
import fr.cg95.cvq.wizard.process.xmlbean.StageType;
import fr.cg95.cvq.wizard.process.xmlbean.StateType;

/**
 * @author René le CLERCQ
 */
public class ProcessWizardState {

    public static final String NAME_REQUEST_PARAMETER = "name";

    public static final String STAGE_REQUEST_PARAMETER = "stage";

	public static final String INDEX_REQUEST_PARAMETER = "index";

	public static final String TRANSITION_REQUEST_PARAMETER = "transition";

    static final String SESSION_KEY = "ProcessWizardState";

	private VelocityContext velocityContext = new VelocityContext();
	private ProcessType process = null;
	private String site = "";
	private WizardListener wizardListener = null;
    
    private String seasonLabel = null;
    private String siteTitle ="";
    private String home ="";
    private Template displayTemplate = null;
    private Template tagTemplate = null;
	
    private int stage = 0;
    private StageType xmlStage = null;

	private String homeAction = null;
	private String transition = null;

    private String pdfFile = null;
    private String message = null;
	
    private Vector<StageType> stageArray = null;
    
	private Vector<String> nextStage = new Vector<String>();
	private Vector<String> prevStage = new Vector<String>();
	
    private boolean frozen = false;
    private boolean stageOk = false;
    private boolean endStage = false;
    
	private class StageParameters {
	    String name = null;
        int index = -1;
        String list = "";
		String state = "";
		String prevState = "";
        private Stack<String> states = new Stack<String>();
        boolean saved =false;
	}

	private Vector<StageParameters> stages = new Vector<StageParameters>();
	private StageParameters stageParameters = null;
	
	public ProcessWizardState() {
		super();
		init();
	}

	public void init() {
		process = null;
		stage = 0;

		nextStage.clear();
		prevStage.clear();
	}

    public static ProcessWizardState getWizardState(HttpServletRequest request) {
        return getWizardState(request.getSession());
    }

    public static ProcessWizardState getWizardState(HttpSession session) {
        return (ProcessWizardState) session.getAttribute(ProcessWizardState.SESSION_KEY);
    }

    public static void removeWizardState(HttpSession session) {
        session.removeAttribute(ProcessWizardState.SESSION_KEY);
    }

    static ProcessWizardState init(PageContext pageContext) {
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        String wizard = request.getParameter(NAME_REQUEST_PARAMETER);
        if (wizard == null)
            wizard = (String)request.getAttribute(NAME_REQUEST_PARAMETER);
        
        if (wizard != null) {
            try {
                ((ProcessWizard)ProcessWizardPlugin.plugin().getProcess(wizard)).init(pageContext);
                return  (ProcessWizardState) request.getSession().getAttribute(SESSION_KEY);

            } catch (JspException e) {
            }
        }
        return null;
    }
    
	public void setStage(int stage) {
		stageParameters = getStageParameters(stage);
        if ((stage != this.stage) || (stageParameters.name == null)) {
//          if (stage != this.stage) {
			StageType xmlbStage = ((ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName()))
					.getWizardStage(this, stage);

            if (xmlbStage != null)
                stageParameters.name = xmlbStage.getName();
            
            if (stageParameters.state.length() == 0)
				stageParameters.state = (xmlbStage != null) ? xmlbStage.getDefault() : "";
				
			homeAction = null;
		}
		this.stage = stage;
	}

    public void setStageDefault(String stageName, String state) {
        int stageNo = -1;
        int i = 0;
        while (i < sizeOfStageArray()) {
            StageType xmlbStage = 
                ((ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName())).getWizardStage(getStageArray(i));
            String name = xmlbStage.getName();
            if (stageName.equals(name))
                stageNo = i;
            
            i++;
        }
        
        if (stageNo != -1) {
            stageParameters = getStageParameters(stageNo);
            stageParameters.state = state;
        }
    }
    
	public void resetStage() {
		stages.clear();
		
        if (getStage() >= 0)
            setStage(0);

		nextStage.clear();
		prevStage.clear();
	}
	
	private StageParameters getStageParameters(int stage) {
		StageParameters params = null;
		
        if (stage < 0)
            return new StageParameters();
        
        try {
			params = stages.get(stage);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			stages.setSize(stage+1);
		}
		if (params == null) {
			params = new StageParameters();
			stages.add(stage,params);
		}
		return params;
	}
	
    public String getState() {
        return stageParameters.state;
    }

    public String getState(int stageNo) {
        if (stageNo == this.stage)
            return getState();

        if ((stageNo >= 0) && (stageNo < stageArray.size()))
            return stageArray.get(stageNo).getDefault();
        
        return null;
    }

	public void setState(String state) {
		stageParameters.prevState = stageParameters.state;
		stageParameters.state = state;
        
		// Remove all occurences until last state with the same name included
        int index = stageParameters.states.search(state);
        for (int i = 0; i < index; i++)
            stageParameters.states.pop();

        // Push the state on the stack
        stageParameters.states.push(state);
    }

    String getPrevStackState() {
        if (stageParameters != null)
            if (stageParameters.states.size() > 1)
                // Return last but one
                return stageParameters.states.get(stageParameters.states.size()-2);
        
        return null;
    }
    
    String getPrevState() {
        if (stageParameters != null)
            return stageParameters.prevState;
        
        return null;
    }

    String getDisplayState() {
        if (stageParameters != null) {
            if (stageParameters.prevState.length() > 0)
                return stageParameters.prevState;
            
            return stageParameters.state;
        }
        return null;
    }

    String getStateContext() {
        if (stageParameters != null)
            return getStateContext(stageParameters.state);
            
        return null;
    }
    
    String getStateContext(String state) {
        if ((state != null) && (state.length() > 0) && (process != null) && (stage >= 0)) {
            ProcessWizard wizard = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName()); 
            StageType xmlbStage = wizard.getWizardStage(this, stage);
    
            if (xmlbStage != null) {
                StateType xmlbState = wizard.getState(xmlbStage, state);
                if ((xmlbState != null) && xmlbState.isSetContext())
                    return xmlbState.getContext();
            }
        }       
        return null;
    }

	public int getIndex() {
		return stageParameters.index;
	}

	public void resetIndex() {
		stageParameters.index = -1;
	}

	public void setIndex(int i) {
		stageParameters.index = i;
	}

    public String getList() {
        return stageParameters.list;
    }
    
    public void setList(String list) {
        stageParameters.list = list;
    }
    
	public int getNextStage() {
		return stage + 1;
	}

	public int getPreviousStage() {
		return stage - 1;
	}

	public String getStageName() {
        if ((process != null) && (stage >= 0)) {
            ProcessWizard wizard = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName()); 
            StageType xmlbStage = wizard.getWizardStage(this, stage);
    
            if (xmlbStage != null)
                return xmlbStage.getName();
        }
		return null;
	}

	public int getStage() {
		return stage;
	}
    
    public void setStageSaved(int stage) {
        setStageSaved(stage, true);
    }
    
    public void setStageSaved(int stage, boolean saved) {
        if ((stage >=0) && (stage < stages.size()))
            getStageParameters(stage).saved = saved;
    }
    
    public void setStageSaved(HttpServletRequest request, String stageName) {
        setStageSaved(request, stageName, true);
    }

    public void setStageSaved(HttpServletRequest request, String stageName, boolean saved) {
        for (int i = 0; i < sizeOfStageArray(); i++) {
            ProcessWizard processWizard = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName()); 
            StageType xmlbStage = processWizard.getWizardStage(getStageArray(i));
            if (stageName.equals(xmlbStage.getName())) {
                if (!saved) { // Check if the stage has a selection list with complete entries.
                    for (Object object : processWizard.getSelectedLists(xmlbStage)) {
                        if (processWizard.getItems(request, (SelectType)object) != null)
                            saved = true;
                    }
                }
                setStageSaved(i, saved);
            }
        }
    }

    public boolean isStageSaved(int stage) {
        return getStageParameters(stage).saved;
    }
    
	public void setNext(String pNext) {
		if (stage >= nextStage.size())
			nextStage.setSize(stage + 1);
			
		nextStage.add(stage,pNext);
	}

	public String getNext() {
		if ((stage >= 0) && (stage < nextStage.size()))
			return (String)nextStage.get(stage);		
			
		return null;
	}
	
	public void setPrevious(String pPrevious) {
		if (stage >= prevStage.size())
			prevStage.setSize(stage + 1);
			
		prevStage.add(stage,pPrevious);
	}

	public String getPrevious() {
		if ((stage >= 0) && (stage < prevStage.size()))
			return (String)prevStage.get(stage);		
			
		return null;
	}
	
	public String getHomeAction() {
		return homeAction;
	}

	public void setHomeAction(String string) {
		homeAction = string;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String string) {
		site = string;
	}
	
	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String string) {
		pdfFile = string;
	}

    public String resetPdfFile() {
        String result = pdfFile;
        pdfFile = null;
        return result;
    }

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String resetMessage() {
        String result = message;
        message = null;
        return result;
    }

    // Package only methods
	ProcessType getProcess() {
		return process;
	}

	void setProcess(ProcessType process) {
		this.process = process;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	public VelocityContext getVelocityContext() {
		return velocityContext;
	}

	public void setVelocityContext(VelocityContext velocityContext) {
		this.velocityContext = velocityContext;
	}

	public String getStagePackage() {
        if ((process != null) && (stage >= 0)) {
            StageType xmlbStage = ((ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName())).getWizardStage(this, stage);
    
            if (xmlbStage instanceof StageDefType)
                if (((StageDefType)xmlbStage).isSetPackage())
                    return ((StageDefType)xmlbStage).getPackage();
            
            return process.getPackage();
        }       
        return null;
        
    }
    
    public Collection getStageArray() {
        return stageArray;
    }

    public StageType getStageArray(int index) {
        return stageArray.get(index);
    }
    
    public void removeStage(int index) {
        stageArray.remove(index);
    }
    
    public int sizeOfStageArray() {
        return stageArray.size();
    }
    
    public void setStageArray(StageType[] stageArray) {

        this.stageArray = new Vector<StageType>(stageArray.length);

        for (int i = 0; i < stageArray.length; i++) {
            this.stageArray.add((StageType)stageArray[i].copy());
        }
    }

    public void setSiteData(String name, String title, String home) {
        this.site = name;
        
        this.siteTitle = title;
        this.home = home;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getProcessName() {
        return getProcess().getName();
    }

    boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public Template getDisplayTemplate() {
        return displayTemplate;
    }

    public void setDisplayTemplate(File template) {
        if ((this.displayTemplate == null) && (template != null) && template.exists()) 
            this.displayTemplate = VelocityUtils.getVelocityTemplate(template); 
    }

    public Template getTagTemplate() {
        return tagTemplate;
    }

    public void setTagTemplate(File template) {
        if ((this.tagTemplate == null) && (template != null) && template.exists()) 
            this.tagTemplate = VelocityUtils.getVelocityTemplate(template); 
    }
    
    public boolean isEndStage() {
        return endStage;
    }

    public void setEndStage(boolean endStage) {
        this.endStage = endStage;
        if (endStage) {
            ProcessWizard wizard = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(process.getName()); 
            StageType xmlbStage = wizard.getWizardStage(this, stage);
    
            if (xmlbStage != null) {
//                stageParameters.state = xmlbStage.getDefault();
                setState(xmlbStage.getDefault());
            }
        }
    }

    public String getSeasonLabel() {
        return seasonLabel;
    }

    public void setSeasonLabel(String seasonLabel) {
        this.seasonLabel = seasonLabel;
    }

    public boolean isStageOk() {
        return stageOk;
    }

    public void setStageOk(boolean stageOk) {
        this.stageOk = stageOk;
    }

    public WizardListener getWizardListener() {
        return wizardListener;
    }

    public void setWizardListener(Object wizardListener) {
        if (wizardListener instanceof WizardListener)
            this.wizardListener = (WizardListener)wizardListener;
    }

    public StageType getXmlStage() {
        return xmlStage;
    }

    public void setXmlStage(StageType xmlStage) {
        this.xmlStage = xmlStage;
    }

}