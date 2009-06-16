import fr.cg95.cvq.business.authority.Agent
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.request.DataState
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.external.IExternalService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.authority.ILocalReferentialService
import fr.cg95.cvq.service.authority.IRecreationCenterService
import fr.cg95.cvq.service.authority.ISchoolService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.mail.IMailService
import grails.converters.JSON
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.springframework.web.context.request.RequestContextHolder

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestInstructionController {

    GroovyPagesTemplateEngine groovyPagesTemplateEngine

    IRequestService defaultRequestService
    IRequestActionService requestActionService
    IRequestTypeService requestTypeService
    IRequestWorkflowService requestWorkflowService
    IHomeFolderService homeFolderService
    IIndividualService individualService
    IDocumentService documentService
    IMeansOfContactService meansOfContactService
    IAgentService agentService
    IRequestServiceRegistry requestServiceRegistry
    IMailService mailService
    ILocalAuthorityRegistry localAuthorityRegistry
    ICategoryService categoryService
    ILocalReferentialService localReferentialService 
    IRecreationCenterService recreationCenterService
    ISchoolService schoolService
    IExternalService externalService

    def translationService
    def instructionService
    def documentAdaptorService
    def homeFolderAdaptorService
    def requestAdaptorService
    def pdfService
    def defaultAction = "edit"

    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }

    def edit = {
        Agent agent = SecurityContext.getCurrentAgent();
        def request = defaultRequestService.getById(Long.valueOf(params.id))
        def requestLabel = translationService
            .translateRequestTypeLabel(request.requestType.label).encodeAsHTML()
        
        def requester = individualService.getById(request.requesterId)     

        def documentList = []
        def providedDocumentTypes = []
        def requestDocuments = defaultRequestService.getAssociatedDocuments(Long.valueOf(params.id))
    
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
        requestTypeService.getAllowedDocuments(request.requestType.id).each { documentTypeIt ->
            isDocumentProvided = false
            if (providedDocumentTypes.contains(documentTypeIt.id))
                isDocumentProvided = true
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
        if (request instanceof  fr.cg95.cvq.business.request.ecitizen.VoCardRequest
            || request instanceof fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest) {
            def individuals = homeFolderService.getIndividuals(request.homeFolderId)
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
        
        def localReferentialTypes = getLocalReferentialTypes(localReferentialService, request.requestType.label)
        localReferentialTypes.each { lazyInit(request, it.key) }

        def externalProviderServiceLabel = null
        def lastTraceStatus = null
        if (externalService.hasMatchingExternalService(request.requestType.label)) {
            externalProviderServiceLabel = externalService
                .getExternalServiceByRequestType(request.requestType.label).label
            def lastTrace = externalService.getLastTrace(request.id, externalProviderServiceLabel)
            if (lastTrace != null) {
                lastTraceStatus = CapdematUtils
                    .adaptCapdematEnum(lastTrace.status, "externalservice.trace.status")
            }
        }

        def lastAction = requestActionService.getLastAction(request.id)
        def lastActionNote = lastAction != null ? lastAction.note : ""
        return ([
            "request": request,
            "requestTypeLabel": request.requestType.label,
            "lrTypes": localReferentialTypes,
            "adults": adults,
            "children": children,
            "requester": requester,
            'hasHomeFolder': !homeFolderService.getById(request.homeFolderId).boundToRequest,
            "childrenLegalResponsibles": clr,
            "editableStates": (editableStates as JSON).toString(),
            "agentCanWrite": categoryService.hasWriteProfileOnCategory(agent, request.requestType.category.id),
            "requestState": CapdematUtils.adaptCapdematEnum(request.state, "request.state"),
            "lastActionNote" : lastActionNote,
            "requestDataState": CapdematUtils.adaptCapdematEnum(request.dataState, "request.dataState"),
            "requestLabel": requestLabel,
            "requestTypeTemplate": CapdematUtils.requestTypeLabelAsDir(request.requestType.label),
            "documentList": documentList,
            "externalProviderServiceLabel" : externalProviderServiceLabel,
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
    def lazyInit(request, listName) { 
        if (request[listName] == null || request[listName].size() == 0) return false
        request[listName].get(0)
    }
    
    def localReferentialData = {
        def rqt = defaultRequestService.getById(Long.valueOf(params.requestId))
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
            def rqt = defaultRequestService.getById(Long.valueOf(params.id))
            def lrTypes = getLocalReferentialTypes(localReferentialService, rqt.requestType.label)
            model['lrType'] = lrTypes[params.propertyName]
            model['lrDatas'] = rqt[params.propertyName].collect { it.name }
            flash[params.propertyName + 'Index'] = 0
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
        def request = defaultRequestService.getById(Long.valueOf(params.requestId))
        if (["VO Card", "Home Folder Modification"].contains(request.requestType.label)) {
            def homeFolder = homeFolderService.getById(request.homeFolderId)
            DataBindingUtils.initBind(homeFolder, params)
            bind(homeFolder)
        } else if (params.keySet().contains('_requester')) {
            def requester = individualService.getById(request.requesterId)
            bindRequester(requester, params)
        } else if (params.keySet().contains('schoolId')) {
            request.school = schoolService.getById(Long.valueOf(params.schoolId))
        } else if (params.keySet().contains('recreationCenterId')) {
            request.recreationCenter = recreationCenterService.getById(Long.valueOf(params.recreationCenterId))
        } else {
            DataBindingUtils.initBind(request, params)
            bind(request)
        }
//        log.debug("Binder custum editor PersistentStringEnum = " + getBinder(request).propertyEditorRegistry.findCustomEditor(fr.cg95.cvq.dao.hibernate.PersistentStringEnum.class, null))
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
        
        def cRequest = defaultRequestService.getById(Long.valueOf(params.requestId))
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
               ,model: ['request': cRequest])
    }

    def condition = {
        
        def result = []
        
        if (params.requestTypeLabel == null)
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
        
        try {
            IRequestService service = requestServiceRegistry.getRequestService(params.requestTypeLabel)
            for(Map entry : (JSON.parse(params.conditionsContainer) as List)) {
                result.add([
                    success_msg: message(code:'message.conditionTested'),
                    test: service.isConditionFilled(entry),
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

    /*  request information  managment
    * --------------------------------------------------------------------- */

    def help = {
    		render(template:'help')
    }
    
    // FIXME : copy-paste from frontOfficeHomeFolderController. mutualize if possible
    def homeFolder = {
        def result = ['adults':[], 'children': [], homeFolder: []]
        def cRequest = defaultRequestService.getById(Long.valueOf(params.id))
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
   	    def request = defaultRequestService.getById(Long.valueOf(params.id))
        def homeFolderRequests = defaultRequestService.getByHomeFolderId(request.homeFolderId);
        def homeFolder = homeFolderService.getById(request.homeFolderId)             

        def records = []
        homeFolderRequests.each {
          def quality = 'green'
          if (it.redAlert)
              quality = 'red'
          else if (it.orangeAlert)
              quality = 'orange'
          def record = [
              'id':it.id,
              'label':translationService.translateRequestTypeLabel(it.requestType.label).encodeAsHTML(),
              'creationDate':it.creationDate,
              'requesterLastName':it.requesterLastName + " " + it.requesterFirstName,
              'subjectLastName':it.subjectId ? it.subjectLastName + " " + it.subjectFirstName : "",
              'homeFolderId':it.homeFolderId,
              'state':it.state.toString(),
              'lastModificationDate':it.lastModificationDate,
              'lastInterveningUserId': instructionService.getActionPosterDetails(it.lastInterveningUserId),
              'permanent':!homeFolder.boundToRequest,
              'quality':quality
          ]
          records.add(record)
        }
        render(template:'homeFolderRequests', model: ['records': records])
    }

    def requestActions = {
        def requestActions = requestActionService.getActions(Long.valueOf(params.id))
        def requestActionList = []
        requestActions.each {
            def user = instructionService.getActionPosterDetails(it.agentId)
            def resultingState = null
            if (it.label.equals(IRequestActionService.STATE_CHANGE_ACTION)) {
                resultingState = "request.state." + StringUtils.pascalToCamelCase(it.resultingState.toString())
            }
            def requestAction = [
                'id':it.id,
                'agent_name':user,
                'label':message(code:CapdematUtils.adaptRequestActionLabel(it.label)),
                'note':it.note,
                'date':it.date,
                'resulting_state':resultingState
            ]
            requestActionList.add(requestAction)
        }
        render(template:'requestHistory', model: ['requestActionList':requestActionList])
    }

    def requestNotes = {
        render(template : 'requestNotes',
               model : ['requestNoteList' : requestAdaptorService.prepareNotes(
                            defaultRequestService.getNotes(Long.valueOf(params.id),
                            RequestNoteType.forString(params.type))),
                        'requestNoteTypes' : RequestNoteType.allRequestNoteTypes.collect{
                            CapdematUtils.adaptCapdematEnum(it, "request.note.type")},
                        'currentType' : params.type, 'requestId' : params.id])
    }

    def requestNote = {
        if (params.requestId != null && params.note != null && params.requestNoteType != null) {
            defaultRequestService.addNote(
                Long.valueOf(params.requestId),
                RequestNoteType.forString(params.requestNoteType), params.note)
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else
            render ([status: "error", error_msg:message(code:"error.missingParmeter")] as JSON)
        
    }

    def external = {
        if (request.post) {
            externalService.sendRequest(defaultRequestService.getById(Long.valueOf(params.id)))
            def lastTraceStatus = CapdematUtils.adaptCapdematEnum(
                externalService.getLastTrace(
                    Long.valueOf(params.id), params.label).status, "externalservice.trace.status")
            render(template : "/backofficeRequestInstruction/external/" + params.label + "/externalStatus",
                   model : ["externalProviderServiceLabel" : params.label,
                            "lastTraceStatus" : lastTraceStatus])
        }
    }

    def externalHistory = {
        def traces = []
        externalService.getTraces(Long.valueOf(params.id), params.label).each {
            traces.add(["date" : it.date,
                        "status" : CapdematUtils.adaptCapdematEnum(it.status, "externalservice.trace.status").i18nKey,
                        "message" : it.message])
        }
        render(template : "externalHistory", model : ["traces" : traces])
    }

    def externalReferentialChecks = {
        def request = defaultRequestService.getById(Long.valueOf(params.id))
        render(template : "/backofficeRequestInstruction/external/" + params.label + "/externalReferentialChecks",
               model : ["id" : params.id, "label" : params.label,
                        "externalReferentialCheckErrors" : externalService
                            .checkExternalReferential(request)])
    }

   /* eCitizen contact managment
    * --------------------------------------------------------------------- */

    // TODO : rename action
    def contactInformation = {
        def request = defaultRequestService.getById(Long.valueOf(params.id))
        Adult requester = individualService.getById(request.requesterId)

        def requesterMeansOfContacts = []
        meansOfContactService.getAdultEnabledMeansOfContact(requester).each {
            requesterMeansOfContacts.add(
                CapdematUtils.adaptCapdematEnum(it.type, "request.meansOfContact"))
        }

        def requestForms = []
        //requestForms.add(["id":-1,"shortLabel":"...","type":""])
        requestTypeService.getRequestTypeForms(request.requestType.id,
            RequestFormType.REQUEST_MAIL_TEMPLATE).each {
            String data = ''
            if(it.personalizedData) data = new String(it.personalizedData)

            requestForms.add(
                [ "id": it.id,
                  "shortLabel": it.shortLabel,
                  "type": CapdematUtils.adaptCapdematEnum(it.type, "request.meansOfContact")
                ]
            )
        }

        // this task must maybe be done by a service
        def defaultContactRecipient
        if (request.meansOfContact?.type == MeansOfContactEnum.EMAIL)
            defaultContactRecipient = requester.email
        else if (request.meansOfContact?.type == MeansOfContactEnum.SMS)
            defaultContactRecipient = requester.mobilePhone

        requesterMeansOfContacts.each() {
            it.i18nKey = message(code:it.i18nKey)
        }

        render( template: "ecitizenContact",
            model:[
                   "requesterMeansOfContacts": requesterMeansOfContacts,
                    "requestForms": requestForms,
                    "traceLabel" :  IRequestActionService.REQUEST_CONTACT_CITIZEN,
                    "defaultContactRecipient": defaultContactRecipient,
                    "requester": requester,
                    "request": [
                        "id" : request.id,
                        "state": CapdematUtils.adaptCapdematEnum(request.state, "request.state"),
                        "requesterMobilePhone": requester.mobilePhone,
                        "requesterEmail": requester.email,
                        "meansOfContact": CapdematUtils.adaptCapdematEnum(request.meansOfContact?.type,
                                                                          "request.meansOfContact")
                    ]
                ]
        )
    }

    def trace = {
        requestActionService.addAction(Long.valueOf(params.requestId),
                params.traceLabel, params.message)
        render([status:"ok", success_msg:message(code:"message.actionTraced")] as JSON)
    }

    def sendEmail = {
        def request = defaultRequestService.getById(Long.valueOf(params?.requestId))
        def form = requestTypeService.getRequestFormById(Long.valueOf(params?.requestForms))
        
        String template = this.prepareTemplate(
            params?.requestId,
            params?.requestForms,
            params?.message?.encodeAsHTML()
        )
        
        this.meansOfContactService.notifyRequesterByEmail(
            request,
            params?.email,
            message(code:"mail.ecitizenContact.subject"),
            message(code:"mail.ecitizenContact.body"),
            template?.getBytes(),
            "${form.label}.html")

        render([status:"ok",success_msg:message(code:"message.emailSent")] as JSON)
    }

    def sendSms = {
        render([status:"ok",success_msg:message(code:"message.notImplemented")] as JSON)
        //render([status:"ok",success_msg:message(code:"message.smsSent")] as JSON)
    }

    def preview = {

        if (params.type == 'html') {
        	response.contentType = 'text/html; charset=utf-8'
        	render this.prepareTemplate(params?.rid,params?.fid,params?.msg?.encodeAsHTML(),params.type)
        } else if (params.type == 'pdf') {
            def data = this.prepareTemplate(params.rid,params.fid,params.msg?.encodeAsHTML(),params.type)
            byte[] b = pdfService.htmlToPdf(data)
            response.contentType = 'application/pdf'
            response.setHeader('Content-disposition', 'attachment; filename=letter.pdf')
            response.contentLength = b.length
            response.outputStream << b        	
        }
    } 

    private prepareTemplate = {requestId,formId,message,type ->
        
        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        def form = requestTypeService.getRequestFormById(Long.valueOf(formId))
        Request request = defaultRequestService.getById(Long.valueOf(requestId))
            
        Adult requester = individualService.getById(request.requesterId)
        def address = requester.getHomeFolder().getAdress()
        def subjectObject = null
        if (request.subjectId) {
            subjectObject = individualService.getById(request.subjectId)
        }
        def subject = this.getSubjectDescription(subjectObject)
        def forms = []
        forms.add(form)
    
        File templateFile = requestTypeService.getTemplateByName(form.getTemplateName())
        if (templateFile.exists()) {

        	// FIXME BOR : is there a better way to do this ?
            def logoLink = ''
            if (type == 'pdf') {
                File logoFile = 
                    localAuthorityRegistry.getCurrentLocalAuthorityResource(ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                        "logoPdf.jpg", false)
                logoLink = logoFile.absolutePath
            }

            def template = groovyPagesTemplateEngine.createTemplate(templateFile);
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(['forms':forms,'type':type,'logoLink':logoLink]).writeTo(out);
            requestAttributes.setOut(originalOut)
                        
            String content = out.toString().replace('#{','${')
            def model = [
                'DATE' : java.text.DateFormat.getDateInstance().format(new Date()),
                'RQ_ID' : request.id,
                'RQ_TP_LABEL' : request.requestType.label,
                'RQ_CDATE' : request.creationDate,
                'RQ_DVAL' : request.validationDate,
                'RQ_OBSERV' : message,
                'HF_ID' : requester.homeFolder.id,
                'RR_FNAME' : requester.firstName,
                'RR_LNAME' : requester.lastName,
                'RR_TITLE' : requester.title,
                'RR_LOGIN' : requester.login,
                'SU_FNAME' : subject?.firstName,
                'SU_LNAME' : subject?.lastName,
                'SU_TITLE' : subject?.title,
                'HF_ADDRESS_ADI' : address.additionalDeliveryInformation,
                'HF_ADDRESS_AGI' : address.additionalGeographicalInformation,
                'HF_ADDRESS_SNAME' : address.streetName,
                'HF_ADDRESS_SNUM' : address.streetNumber,
                'HF_ADDRESS_PNS' : address.placeNameOrService,
                'HF_ADDRESS_ZIP' : address.postalCode,
                'HF_ADDRESS_TOWN' : address.city,
                'HF_ADDRESS_CN' : address.countryName
            ]
            model.each{k,v ->  if(v == null)model[k]=''}
    
            template = groovyPagesTemplateEngine.createTemplate(content,'tmp')
            out = new StringWriter();
            originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(model).writeTo(out);
            requestAttributes.setOut(originalOut)
            
            return out.toString()
        } else {
            return ""
        }
    }
    
    private getSubjectDescription = {Object sub ->
        def result = ['firstName':'','lastName':'','title':'']
        if(!sub) return result

        result.firstName = ((Individual)sub).getFirstName()
        result.lastName = ((Individual)sub).getLastName()

        if(sub.getClass().getSimpleName() == 'Child')result.title = 'request.individual.kid'
        else if(sub.getClass().getSimpleName() == 'Adult')result.title = ((Adult)sub).getTitle()

        return result
    }

}


