package fr.cg95.cvq.fo.business;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.RulesForm;
import fr.cg95.cvq.fo.dispatcher.DispatchFilter;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class RequestManager implements Serializable {

    private HashMap _requestTypes = null;

    public RequestManager() {
        super();
    }

    private HashMap getRequestTypes() {
        if (_requestTypes == null) {
            _requestTypes = new HashMap();

            addRequestTypes();

            updateRequestTypes();
        }
        return _requestTypes;
    }

    private void addRequestTypes() {
        Iterator iter = ProcessWizardPlugin.plugin().getProcesses().iterator();
        while (iter.hasNext()) {
            IProcessWizard processWizard = (IProcessWizard) iter.next();
            Process process = new Process();
            process.setName(processWizard.getName());
            process.setLabel(processWizard.getTitle());
            process.setTime(processWizard.getTime());
            process.setInformationFile(processWizard.getInformationFile());
            process.setInformationLabel(processWizard.getInformationLabel());

            if (process.setPersistence(processWizard.getPersistence()))
                try {
                    String serviceName = process.getPersistence().getServiceName(process.getName());
                    process.setModel(getRequestTypeServiceLabel(serviceName));
                    process.setInscriptionType(getInscriptionType(serviceName));
                    _requestTypes.put(process.getName(), process);
                    _requestTypes.put(process.getModel(), process);
                } catch (Exception e) {
                    e.getMessage();
                }
        }
    }

    private String getRequestTypeServiceLabel(String service) {
        if (service != null) {
            IRequestService requestService = (IRequestService) BusinessManager.getAc().getBean(service);
            return requestService.getLabel();
        }
        return null;
    }

    private boolean getInscriptionType(String service) {
        if (service != null) {
            IRequestService requestService = (IRequestService) BusinessManager.getAc().getBean(service);
            return requestService.isOfRegistrationKind();
        }
        return false;
    }

    private void updateRequestTypes() {
        try {
            Iterator iter = BusinessManager.getInstance().getRequestService().getAllRequestTypes().iterator();
            while (iter.hasNext()) {
                RequestType requestType = (RequestType) iter.next();
                Process process = (Process) _requestTypes.get(requestType.getLabel());
                if (process != null) {
                    process.setTypeId(requestType.getId());
                    _requestTypes.put(process.getTypeId(), process);
                }
            }

            IRequestServiceRegistry registry = (IRequestServiceRegistry) BusinessManager.getAc().getBean(
                    IRequestServiceRegistry.SERVICE_NAME);
            iter = registry.getServicesSupportingUnregisteredCreation().iterator();
            while (iter.hasNext()) {
                IRequestService requestService = (IRequestService) iter.next();
                Process process = (Process) _requestTypes.get(requestService.getLabel());
                if (process != null)
                    process.setPublik(true);
            }
        } catch (CvqException e) {
            e.getMessage();
        }
    }

    public IPersistence getPersistenceClass(Request cvqRequest) {
        Process process = (Process) getRequestTypes().get(cvqRequest.getProcess());
        if (process != null)
            return process.getPersistence();

        return null;
    }

    public fr.cg95.cvq.xml.common.RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        Process process = (Process) getRequestTypes().get(cvqRequest.getProcess());
        if ((process != null) && (process.getPersistence() != null))
            return process.getPersistence().createRequest(request, cvqRequest);

        return null;
    }

    public String getMessage(Request cvqRequest) {
        Process process = (Process) getRequestTypes().get(cvqRequest.getProcess());
        if ((process != null) && (process.getPersistence() != null))
            return process.getPersistence().getMessage();
        
        return null;
    }

    public String getTime(String processName) {
        Process process = (Process) getRequestTypes().get(processName);
        if (process != null)
            return process.getTime();
        
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        Process process = (Process) getRequestTypes().get(cvqRequest.getProcess());
        if ((process != null) && (process.getPersistence() != null))
            return process.getPersistence().validateRequest(request, cvqRequest, xmlRequestData);

        return null;
    }

    public void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState,
            Request cvqRequest) {
        Process process = (Process) getRequestTypes().get(cvqRequest.getProcess());
        if ((process != null) && (process.getPersistence() != null))
            process.getPersistence().terminateRequest(request, wizardState, cvqRequest);
    }

    public String getRequestTypeModelLabel(String requestType) {
        Process process = (Process) getRequestTypes().get(requestType);
        if (process != null)
            return process.getModel();

        return "";
    }

    public String getRequestTypeLabel(String requestType) {
        Process process = (Process) getRequestTypes().get(requestType);
        if (process != null)
            return process.getLabel();

        return "";
    }

    public RequestType getRequestType(Request request) {
        return getRequestType(request.getProcess());
    }

    public RequestType getRequestType(String requestType) {
        Process process = (Process) getRequestTypes().get(requestType);
        if (process != null)
            try {
                return BusinessManager.getInstance().getRequestService().getRequestTypeById(
                        process.getTypeId());
            } catch (CvqException e) {
            }

        return null;
    }

    public boolean hasOpenSeasons(String processName) {
        Process process = (Process) getRequestTypes().get(processName);
        if (process != null) {
            try {
                String serviceName = process.getPersistence().getServiceName(process.getName());
                return ((IRequestService) BusinessManager.getAc().getBean(serviceName))
                        .isRegistrationOpen(process.getTypeId());

            } catch (CvqObjectNotFoundException e) {
            } catch (CvqException e) {
            } catch (NullPointerException e) {
            }
        }
        return false;
    }

    public Map getAuthorizedSubjects(String processName, Long familyId) {
        Process process = (Process) getRequestTypes().get(processName);
        if (process != null) {
            try {
                String serviceName = process.getPersistence().getServiceName(process.getName());
                return ((IRequestService) BusinessManager.getAc().getBean(serviceName))
                        .getAuthorizedSubjects(familyId);

            } catch (CvqObjectNotFoundException e) {
            } catch (CvqException e) {
            } catch (NullPointerException e) {
            }
        }
        return null;
    }

    public boolean getRequestTypeActive(String processName) {
        RequestType requestType = getRequestType(processName);
        if (requestType != null)
            return requestType.getActive().booleanValue();

        return false;
    }

    public boolean isProcessPublic(String requestType) {
        Process process = (Process) getRequestTypes().get(requestType);
        if (process != null)
            return process.isPublik();

        return false;
    }

    public boolean isInscriptionType(String requestType) {
        Process process = (Process) getRequestTypes().get(requestType);
        if (process != null)
            return process.isInscriptionType();

        return false;
    }

    public RulesForm getRulesForm(String processName) {
        Process process = (Process) getRequestTypes().get(processName);
        if ((process != null) && (process.getInformationFile() != null)) {
            RulesForm rules = new RulesForm();
            rules.setTitle(process.getInformationLabel());
            rules.setContent(process.getInformationFile());
            return rules;
        }
        return null;
    }

    public boolean getExists(String fileName) {
        File file = DispatchFilter.getAssetsBaseFile(fileName);

        return file.exists();
    }

}

