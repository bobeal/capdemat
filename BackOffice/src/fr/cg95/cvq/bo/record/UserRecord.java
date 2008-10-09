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
 package fr.cg95.cvq.bo.record;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.wizard.StringUtils;

/**
 * @author René le CLERCQ
 */
public class UserRecord implements IResultRecord {

	private static final long serialVersionUID = 2440080708182523819L;
	
	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;
	private String profile;
	private Boolean active;
	
	private boolean RO;
    private boolean RW;
    private boolean manager;
	
	private HashMap categoryProfiles = new HashMap();
	
	private DisplayColumn adminUserColumns[] =
		{
			new DisplayColumn("fullName", "Nom de l'agent", false, null, 8),
			new DisplayColumn("login", "Login de l'agent", false, null, 15),
            new DisplayColumn("RO", "R", "check", false, null),
            new DisplayColumn("RW", "R/W", "check", false, null),
            new DisplayColumn("manager", "M", "check", false, null)};

	/**
	 */
	public UserRecord() {
		super();
	}

    public Long getResultId() {
        return id;
    }
    
	public void load() {
	}

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

	public void clearCategoryProfile() {
		categoryProfiles.clear();
	}
	
	public void addCategoryProfile(Long categoryId, int profile) {
		categoryProfiles.put(categoryId, new Integer(profile));
	}
	
	public int getCategoryProfile(Long categoryId) {
		Integer profile = (Integer)categoryProfiles.get(categoryId);
		if (profile != null)
			return profile.intValue();
			
		return ProfileManager.PROFILE_NONE;
	}
	
    public Collection getCategoryProfiles() {
        return categoryProfiles.entrySet();
    }
    
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getProfile() {
		return profile;
	}

	public void setFirstName(String string) {
		firstName = string;
	}

	public void setLastName(String string) {
		lastName = string;
	}

	public void setProfile(String string) {
		profile = string;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		id = long1;
	}

	public boolean isRO() {
		return RO;
	}

	public boolean isRW() {
		return RW;
	}

	public void setRO(boolean b) {
		RO = b;
	}

	public void setRW(boolean b) {
		RW = b;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String string) {
		password = string;
	}

    public String getLogin() {
        return login;
    }

    public String getDisplayLogin() {
        return StringUtils.truncateLine(login,30);
    }

	public void setLogin(String string) {
		login = string;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return adminUserColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manage) {
        this.manager = manage;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
