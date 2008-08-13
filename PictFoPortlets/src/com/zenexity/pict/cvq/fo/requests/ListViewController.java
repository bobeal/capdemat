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

public class ListViewController extends AbstractController {

    private Log log = LogFactory.getLog(ListViewController.class);

    private EcitizenDataCache ecitizenDataCache;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        String requestedState;
        if (request.getParameter("requestedState") != null)
        		requestedState = request.getParameter("requestedState");
        else
        		requestedState = "inprogressRequests";
        model.put("requestedState", requestedState);
        
        try {

        		Set<Request> requests = (Set<Request>) ecitizenDataCache.getObject(requestedState);
        		model.put("requests", requests);
        		
        } catch (CvqException e) {
            log.error("Error while retrieving home folder requests");
            model.put("error", "error.remote_exception");
        }

        // TODO : i18n
        String title = null;
        if (requestedState.equals("inprogressRequests"))
        		title = "Mes demandes en cours";
        else if (requestedState.equals("acceptedRequests"))
        		title = "Mes demandes acceptées";
        else if (requestedState.equals("archivedRequests"))
        		title = "Mes demandes archivées";
        else if (requestedState.equals("failedRequests"))
        		title = "Mes demandes annulées";
        response.setTitle(title);
        
        return new ModelAndView("listView", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    		if (request.getParameter("requestedState") != null)
    			response.setRenderParameter("requestedState", request.getParameter("requestedState"));
    }

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
