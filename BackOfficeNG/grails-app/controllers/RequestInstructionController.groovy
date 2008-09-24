import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.DataState
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.util.Critere
import java.util.Date

import grails.converters.JSON

class RequestInstructionController {

    IRequestService defaultRequestService
    IHomeFolderService homeFolderService
    IAgentService agentService
    IDocumentService documentService
   
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
                  "endValidityDate" : DateUtils.formatDate((Date)it.endValidityDate),
                  "pageNumber": documentService.getPagesNumber(it.id),
                  "state": CapdematUtils.adaptCapdematState(it.state, "documentState")
		            ])
		               log.debug(DateUtils.formatDate((Date)it.endValidityDate))
		    }
		    
		    // manage allow and associated documents of a request
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
                      "state": ["cssClass": "tag-not_provided", "i18nKey": "documentType.notProvided"]
		                ])
		    }
		    
		    [ "request": request,
		      "requestState": CapdematUtils.adaptCapdematState(request.state, "requestState"),
		      "requestDataState": CapdematUtils.adaptCapdematState(request.dataState, "requestDataState"),
		      "requestLabel": requestLabel,
		      "documentList": documentList
		    ]
    }
    
    // called asynchronously
    def stateTransitions = {
        def stateAsString = StringUtils.toPascalCase(params.stateCssClass.replace("tag-", ""))
        def stateType = params.stateType
        
        def transitionStates = [] 
        switch (stateType) {
            case "requestDataState":
                transitionStates = 
                    defaultRequestService.getPossibleTransitions(DataState.forString(stateAsString))
                break
            case "documentState":
                transitionStates =
                    documentService.getPossibleTransitions(DocumentState.forString(stateAsString))
                break
            case "requestState":
                transitionStates = 
                    defaultRequestService.getPossibleTransitions(RequestState.forString(stateAsString))
                 break
        }
        
        def states = []
        transitionStates.each { states.add(CapdematUtils.adaptCapdematState(it, stateType)) }
        
        render( template: "possibleTransitionStates", 
                model: ["states": states, "stateType": stateType, "id": params.id])
    }
    
    // called asynchronously
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
                  "resultingState": CapdematUtils.adaptCapdematState(it.resultingState, "documentState")
                ])
        }
        
        render( template:"requestDocument", 
                model: [ "document": 
                            [ "id": document.id,
                              "name": document.documentType.name,
                              "state": CapdematUtils.adaptCapdematState(document.state, "documentState"),
                              "depositType": CapdematUtils.adaptCapdematState(document.depositType, "depositType"),
                              "depositOrigin": CapdematUtils.adaptCapdematState(document.depositOrigin, "depositOrigin"),
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
    
    def modifyDocument = {
        def document = documentService.getById(Long.valueOf(params.documentId))
        
        document.endValidityDate = params.endValidityDate == "" ? 
                document.endValidityDate : DateUtils.stringToDate(params.endValidityDate)
        document.agentNote = params.agentNote
        
        try {
            documentService.modify(document)
            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            ce.printStackTrace()
            log.error "postNewState() error while updating state (request, data, or document)"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }            
    }
    
    def loadHomeFolderData = {
//        def homeFolder = homeFolderService.getByrequestId(Long.valueOf(params.id))
//        def adults = homeFolderService.getAdults(homeFolder.id)
//        def children = homeFolderService.getChildren(homeFolder.id)

    		render(template:'homeFolderData')
    }
    
    def loadHomeFolderRequests = {
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
              'permanent':!it.homeFolder.boundToRequest,
              'quality':quality
          ]
          records.add(record)
        }
        log.debug ("homefolder record list = " + records.size())
        render(template:'/request/searchResult', collection: records, var:'record')
    }

    def loadRequestHistory = {
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

    def loadRequestNotes = {
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



