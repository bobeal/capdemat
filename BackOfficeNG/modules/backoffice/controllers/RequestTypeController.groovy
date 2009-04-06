import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.business.request.RequestSeason
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.request.Requirement
import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.business.authority.LocalReferentialEntry
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.ILocalReferentialService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry

import org.springframework.web.context.request.RequestContextHolder
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine

import java.io.File
import java.util.Collections

import grails.converters.JSON

class RequestTypeController {

    IRequestTypeService requestTypeService
    IDocumentTypeService documentTypeService
    ICategoryService categoryService
    ILocalReferentialService localReferentialService
    IRequestServiceRegistry requestServiceRegistry

    GroovyPagesTemplateEngine groovyPagesTemplateEngine
    
    def translationService
    def requestAdaptorService
    
    def defaultAction = 'list'
    
    def beforeInterceptor = {
        session['currentMenu'] = 'requestType'
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
                requestTypeService.getRequestTypes(categoryId, state)
        } else {
        	requestTypes = requestTypeService.getAllRequestTypes()
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
        	requestTypeService.getRequestTypeById(Long.valueOf(params.id))
        def requestTypeLabel =
            translationService.getEncodedRequestTypeLabelTranslation(requestType.label)
        def requestService = requestServiceRegistry.getRequestService(requestType.label)
        if (requestService.getLocalReferentialFilename() != null)
            baseConfigurationItems["localReferential"] =
                ["requestType.configuration.localReferential", true]
        if (requestService.isOfRegistrationKind()) {
            baseConfigurationItems["seasons"] = ["requestType.configuration.seasons", true]
        }
        return ["requestType":requestType, "requestTypeLabel":requestTypeLabel,
                "baseConfigurationItems":baseConfigurationItems,
                "requestTypes":requestAdaptorService.translateAndSortRequestTypes()]
    }

    def loadAlertsArea = {
        def requestType = 
            requestTypeService.getRequestTypeById(Long.valueOf(params.id))
        def lacb = SecurityContext.getCurrentConfigurationBean()
        render(template:"alerts",
               model:['requestType':requestType,
                      'instructionDefaultMaxDelay':lacb.getInstructionDefaultMaxDelay(),
                      'instructionDefaultAlertDelay':lacb.getInstructionDefaultAlertDelay()])
    }

