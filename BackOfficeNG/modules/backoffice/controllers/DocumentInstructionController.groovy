import grails.converters.JSON
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DepositOrigin
import fr.cg95.cvq.business.document.DepositType
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.business.request.RequestDocument

class DocumentInstructionController {
    
    def defaultAction = "edit"
    def beforeInterceptor = {}
    
    def instructionService
    def documentAdaptorService
    
    IDocumentService documentService;
    IDocumentTypeService documentTypeService;
    IRequestService defaultRequestService;

    
    def edit = {
        def document = [actions:[],documentType:[:]]
        //Request request = defaultRequestService.getById(Long.valueOf(params.rid))
        
        if(!params?.id || Integer.valueOf(params.id) == 0) {
            def documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.dtid))
            document.documentType.name = documentType.name
            document.state = DocumentState.PENDING
            document.depositOrigin = DepositOrigin.AGENT
            document.depositType = DepositType.PC
            document.datas = []
//            document.homeFolderId = request.homeFolderId
        } else {
            document = documentService.getById(Long.valueOf(params.id))
        }

        def actions = []
        document.actions.each {
            actions.add([
                "id": it.id,
                "note": it.note,
                "date": it.date,
                "label": it.label,
                "agentName": instructionService.getActionPosterDetails(it.agentId),
                "resultingState": CapdematUtils.adaptCapdematEnum(it.resultingState, "document.state")
            ])
        }
        
        return ([
            "uuid" : UUID.randomUUID().toString(),
            "document": [
                "id": document.id,
                "actions": actions,
                "name": message(code:CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
                "state": CapdematUtils.adaptCapdematEnum(document.state, "document.state"),
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
        DocumentBinary page = new DocumentBinary()
        Document document = null
        
        if((file.contentType =~ /image\/.*/).matches()) {
            if (params.documentId)  document = documentService.getById(Long.valueOf(params.documentId))
            else {
                document = new Document()
                Request req = defaultRequestService.getById(Long.valueOf(params.requestId))
                document.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.documentTypeId))
                document.homeFolderId = req.homeFolderId
                document.state = DocumentState.PENDING
                document.depositOrigin = DepositOrigin.AGENT
                
                documentService.create(document)
                defaultRequestService.addDocument(req, document.id)
                result.newDocumentId = document.id
            }
            
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
        def document = documentService.getById(Long.valueOf(params.documentId))
        document.datas.remove(Integer.valueOf(params.pageNumber))
        render ([status:"success", message:message(code:"message.deleteDone")] as JSON)
    }
    
    def modifyPage = {
        def result = [:], file = request.getFile('pageFile')
        
        if((file.contentType =~ /image\/.*/).matches()) {
            def document = documentService.getById(Long.valueOf(params.documentId))
            document.datas[Integer.valueOf(params.pageNumber)].data = file.bytes
            documentService.modify(document)
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

    def documentStates = {
        def stateAsString = StringUtils.toPascalCase(params.stateCssClass.replace("tag-", ""))

        def transitionStates =
            documentService.getPossibleTransitions(DocumentState.forString(stateAsString))

        def states = []
        transitionStates.each {
            states.add(CapdematUtils.adaptCapdematEnum(it, "document.state"))
        }

        render(template: "documentStates",
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
    
    def documentList = {
        
        def documents = [], types = [], result = [:]
        Request request = defaultRequestService.getById(Long.valueOf(params.rid))
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
        
        for(DocumentType t : defaultRequestService.getAllowedDocuments(request.requestType.id)) {
            if (!types.contains(t.id)) documents.add([
                "id": 0,"documentTypeId": t.id,
                "name": message(code: CapdematUtils.adaptDocumentTypeName(t.name)),
                "state": ["cssClass": "tag-not_provided", "i18nKey": "document.state.notProvided"]
            ])
        }
        
        result.documents = documents
        return result
    }
}
