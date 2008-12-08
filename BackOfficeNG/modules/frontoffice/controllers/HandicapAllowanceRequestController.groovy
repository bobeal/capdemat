

import fr.cg95.cvq.business.request.social.HandicapAllowanceRequest
import fr.cg95.cvq.service.request.social.IHandicapAllowanceRequestService
import fr.cg95.cvq.business.users.Address

class HandicapAllowanceRequestController {

    HandicapAllowanceRequest har 
    IHandicapAllowanceRequestService handicapAllowanceRequestService
   
    def translationService
    
    def defaultAction = "edit"
    
    def currentTab = "tab1"
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
    
    def edit = {
        if (har == null)
          har = new HandicapAllowanceRequest()
        
        
          
        session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", 
        	model:[har:har, currentTab:currentTab,translationService:translationService])
    }
    
    
    def validSubject = {
    	log.debug("validSubject - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validDwelling = {
    	log.debug("validDwelling - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validSocialSecurity = {
    	log.debug("validSocialSecurity - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validPosition = {
    	log.debug("validPosition - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validHandicapKind = {
    	log.debug("validHandicapKind - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validFollowup = {
    	log.debug("validFollowup - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validProject = {
    	log.debug("validProject - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validDocumentRef = {
    	log.debug("validDocumentRef - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    def validValidationRef = {
    	log.debug("validValidationRef - START")
        
		har = session["handicapAllowanceRequest"]
		bind(har)
        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"frontofficeRequestType/handicapAllowanceRequest/edit", model:[har:har, currentTab:currentTab, translationService:translationService])
    }
    
    
    
    def getCurrentTab = { currentTab ->
	
		if (params.submitHarSubject)
		   currentTab = "tab1"
	
		else if (params.submitHarDwelling)
		   currentTab = "tab2"
	
		else if (params.submitHarSocialSecurity)
		   currentTab = "tab3"
	
		else if (params.submitHarPosition)
		   currentTab = "tab4"
	
		else if (params.submitHarHandicapKind)
		   currentTab = "tab5"
	
		else if (params.submitHarFollowup)
		   currentTab = "tab6"
	
		else if (params.submitHarProject)
		   currentTab = "tab7"
	
		else if (params.submitHarDocumentRef)
		   currentTab = "tab8"
	
		else if (params.submitHarValidationRef)
		   currentTab = "tab9"
	
		return currentTab
    } 
    
    def checkConditions = {
    	log.debug("checkConditions - START")
    	def conditions = new HashMap();
    	params.each {
    		if (it.key.contains("cn_")) {
    			conditions.put(it.value, new HashMap())
    		}	
    	}
    	params.each {
    	  def currentParam = it
    	  conditions.each {
    	    if (currentParam.key.contains(it.key) && !currentParam.key.contains("cn_")) {
    	      def triggerName = currentParam.key.substring(currentParam.key.indexOf("_") + 1, currentParam.key.length())
    	      conditions.get(it.key).put(triggerName, currentParam.value)
    	    }
    	  }
    	}
    	def args = [conditions]
    	render handicapAllowanceRequestService.invokeMethod("areConditionsFilled", args as Object[])
    }
    
}
