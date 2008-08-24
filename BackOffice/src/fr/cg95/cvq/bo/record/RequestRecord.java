/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Gï¿œnï¿œral du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and Renï¿œ le Clercq 
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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.Localization;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.manager.TaskManager;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.PlaceReservationType.TicketSelection;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.users.PlaceReservationData;
import fr.cg95.cvq.business.users.TicketTypeSelection;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.ReservationNode;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author Renï¿œ le CLERCQ
 */
public class RequestRecord extends BaseRecord implements IPaperHolder, IImportExportRequest {
	
	private static final long serialVersionUID = -1788715425700500925L;
	
	private Long id;
	private Date date;
    private String requestType;
    private String shortLabel;
	private String typeLabel;
	private String demanderName;
    private AdultRecord demander;
    private String meansOfContact;
	private Long familyId;
	private String step;
	private String state;
	private String currentTask;
	private Date modificationDate;
	private String lastAgent;
	private String eMail;
    private String mobilePhone;
    private boolean temporary;
    private Boolean orangeAlert;
    private Boolean redAlert;

	private Long dataId;
	private String dataState;
	private String instructionInternal = "";
	private String instructionExternal = "";
	private String deliveryInternal = "";
	private String deliveryExternal = "";
	private String notify;
		
	private IndividualRecord subject;
    private String subjectName;
    
	private CategoryRecord category;
	
	private ArrayList<PaperRecord> papers = new ArrayList<PaperRecord>();
	private PaperRecord selectedPaper = null;
	
	private TaskManager tasks = null;

    private HashMap<String, List> list = new HashMap<String, List>();

	private ArrayList certificats = null;
		
	private ArrayList history = null;

	private boolean selected = false;
	private String message = null;
    
    private RequestManager requestManager = null;
	
    private DisplayColumn requestColumns[] =
        {
            new DisplayColumn("id", "N° de la demande", true, "request"),
            new DisplayColumn("date", "Date de la demande", true, null),
            new DisplayColumn("typeLabel", "Type de la demande", true, null),
            new DisplayColumn("demanderName", "Nom du demandeur", true, null, 18),
            new DisplayColumn("subjectName", "Personne concernée", true, null, 18),
            new DisplayColumn("familyId", "N° du compte", true, "family"),
            new DisplayColumn("state", "Etat de la demande", true, null),
            new DisplayColumn("modificationDate", "Dernière modification", true, null),
            new DisplayColumn("lastAgent", "Dernier intervenant", true, null, 14),
            new DisplayColumn("temporaryIndicator", "CP", "indicator", null),
            new DisplayColumn("quality", "QS", "indicator", null)};

    private DisplayColumn reportColumns[] =
        {
            new DisplayColumn("id", "Référence", false, null),
            new DisplayColumn("date", "Date", false, null),
            new DisplayColumn("typeLabel", "Type ", false, null),
            new DisplayColumn("demanderName", "Nom du demandeur", false, null),
            new DisplayColumn("state", "Etat", false, null),
            new DisplayColumn("modificationDate", "Dernière modification", false, null)};

	private DisplayColumn exportColumns[] =
		{
			new DisplayColumn("selected", "", "check", "currentSearch.wholeResultsList"),
			new DisplayColumn("id", "N° de la demande", true, null),
			new DisplayColumn("date", "Date de la demande", true, null),
			new DisplayColumn("typeLabel", "Type de la demande", true, null),
			new DisplayColumn("demanderName", "Nom du demandeur", true, null, 18),
			new DisplayColumn("familyId", "N° du compte", true, null),
			new DisplayColumn("state", "Etat de la demande", true, null),
			new DisplayColumn("modificationDate", "Date de la dernière modification", true, null),
			new DisplayColumn("message", "Etat de l'export", true, null)};

    private static final byte NOT_LOADED = 0;
    private static final byte LOADED = 1;
    private static final byte FULLY_LOADED = 2;
    
