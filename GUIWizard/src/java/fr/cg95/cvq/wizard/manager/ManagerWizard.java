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

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import fr.cg95.cvq.wizard.DateUtils;
import fr.cg95.cvq.wizard.IWizardSession;
import fr.cg95.cvq.wizard.StringUtils;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerActionType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerButtonType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerConditionType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerConfirmType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerContentType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerDetailType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerDisplayProcessType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerDisplayType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerMenuType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerSelectType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerSessionType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerStateType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerTabType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerTimeoutType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerType;
import fr.cg95.cvq.wizard.process.ProcessWizardGroup;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.xmlbean.ConfirmType;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;

/**
 * @author René le CLERCQ
 */
public class ManagerWizard {

	/** Commons Logging instance. */
	protected static Logger log = Logger.getLogger(ManagerWizard.class);

	private ManagerType xmlbManager = null;
	private ManagerTabType xmlbTab = null;
	private PageContext pageContext = null;
	private ManagerWizardState wizardState = null;
	private String contextPath;

	public ManagerWizard() {
		super();
	}

	public ManagerWizard(ManagerType xmlbManager) {
		super();
		this.xmlbManager = xmlbManager;
	}

    public static IWizardSession loadSessionObject(HttpSession session, boolean init) {
        return loadSessionObject(session, 0, init);
    }
    
    public static IWizardSession loadSessionObject(HttpSession session, int wizard, boolean init) {
		// Start a new session
		try {
            IWizardSession sessionObject = getSessionObject(session);

            if (sessionObject == null) {
                ManagerSessionType xmlbSession =
                    ManagerWizardPlugin.plugin().getGlobals().getSession();

                sessionObject =
                    (IWizardSession) Class.forName(xmlbSession.getType()).newInstance();
                
                session.setAttribute(xmlbSession.getData(), sessionObject);
            }
			if (init)
				sessionObject.init(session, wizard);
			
			return sessionObject;
			
		} catch (ClassNotFoundException cnfe) {
		} catch (IllegalAccessException iae) {
		} catch (InstantiationException ie) {
		} catch (NullPointerException npe) {
		}
		return null;
	}

    public static IWizardSession getSessionObject(HttpSession session) {
        ManagerSessionType xmlbSession =
            ManagerWizardPlugin.plugin().getGlobals().getSession();

        IWizardSession sessionObject =
            (IWizardSession) session.getAttribute(xmlbSession.getData());

        return sessionObject;
    }
    
    public static void removeSessionObject(HttpSession session) {
        ManagerSessionType xmlbSession =
            ManagerWizardPlugin.plugin().getGlobals().getSession();

        session.removeAttribute(xmlbSession.getData());
    }
    
	/**
	 * Initialise the wizard in the given PageContext - 
	 * Try to get the current wizardState, if not create one
	 */
	public void init(PageContext pageContext) throws JspException {
		this.pageContext = pageContext;
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		contextPath = request.getContextPath();
		try {
			wizardState = ManagerWizardState.getWizardState(request);
		} catch (Exception e) {
			wizardState = null;
		}
		if (wizardState == null) {
			wizardState = ManagerWizardState.addWizardState(request);
			wizardState.setUser((String)request.getAttribute(ManagerWizardState.USER_REQUEST_PARAMETER));
			wizardState.setVelocityContext(new VelocityContext());
			wizardState.setEmptyContent(
                ManagerWizardPlugin.getParameter(request, ManagerWizardState.EMPTY_REQUEST_PARAMETER) != null);
		}
		wizardState.setManager(xmlbManager.getName());
		if (ManagerWizardPlugin
			.getParameter(request, ManagerWizardState.NAME_REQUEST_PARAMETER) != null) {
			// Start a new session
			loadSessionObject(
				request.getSession(),
                wizardState.getWizard(),
				ManagerWizardPlugin.getParameter(
					request,
					ManagerWizardState.RESET_REQUEST_PARAMETER)
					!= null);
		}
	}

	public void testPage(Writer out) throws IOException {
		if (wizardState == null) {
			wizardState = new ManagerWizardState();
		}
		wizardState.setManager(xmlbManager.getName());
		wizardState.setTab(0);
		wizardState.setUser("ManagerTest");
		
		xmlbTab = getTabDefinition(wizardState.getTab());
		
		wizardPage(out);
	}
	
