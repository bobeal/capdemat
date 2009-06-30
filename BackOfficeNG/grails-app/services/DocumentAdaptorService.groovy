import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.business.document.DocumentBinary

/* More than a simple adaptor service.
 *  - manage serialization / deserialisation of new document in capdemat request creation
 *  - support out of account capdemat request
 *  - decouple management of provided documents and new documents
 *  - TODO - refactor capdemat DocumentService
 */
public class DocumentAdaptorService {

    def messageSource
    def instructionService
    def requestAdaptorService
    
    IRequestTypeService requestTypeService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    
    def servletContext
    
    private getServletContext (context) {
        this.servletContext = context
    }
    
    def getDocumentTypes(IRequestService requestService, Request cRequest, String sessionUuid, Set newDocuments) {
        def requestType = requestTypeService.getRequestTypeByLabel(requestService.getLabel())
        def documentTypes = requestTypeService.getAllowedDocuments(requestType.getId())
        def result = [:]
        def documentTypeList = []
        documentTypes.each {             
            def providedAssociatedDocs = getProvidedAssociatedDocuments(requestService, cRequest, it)
            def newAssociatedDocs = getNewAssociatedDocuments(sessionUuid, newDocuments, it) 
            def docType = ['id':it.id,
                           'name':messageSource.getMessage(CapdematUtils.adaptDocumentTypeName(it.name),null,SecurityContext.currentLocale),
                           'associated':providedAssociatedDocs + newAssociatedDocs,
                           'provided':getProvidedNotAssociatedDocuments(it , providedAssociatedDocs)]
            documentTypeList.add(docType)
        }
        documentTypeList = documentTypeList.sort { it.name }
        documentTypeList.each {
            result[it.id] = it
            if (it.associated.isEmpty()
                && cRequest.stepStates != null && cRequest.stepStates.get('document') != null)
                requestAdaptorService.stepState(cRequest.stepStates.get('document'), 'uncomplete', '')
        }
        return result
    }
    
    private List getProvidedAssociatedDocuments(IRequestService requestService, Request cRequest, DocumentType docType) {
        // TODO : add a docType parameter to service's method
        def requestDocuments = requestService.getAssociatedDocuments(cRequest)
        def documents = requestDocuments.collect{ documentService.getById(it.documentId) }
        def docTypeDocuments = documents.findAll{ it.documentType.id == docType.id }
        def result = []
        docTypeDocuments.each {
            result.add(['id':it.id, 'isNew':false,
                        'endValidityDate':it.endValidityDate, 'ecitizenNote':it.ecitizenNote])
        }
        return result
    }
    
    private List getNewAssociatedDocuments(String sessionUuid, Set newDocuments, DocumentType docType) {
        def result = []
        def documents = deserializeDocuments(newDocuments, sessionUuid)
        def docTypeDocuments = documents.findAll{ it.documentType.id == docType.id }
        docTypeDocuments.each {
            result.add(['id':it.id, 'isNew':true,
                        'endValidityDate':it.endValidityDate, 'ecitizenNote':it.ecitizenNote])
        }
        return result
    }
    
    private List getProvidedNotAssociatedDocuments(DocumentType docType, List associateds) {
        // TODO : also use subject id
        if (SecurityContext.currentEcitizen) {
            def provideds =
                documentService.getProvidedDocuments(docType, SecurityContext.currentEcitizen.homeFolder.id, null)
            def associatedIds = associateds.collect{ it.id }
            return provideds.findAll{ !associatedIds.contains(it.id) }
        } else return []
    }
    
    def hasAssociatedDocuments(IRequestService requestService, Request cRequest, String sessionUuid, Set newDocuments) {
        def providedAssociatedDocuments = requestService.getAssociatedDocuments(cRequest)
        if (providedAssociatedDocuments == null) providedAssociatedDocuments = [] 
        def newAssociatedDocuments = deserializeDocuments(newDocuments, sessionUuid)
        return ((newAssociatedDocuments + providedAssociatedDocuments).size() > 0)
    }
    
