package fr.cg95.cvq.fo.common.action;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.manager.ManagerWizard;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class StartRequestAction extends BaseXmlAction {

    public StartRequestAction() {
        super();
    }

    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        resetProcessAttributes(request);

        removeProcessSessionAttributes(request.getSession());

        saveSessionAttributes(request.getSession());
        
        ManagerWizard.loadSessionObject(request.getSession(), true);
        RequestManager requestManager = SessionManager.getRequestManager(request);
        
        Request cvqRequest = new Request();
        
        String returnUrl = "";
        String name = request.getParameter(ProcessWizardState.NAME_REQUEST_PARAMETER);
        if (name != null) {
            int pos = name.indexOf(","); 
            if (pos > 0) {
                returnUrl = name.substring(pos + 1);
                returnUrl = returnUrl.substring(returnUrl.indexOf("=") + 1);
                name = name.substring(0, pos);
            }
        }
        cvqRequest.setProcess(name);
        cvqRequest.setType(requestManager.getRequestTypeModelLabel(name));

        if ((returnUrl == null) || (returnUrl.length() == 0))
            returnUrl = request.getParameter(Request.RETURN_URL_PARAMETER);

        if ((returnUrl == null) || (returnUrl.length() == 0))
            returnUrl = getDefaultUrl(request);

        cvqRequest.setReturnUrl(returnUrl);
        
        cvqRequest.setControlId(generateIdByClock());
        cvqRequest.setNoRequester(!isAuthentified(request));
        cvqRequest.setPublik(requestManager.isProcessPublic(cvqRequest.getProcess()));
        
        setRequiredDocuments(requestManager, cvqRequest);
        
        request.getSession().setAttribute(Request.class.getName(), cvqRequest);

        cvqRequest.setRules(requestManager.getRulesForm(cvqRequest.getProcess()));

        request.getSession().setAttribute(IProcessWizard.PROCESS_NAME, cvqRequest.getProcess());
        request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, cvqRequest.getProcess());
        
        initialiseProcess(servlet, request, response);

        if (request.getParameter("private") != null) {
            ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
            wizardState.setProcess(cvqRequest.getProcess());
            cvqRequest.setReturnUrl(getDefaultUrl(request) + "?submenu=" + wizardState.getSubmenu());
            request.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, "presentation");
            return mapping.findForward("private");
        } else {
            request.setAttribute("loginForm", new LoginForm());
            return mapping.findForward("presentation");
        }
    }

}