	public void page(PageContext pageContext) throws JspException {
		if (ManagerWizardPlugin.getParameter(pageContext.getRequest(),
				ManagerWizardState.RESET_REQUEST_PARAMETER) != null) {
			wizardState.resetTab();
		}

		int tab = wizardState.getTab();

        xmlbTab = getTabDefinition(tab);
            
        while ((xmlbTab != null) && !display(xmlbTab.getConditionArray())) {
            if (wizardState.getTab() == 0)
                tab++;
            else
                tab = 0;
            
            xmlbTab = getTabDefinition(tab);
        }
        if (xmlbTab != null) {
            wizardState.setTab(tab);
			//			if (initialize)
			//				wizardState.setAction(xmlbTab.getDefault());

			setScopeVariables(xmlbTab);
			
			wizardPage(pageContext.getOut());

            wizardState.setAlert(null);
            wizardState.setProcess("");

        } else {
			wizardState.init();

			throw new JspException("Manager Wizard: selected tab out of range");
		}
	}
	
	private void setScopeVariables(ManagerTabType tab) {
		if (tab.isSetHeader())
			setScope(tab.getHeader());
		
		if (tab.sizeOfFormArray() > 0)
			for (int form = 0; form < tab.sizeOfFormArray(); form++) 
				setScope(tab.getFormArray(form));
		else if (tab.isSetProcess()) {
		    ManagerStateType xmlbState = displayProcess(tab, tab.getProcess());
            if (xmlbState != null) {
                for (int i = 0; i < xmlbState.sizeOfFormArray(); i++)
                    setScope(xmlbState.getFormArray(i));
            }
        }
		if (tab.isSetFooter())
			setScope(tab.getFooter());
	}

	private void setScope(ManagerContentType content) {
		if (content.isSetScope() && displayForm(content)) {
			if (content.getScope().equalsIgnoreCase("page"))
				pageContext.setAttribute("ManagerContent",content.getStringValue() +".jsp");
			
			else if (content.getScope().equalsIgnoreCase("request"))
				pageContext.getRequest().setAttribute("ManagerContent",content.getStringValue() +".jsp");
			
			else if (content.getScope().equalsIgnoreCase("session"))
				pageContext.getSession().setAttribute("ManagerContent",content.getStringValue() +".jsp");
		}

	}

	private void wizardPage(Writer out) {
        Template managerTemplate = wizardState.getDisplayTemplate();
        if (managerTemplate == null)
            managerTemplate = ManagerWizardPlugin.plugin().getManagerTemplate();
        
		VelocityContext velocityContext = wizardState.getVelocityContext();

        velocityContext.put("global", ManagerWizardPlugin.plugin().getGlobals());
        velocityContext.put("globalmenus", ManagerWizardPlugin.plugin().getMenus());
		velocityContext.put("wizard", this);
		velocityContext.put("wizardstate", wizardState);
		velocityContext.put("manager", xmlbManager);
        velocityContext.put("tab", xmlbTab);
        velocityContext.put("year", DateUtils.getYear());
		
		try {
			managerTemplate.merge(velocityContext, out);

		} catch (ResourceNotFoundException e) {
			log.error("wizardPage", e);
		} catch (ParseErrorException e) {
			log.error("wizardPage", e);
		} catch (MethodInvocationException e) {
			log.error("wizardPage", e);
		} catch (Exception e) {
			log.error("wizardPage", e);
		}
	}

    public String getTimeout() {
        String result = null;
        ManagerTimeoutType xmlTimeout[] = ManagerWizardPlugin.plugin().getGlobals().getTimeoutArray();
        if (xmlTimeout != null) { 
            for (int i = 0; i < xmlTimeout.length; i++) {
                if (xmlTimeout[i].isSetCookie() && hasCookie(xmlTimeout[i].getCookie()))
                    result = String.valueOf(xmlTimeout[i].getDelay().intValue() * 60 * 1000);
                else if (!xmlTimeout[i].isSetCookie())
                    result = String.valueOf(xmlTimeout[i].getDelay().intValue() * 60 * 1000);
            }
        }
        return result;
    }

