package com.zenexity.pict.cvq.fo.individuals;

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

import fr.cg95.cvq.exception.CvqException;

public class ViewController extends AbstractController {

    private Log log = LogFactory.getLog(ViewController.class);

    private EcitizenDataCache ecitizenDataCache;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        String title = request.getPreferences().getValue("title", "Les personnes du foyer");
        response.setTitle(title);

        try {

        		Set adults = (Set) ecitizenDataCache.getObject("adults");
        		model.put("adults", adults);
        		
        		Set children = (Set) ecitizenDataCache.getObject("children");
        		model.put("children", children);
        		model.put("homeFolderId",ecitizenDataCache.getObject(EcitizenDataCache.HOME_FOLDER_ID_KEY)) ;
        		
        } catch (CvqException e) {
            log.error("Error while retrieving home folder contents");
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
