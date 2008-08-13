/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.fo.common.form;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.fo.dispatcher.StartupServlet;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.fo.util.ImageHandler;
import fr.cg95.cvq.fo.util.ImageManager;
import fr.cg95.cvq.fo.util.TimeHandler;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class DocumentForm extends ValidatorForm {

	private String id;

	private String type;

	private Integer typeId;
    
    private Individual person;
    private String state;
    private Date expirationDate;
    private String validationDate;
    private String submissionDate;


	private FormFile uploadedFile;

	/** the current page number being created */
	private int pageNumber = 1;

	private int displayedPageNumber = 1;

	private String fileFormat;

	private boolean certified = false;
    private File certifiedFile = null;
    
    private ArrayList<DocumentForm> documents = null;
    
    /**
	 * a map containing all the paths to the temporary image files. the data's
	 * page number is the key
	 */
	private ArrayList serverFileMap = new ArrayList();

	private boolean supplied = false;
    private boolean selected = false;
    private boolean available = false;

	private String method = Constants.ADD;

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param pType
	 *            The type to set.
	 */
	public void setType(String pType) {
		type = pType;
	}

	/**
	 * @return Returns the supplied.
	 */
	public boolean isSupplied() {
		return supplied;
	}

	/**
	 * @param pSupplied
	 *            The supplied to set.
	 */
	public void setSupplied(boolean pSupplied) {
		supplied = pSupplied;
	}

	/**
	 * @return Returns the uploaded file.
	 */
	public FormFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param pUploadedFile
	 *            The uploaded file to set.
	 */
	public void setUploadedFile(FormFile pUploadedFile) {
		uploadedFile = pUploadedFile;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pPageNumber) {
		pageNumber = pPageNumber;
	}

	/**
	 * Increment the current page number
	 */
	public void incPageNumber() {
		pageNumber++;
	}

	/**
	 * @return Returns the serverFilePathMap.
	 */
	public Collection getServerFileMap() {
		return serverFileMap;
	}

	public File getServerFile(int pPageNumber) throws Exception {

		return (File) serverFileMap.get(pPageNumber - 1);

	}

	public void addServerFile(int pPageNumber, File file) {

		serverFileMap.add(pPageNumber - 1, file);
	}

	public void removeServerFile(int pPageNumber) {
		serverFileMap.remove(pPageNumber - 1);
	}

	/**
	 * @return Returns the typeId.
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param pTypeId
	 *            The typeId to set.
	 */
	public void setTypeId(Integer pTypeId) {
		typeId = pTypeId;
	}

	/**
	 * @return Returns the fileFormat.
	 */
	public String getFileFormat() {
		return fileFormat;
	}

	/**
	 * @param pFileFormat
	 *            The fileFormat to set.
	 */
	public void setFileFormat(String pFileFormat) {
		fileFormat = pFileFormat;
	}

	/**
	 * @return Returns the displayedPageNumber.
	 */
	public int getDisplayedPageNumber() {
		return displayedPageNumber;
	}

	/**
	 * @param pDisplayedPageNumber
	 *            The displayedPageNumber to set.
	 */
	public void setDisplayedPageNumber(int pDisplayedPageNumber) {
		displayedPageNumber = pDisplayedPageNumber;
	}

	/**
	 * Increment the displayed page number
	 */
	public void incDisplayedPageNumber() {
		displayedPageNumber++;
		if (displayedPageNumber > pageNumber) {
			displayedPageNumber = pageNumber;
		}

	}

	/**
	 * Decrement the displayed page number
	 */
	public void decDisplayedPageNumber() {
		displayedPageNumber--;
		if (displayedPageNumber < 1) {
			displayedPageNumber = 1;
		}
	}

	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param pMethod
	 *            The method to set.
	 */
	public void setMethod(String pMethod) {
		method = pMethod;
	}

	public void removeAll() {
		serverFileMap.clear();
		pageNumber = 1;
		displayedPageNumber = 1;
		method = Constants.ADD;
        setSupplied(false);
	}

	public int getNumberOfPages() {
		return serverFileMap.size();
	}

	/**
	 * Decrement the page number
	 */
	public void decPageNumber() {
		pageNumber--;
		if (pageNumber < 1) {
			pageNumber = 1;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		id = string;
	}

	public void uploadDocument(HttpServletRequest request, FormFile uploadedFile) throws Exception {
		String fileFormat = ImageManager.getInstance().findFileFormat(uploadedFile);

		File file = StartupServlet.getTempContextFile(request.getSession(), "paper");

		ImageHandler.createFileFromBytes(file, fileFormat, uploadedFile.getFileData());

		if (getMethod().equals(Constants.MODIFY)) {
			removeServerFile(getDisplayedPageNumber());
			addServerFile(getDisplayedPageNumber(), file);

		} else { // add
            setPageNumber(getNumberOfPages()+1);
			addServerFile(getPageNumber(), file);
			setDisplayedPageNumber(getPageNumber());

			incPageNumber();
		}

		// mark the document as supplied
		setSupplied(true);
	}

    public String getExpirationDate() {
        return TimeHandler.parseDate(expirationDate, Constants.SHORT_DATE_FORMAT);
    }

    public Calendar getExpirationCalendar() {
        if (expirationDate == null) 
            return null;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        return calendar;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Individual getPerson() {
        return person;
    }

    public String getPersonName() {
        return (person == null) ? "Compte" : person.getLastName() + " " + person.getFirstName();
    }

    public void setPerson(Individual person) {
        this.person = person; 
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = TimeHandler.parseDate(submissionDate, Constants.SHORT_DATE_FORMAT);
    }

    public String getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = TimeHandler.parseDate(validationDate, Constants.SHORT_DATE_FORMAT);;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public File getCertifiedFile() {
        return certifiedFile;
    }

    public void setCertifiedFile(File certifiedFile) {
        this.certifiedFile = certifiedFile;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<DocumentForm> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<DocumentForm> documents) {
        this.documents = documents;
    }

}