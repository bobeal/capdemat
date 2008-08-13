package fr.cg95.cvq.fo.personal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class ShowAdultAction extends BasePersonalAction {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
            HttpServletResponse pResponse) throws Exception {

        int index = Integer.parseInt(pRequest.getParameter(ManagerWizardState.INDEX_REQUEST_PARAMETER));

        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);

        AdultForm adult = (AdultForm) familyHome.getAdults().toArray()[index];

        pRequest.setAttribute("adult", adult);

        return null;
    }

}
