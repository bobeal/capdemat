package com.zenexity.pict.cvq.fo.requests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;

import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;

public class SynViewController extends AbstractController {

    private Log log = LogFactory.getLog(SynViewController.class);

    private EcitizenDataCache ecitizenDataCache;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        String title = request.getPreferences().getValue("title", "Les demandes du foyer");
        response.setTitle(title);

        String requestedState = null;
        if (request.getParameter("requestedState") != null)
        		requestedState = request.getParameter("requestedState");
        else 
        		requestedState = "inprogressRequests";
        model.put("requestedState", requestedState);
        
        try {

        		model.put("inprogressRequests", (Set<Request>) ecitizenDataCache.getObject("inprogressRequests"));
        		model.put("acceptedRequests", (Set<Request>) ecitizenDataCache.getObject("acceptedRequests"));
        		model.put("archivedRequests", (Set<Request>) ecitizenDataCache.getObject("archivedRequests"));
        		model.put("failedRequests", (Set<Request>) ecitizenDataCache.getObject("failedRequests"));
        		
        } catch (CvqException e) {
            log.error("Error while retrieving home folder requests");
            model.put("error", "error.remote_exception");
        }

        return new ModelAndView("synView", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    		if (request.getParameter("requestedState") != null)
    			response.setRenderParameter("requestedState", request.getParameter("requestedState"));
    }

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
