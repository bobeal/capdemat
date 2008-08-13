package com.zenexity.pict.cvq.fo.toolbar;

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

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Document;
import fr.cg95.cvq.exception.CvqException;

public class ViewController extends AbstractController {

    private Log log = LogFactory.getLog(ViewController.class);

    private EcitizenDataCache ecitizenDataCache;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        try {

        		Set<Adult> adults = (Set<Adult>) ecitizenDataCache.getObject("adults");
        		model.put("adults", adults);
        		Set<Document> homeFolderDocuments = (Set<Document>) ecitizenDataCache.getObject("homeFolderDocuments");
        		model.put("homeFolderDocuments", homeFolderDocuments);
        		
        } catch (CvqException e) {
            log.error("Error while retrieving home folder requests");
            model.put("error", "error.remote_exception");
        }

        response.addProperty("script", request.getContextPath() + "/js/prototype.js");
        response.addProperty("script", request.getContextPath() + "/js/scriptaculous.js");
        
        return new ModelAndView("view", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    }

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
