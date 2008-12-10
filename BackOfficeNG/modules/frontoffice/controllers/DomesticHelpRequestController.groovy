
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

import fr.cg95.cvq.business.request.social.DomesticHelpRequest
import fr.cg95.cvq.service.request.social.IDomesticHelpRequestService
import fr.cg95.cvq.business.users.Address

class DomesticHelpRequestController {

    ILocalAuthorityRegistry localAuthorityRegistry

    DomesticHelpRequest dhr 
    IDomesticHelpRequestService domesticHelpRequestService
   
    def translationService
    
    def defaultAction = "edit"
    
    def currentTab = "tab1"
    
    def steps = ["subject", "familyReferent", "spouse", "dwelling", "resources", "taxes"]
    
    def edit = {
        if (dhr == null)
          dhr = new DomesticHelpRequest()
        
        dhr.setDhrGuardianAddress(new Address())
dhr.setDhrReferentAddress(new Address())
dhr.setDhrSpouseAddress(new Address())
dhr.setDhrCurrentDwellingAddress(new Address())

          
        session["domesticHelpRequest"] = dhr
        
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
        	model:[dhr:dhr, currentTab:currentTab,translationService:translationService,
        	       help:getHelp()])
    }
    
    
    def validSubject = {
    	log.debug("validSubject - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validFamilyReferent = {
    	log.debug("validFamilyReferent - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, , help:getHelp()])
    }
    
    def validSpouse = {
    	log.debug("validSpouse - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validDwelling = {
    	log.debug("validDwelling - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validResources = {
    	log.debug("validResources - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validTaxes = {
    	log.debug("validTaxes - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validDocumentRef = {
    	log.debug("validDocumentRef - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    def validValidationRef = {
    	log.debug("validValidationRef - START")
        
		dhr = session["domesticHelpRequest"]
		bind(dhr)
        currentTab = getCurrentTab(params)
          
		session["domesticHelpRequest"] = dhr
        render(view:"frontofficeRequestType/domesticHelpRequest/edit", 
                model:[dhr:dhr, currentTab:currentTab, translationService:translationService, help:getHelp()])
    }
    
    
    def getHelp = {
            
            def help = [:]
            steps.each {
                help[it] = localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelp("domesticHelpRequest",it)
            }

            return help
    }
    
    def getCurrentTab = { currentTab ->
	
		if (params.submitDhrSubject)
		   currentTab = "tab1"
	
		else if (params.submitDhrFamilyReferent)
		   currentTab = "tab2"
	
		else if (params.submitDhrSpouse)
		   currentTab = "tab3"
	
		else if (params.submitDhrDwelling)
		   currentTab = "tab4"
	
		else if (params.submitDhrResources)
		   currentTab = "tab5"
	
		else if (params.submitDhrTaxes)
		   currentTab = "tab6"
	
		else if (params.submitDhrDocumentRef)
		   currentTab = "tab7"
	
		else if (params.submitDhrValidationRef)
		   currentTab = "tab8"
	
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
    	render domesticHelpRequestService.invokeMethod("areConditionsFilled", args as Object[])
    }
    
}
