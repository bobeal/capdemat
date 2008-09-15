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
package fr.cg95.cvq.bo.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.bo.TwoWayMap;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.CategoryRecord;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.wizard.manager.ManagerProcessGroup;
import fr.cg95.cvq.wizard.manager.ManagerWizardPlugin;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessType;

/**
 * @author René le CLERCQ
 */
public class RequestManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private class RequestDefinition implements Serializable {

		private static final long serialVersionUID = 1L;

        int groupId = -1;
		String record = null;
        String persistence = null;
        String name = null;
        String label = null;
        IPersistence persist = null;
        Map<String,LetterTypeRecord> letters = null;
        String informationLabel = null;
        String informationFile = null;
        
        RequestDefinition(int groupId, String record, String persistence, String name, String label) {
            this.groupId = groupId;
            this.record = record;
            this.persistence = persistence;
            this.name = name;
            this.label = label;
        }
    }

    private LocalAuthorityConfigurationBean siteData = null;
    
    private HashMap<String, RequestDefinition> demandTypes = null;

    private HashMap<String,Long> requestTypeIds = null;

    private TwoWayMap requestXTypes = null;
    
    private ArrayList<String> managedRequestTypes = null;

    private List<ManagerProcessGroup> groups = null;
    
    public RequestManager() {
        super();

        getSiteData();

        demandTypes = new HashMap<String, RequestDefinition>();

        groups = new ArrayList<ManagerProcessGroup>(ManagerWizardPlugin.plugin().getProcessGroups().values());
        Collections.sort(groups);
        
        for (ManagerProcessGroup group : groups) {
            for (ManagerProcessType process : group.getProcesses()) {
                
                RequestDefinition definition = new RequestDefinition( 
                    group.getOrder(), 
                    process.getRecord(), 
                    process.getPersistence(), 
                    process.getName(), 
                    process.getLabel());
                
//                definition.letters = addLetterTypes(group, process);
                if (process.isSetInformation()) {
                    definition.informationLabel = process.getInformation().getLabel();
                    definition.informationFile = process.getInformation().getStringValue();
                }
                
                addRequestDefinition(definition);
                
            }
        }
    }

    private void addRequestDefinition(RequestDefinition definition) {
        getPersistenceClass(definition);
        if (definition.persist != null)
            demandTypes.put(getRequestLabel(definition.persist.getServiceName(definition.name)), definition);
    }
    
    public RequestRecord getRequestRecord(Request demand, RequestRecord record) {

        RequestDefinition definition = demandTypes.get(demand.getRequestType().getLabel());
        if (definition != null) {
            try {
                if (record == null)
                    record = (RequestRecord) Class.forName(definition.record).newInstance();

                record.setRequestManager(this);
                record.setId(demand.getId());
                record.setRequestType(demand.getRequestType().getLabel());
                record.setShortLabel(definition.name);
                record.setTypeLabel(definition.label);

                return record;

            } catch (InstantiationException e) {
                e.getMessage();
            } catch (IllegalAccessException e) {
                e.getMessage();
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        }
        return null;
    }

    public Long getRequestTypeId(String type) {
        return (Long) requestTypeIds.get(type);
    }

    public String getRequestTypeLabel(String type) {
        initRequestTypes();
        String label = (String) requestXTypes.get(type);
        if (label == null)
            label = "Pas disponible";

        return label;
    }

    public Collection getRequestTypeLabels() {
        initRequestTypes();
        return requestXTypes.getOneWayValues();
    }

    public Collection getManagedRequestTypeLabels() {
        initRequestTypes();
        return managedRequestTypes;
    }

    public boolean loadRequest(Request request, RequestRecord record) {
        RequestDefinition definition = demandTypes.get(record.getRequestType());
        
        if ((definition != null) && (definition.persist != null)) {
            definition.persist.initRequest(record);
            record.load(request);
            definition.persist.loadRequest(request, record);
            
            record.setFullyLoaded();
            return true;
        }
        return false;
    }
    
    public boolean saveRequest(RequestRecord record) throws CvqException {
        RequestDefinition definition = demandTypes.get(record.getRequestType());
        
        if ((definition != null) && (definition.persist != null)) {
            saveRequest(definition.persist, definition.name, record);
            return true;
        }
        return false;
    }
    
    private void saveRequest(IPersistence persist, String name, RequestRecord record) throws CvqException{
        IRequestService service = (IRequestService)BusinessManager.getAc().getBean(persist.getServiceName(name));
        
        Request request = service.getById(record.getId());
        
        persist.saveRequest(request, record);
        record.saveRequest(request);

        service.modify(request);
    }
    
    public boolean saveRequestData(RequestRecord record) throws CvqException {
        if (record.isModified()) {
            RequestDefinition definition = demandTypes.get(record.getRequestType());
            
            if ((definition != null) && (definition.persist != null)) {
                saveRequestData(definition.persist, definition.name, record);
                record.reset();
                return true;
            }
        }
        return false;
    }
    
    private void saveRequestData(IPersistence persist, String name, RequestRecord record) throws CvqException{
        IRequestService service = (IRequestService)BusinessManager.getAc().getBean(persist.getServiceName(name));
        
        Request request = service.getById(record.getId());
        
        persist.saveRequestData(request, record);
        record.saveData(request);

        service.modify(request);
    }
    
    public Long importRequest(fr.cg95.cvq.xml.common.RequestType xmlRequest) throws CvqException {
        String name = xmlRequest.getDomNode().getNodeName();
        
        RequestDefinition definition = findDefinition(name);
        if ((definition != null) && (definition.persist != null))
            return definition.persist.importRequest(xmlRequest);
            
        return null;
    }
    
    private RequestDefinition findDefinition(String xsdName) {
        for (RequestDefinition definition : demandTypes.values()) {
            if (definition.record.indexOf(xsdName) != -1)
                return definition;
        }
        return null;
    }
    
    public Collection getReportFields(String requestType) {
        RequestDefinition definition = demandTypes.get(requestType);
        
        if ((definition != null) && (definition.persist != null)) {
            return definition.persist.getReportFields();
        }
        return null;
    }
    
    private String getRequestLabel(String service) {
        if (service != null) {
            IRequestService requestService = (IRequestService)BusinessManager.getAc().getBean(service);
            return requestService.getLabel();
        }
        return null;
    }
    
    private void getPersistenceClass(RequestDefinition definition) {
        if ((definition != null) && (definition.persistence != null))
            try {
                definition.persist = 
                    (IPersistence) Class.forName(definition.persistence).newInstance();
                
            } catch (InstantiationException e) {
                e.getMessage();
            } catch (IllegalAccessException e) {
                e.getMessage();
            } catch (ClassNotFoundException e) {
                e.getMessage();
            } catch (ClassCastException e) {
                e.getMessage();
            }
    }
    
    private void initRequestTypes() {
        if (requestXTypes == null) {
            requestTypeIds = new HashMap<String,Long>();
            requestXTypes = new TwoWayMap();
            managedRequestTypes = new ArrayList<String>();

            try {
                IRequestService requestService = BusinessManager.getDefaultRequestService();

                Iterator iter = requestService.getAllRequestTypes().iterator();

                while (iter.hasNext()) {
                    RequestType requestType = (RequestType) iter.next();
                    RequestDefinition definition = (RequestDefinition) demandTypes.get(requestType
                            .getLabel());
    
    //                  if ((definition != null) && requestType.getActive().booleanValue()) {
                    if (definition != null) {
                        requestXTypes.put(requestType.getLabel(), definition.label);
                        requestTypeIds.put(definition.label, requestType.getId());
                        
                        if ((requestType.getCategory() != null) && 
                                BusinessManager.hasManagerProfile(requestType.getCategory().getName()))
                            managedRequestTypes.add(definition.label);
                    }
                }
                Collections.sort((List<String>)requestXTypes.getOneWayValues());
                Collections.sort((List<String>)managedRequestTypes);

            } catch (CvqException e) {
                e.getMessage();
            }
        }
    }

    public Collection<String> getRequestTypeLabels(String category) {
        ArrayList<String> labels = new ArrayList<String>();
        IRequestService requestService = BusinessManager.getDefaultRequestService();
        CategoryRecord categoryRecord = BusinessManager.getCategoryByName(category);
        if (categoryRecord != null) {
            try {
                Iterator iter = requestService.getRequestsTypesByCategory(categoryRecord.getId()).iterator();
                while (iter.hasNext()) {
                    labels.add(((RequestType)iter.next()).getLabel());
                }
            } catch (CvqException e) {
                e.getMessage();
            }
        }
        return labels;
    }
    
    public Collection<LetterTypeRecord> getLetterTypes(String label) {
        RequestDefinition definition = demandTypes.get(label);
        if (definition != null) {
            Long typeId = getRequestTypeId(definition.label);
            IRequestService requestService = BusinessManager.getDefaultRequestService();
            
            try {
                HashMap<String, LetterTypeRecord> letters = new HashMap<String, LetterTypeRecord>(); 

                Set<RequestForm> forms = 
                    requestService.getRequestTypeForms(typeId, RequestFormType.REQUEST_MAIL_TEMPLATE);
                for (RequestForm requestForm : forms) {
                    LetterTypeRecord letterType = new LetterTypeRecord();
                    
                    letterType.setId(requestForm.getId());
                    letterType.setLabel(requestForm.getLabel());
                    letterType.setShortLabel(requestForm.getShortLabel());
                    letterType.setXsltfo(requestForm.getXslFoFilename());

                    letters.put(letterType.getShortLabel(),letterType); 
                }
                definition.letters = letters;
                
                return definition.letters.values();
                
            } catch (CvqException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    public LetterTypeRecord getLetterType(String label, String type) {
        RequestDefinition definition = demandTypes.get(label);
        if (definition != null)
            return definition.letters.get(type);
        
        return null;
    }
    
    public RequestTypeRecord getRequestTypeRecord(String label) {
        RequestDefinition definition = demandTypes.get(label);
        if (definition != null) 
            try {
                Long typeId = getRequestTypeId(definition.label);
                IRequestService requestService = BusinessManager.getDefaultRequestService();
                RequestType requestType = requestService.getRequestTypeById(typeId);

                return getRequestTypeRecord(definition.groupId, requestType);
                
            } catch (CvqException e) {
                e.getMessage();
            }
        return null;
    }
    
    public RequestTypeRecord getRequestTypeRecord(RequestType requestType) {
        RequestDefinition definition = demandTypes.get(requestType.getLabel());
        
        int groupId = (definition != null) ? definition.groupId : -1; 
        
        return getRequestTypeRecord(groupId, requestType);
    }
    
    private RequestTypeRecord getRequestTypeRecord(int groupId, RequestType requestType) {
        RequestTypeRecord typeRecord = new RequestTypeRecord();
        typeRecord.setGroupId(groupId);
        typeRecord.setId(requestType.getId());
        typeRecord.setActivated(requestType.getActive());
        typeRecord.setType(requestType.getLabel());
        typeRecord.setLabel(getRequestTypeLabel(requestType.getLabel()));

        if (requestType.getInstructionMaxDelay() != null)
            typeRecord.setMaxDelay(requestType.getInstructionMaxDelay());
        else 
            typeRecord.setMaxDelay(getSiteData().getInstructionDefaultMaxDelay());
        
        if (requestType.getInstructionAlertDelay() != null)
            typeRecord.setAlertDelay(requestType.getInstructionAlertDelay());
        else
            typeRecord.setAlertDelay(getSiteData().getInstructionDefaultAlertDelay());
        
        if (requestType.getCategory() != null)
            typeRecord.setCategoryId(requestType.getCategory().getId());

        try {
            typeRecord.setSeasonable(BusinessManager.getRequestService(requestType.getLabel()).isOfRegistrationKind());
        } catch (CvqObjectNotFoundException e) {
            e.printStackTrace();
        } catch (CvqException e) {
            e.printStackTrace();
        }

        typeRecord.setConfigurable(false);
        Set data = BusinessManager.getReferentialRequestData(requestType.getLabel());
        if (data == null) {
            data = BusinessManager.getReservationData(requestType.getLabel(), true);
            typeRecord.setConfigurable(data != null);
            
        } else {
            typeRecord.setConfigurable((data !=null) && !data.isEmpty());
        }
        
        typeRecord.setParameters(data);
        typeRecord.setParameterState();
        
        setInformation(typeRecord);

        return typeRecord;
    }
    
    private void setInformation(RequestTypeRecord typeRecord) {
        RequestDefinition definition = demandTypes.get(typeRecord.getType());
        if (definition != null)
            typeRecord.setInformation(definition.informationLabel, definition.informationFile);
    }
    
    public List<ManagerProcessGroup> getGroups() {
        return groups;
    }

    private LocalAuthorityConfigurationBean getSiteData() {
        if (siteData == null)
            siteData = BusinessManager.getCurrentSiteData("");
        return siteData;
    }
}
