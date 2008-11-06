import java.io.File;

import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.Requirement
import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.business.request.RequestSeason
import org.springframework.web.context.request.RequestContextHolder
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import fr.cg95.cvq.exception.*

import grails.converters.JSON

class RequestTypeController {

    IRequestService defaultRequestService
    IRequestServiceRegistry requestServiceRegistry
    IDocumentService documentService
	ICategoryService categoryService
	GroovyPagesTemplateEngine groovyPagesTemplateEngine
	
    def translationService
    
    def defaultAction = "list"
    
    def beforeInterceptor = {
        session["currentMenu"] = "requestType"
    }

    def list = {
        def requestTypes = []
    		
        // deal with dynamic filters
        def parsedFilters = SearchUtils.parseFilters(params.filterBy)
        if (parsedFilters.filters.size() > 0) {
            def categoryId = 
            	parsedFilters.filters['categoryIdFilter'] == null ? null : Long.valueOf(parsedFilters.filters['categoryIdFilter'])
            def state = 
            	parsedFilters.filters['stateFilter'] == null ? null : Boolean.valueOf(parsedFilters.filters['stateFilter'])
            requestTypes = 
                defaultRequestService.getRequestsTypes(categoryId, state)
        } else {
        	requestTypes = defaultRequestService.getAllRequestTypes()
        }

        def adaptedRequestTypes = []
        requestTypes.each{ 
        	adaptedRequestTypes.add(CapdematUtils.adaptRequestType(translationService, it)) 
        }
        adaptedRequestTypes = adaptedRequestTypes.sort{ it.label.toLowerCase() }
        ["requestTypes":adaptedRequestTypes, "allCategories":categoryService.getAll(),
         	"filters":parsedFilters.filters,"filterBy":parsedFilters.filterBy]
    }

    // the configuration items all request types will have
    // the boolean indicates if it's a mandatory step
    def baseConfigurationItems = [
      "forms":["requestType.configuration.forms", true],
      "alerts":["requestType.configuration.alerts", true]]
                                  
    
    def configure = {
    	def requestType = 
        	defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        def requestTypeLabel =
            translationService.getEncodedRequestTypeLabelTranslation(requestType.label)
        def requestService = 
        	requestServiceRegistry.getRequestService(requestType.label)
        if (requestService.isOfRegistrationKind())
        	baseConfigurationItems.put("seasons",["requestType.configuration.seasons", true])
//        if (requestService.getLocalReferentialFilename() != null)
//        	baseConfigurationItems.put("localReferential",["requestType.configuration.localReferential", true])

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
           
            
             defaultRequestService.createRequestTypeSeasons(requestType,requestSeason)
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
                defaultRequestService.removeRequestTypeSeasons(requestType,uuid)
                render ([status:"ok",uuid:params.seasonUuid,
                                 success_msg:message(code:"requestSeason.message.confirmDelete")] as JSON)
    }
    
    
    // retrives request form list using passed request type id
    def formList = {
        def id = Long.valueOf(params.id)
        def mailType = RequestFormType.REQUEST_MAIL_TEMPLATE
        def forms = defaultRequestService.getRequestTypeForms(id, mailType)
        render(template:"formList",model:["requestForms":forms])
    }
    
    def form = {
        def method = request.getMethod().toLowerCase()
        if(method == "post" && params?.requestTypeId) {
            RequestForm form = new RequestForm()
            if(params?.requestFormId) {
                form = defaultRequestService.getRequestFormById(Long.valueOf(params.requestFormId))
            }
            form.setType(RequestFormType.REQUEST_MAIL_TEMPLATE)
            form.setLabel(params.label)
            form.setTemplateName(params.templateName)
            form.setShortLabel(params.shortLabel)
            defaultRequestService.processRequestTypeForm(Long.valueOf(params.requestTypeId),form)
            
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else if(method=="get") {
            def requestForm = null
            def templates = defaultRequestService.getMailTemplates('.*[.]html$')
            if(params.id) 
                requestForm = defaultRequestService
                    .getRequestFormById(Long.valueOf(params.id))
            render(template:"form",model:["requestForm":requestForm,
                                               "templates":templates])
        } else if(method=="delete") {
            defaultRequestService.removeRequestTypeForm(Long.valueOf(params.id));
            render([status:"ok", success_msg:message(code:"message.deleteDone")] as JSON)
        }
    }
    
    
    def mailTemplate = {
        if(request.post) {
            if(params?.editor != "") {
                RequestForm form = defaultRequestService
                    .getRequestFormById(Long.valueOf(params?.requestFormId))
                form.setType(RequestFormType.REQUEST_MAIL_TEMPLATE)
                form.setPersonalizedData(params.editor.getBytes())
                
                defaultRequestService.processRequestTypeForm(Long.valueOf(params.requestTypeId),form)
                render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
            } else {
                throw new Exception("mail_templates.some_of_mandatory_fields_is_empty")
            }
        } 
        else {
            def templates = defaultRequestService.getMailTemplates('.*[.]html$')
            render (view: 'mailTemplate', model:['name':params.id,'templates':templates])
        }
    }
    
    def loadMailTemplate = {
        def fileName = params?.file
        def formId = Long.valueOf(params?.formId)
        def typeId = Long.valueOf(params?.typeId)
        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        
        File templateFile = defaultRequestService.getTemplateByName(fileName)
        if(templateFile.exists()) {
            def forms = [];
            forms.add(defaultRequestService.getRequestFormById(formId))
            
            def template = groovyPagesTemplateEngine.createTemplate(templateFile);
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(['name':fileName,'forms':forms]).writeTo(out);
            requestAttributes.setOut(originalOut)
            
            response.contentType = 'text/html; charset=utf-8'
            render out.toString()
        }
        
        //render(template:"tmp",model:['name':params.id])
    }
}

class RequestTypeConfigurationData {
    def configurationItems
    def requestType
    def requestTypeLabel
}



