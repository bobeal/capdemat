import fr.cg95.cvq.business.request.LocalReferentialEntry
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.business.request.RequestSeason
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.request.Requirement
import fr.cg95.cvq.business.request.RequestForm
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Version
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.util.Critere

import org.springframework.web.context.request.RequestContextHolder
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine

import java.io.File
import java.util.Collections

import grails.converters.JSON

class BackofficeRequestTypeController {

    IRequestTypeService requestTypeService
    IDocumentTypeService documentTypeService
    ICategoryService categoryService
    ILocalReferentialService localReferentialService
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry

    GroovyPagesTemplateEngine groovyPagesTemplateEngine
    
    def translationService
    def requestAdaptorService
    def RequestTypeAdaptorService
    
    def defaultAction = 'list'
    
    def beforeInterceptor = {
        session["currentMenu"] = "requests"
    }

    def afterInterceptor = { model ->
        model["subMenuEntries"] = BackofficeRequestController.subMenuEntries
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
            Set<Critere> criteriaSet = new HashSet<Critere>()
            if (categoryId != null) {
                Critere critere = new Critere()
                critere.attribut = RequestType.SEARCH_BY_CATEGORY_ID
                critere.value = categoryId
                criteriaSet.add(critere)
            }
            if (state != null) {
                Critere critere = new Critere()
                critere.attribut = RequestType.SEARCH_BY_STATE
                critere.value = state
                criteriaSet.add(critere)
            }
            requestTypes = 
                requestTypeService.getRequestTypes(criteriaSet)
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

    private getCommonModel(requestType) {
        def result = [
            "requestType" : requestType,
            "requestTypeLabel" :
                translationService.translateRequestTypeLabel(requestType.label).encodeAsHTML(),
            "requestTypes" : requestAdaptorService.translateAndSortRequestTypes()
        ]
        def requestService = requestServiceRegistry.getRequestService(requestType.label)
        result["configurationItems"] = [
            "forms" : ["requestType.configuration.forms", false],
            "delays" : ["requestType.configuration.delays", false],
            "documents" : ["requestType.configuration.documentType", false]
        ]
        if (requestTypeService.getRulesAcceptanceFieldNames(requestType.id).size() > 0) {
            result["configurationItems"]["rules"] = ["requestType.configuration.rules", false]
        }
        if (requestService.getLocalReferentialFilename() != null) {
            result["configurationItems"]["localReferential"] =
                ["requestType.configuration.localReferential", true]
        }
        if (requestService.isOfRegistrationKind()) {
            result["configurationItems"]["seasons"] = ["requestType.configuration.seasons", false]
        }
        if (requestType.label == 'Ticket Booking') {
            result["configurationItems"]["ticketBooking"] =
                ["requestType.configuration.ticketBooking", false]
        }
        return result
    }

    def forms = {
        def id = Long.valueOf(params.id)
        render(
            view : "configure",
            model : [
                "requestForms" :
                    requestTypeService.getRequestTypeForms(id, RequestFormType.REQUEST_MAIL_TEMPLATE)
            ].plus(getCommonModel(requestTypeService.getRequestTypeById(id))))
    }

    def delays = {
        def requestType = requestTypeService.getRequestTypeById(Long.valueOf(params.id))
        if (request.get) {
            render(
                view : "configure",
                model : [
                    "defaultConfig" : requestTypeService.globalRequestTypeConfiguration
                ].plus(getCommonModel(requestType))
            )
        } else if (request.post) {
            bind(requestType)
            requestTypeService.modifyRequestType(requestType)
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        }
    }

    def seasons = {
        render(view : "configure",
            model : getCommonModel(requestTypeService.getRequestTypeById(Long.valueOf(params.id))))
    }

    def loadSeasonsArea = {
        render(template : "listSeasons", model : ["seasons" : requestTypeService.getRequestTypeById(Long.valueOf(params.id)).seasons, "requestTypeId" : params.id])
    }

    def editSeason = {
        if (request.get) {
            def season
            if (params.id)
                season = requestTypeService.getRequestSeason(
                    Long.valueOf(params.requestTypeId), Long.valueOf(params.id))
            render(template : "editSeason", model : ["season" : season, "requestTypeId" : params.requestTypeId])
            return false
        } else if (request.post) {
            def season = new RequestSeason()
            bind(season)
            def codeString
            if (params.id == null || params.id.trim().isEmpty()) {
                requestTypeService.addRequestSeason(
                    Long.valueOf(params.requestTypeId), season)
                codeString = "message.creationDone"
            } else {
                requestTypeService.modifyRequestSeason(
                    Long.valueOf(params.requestTypeId), season)
                codeString = "message.updateDone"
            }
            render([status:"ok", success_msg:message(code : codeString)] as JSON)
            return false
        } else if (request.getMethod().toLowerCase() == "delete") {
            requestTypeService.removeRequestSeason(
                Long.valueOf(params.requestTypeId), Long.valueOf(params.id))
            render([status:"ok", success_msg:message(code:"message.deleteDone")] as JSON)
            return false
        }
    }

    def documents = {
        render(
            view : "configure",
            model: getCommonModel(requestTypeService.getRequestTypeById(Long.valueOf(params.id)))
        )
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
        def requestType = requestTypeService.getRequestTypeById(Long.parseLong(params.id))
        if (request.get) {
            def result = [:]
            result.active = requestType.active
            result.requestTypeId = params.id
            result.state = requestType.active ? 'active':'inactive'
            return result
        } 
        else if (request.post) {
            def requestService = requestServiceRegistry.getRequestService(requestType.label)
            if (requestService.getLocalReferentialFilename() != null
               && !localReferentialService.isLocalReferentialConfigured(requestType.label)
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
            def templates = localAuthorityRegistry
                .getLocalAuthorityResourceFileNames(Type.MAIL_TEMPLATES,
                ".*\\" + Type.MAIL_TEMPLATES.extension)
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
            def templates = localAuthorityRegistry
                .getLocalAuthorityResourceFileNames(Type.MAIL_TEMPLATES, "*")
            render (view: 'mailTemplate', model:['name':params.id,'templates':templates])
        }
    }
    
    def loadMailTemplate = {
        def fileName = params.file        
        File templateFile = localAuthorityRegistry
            .getLocalAuthorityResourceFile(Type.MAIL_TEMPLATES, fileName, false)
        
        if(templateFile.exists()) {
            response.contentType = 'text/html; charset=utf-8'
			
            def forms = [];
            forms.add(requestTypeService.getRequestFormById(Long.valueOf(params.formId)))

            def content = templateFile.text
            def template = groovyPagesTemplateEngine.createTemplate(content,'page1');

            def requestAttributes = RequestContextHolder.currentRequestAttributes()
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
        render(
            view : "configure",
            model : getCommonModel(requestTypeService.getRequestTypeById(Long.valueOf(params.id)))
        )
    }

    def localReferentialList = {
        render(
            template : "localReferentialList",
            model : [
                "lrTypes" : localReferentialService.getLocalReferentialDataByRequestType(
                    requestTypeService.getRequestTypeById(Long.valueOf(params.id)).label)
            ]
        )
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
            lre.labelsMap.fr = params.labelsMap.fr
            lre.messagesMap.fr = params.messagesMap.fr
            lre.key = null
            lrType.addEntry(lre, 
                params.parentEntryKey != params.dataName ? lrType.getEntryByKey(params.parentEntryKey) : null )
            isNew = true
        } else {
            lre = lrType.getEntryByKey(params.'entry.key')
            lre.labelsMap.fr = params.labelsMap.fr
            lre.messagesMap.fr = params.messagesMap.fr
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

    /* Rules related action
     * ------------------------------------------------------------------------------------------ */

    def rules = {
        render(
            view : "configure",
            model : getCommonModel(requestTypeService.getRequestTypeById(Long.valueOf(params.id)))
        )
    }

    def loadRules = {
        def requestType = requestTypeService.getRequestTypeById(Long.valueOf(params.id))
        def requestTypeLabelAsDir = CapdematUtils.requestTypeLabelAsDir(requestType.label)

        def rulesFieldNames = [:]
        requestTypeService.getRulesAcceptanceFieldNames(Long.valueOf(params.id))?.each {
            File ruleFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.PDF, requestTypeLabelAsDir + '/' + it, Version.CURRENT, false)
            rulesFieldNames[it] = ruleFile.exists()
        }

        render(template:"ruleList",
                model:['id': params.id,
                    'requestTypeAcronym': RequestTypeAdaptorService.generateAcronym(requestType.label),
                    'requestTypeLabelAsDir': requestTypeLabelAsDir,
                    'rulesFieldNames': rulesFieldNames ])
    }

    // TODO: Manage in LocalAuthorityRegistry the requestType ressource dir persistence
    def saveRule = {
        def requestType = requestTypeService.getRequestTypeById(Long.valueOf(params.requestTypeId))
        def requestTypeLabelAsDir = CapdematUtils.requestTypeLabelAsDir(requestType.label)
        def file = request.getFile('rulesFile')
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'requestType.message.noRulesFile')]).toString())
            return false
        }
        def rulesDir = new File (localAuthorityRegistry.getAssetsBase() + '/' + session.currentSiteName + '/' + Type.PDF.folder + '/' + requestTypeLabelAsDir)
        if (!rulesDir.exists()) rulesDir.mkdir()

        localAuthorityRegistry.saveLocalAuthorityResource(Type.PDF, 
            requestTypeLabelAsDir + '/' + params.rulesField, file.bytes)
        render (new JSON([ 'rand' : UUID.randomUUID().toString(),
                           'status':'success', 
                           'message':message(code:'message.updateDone')]).toString())

    }

    def ticketBooking = {
        render(
            view : "configure",
            model : getCommonModel(requestTypeService.getRequestTypeById(Long.valueOf(params.id)))
        )
    }
}
