package fr.cg95.cvq.bo.action;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.form.RequestForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.bo.record.SeasonRecord;
import fr.cg95.cvq.bo.tag.ExceptionTag;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class RequestAction extends BaseAction {

    public RequestAction() {
        super();
    }

    protected ActionForward executeLogic(
            ActionMapping mapping, 
            ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Update the wizard with the request parameters
        updateWizardState(request);

        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        StateManager stateManager = getStateManager(request);

        RequestForm requestForm = (RequestForm)form;
        if (requestForm == null)
            requestForm = new RequestForm();

        requestForm.initAllrtypes(stateManager.getRequestManager(),false);
        requestForm.initSeasonrtypes(stateManager.getRequestManager(),false);
        requestForm.initGrouprtypes(stateManager.getRequestManager());
        
        if (request.getParameter("clear") != null)
            requestForm.setRequestTypeRecord(stateManager, null);
        
        String save = request.getParameter("save");
        if (save != null) try {
            if (save.equals("rtypes")) {
                BusinessManager.saveRequestTypes(requestForm.getAllrtypes());

            } else if (save.equals("meansOfContact")) {
                BusinessManager.saveMeansOfContact(requestForm.getMeansOfContact());

            } else if (save.equals("documents")) {
                BusinessManager.setScanDocumentData(requestForm.isScanDocumentData());
                BusinessManager.saveRequirements(requestForm.getRequestType(), requestForm.getDocuments());

            } else if (save.equals("season")) {
                SeasonRecord record = null;
                List<SeasonRecord> seasons = requestForm.getSeasons();
                for (SeasonRecord seasonRecord : seasons) {
                    if ((seasonRecord.getLabel() != null) &&
                         seasonRecord.getLabel().equals(requestForm.getLabel()))
                        record = seasonRecord;
                }
                Long requestTypeId = requestForm.getRequestType().getId();
                
                try {
                    if (requestForm.getDelete() != null) {
                        if (record != null) {
                            BusinessManager.deleteSeason(requestTypeId, record);
                            seasons.remove(record);
                            
                            if (seasons.isEmpty())
                                seasons.add(new SeasonRecord());
                        }                    
                        record = null;
    
                    } else if (requestForm.getModify() != null) {
                        if (record == null)
                            if (requestForm.getLine() < seasons.size())
                                record = seasons.get(requestForm.getLine());
                        
                    } else if (requestForm.getAdd() != null) {
                        if (record == null) {
                            if ((seasons.size() == 1) && (seasons.get(0).getLabel() == null))
                                record = seasons.get(0);
                            else {
                                record = new SeasonRecord();
                                seasons.add(record);
                                requestForm.setLine(seasons.size()-1);
                            }
                        }
                    }    
                    if (record != null) {
                        record.setLabel(requestForm.getLabel());
                        record.setStartDate(Utils.getStringAsDate(requestForm.getStartDate()));
                        record.setEndDate(Utils.getStringAsDate(requestForm.getEndDate()));
                        record.setStartInscription(Utils.getStringAsDate(requestForm.getStartInscription()));
                        record.setEndInscription(Utils.getStringAsDate(requestForm.getEndInscription()));
                        record.setValidationDate(Utils.getStringAsDate(requestForm.getValidationDate()));

                        BusinessManager.saveSeason(requestTypeId, record);
                        requestForm.resetSeasons();
                    }
                } catch (CvqException ce) {
                    requestForm.resetSeasons();
                    throw ce;
                }
                
            } else if (save.equals("alert")) {
                RequestTypeRecord record = requestForm.getRequestType();
                record.setMaxDelay(requestForm.getMaxDelay());
                record.setAlertDelay(requestForm.getAlertDelay());
                
                BusinessManager.saveAlert(record);

            } else if (save.equals("layout")) {
                LetterTypeRecord record = null;
                List<LetterTypeRecord> letterTypes = requestForm.getLetterTypes();
                for (LetterTypeRecord letterTypeRecord : letterTypes) {
                    if ((letterTypeRecord.getLabel() != null) &&
                            letterTypeRecord.getLabel().equals(requestForm.getLetterLabel()))
                        record = letterTypeRecord;
                }
                Long requestTypeId = requestForm.getRequestType().getId();
                
                try {
                    if (requestForm.getDelete() != null) {
                        if (record != null) {
                            BusinessManager.deleteLetterType(requestTypeId, record);
                            letterTypes.remove(record);
                            if (letterTypes.isEmpty())
                                letterTypes.add(new LetterTypeRecord());
                        }
                        record = null;
                        
                    } else if (requestForm.getModify() != null) {
                        if (record == null)
                            if (requestForm.getLine() < letterTypes.size())
                                record = letterTypes.get(requestForm.getLine());
                        
                    } else if (requestForm.getAdd() != null) {
                        if (record == null) {
                            if ((letterTypes.size() == 1) && (letterTypes.get(0).getLabel() == null))
                                record = letterTypes.get(0);
                            else {
                                record = new LetterTypeRecord();
                                letterTypes.add(record);
                                requestForm.setLine(letterTypes.size()-1);
                            }
                        }
                    }    
                    if (record != null) {
                        record.setLabel(requestForm.getLetterLabel());
                        record.setShortLabel(requestForm.getLetterShortLabel());
                        record.setXsltfo(requestForm.getFile().getFileName());
                        
                        BusinessManager.saveLetterType(requestTypeId, record, requestForm.getFile().getFileData());
                        requestForm.resetLetterTypes(stateManager);
                    }    
                } catch(CvqException ce) {
                    requestForm.resetLetterTypes(stateManager);
                    throw ce;
                }
                
            } else if (save.equals("information")) {
                File file = DispatchFilter.getAssetsBaseFile(requestForm.getRequestType().getInformationFile());
                FileWriter writer = new FileWriter(file);
                writer.write(request.getParameter("information"));
                writer.close();

            } else if (save.equals("activate")) {
                RequestTypeRecord record = requestForm.getRequestType(); 
                record.setActivated(!record.isActivated());
                BusinessManager.saveRequestType(record);
            }
            if (requestForm.getRequestType() != null)
                requestForm.getRequestType().setParameterState();
       
        } catch (CvqException ce) {
            setInfo("/jsp/bo/service/error");
            request.setAttribute(ExceptionTag.ID, ce);
        }
        
        String state = request.getParameter(ManagerWizardState.TRANSITION_REQUEST_PARAMETER);

        // If there is no admin parameter in the request, find the id from the current tab
        if (state == null)
            state = wizardState.getTabId();

        if ((state != null) && state.equals("select")) {
            int index = Integer.parseInt(request.getParameter("order"));
            
            requestForm.selectGroup(stateManager.getRequestManager(), index);
        }
        
        String select = request.getParameter("select");
        if (select != null && select.equals("type")) {
            requestForm.setRequestTypeRecord(stateManager, 
                    requestForm.getGroupRequestTypeRecord(wizardState.getIndex()));
        }
//        requestForm.initAllrtypes(stateManager.getRequestManager(),true);
        
        // Set the selected item based on the wizardstate and the index
//        requestForm.setRequestTypeRecord(wizardState.getIndex(), state);
        requestForm.setScanDocumentData(stateManager.getScanDocumentData());
        requestForm.setAlertsEnabled(stateManager.getAlertsEnabled());
        
        stateManager.setSelectedRecord(null);

        // Update the wizard state indirectly with additional specific parameters, 
        request.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, state);

        // We are looking for administration, so we display the admin manager
        request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, "process");

        return null;
    }

}
