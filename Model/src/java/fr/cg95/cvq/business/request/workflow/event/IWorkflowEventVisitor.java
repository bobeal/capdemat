package fr.cg95.cvq.business.request.workflow.event;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowDraftEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowPendingEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowInProgressEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowExtInProgressEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowCompleteEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowUncompleteEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowRectifiedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowRejectedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowCancelledEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowValidatedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowNotifiedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowClosedEvent;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowArchivedEvent;

public interface IWorkflowEventVisitor {
    void visit(final WorkflowDraftEvent wfEvent) throws CvqException;

    void visit(final WorkflowPendingEvent wfEvent) throws CvqException;

    void visit(final WorkflowInProgressEvent wfEvent) throws CvqException;

    void visit(final WorkflowExtInProgressEvent wfEvent) throws CvqException;

    void visit(final WorkflowCompleteEvent wfEvent) throws CvqException;

    void visit(final WorkflowUncompleteEvent wfEvent) throws CvqException;

    void visit(final WorkflowRectifiedEvent wfEvent) throws CvqException;

    void visit(final WorkflowRejectedEvent wfEvent) throws CvqException;

    void visit(final WorkflowCancelledEvent wfEvent) throws CvqException;

    void visit(final WorkflowValidatedEvent wfEvent) throws CvqException;

    void visit(final WorkflowNotifiedEvent wfEvent) throws CvqException;

    void visit(final WorkflowClosedEvent wfEvent) throws CvqException;

    void visit(final WorkflowArchivedEvent wfEvent) throws CvqException;
}
