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
package fr.cg95.cvq.bo.manager;

import java.io.Serializable;
import java.util.BitSet;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 */
public class ProfileManager implements Serializable {

	private static final long serialVersionUID = 868419518063105908L;
	
	public final static int PROFILE_RW = 0;
	public final static int PROFILE_RO = 1;
	public final static int PROFILE_MANAGER = 2;
    public final static int PROFILE_ADMIN = 4;
    public final static int PROFILE_NONE = 8;
	
	public final static String PROFILE_STRING_RW = "R/W";
    public final static String PROFILE_STRING_RO = "R/O";
    public final static String PROFILE_STRING_MANAGER = "Manager";
	public final static String PROFILE_STRING_ADMIN = "Admin";
	
	private BitSet profile = new BitSet();
	private StateManager stateManager = null;
	
	/**
	 */
	public ProfileManager(StateManager stateManager) {
		super();
		this.stateManager = stateManager;
	}

	public void setProfile(String profileString) {
		profile.clear();
		if (profileString != null) {
			if (profileString.equals(PROFILE_STRING_ADMIN))
				profile.set(PROFILE_ADMIN);
			
			if (profileString.equals(PROFILE_STRING_RW))
				profile.set(PROFILE_RW);
            
            if (profileString.equals(PROFILE_STRING_RO))
                profile.set(PROFILE_RO);
            
            if (profileString.equals(PROFILE_STRING_MANAGER))
                profile.set(PROFILE_MANAGER);
		}
	}
	
	public String getProfile() {
		
		String profileString = "";
		
		if (profile.get(PROFILE_ADMIN))
			profileString += PROFILE_STRING_ADMIN;
			
		if (profile.get(PROFILE_RW))
			profileString += PROFILE_STRING_RW;
			
		if (profile.get(PROFILE_RO))
			profileString += PROFILE_STRING_RO;
			
		return profileString;
	}
	
    public boolean isAdmin() {
        return profile.get(PROFILE_ADMIN);
    }
    
    public boolean isCard() {
        return profile.get(PROFILE_ADMIN);
    }
    
    public boolean isManagerprofile() {
        return BusinessManager.managesCategories();
    }
    
    public boolean isRoprofile() {
        return profile.get(PROFILE_RO) || profile.get(PROFILE_ADMIN);
    }
    
	public boolean isRwprofile() {
		return profile.get(PROFILE_RW) || profile.get(PROFILE_ADMIN);
	}
	
	public boolean isReadonly() {
		if (!isUserReadWrite())
			return true;

		if (!isTabEnabled())
			return true;
			
		return profile.get(PROFILE_RO) || profile.get(PROFILE_ADMIN);
	}
	
	public boolean isReadwrite() {
		if (!isUserReadWrite())
			return false;

		if (!isTabEnabled())
			return false;
			
		return profile.get(PROFILE_RW) || profile.get(PROFILE_ADMIN);
	}
	
	private boolean isTabEnabled() {
		ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState(stateManager.getSession(), stateManager.getWindowIndex());
		String tabId = wizardState.getTabId();
		if (stateManager.getSelectedRecord() instanceof RequestRecord) {
			RequestRecord record = (RequestRecord)stateManager.getSelectedRecord();
			if ((tabId != null) && !tabId.equalsIgnoreCase(record.getStep()))
				return false;
		}
		return true;		
	}
	
	private boolean isUserReadWrite() {
		try {
			if (stateManager.getSelectedRecord() instanceof RequestRecord) {
				RequestRecord record = (RequestRecord)stateManager.getSelectedRecord();
				UserRecord user = stateManager.getCurrentUser();
					int categoryProfile = user.getCategoryProfile(record.getCategory().getId());
		
					return (categoryProfile == PROFILE_RW);
			}
		} catch (NullPointerException npe) {
		}
		return false;		
	}
	
}
