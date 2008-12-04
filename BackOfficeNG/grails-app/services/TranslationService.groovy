import fr.cg95.cvq.util.localization.ILocalizationService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.business.request.Request

class TranslationService {
    
    ILocalizationService localizationService
    IRequestServiceRegistry requestServiceRegistry

    def requestTypesCache = [:]

        
    // this is quite ugly for the moment, improve this in the CapDemat model 
    // see FIXME in fr.cg95.cvq.util.localization.ILocalizationService
    def getEncodedRequestTypeLabelTranslation(Request inRequest) {
        def requestTypeId = inRequest.requestType.id
        
        if (requestTypesCache.get(String.valueOf(requestTypeId)) == null) {
          
            def tempRequestService = requestServiceRegistry.getRequestService(inRequest)
            def request = tempRequestService.getSkeletonRequest()
            requestTypesCache[String.valueOf(requestTypeId)] = 
                localizationService.getRequestLabelTranslation(request.class.name,"fr",false).encodeAsHTML()
        }

        return requestTypesCache[String.valueOf(requestTypeId)]
    }

    // this is quite ugly for the moment, improve this in the CapDemat model 
    // see FIXME in fr.cg95.cvq.util.localization.ILocalizationService
    def getEncodedRequestTypeLabelTranslation(String label) {
        def tempRequestService = requestServiceRegistry.getRequestService(label)
        def request = tempRequestService.getSkeletonRequest()
        return localizationService.getRequestLabelTranslation(request.class.name,"fr",false).encodeAsHTML()
    }
    
    // ADDED METHODS
    def getLabelTranslation = { className, elementName, lang ->
    	if (className != null)
			return localizationService.getElementTranslation(className, elementName, lang)
    }
    
    def getRequestLabelTranslation = { requestTypeName, lang, fullDesc ->
    	return localizationService.getRequestLabelTranslation(requestTypeName, lang, fullDesc)
    }
    
    def getEnumsDataMap = { namespace, elementTypeName, lang ->
    	return localizationService.getEnumsDataMap(namespace, elementTypeName, lang)
    }
       
    def getElementDesc = { requestNamespace, elementTypeName, elementName, lang, fullDesc ->
    	return localizationService.getElementDesc(requestNamespace, elementTypeName, elementName, lang, fullDesc)
	}
    
    def getGlobalElementDesc = { className, elementName, lang, fullDesc ->
    	return localizationService.getGlobalElementDesc(className, elementName, lang, fullDesc)
    }
}
