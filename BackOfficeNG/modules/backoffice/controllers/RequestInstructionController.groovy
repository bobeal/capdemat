import fr.cg95.cvq.business.external.ExternalServiceTrace
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.request.DataState
import fr.cg95.cvq.business.request.RequestAction
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.external.IExternalService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.authority.IRecreationCenterService
import fr.cg95.cvq.service.authority.ISchoolService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.IConditionService
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestNoteService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.IRequestExternalService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.util.mail.IMailService

import grails.converters.JSON

import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestInstructionController {

    GroovyPagesTemplateEngine groovyPagesTemplateEngine

    IRequestActionService requestActionService
    IRequestLockService requestLockService
    IRequestSearchService requestSearchService
    IRequestDocumentService requestDocumentService
    IRequestNoteService requestNoteService
    IRequestTypeService requestTypeService
    IRequestWorkflowService requestWorkflowService
    IHomeFolderService homeFolderService
    IIndividualService individualService
    IDocumentService documentService
    IMeansOfContactService meansOfContactService
    IAgentService agentService
    IMailService mailService
    ICategoryService categoryService
    ILocalReferentialService localReferentialService 
    IRecreationCenterService recreationCenterService
    ISchoolService schoolService
    IRequestExternalService requestExternalService
    IExternalService externalService
    IConditionService conditionService

    def translationService
    def instructionService
    def documentAdaptorService
    def homeFolderAdaptorService
    def requestAdaptorService
    def defaultAction = "edit"

    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }

    def edit = {
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.id))
        def requester = rqt.requesterId != null ? individualService.getById(rqt.requesterId) : null
        def documentList = []
        def providedDocumentTypes = []
        def requestDocuments = requestDocumentService.getAssociatedDocuments(Long.valueOf(params.id))
    
        requestDocuments.each {
            def document = documentService.getById(it.documentId)
            providedDocumentTypes.add(document.documentType.id)
            documentList.add([
                "id": document.id,
                "documentTypeId" : document.documentType.id,
                "name": message(code: CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
                "endValidityDate": document.endValidityDate,
                "pageNumber": document.datas.size(),
                "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state")
            ])
        }

        // manage allowed and associated documents to a request
        def isDocumentProvided
        requestTypeService.getAllowedDocuments(rqt.requestType.id).each { documentTypeIt ->
            isDocumentProvided = 
                providedDocumentTypes.contains(documentTypeIt.id) ? true : false
            if (!isDocumentProvided)
                documentList.add([
                    "id": 0,
                    "documentTypeId" : documentTypeIt.id,
                    "name": message(code: CapdematUtils.adaptDocumentTypeName(documentTypeIt.name)),
                    "state": ["cssClass": "tag-not_provided", "i18nKey": "document.state.notProvided"]
                ])
        }
        
        // just for VoCardRequest and HomeFolderModificationRequest
        def adults = []
        def children = []
        def clr = [:]
        if (requestTypeService.isAccountRequest(rqt.id)) {
            def individuals = homeFolderService.getIndividuals(rqt.homeFolderId)
            individuals.eachWithIndex { individual, index ->
                def item = ['data':individual, 'index':index]
                if (individual.class.simpleName == "Adult") adults.add(item)
                else if (individual.class.simpleName == "Child") children.add(item)
            }
            children.each {
                def child = it.data
                clr.put(child.id, homeFolderService.getBySubjectRoles(child.id,
                        [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]))
            }
        }
        def editableStates = []
        for(RequestState state : requestWorkflowService.getEditableStates())
            editableStates.add(state.toString())
        
        def localReferentialTypes =
            getLocalReferentialTypes(localReferentialService, rqt.requestType.label)
        localReferentialTypes.each { lazyInit(rqt, it.key) }

        def externalProviderServiceLabel = null
        def externalTemplateName = null
        def lastTraceStatus = null
        if (requestExternalService.hasMatchingExternalService(rqt.requestType.label)) {
            externalProviderServiceLabel = requestExternalService
                .getExternalServiceByRequestType(rqt.requestType.label).label
            externalTemplateName = ["/backofficeRequestInstruction/external",
                externalProviderServiceLabel, "_block"].join('/')
            def externalTemplate = groovyPagesTemplateEngine
                .getResourceForUri(externalTemplateName)
            if (!externalTemplate || !externalTemplate.file
                || !externalTemplate.exists())
                externalTemplateName = null
            else
                externalTemplateName = ["/backofficeRequestInstruction/external",
                    externalProviderServiceLabel, "block"].join('/')
            def criteriaSet = new HashSet<Critere>(2)
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                String.valueOf(rqt.id), Critere.EQUALS))
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
                externalProviderServiceLabel, Critere.EQUALS))
            def traces = externalService.getTraces(criteriaSet,
                ExternalServiceTrace.SEARCH_BY_DATE, "desc")
            if (!traces.isEmpty()) {
                lastTraceStatus = CapdematUtils
                    .adaptCapdematEnum(traces.get(0).status, "externalservice.trace.status")
            }
        }

        def criteriaSet = new HashSet<Critere>(2)
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_REQUEST_ID,
            rqt.id, Critere.EQUALS))
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_TYPE,
            RequestActionType.STATE_CHANGE, Critere.EQUALS))
        def actions = requestActionService.get(criteriaSet,
            RequestAction.SEARCH_BY_DATE, "desc", 1, 0)
        def lastActionNote = !actions.isEmpty() ? actions.get(0).note : ""

        return ([
            "rqt": rqt,
            "requestTypeLabel": rqt.requestType.label,
            "lrTypes": localReferentialTypes,
            "adults": adults,
            "children": children,
            "requester": requester,
            'hasHomeFolder': !homeFolderService.getById(rqt.homeFolderId).boundToRequest,
            "childrenLegalResponsibles": clr,
            "editableStates": (editableStates as JSON).toString(),
            "agentCanWrite": categoryService.hasWriteProfileOnCategory(SecurityContext.currentAgent, 
                rqt.requestType.category.id),
            "requestState": CapdematUtils.adaptCapdematEnum(rqt.state, "request.state"),
            "lastActionNote" : lastActionNote,
            "requestDataState": CapdematUtils.adaptCapdematEnum(rqt.dataState, "request.dataState"),
            "requestLabel": translationService.translateRequestTypeLabel(rqt.requestType.label).encodeAsHTML(),
            "requestTypeTemplate": CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label),
            "documentList": documentList,
            "externalProviderServiceLabel" : externalProviderServiceLabel,
            "externalTemplateName" : externalTemplateName,
            "lastTraceStatus" : lastTraceStatus
        ])
    }
    
    // TODO - Mutualize with FrontOffice
    def getLocalReferentialTypes(localReferentialService, requestTypeLabel) {
        def result = [:]
        try {
            localReferentialService.getLocalReferentialDataByRequestType(requestTypeLabel).each{
                result.put(StringUtils.firstCase(it.dataName,'Lower'), it)
            }
        } catch (CvqException ce) { /* No localReferentialData found ! */ }
        return result
    }
    
    // FIXME - Modify lazy initialization policy in JavaBean ?
    def lazyInit(rqt, listName) {
        if (rqt[listName] == null || rqt[listName].size() == 0) return false
        rqt[listName].get(0)
    }
    
    def localReferentialData = {
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.requestId))
        def lrTypes = getLocalReferentialTypes(localReferentialService, rqt.requestType.label)
        render( template: '/backofficeRequestInstruction/widget/localReferentialDataStatic',
                model: ['rqt':rqt,
                        'javaName':params.javaName, 
                        'lrEntries':lrTypes[params.javaName]?.entries,
                        'isMultiple':lrTypes[params.javaName]?.entriesSupportMultiple,
                        'depth':0 ])
    }

    /* request data inline edition managment
    * --------------------------------------------------------------------- */

    def widget = {
        def widgets = ['date','address','capdematEnum','boolean','textarea','localReferentialData','school','recreationCenter']
        
        def propertyTypes = JSON.parse(params.propertyType)
        def propertyType = propertyTypes.validate
        def widget = widgets.contains(propertyType) ?  propertyType : "string"
        if (propertyType == "acceptance") {
            widget = "boolean"
        }

        def model = ["requestId": Long.valueOf(params.id),
                     // the "fully qualifier" property name
                     "propertyName": params.propertyName,
                     "propertyType": propertyType,
                     "required" : propertyTypes.required ? "required" : ""]
        
        // value init (by type)
        def propertyValue
        if (propertyType == "address") {
            propertyValue = JSON.parse(params.propertyValue)
        } 
        else if (propertyType == "capdematEnum") {
            def propertyJavaType = propertyTypes.javatype.tokenize(".")
            def allPropertyValue = Class.forName(propertyTypes.javatype)
                    .getField("all" + propertyJavaType[propertyJavaType.size() -1] + "s").get()
            model["allPropertyValue"] = allPropertyValue
            
            // FIXME - normalize propertyValue class like class="value<MY_VAL> i18n-<MY_I18n>)"
            def propertyValueTokens = params.propertyValue.tokenize(" ")
            if (propertyValueTokens.size() == 1)
                propertyValueTokens = ['',propertyValueTokens[0]]
                
            propertyValue = [ "enumString": propertyValueTokens[0],
                              "i18nKeyPrefix": propertyValueTokens[1] ]
            // will contain the fully qualified class name of the "CapDemat enum" class
            model["propertyValueType"] = propertyTypes.javatype
        }
        else if (propertyType == "localReferentialData") {
            def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.id))
            def lrTypes = getLocalReferentialTypes(localReferentialService, rqt.requestType.label)
            model['lrType'] = lrTypes[params.propertyName]
            model['lrDatas'] = rqt[params.propertyName].collect { it.name }
            flash[params.propertyName + 'Index'] = 0
            model["htmlClass"] =
                (model["lrType"].entriesSupportMultiple ? "validate-localReferentialData " :
                    (model["required"] != "" ? "validate-not-first " : "")) +
                model["required"]
        }
        else if (propertyType == "school") {
            model.schools = schoolService.getAll()
            if (params.propertyValue != "null") {
                propertyValue = Long.valueOf(params.propertyValue)
            }
        }
        else if (propertyType == "recreationCenter") {
            model.recreationCenters = recreationCenterService.getAll()
            if (params.propertyValue != "null") {
                propertyValue = Long.valueOf(params.propertyValue)
            }
        }
        else {
            propertyValue = params.propertyValue
            model["minLength"] = propertyTypes.minLength
            model["maxLength"] = propertyTypes.maxLength
            model["i18nKeyPrefix"] = propertyTypes.i18n
            model["regex"] = params.propertyRegex
            if (params.propertyRegex != "") model["propertyType"] = "regex"
            if (propertyType == "textarea") model["rows"] = propertyTypes.rows
        }
        model["propertyValue"] = propertyValue
        render( template: "/backofficeRequestInstruction/widget/" + widget, model:model)
    }
    
    def modify = {
        if (params.requestId == null)
             return false
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.requestId))
        if (["VO Card", "Home Folder Modification"].contains(rqt.requestType.label)) {
            def homeFolder = homeFolderService.getById(rqt.homeFolderId)
            DataBindingUtils.initBind(homeFolder, params)
            bind(homeFolder)
        } else if (params.keySet().contains('_requester')) {
            def requester = individualService.getById(rqt.requesterId)
            bindRequester(requester, params)
        } else if (params.keySet().contains('schoolId')) {
            rqt.school = schoolService.getById(Long.valueOf(params.schoolId))
        } else if (params.keySet().contains('recreationCenterId')) {
            rqt.recreationCenter = recreationCenterService.getById(Long.valueOf(params.recreationCenterId))
        } else {
            DataBindingUtils.initBind(rqt, params)
            bind(rqt)
        }
