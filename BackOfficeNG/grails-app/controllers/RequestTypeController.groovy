import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.Requirement
import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.business.request.RequestSeason
import fr.cg95.cvq.exception.*

import grails.converters.JSON


class RequestTypeController {

    IRequestService defaultRequestService
    IRequestServiceRegistry requestServiceRegistry
    IDocumentService documentService
	ICategoryService categoryService
    def translationService
    
    def defaultAction = "list"
    
    def beforeInterceptor = {
        session["currentMenu"] = "requestType"
    }

    def list = {
        def requestTypes = defaultRequestService.getAllRequestTypes()            
        ["requestTypes":requestTypes, "categories":categoryService.getAll()]
    }

    // the configuration items all request types will have
    // the boolean indicates if it's a mandatory step
    def baseConfigurationItems = [
    	"general":["requestType.configuration.general", true] 
//        "documents":["requestType.configuration.documents", false]
    ]
    
    def configure = {
    	def requestType = 
        	defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        def requestTypeLabel =
            translationService.getEncodedRequestTypeLabelTranslation(requestType.label)
        def requestService = 
        	requestServiceRegistry.getRequestService(requestType.label)
        if (requestService.isOfRegistrationKind())
        	baseConfigurationItems.put("seasons",["requestType.configuration.seasons", true])
        if (requestService.getLocalReferentialFilename() != null)
        	baseConfigurationItems.put("localReferential",["requestType.configuration.localReferential", true])

        def requestTypeConfigurationData = new RequestTypeConfigurationData()
    	requestTypeConfigurationData.configurationItems = baseConfigurationItems
		requestTypeConfigurationData.requestType = requestType
		requestTypeConfigurationData.requestTypeLabel = requestTypeLabel
    	
		def requestTypesConfigurationInProgress = session.requestTypesConfigurationInProgress
		if (requestTypesConfigurationInProgress == null) {
		    requestTypesConfigurationInProgress = [:]
		    session.requestTypesConfigurationInProgress = requestTypesConfigurationInProgress
		}
    	requestTypesConfigurationInProgress.put(params.id, requestTypeConfigurationData)

        return ["requestType":requestType, "requestTypeLabel":requestTypeLabel,
                "baseConfigurationItems":baseConfigurationItems,
                "requestTypes":defaultRequestService.getAllRequestTypes()]
    }

    def loadGeneralArea = {
        def requestType = 
             defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        render(template:"general",model:['requestType':requestType])
    }
    
    def loadAlertsArea = {
            def requestType = 
                 defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
            def lacb = SecurityContext.getCurrentConfigurationBean()
            render(template:"alerts",model:['requestType':requestType,
                                            'instructionDefaultMaxDelay':lacb.getInstructionDefaultMaxDelay(),
                                            'instructionDefaultAlertDelay':lacb.getInstructionDefaultAlertDelay()])
    }

    def loadFormsArea = {
            def requestType = 
                 defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
            render(template:"forms",model:['requestType':requestType])
    }

    def loadSeasonsArea = {
            def requestType = 
                defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
            def listSeasons = requestType.getSeasons()
            render(template:"seasons",model:['requestType':requestType,"listSeasons":listSeasons])
    }

    def loadConfigurationSubmenu = {
        def requestType = 
            defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        if (params.submenu == "general") {
            def lacb = SecurityContext.getCurrentConfigurationBean()
            render(template:"general", 
                    model:['requestType':requestType,
                           'instructionDefaultMaxDelay':lacb.getInstructionDefaultMaxDelay(),
                           'instructionDefaultAlertDelay':lacb.getInstructionDefaultAlertDelay()])
        } else if (params.submenu == "documents"){
            render(template:"documents")
        } else if (params.submenu == "seasons"){
              def listSeasons = requestType.getSeasons()
              render(template:"seasons",model:['requestType':requestType,"listSeasons":listSeasons])
        }
    }
    
