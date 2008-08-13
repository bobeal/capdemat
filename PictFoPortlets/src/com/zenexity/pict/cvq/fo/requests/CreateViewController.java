package com.zenexity.pict.cvq.fo.requests;

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

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;

public class CreateViewController extends AbstractController {

    private Log log = LogFactory.getLog(CreateViewController.class);

    private EcitizenDataCache ecitizenDataCache;
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        response.addProperty("script", request.getContextPath() + "/js/prototype.js");
        response.addProperty("script", request.getContextPath() + "/js/scriptaculous.js");
        response.addProperty("script", request.getContextPath() + "/dwr/interface/ECitizenDataCache.js");
        response.addProperty("script", request.getContextPath() + "/dwr/interface/RequestCreator.js");
        response.addProperty("script", request.getContextPath() + "/dwr/engine.js");
        response.addProperty("script", request.getContextPath() + "/dwr/util.js");
        
        model.put("currentUser", ecitizenDataCache.getCurrentUser());
        return new ModelAndView("createView", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    }

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