    public String getTimeoutHref() {
        String result = null;
        ManagerTimeoutType xmlTimeout[] = ManagerWizardPlugin.plugin().getGlobals().getTimeoutArray();
        if (xmlTimeout != null) { 
            for (int i = 0; i < xmlTimeout.length; i++) {
                if (xmlTimeout[i].isSetCookie() && hasCookie(xmlTimeout[i].getCookie()))
                    result = xmlTimeout[i].getHref();
                else if (!xmlTimeout[i].isSetCookie())
                    result = xmlTimeout[i].getHref();
            }
        }
        return result;
    }

    private boolean hasCookie(String cookie) {
        Cookie cookies[] = ((HttpServletRequest)pageContext.getRequest()).getCookies();
        
        if (cookies == null)
            return false;
            
        int i = 0;
        while ((i < cookies.length) && !cookies[i++].getName().equals(cookie));
        
        return (i < cookies.length);
    }
    
	public String baseReference() {
		String result = null;
		if (pageContext != null) {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			result = request.getScheme() + "://" + request.getServerName();
			if (request.getScheme().equals("http") && (request.getServerPort() == 80));
			else if (request.getScheme().equals("https") && (request.getServerPort() == 443));
			else
				result += ":" + request.getServerPort();
			result += contextPath +"/";
		}
		return result;
	}
	
	public String getVersion() {
		try {
			String version =
				(String) callGetMethod(ManagerWizardPlugin
					.plugin()
					.getGlobals()
					.getSession()
					.getData(),
					"version");
			if (version != null)
				return version;
		} catch (NullPointerException npe) {
		}
		return "0.0";
	}

    public ManagerStateType getState() throws ServletException, IOException {
        String state = wizardState.getState();
//        if (state != null) {
            ManagerStateType xmlState = (ManagerStateType)ManagerWizardPlugin.find(xmlbTab.getStateArray(),"name",state);
            if (xmlState == null)
                return (ManagerStateType)ManagerWizardPlugin.find(xmlbTab.getStateArray(),"name",xmlbTab.getDefault());
            else
                return xmlState;
//        }
//        return null;
    }
    
    public int sizeOfProcessMenus(ManagerTabType xmlTab) {
        int size = 0;
        
        for (int i = 0; i < xmlTab.sizeOfMenuArray(); i++) {
            ManagerMenuType menu = xmlTab.getMenuArray(i);
            if (displayMenu(menu) && menu.isSetProcesses()) size++;
        }
        if (size > 0) {
            ManagerMenuType menuItem = getSubmenu();
            if (menuItem == null) {
                int i = 0;
                while ((menuItem == null) && (i < xmlTab.sizeOfMenuArray())) {
                    ManagerMenuType menu = xmlTab.getMenuArray(i++);
                    if (displayMenu(menu) && menu.isSetProcesses())
                        menuItem = menu; 
                }
                if (menuItem != null)
                    wizardState.setSubmenu(menuItem.getCaption());
            }
        }
        return size;
    }

    public int sizeOfVisibleMenusAndSelect(ManagerTabType xmlTab) {
        return sizeOfVisibleMenus(xmlTab) + sizeOfVisibleSelect(xmlTab);
    }
    
    public int sizeOfVisibleMenus(ManagerTabType xmlTab) {
        int size = 0;
        for (int i = 0; i < xmlTab.sizeOfMenuArray(); i++) {
            ManagerMenuType menu = xmlTab.getMenuArray(i);
            if (displayMenu(menu)) size++;
        }
        return size;
    }

    public int sizeOfVisibleSelect(ManagerTabType xmlTab) {
        int size = 0;
        for (int i = 0; i < xmlTab.sizeOfSelectArray(); i++) {
            ManagerSelectType select = xmlTab.getSelectArray(i);
            if (display(select.getCondition(),"", "")) size++;
        }
        return size;
    }

    public int sizeOfVisibleBlock(ManagerTabType xmlTab) {
        int size = 0;
        for (int i = 0; i < xmlTab.sizeOfBlockArray(); i++) {
            ManagerStateType block = xmlTab.getBlockArray(i);
            if (display(block.getCondition(),"", "")) size++;
        }
        return size;
    }

