package com.zenexity.pict.cvq.fo.individuals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;

public class HoranetConsumptionController extends AbstractController {
	
	private EcitizenDataCache ecitizenDataCache = null ;
	private Log logger = LogFactory.getLog(HoranetConsumptionController.class) ;
	
	
	
	@Override
	protected void handleActionRequestInternal(ActionRequest arg0, ActionResponse arg1) throws Exception {
		String idAdult     = arg0.getParameter("idAdult")     ;
		String idChild     = arg0.getParameter("idChild")     ;
		String fromFom     = arg0.getParameter("fromForm")    ;
		String date        = arg0.getParameter("fromdate")    ;
		String requestType = arg0.getParameter("requests")    ;
		String displayType = arg0.getParameter("displayType") ; 
		
		
		
		if(idAdult != null && !"".equals(idAdult)){
			arg1.setRenderParameter("idAdult",idAdult) ;
		}
		if(idChild != null && !"".equals(idChild)){
			arg1.setRenderParameter("idChild",idChild) ;
		}
		if(fromFom == null ||"".equals(fromFom)){
			fromFom = "false" ;
		}
		if(date == null){
			date = "" ;
		}
		if(requestType == null){
			requestType = "" ;
			
		}
		if(displayType == null){
			displayType = "Détaillé" ;
		}
		arg1.setRenderParameter("fromForm",fromFom)        ;
		arg1.setRenderParameter("fromdate",date)           ;
		arg1.setRenderParameter("requests",requestType)    ;
		arg1.setRenderParameter("displayType",displayType) ;
	}
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest arg0, RenderResponse arg1) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		String idAdult  = arg0.getParameter("idAdult") ;
		String idChild  = arg0.getParameter("idChild") ; 
		String fromForm = arg0.getParameter("fromForm");
		
		try {
			if(idAdult != null && !"".equals(idAdult)){
				
				Individual adult = ecitizenDataCache.getAdultById(idAdult) ;
				Set aux = ecitizenDataCache.getBySubjectId(adult.getLogin(),adult.getId()) ;
				Set  comsumptionAdultRequests = new HashSet() ;
				
				//check if we will process the form 
				if(fromForm != null && "true".equalsIgnoreCase(fromForm)){
					horanetIndividualDetail(arg0, model,adult, aux);
				}
				
				//we find out all consumption requests to display theire label
				for(Object req : aux){
					if(req instanceof Request){
						Request request = (Request)req ;
						if(ecitizenDataCache.hasConsumptions(adult.getLogin(),request.getRequestType().getLabel() )){
							comsumptionAdultRequests.add(req) ;
						}
					}
				}
				
				model.put("consumptionAdultRequests",comsumptionAdultRequests) ;
				model.put("idAdult",idAdult) ;
				
			}else if(idChild != null && !"".equals(idChild)){
				
				Individual child = ecitizenDataCache.getChildById(idChild) ;
				Set aux = ecitizenDataCache.getBySubjectId(ecitizenDataCache.getCurrentUser(),child.getId()) ;
				Set comsumptionChildRequests = new HashSet() ;
				
				if(fromForm != null && "true".equalsIgnoreCase(fromForm)){
					horanetIndividualDetail(arg0, model,child, aux);
				}
				
				for(Object req : aux){
					if(req instanceof Request){
						Request request = (Request)req ;
						if(ecitizenDataCache.hasConsumptions(ecitizenDataCache.getCurrentUser(),request.getRequestType().getLabel() )){
							comsumptionChildRequests.add(req) ;
						}
					}
				}
				
				model.put("consumptionChildRequests",comsumptionChildRequests) ;
				model.put("idChild",idChild) ;
			}
			
			model.put("adults", ecitizenDataCache.getObject("adults"))    ;
			model.put("children", ecitizenDataCache.getObject("children"));
			
		} catch (CvqException e) {
			logger.error("Error while retrieving home folder contents");
			model.put("error", "error.remote_exception");
		}
		
		arg1.addProperty("script", arg0.getContextPath() + "/js/calendarDateInput.js");
		
		return new ModelAndView("horanetConsumption",model) ;
	}

	private void horanetIndividualDetail(RenderRequest arg0, Map<String, Object> model,Individual individual, Set aux) 
	throws ParseException, CvqException, Exception {
		
		String pattern     = "DD/MM/yyyy"                     ;
		String date        = arg0.getParameter("fromdate")    ;
		String requestType = arg0.getParameter("requests")    ;
		String displayType = arg0.getParameter("displayType") ; 
		
		DateFormat df =  new SimpleDateFormat(pattern)        ;
		
		Date from = df.parse(date.replace('-','/'))           ;
		Calendar calendar = Calendar.getInstance()            ;
		calendar.setTime(from)                                ;
		calendar.add(Calendar.WEEK_OF_MONTH,1)                ;
		Date to = calendar.getTime()                          ;
		
		Request currentRequest = null                         ;
		
		for(Object req : aux){
			if(req instanceof Request){
				Request request = (Request)req ;
				
				if(request.getRequestType().getLabel().equalsIgnoreCase(requestType)){
					currentRequest = request   ;
					break ;
				}
			}
		}
		Map detailsConsumption = null ;
		if(individual instanceof Child){
			detailsConsumption = ecitizenDataCache.getConsumptionsByRequest(ecitizenDataCache.getCurrentUser(),
						(currentRequest !=null?currentRequest.getId():null),from,to) ;
		}else{
			
			detailsConsumption = ecitizenDataCache.getConsumptionsByRequest(individual.getLogin(),
					(currentRequest !=null?currentRequest.getId():null),from,to) ;
		}
		
		if("Résumé".equalsIgnoreCase(displayType)&&(!detailsConsumption.isEmpty())){
			
			int nbMorningNursery = 0 ;
			int nbEveningNursery = 0 ;
			int nbMorningAndEveningNursery = 0 ;
			
			for(Object req : detailsConsumption.entrySet()){
				
				if("EveningNursery".equals( ((Map.Entry)req).getValue() )){
					nbEveningNursery++ ;
				}
				if("MorningNursery".equals(((Map.Entry)req).getValue())){
					nbMorningNursery++ ;
					
				}
				if("MorningAndEveningNursery".equals(((Map.Entry)req).getValue())){
					nbMorningAndEveningNursery++ ;
				}
			}
			detailsConsumption.clear() ;
			detailsConsumption.put("nombre MorningNursery",nbMorningNursery);
			detailsConsumption.put("nombre EveningNursery",nbEveningNursery);
			detailsConsumption.put("nombre MorningAndEveningNursery",nbMorningAndEveningNursery) ;
			model.put("Résumer","yes") ;
		}
		
		model.put("detailsConsumption",detailsConsumption) ;
		model.put("displayType",displayType) ;
	}

	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
	
	
}
