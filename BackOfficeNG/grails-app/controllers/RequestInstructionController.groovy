import fr.cg95.cvq.service.request.*
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IChildService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.document.IDocumentService

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.DataState
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Child

import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.exception.*
import fr.cg95.cvq.service.authority.IAgentService
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.springframework.web.context.request.RequestContextHolder

import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.mail.impl.MailService;

import java.util.Date
import java.io.File;
import java.io.InputStream

import grails.converters.JSON

class RequestInstructionController {

    GroovyPagesTemplateEngine groovyPagesTemplateEngine
    IRequestService defaultRequestService
    IHomeFolderService homeFolderService
    IChildService childService
    IIndividualService individualService
    IDocumentService documentService
    IMeansOfContactService meansOfContactService
    IAgentService agentService
    IRequestServiceRegistry requestServiceRegistry
    IMailService mailService

    def translationService

    def defaultAction = "edit"

    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }

    def edit = {

		    def request = defaultRequestService.getById(Long.valueOf(params.id))
		    def requestLabel = translationService.getEncodedRequestTypeLabelTranslation(request)

		    def documentList = []
		    def requestDocuments = defaultRequestService.getAssociatedDocuments(Long.valueOf(params.id))

		    requestDocuments.each {
		        documentList.add(
                [ "id": it.id,
                  "name": it.documentType.name,
                  "endValidityDate" : it.endValidityDate == null ? "" : DateUtils.formatDate((Date)it.endValidityDate),
                  "pageNumber": documentService.getPagesNumber(it.id),
                  "state": CapdematUtils.adaptCapdematEnum(it.state, "document.state")
		            ])
		    }

		    // manage allowed and associated documents to a request
		    def isDocumentProvide
		    defaultRequestService.getAllowedDocuments(request.getRequestType()).each { documentTypeIt ->
		        isDocumentProvide = false
		        requestDocuments.each { documentIt ->
		            if (documentIt.documentType == documentTypeIt)
		                isDocumentProvide = true
		        }
		        if (!isDocumentProvide)
		            documentList.add(
		                [ "id": 0,
                      "name": documentTypeIt.name,
                      "state": ["cssClass": "tag-not_provided", "i18nKey": "document.state.notProvided"]
		                ])
		    }

		    // just for VoCardRequest and HomeFolderModificationRequest
		    def adults
		    def children
		    def clr = [:]
		    if (request instanceof  fr.cg95.cvq.business.request.ecitizen.VoCardRequest
		        || request instanceof fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest) {
		        adults = homeFolderService.getAdults(request.homeFolder.id)
		        children = homeFolderService.getChildren(request.homeFolder.id)
		        children.each {
		        	clr.put(it.id, childService.getLegalResponsibles(it.id))
		        }
		    }

		    [ "request": request,
		      "adults" : adults,
		      "children" : children,
		      "childrenLegalResponsibles" : clr,
		      "requestState": CapdematUtils.adaptCapdematEnum(request.state, "request.state"),
		      "requestDataState": CapdematUtils.adaptCapdematEnum(request.dataState, "request.dataState"),
		      "requestLabel": requestLabel,
		      "documentList": documentList
		    ]
    }


    /* request data inline edition managment
    * --------------------------------------------------------------------- */

    def widget = {
        def widgetMap = [ string:"string", email:"string", number:"string",
                          date:"date", address:"address", capdematEnum:"capdematEnum" ]

        // tp implementation
        def propertyNameTokens = params.propertyName.tokenize(".")
        
        def propertyTypes = JSON.parse(params.propertyType)
        
        // one of the widgetMap keys
        def propertyType = propertyTypes.validate

        def model = ["requestId": Long.valueOf(params.id),
                     "individualId": params.propertyName.tokenize("[]")[1],
                     // the "simple" property name, with de-referencement
                     "propertyNameTp": propertyNameTokens[propertyNameTokens.size() -1],
                     // the "fully qualifier" property name
                     "propertyName": params.propertyName,
                     "propertyType": propertyType,
                     "required" : propertyTypes.required ? "required" : ""]

        def propertyValue
        if (propertyType == "address") {
            propertyValue = JSON.parse(params.propertyValue)
        } else if (propertyType == "capdematEnum") {
            def propertyJavaType = propertyTypes.javatype.tokenize(".")
            def allPropertyValue = Class.forName(propertyTypes.javatype)
                    .getField("all" + propertyJavaType[propertyJavaType.size() -1] + "s").get()
            model["allPropertyValue"] = allPropertyValue
            def propertyValueTokens = params.propertyValue.tokenize(" ")
            propertyValue = [ "enumString": propertyValueTokens[0], "i18nKeyPrefix": propertyValueTokens[1] ]
            // will contain the fully qualified class name of the "CapDemat enum" class
            model["propertyValueType"] = propertyTypes.javatype
        } else {
            propertyValue = params.propertyValue
        }
        model["propertyValue"] = propertyValue

        render( template: "/requestInstruction/widget/" + widgetMap[propertyType], model:model)
    }

    def modify = {
        if (params.requestId == null || params.individualId == null )
             return
        try {
          def individual = individualService.getById(Long.valueOf(params.individualId))

          log.debug("Binder custum editor PersistentStringEnum = " +
              getBinder(individual)
                  .propertyEditorRegistry
                  .findCustomEditor(fr.cg95.cvq.dao.hibernate.PersistentStringEnum.class ,null)
          )
          bind(individual)

          render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            ce.printStackTrace()
            log.error "save() error while saving property of request"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
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

        try {
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

        } catch (CvqException ce) {
            ce.printStackTrace()
            log.error "postNewState() error while updating state (request, data, or document)"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }

    /* Document managment
    * --------------------------------------------------------------------- */

    def document = {
        def document = documentService.getById(Long.valueOf(params.id))

        def actions = []
        document.actions.each {
            def agent
            try {
              agent = it.agentId ? agentService.getById(it.agentId) : null
            } catch (CvqObjectNotFoundException) {
                agent = null
            }

            actions.add(
                [ "id": it.id,
                  "agentName": agent ? agent.lastName + " " + agent.firstName : "",
                  "label": it.label,
                  "note": it.note,
                  "date": it.date,
                  "resultingState": CapdematUtils.adaptCapdematEnum(it.resultingState, "document.state")
                ])
        }

        render( template:"requestDocument",
                model: [ "document":
                            [ "id": document.id,
                              "name": document.documentType.name,
                              "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state"),
                              "depositType": CapdematUtils.adaptCapdematEnum(document.depositType, "document.depositType"),
                              "depositOrigin": CapdematUtils.adaptCapdematEnum(document.depositOrigin, "document.depositOrigin"),
                              "endValidityDate": document.endValidityDate,
                              "ecitizenNote": document.ecitizenNote,
                              "agentNote": document.agentNote,
                              "actions": actions,
                              "pageNumber": documentService.getPagesNumber(document.id),
                              "pages": documentService.getAllPages(document.id)
                            ]
                       ])
    }

    // render document data as PNG image
    def documentPage = {
        def documentBinary = documentService.getPage(
            Long.valueOf(params.documentId), Integer.valueOf(params.pageNumber))

        response.contentType = "image/png"
        response.outputStream << documentBinary.data
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
        try {
            documentService.modify(document)
            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            ce.printStackTrace()
            log.error "modifyDocument()"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }


    /* eCitizen contact managment
    * --------------------------------------------------------------------- */

    // TODO : rename action
    def contactInformation = {
        def request = defaultRequestService.getById(Long.valueOf(params.id))
        Adult requester = request.getRequester()

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
        if (request.meansOfContact.type == MeansOfContactEnum.EMAIL)
            defaultContactRecipient = request.requester.email
        else if (request.meansOfContact.type == MeansOfContactEnum.SMS)
            defaultContactRecipient = request.requester.mobilePhone

        requesterMeansOfContacts.each(){
            it.i18nKey = message(code:it.i18nKey)
        };

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
                        "requesterMobilePhone": request.requester.mobilePhone,
                        "requesterEmail": request.requester.email,
                        "meansOfContact": CapdematUtils.adaptCapdematEnum(request.meansOfContact.type,
                                                                          "request.meansOfContact")
                    ]
                ]
        )
    }

    // TODO test field
    def notifyContact = {
        def meansOfContact = MeansOfContactEnum.forString(params.meansOfContact)
        def to = params.contactRecipient
        def body = params.contactMessage

        try {
            if (meansOfContact == MeansOfContactEnum.EMAIL)
                meansOfContactService.notifyRequesterByEmail(null, to , "", body, null)
            else if (meansOfContact == MeansOfContactEnum.SMS)
                meansOfContactService.notifyRequesterBySms(to, body)

            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            ce.printStackTrace()
            log.error "notifyContact() error while notifying requester)"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }
    }


    /*  request information  managment
    * --------------------------------------------------------------------- */

    def homeFolder = {
//        def homeFolder = homeFolderService.getByrequestId(Long.valueOf(params.id))
//        def adults = homeFolderService.getAdults(homeFolder.id)
//        def children = homeFolderService.getChildren(homeFolder.id)

    		render(template:'homeFolderData')
    }

    def homeFolderRequests = {
    		def request = defaultRequestService.getById(Long.valueOf(params.id))
        def homeFolderRequests = defaultRequestService.getByHomeFolderId(request.homeFolder.id);

        def records = []
        homeFolderRequests.each {
          def agent = it.lastInterveningAgentId ? agentService.getById(it.lastInterveningAgentId) : null
          def quality = 'green'
          if (it.redAlert)
              quality = 'red'
          else if (it.orangeAlert)
              quality = 'orange'
          def record = [
              'id':it.id,
              'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
              'creationDate':DateUtils.formatDate(it.creationDate),
              'requesterLastName':it.requester.lastName + " " + it.requester.firstName,
              'subjectLastName':it.subject ? it.subject.lastName + " " + it.subject.firstName : "",
              'homeFolderId':it.homeFolder.id,
              'state':it.state.toString(),
              'lastModificationDate':it.lastModificationDate == null ? "" :  DateUtils.formatDate(it.lastModificationDate),
              'lastInterveningAgentId': agent ? agent.lastName + " " + agent.firstName : "",
              'prmanent':!it.homeFolder.boundToRequest,
              'quality':quality
          ]
          records.add(record)
        }
        log.debug ("homefolder record list = " + records.size())
        render(template:'/request/searchResult', collection: records, var:'record')
    }

    def requestActions = {
        def requestActions = defaultRequestService.getActions(Long.valueOf(params.id))
        def requestActionList = []
        requestActions.each {
            def user = ""
            try {
                def requestAgent = agentService.getById(it.agentId)
                user = requestAgent.firstName + " " + requestAgent.lastName
            } catch (CvqObjectNotFoundException) {
                user = "Demandeur"
            }
            def requestAction = [
                'id':it.id,
                'agent_name':user,
                'label':it.label,
                'note':it.note,
                'date':it.date.toString(),
                'resulting_state':it.resultingState.toString(),
                'request_id':it.request.id
            ]
            requestActionList.add(requestAction)
        }
        render(template:'requestHistory', model: ['requestActionList':requestActionList])
    }

    def requestNotes = {
    		def requestNotes = defaultRequestService.getNotes(Long.valueOf(params.id))
    		def requestNoteList = []
    		requestNotes.each {
                def user = ""
                try {
                    def requestAgent = agentService.getById(it.agentId)
                    user = requestAgent.firstName + " " + requestAgent.lastName
                } catch (CvqObjectNotFoundException) {
                    user = "Demandeur"
                }
    			def requestNote = [
	               'id':it.id,
	               'agent_name':user,
	               'type':it.type,
	               'note':it.note,
	               'request_id':it.request.id
    			]
    			requestNoteList.add(requestNote)
    		}
            render(template:'requestNotes', model:['requestNoteList':requestNoteList,'requestId':params.id])
    }

    def addRequestNote = {
        try {
            if (params.requestId != null && params.newRequestNote != null)
          			defaultRequestService.addNote(Long.valueOf(params.requestId),
          					RequestNoteType.DEFAULT_NOTE, params.newRequestNote)
          	else
          		 redirect(controller:"request")
          } catch (CvqException cvqe) {
          	log.error "save() error while adding a note to request " + params.id
              render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
              return
          }
        render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    def trace = {
        //throw new CvqException('action.cancel');
        def request = this.defaultRequestService.getById(Long.valueOf(params?.requestId))
        this.defaultRequestService.addAction(request, params?.traceLabel, params?.message)
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
        //Locale.setDefault Locale.FRANCE
        response.contentType = 'text/html; charset=utf-8'
        render this.prepareTemplate(params?.rid,params?.fid,params?.msg?.encodeAsHTML())
        //response.contentType = 'text/html; charset=utf-8'
    } 

    private prepareTemplate = {requestId,formId,message ->
        
        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        def form = this.defaultRequestService.getRequestFormById(Long.valueOf(formId))
        Request request = this.defaultRequestService.getById(Long.valueOf(requestId))
            
        Adult requester = request.getRequester()
        def address = requester.getHomeFolder().getAdress()
        def subject = this.getSubjectDescription(request.getSubject())
        def forms = []
        forms.add(form)
    
        File templateFile = defaultRequestService.getTemplateByName(form.getTemplateName())
        if(templateFile.exists()) {
    
            def template = groovyPagesTemplateEngine.createTemplate(templateFile);
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(['forms':forms]).writeTo(out);
            requestAttributes.setOut(originalOut)
    
            String content = out.toString().replace('#{','${');
            def model = [
                'DATE' : java.text.DateFormat.getDateInstance().format(new Date()),
                'RQ_ID' : request?.getId(),
                'RQ_TP_LABEL' : request?.getRequestType().getLabel(),
                'RQ_CDATE' : request?.getCreationDate(),
                'RQ_DVAL' : request?.getValidationDate(),
                'RQ_OBSERV' : message,
                'HF_ID' : requester?.getHomeFolder()?.getId(),
                'RR_FNAME' : requester?.getFirstName(),
                'RR_LNAME' : requester?.getLastName(),
                'RR_TITLE' : requester?.getTitle(),
                'RR_LOGIN' : requester?.getLogin(),
                'RR_FNAME' : subject?.firstName,
                'RR_LNAME' : subject?.lastName,
                'RR_TITLE' : subject?.title,
                'HF_ADDRESS_ADI' : address?.additionalDeliveryInformation,
                'HF_ADDRESS_AGI' : address?.additionalGeographicalInformation,
                'HF_ADDRESS_SNAME' : address?.streetName,
                'HF_ADDRESS_SNUM' : address?.streetNumber,
                'HF_ADDRESS_PNS' : address?.placeNameOrService,
                'HF_ADDRESS_ZIP' : address?.postalCode,
                'HF_ADDRESS_TOWN' : address?.city,
                'HF_ADDRESS_CN' : address?.countryName,
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