    public boolean displayBlock(ManagerStateType block) {
        if (block != null)
            return display(block.getCondition(), "", "");
        
        return false;
    }
    
    public boolean displaySelect(ManagerSelectType select) {
        if (select != null)
            return display(select.getCondition(), "", "");
        
        return false;
    }
    
    public boolean displayTab(ManagerTabType tab) {
        if (tab != null)
            return display(tab.getConditionArray());
        
        return false;
    }
    
    public boolean displayProcess(ManagerMenuType menu, ProcessType process) {
        if (process != null)
            return display(menu.getCondition(), "\\$process", process.getName());
        
        return false;
    }
    
    public boolean displayMenu(ManagerMenuType menu) {
        List processes = null;
        if (menu.isSetProcesses())
            processes = processGroup(menu);
          
        if (processes != null) {
            for (int i = 0; i < processes.size(); i++) {
                ProcessType process = (ProcessType)processes.get(i);
                if (displayProcess(menu,process))
                    return true;
            }
        } else if (menu.isSetDisplay() && menu.getDisplay().equals("force")) {
            return true;
            
        } else if (display(menu.getCondition(),"", "")) {
            for (int i = 0; i < menu.sizeOfMenuArray(); i++) {
                if (display(menu.getMenuArray(i).getCondition(),"", ""))
                    return true;
            }
            return menu.sizeOfMenuArray() == 0;
        }
        return false;
    }
    
    public ManagerMenuType getSubmenu() {
        String caption = wizardState.getSubmenu();
        if (caption != null) {
            return (ManagerMenuType)ManagerWizardPlugin.find(xmlbTab.getMenuArray(),"caption",caption);
        }
        return null;
    }
    
    public boolean isSelected(ManagerMenuType menuItem) {
        String caption = wizardState.getSubmenu();
        if (caption != null) {
            return caption.equals(menuItem.getCaption());
        }
        return false;
    }
    
    public boolean displayForm(ManagerContentType form) {
        if (form.isSetCondition()) {
            ManagerConditionType xmlbTabCondition = null;
            if (xmlbTab.sizeOfConditionArray() > 0)
                xmlbTabCondition = xmlbTab.getConditionArray(0);

            Object tabCondition = null;
            if ((xmlbTabCondition != null) && xmlbTabCondition.isSetName())
                tabCondition = callGetMethod(xmlbTabCondition.getName(), xmlbTabCondition.getProperty());
                
            if (tabCondition != null) {
                String condition = form.getCondition();
    
                int pos = condition.indexOf("==");
                if (pos != -1) {
                    String field = condition.substring(0,pos);
                    String value = condition.substring(pos+2);
                    
                    return value.equals(ManagerWizardPlugin.callGetMethod(tabCondition, field));
                }
            }
        }
        return true;
    }
    
    public String includeJsp(ManagerContentType content) throws ServletException, IOException {
        return includeJsp("", content);
    }
    
    public String includeJsp(String prefix, ManagerContentType content) throws ServletException, IOException {
        if (displayForm(content))
            return includeJsp(prefix, content.getStringValue());
        
        return "";
	}
	
    public String includeJsp(String page) throws ServletException, IOException {
        return includeJsp("", page);
    }
    
    public String includeJsp(String prefix, String page) throws ServletException, IOException {
		String result = "";

        if (pageContext != null)
			pageContext.include(prefix + page + ".jsp");
		else
			result = "include file " + prefix + page;
		
		return result;
	}
	
	public void popup() throws ServletException, IOException {
		try {
			includeJsp(wizardState.getPopup());

		} catch (ServletException se) {
			log.error("popup", se);
		}
		wizardState.setPopup(null);
	}

    public String logoutLabel() {
        return wizardState.getHomeLabel();
    }
    
    public String logout() {
		String home = wizardState.getHome();

        if (home != null) {
    		String action = RequestUtils.getActionMappingName(home);
    		if (ManagerWizardPlugin.plugin().getConfig().findActionConfig(action) != null) {
    			if (home.indexOf(".do") == -1)
    				return home + ".do";
    			
    			return home;
    		}
    		else			 				
    			return home + ".jsp";
        }
        return null;
	}

