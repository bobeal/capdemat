package fr.cg95.cvq.business.request.workflow.event.impl;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.workflow.event.IWorkflowEvent;
import fr.cg95.cvq.business.request.workflow.event.IWorkflowEventVisitor;
import fr.cg95.cvq.business.request.workflow.event.IWorkflowPostAction;
import fr.cg95.cvq.exception.CvqException;

public abstract class WorkflowGenericEvent implements IWorkflowEvent {

    private static final long serialVersionUID = 1L;
    private Request request;
    private List<IWorkflowPostAction> workflowPostActions = new ArrayList<IWorkflowPostAction>();

    @Override
    public void accept(IWorkflowEventVisitor workflowEventVisitor) throws CvqException {}

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public WorkflowGenericEvent(Request request) {
        setRequest(request);
    }

    public List<IWorkflowPostAction> getWorkflowPostActions() {
        return workflowPostActions;
    }

    public void setWorkflowPostAction(IWorkflowPostAction workflowPostAction) {
        workflowPostActions.add(workflowPostAction);
    }
}
