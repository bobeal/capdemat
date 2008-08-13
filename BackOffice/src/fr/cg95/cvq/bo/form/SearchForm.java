/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil G�n�ral du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and Ren� le Clercq 
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
 package fr.cg95.cvq.bo.form;

import java.util.StringTokenizer;

/**
 * @author Ren� le CLERCQ
 */
public class SearchForm extends SearchBaseForm {

    public static final int CREATION_DATE = 1;
    public static final int MODIFICATION_DATE = 2;
    
    private static final long serialVersionUID = -6314797368315883529L;

	private String search;

	private String type;
	private String state;
	private String lastName;
	private String firstName;
	private String task;
	private String birthDate;
	private String periodBegin;
	private String periodEnd;
	private Long demandId;
	private Long familyId;
	private String lastAgent;
	private Long lastAgentId;
	private String service;
    private String bankReference;
    private String broker;
    
    private int dataType = CREATION_DATE; 
    
	public SearchForm() {
		super();
	}

	public Long getFamilyId() {
		return familyId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastAgent() {
		return lastAgent;
	}

	public Long getLastAgentId() {
		return lastAgentId;
	}

	public void setLastAgentId(Long lastAgentId) {
		this.lastAgentId = lastAgentId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getState() {
		return state;
	}

	public String getTask() {
		return task;
	}

	public String getType() {
		return type;
	}

	public void setFamilyId(Long i) {
		if ((i == null) || (i.longValue() == 0))
			familyId = null;
		else
			familyId = i;
	}

	public void setFirstName(String string) {
		firstName = string;
	}

	public void setLastAgent(String string) {
		lastAgent = string;
	}

	public void setLastName(String string) {
		lastName = string;
	}

	public void setState(String string) {
		state = string;
	}

	public void setTask(String string) {
		task = string;
	}

	public void setType(String string) {
		type = string;
	}

	public String getPeriodBegin() {
		return periodBegin;
	}

	public String getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodBegin(String string) {
		periodBegin = string;
	}

	public void setPeriodEnd(String string) {
		periodEnd = string;
	}

	public String getPeriod() {
		return getPeriodBegin() + ";" + getPeriodEnd();
	}
	
	public void setPeriod(String period) {
		StringTokenizer st = new StringTokenizer(period,";");
		
		if (st.hasMoreTokens()) 
			setPeriodBegin(st.nextToken());
			
		if (st.hasMoreTokens()) 
			setPeriodEnd(st.nextToken());
	}
	
	public String getBirthDate() {
		return birthDate;
	}

	public String getSearch() {
		return search;
	}

	public void setBirthDate(String string) {
		birthDate = string;
	}

	public void setSearch(String string) {
		search = string;
	}

	public Long getDemandId() {
		return demandId;
	}

	public void setDemandId(Long long1) {
		if ((long1 == null) || (long1.longValue() == 0))
			demandId = null;
		else
			demandId = long1;
	}

	public void reset() {
		type = null;
		state = null;
		lastName = null;
		firstName = null;
		task = null;
		birthDate = null;
		periodBegin = null;
		periodEnd = null;
		demandId = null;
		familyId = null;
		lastAgent = null;
        bankReference = null;
        broker = null;
	}

    public String getService() {
		return service;
	}

	public void setService(String string) {
		service = string;
	}

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getBankReference() {
        return bankReference;
    }

    public void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

}
