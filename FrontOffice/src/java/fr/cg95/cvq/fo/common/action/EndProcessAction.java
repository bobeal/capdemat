package fr.cg95.cvq.fo.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class EndProcessAction extends BaseXmlAction {

    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());

        terminateRequest(request, null, cvqRequest);

        removeProcessSessionAttributes(request.getSession());

        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (familyHome != null)
            familyHome.setIndividualToRegister(null);

        // Display the wizard page from where the process was called
        response.sendRedirect(cvqRequest.getReturnUrl());

        return null;
    }

    protected void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState,
            Request cvqRequest) {
        RequestManager requestManager = SessionManager.getRequestManager(request);
        requestManager.terminateRequest(request, wizardState, cvqRequest);
    }

}
