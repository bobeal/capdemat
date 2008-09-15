import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

class RequestInstructionController {

    IRequestService defaultRequestService
    IHomeFolderService homeFolderService
    IAgentService agentService
   
    def translationService
    
    def defaultAction = "edit"
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
    
    def edit = {
		    def request = defaultRequestService.getById(Long.valueOf(params.id))
		    def requestLabel = translationService.getEncodedRequestTypeLabelTranslation(request)
		
		    def documentList = [];
		    def requestDocuments = request.getDocuments();
		    requestDocuments.each {
		        def document = [
		            'id':it.id,
		            'name':it.documentType.name
		            ];
		        documentList.add(document);
		    }
		
		    ["request":request, "requestLabel":requestLabel, "documentList":documentList]
    }
    
    def loadHomeFolderData = {
//    		def homeFolder = homeFolderService.getByrequestId(Long.valueOf(params.id))
//    		def adults = homeFolderService.getAdults(homeFolder.id)
//    		def children = homeFolderService.getChildren(homeFolder.id)

    		render(template:'homeFolderData')
    }
    
    def loadHomeFolderRequests = {
    		def request = defaultRequestService.getById(Long.valueOf(params.id))
            redirect(controller:"request", action:"loadRequests", params:[homeFolderId:request.requester.homeFolder.id])
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
            render(template:'requestHistory', model:['requestActionList':requestActionList])
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
    
    
    def test = {
      render(view:'test')
    }
}



