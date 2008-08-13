package com.zenexity.pict.cvq.fo.login;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;

public class ViewController extends AbstractController {

	private EcitizenDataCache ecitizenDataCache;
	
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {

		if (request.getRemoteUser() == null) {
			Map<String, String> model = new HashMap<String, String>();
			model.put("error", request.getParameter("error"));
			model.put("username", request.getParameter("username"));
			return new ModelAndView("form", model);
		} else {
			return new ModelAndView("profile");
		}
	}

	public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {

		if (request.getParameter("error") != null) {
			response.setRenderParameter("error", request.getParameter("error"));
			response.setRenderParameter("username", request.getParameter("username"));
		} else if (request.getParameter("init") != null) {
			ecitizenDataCache.initHomeFolder(request.getParameter("username"));
		} else if (request.getParameter("release") != null) {
			ecitizenDataCache.releaseHomeFolder();
		}
	}

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
}
