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
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.business.BusinessManager;

/**
 * @author René le CLERCQ
 */
public class FamilyRecord implements IResultRecord, IPaperHolder {

	private static final long serialVersionUID = 8975566218410119243L;

	private Long id;
    private boolean enabled = false;
    private boolean archived = false;
    private String state;
    
	private AdultRecord responsible = null;
	private ArrayList adults;
	private ArrayList children;

	private ArrayList papers;
	private PaperRecord selectedPaper = null;
	
	private ArrayList demands;
	private IResultRecord selectedDemand = null;
    private String familyQuotient;
	
	public FamilyRecord() {
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

	public ArrayList getSiblings(ChildRecord child) {
		ArrayList siblings = new ArrayList();
		
		Iterator iter = children.iterator();
		while (iter.hasNext()) {
			ChildRecord sibling = (ChildRecord)iter.next();
			if (!sibling.getId().equals(child.getId()))
				siblings.add(sibling);
		}
		return siblings;
	}
	
	public void addAdult(AdultRecord adult) {
		if (adults == null)
		adults = new ArrayList();
			
		adults.add(adult);
	}
	
	public void addChild(ChildRecord child) {
		if (children == null)
			children = new ArrayList();
			
		children.add(child);
	}

	/**
	 */
	public ArrayList getAdults() {
		return adults;
	}

	/**
	 */
	public ArrayList getChildren() {
		return children;
	}

	public ArrayList getPapers() {
		return papers;
	}

	public void addPaper(PaperRecord paper) {
		if (papers == null)
			papers = new ArrayList();
			
		if (!paperExists(paper))
			papers.add(paper);
	}

	private boolean paperExists(PaperRecord paper) {
		if (papers != null) {
			int i = 0;
			while ((i < papers.size()) && !((PaperRecord)papers.get(i)).getId().equals(paper.getId())) i++;
			
			return i < papers.size();
		} 
		return false;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		id = long1;
	}

	public IResultRecord getSelectedPaper() {
		return selectedPaper;
	}

	public void setSelectedPaper(IResultRecord record, String page) {
		selectedPaper = (PaperRecord)record;
		if (page != null)
			selectedPaper.setPage(Integer.parseInt(page));
	}

	public ArrayList getDemands() {
		return demands;
	}

	public IResultRecord getSelectedDemand() {
		return selectedDemand;
	}

	public void setDemands(ArrayList list) {
		demands = list;
	}

	public void setSelectedDemand(IResultRecord record) {
		selectedDemand = record;
	}

	/* (non-Javadoc)
	 * @see fr.cg95.cvq.bo.record.IPaperHolder#getValidPapers()
	 */
	public ArrayList getValidPapers() {
		return getPapers();
	}

	public AdultRecord getResponsible() {
		return responsible;
	}

	public void setResponsible(AdultRecord record) {
		responsible = record;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return null;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFamilyQuotient() {
        return familyQuotient;
    }

    public void setFamilyQuotient(String familyQuotient) {
        this.familyQuotient = familyQuotient;
    }
    
    public ArrayList getAccounts() {
        return BusinessManager.getExternalAccounts(id);
    }

}