    private boolean display(ManagerConditionType[] xmlbCondition) {
        for (int i = 0; i < xmlbCondition.length; i++) {
            if (!display(xmlbCondition[i], "", ""))
                return false;
        }
        // No condition defined, or no negative condition, we display
        return true;
    }
    
    public boolean display(ManagerConditionType xmlbCondition, String replace, String value) {
		// Check the condition to display
		if (xmlbCondition != null) {
			Object condition = null;
            String property = xmlbCondition.getProperty();
            String equalValue = null;
            String lessValue = null;
            String greaterValue = null;
            
			boolean inverse = false;
			
            if (property != null) {
                if (property.startsWith("!")) {
                    inverse = true;
                    property = property.substring(1);
                }
                if ((replace != null) && (replace.length() > 0)) {
                    property = property.replaceFirst(replace,value);
                    if (property.indexOf(value) == -1)
                        return false;
                }
                int pos = property.indexOf("==");
                if (pos != -1) {
                    equalValue = property.substring(pos+2);
                    property = property.substring(0,pos);
                }
                pos = property.indexOf("<");
                if (pos != -1) {
                    lessValue = property.substring(pos+1);
                    property = property.substring(0,pos);
                }
                pos = property.indexOf(">");
                if (pos != -1) {
                    greaterValue = property.substring(pos+1);
                    property = property.substring(0,pos);
                }
            }
            
            if (xmlbCondition.isSetParameter()) {
                condition = ManagerWizardPlugin.getParameter(pageContext.getRequest(), xmlbCondition.getParameter()) != null;
            
            } else if (xmlbCondition.isSetName()) {
				condition = callGetMethod(xmlbCondition.getName(), property);
			
            } else {
				condition = ManagerWizardPlugin.find(wizardState.getProperties(),"", xmlbCondition.getProperty());
			}
			
			if (condition != null) {
				if (condition instanceof Boolean) {
					// Condition object is a boolean, we display according to the boolean value
					return (inverse) ? !((Boolean)condition).booleanValue() : ((Boolean)condition).booleanValue();
				
                } else if (equalValue != null) {
                    if (condition instanceof String) 
                        return condition.equals(equalValue);
                    
                    if (condition instanceof Integer)
                        return condition.equals(Integer.parseInt(equalValue));
                        
                } else if ((lessValue != null) && (condition instanceof Integer)) {
                    return (Integer)condition < Integer.parseInt(lessValue);
                        
                } else if ((greaterValue != null) && (condition instanceof Integer)) {
                    return (Integer)condition > Integer.parseInt(greaterValue);
                        
                } else {
                    // Condition object available and not a boolean, we display
    				return (inverse) ? false : true;
                }
			}
			// Condition object not available we do NOT display
			return false;
		}
		// No condition defined we display
		return true;
	}

	public ManagerStateType displayProcess(ManagerTabType xmlbTab, ManagerDisplayProcessType xmlbProcess) {
		ManagerConditionType xmlbCondition = null;
		if (xmlbTab.sizeOfConditionArray() > 0)
		    xmlbCondition = xmlbTab.getConditionArray(0);
		
		if (xmlbCondition != null) {
			String type = (String) callGetMethod(xmlbCondition.getName(), xmlbProcess.getCheck());

			ManagerProcessType process = 
                (ManagerProcessType) ManagerWizardPlugin.find(
                        ManagerWizardPlugin.plugin().getProcesses().getProcessArray(), "name", type);

            String state = xmlbProcess.getState();
            int i = 0;
            while ((i < process.sizeOfStateArray()) && !process.getStateArray(i).getName().equals(state)) i++;
            
            if (i < process.sizeOfStateArray())
                return process.getStateArray(i);
		}
		return null;
	}
	
	public ManagerTabType getTabDefinition(int index) {
        if ((index >= 0) && (index < xmlbManager.getTabArray().length))
            return (ManagerTabType) xmlbManager.getTabArray(index);
        
        return null;
	}

    public String getTabHref(ManagerTabType xmlbTab, int tabIndex) {
        return getTabAction(xmlbTab, tabIndex, "", "");
    }
    
    public String getTabAction(ManagerTabType xmlbTab, int tabIndex) {
        return getTabAction(xmlbTab, tabIndex, "document.location.href='", "';");
    }
    
