package fr.cg95.cvq.business.request.workflow.event;

import fr.cg95.cvq.service.request.IRequestWorkflowService;

public interface IWorkflowPostAction {

    String getExecutor();

    void execute(IRequestWorkflowService requestWorkflowService);
}