    def saveGeneral = {
        def requestType = 
            defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        if (params.active)
            requestType.setActive(true)
        else
            requestType.setActive(false)
        defaultRequestService.modifyRequestType(requestType)
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def saveAlerts = {
        def requestType = 
            defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        if (params.instructionMaxDelay != '')
            requestType.setInstructionMaxDelay(Integer.valueOf(params.instructionMaxDelay))
        if (params.instructionAlertDelay != '')
            requestType.setInstructionAlertDelay(Integer.valueOf(params.instructionAlertDelay))
        defaultRequestService.modifyRequestType(requestType)

        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
        
    def saveForms = {
        def requestForm = new RequestForm()
        requestForm.setName(params.name)
        requestForm.setXslFoFilename(params.xslFoFilename.originalFilename)
        defaultRequestService.addRequestTypeForm(Long.valueOf(params.id), requestForm,
                params.xslFoFilename.bytes)

        render([status:"ok", success_msg:message(code:"message.updateDone"),
                requestTypeId:params.id] as JSON)
    }
    
    def modifyDocumentAssociation = {
		def requestService = 
        	requestServiceRegistry.getRequestService(Long.valueOf(params.id))
        try {
  	    	if (params.operation == "add")
        		requestService.addRequestTypeRequirement(Long.valueOf(params.id), Long.valueOf(params.documentId))
        	else
        		requestService.removeRequestTypeRequirement(Long.valueOf(params.id), Long.valueOf(params.documentId))
        } catch (CvqException ce) {
			log.error "save() error while creating request type's documents"
		    render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
		    return            
        }
        	
		render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    // called asynchronously
    // return a JSON array of all the request types
    def loadAllRequestTypes = {
        log.debug "loadAllRequestTypes()"
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        render('builder': 'json') {
            // name has to be different from any object in the scope
            'result' {
                allRequestTypes.each {
                    // name 'myRequestType' has no importance as it won't be in the response
                    myRequestType(
                        'id':it.id,
                        'label':translationService.getEncodedRequestTypeLabelTranslation(it.label),
                        'category':it.category?.name,
                        'active':it.active
                    )
                }
            }
        }
    }
    
    def loadRequestTypeForms = {
        def requestType = 
            defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        def forms = requestType.forms
        render('builder': 'json') {
            // name has to be different from any object in the scope
            'result' {
                forms.each {
                    // name 'myForm' has no importance as it won't be in the response
                    myForm(
                        'name':it.name,
                        'filename':it.xslFoFilename
                    )
                }
            }            
        }
    }
    
    // called asynchronously
    // return a JSON array of all the document types
    def loadAllDocumentTypes = {
        log.debug "loadAllDocumentTypes()"
        def requestTypeDocuments = []
    	def requestType = 
    	    defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        requestType.requirements.each {
            requestTypeDocuments.add(it.documentType.id)
        }
        def allDocumentTypes = documentService.getAllDocumentTypes()
        render('builder': 'json') {
            // name has to be different from any object in the scope
            'result' {
                allDocumentTypes.each {
                    // name 'myDocumentType' has no importance as it won't be in the response
                    myDocumentType(
                        'id':it.id,
                        'name':it.name,
                        'selector':requestTypeDocuments.contains(it.id) ? 'true' : ''
                    )
                }
            }
        }
    }

    //called asynchronously
    //save a new season in the list 
    def saveSeasons = {
            
            def requestType = 
                defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
               
               def label = params.label
               def registrationEnd = DateUtils.stringToDate(params.registrationEnd)               
               def registrationStart = DateUtils.stringToDate(params.registrationStart)
               def effectStart = DateUtils.stringToDate(params.effectStart)
               def effectEnd =  DateUtils.stringToDate(params.effectEnd)
               def validationAuthorizationStart =
                DateUtils.stringToDate(params.validationAuthorizationStart)            
                
               def translationService
               
               def requestSeason = new RequestSeason()
                 
           		 requestSeason.setLabel(label)
           		 requestSeason.setRegistrationStart(registrationStart)
                 requestSeason.setRegistrationEnd(registrationEnd)
                 requestSeason.setEffectStart(effectStart)
           		 requestSeason.setEffectEnd(effectEnd)
           		 requestSeason.setValidationAuthorizationStart(validationAuthorizationStart)
               
           		 try{
               		 defaultRequestService.createRequestTypeSeasons(requestType,requestSeason)
                  } catch (CvqModelException cme) {
                      
          		      render ([status: "error", 
                                  error_msg: "Erreur :" + cme]
          		              as JSON)
                  	
                    return 
                  
                  }
           		 render([status:"ok",seasonUuid: requestSeason.uuid,
                  seasonLabel:requestSeason.label] as JSON)
                 
    }
   
	 // called asynchronously
     // return the template used to display a season in the seasons List
	
    def loadRequestTypeSeasonsList = {
        def requestType = defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        def listSeasons = requestType.getSeasons()  
        render(template:"seasons",model:['requestType':requestType,"listSeasons":listSeasons])
    }
 
    //called asynchronously
    //delete seasons from the seasons list
    def deleteSeasons = {
            def requestType = 
                defaultRequestService.getRequestTypeById(Long.valueOf(params.requestTypeId))
               
                def uuid = params.seasonUuid
                try{
                        defaultRequestService.removeRequestTypeSeasons(requestType,uuid)
                } catch (CvqModelException cme) { 
                    render ([status: "error", 
                             error_msg:message(code:"requestSeason.error.seasonNotFound")] as JSON)
                  return
                }
                render ([status:"ok",uuid:params.seasonUuid,
                                 success_msg:message(code:"requestSeason.message.confirmDelete")] as JSON)
    }
    
}

class RequestTypeConfigurationData {
    def configurationItems
    def requestType
    def requestTypeLabel
}



