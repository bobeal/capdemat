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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.ImageHandler;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.business.users.DocumentBinary;
import fr.cg95.cvq.business.users.Individual;

/**
 * @author René le CLERCQ
 */
public class PaperRecord implements IResultRecord {

	private static final long serialVersionUID = -6862964115841583297L;
	
	private Long id;
	private String person;
	private Integer typeId;
	private String type;
	private String state;
	private String expirationDate;
	private String validationDate;
	private String submissionDate;

    private boolean certified = false;
    private byte[] certifiedData = null;
    
	private int page = 0;
	private int nbPages = 0;
	private ArrayList data = null;

	private DisplayColumn paperColumns[] =
		{
//			new DisplayColumn("type", "Nature du justificatif", "text", false, "paper", "validDocument"),
			new DisplayColumn("type", "Nature du justificatif", true, "paper"),
			new DisplayColumn("person", "Personne", false, null),
			new DisplayColumn("state", "Etat", false, null),
			new DisplayColumn("expirationDate", "Expire le", false, null),
			new DisplayColumn("validationDate", "Validation le", false, null),
			new DisplayColumn("submissionDate", "Date du dépot", false, null)};

	class DataAction {
		static final int DB = 0;
		static final int ADD = 1;
		static final int MODIFY = 2;

		int action;
		File file;

		DataAction(HttpSession session, int action, byte data[]) {
			this.action = action;

			try {
				this.file = StartupServlet.getTempContextFile(session, "paper");
	
				ImageHandler.createFileFromBytes(file, ImageHandler.JPG_FORMAT, data);
			} catch (IOException ioe) {
			}
		}
	}

	public PaperRecord() {
		super();
	}

	public PaperRecord(
		String type,
		String state,
		String expirationDate,
		String validationDate,
		String submissionDate) {
		super();
		this.type = type;
		this.state = state;
		this.expirationDate = expirationDate;
		this.validationDate = validationDate;
		this.submissionDate = submissionDate;

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

	public boolean isValid() {
		return (BusinessDictionary.getDocumentState(state) != null);
	}

	public String getValidDocument() {
		if (isValid())
			return "select";

		return "show";
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public String getState() {
        if (this.certified)
            return IBusinessConstants.STATE_CERTIFIED;
        
		return state;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public String getType() {
		return type;
	}

	public String getValidationDate() {
		return validationDate;
	}

	public void setExpirationDate(String string) {
		expirationDate = string;
	}

	public void setState(String string) {
		state = string;
	}

	public void setSubmissionDate(String string) {
		submissionDate = string;
	}

	public void setType(String string) {
		type = string;
	}

	public void setValidationDate(String string) {
		validationDate = string;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		id = long1;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(Individual person) {
		this.person = (person == null) ? "Compte" : person.getLastName() + " " + person.getFirstName();
	}

	public void setPerson(IndividualRecord person) {
		this.person = (person == null) ? "Compte" : person.getLastName() + " " + person.getFirstName();
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer integer) {
		typeId = integer;
	}

	public File getDataFile() {
		return getDataFile(page);
	}

	public File getDataFile(int page) {
		if ((this.data != null) && (page >= 0) && (page < nbPages)) {
			this.page = page;
			return ((DataAction) data.get(page)).file;
		}
		return null;
	}

	public File getNewDocumentFile(int page) {
		if ((this.data != null) && (page >= 0) && (page < nbPages)) {
			DataAction dataAction = (DataAction) data.get(page); 
			if (dataAction.action == DataAction.ADD)
				return dataAction.file;
		}
		return null;
	}

	public void updateDataAction(int page) {
		if ((this.data != null) && (page >= 0) && (page < nbPages)) {
			DataAction dataAction = (DataAction) data.get(page); 
			dataAction.action = DataAction.DB;
		}
	}

	public void setData(HttpSession session, Set data) {
		if (data != null) {
			this.data = new ArrayList();
            
            Iterator iter = data.iterator();
			while (iter.hasNext()) {
				DocumentBinary binary = (DocumentBinary) iter.next();
                if (binary.getPageNumber().intValue() == 0)
                    this.certifiedData = binary.getData(); 
                else
                    this.data.add(new DataAction(session, DataAction.DB, binary.getData()));
			}
		}
	}

	public int addPage(HttpSession session, byte[] data) throws java.io.IOException {
	    int pageNumber = nbPages;
        
        if (!this.certified) {
    		nbPages++;
    
    		if (this.data == null) {
    			// First page for this document set the state to pending
    			this.data = new ArrayList();
    			this.state = IBusinessConstants.STATE_PENDING;
    		}
    		this.data.add(new DataAction(session, DataAction.ADD, data));
        }		
		return pageNumber;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer i) {
		if (i != null)
			nbPages = i.intValue();
        
        if (this.certified)
            nbPages--;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int i) {
		if (i < 0)
			page = nbPages - 1;

		else if (i >= nbPages)
			page = 0;

		else
			page = i;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return paperColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public byte[] getCertifiedData() {
        return certifiedData;
    }

    public void setCertifiedData(byte[] certifiedData) {
        this.certifiedData = certifiedData;
    }

}