    def getDocument(id, sessionUuid) {
        def doc = deserializeDocument(id, sessionUuid)
        if (doc == null) return [:]
        else return adaptDocument(doc)
    }
    
    def getDocument(id) {
    	def doc = documentService.getById(id)
    	return adaptDocument(doc)
    }
    
    def adaptDocument(doc) {
        def result = [:], pageNumber = 0
        result.id = doc.id
        result.ecitizenNote = doc.ecitizenNote
        result.datas = []
        result.documentType = doc.documentType
        
        for(DocumentBinary page : doc.datas) {
            result.datas.add(['id': page.id, 'pageNumber': pageNumber])
            pageNumber ++
        }
        return result
    }
    
    def adaptDocumentAction(action) {
        def resultingState = null
        if (action.label.equals(IDocumentService.STATE_CHANGE_ACTION)) {
            resultingState = "document.state.${StringUtils.pascalToCamelCase(action.resultingState.toString())}"
        }
        return [
            'id': action.id,
            'note': action.note,
            'date': action.date,
            'label':messageSource.getMessage(CapdematUtils.adaptDocumentActionLabel(action.label),null,SecurityContext.currentLocale),
            'agentName': instructionService.getActionPosterDetails(action.agentId),
            'resultingState': resultingState
        ]
    }
    
    def getDocumentType(Long id) {
        def docType = documentTypeService.getDocumentTypeById(id)
        return ['id':docType.id, 'i18nKey':CapdematUtils.adaptDocumentTypeName(docType.name)]
    }
    
    def addDocumentPage(docParam, doc, request, sessionUuid) {
        if (docParam.id != null)
            doc = deserializeDocument(docParam.id, sessionUuid)
        
        def newDocBinary = new DocumentBinary()
        newDocBinary.data = request.getFile('documentData-0').bytes
        doc.datas.add(newDocBinary)
        serializeDocument(doc, sessionUuid)
        return getDocument(doc.id, sessionUuid)
    }
    
    def modifyDocumentPage(docParam, request, sessionUuid) {
        def doc = deserializeDocument(docParam.id, sessionUuid)
        def newDocBinary = doc.datas.get(Integer.parseInt(docParam.dataPageNumber))
        
        newDocBinary.data = request.getFile('documentData-' + (Integer.valueOf(docParam.dataPageNumber) + 1)).bytes
        doc.datas[Integer.parseInt(docParam.dataPageNumber)] = newDocBinary
        
        serializeDocument(doc, sessionUuid)
        return adaptDocument(doc)
    }
    
    def deleteDocument(docId, sessionUuid) {
        def tmpSessionPath = servletContext['javax.servlet.context.tempdir'].absolutePath + '/' + sessionUuid
        def docFile = new File(tmpSessionPath + '/document-' + docId)
        if (docFile.exists())
            docFile.delete()
    }
    
    def serializeDocument (doc, sessionUuid) {
        def tmpSessionPath = servletContext['javax.servlet.context.tempdir'].absolutePath + '/' + sessionUuid
        def sessionDir = new File(tmpSessionPath)
        if (!sessionDir.exists())  sessionDir.mkdir()
        
        new File(tmpSessionPath + '/document-' + doc.id).withObjectOutputStream { out ->
            out << doc
        }
    }
    
    def deserializeDocument(docId, sessionUuid) {
        def tmpSessionPath = servletContext['javax.servlet.context.tempdir'].absolutePath + '/' + sessionUuid
        def doc
        def docFile = new File(tmpSessionPath + '/document-' + docId)
        if (docFile.exists()) {
            docFile.withObjectInputStream { instream ->
                instream.eachObject {
                    doc = it
                }
            }
        }
        return doc
    }
    
    def deserializeDocuments(docIds, sessionUuid) {
        def documents = []
        docIds.each {
            def doc = deserializeDocument(it, sessionUuid)
            if (doc != null) documents.add(doc)
        }
        return documents
    }

}
