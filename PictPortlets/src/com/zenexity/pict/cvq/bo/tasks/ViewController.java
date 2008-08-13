package com.zenexity.pict.cvq.bo.tasks;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exporter.service.bo.IAgentTaskService;

public class ViewController extends AbstractController {

    private Log log = LogFactory.getLog(ViewController.class);

    private IAgentTaskService agentTaskService;
    private CvqHttpInvoker cvqHttpInvoker;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        String title = request.getPreferences().getValue("title", "Tâches CVQ");
        response.setTitle(title);

        try {
            Map agentTasks = agentTaskService.getCurrentAgentTasks();
            model.put("tasksCount", agentTasks);
        } catch (CvqException e) {
            log.error("Agent not found in CVQ database");
            model.put("error", "error.remote_exception");
        }

        model.put("backofficeUrl", cvqHttpInvoker.getServiceUrl() + "/BackOffice");
        return new ModelAndView("view", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    }

    public void setAgentTaskService(IAgentTaskService agentTaskService) {
        this.agentTaskService = agentTaskService;
    }

    public void setCvqHttpInvoker(CvqHttpInvoker cvqHttpInvoker) {
		this.cvqHttpInvoker = cvqHttpInvoker;
	}
}