    public String getTabAction(ManagerTabType xmlbTab, int tabIndex, String prefix, String postfix) {
		String tabAction = "managerWizard.do";
		
		if (xmlbTab.isSetAction())
			tabAction = xmlbTab.getAction().getStringValue();
			
		else if (xmlbManager.isSetAction())
			tabAction = xmlbManager.getAction().getStringValue();

		if (tabAction.indexOf('?') > 0)
			tabAction += "&";
		else
			tabAction += "?";
						
		tabAction += ManagerWizardState.TAB_REQUEST_PARAMETER
							+ "="
							+ tabIndex;
        
		tabAction = addWizardIndex(tabAction);

		if (xmlbTab.isSetDefault()) {
			tabAction += "&" + ManagerWizardState.TRANSITION_REQUEST_PARAMETER
								+ "="
								+ xmlbTab.getDefault();
		}				
		return prefix + tabAction + postfix;
	}
	
    public String menuAction(ManagerMenuType menu, ProcessType process) {
        return menuAction(menu, process, "\\$process", process.getName());
    }
    
    public String menuAction(ManagerMenuType menu) {
        return menuAction(menu, null, "", "");
    }

    public String menuAction(ManagerMenuType menu, ProcessType process, String replace, String value) {
        return menuHref(menu, process, replace, value, "document.location.href='", "';");
    }
    
    public String menuHref(ManagerMenuType menu, ProcessType process) {
        return menuHref(menu, process, "\\$process", process.getName());
    }
    
    public String menuHref(ManagerMenuType menu) {
        return menuHref(menu, null, "", "");
    }

    public String menuHref(ManagerMenuType menu, ProcessType process, String replace, String value) {
        return menuHref(menu, process, replace, value, "", "");
    }
    
    public String menuHref(ManagerMenuType menu, ProcessType process, String replace, String value, String prefix, String postfix) {
        ManagerActionType xmlAction = menu.getAction(); 
		if (xmlAction != null) {

            boolean confirm = false;
            String bean = null;
            String check = null;
            String message = "";
            if (xmlAction.isSetConfirm()) {
                ManagerConfirmType xmlbConfirm = 
                    (ManagerConfirmType) ManagerWizardPlugin.find(xmlbTab.getConfirmArray(), "name", xmlAction.getConfirm());
                confirm = true;
                bean = ManagerWizardPlugin.plugin().getGlobals().getSession().getData();
                check = xmlbConfirm.getCheck();
                message = xmlbConfirm.getStringValue();
                
            } else if (menu.isSetProcesses() && (process != null) && (process.sizeOfConfirmArray() > 0)) {
                ConfirmType xmlbConfirm = process.getConfirmArray(0);
                confirm = false;  // For the new look we confirm later on ....
                bean = xmlbConfirm.getName();
                check = xmlbConfirm.getCheck();
                message = xmlbConfirm.getStringValue();
            }
            if (confirm) {
                if (check != null) {
                    Object condition = null;
                    if (check.length() > 0) {
                        condition = callGetMethod(bean, check);
                    }
                    
                    boolean displayAlert = true;
                    if (condition != null) {
                        if (condition instanceof Boolean)
                            // Condition object is a boolean, we display according to the boolean value
                            displayAlert = !((Boolean)condition).booleanValue();
                        else
                        // Condition object avalable and not a boolean, we display
                            displayAlert = false;
                    }
                    if (displayAlert) { 
                        return "javascript:alert('" + formatScriptText(message) + "');";
                    }
                } else {
                    prefix = "javascript:processConfirm('" + formatScriptText(message) + "','";
                    postfix = "')";
                }
            }
            
            String action = xmlAction.getStringValue();
            action = action.replaceAll(replace, value);
			if ((menu.isSetProcesses() && (process == null)) || (action == null) || (action.length() == 0)) {
				action = "managerWizard.do";

                if (!xmlAction.isSetTransition()) {
                    action += "?" + ManagerWizardState.SUBMENU_REQUEST_PARAMETER + "=" + menu.getCaption();
                }
            } else {
                String menuAction = action;
                String parameters = "";
                
                int question = menuAction.indexOf("?");
                if (question >= 0) {
                    parameters = menuAction.substring(question+1);
                    menuAction = menuAction.substring(0, question);
                }
                if (ManagerWizardPlugin.plugin().getConfig().
                        findActionConfig(RequestUtils.getActionMappingName(menuAction)) != null) {
                    if (!menuAction.endsWith(".do"))
                        menuAction += ".do";
                    
                    if (parameters.length() > 0)
                        action = menuAction + "?" + parameters;

                    action = addWizardIndex(action);

                } else {
                    prefix = "javascript:";
                    postfix = ";";
                }
            }

			String state = xmlAction.getTransition();
			
			if (xmlAction.getPopup())
				return "javascript:window.open('"	+ action
					+ "','fo','resizable=yes,top=0,left=110,width=820,height=740');";
			
			if ((state != null) && (state.length() > 0)) {
				ManagerStateType xmlbState = (ManagerStateType)ManagerWizardPlugin.find(xmlbTab.getStateArray(),"name", state);
				if (xmlbState != null) {
					if (action.indexOf('?') != -1)
						action += "&";
					else if (action.endsWith(".do"))
						action += "?";
					else 
						action += ".do?";					
						
					action += ManagerWizardState.TRANSITION_REQUEST_PARAMETER + "=" + xmlbState.getName();
				}
			}
			return prefix + action + postfix;
		}
		return "";
	}

