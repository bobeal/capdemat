package fr.cg95.cvq.fo.common.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;

public class CreateRequestAction extends BaseXmlAction {

    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ProcessWizardState wizardState = getWizardState(request);
        
        Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());

        if (cvqRequest == null)
            saveSessionAttributes(request.getSession());
        
        RequestManager requestManager = SessionManager.getRequestManager(request);
        
        if (cvqRequest == null) {
            cvqRequest = new Request();
            
            cvqRequest.setProcess(request.getParameter(ProcessWizardState.NAME_REQUEST_PARAMETER));
            if (cvqRequest.getProcess() == null)
                cvqRequest.setProcess(wizardState.getProcessName());
            
            cvqRequest.setType(requestManager.getRequestTypeModelLabel(cvqRequest.getProcess()));

            String returnUrl = request.getParameter(Request.RETURN_URL_PARAMETER);
            if ((returnUrl == null) || (returnUrl.length() == 0))
                returnUrl = getDefaultUrl(request);

            cvqRequest.setReturnUrl(returnUrl);
            
            cvqRequest.setControlId(generateIdByClock());
            cvqRequest.setNoRequester(!isAuthentified(request)); // We have not logged in
            
            setRequiredDocuments(requestManager, cvqRequest);
            request.getSession().setAttribute(Request.class.getName(), cvqRequest);
            
            cvqRequest.setRules(requestManager.getRulesForm(cvqRequest.getProcess()));

        }

        RequestType rt = requestManager.createRequest(request, cvqRequest);

        if (rt != null) {
            initializeBean(rt, rt.schemaType());
            if (!isAuthentified(request))
                initializeRequester(rt,null);
            else {
                FamilyHome familyHome = SessionManager.getFamilyHome(request);
                initializeRequester(rt,familyHome.getFamilyHomeResponsible().getId());
                cvqRequest.setRequesterId(familyHome.getFamilyHomeResponsible().getId());

                if (familyHome.getIndividualToRegister() != null)
                    cvqRequest.setSubjectId(familyHome.getIndividualToRegister().getId());
    
                setExpectedDocuments(familyHome, cvqRequest);
            }
            cvqRequest.setData(rt);
            setRequestData(request, rt);
        }

        cvqRequest.setInitialised(true);

        return null;
    }

    protected void process(HttpServletRequest request) {
        ProcessWizardState wizardState = getWizardState(request);
        
        Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());

        RequestManager requestManager = SessionManager.getRequestManager(request);
        
        if (wizardState != null)
            wizardState.setWizardListener(requestManager.getPersistenceClass(cvqRequest));

        super.process(request);
    }

}
