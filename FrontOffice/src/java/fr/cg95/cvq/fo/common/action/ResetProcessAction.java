package fr.cg95.cvq.fo.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.dispatcher.SessionManager;

public class ResetProcessAction extends CreateRequestAction {

	public ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
			HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

//	    String keep = ProcessWizardState.SESSION_KEY;
//        
//        removeProcessSessionAttributes(pRequest.getSession(), keep);
		
        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);
        if (familyHome != null)
            familyHome.setIndividualToRegister(null);

		// We must re-create the request
        return super.doExecute(pMapping, pForm, pRequest, pResponse);
	}

}
