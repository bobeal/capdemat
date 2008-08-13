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
import java.util.Iterator;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.authority.PlaceReservationType;

/**
 * @author René le CLERCQ
 */
public class RequestTypeRecord implements IResultRecord {

	private static final long serialVersionUID = -5897690533005211193L;
    
    public static final int SELECTED = 1;
    public static final int DOCUMENTS = 2;
    public static final int SEASONS = 3;
    public static final int ALERTS = 4;
    public static final int PARAMETERS = 5;
    public static final int FILES = 6;
    public static final int INFORMATION = 7;
    public static final int ACTIVATED = 8;
	
    private int groupId = -1;
    private Long id = null;
    private String label = null;
    private String type = null;
	private Long categoryId = null;
    private Integer maxDelay = null;
    private Integer alertDelay = null;
	private boolean treated = false;
	private boolean activated = false;
    private boolean seasonable = false;

    private String informationLabel = null;
    private String informationFile = null;
    
    private Collection parameters = null;
    private boolean configurable = false;
    
    private Collection letterTypes;
    
    private boolean managerProfile = false;

    private int parameterState = SELECTED;
    
	private DisplayColumn adminRTypeColumns[] =
		{
			new DisplayColumn("label", "Type de demande", false, null),
			new DisplayColumn("treated", "Instruction", "check", false, null)};
	
	private DisplayColumn activeRTypeColumns[] =
		{
			new DisplayColumn("label", "Type de demande", false, null),
			new DisplayColumn("activated", "Active", "check", false, null)};

    /**
	 */
	public RequestTypeRecord() {
		super();
	}

	public void reset() {
		treated = false;
//        activated = false;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String string) {
		label = string;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long long1) {
		categoryId = long1;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean b) {
		treated = b;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		id = long1;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		if ((type != null) && (type.equals("active")))
			return activeRTypeColumns;

		return adminRTypeColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public Integer getAlertDelay() {
        return alertDelay;
    }

    public void setAlertDelay(Integer alertDelay) {
        this.alertDelay = alertDelay;
    }

    public Integer getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(Integer maxDelay) {
        this.maxDelay = maxDelay;
    }

    public int getParameterState() {
        return parameterState;
    }

    public void setParameterState(int parameterState) {
        this.parameterState = parameterState;
    }

    public void setParameterState() {
        if (isConfigurable()) {
            boolean first = true;
            Iterator iter = parameters.iterator();
            boolean isConfigured = iter.hasNext();
            while (iter.hasNext()) {
                Object data = iter.next();
                if (data instanceof LocalReferentialType) {
                    Collection entries = ((LocalReferentialType)data).getEntries(); 
                    if((entries == null) || entries.isEmpty())
                        isConfigured = false;
                }
                else if (data instanceof PlaceReservationType) {
                    if (first) {
                        isConfigured = false;
                        first = false;
                    }                    
                    Collection tickets = ((PlaceReservationType)data).getTicketsSelection(); 
                    if ((tickets != null) && !tickets.isEmpty())
                        isConfigured = true;
                }
            }
            if (isConfigured)
                this.parameterState = ACTIVATED;
            else
                this.parameterState = PARAMETERS;

        } else {
            this.parameterState = ACTIVATED;
        }
    }

    public boolean isSeasonable() {
        return seasonable;
    }

    public void setSeasonable(boolean seasonable) {
        this.seasonable = seasonable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }
    
    public boolean isConfigurable() {
        return configurable;
        //        return (parameters != null) && !parameters.isEmpty();
    }

    public Collection getLetterTypes() {
        return letterTypes;
    }

    public void setLetterTypes(Collection letterTypes) {
        this.letterTypes = letterTypes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection getParameters() {
        return parameters;
    }

    public void setParameters(Collection parameters) {
        this.parameters = parameters;
    }

    public void setInformation(String label, String file) {
        this.informationLabel = label;
        this.informationFile = file;
    }
    
    public String getInformationLabel() {
        return this.informationLabel;
    }
    
    public String getInformationFile() {
        return this.informationFile;
    }
    
    public boolean hasInformation() {
        return this.informationFile != null;
    }

    public boolean isManagerProfile() {
        return managerProfile;
    }

    public void setManagerProfile(boolean managerProfile) {
        this.managerProfile = managerProfile;
    }

}
