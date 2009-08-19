import grails.converters.JSON
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DepositOrigin
import fr.cg95.cvq.business.document.DepositType
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.business.request.RequestDocument
import fr.cg95.cvq.business.document.DocumentAction
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.authority.Agent
import fr.cg95.cvq.service.authority.ICategoryService

class DocumentInstructionController {
    
    def defaultAction = "edit"
    
    def instructionService
    def documentAdaptorService
    
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IRequestService defaultRequestService
    IRequestTypeService requestTypeService
    ICategoryService categoryService

    
    def edit = {
        def document = [actions:[],documentType:[:]]
        Request request = defaultRequestService.getAndTryToLock(Long.valueOf(params.rid))
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
                "pages": document.id ? documentAdaptorService.getDocument(document.id).datas : []
            ]
        ])
    }
    
    def addPage = {
        def result = [:], file = request.getFile('pageFile')
        
        if((file.contentType =~ /image\/.*/).matches()) {
            Document document = null
            if (params.documentId) {
            	document = documentService.getById(Long.valueOf(params.documentId))
            } else {
                document = new Document()
                Request req = defaultRequestService.getAndTryToLock(Long.valueOf(params.requestId))
                document.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.documentTypeId))
                document.homeFolderId = req.homeFolderId
                document.depositOrigin = DepositOrigin.AGENT
                
                documentService.create(document)
                defaultRequestService.addDocument(req, document.id)
                result.newDocumentId = document.id
            }
            
            DocumentBinary page = new DocumentBinary()
            page.data = file.bytes
            documentService.addPage(Long.valueOf(document.id), page)
            
            result.status = 'success'
            result.documentId = params?.documentId ? '' : document.id
            result.message = message(code:"message.addDone")
            result.pageNumber = document.datas.size() - 1
        } else {
            result.status = 'warning'
            result.message = message(code:"message.fileTypeIsNotSupported")
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
        
        if((file.contentType =~ /image\/.*/).matches()) {
            def document = documentService.getById(Long.valueOf(params.documentId))
            def documentBinary = document.datas[Integer.valueOf(params.pageNumber)]
            documentBinary.data = file.bytes
            documentService.modifyPage(Long.valueOf(params.documentId), documentBinary)
            result.message = message(code:"message.updateDone")
            result.status = 'success'
        } else {
            result.status = 'warning'
            result.message = message(code:"message.fileTypeIsNotSupported")
        }
        
        result.pageNumber = params.pageNumber
        
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
        Request request = defaultRequestService.getAndTryToLock(Long.valueOf(params.rid))
        Set docs = defaultRequestService.getAssociatedDocuments(Long.valueOf(params.rid))

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
        result.requestId = params.rid
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
}
