import java.io.File;

import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.Requirement
import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IRequestService
import org.springframework.web.context.request.RequestContextHolder
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine

import grails.converters.JSON
import fr.cg95.cvq.business.request.RequestType

class RequestTypeController {

    IRequestService defaultRequestService
    IDocumentTypeService documentTypeService
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
        "alerts":["requestType.configuration.alerts", true],
        "documents":["requestType.configuration.documentType", true]
    ]
    
    def configure = {
    	def requestType = 
        	defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        def requestTypeLabel =
            translationService.getEncodedRequestTypeLabelTranslation(requestType.label)

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
        def requestType = defaultRequestService.getRequestTypeById(Long.valueOf(params.requestTypeId))
        if (params.instructionMaxDelay != '') {
            requestType.setInstructionMaxDelay(Integer.valueOf(params.instructionMaxDelay))
        }
        if (params.instructionAlertDelay != ''){
            requestType.setInstructionAlertDelay(Integer.valueOf(params.instructionAlertDelay))
        }
        defaultRequestService.modifyRequestType(requestType)

        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
        
    // called asynchronously
    // return a JSON array of all the request types
    def loadAllRequestTypes = {
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

    def documentList = {
        def list = []
        def reqs = []
        def requestType = defaultRequestService.getRequestTypeById(Long.valueOf(params.id))
        requestType.requirements.each { r -> reqs.add(r.documentType.id)}
        documentTypeService.getAllDocumentTypes().each{ d ->
            list.add([
                'documentId' : d.id,
                'name' : message(code:CapdematUtils.adaptDocumentTypeName(d.name)),
                'bound' : reqs.contains(d.id),
                'class' : reqs.contains(d.id) ? '' : 'notBelong'
            ])
        }
        list = list.sort{it.name}
        render(template:"documentList",model:["documents":list])
    }
    
    def associateDocument = {
        this.defaultRequestService.addRequestTypeRequirement(
            Long.valueOf(params.rtid),Long.valueOf(params.dtid)
        )
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def unassociateDocument = {
        this.defaultRequestService.removeRequestTypeRequirement(
            Long.valueOf(params.rtid),Long.valueOf(params.dtid)
        )
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    // retrives request form list using passed request type id
    def formList = {
        def id = Long.valueOf(params.id)
        def mailType = RequestFormType.REQUEST_MAIL_TEMPLATE
        def forms = defaultRequestService.getRequestTypeForms(id, mailType)
        render(template:"formList",model:["requestForms":forms])
    }
    
    def state = {
        if(request.get) {
            def result = [:]
            
            RequestType requestType = this.defaultRequestService.getRequestTypeById(Long.parseLong(params.id))
            result.active = requestType.active
            result.requestTypeId = params.id
            result.state = requestType.active ? 'active':'inactive'
            
            return result
        } else {
            RequestType requestType = this.defaultRequestService.getRequestTypeById(
                Long.parseLong(params.requestTypeId))
            requestType.active = params.requestState == 'active'
            this.defaultRequestService.modifyRequestType(requestType) 
            
            render ([
                'label': message(code: "property.${requestType.active ? 'active' : 'inactive'}"),
                'state': requestType.active ? 'enable' : 'disable',
                'success_msg':message(code:"message.updateDone"),
                'status':"ok"
            ] as JSON)
        }
    }
    
    def form = {
        def method = request.getMethod().toLowerCase(), id
        if(method == "post" && params?.requestTypeId) {
            RequestForm form = new RequestForm()
            if(params?.requestFormId) {
                form = defaultRequestService.getRequestFormById(Long.valueOf(params.requestFormId))
            }
            form.setType(RequestFormType.REQUEST_MAIL_TEMPLATE)
            form.setLabel(params.label)
            form.setTemplateName(params.templateName)
            form.setShortLabel(params.shortLabel)
            id = defaultRequestService.modifyRequestTypeForm(Long.valueOf(params.requestTypeId),form)
            
            render(['id':id,status:"ok",success_msg:message(code:"message.updateDone")] as JSON)
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
                
                defaultRequestService.modifyRequestTypeForm(Long.valueOf(params.requestTypeId),form)
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
        response.contentType = 'text/html; charset=utf-8'
        
        if(templateFile.exists()) {
            def forms = [];
            def content = templateFile.text
            forms.add(defaultRequestService.getRequestFormById(formId))
            
            def template = groovyPagesTemplateEngine.createTemplate(content,'page1');
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(['name':fileName,'forms':forms]).writeTo(out);
            requestAttributes.setOut(originalOut)
            
            render out.toString()
        } else { 
            render message(code:'message.templateDoesNotExist')
        }
    }
}


