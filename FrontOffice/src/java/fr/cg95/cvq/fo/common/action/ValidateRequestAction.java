package fr.cg95.cvq.fo.common.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.Validation;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.business.users.MeansOfContact;

public class ValidateRequestAction extends BaseAction {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest request,
            HttpServletResponse pResponse) throws Exception {

        Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());
        RequestType xmlbRequest = (RequestType)getRequestData(request);
        Validation validation = getValidationData(request);
        
        if (cvqRequest.isAlreadyExecuted()) {
                return null;
        }
        if (!isAuthentified(request)) {
            String controlId = validation.getControlId();
            if ((controlId == null) || !controlId.equals(cvqRequest.getControlId())) {
                validation.setControlId("");
                cvqRequest.setControlId(generateIdByClock());
                request.setAttribute("CodeError","");
                return null;
            }
        }
        ProcessWizardState wizardState = getWizardState(request);

        if (wizardState.getState(wizardState.getStage()).equals("validation") && validation.isTrace()) {
            wizardState.setTransition("trace");
            return null;
        }
        
        // set the request as already executed
        cvqRequest.setAlreadyExecuted(true);
        
        MeansOfContact moc = BusinessManager.getInstance().getMeansOfContactByType(MeansOfContactEnum.forString(validation.getMeansOfContact()));
        xmlbRequest.setMeansOfContact(moc.modelToXml(moc));

        if (validation.isTrace()) {
            AdultType requester = xmlbRequest.getRequester();
            requester.setPassword(validation.getPassword());
            requester.setQuestion(validation.getQuestion());
            requester.setAnswer(validation.getAnswer());
        }

        Long requestId = validateRequest(request, cvqRequest, xmlbRequest);
        
        // update the request form for displaying new elements
        updateRequest(request, cvqRequest, requestId);
        
// Family Id for save documents from request, NOT from a session variable!!!!
        Long familyHomeId = BusinessManager.getInstance().findFamilyHomeIdByRequestId(requestId);
        Long requesterId = null;
        if (familyHomeId == null)
            requesterId = cvqRequest.getRequesterId();
        
        saveDocuments(cvqRequest, familyHomeId, requesterId);

        terminateRequest(request, wizardState, cvqRequest);
        
        return null;
    }
    
    protected Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData) throws Exception {
        return SessionManager.getRequestManager(request).validateRequest(request, cvqRequest, xmlRequestData);
    }
    
    protected void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState, 
                                        Request cvqRequest) {
        // set the action name to the GUI wizard state
        wizardState.setTransition("print");

        // set the previous step to false
        wizardState.setPrevious("false");

        // set the next step to the end function
        wizardState.setNext("endProcess");

        SessionManager.getRequestManager(request).terminateRequest(request, wizardState, cvqRequest);
    }

    private Validation getValidationData(HttpServletRequest request) {
        Validation validation = (Validation)request.getSession().getAttribute(Validation.class.getName());
        if (validation == null) {
            validation = new Validation();
            request.getSession().setAttribute(Validation.class.getName(), validation);
        }
        getUserData(request, validation);
        return validation;
    }
    
    private LocalReferentialDataType[] saveForm(String formData, Collection repData) {
        LocalReferentialDataType[] xmlData = new LocalReferentialDataType[1];
        xmlData[0] = LocalReferentialDataType.Factory.newInstance();
        xmlData[0].setName(formData);
        
        return xmlData;
    }
    
    private void updateRequest(HttpServletRequest httpRequest, Request cvqRequest, Long requestId) throws CvqObjectNotFoundException, CvqException {
        
        fr.cg95.cvq.business.users.Request request = BusinessManager.getInstance().getRequestService().getById(requestId);

        cvqRequest.setId(requestId);
        cvqRequest.setFamilyHomeId(request.getHomeFolder().getId());
        cvqRequest.setLogin(request.getRequester().getLogin());
        cvqRequest.setRequesterId(request.getRequester().getId());
    }
    
}
