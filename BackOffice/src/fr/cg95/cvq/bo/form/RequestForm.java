package fr.cg95.cvq.bo.form;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.DocumentTypeRecord;
import fr.cg95.cvq.bo.record.MeansOfContactRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.bo.record.SeasonRecord;
import fr.cg95.cvq.business.authority.Requirement;
import fr.cg95.cvq.wizard.manager.ManagerProcessGroup;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class RequestForm extends ActionForm {

	private static final long serialVersionUID = 6206073459733053645L;
	
    private String add;
    private String modify;
    private String delete;
    
    private List<RequestTypeRecord> allrtypes;
    private List<RequestTypeRecord> seasonrtypes;
    private List<DocumentTypeRecord> documents;
    private List<MeansOfContactRecord> meansOfContact;
    private List<SeasonRecord> seasons;

    private List<ManagerProcessGroup> groups;
    private List<RequestTypeRecord> grouprtypes;
    private String groupName = "";

    private boolean scanDocumentData;

    private int line;
    private String label;
    private String startDate;
    private String endDate;
    private String startInscription;
    private String endInscription;
    private String validationDate;
    
    private boolean alertsEnabled = false;
    private Integer maxDelay;
    private Integer alertDelay;
    
    private ArrayList<LetterTypeRecord> letterTypes = null;
    private FormFile file;
    private String letterShortLabel;
    private String letterLabel;

    private RequestTypeRecord requestType = null;

    private String selectedTab = "";
    
    public RequestForm() {
        super();
        documents = BusinessManager.getDocumentTypes();
        meansOfContact = BusinessManager.getMeansOfContact();
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        if (allrtypes != null)
            for (RequestTypeRecord record : allrtypes)
                record.reset();
            
        scanDocumentData = false;
        add = null;
        delete = null;
        modify = null;

        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        
        selectedTab = wizardState.getTabId(request);
        if (selectedTab == null) {
            selectedTab = "";
            requestType = null;
            label = null;
            startDate = null;
            endDate = null;
            startInscription = null;
            endInscription = null;
            validationDate = null;
            letterShortLabel = null;
            letterLabel = null;
            file = null;

        } else if (selectedTab.equals("documents")) {
            if ((documents != null) && (request.getParameter("save") != null))
                for (DocumentTypeRecord record : documents)
                    record.reset();
                
        } else if (selectedTab.equals("globals")) {
            if ((meansOfContact != null) && (request.getParameter("save") != null))
                for (MeansOfContactRecord record : meansOfContact)
                    record.reset();
        }
        
        super.reset(mapping, request);
    }

    public List getAllrtypes() {
        return allrtypes;
    }

    public void initAllrtypes(RequestManager requestManager, boolean force) {
        if (force || (allrtypes == null))
            allrtypes = BusinessDictionary.getRequestTypeRecords(requestManager, false);
    }

    public List<RequestTypeRecord> getSeasonrtypes() {
        return seasonrtypes;
    }

    public void initSeasonrtypes(RequestManager requestManager, boolean force) {
        if (force || (seasonrtypes == null))
            seasonrtypes = BusinessDictionary.getSeasonableRequestTypeRecords(requestManager);
    }

    public void initGrouprtypes(RequestManager requestManager) {
        groups = requestManager.getGroups();
    }
    
    public RequestTypeRecord getRequestType() {
        return requestType;
    }
    
    private void setRequestType(int index) {
        setRequestTypeRecord(null, index,"");
    }
    
    public void setRequestTypeRecord(StateManager stateManager, int index, String state) {
        if ((state != null) && state.equals("seasons"))
            setRequestTypeRecord(stateManager, seasonrtypes.get(index));
        else
            setRequestTypeRecord(stateManager, allrtypes.get(index));
    }
     
    public void setRequestTypeRecord(StateManager stateManager, RequestTypeRecord rtype) {
        requestType = rtype;
        
        if (requestType != null) {
            for (DocumentTypeRecord record : documents)
                record.reset();
                
            Iterator iter = BusinessManager.getRequirements(requestType.getId()).iterator();
            while (iter.hasNext()) {
                Requirement requirement = (Requirement)iter.next();
                Long docId = requirement.getDocumentType().getId();
                int i = 0;
                while ((i < documents.size()) && !documents.get(i).getId().equals(docId)) i++; 
                if (i < documents.size()) 
                    documents.get(i).setUsed(true);
            }
            resetSeasons();
            maxDelay = requestType.getMaxDelay();
            alertDelay = requestType.getAlertDelay();
            
            resetLetterTypes(stateManager);
        }
    }

    public List getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<DocumentTypeRecord> documents) {
        this.documents = documents;
    }

    public boolean isScanDocumentData() {
        return scanDocumentData;
    }

    public void setScanDocumentData(boolean scanDocumentData) {
        this.scanDocumentData = scanDocumentData;
    }

    public boolean isAlertsEnabled() {
        return alertsEnabled;
    }

    public void setAlertsEnabled(boolean alertsEnabled) {
        this.alertsEnabled = alertsEnabled;
    }
    
    public List<SeasonRecord> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonRecord> seasons) {
        this.seasons = seasons;
    }

    public void resetSeasons() {
        seasons = BusinessManager.getSeasons(requestType.getId());
        if (seasons == null)
            seasons = new ArrayList<SeasonRecord>();
        
        if (seasons.isEmpty())
            seasons.add(new SeasonRecord());
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int index) {
        this.line = index;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String save) {
        this.add = save;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndInscription() {
        return endInscription;
    }

    public void setEndInscription(String endInscription) {
        this.endInscription = endInscription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartInscription() {
        return startInscription;
    }

    public void setStartInscription(String startInscription) {
        this.startInscription = startInscription;
    }

    public String getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(String validationDate) {
        this.validationDate = validationDate;
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

    public int getRequestTypeParameterState() {
        if (requestType != null)
            return requestType.getParameterState();
        
        return 0;
    }

    public List<ManagerProcessGroup> getGroups() {
        return groups;
    }

    public void selectGroup(RequestManager requestManager, int groupId) {
        groupName = getGroup(groupId).getCaption();
        
        if (grouprtypes == null)
            grouprtypes = new ArrayList<RequestTypeRecord>();
        else
            grouprtypes.clear();
        
        for (RequestTypeRecord rtype : allrtypes) {
            if (rtype.getGroupId() == groupId) {
                grouprtypes.add(rtype);
            }
        }
    }
    
    private ManagerProcessGroup getGroup(int order) {
        for (ManagerProcessGroup group : groups) {
            if (group.getOrder() == order)
                return group;
        }
        return null;
    }
    
    public List<RequestTypeRecord> getGrouprtypes() {
        return grouprtypes;
    }
    
    public RequestTypeRecord getGroupRequestTypeRecord(int index) {
        return grouprtypes.get(index);
    }
    
    public boolean getDisplay(String tab) {
        if (requestType == null) {
            if (selectedTab.equals("globals") && tab.equals("globals")) {
                return true;
            }
        } else {
            if (tab.equals("documents")) {
                if (isScanDocumentData() && requestType.getParameterState() >= RequestTypeRecord.DOCUMENTS)
                    return true;
                
            } else if (tab.equals("seasons")) {
                if (requestType.isSeasonable() && requestType.getParameterState() >= RequestTypeRecord.SEASONS)
                    return true;
                
            } else if (isAlertsEnabled() && tab.equals("alerts")) {
                if (requestType.getParameterState() >= RequestTypeRecord.ALERTS)
                    return true;
                
            } else if (tab.equals("parameters")) {
                if (requestType.isConfigurable() && requestType.getParameterState() >= RequestTypeRecord.PARAMETERS)
                    return true;
                
            } else if (tab.equals("letters")) {
                if (requestType.getParameterState() >= RequestTypeRecord.FILES)
                    return true;
                
            } else if (tab.equals("information")) {
                if (requestType.hasInformation() && requestType.getParameterState() >= RequestTypeRecord.INFORMATION)
                    return true;
                
            } else if (tab.equals("activate")) {
                if (requestType.getParameterState() >= RequestTypeRecord.ACTIVATED)
                    return true;
            }
        }
        return false;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String getLetterShortLabel() {
        return letterShortLabel;
    }

    public void setLetterShortLabel(String letterType) {
        this.letterShortLabel = letterType;
    }

    public ArrayList<LetterTypeRecord> getLetterTypes() {
        return letterTypes;
    }
    
    public void resetLetterTypes(StateManager stateManager) {
        if (stateManager != null) {
            Collection<LetterTypeRecord> types = 
                stateManager.getRequestManager().getLetterTypes(requestType.getType());
            letterTypes = new ArrayList<LetterTypeRecord>(types);
            if (letterTypes.isEmpty())
                letterTypes.add(new LetterTypeRecord());
        }    
    }

    public String getInformationLabel() {
        if (requestType != null)
            return requestType.getInformationLabel();
        
        return null;
    }
    
    public String getInformation() {
        if (requestType != null) {
            try {
                File file = DispatchFilter.getAssetsBaseFile(requestType.getInformationFile());
                if (file.exists()) {
                    int size = new Long(file.length()).intValue();
                    char[] buf = new char[size];
                    FileReader reader = new FileReader(file);
                    reader.read(buf);
                    reader.close();
                    return new String(buf);
                }
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }
        return null;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<MeansOfContactRecord> getMeansOfContact() {
        return meansOfContact;
    }

    public void setMeansOfContact(List<MeansOfContactRecord> meansOfContact) {
        this.meansOfContact = meansOfContact;
    }

    public String getLetterLabel() {
        return letterLabel;
    }

    public void setLetterLabel(String letterLabel) {
        this.letterLabel = letterLabel;
    }
    
}
