/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
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
package fr.cg95.cvq.bo.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 */
public class BaseBodyTag extends BodyTagSupport {

	private static final long serialVersionUID = 7230738681354910325L;

	protected String name;
	protected String property;
	protected String scope;
	protected String styleClass;
	protected String profile;

    protected void setWindowIndex() {
        StateManager stateManager = (StateManager) pageContext.getSession().getAttribute(
                StateManager.STATE_MANAGER);
        ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
        
        if ((stateManager != null) && (wizardState != null))
            stateManager.setWindowIndex(wizardState.getWizard());
    }
    
    protected int getWindowIndex() {
        ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
        return wizardState.getWizard();
    }
    
	protected ProfileManager getProfileManager() {
		ProfileManager profileManager = null;
		if (profile != null)
			try {
				profileManager =
					(ProfileManager) RequestUtils.lookup(
						pageContext,
						StateManager.STATE_MANAGER,
						profile,
						"session");
			} catch (Exception e) {
				e.getMessage();
			}
		return profileManager;

	}

	/**
	 */
	public String getName() {
		return name;
	}

	/**
	 */
	public String getProperty() {
		return property;
	}

	/**
	 */
	public String getScope() {
		if (scope == null)
			scope = "session";
		return scope;
	}

	/**
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 */
	public void setProperty(String string) {
		property = string;
	}

	/**
	 */
	public void setScope(String string) {
		scope = string;
	}

	/**
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 */
	public void setStyleClass(String string) {
		styleClass = string;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String string) {
		profile = string;
	}

}