    private byte loaded = NOT_LOADED;
	
    public RequestRecord() {
        super();
    }

    public RequestRecord(RequestManager requestManager, Long id) {
        super();
        this.id = id;
        this.requestManager = requestManager;
    }

	public BaseRecord getDataRecord(Long id) {
		return null;
	}
	 
	public void load() {
		if (loaded == NOT_LOADED) {
			BusinessManager.getRequestRecord(requestManager, this);
			loaded = LOADED;
		}
	}
	
	public void loadPage(HashMap<Long,IResultRecord> results) {
	    BusinessManager.getRequestRecords(requestManager, results);
	}
	
    public Long getResultId() {
        return id;
    }
    
    public boolean isLoaded() {
        return loaded > 0;
    }

    public void load(Object xmlRequest) {
    }
    
	public void saveRequest() throws Exception {
	}
	
    public void saveRequest(Object xmlRequest) {
    }
    
	public void saveData() throws Exception {
		reset();
	}
	
    public void saveData(Object xmlRequest) {
    }
    
    protected String getEnumElementTranslation(String className, String elementName, String value) {
        return BusinessDictionary.getEnumElementTranslation(className, elementName, value);
    }
    
    protected String getEnumKeyTranslation(String className, String elementName, String value) {
        return BusinessDictionary.getEnumKeyTranslation(className, elementName, value);
    }
    
    protected ReservationNode getReservations(List referentialData, Set reservationData) {
        ReservationNode reservations = new ReservationNode();
        Iterator iter = reservationData.iterator();
        while (iter.hasNext()) {
           PlaceReservationData data = (PlaceReservationData)iter.next();
           PlaceReservationType spectacle = findSpectacle(referentialData, data.getName());
           ReservationNode reservation = null;
           if (spectacle != null)
               reservation = reservations.addDetail(spectacle.getKey(),
                                                    spectacle.getLabelsMap().get("fr").toString(),
                                                    spectacle.getMessage(),
                                                    spectacle.getEventDate(),
                                                    spectacle.getRemainingPlaces());
           else 
               reservation = reservations.addDetail(data.getName(),
                                                    data.getName(),
                                                    "",
                                                    new Date(),
                                                    new Integer(0));
           
           Iterator tickets = data.getTickets().iterator();
           while (tickets.hasNext()) {
               TicketTypeSelection ticket = (TicketTypeSelection)tickets.next();
    
               if (spectacle != null) {
                   TicketSelection ticketDetail = spectacle.getTicketSelection(ticket.getName());
                   
                   reservation.addDetail(  ticketDetail.getName(), 
                                           ticketDetail.getLabelsMap().get("fr").toString(),
                                           ticketDetail.getPrice(),
                                           ticket.getNumber().intValue());
               } else {
                   reservation.addDetail(  ticket.getName(), 
                                           ticket.getName(),
                                           new Float(0.0),
                                           ticket.getNumber().intValue());
               }
           }
        }
        return reservations;
    }
    
    private PlaceReservationType findSpectacle(List reservationTypes, String key) {
        Iterator iter = reservationTypes.iterator();
        while (iter.hasNext()) {
           PlaceReservationType place = (PlaceReservationType)iter.next();
           if (place.getKey().equals(key))
               return place;
        }
        
        return null;
    }

    protected ReferentialData getReferentialData(List referentialEntries, Set requestData) {
        return getReferentialData(referentialEntries, new ReferentialData(), requestData);
    }
        
