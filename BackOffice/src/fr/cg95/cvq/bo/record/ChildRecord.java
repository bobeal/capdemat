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

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class ChildRecord extends IndividualRecord {

	private static final long serialVersionUID = -9131399147258558935L;

	private String observations;
	private String school = "";
	private String section = "";
	private boolean canteen = false;
	
	private ArrayList siblings = null;
	
	private ArrayList legalResponsibles = new ArrayList();

	private DisplayColumn childColumns[] =
		{
			new DisplayColumn("name", "Nom", false, null),
			new DisplayColumn("birthDate", "Date de naissance", false, null),
			new DisplayColumn("school", "Etablissement", false, null),
			new DisplayColumn("section", "Classe", false, null),
			new DisplayColumn("canteen", "Inscrit à la cantine", false, null)};

	/**
	 */
	public ChildRecord() {
		super();
	}

	/**
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 */
	public void setObservations(String string) {
		observations = string;
	}

	public ArrayList getLegalResponsibles() {
		return legalResponsibles;
	}

	public void addLegalResponsible(IndividualRecord responsible) {
		legalResponsibles.add(responsible);
	}

	public boolean isCanteen() {
		return canteen;
	}

	public String getSchool() {
		return school;
	}

	public String getSection() {
		return section;
	}

	public void setCanteen(boolean b) {
		canteen = b;
	}

	public void setSchool(String string) {
		school = string;
	}

	public void setSection(String string) {
		section = string;
	}

	public ArrayList getSiblings() {
		if (siblings == null)
			siblings = BusinessManager.findFamilyMembers(getFamilyId()).getSiblings(this);
			
		return siblings;
	}

	public void addSibling(ChildRecord sibling) {
		siblings.add(sibling);
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		if (type == null)
			return super.getDisplayColumns(pageContext, type);
			
		else if (type.equals("children"))
			return childColumns;
			
		return null;
	}

	   public String getNavigateAction(PageContext pageContext) {
	        ManagerWizardState wizardState = 
	            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
	                
	        if ((wizardState.getTabId() != null) && wizardState.getTabId().equals("instruction"))
	            return null;
	        
	        return super.getNavigateAction(pageContext);
	    }


}
