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

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqException;

public class DocumentController extends AbstractController {

	private Log log = LogFactory.getLog(DocumentController.class);

    private EcitizenDataCache ecitizenDataCache;
   
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();
        String idAdult = request.getParameter("idAdult") ;
        String idChild = request.getParameter("idChild") ;
       
        try {

        		if((idAdult != null) && (!"".equals(idAdult))){
        			Adult adult = ecitizenDataCache.getAdultById(idAdult) ;
        			if(adult != null){
        				adult.setDocuments(ecitizenDataCache.getIndividualDocuments(adult.getLogin(),adult.getId())) ;
        			}
        			model.put("adult",adult) ;
        		}
        		if((idChild != null) && (!"".equals(idChild))){
        			Child child = ecitizenDataCache.getChildById(idChild) ;
        			if(child != null){
        				child.setDocuments(ecitizenDataCache.getIndividualDocuments(ecitizenDataCache.getCurrentUser() ,child.getId())) ;
        			}
        			model.put("child",child) ;
        			model.put("currentUser", ecitizenDataCache.getCurrentUser());
        		}
        		
        		if((!model.containsKey("adult")) && (!model.containsKey("child"))){
        			Set<Document> homeFolderDocuments = (Set<Document>) ecitizenDataCache.getObject("homeFolderDocuments");
        			model.put("homeFolderDocuments", homeFolderDocuments);
        			model.put("currentUser", ecitizenDataCache.getCurrentUser());
        		}
        		
        } catch (CvqException e) {
            log.error("Error while retrieving home folder requests");
            model.put("error", "error.remote_exception");
        }

        response.addProperty("script", request.getContextPath() + "/js/prototype.js");
        response.addProperty("script", request.getContextPath() + "/js/scriptaculous.js");
        
        return new ModelAndView("viewDocument", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
    	String idAdult = request.getParameter("idAdult") ;
    	String idChild = request.getParameter("idChild") ;
    	
    	if(idAdult == null){
    		idAdult = "" ;
    	}
    	if(idChild == null){
    		idChild = "" ;
    	}
    	response.setRenderParameter("idAdult",idAdult)   ;
    	response.setRenderParameter("idChild",idChild)   ;
    }

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}

}

