    def saveAlerts = {
        def requestType = requestTypeService.getRequestTypeById(Long.valueOf(params.requestTypeId))
        if (params.instructionMaxDelay != '') {
            requestType.setInstructionMaxDelay(Integer.valueOf(params.instructionMaxDelay))
        }
        if (params.instructionAlertDelay != ''){
            requestType.setInstructionAlertDelay(Integer.valueOf(params.instructionAlertDelay))
        }
        requestTypeService.modifyRequestType(requestType)

        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    def loadSeasonsArea = {
        render(template : "listSeasons", model : ["seasons" : requestTypeService.getRequestTypeById(Long.valueOf(params.id)).seasons, "requestTypeId" : params.id])
    }

    def editSeason = {
        def season
        if (request.get) {
            season = requestTypeService.getRequestTypeSeason(Long.valueOf(params.requestTypeId), params.uuid)
            render(template : "editSeason", model : ["season" : season, "requestTypeId" : params.requestTypeId])
            return false
        } else if (request.post) {
            def codeString
            season = new RequestSeason()
            bind(season)
            if (params.uuid == null || params.uuid.trim().isEmpty()) {
                requestTypeService.addRequestTypeSeason(Long.valueOf(params.requestTypeId), season)
                codeString = "message.creationDone"
            } else {
                requestTypeService.modifyRequestTypeSeason(Long.valueOf(params.requestTypeId), season)
                codeString = "message.updateDone"
            }
            render([status:"ok", success_msg:message(code : codeString)] as JSON)
            return false
        } else if (request.getMethod().toLowerCase() == "delete") {
            requestTypeService.removeRequestTypeSeason(Long.valueOf(params.requestTypeId), params.uuid)
            render([status:"ok", success_msg:message(code:"message.deleteDone")] as JSON)
            return false
        }
    }

    def documentList = {
        def list = []
        def reqs = []
        def requestType = requestTypeService.getRequestTypeById(Long.valueOf(params.id))
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
        requestTypeService.addRequestTypeRequirement(
            Long.valueOf(params.rtid),Long.valueOf(params.dtid)
        )
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def unassociateDocument = {
        requestTypeService.removeRequestTypeRequirement(
            Long.valueOf(params.rtid),Long.valueOf(params.dtid)
        )
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def state = {
        if(request.get) {
            def result = [:]

            RequestType requestType =
                requestTypeService.getRequestTypeById(Long.parseLong(params.id))
            result.active = requestType.active
            result.requestTypeId = params.id
            result.state = requestType.active ? 'active':'inactive'

            return result
        } else {
            RequestType requestType =
                requestTypeService.getRequestTypeById(Long.parseLong(params.requestTypeId))            
            if(!localReferentialService.isLocalReferentialConfigure(requestType.label)
               && !requestType.active) {
                render ([
                  'label': message(code: "property.${requestType.active ? 'active' : 'inactive'}"),
                  'state': requestType.active ? 'enable' : 'disable',
                  'message':message(code:"localReferential.error.isNotConfigure"),
                  'status':"warning"
                ] as JSON)
            }
            else {
                requestType.active = params.requestState == 'active'
                requestTypeService.modifyRequestType(requestType)
                render ([
                    'label': message(code: "property.${requestType.active ? 'active' : 'inactive'}"),
                    'state': requestType.active ? 'enable' : 'disable',
                    'message':message(code:"message.updateDone"),
                    'status':"success"
                ] as JSON)
            }
        }
    }

    // retrieves request form list using passed request type id
    def formList = {
        def id = Long.valueOf(params.id)
        def mailType = RequestFormType.REQUEST_MAIL_TEMPLATE
        def forms = requestTypeService.getRequestTypeForms(id, mailType)
        render(template:"formList",model:["requestForms":forms])
    }
    
    def form = {
        def method = request.getMethod().toLowerCase(), id
        if(method == "post" && params?.requestTypeId) {
            RequestForm form = new RequestForm()
            if(params.requestFormId) {
                form = requestTypeService.getRequestFormById(Long.valueOf(params.requestFormId))
            }
            form.setType(RequestFormType.REQUEST_MAIL_TEMPLATE)
            form.setLabel(params.label)
            form.setTemplateName(params.templateName)
            form.setShortLabel(params.shortLabel)
            id = requestTypeService.modifyRequestTypeForm(Long.valueOf(params.requestTypeId),form)
            
            render(['id':id,status:"ok",success_msg:message(code:"message.updateDone")] as JSON)
        } else if(method=="get") {
            def requestForm = null
            def templates = requestTypeService.getMailTemplates('.*[.]html$')
            if(params.id) 
                requestForm = requestTypeService
                    .getRequestFormById(Long.valueOf(params.id))
            render(template:"form",model:["requestForm":requestForm,
                                               "templates":templates])
        } else if(method=="delete") {
            requestTypeService.removeRequestTypeForm(Long.valueOf(params.id));
            render([status:"ok", success_msg:message(code:"message.deleteDone")] as JSON)
        }
    }
    
    def mailTemplate = {
        if(request.post) {
            if(params.editor != "") {
                RequestForm form = requestTypeService
                    .getRequestFormById(Long.valueOf(params.requestFormId))
                form.setType(RequestFormType.REQUEST_MAIL_TEMPLATE)
                form.setPersonalizedData(params.editor.getBytes())
                
                requestTypeService.modifyRequestTypeForm(Long.valueOf(params.requestTypeId),form)
                render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
            } else {
                throw new Exception("mail_templates.some_of_mandatory_fields_is_empty")
            }
        } 
        else {
            def templates = requestTypeService.getMailTemplates('.*[.]html$')
            render (view: 'mailTemplate', model:['name':params.id,'templates':templates])
        }
    }
    
    def loadMailTemplate = {
        def fileName = params.file
        def formId = Long.valueOf(params.formId)
        def typeId = Long.valueOf(params.typeId)
        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        
        File templateFile = requestTypeService.getTemplateByName(fileName)
        response.contentType = 'text/html; charset=utf-8'
        
        if(templateFile.exists()) {
            def forms = [];
            def content = templateFile.text
            forms.add(requestTypeService.getRequestFormById(formId))
            
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
    
    /* Local referential related action
     * ------------------------------------------------------------------------------------------ */
    def localReferential = {
        def rt = requestTypeService.getRequestTypeById(Long.valueOf(params.id))
        def lrTypes = localReferentialService.getLocalReferentialDataByRequestType(rt.label)
        render(template:"localReferential", model:['lrTypes':lrTypes])
    }
    
    def localReferentialType = {
        def lrType = localReferentialService.getLocalReferentialDataByName(params.dataName)
        render(template:"localReferentialEntries", 
               model:['lrEntries': lrType.entries, , 'parentEntry':lrType.dataName,
                       'isMultiple':lrType.entriesSupportMultiple, 'depth':0])
    }
    
    def localReferentialWidget = {
        def lrType = localReferentialService.getLocalReferentialDataByName(params.lrtDataName)
        bind(lrType)
        lrType.entries = Collections.emptySet();
        localReferentialService.setLocalReferentialData(lrType)
        render (['status':'success', 'message':message(code:"message.updateDone")] as JSON)
    }
    
    
    def localReferentialEntry = {
       def lrType = localReferentialService.getLocalReferentialDataByName(params.dataName)
       def lre          
       if (params.isNew != null) {
          lre = new LocalReferentialEntry()
          lre.key = params.parentEntryKey
       } else 
          lre = lrType.getEntryByKey(params.entryKey)
       
       render(template:"localReferentialEntryFrom", 
              model:['entry':lre,
                     'parentEntryKey':params.parentEntryKey,
                     'dataName':params.dataName,
                     'isNewSubEntry':params.isNew != null ? true : false])
    }
    
    def saveLocalReferentialEntry = {
        def lrType = localReferentialService.getLocalReferentialDataByName(params.dataName)
        def isNew = false
        def lre
        if (params.'entry.key' == params.parentEntryKey) {
            lre = new LocalReferentialEntry()
            lre.addLangage('fr')
            bind(lre)
            lre.key = null
            lrType.addEntry(lre, 
                params.parentEntryKey != params.dataName ? lrType.getEntryByKey(params.parentEntryKey) : null )
            isNew = true
        } else {
            lre = lrType.getEntryByKey(params.'entry.key')
            bind(lre)
        }
        localReferentialService.setLocalReferentialData(lrType)
        render (['isNew': isNew, 'entryLabel': lre.labelsMap.fr,
                 'status':'success', 'message':message(code:"message.updateDone")] as JSON)
    }
    
    def removeLocalReferentialEntry = {
        def lrType = localReferentialService.getLocalReferentialDataByName(params.dataName)
        def lre = lrType.getEntryByKey(params.entryKey)
        lrType.removeEntry(lre, 
              params.parentEntryKey != params.dataName ? lrType.getEntryByKey(params.parentEntryKey) : null )
        localReferentialService.setLocalReferentialData(lrType)
        render (['entryLabel': lre.labelsMap.fr,
                  'status':'success', 'message':message(code:"message.updateDone")] as JSON)
    }
    
}
