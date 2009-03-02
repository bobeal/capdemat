import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService


public class DocumentAdaptorService {
    
    IRequestService defaultRequestService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    
    public getDocumentTypes(IRequestService requestService, Request cRequest, List newDocuments) {
        def requestType = requestService.getRequestTypeByLabel(requestService.getLabel())
        def documentTypes = requestService.getAllowedDocuments(requestType.getId())
        
        def result = [:]
        def documentTypeList = []
        documentTypes.each {
            def associatedDocuments = getAssociatedDocuments(requestService, cRequest, it, newDocuments)
            def docType = ['id':it.id,
                           'name':CapdematUtils.adaptDocumentTypeName(it.name),
                           'associated':associatedDocuments,
                           'provided':getProvidedNotAssociatedDocuments(it , associatedDocuments)]
            documentTypeList.add(docType)
        }
        documentTypeList = documentTypeList.sort { it.name }
        documentTypeList.each { result[it.id] = it }
        return result
    }
    
    public  List getAssociatedDocuments(IRequestService requestService, Request cRequest, DocumentType docType, List newDocuments) {
        // TODO : add a docType parameter to service's method
        def requestDocuments = requestService.getAssociatedDocuments(cRequest)
        def documents = requestDocuments.collect{ documentService.getById(it.documentId) }
        def docTypeDocuments = documents.findAll{ it.documentType.id == docType.id }
        
        def result = []
        docTypeDocuments.each {
            def doc = ['id':it.id,
                       'endValidityDate':it.endValidityDate,
                       'ecitizenNote':it.ecitizenNote,
                       'isNew':newDocuments.contains(it.id) ? true : false]
            result.add(doc)
        }
        return result
    }
    
    public  List getProvidedNotAssociatedDocuments(DocumentType docType, List associateds) {
        // TODO : also use subject id
        def provideds =
            documentService.getProvidedDocuments(docType, SecurityContext.currentEcitizen.homeFolder.id, null)
        def associatedIds = associateds.collect{ it.id }
        return provideds.findAll{ !associatedIds.contains(it.id) }
    }
    
    public getDocument(Long id) {
        def doc = documentService.getById(id)
        def result = [:]
        result.id = doc.id
        result.ecitizenNote = doc.ecitizenNote
        result.datas = []
        doc.datas.each {
            result.datas.add(['id': it.id, 'pageNumber':it.pageNumber])
        }
        return result 
    }
    
    public getDocumentType(Long id) {
        def docType = documentTypeService.getDocumentTypeById(id)
        return ['id':docType.id, 'i18nKey':CapdematUtils.adaptDocumentTypeName(docType.name)]
    }

}
