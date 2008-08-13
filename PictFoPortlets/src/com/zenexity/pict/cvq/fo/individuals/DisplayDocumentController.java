package com.zenexity.pict.cvq.fo.individuals;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;

public class DisplayDocumentController extends AbstractController {
	
	private EcitizenDataCache ecitizenDataCache = null ;

	@Override
	protected void handleActionRequestInternal(ActionRequest arg0, ActionResponse arg1) throws Exception {
		String documentId = arg0.getParameter("documentId") ;
		String name = arg0.getParameter("name") ;
		String homeFolderId = arg0.getParameter("homeFolderId") ;
		
		if(documentId == null || "".equals(documentId)){
			documentId = "";
		}
		if(name == null || "".equals(name)){
			name = "" ;
		}
		if(homeFolderId == null){
			homeFolderId = "" ;
		}
		
		arg1.setRenderParameter("documentId",documentId) ;
		arg1.setRenderParameter("name",name) ;
		arg1.setRenderParameter("homeFolderId",homeFolderId) ;
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest arg0, RenderResponse arg1) throws Exception {
		
		Map<String, String> model = new HashMap<String, String>();
		String documentId = arg0.getParameter("documentId") ;
		String name = arg0.getParameter("name") ;
		String homeFolderId = arg0.getParameter("homeFolderId") ; 
		
		if(documentId != null && !"".equals(documentId)){
			model.put("documentId",documentId) ;
		}
		if(name != null && !"".equals(name)){
			model.put("name",name) ;
		}
		if(homeFolderId == null){
			homeFolderId = "" ;
		}
		model.put("homeFolderId",homeFolderId) ;
		
		return new ModelAndView("displayDocument","model",model);
	}

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}

	
}
