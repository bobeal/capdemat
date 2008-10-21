import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IChildService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.document.IDocumentService

import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.DataState
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Child

import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.service.authority.IAgentService

import fr.cg95.cvq.util.Critere
import java.util.Date

import grails.converters.JSON

class RequestInstructionController {

    IRequestService defaultRequestService
    IHomeFolderService homeFolderService
    IChildService childService
    IIndividualService individualService
    IDocumentService documentService
    IMeansOfContactService meansOfContactService
    IAgentService agentService
    
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
                  "state": CapdematUtils.adaptCapdematState(it.state, "document.state")
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
		    if (request instanceof  fr.cg95.cvq.business.ecitizen.VoCardRequest
		        || request instanceof fr.cg95.cvq.business.request.HomeFolderModificationRequest) {
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
		      "requestState": CapdematUtils.adaptCapdematState(request.state, "request.state"),
		      "requestDataState": CapdematUtils.adaptCapdematState(request.dataState, "request.dataState"),
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
        
        def propertyTypeList = params.propertyType.tokenize(" ")
        // one of the widgetMap keys
        def propertyType = propertyTypeList[0]
        
        def model = ["requestId": Long.valueOf(params.id),
                     "individualId": params.propertyName.tokenize("[]")[1],
                     // the "simple" property name, with de-referencement
                     "propertyNameTp": propertyNameTokens[propertyNameTokens.size() -1],
                     // the "fully qualifier" property name
                     "propertyName": params.propertyName,
                     "propertyType": propertyType,
                     "required" : propertyTypeList[propertyTypeList.size() -1] == "required" ? "required" : ""]
        
        def propertyValue
        if (propertyType == "address") {
            propertyValue = JSON.parse(params.propertyValue)
        } else if (propertyType == "capdematEnum") {
            def propertyJavaType = propertyTypeList[1].tokenize(".")
            def allPropertyValue = Class.forName(propertyTypeList[1])
                    .getField("all" + propertyJavaType[propertyJavaType.size() -1] + "s").get()
            
            model["allPropertyValue"] = allPropertyValue
            def propertyValueTokens = params.propertyValue.tokenize(" ")
            propertyValue = [ "enumString": propertyValueTokens[0], "i18nKeyPrefix": propertyValueTokens[1] ]
            // will contain the fully qualified class name of the "CapDemat enum" class
            model["propertyValueType"] = propertyTypeList[1]
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
        transitionStates.each { states.add(CapdematUtils.adaptCapdematState(it, stateTypeI18nKey)) }
        
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
                  "resultingState": CapdematUtils.adaptCapdematState(it.resultingState, "document.state")
                ])
        }
        
        render( template:"requestDocument", 
                model: [ "document": 
                            [ "id": document.id,
                              "name": document.documentType.name,
                              "state": CapdematUtils.adaptCapdematState(document.state, "document.state"),
                              "depositType": CapdematUtils.adaptCapdematState(document.depositType, "document.depositType"),
                              "depositOrigin": CapdematUtils.adaptCapdematState(document.depositOrigin, "document.depositOrigin"),
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
            states.add(CapdematUtils.adaptCapdematState(it, "document.state"))
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
        
        def requesterMeansOfContacts = []
        meansOfContactService.getAdultEnabledMeansOfContact(request.requester).each {
            requesterMeansOfContacts.add(
                CapdematUtils.adaptCapdematState(it.type, "request.meansOfContact"))
        }
        
        def requestForms = []
        defaultRequestService.getRequestTypeForms(request.requestType.id, RequestFormType.REQUEST_CERTIFICAT).each {
            requestForms.add(
                [ "id": it.id,
                  "shortLabel": it.shortLabel,
                  "xslFoFilename": it.xslFoFilename,
                  "type": CapdematUtils.adaptCapdematState(it.type, "request.meansOfContact")
                ]
            )
        }
        
        // this task must maybe be done by a service
        def defaultContactRecipient
        if (request.meansOfContact.type == MeansOfContactEnum.EMAIL)
            defaultContactRecipient = request.requester.email
        else if (request.meansOfContact.type == MeansOfContactEnum.SMS)
            defaultContactRecipient = request.requester.mobilePhone
        
        render( template: "ecitizenContact", 
                model: 
                    [ "requesterMeansOfContacts": requesterMeansOfContacts,
                      "requestForms": requestForms,
                      "request": 
                          [ "state": CapdematUtils.adaptCapdematState(request.state, "request.state"),
                            "requesterMobilePhone": request.requester.mobilePhone,
                            "requesterEmail": request.requester.email,
                            "meansOfContact": CapdematUtils.adaptCapdematState(request.meansOfContact.type, "request.meansOfContact")
                          ],
                      "defaultContactRecipient": defaultContactRecipient
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
    
}