    private ReferentialData getReferentialData(Collection referentialEntries, ReferentialData referential, Set requestData) {
        Iterator iter = requestData.iterator();
        while (iter.hasNext()) {
           LocalReferentialData data = (LocalReferentialData)iter.next();
           
           LocalReferentialEntry entry = findEntry(referentialEntries, data.getName());

           ReferentialData referentialData  = null;
           if (entry != null) {
               referentialData  = referential.addDetail(entry.getKey(), entry.getLabelsMap().get("fr").toString());
               if (entry.getEntriesSupportPrecision())
                   referentialData.setPrecisionLabel("Niveau");
               if (entry.getEntriesSupportPriority())
                   referentialData.setPriorityLabel("Priorité");
           
               getReferentialData(entry.getEntries(), referentialData, data.getChildren());

           } else {
               referentialData  = referential.addDetail(data.getName(), data.getName());
           }
           referentialData.setSelected(true);
           referentialData.setPrecision(data.getAdditionalInformationValue());
           if (data.getPriority() != null)
               referentialData.setPriority(data.getPriority().toString());
        }
        return referential;
    }
    
    private LocalReferentialEntry findEntry(Collection referentialData, String key) {
        Iterator iter = referentialData.iterator();
        while (iter.hasNext()) {
           LocalReferentialEntry entry = (LocalReferentialEntry)iter.next();
           if (entry.getKey().equals(key))
               return entry;
        }
        return null;
    }
    
    protected boolean containsRefData(Set values, String name) {
        Iterator iter = values.iterator();
        while (iter.hasNext()) {
            LocalReferentialData refData = (LocalReferentialData)iter.next();
            while (refData.getChildren().size() > 0)
                refData = (LocalReferentialData)refData.getChildren().iterator().next();

            if ((refData.getName() != null) && refData.getName().equals(name))
                return true;
        }
        return false;
    }
    
    protected Set getRefDataSet(boolean[] values, List list) {
        Set refDataSet = new HashSet();
        
        for (int i = 0; i < values.length; i++) {
            if (values[i]) {
                LocalReferentialData lrd = new LocalReferentialData();
                lrd.setName(((ReferentialData)list.get(i)).getKey());
                refDataSet.add(lrd);
            }
        }
        return refDataSet;
        
    }
    
    public List getList(String key) {
        return list.get(key);
    }

    public void setList(String key, List list) {
        this.list.put(key, list);
    }

	public String getCurrentTask() {
		return currentTask;
	}

	public Date getDate() {
		return date;
	}

	public String getLongDate() {
		return Localization.getLongDateFormatter().format(date);
	}

	public Long getFamilyId() {
		return familyId;
	}

	public Long getId() {
		return id;
	}

