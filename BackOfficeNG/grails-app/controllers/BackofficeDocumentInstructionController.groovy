import fr.cg95.cvq.exception.CvqModelException;

import grails.converters.JSON
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DepositOrigin
import fr.cg95.cvq.business.document.DepositType
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestDocument
import fr.cg95.cvq.business.document.DocumentAction
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.authority.Agent

class BackofficeDocumentInstructionController {
    
    def defaultAction = "edit"
    
    def instructionService
    DocumentAdaptorService documentAdaptorService
    
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IRequestDocumentService requestDocumentService
    IRequestLockService requestLockService
    IRequestTypeService requestTypeService
    IRequestSearchService requestSearchService
    ICategoryService categoryService

    def beforeInterceptor = {
        if (params.requestId)
            requestLockService.tryToLock(Long.valueOf(params.requestId))
    }

    def edit = {
        def document = [actions:[],documentType:[:]]
        Request request = requestSearchService.getById(Long.valueOf(params.requestId), false)
        Agent agent = SecurityContext.currentAgent;
        
        if(!params.id || Integer.valueOf(params.id) == 0) {
            def documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.dtid))
            document.documentType.name = documentType.name
            document.state = DocumentState.PENDING
            document.depositOrigin = DepositOrigin.AGENT
            document.depositType = DepositType.PC
            document.datas = []
        } else {
            document = documentService.getById(Long.valueOf(params.id))
        }

        def actions = []
        for(DocumentAction action : document.actions) {
            actions.add(documentAdaptorService.adaptDocumentAction(action))
        }
        def agentCanWrite =
            categoryService.hasWriteProfileOnCategory(agent, request.requestType.category.id)
        
        def contentType = ""
        if(document.datas.size() != 0)
            contentType = "de type" + document.datas[0].getContentType().toString()
        
        return ([
            "uuid" : UUID.randomUUID().toString(),
            "document": [
                "id": document.id,
                "actions": actions,
                "editable": documentService.getEditableStates().contains(document.state) && agentCanWrite,
                "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state"),
                "name": message(code:CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
                "depositType": CapdematUtils.adaptCapdematEnum(document.depositType, "document.depositType"),
                "depositOrigin": CapdematUtils.adaptCapdematEnum(document.depositOrigin, "document.depositOrigin"),
                "endValidityDate": document.endValidityDate,
                "ecitizenNote": document.ecitizenNote,
                "agentNote": document.agentNote,
                "pageNumber": document.datas.size(),
                "contentType": document.datas.size(),
                "pages": document.id ? documentAdaptorService.getDocument(document.id).datas : []
            ]
        ])
    }
    
    def addPage = {
        def result = [:], file = request.getFile('pageFile')
        
            Document document = null
            if (params.documentId) {
            	document = documentService.getById(Long.valueOf(params.documentId))
            } else {
                document = new Document()
                Request req = requestSearchService.getById(Long.valueOf(params.requestId), false)
                document.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.documentTypeId))
                document.homeFolderId = req.homeFolderId
                document.depositOrigin = DepositOrigin.AGENT
                
                documentService.create(document)
                requestDocumentService.addDocument(req, document.id)
                result.newDocumentId = document.id
            }
            
            try {
                documentService.addPage(Long.valueOf(document.id), new DocumentBinary(file.bytes))
                result.status = 'success'
                result.documentId = params?.documentId ? '' : document.id
                result.message = message(code:"message.addDone")
                result.pageNumber = document.datas.size() - 1
            } catch (CvqModelException cme) {
                result.status = 'warning'
                result.message = message(code : cme.i18nKey)
            }
        
        response.contentType = 'text/html; charset=utf-8'
        render((new JSON(result)).toString())
    }
    
    def deletePage = {
    	documentService.deletePage(Long.valueOf(params.documentId), Integer.valueOf(params.pageNumber))
        render ([status:"success", message:message(code:"message.deleteDone")] as JSON)
    }
    
    def modifyPage = {
        def result = [:], file = request.getFile('pageFile')
        
        def document = documentService.getById(Long.valueOf(params.documentId))
        def documentBinary = document.datas[Integer.valueOf(params.pageNumber)]
        documentBinary.data = file.bytes
        try {
            documentService.modifyPage(Long.valueOf(params.documentId), documentBinary)
            result.message = message(code:"message.updateDone")
            result.status = 'success'
            result.pageNumber = params.pageNumber
         } catch (CvqModelException cme) {
             result.status = 'warning'
             result.message = message(code: cme.i18nKey)
         }
        
        response.contentType = 'text/html; charset=utf-8'
        render((new JSON(result)).toString())
    }
    
    def documentPage = {
        def document = documentService.getById(Long.valueOf(params.id))
        def page = document.datas[Integer.valueOf(params.pageNumber)]

        response.contentType = "image/png"
        response.outputStream << page.data
    }

    def states = {
        def result = [:]
        def document = documentService.getById(Long.valueOf(params.id));

        def states = documentService.getPossibleTransitions(DocumentState.forString(document.state.toString()))
        
        result.states = []
        for(String s : states) result.states.add(CapdematUtils.adaptCapdematEnum(s, "document.state"))
        
        result.endValidityDate = document.endValidityDate
        result.stateType = document.documentType.name
        result.documentId = document.id
        
        return result;
    }
    
    def documentsList = {
        
        def documents = [], types = [], result = [:], agent = SecurityContext.currentAgent
        Request request = requestSearchService.getById(Long.valueOf(params.requestId), false)
        Set docs = requestDocumentService.getAssociatedDocuments(Long.valueOf(params.requestId))

        for (RequestDocument rd: docs) {
            def d = documentService.getById(rd.documentId);
            types.add(d.documentType.id)
            documents.add([
                "id": d.id,
                "documentTypeId": d.documentType.id,
                "name": message(code: CapdematUtils.adaptDocumentTypeName(d.documentType.name)),
                "endValidityDate": d.endValidityDate,
                "pageNumber": d.datas.size(),
                "state": CapdematUtils.adaptCapdematEnum(d.state, "document.state")
            ])
        }
        
        for(DocumentType t : requestTypeService.getAllowedDocuments(request.requestType.id)) {
            if (!types.contains(t.id)) documents.add([
                "id": 0,"documentTypeId": t.id,
                "name": message(code: CapdematUtils.adaptDocumentTypeName(t.name)),
                "state": ["cssClass": "tag-not_provided", "i18nKey": "document.state.notProvided"]
            ])
        }
        
        result.agentCanWrite = categoryService.hasWriteProfileOnCategory(agent, request.requestType.category.id)
        result.documents = documents
        result.requestId = params.requestId
        result.shortMode = params.shortMode

        return result
    }
    
    def changeState = {
        documentService.updateDocumentState(Long.valueOf(params.documentId),
        		DocumentState.forString(params.state), null, 
        		DateUtils.stringToDate(params.endValidityDate))
        render ([status:"success", message:message(code:"message.updateDone")] as JSON)
    }
    
    def agentNote = {
        def document = documentService.getById(Long.valueOf(params.documentId));
        bind(document)
        documentService.modify(document)
        render([status:"success", message:message(code:"message.updateDone")] as JSON)
    }

    def removeDocument = {
        if (request.getMethod().toLowerCase() == "delete") {
            requestDocumentService.removeDocument(
                requestSearchService.getById(Long.valueOf(params.requestId), false),
                Long.valueOf(params.documentId))
            render ([status:"ok",
                success_msg:message(code:"message.deleteDone")] as JSON)
        }
    }
}
