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
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.mail.IMailService
import grails.converters.JSON
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.springframework.web.context.request.RequestContextHolder

class RequestInstructionController {

    GroovyPagesTemplateEngine groovyPagesTemplateEngine
    IRequestService defaultRequestService
    IHomeFolderService homeFolderService
    IIndividualService individualService
    IDocumentService documentService
    IMeansOfContactService meansOfContactService
    IAgentService agentService
    IRequestServiceRegistry requestServiceRegistry
    IMailService mailService
    ILocalAuthorityRegistry localAuthorityRegistry
    ICategoryService categoryService

    def translationService
    def instructionService
    def documentAdaptorService
    def pdfService
    def defaultAction = "edit"

    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }

    def edit = {
        Agent agent = SecurityContext.getCurrentAgent();
        def request = defaultRequestService.getById(Long.valueOf(params.id))
        def requester = individualService.getById(request.requesterId)
        def requestLabel = translationService.getEncodedRequestTypeLabelTranslation(request)

        def documentList = []
        def providedDocumentTypes = []
        def requestDocuments = defaultRequestService.getAssociatedDocuments(Long.valueOf(params.id))
    
        requestDocuments.each {
            def document = documentService.getById(it.documentId)
            providedDocumentTypes.add(document.documentType.id)
            documentList.add(
                    [ "id": document.id,
                      "name": message(code:CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
                      "endValidityDate" : document.endValidityDate,
                      "pageNumber": documentService.getPagesNumber(document.id),
                      "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state")
                    ]
            )
        }

        // manage allowed and associated documents to a request
        def isDocumentProvided
        defaultRequestService.getAllowedDocuments(request.requestType.id).each { documentTypeIt ->
            isDocumentProvided = false
            if (providedDocumentTypes.contains(documentTypeIt.id))
                isDocumentProvided = true
            if (!isDocumentProvided)
                documentList.add(
                    [ "id": 0,
                      "name": message(code:CapdematUtils.adaptDocumentTypeName(documentTypeIt.name)),
                      "state": ["cssClass": "tag-not_provided", "i18nKey": "document.state.notProvided"]
                    ])
        }
        
        // just for VoCardRequest and HomeFolderModificationRequest
        def adults
        def children
        def clr = [:]
        if (request instanceof  fr.cg95.cvq.business.request.ecitizen.VoCardRequest
            || request instanceof fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest) {
            adults = homeFolderService.getAdults(request.homeFolderId)
            children = homeFolderService.getChildren(request.homeFolderId)
            children.each {
                clr.put(it.id, homeFolderService.getBySubjectRoles(it.id,
                        [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]))
            }
        }
        def editableStates = []
        for(RequestState state : defaultRequestService.getEditableStates()) 
            editableStates.add(state.toString())

        [ "request": request,
          "requestTypeLabel" : request.requestType.label,
          "requester": requester,
          "adults" : adults,
          "children" : children,
          "childrenLegalResponsibles" : clr,
          "editableStates" : (editableStates as JSON).toString(),
          "agentCanWrite" : categoryService.hasWriteProfileOnCategory(agent,request.requestType.category.id),
          "requestState": CapdematUtils.adaptCapdematEnum(request.state, "request.state"),
          "requestDataState": CapdematUtils.adaptCapdematEnum(request.dataState, "request.dataState"),
          "requestLabel": requestLabel,
          "requestTypeTemplate": CapdematUtils.requestTypeLabelAsDir(request.requestType.label),
          "documentList": documentList
        ]
    }


    /* request data inline edition managment
    * --------------------------------------------------------------------- */

    def widget = {
        def widgetMap = [ date:"date", address:"address", capdematEnum:"capdematEnum", boolean:"boolean", textarea:"textarea"]
        
        // tp implementation
        def propertyNameTokens = params.propertyName.tokenize(".")
        
        def propertyTypes = JSON.parse(params.propertyType)
        
        // one of the widgetMap keys
        def propertyType = propertyTypes.validate
        def widget = widgetMap[propertyType] ? widgetMap[propertyType] : "string"

        // big hacks allow list datading for all request different from VoCard and HomeFolder
        // Will be remove with homefolder refactoring
        // here inline edition will pass until 10 element per list
        def individualId = params.propertyName.tokenize("[]").size() > 1 ? Integer.valueOf(params.propertyName.tokenize("[]")[1]).intValue() : 0 
        
        def model = ["requestId": Long.valueOf(params.id),
                     "individualId": params.propertyName.tokenize("[]")[1],
                     // the "simple" property name, with de-referencement
                     "propertyNameTp": individualId > 10 ? propertyNameTokens[propertyNameTokens.size() -1] : params.propertyName,
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
                
            propertyValue = [ "enumString": propertyValueTokens[0], "i18nKeyPrefix": propertyValueTokens[1] ]
            // will contain the fully qualified class name of the "CapDemat enum" class
            model["propertyValueType"] = propertyTypes.javatype
        }
        else {
            propertyValue = params.propertyValue
            model["i18nKeyPrefix"] = propertyTypes.i18n
            model["regex"] = params.propertyRegex
            if (params.propertyRegex != "")
                model["propertyType"] = "regex"
            
            if (propertyType == "textarea")
              model["rows"] = propertyTypes.rows
        }
        model["propertyValue"] = propertyValue

        render( template: "/backofficeRequestInstruction/widget/" + widget, model:model)
    }

    def modify = {
        if (params.requestId == null || params.individualId == null )
             return
        def request = defaultRequestService.getById(Long.valueOf(params.requestId))
        if (["VO Card Request", "Home Folder Modification"].contains(request.requestType.label)) {
            def individual = individualService.getById(Long.valueOf(params.individualId))
            bind(individual)
        } else {
            DataBindingUtils.initBind(request, params)
            bind(request)
        }
//        log.debug("Binder custum editor PersistentStringEnum = " +
//                getBinder(request)
//                    .propertyEditorRegistry
//                    .findCustomEditor(fr.cg95.cvq.dao.hibernate.PersistentStringEnum.class, null))

        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def modifyList = {
        println 'modifyList START'
        if (params.requestId == null || params.listAction == null )
             return
        
        def cRequest = defaultRequestService.getById(Long.valueOf(params.requestId))
        def actionTokens = params.listAction.tokenize('_')

        def listElemTokens = actionTokens[1].tokenize('[]')
        def getterMethod = cRequest.class.getMethod('get' + StringUtils.firstCase(listElemTokens[0], 'Upper'))
        
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
                    defaultRequestService.getPossibleTransitions(DataState.forString(stateAsString))
                stateTypeI18nKey = "request.dataState"
                break
            case "documentState":
                transitionStates =
                    documentService.getPossibleTransitions(DocumentState.forString(stateAsString))
                stateTypeI18nKey = "document.state"
                break
            case "requestState":
                transitionStates =
                    defaultRequestService.getPossibleTransitions(RequestState.forString(stateAsString))
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
                defaultRequestService.updateRequestDataState(
                        Long.valueOf(params.id), DataState.forString(params.newState))
                break
            case "documentState":
                documentService.updateDocumentState(
                        Long.valueOf(params.id),
                        DocumentState.forString(params.newState),
                        null, null)
                break
            case "requestState":
                defaultRequestService.updateRequestState(
                        Long.valueOf(params.id),
                        RequestState.forString(params.newState),
                        null)
               break
        }
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    /* Document managment
    * --------------------------------------------------------------------- */

    def document = {
        def document = documentService.getById(Long.valueOf(params.id))

        def actions = []
        document.actions.each {
            actions.add(
                [ "id": it.id,
                  "agentName": instructionService.getActionPosterDetails(it.agentId),
                  "label": it.label,
                  "note": it.note,
                  "date": it.date,
                  "resultingState": CapdematUtils.adaptCapdematEnum(it.resultingState, "document.state")
                ])
        }
        
        render( template:"requestDocument", model: [
            "document": [
                "id": document.id,
                "name": message(code:CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
                "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state"),
                "depositType": CapdematUtils.adaptCapdematEnum(document.depositType, "document.depositType"),
                "depositOrigin": CapdematUtils.adaptCapdematEnum(document.depositOrigin, "document.depositOrigin"),
                "endValidityDate": document.endValidityDate,
                "ecitizenNote": document.ecitizenNote,
                "agentNote": document.agentNote,
                "actions": actions,
                "pageNumber": documentService.getPagesNumber(document.id),
                "pages": documentAdaptorService.getDocument(document.id).datas    
            ]
        ])
    }

    def documentPage = {
        def document = documentService.getById(Long.valueOf(params.id))
        def page = document.datas[Integer.valueOf(params.pageNumber)]

        response.contentType = "image/png"
        response.outputStream << page.data
    }


    def documentStates = {
        def stateAsString = StringUtils.toPascalCase(params.stateCssClass.replace("tag-", ""))

        def transitionStates =
            documentService.getPossibleTransitions(DocumentState.forString(stateAsString))

        def states = []
        transitionStates.each {
            states.add(CapdematUtils.adaptCapdematEnum(it, "document.state"))
        }

        render( template: "requestDocumentStates",
                model: [
                    "endValidityDate": DateUtils.systemStringToDate(params.endValidityDate),
                    "states": states,
                    "stateType": "documentType",
                    "documentId": params.id
                ])
    }

    def modifyDocument = {
        def document = documentService.getById(Long.valueOf(params.documentId))
        bind(document)
        documentService.modify(document)
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    /*  request information  managment
    * --------------------------------------------------------------------- */

    def help = {
    		render(template:'help')
    }
    
    def homeFolder = {
    		render(template:'homeFolderData')
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
              'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
              'creationDate':it.creationDate,
              'requesterLastName':it.requesterLastName + " " + it.requesterFirstName,
              'subjectLastName':it.subjectId ? it.subjectLastName + " " + it.subjectFirstName : "",
              'homeFolderId':it.homeFolderId,
              'state':it.state.toString(),
              'lastModificationDate':it.lastModificationDate,
              'lastInterveningAgentId': instructionService.getActionPosterDetails(it.lastInterveningAgentId),
              'permanent':!homeFolder.boundToRequest,
              'quality':quality
          ]
          records.add(record)
        }
        render(template:'homeFolderRequests', model: ['records': records])
    }

    def requestActions = {
        def requestActions = defaultRequestService.getActions(Long.valueOf(params.id))
        def requestActionList = []
        requestActions.each {
            def user = instructionService.getActionPosterDetails(it.agentId)
            def resultingState = null
            if (it.label.equals(IRequestService.STATE_CHANGE_ACTION)) {
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
        def requestNotes = defaultRequestService.getNotes(Long.valueOf(params.id))
        def requestNoteList = []
        requestNotes.each {
            def user = instructionService.getActionPosterDetails(it.agentId)
            def requestNote = [
               'id':it.id,
               'agent_name':user,
               'type':it.type,
               'note':it.note,
            ]
            requestNoteList.add(requestNote)
        }
        render(template:'requestNotes', model:['requestNoteList':requestNoteList,'requestId':params.id])
    }

    def requestNote = {
        if (params.requestId != null && params.note != null) {
            defaultRequestService.addNote(
                Long.valueOf(params.requestId), RequestNoteType.DEFAULT_NOTE, params.note)
            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else
            render ([status: "error", error_msg:message(code:"error.missingParmeter")] as JSON)
        
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
        defaultRequestService.getRequestTypeForms(request.requestType.id, RequestFormType.REQUEST_MAIL_TEMPLATE).each {
            String data = ''
            if(it?.personalizedData) data = new String(it?.personalizedData)

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
                    "traceLabel" :  IRequestService.REQUEST_CONTACT_CITIZEN,
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
        this.defaultRequestService.addAction(Long.valueOf(params.requestId), 
                params.traceLabel, params.message)
        render([status:"ok", success_msg:message(code:"message.actionTraced")] as JSON)
    }

    def sendEmail = {
        def request = defaultRequestService.getById(Long.valueOf(params?.requestId))
        def form = defaultRequestService.getRequestFormById(Long.valueOf(params?.requestForms))
        
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
        def form = this.defaultRequestService.getRequestFormById(Long.valueOf(formId))
        Request request = this.defaultRequestService.getById(Long.valueOf(requestId))
            
        Adult requester = individualService.getById(request.requesterId)
        def address = requester.getHomeFolder().getAdress()
        def subjectObject = null
        if (request.subjectId) {
            subjectObject = individualService.getById(request.subjectId)
        }
        def subject = this.getSubjectDescription(subjectObject)
        def forms = []
        forms.add(form)
    
        File templateFile = defaultRequestService.getTemplateByName(form.getTemplateName())
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
        else if(sub.getClass().getSimpleName() == 'Adult')result.title ((Adult)sub).getTitle()

        return result
    }

}