class Process implements Serializable {

    private boolean active = true;

    private String name;

    private String label;

    private String model;

    private Long typeId;

    private boolean publik = false;

    private boolean inscriptionType = false;
    
    private IPersistence persistence;
    
    private String time;
    
    private String informationLabel;

    private String informationFile;

    public Process() {
        super();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isPublik() {
        return publik;
    }

    public void setPublik(boolean publik) {
        this.publik = publik;
    }

    public boolean isInscriptionType() {
        return inscriptionType;
    }

    public void setInscriptionType(boolean inscriptionType) {
        this.inscriptionType = inscriptionType;
    }

    public IPersistence getPersistence() {
        return persistence;
    }

    public boolean setPersistence(String persistence) {
        try {
            this.persistence = (IPersistence) Class.forName(persistence).newInstance();
            return true;

        } catch (InstantiationException e) {
            e.getMessage();
        } catch (IllegalAccessException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (ClassCastException e) {
            e.getMessage();
        }
        return false;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInformationFile() {
        return informationFile;
    }

    public void setInformationFile(String informationFile) {
        this.informationFile = informationFile;
    }

    public String getInformationLabel() {
        return informationLabel;
    }

    public void setInformationLabel(String informationLabel) {
        this.informationLabel = informationLabel;
    }

}
