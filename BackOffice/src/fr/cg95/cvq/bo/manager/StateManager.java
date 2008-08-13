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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.bo.LP7CertifyProperties;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.dispatcher.HttpSessionEventListener;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.record.CategoryRecord;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.wizard.IWizardSession;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * StateManager
 */
public class StateManager implements IWizardSession, Serializable {

	private static final long serialVersionUID = -6240101389494952604L;

	public final static String STATE_MANAGER = "stateManager";
	
	transient private HttpSession session = null;
	transient private int windowIndex = 0;
    private boolean navigate = true;
    
	private UserRecord currentUser = null;
	private SearchForm currentSearch = null;

    private ArrayList<IResultRecord> selectedRecords = new ArrayList<IResultRecord>();
    private ArrayList<IResultRecord> previousRecords = new ArrayList<IResultRecord>();
    
    private SearchForm accountSearch = null;
    private SearchForm reportSearch = null;
    private SearchForm reportFilter = null;
    private SearchForm paymentSearch = null;

	private Long nbOpen = null;
	private Long nbPending = null;
	private Long nbNotify = null;
	
	private ProfileManager profile = null;
    private RequestManager requestManager = null;

	private HashMap agents = null;
	
	public StateManager() {
		super();
		
		// Create the connection with the businesslayer of the system. 
		// We do this only once for each session.		
// 		new BusinessManager();
        profile = new ProfileManager(this);
        requestManager = new RequestManager();
	}
	
	public void init(HttpSession session, int wizard) {
		this.session = session;

        if (wizard == 0) {
            currentSearch = null;
            accountSearch = null;
            reportSearch = null;
            reportFilter = null;
            paymentSearch = null;
        }
        if (wizard < selectedRecords.size())
            selectedRecords.set(wizard, null);
        
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(session, wizard);
        if (wizardState != null)
            wizardState.setUser(getCurrentUser().getLogin());
	}

	public String getProcessName() {
        IResultRecord selectedRecord = getSelectedRecord();
        if (selectedRecord != null) {
			if (selectedRecord instanceof RequestRecord) {
				return ((RequestRecord)selectedRecord).getShortLabel();
			}
		}
		return null;
	}

	public SearchForm getCurrentSearch() {
		return currentSearch;
	}

	public void setCurrentSearch(SearchForm form) {
		currentSearch = form;
	}

	public IResultRecord getSelectedRecord() {
        if (windowIndex < selectedRecords.size())
            return selectedRecords.get(windowIndex);
            
        return null;
	}

	public void setSelectedRecord(IResultRecord record) {
	    if (windowIndex >= selectedRecords.size()) {
            selectedRecords.ensureCapacity(windowIndex+1);
            previousRecords.ensureCapacity(windowIndex+1);
        }
        
        IResultRecord selectedRecord = getSelectedRecord();
        if (selectedRecord != null)
            HttpSessionEventListener.unRegisterRecord(session, selectedRecord);
        
        if (windowIndex < selectedRecords.size())
            selectedRecords.set(windowIndex, record);
        else
            selectedRecords.add(windowIndex, record);
        
        if (record != null) {
            HttpSessionEventListener.registerRecord(session, record);
        } else if (windowIndex < previousRecords.size()) {
            previousRecords.set(windowIndex, null);
        } else {
            previousRecords.add(windowIndex, null);
        }
	}

    public String inUseBy(IResultRecord record) {
        String activeUsers = "";
        HashMap<String, HttpSession> sessions = 
            HttpSessionEventListener.getRecordReqistration(session, record);
        if (sessions != null) {
            ArrayList<HttpSession> faultySessions = new ArrayList<HttpSession>();
            for (HttpSession userSession : sessions.values()) {
                try {
                    if (!userSession.getId().equals(session.getId())) {
                        StateManager stateManager = (StateManager)userSession.getAttribute(StateManager.STATE_MANAGER);
                        if ((stateManager != null) && (stateManager.getCurrentUser() != null)) {
                            activeUsers += "\n - " + stateManager.getCurrentUser().getLogin() + " (" + ")";
                        }
                    }
                } catch(Exception e) {
                    // Store sessions to be removed to avoid ConcurrentModificationException
                    faultySessions.add(userSession);
                }
            }
            // Remove the faulty session found
            for (HttpSession userSession : faultySessions) {
                HttpSessionEventListener.removeFaultySession(userSession);
            }
        }
        return activeUsers;
    }
    
	public Collection getRequestStates() {
		return BusinessDictionary.getRequestStates();
	}
	
