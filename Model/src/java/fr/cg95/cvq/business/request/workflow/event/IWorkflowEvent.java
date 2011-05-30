package fr.cg95.cvq.business.request.workflow.event;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.business.request.workflow.event.IWorkflowEventVisitor;

public interface IWorkflowEvent {
    void accept(IWorkflowEventVisitor workflowEventVisitor) throws CvqException;
}