    private String formatScriptText(String text) {
        String result = text.replaceAll("'","\\\\'");
        return result;
    }
    
    public List processGroup(ManagerMenuType menu) {
        String groupName = menu.getProcesses();
        HashMap<String, ProcessWizardGroup> groups = ProcessWizardPlugin.plugin().getProcessGroups();
        ProcessWizardGroup group = groups.get(groupName);
        if (group != null)
            return group.getProcesses(); 

        return null;
    }
    
    public ProcessType getProcess(ManagerMenuType menu) {
        if (menu.isSetProcesses()) {
            StringTokenizer processesGroup = new StringTokenizer(menu.getProcesses(), ".");
            if (processesGroup.countTokens() == 2) {
                String groupName = processesGroup.nextToken();
                String processName = processesGroup.nextToken();

                HashMap<String, ProcessWizardGroup> groups = ProcessWizardPlugin.plugin().getProcessGroups();
                ProcessWizardGroup group = groups.get(groupName);

                if (group != null)
                    for (ProcessType process : group.getProcesses()) {
                        if (process.getName().equals(processName))
                            return process;
                    }
            }
        }
        return null;
    }
    
    public String menuCaption(ManagerMenuType menu) {
        String caption = menu.getCaption();
//        if (menu.isSetProcesses()) {
//            caption = ProcessWizardPlugin.plugin().getProcessGroupCaption(menu.getProcesses());
//        }
        ManagerDetailType xmlbDetail = menu.getDetail();
		if (xmlbDetail != null) {

			String detail = (String) callGetMethod(xmlbDetail.getName(), xmlbDetail.getProperty());
			if (detail != null)
				return detail + " " + caption;
		}
		return caption;
	}

    public Collection getItems(ManagerSelectType xmlbSelect) {
		Collection collection =	(Collection) callGetMethod(xmlbSelect.getName(), xmlbSelect.getProperty());
		if ((collection == null) || collection.isEmpty())
			return null;
		
		return collection;
	}

	public String displayItem(Object item, ManagerDisplayType[] displays) {
		String select = "";
		
		for (int i= 0; i < displays.length; i++) {
            if (displays[i].isSetName()) {
    			String name = (String)ManagerWizardPlugin.callGetMethod(item, displays[i].getName());
    
    			if (select.length() > 0)
    				select = select + " ";

    			if (displays[i].isSetMaxchars())
    			    name = StringUtils.truncate(name, displays[i].getMaxchars());
    			
    			select = select + name;
            }
		}
		return select;
	}
	
	public String displayItemIcon(Object item) {
	    try {
	    String icon = (String)PropertyUtils.getProperty(item, "icon");
	    if (icon != null)
	        return icon;
	    } catch (Exception e) {
	    }
	    return "";
	}
	
    public String displayItemType(ManagerDisplayType[] displays) {
        for (int i = 0; i < displays.length; i++) {
            if (displays[i].isSetType()) {
                return displays[i].getType();
            }
        }
        return "";
    }
    
