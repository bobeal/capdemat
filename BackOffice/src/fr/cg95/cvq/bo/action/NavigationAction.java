package fr.cg95.cvq.bo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class NavigationAction extends BaseAction {

    public NavigationAction() {
        super();
    }

    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Get the session variables
        StateManager stateManager = getStateManager(request);
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
  
        if ((stateManager.getCurrentSearch() != null) && 
                !wizardState.getManager().equals(stateManager.getCurrentSearch().getSearch()) &&
                ((stateManager.getPreviousRecord() == null) || (stateManager.getPreviousRecord() instanceof RequestRecord))) {
            request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, stateManager.getCurrentSearch().getSearch());
            stateManager.setSelectedRecord(stateManager.getPreviousRecord());

        } else if ((stateManager.getAccountSearch() != null) && 
                !wizardState.getManager().equals(stateManager.getAccountSearch().getSearch()) &&
                (stateManager.getPreviousRecord() instanceof FamilyRecord)) {
            request.setAttribute(ManagerWizardState.NAME_REQUEST_PARAMETER, stateManager.getAccountSearch().getSearch());
            stateManager.setSelectedRecord(stateManager.getPreviousRecord());
        }
        return null;
    }

}