	public Collection getFilteredRequestStates() {
        IResultRecord selectedRecord = getSelectedRecord();
		if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
			String state = ((RequestRecord)selectedRecord).getState();
			Collection requestStates = BusinessManager.getRequestStates(state);
			if (!requestStates.contains(state))
				requestStates.add(state);
			
			Collections.sort((List)requestStates);
            return requestStates;
		}
		return BusinessDictionary.getRequestStates();
	}
	
	public Collection getDocumentStates() {
		return BusinessDictionary.getDocumentStates();
	}
	
	public Collection getFilteredDocumentStates() {
        IResultRecord selectedRecord = getSelectedRecord();
		if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
			PaperRecord paper = (PaperRecord)((RequestRecord)selectedRecord).getSelectedPaper();
			String state = paper.getState();

            if (!getScanDocumentData() && state.equals(IBusinessConstants.STATE_ABSENT))
                state = IBusinessConstants.STATE_PENDING;
            
			Collection documentStates = BusinessManager.getDocumentStates(state);
			if (!documentStates.contains(state))
				documentStates.add(state);
			
            if (state.equals(IBusinessConstants.STATE_VALIDATED) && LP7CertifyProperties.isConfigured())
                documentStates.add(IBusinessConstants.STATE_CERTIFIED);

            Collections.sort((List)documentStates);
			return documentStates;
		}
		return BusinessDictionary.getDocumentStates();
	}
	
    public boolean getScanDocumentData() {
        return BusinessManager.scanDocumentData(SecurityContext.getCurrentSite().getName());
    }

    public boolean getAlertsEnabled() {
        LocalAuthorityConfigurationBean siteData = 
            BusinessManager.getCurrentSiteData(SecurityContext.getCurrentSite().getName());
        
        return siteData.getInstructionAlertsEnabled();
    }
    
    public boolean getCanAddPage() {
        IResultRecord selectedRecord = getSelectedRecord();
        if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
            PaperRecord paper = (PaperRecord)((RequestRecord)selectedRecord).getSelectedPaper();
            String state = paper.getState();

            return (!state.equals(IBusinessConstants.STATE_VALIDATED) && 
                    !state.equals(IBusinessConstants.STATE_CERTIFIED));
        }
        return true;
    }
    
    public boolean getViewCertified() {
        IResultRecord selectedRecord = getSelectedRecord();
        if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
            PaperRecord paper = (PaperRecord)((RequestRecord)selectedRecord).getSelectedPaper();
            String state = paper.getState();

            return state.equals(IBusinessConstants.STATE_CERTIFIED);
        }
        return false;
    }
    
	public Collection getDataStates() {
        IResultRecord selectedRecord = getSelectedRecord();
		if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {

			String dataState =((RequestRecord)selectedRecord).getDataState();
			if (!dataState.equals(IBusinessConstants.STATE_PENDING)) {
				ArrayList dataStates = new ArrayList();
				Iterator iter = BusinessDictionary.getDataStates().iterator();
				while (iter.hasNext())
					 	dataStates.add(iter.next());
				dataStates.remove(IBusinessConstants.STATE_PENDING);
				
                Collections.sort((List)dataStates);
				return dataStates;
			}
		}
		return BusinessDictionary.getDataStates(); 
	}
	
	public Collection getAgents() {
		agents =  BusinessManager.getAgents();
		return agents.keySet();
	}
	
	public Long getAgentId(String fullName) {
		if (fullName != null)
			return (Long)agents.get(fullName);
		
		return null;
	}
	
    public Collection getPaymentTypes() {
        return BusinessDictionary.getPaymentTypes();
    }
    
    public Collection getPaymentStates() {
        return BusinessDictionary.getPaymentStates();
    }

    public Collection getCardStates() {
        return BusinessDictionary.getCardStates();
    }
    
	public void refresh() {
        if (currentUser != null) {
    	    Map tasks = BusinessManager.getNbAgentsTasks(currentUser.getLogin());
            if (tasks != null) {
                nbOpen = (Long)tasks.get("cvq.tasks.opened");
                nbPending = (Long)tasks.get("cvq.tasks.pending");
                nbNotify = (Long)tasks.get("cvq.tasks.validated");
            }
        }
	}
	
	public String getNbopen() {
		if (nbOpen == null)
			refresh();
		return notNull(nbOpen, "0");
	}
	
	public String getNbpending() {
		if (nbPending == null)
			refresh();
		return notNull(nbPending, "0");
	}
	
	public String getNbnotify() {
		if (nbNotify == null)
			refresh();
		return notNull(nbNotify, "0");
	}
	
    private String notNull(Object obj, String value) {
        if (obj == null)
            return value;
        
        return obj.toString();
    }
    
    public ArrayList getReportRecords() {
        if (reportFilter != null)
            return reportFilter.getWholeResultsList();
        
        return null;
    }

    public SearchForm getReportSearch() {
        return reportSearch;
    }
    
	public void setReportSearch(SearchForm form) {
		reportSearch = form;
	}

    public Collection getTypes() {
        return requestManager.getRequestTypeLabels();
    }
     
    public Collection<String> getServices() {
        List<CategoryRecord> serviceRecordList = BusinessManager.getCategories(true);
        Collection<String> serviceLabelsList = new ArrayList<String>();
        for (int i=0; i < serviceRecordList.size(); i++) {
            serviceLabelsList.add(serviceRecordList.get(i).getName());
        }
        return serviceLabelsList;
    }
    
    public Collection getManagerTypes() {
        return requestManager.getManagedRequestTypeLabels();
    }
     
    public Collection<String> getManagerServices() {
        List<CategoryRecord> serviceRecordList = BusinessManager.getCategories(false);
        Collection<String> serviceLabelsList = new ArrayList<String>();
        for (int i=0; i < serviceRecordList.size(); i++) {
            serviceLabelsList.add(serviceRecordList.get(i).getName());
        }
        return serviceLabelsList;
    }
    
	public ProfileManager getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile.setProfile(profile);
	}

	public HttpSession getSession() {
		return session;
	}

	public String getVersion() {
		return session.getServletContext().getInitParameter("applicationVersion")
            + "-" + session.getServletContext().getInitParameter("applicationRevision");
	}

	public UserRecord getCurrentUser() {
	    if (currentUser == null) {
            currentUser = BusinessManager.getCurrentUser();
            setProfile(currentUser.getProfile());
        }
        return currentUser;
	}

	public void setCurrentUser(UserRecord record) {
		currentUser = record;
	}

	public String getFrontOfficeSite(String context) {
		String frontOffice = context.replaceFirst("Back","Front");

		return frontOffice;
	}
	
	public Collection getDeliveryCertificats() {
        IResultRecord selectedRecord = getSelectedRecord();
		if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
			RequestRecord requestRecord = (RequestRecord)selectedRecord;
            
            return requestManager.getLetterTypes(requestRecord.getRequestType());
		}
		return null;
	}
	
	public LetterTypeRecord getDeliveryCertificat(String type) {
        IResultRecord selectedRecord = getSelectedRecord();
		if ((selectedRecord != null) && (selectedRecord instanceof RequestRecord)) {
			RequestRecord requestRecord = (RequestRecord)selectedRecord;

            LetterTypeRecord certificat = requestManager.getLetterType(requestRecord.getRequestType(), type);
            
            if (certificat != null)
                return certificat;
            
            Iterator iter = requestRecord.getCertificats().iterator();
			while (iter.hasNext()) {
				certificat = (LetterTypeRecord)iter.next();
				
				if (certificat.getShortLabel().equals(type))
					return certificat;
			}
		}
		return null;
	}
	
    public Collection getMeansOfContact() {
        try {
            return BusinessManager.getEnabledMeansOfContact();
        } catch (CvqException e) {
        }
        return null;
    }

    public IResultRecord getPreviousRecord() {
        if (windowIndex < previousRecords.size())
            return previousRecords.get(windowIndex);

        return null;
    }

    public void setPreviousRecord(IResultRecord previousRecord) {
        if (windowIndex < selectedRecords.size()) {
            previousRecords.set(windowIndex, previousRecord);
        } else {
            previousRecords.ensureCapacity(windowIndex+1);
            previousRecords.add(windowIndex, previousRecord);
        }
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public int getWindowIndex() {
        return windowIndex;
    }

    public void setWindowIndex(int wizard) {
        this.windowIndex = wizard;
    }

    public boolean isNavigate() {
        return windowIndex == 0;
    }

    public void setNavigate(boolean navigate) {
        this.navigate = navigate;
    }

    public SearchForm getPaymentSearch() {
        return paymentSearch;
    }

    public void setPaymentSearch(SearchForm paymentSearch) {
        this.paymentSearch = paymentSearch;
    }

    public SearchForm getReportFilter() {
        return reportFilter;
    }

    public void setReportFilter(SearchForm reportFilter) {
        this.reportFilter = reportFilter;
    }

    public SearchForm getAccountSearch() {
        return accountSearch;
    }

    public void setAccountSearch(SearchForm accountSearch) {
        this.accountSearch = accountSearch;
    }

}