    public String onclickLink(ManagerSelectType xmlbSelect, Object item, int index) {
        return hrefLink(xmlbSelect, item, index, "document.location.href='", "'");
    }
    
    public String hrefLink(ManagerSelectType xmlbSelect, Object item, int index) {
        return hrefLink(xmlbSelect, item, index, "", "");
    }
    
    public String hrefLink(ManagerSelectType xmlbSelect, Object item, int index, String prefix, String postfix) {
		ManagerActionType xmlbAction = xmlbSelect.getAction();
        
        String action = xmlbAction.getStringValue() + ".do?";
		if (xmlbAction.getParameter().equals("index")) {
            action += ManagerWizardState.INDEX_REQUEST_PARAMETER
				+ "="
				+ index;
		} else {
			action += xmlbAction.getParameter()
    			+ "="
    			+ ManagerWizardPlugin.callGetMethod(item, xmlbAction.getParameter());
        }
        action += "&"
            + ManagerWizardState.TRANSITION_REQUEST_PARAMETER
            + "="
            + xmlbAction.getTransition();

        action = addWizardIndex(action);

        return prefix + action + postfix;
	}

	public String onClick(ManagerButtonType xmlbButton) {
		String onClick = "";

		String transition = "";
		if (xmlbButton.isSetTransition()) {
			transition = ManagerWizardState.TRANSITION_REQUEST_PARAMETER + 
						 "=" + xmlbButton.getTransition();
		}
		// confirm and action
//		ConfirmType xmlbConfirm = getConfirm(xmlbButton.getConfirm());
//		if ((xmlbConfirm != null) && !xmlbConfirm.isSetCheck()) {
//			onClick = "javascript:processConfirm('" + formatScriptText(xmlbConfirm.getStringValue()) + "','";
//			onClick += getAction(xmlbButton.getAction(), transition);
//			onClick += "')";
//		}
//		// script and action
//		else 
		if ((xmlbButton.getAction() != null) && (xmlbButton.getScript() != null)) {
			onClick = "javascript:" + xmlbButton.getScript() + "('";
			onClick += getAction(xmlbButton.getAction(), transition);
			onClick += "')";
			
		}
		// action only
		else if (xmlbButton.getAction() != null) {
			onClick = "document.location.href='";
			onClick += getAction(xmlbButton.getAction(), transition);
			onClick += "'";
		}
		// script only
		else if (xmlbButton.getScript() != null) {
			onClick = "javascript:" + xmlbButton.getScript() + ";"; 
		}										
		return onClick;										
	}
	
	private String getAction(String action, String extra) {
        if ((action != null) && (action.length() > 0)) {

			String parameters = "";
	        int question = action.indexOf("?");
	        if (question >= 0) {
	            parameters = action.substring(question+1);
	            action = action.substring(0, question);
	        }
	        if (!action.endsWith(".do"))
	        	action += ".do";
	        
	        if (parameters.length() > 0) {
	        	action += "?" + parameters;
	        	if (extra.length() > 0)
	        		action += "&" + extra;
	        }
	        else if (extra.length() > 0)
	    		action += "?" + extra;
		} else {
			action = "managerWizard.do";
	        if (extra.length() > 0)
	    		action += "?" + extra;
		}
        return addWizardIndex(action);
	}
	
	private Object callGetMethod(String param, String property) {
		Object obj = null;
		if (pageContext != null)
			try {
			    setWindowIndex();
                obj = RequestUtils.lookup(pageContext, param, property, "session");
			} catch (JspException je) {
				log.error("callGetMethod", je);
			}
		
		return obj;
	}

	private String addWizardIndex(String action) {
	    if (wizardState.getWizard() > 0) {
            if (action.indexOf('?') > 0)
                action += "&";
            else
                action += "?";
            
            action += ManagerWizardState.WIZARD_REQUEST_PARAMETER + "=" + wizardState.getWizard();
        }        
        return action;
    }
    
    private void setWindowIndex() {
	    IWizardSession sessionObject = getSessionObject(pageContext.getSession());
        if (sessionObject != null)
            sessionObject.setWindowIndex(wizardState.getWizard());
    }
    
    public ManagerType getXmlbManager() {
		return xmlbManager;
	}
    
}
