package fr.cg95.cvq.bo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.RequestRecord;

public class HistoryAction extends BaseAction {

    public HistoryAction() {
        super();
    }

    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Get the session variables
        StateManager stateManager = getStateManager(request);

        RequestRecord record = (RequestRecord)stateManager.getSelectedRecord();
        
        // update the history records from model
        record.updateHistory();
        return null;
    }

}
