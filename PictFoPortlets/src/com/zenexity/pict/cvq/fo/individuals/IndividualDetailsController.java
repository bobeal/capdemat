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

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;

public class IndividualDetailsController extends AbstractController {
	
	private static Log logger = LogFactory.getLog(IndividualDetailsController.class);
	private EcitizenDataCache ecitizenDataCache = null ;
	
	@Override
	protected void handleActionRequestInternal(ActionRequest arg0, ActionResponse arg1) throws Exception {
		
		String idAdult      = arg0.getParameter("idAdult")      ;
		String idChild      = arg0.getParameter("idChild")      ;
		String homeFolderId = arg0.getParameter("homeFolderId") ;
		String delete		= arg0.getParameter("supprim")      ;
		String isAdult      = arg0.getParameter("isAdult")      ;
		
		if(idAdult == null ){
			idAdult = "";//ecitizenDataCache.getIndividualId(ecitizenDataCache.getCurrentUser()).toString() ;
	
		}
		
		if(idChild != null){
			arg1.setRenderParameter("idChild",idChild) ;
			
		}
		if(homeFolderId == null){
			homeFolderId = "" ;
		}
		if(delete == null){
			delete = ""       ;
		}
		if(isAdult == null){
			isAdult = ""      ;
		}
		
		arg1.setRenderParameter("delete",delete)             ;
		arg1.setRenderParameter("idAdult",idAdult)           ;
		arg1.setRenderParameter("homeFolderId",homeFolderId) ;
		arg1.setRenderParameter("isAdult",isAdult)           ;
	}
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest arg0, RenderResponse arg1) throws Exception {
		
		String idAdult      = arg0.getParameter("idAdult")  		 ;
		String idChild      = arg0.getParameter("idChild")   		 ;
		String homeFolderId = arg0.getParameter("homeFolderId")      ;
		String delete       = arg0.getParameter("delete")            ;
		String isAdult      = arg0.getParameter("isAdult")           ;
		
		Map<String,Object> model = new HashMap<String,Object>() ;
		
		try {
			 if(isAdult == null ||"".equals(isAdult)){
				 
				if((idAdult != null) && (!"".equals(idAdult))){	
					
					model.put("adult",ecitizenDataCache.getAdultById(idAdult)) ;
						
				}else if(idChild != null && (!"".equals(idChild))){
						
					model.put("child",ecitizenDataCache.getChildById(idChild)) ;    
				}
					
			    model.put("homeFolderId",homeFolderId) ;
			 }else if("true".equalsIgnoreCase(isAdult) ){
				 Set adults = (Set)ecitizenDataCache.getObject("adults")       ;
				 Adult adult = ecitizenDataCache.getAdultById(idAdult)         ;
				 
				 adults.remove(adult) ;
				 
				 ecitizenDataCache.modify(adult.getLogin(),adults,true)        ;
				 
				// ecitizenDataCache.deleteIndividualById(ecitizenDataCache.getAdultById(idAdult).getLogin(),Long.valueOf(idAdult)) ;
				 
			 }else if("false".equalsIgnoreCase(isAdult)){
				 Set children = (Set)ecitizenDataCache.getObject("children")   ;
				 Child child  = ecitizenDataCache.getChildById(idChild)        ;
				 children.remove(child) ;
				 ecitizenDataCache.modify(ecitizenDataCache.getCurrentUser(),children,false) ;
				 //ecitizenDataCache.deleteIndividualById(ecitizenDataCache.getCurrentUser(),Long.valueOf(idChild)) ;
			 }
			
			
		} catch (Exception e) {
			
			if(logger.isDebugEnabled()){
				logger.debug("The giving exception has ocurred",e) ;
			}
			model.put("error","error.remote_exception") ;
		}
	    
		arg1.addProperty("script", arg0.getContextPath() + "/js/prototype.js")    ;
        arg1.addProperty("script", arg0.getContextPath() + "/js/scriptaculous.js");
        arg1.addProperty("script", arg0.getContextPath() + "/js/extensions.js")   ;
        
		if(delete != null && "ok".equalsIgnoreCase(delete)){
			return new ModelAndView("confirmDeletion",model) ; 
		}
		
        return new ModelAndView("detail",model) ;
		
	}
	
	/**
	 * 
	 * @param ecitizenDataCache
	 */
	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}	
	
}
