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
package fr.cg95.cvq.fo.common;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.common.form.RulesForm;
import fr.cg95.cvq.fo.dispatcher.DispatchFilter;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.fo.util.TimeHandler;

/**
 */
public class Request implements Serializable {
    public static final String RETURN_URL_PARAMETER = "returnUrl";
    
    private boolean initialised = false;
    
    private String process;
    
    private Long id;

    private String type;

    private String state;

    private String creationDate;

    private Integer currentDocumentTypeId;

    private HashMap<Integer, DocumentForm> documents = new HashMap<Integer, DocumentForm>();

    private HashMap<String, Collection> list = new HashMap<String, Collection>();

    private boolean complete = false;

    private boolean alreadyExecuted = false;

    private RulesForm rules = new RulesForm();

    private fr.cg95.cvq.business.request.Request dbRequest;
    
    private boolean noRequester = false;
    
    private boolean scanDocuments = true;
    
    private String controlId = "";
    
    private String login = "";
    
    private Long requesterId = null;
    
    private Long subjectId = null;
    private String subjectName;
    
    private Long _familyHomeId = null;
    
    private Object data = null;
    
    private String returnUrl = "";
    
    private boolean publik = false;
    
    /**
     */
    public Long getId() {
        return id;
    }

    /**
     */
    public String getType() {
        return type;
    }

    /**
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     */
    public String getState() {
        return state;
    }

    /**
     */
    public void setId(Long pId) {
        id = pId;
    }

    /**
     */
    public void setType(String pType) {
        type = pType;
    }

    /**
     */
    public void setCreationDate(Date pCreationDate) {
			creationDate = TimeHandler.parseDate(pCreationDate, Constants.DATE_FORMAT);
    }

    /**
     */
    public void setState(String pState) {
        state = pState;
    }

    public void addDocument(DocumentForm pDocument) {
        this.documents.put(pDocument.getTypeId(), pDocument);
    }

    public void changeDocument(DocumentForm pDocument) {
        this.documents.put(pDocument.getTypeId(), pDocument);
    }

    public void removeDocument(DocumentForm pDocument) {
        this.documents.remove(pDocument.getTypeId());
    }

    public DocumentForm getDocument(Integer pTypeId) {
        return this.documents.get(pTypeId);
    }

    public DocumentForm getCurrentDocument() {
        if (currentDocumentTypeId != null)
            return this.documents.get(currentDocumentTypeId);
        
        return null;
    }
    
    public Collection getDocuments() {

        return this.documents.values();
    }

    public boolean getHasDocuments() {
        return (this.documents != null) && !this.documents.isEmpty();
    }
    
    public boolean getHasDocumentsToScan() {
        return scanDocuments && (this.documents != null) && !this.documents.isEmpty();
    }
    
    // Methods for 'old' interface, using only expected and supplied documents
    public Collection getExpectedDocument() {

        HashMap<Integer, DocumentForm> expectedDocument = new HashMap<Integer, DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (!(document.isSupplied() || document.isAvailable())) {
                expectedDocument.put(document.getTypeId(), document);
            }
        }
        setComplete(expectedDocument.isEmpty());
        return expectedDocument.values();
    }

    public Collection getSuppliedDocument() {

        HashMap<Integer, DocumentForm> suppliedDocument = new HashMap<Integer, DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (document.isSupplied() || document.isAvailable()) {
                suppliedDocument.put(document.getTypeId(), document);
            }
        }

        return suppliedDocument.values();
    }

    // Methods for 'new' interface using available, missing, selected and supplied documents
    public Collection getAvailableDocuments() {
        ArrayList<DocumentForm> availableDocuments = new ArrayList<DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (document.isAvailable()) {
                availableDocuments.add(document);
            }
        }

        return availableDocuments;
    }
    
    public Collection getMissingDocuments() {
        ArrayList<DocumentForm> missingDocuments = new ArrayList<DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (!document.isAvailable()) {
                missingDocuments.add(document);
            }
        }

        return missingDocuments;
    }
    
    public void resetSelectedDocuments() {
        for (DocumentForm document : this.documents.values()) {
            if (!document.isAvailable() && !document.isSupplied())
                document.setSelected(false);
        }
    }
    
    public Collection getSelectedDocuments() {
        ArrayList<DocumentForm> selectedDocuments = new ArrayList<DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (document.isSelected()) {
                selectedDocuments.add(document);
            }
        }

        return selectedDocuments;
    }
    
    public Collection getSuppliedDocuments() {
        ArrayList<DocumentForm> suppliedDocuments = new ArrayList<DocumentForm>();

        for (DocumentForm document : this.documents.values()) {
            if (document.isSupplied()) {
                suppliedDocuments.add(document);
            }
        }

        return suppliedDocuments;
    }
    
    /**
     * @return Returns the currentDocument type Id.
     */
    public Integer getCurrentDocumentTypeId() {
        return currentDocumentTypeId;
    }

    /**
     * @param pCurrentDocumentTypeId
     *            The currentDocument type Id to set.
     */
    public void setCurrentDocumentType(Integer pCurrentDocumentTypeId) {
        currentDocumentTypeId = pCurrentDocumentTypeId;
    }

    /**
     * @return Returns the complete.
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * @param pComplete
     *            The complete to set.
     */
    public void setComplete(boolean pComplete) {
        complete = pComplete;
    }

    /**
     * @return Returns the alreadyExecuted.
     */
    public boolean isAlreadyExecuted() {
        return alreadyExecuted;
    }

    /**
     * @param pAlreadyExecuted
     *            The alreadyExecuted to set.
     */
    public void setAlreadyExecuted(boolean pAlreadyExecuted) {
        alreadyExecuted = pAlreadyExecuted;
    }
    /**
     * @return Returns the rules.
     */
    public RulesForm getRules() {
        return rules;
    }
    /**
     * @param pRules The rules to set.
     */
    public void setRules(RulesForm pRules) {
        rules = pRules;
    }

	public Collection getList(String key) {
		return list.get(key);
	}

	public void setList(String key, Collection list) {
		this.list.put(key, list);
	}

	public fr.cg95.cvq.business.request.Request getDbRequest() {
		return dbRequest;
	}

	public void setDbRequest(fr.cg95.cvq.business.request.Request dbRequest) {
		this.dbRequest = dbRequest;
	}

    public boolean isNoRequester() {
        return noRequester;
    }

    public void setNoRequester(boolean noRequester) {
        this.noRequester = noRequester;
    }

    public boolean isScanDocuments() {
        return scanDocuments;
    }

    public void setScanDocuments(boolean scanDocuments) {
        this.scanDocuments = scanDocuments;
    }

    public String getControlId() {
        return this.controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public boolean isInitialised() {
        return initialised;
    }

    public void setInitialised(boolean initialised) {
        this.initialised = initialised;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getFamilyHomeId() {
        return _familyHomeId;
    }

    public void setFamilyHomeId(Long familyHomeId) {
        _familyHomeId = familyHomeId;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean isPublik() {
        return publik;
    }

    public void setPublik(boolean publik) {
        this.publik = publik;
    }
    
}

class CompareRequests implements Comparator {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Object pObject1, Object pObject2) {
        Request request1 = null;
        Request request2 = null;

        if (pObject1 instanceof Request)
            request1 = (Request) pObject1;

        if (pObject2 instanceof Request)
            request2 = (Request) pObject2;

        if ((request1 == null) || (request2 == null))
            throw new ClassCastException("Object is not a Request");

        int id1 = request1.getId().intValue();
        int id2 = request2.getId().intValue();

        if (id1 < id2)
            return -1;

        if (id1 == id2)
            return 0;

        return 1;
    }

}