//        log.debug("Binder custum editor PersistentStringEnum = " + getBinder(rqt).propertyEditorRegistry.findCustomEditor(fr.cg95.cvq.dao.hibernate.PersistentStringEnum.class, null))
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def bindRequester(requester, params) {
        params.each { param ->
            if (param.value.getClass() == GrailsParameterMap.class && param.key == '_requester') {
                DataBindingUtils.initBind(requester, param.value)
                bindParam (requester, param.value)
            }
        }
    }
    
    def modifyList = {
        if (params.requestId == null || params.listAction == null )
             return
        
        def cRequest = requestLockService.getAndTryToLock(Long.valueOf(params.requestId))
        def actionTokens = params.listAction.tokenize('_')

        def listElemTokens = actionTokens[1].tokenize('[]')
        def getterMethod =
            cRequest.class.getMethod('get' + StringUtils.firstCase(listElemTokens[0], 'Upper'))
        
        if (actionTokens[0] == 'delete') {                   
            getterMethod.invoke(cRequest, null).remove(Integer.valueOf(listElemTokens[1]).intValue())
        }
        else if (actionTokens[0] == 'add') {
            def listElemType = getterMethod.genericReturnType.actualTypeArguments[0]
            def listElem = listElemType.getConstructor(null).newInstance(null)
            getterMethod.invoke(cRequest, null).add(listElem)
        }
        render (template:'/backofficeRequestInstruction/requestType/'
                          + CapdematUtils.requestTypeLabelAsDir(cRequest.requestType.label) 
                          +'/' + listElemTokens[0]
               ,model: ['rqt': cRequest])
    }

    def condition = {
        
        def result = []
        
        if (params.requestTypeLabel == null)
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
        
        try {
            for(Map entry : (JSON.parse(params.conditionsContainer) as List)) {
                result.add([
                    success_msg: message(code:'message.conditionTested'),
                    test: conditionService.isConditionFilled(params.requestTypeLabel, entry),
                    status: 'ok'
                ])
            }
            render(result as JSON)
        } catch (CvqException ce) {
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
        }
    }

    /* request state workflow managment
    * --------------------------------------------------------------------- */

    def stateTransitions = {
        def stateAsString = StringUtils.toPascalCase(params.stateCssClass.replace("tag-", ""))
        def stateType = params.stateType

        def transitionStates = []
        def stateTypeI18nKey
        switch (stateType) {
            case "requestDataState":
                transitionStates =
                    requestWorkflowService.getPossibleTransitions(DataState.forString(stateAsString))
                stateTypeI18nKey = "request.dataState"
                break
            case "documentState":
                transitionStates =
                    documentService.getPossibleTransitions(DocumentState.forString(stateAsString))
                stateTypeI18nKey = "document.state"
                break
            case "requestState":
                transitionStates =
                    requestWorkflowService.getPossibleTransitions(RequestState.forString(stateAsString))
                 stateTypeI18nKey = "request.state"
                 break
        }

        def states = []
        transitionStates.each { states.add(CapdematUtils.adaptCapdematEnum(it, stateTypeI18nKey)) }

        render( template: "possibleTransitionStates",
                model: ["states": states, "stateType": stateType, "id": params.id])
    }

    def changeState = {
        if (params.stateType == null || params.newState == null || params.id == null )
             return

        switch (params.stateType) {
            case "requestDataState":
                requestWorkflowService.updateRequestDataState(
                        Long.valueOf(params.id), DataState.forString(params.newState))
                break
            case "documentState":
                documentService.updateDocumentState(
                        Long.valueOf(params.id),
                        DocumentState.forString(params.newState),
                        null, null)
                break
            case "requestState":
                requestWorkflowService.updateRequestState(
                        Long.valueOf(params.id),
                        RequestState.forString(params.newState),
                        null)
               break
        }
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    def removeDocument = {
        if (request.getMethod().toLowerCase() == "delete") {
            requestDocumentService.removeDocument(
                requestLockService.getAndTryToLock(Long.valueOf(params.requestId)),
                Long.valueOf(params.documentId))
            render ([status:"ok",
                success_msg:message(code:"message.deleteDone")] as JSON)
        }
    }

    /*  request information  managment
    * --------------------------------------------------------------------- */

    def help = {
    		render(template:'help')
    }
    
    // FIXME : copy-paste from frontOfficeHomeFolderController. mutualize if possible
    def homeFolder = {
        def result = ['adults':[], 'children': [], homeFolder: []]
        def cRequest = requestLockService.getAndTryToLock(Long.valueOf(params.id))
        def homeFolder = homeFolderService.getById(cRequest.homeFolderId)
        homeFolderService.getAdults(homeFolder.id).each { adult ->
            result.adults.add([
                'id' : adult.id,
                'title' : message('code':"homeFolder.adult.title.${adult.title.toString().toLowerCase()}"),
                'fullName' : "${adult.firstName} ${adult.lastName}",
                'email' : adult.email,
                'homePhone' : adult.homePhone,
                'mobilePhone' : adult.mobilePhone,
                'birthDate' : adult.birthDate,
                'birthCountry' : adult.birthCountry,
                'birthPostalCode' : adult.birthPostalCode,
                'birthCity' : adult.birthCity,
                'ownerRoles' : homeFolderAdaptorService.prepareOwnerRoles(adult)
            ])
        }
        homeFolderService.getChildren(homeFolder.id).each{ child ->
            result.children.add([
                'id' : child.id,
                'sex' : child.sex,
                'fullName' : "${child.firstName} ${child.lastName}",
                'birthDate' : child.birthDate,
                'birthCountry' : child.birthCountry,
                'birthPostalCode' : child.birthPostalCode,
                'birthCity' : child.birthCity,
                'childSubjectRoles' : homeFolderAdaptorService.prepareChildSubjectRoles(child)
            ])
        }
        
        result.info = [
            'id' : homeFolder.id,
            'boundToRequest': homeFolder.boundToRequest,
            'state' : homeFolder.state,
            'enabled' : homeFolder.enabled,
            'addressDetails' :   "${homeFolder.adress.streetNumber} "+
                                 "${homeFolder.adress.streetName} " +
                                 "${homeFolder.adress.postalCode} " +
                                 "${homeFolder.adress.city}"
        ]
    		render(template:'homeFolderData', model:['homeFolder':result])
    }

    def homeFolderRequests = {
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.id))
        def homeFolderRequests = requestSearchService.getByHomeFolderId(rqt.homeFolderId);

        def records = []
        homeFolderRequests.each {
            def record = requestAdaptorService.prepareRecordForSummaryView(it)
            records.add(record)
        }
        render(template:'homeFolderRequests', model: ['records': records])
    }

    def requestActions = {
        def criteriaSet = new HashSet<Critere>(2)
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_REQUEST_ID,
            Long.valueOf(params.id), Critere.EQUALS))
        criteriaSet.add(new Critere(RequestAction.SEARCH_BY_RESULTING_STATE,
            RequestState.DRAFT, Critere.NEQUALS))
        def requestActions = requestActionService.get(criteriaSet,
            RequestAction.SEARCH_BY_DATE, "asc", 0, 0)
        def requestActionList = []
        requestActions.each {
            def user = instructionService.getActionPosterDetails(it.agentId)
            def resultingState = null
            if (it.type.equals(RequestActionType.STATE_CHANGE)) {
                resultingState = CapdematUtils.adaptCapdematEnum(it.resultingState, "request.state")
            }
            def requestAction = [
                'id':it.id,
                'agent_name':user,
                "type" : CapdematUtils.adaptCapdematEnum(it.type, "requestAction.type"),
                'note':it.note,
                "message" : it.message,
                'date':it.date,
                'resulting_state':resultingState,
                "hasFile" : it.file != null,
                "fileName" :
                    [RequestActionType.CREATION, RequestActionType.STATE_CHANGE]
                        .contains(it.type) ?
                        "requestAction.property.requestCertificate" : "requestAction.property.file"
            ]
            requestActionList.add(requestAction)
        }
        render(template:'requestHistory', model: ['requestActionList':requestActionList])
    }

    def requestNotes = {
        render(template : 'requestNotes',
               model : ['requestNoteList' : requestAdaptorService.prepareNotes(
                            requestNoteService.getNotes(Long.valueOf(params.id),
                            RequestNoteType.forString(params.type))),
                        'requestNoteTypes' : RequestNoteType.allRequestNoteTypes.collect{
                            CapdematUtils.adaptCapdematEnum(it, "request.note.type")},
                        'currentType' : params.type, 'requestId' : params.id])
    }

    def requestNote = {
        if (params.requestId != null && params.note != null && params.requestNoteType != null) {
            requestNoteService.addNote(
                Long.valueOf(params.requestId),
                RequestNoteType.forString(params.requestNoteType), params.note)
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else
            render ([status: "error", error_msg:message(code:"error.missingParmeter")] as JSON)
        
    }

    def external = {
        if (request.post) {
            requestExternalService.sendRequest(requestLockService.getAndTryToLock(Long.valueOf(params.id)))
            def criteriaSet = new HashSet<Critere>(2)
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                params.id, Critere.EQUALS))
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
                params.label, Critere.EQUALS))
            def lastTraceStatus = CapdematUtils.adaptCapdematEnum(
                externalService.getTraces(criteriaSet,
                ExternalServiceTrace.SEARCH_BY_DATE, "desc").get(0).status, "externalservice.trace.status")
            render(template : "/backofficeRequestInstruction/external/" + params.label + "/externalStatus",
                   model : ["externalProviderServiceLabel" : params.label,
                            "lastTraceStatus" : lastTraceStatus])
        }
    }

    def externalHistory = {
        def traces = []
        Set criteriaSet = new HashSet<Critere>(2)
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
            params.id, Critere.EQUALS))
        criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_NAME,
            params.label, Critere.EQUALS))
        externalService.getTraces(criteriaSet, null, null).each {
            traces.add(["date" : it.date,
                        "status" : CapdematUtils.adaptCapdematEnum(it.status, "externalservice.trace.status").i18nKey,
                        "message" : it.message])
        }
        render(template : "externalHistory", model : ["traces" : traces])
    }

    def externalReferentialChecks = {
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.id))
        render(template : "/backofficeRequestInstruction/external/" + params.label + "/externalReferentialChecks",
               model : ["id" : params.id, "label" : params.label,
                        "externalReferentialCheckErrors" : requestExternalService
                            .checkExternalReferential(rqt)])
    }

    def requestLock = {
        def id = Long.valueOf(params.id)
        if (request.get) {
            if (params.part == "tag") {
                render(template : "requestLock",
                       model : requestAdaptorService.prepareLock(id))
            } else if (params.part == "panel") {
                render(template : "requestLockPanel",
                       model : requestAdaptorService.prepareLock(id))
            }
        } else if (request.post) {
            requestLockService.lock(Long.valueOf(params.id))
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else if (request.method.toLowerCase() == "delete") {
            requestLockService.release(Long.valueOf(params.id))
            render([status:"ok", success_msg:message(code:"message.deleteDone")] as JSON)
        }
    }
}
