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
package fr.cg95.cvq.wizard.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import fr.cg95.cvq.wizard.VelocityUtils;

/**
 * @author René le CLERCQ
 */
public class ManagerWizardState {

    public final static String WIZARD_REQUEST_PARAMETER = "wizard";
    public final static String NAME_REQUEST_PARAMETER = "name";
	public final static String RESET_REQUEST_PARAMETER = "reset";
	public final static String EMPTY_REQUEST_PARAMETER = "empty";
    public final static String TRANSITION_REQUEST_PARAMETER = "transition";
    public final static String SUBMENU_REQUEST_PARAMETER = "submenu";
	public final static String INDEX_REQUEST_PARAMETER = "index";
	public final static String USER_REQUEST_PARAMETER = "wizard_user";
	public final static String TAB_REQUEST_PARAMETER = "tab";

    private final static String SESSION_KEY = "ManagerWizardState";

	private int tab = 0;
    private int wizard = 0;
    private String site = "";
	private String manager = "";
    private String popup = null;
    private String pdfFile = null;
    private String alert = null;
	private String user = null;
	private boolean emptyContent = false;
    
    private String siteTitle = "";
    private String application = "";
    private String home = "";
    private String homeLabel = "";
    private List properties = new ArrayList();
    
    private HashMap<String, String> menuCaptions = new HashMap<String, String>();
	
    private Template displayTemplate = null;
    private Template tagTemplate = null;

    private VelocityContext velocityContext = new VelocityContext();

	private class TabParameters {
		int index = 0;
        String state = "";
        String submenu = "";
        String process = "";
	}

	private Vector tabs = new Vector();
	private TabParameters tabParameters = null;
	
	public ManagerWizardState() {
		super();
	}

    public static ManagerWizardState getWizardState(HttpServletRequest request) {
        int wizard = 0;
        try {
            wizard =
                Integer.parseInt(
                    ManagerWizardPlugin.getParameter(
                        request,
                        ManagerWizardState.WIZARD_REQUEST_PARAMETER));
        } catch (Exception e) {
        }
        return getWizardState(request.getSession(), wizard);
    }
    
    public static ManagerWizardState getWizardState(HttpSession session, int wizard) {
        ArrayList<ManagerWizardState> states = 
            (ArrayList<ManagerWizardState>) session.getAttribute(ManagerWizardState.SESSION_KEY); 

        if ((states != null) && (wizard < states.size()))
            return states.get(wizard);

        return null;
    }
    
    public static ManagerWizardState addWizardState(HttpServletRequest request) {
        int wizard = 0;
        try {
            wizard =
                Integer.parseInt(
                    ManagerWizardPlugin.getParameter(
                        request,
                        ManagerWizardState.WIZARD_REQUEST_PARAMETER));
        } catch (Exception e) {
        }
        ManagerWizardState wizardState = new ManagerWizardState();
        wizardState.setWizard(wizard);
            
        ArrayList<ManagerWizardState> states = 
            (ArrayList<ManagerWizardState> ) request.getSession().getAttribute(ManagerWizardState.SESSION_KEY); 
        
        if (states == null) { 
            states = new ArrayList<ManagerWizardState>();
            request.getSession().setAttribute(ManagerWizardState.SESSION_KEY, states);
        }
        
        if (wizard > states.size())
            states.ensureCapacity(wizard+1);
        states.add(wizard, wizardState);
        
        return wizardState;
    }
    
	public void resetTab() {
		tabs.clear();
		setTab(0);
	}
	
	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
		tabParameters = getTabParameters(tab);
	}

	private TabParameters getTabParameters(int tab) {
		TabParameters params = null;
		try {
			params = (TabParameters)tabs.get(tab);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			tabs.setSize(tab+1);
		}
		if (params == null) {
			params = new TabParameters();
			tabs.add(tab,params);
		}
		return params;
	}
	
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void init() {
		tab = 0;
	}

	public int getIndex() {
		return tabParameters.index;
	}

	public void setIndex(int i) {
		tabParameters.index = i;
	}

    public void setState(String string) {
        tabParameters.state = string;
    }

    public String getState() {
        return tabParameters.state;
    }

    public void setSubmenu(String string) {
        tabParameters.submenu = string;
    }

    public String getSubmenu() {
        return tabParameters.submenu;
    }

    public void setProcess(String string) {
        tabParameters.process = string;
    }

    public String getProcess() {
        return tabParameters.process;
    }

	public String getPopup() {
		return popup;
	}

	public void setPopup(String string) {
		popup = string;
	}
	
    public String getTabId() {
        return ManagerWizardPlugin.getTabId(manager, tab);
    }

    public String getTabId(HttpServletRequest request) {
        String requestedTab = request.getParameter(ManagerWizardState.TAB_REQUEST_PARAMETER);
        if (requestedTab != null) {
            try {
                int rtab = Integer.parseInt(requestedTab);

                return ManagerWizardPlugin.getTabId(manager, rtab);

            } catch (NumberFormatException nfe) {
            }
        }
        return ManagerWizardPlugin.getTabId(manager, tab);
    }

	public String getUser() {
		return user;
	}

	public void setUser(String string) {
		user = string;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String string) {
		site = string;
	}

	public VelocityContext getVelocityContext() {
		return velocityContext;
	}

	public void setVelocityContext(VelocityContext velocityContext) {
		this.velocityContext = velocityContext;
	}

    public Template getDisplayTemplate() {
        return displayTemplate;
    }
    
    public boolean hasDisplayTemplate() {
        return displayTemplate != null;
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
    
    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        setAlert(alert, false);
    }
    
    public void setAlert(String alert, boolean multiLine) {
        if (alert != null) {
            if (!multiLine)
                alert = alert.replaceAll("\n", "");
            else 
                alert = alert.replaceAll("\n", "\\\\n");
        }
        this.alert = alert;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String resetPdfFile() {
        String result = pdfFile;
        pdfFile = null;
        return result;
    }

    public void setSiteData(String application, String name, String title, String home, String homeLabel) {
        this.application = application;
        this.site = name;
        
        this.siteTitle = title;
        this.home = home;
        this.homeLabel = homeLabel;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
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

    public void setMenuCaption(String menu, String menuCaption) {
        menuCaptions.put(menu, menuCaption);
    }
    
    public String getMenuCaption(String menu) {
        String menuCaption = menuCaptions.get(menu);
        if (menuCaption != null)
            return menuCaption;

        return menu;
    }
    
    public void setHome(String home) {
        this.home = home;
    }

    public Object[] getProperties() {
        if (properties != null)
            return properties.toArray();
        return null;
    }

    public void setProperties(List properties) {
        this.properties = properties;
    }

    public String getHomeLabel() {
        return homeLabel;
    }

    public void setHomeLabel(String homeLabel) {
        this.homeLabel = homeLabel;
    }

    public int getWizard() {
        return wizard;
    }

    public void setWizard(int wizard) {
        this.wizard = wizard;
    }

    public boolean getNavigate() {
        return wizard == 0;
    }

    public boolean isEmptyContent() {
        return emptyContent;
    }

    public void setEmptyContent(boolean emptyContent) {
        this.emptyContent = emptyContent;
    }
    
}