	public String getLastAgent() {
		return lastAgent;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public String getDemanderName() {
		return demanderName;
	}

	public String getMeansOfContact() {
        return meansOfContact;
    }

    public void setMeansOfContact(String meansOfContact) {
        this.meansOfContact = meansOfContact;
    }

    public String getState() {
		return state;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setCurrentTask(String string) {
		currentTask = string;
	}

	public void setDate(Date d) {
		date = d;
	}

	public void setFamilyId(Long l) {
		familyId = l;
	}

	public void setId(Long l) {
		id = l;
	}

	public void setLastAgent(String string) {
		lastAgent = string;
	}

	public void setModificationDate(Date d) {
		modificationDate = d;
	}

	public void setDemanderName(String string) {
		demanderName = string;
	}

	public void setState(String string) {
		state = string;
	}

	public void setTypeLabel(String string) {
		typeLabel = string;
	}

	public ArrayList<PaperRecord> getPapers() {
		return papers;
	}

	public ArrayList<PaperRecord> getValidPapers() {
	    ArrayList<PaperRecord> validPapers = new ArrayList<PaperRecord>();
			
		for (int i = 0; i < papers.size(); i++) {
			if (((PaperRecord)papers.get(i)).isValid())
				validPapers.add(papers.get(i));
		}
		return validPapers;
	}

	public void addPaper(PaperRecord paper) {
		if (papers == null)
			papers = new ArrayList<PaperRecord>();
			
		papers.add(paper);
	}

	public IResultRecord getSelectedPaper() {
		return selectedPaper;
	}

	public void setSelectedPaper(IResultRecord record, String page) {
		selectedPaper = (PaperRecord)record;
		if (page != null)
			selectedPaper.setPage(Integer.parseInt(page));
	}

	public TaskManager getTasks() {
		return tasks;
	}

	public void setTasks(TaskManager list) {
		tasks = list;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String string) {
		dataState = string;
	}

	public ArrayList getCertificats() {
		return certificats;
	}

    /**
     * 
     * @deprecated Use letter definitions in process definition files (citizen.xml, children.xml, etc.)
     */
	public void setCertificats(ArrayList list) {
		certificats = list;
	}

	public IndividualRecord getSubject() {
		return subject;
	}

	public void setSubject(IndividualRecord record) {
		subject = record;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String string) {
		notify = string;
	}

	public void updateHistory() {
		if (history == null)
			history = new ArrayList();
		else
			history.clear();
			
		BusinessManager.updateHistory(history,this);
    }		
    
    public ArrayList getHistory() {
		return history;
	}

	public void setHistory(ArrayList list) {
		history = list;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long long1) {
		dataId = long1;
	}

	public String getStep() {
		return step;
	}
	
	public void setStep(String string) {
		step = string;
	}

	public String getDeliveryExternal() {
		return deliveryExternal;
	}

	public String getDeliveryInternal() {
		return deliveryInternal;
	}

	public String getInstructionExternal() {
		return instructionExternal;
	}

	public String getInstructionInternal() {
		return instructionInternal;
	}

	public void setDeliveryExternal(String string) {
		deliveryExternal = string;
	}

	public void setDeliveryInternal(String string) {
		deliveryInternal = string;
	}

	public void setInstructionExternal(String string) {
		instructionExternal = string;
	}

	public void setInstructionInternal(String string) {
		instructionInternal = string;
	}

	public CategoryRecord getCategory() {
		return category;
	}

	public void setCategory(CategoryRecord categoryRecord) {
		category = categoryRecord;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String string) {
		eMail = string;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean b) {
		selected = b;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
				
		if (wizardState.getTabId() == null)
			return requestColumns;

        else if (wizardState.getTabId().equals("report"))
            return reportColumns;
            
        else if (wizardState.getTabId().equals("export"))
            return exportColumns;
            
		return null;
	}

	public String getNavigateAction(PageContext pageContext) {
        ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
				
		if (wizardState.getTabId() == null)
			return "searchAction";

        else if (wizardState.getTabId().equals("report"))
            return "reportAction";

        else if (wizardState.getTabId().equals("export"))
			return "exportAction";
			
		return null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String string) {
		message = string;
	}

	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String typeId) {
		this.shortLabel = typeId;
	}

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public AdultRecord getDemander() {
        return demander;
    }

    public void setDemander(AdultRecord demander) {
        this.demander = demander;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public String getTemporaryIndicator() {
        if (temporary)
            return "/BackOffice/images/error.png";

        return null;
    }
    
    public RequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public String getQuality() {
        if (orangeAlert.booleanValue())
            return "/BackOffice/images/bullet_orange.png";

        else if (redAlert.booleanValue())
            return "/BackOffice/images/no.png";
        
        return null;
    }
    
	public Boolean getOrangeAlert() {
		return orangeAlert;
	}

	public void setOrangeAlert(Boolean orangeAlert) {
		this.orangeAlert = orangeAlert;
	}

	public Boolean getRedAlert() {
		return redAlert;
	}

	public void setRedAlert(Boolean redAlert) {
		this.redAlert = redAlert;
	}

    public void unLoad() {
        this.loaded = NOT_LOADED;
    }
    
    public void setLoaded() {
        this.loaded = LOADED;
    }
    
    public void setFullyLoaded() {
        this.loaded = FULLY_LOADED;
    }
    
    public boolean isFullyLoaded() {
        return (this.loaded == FULLY_LOADED);
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
