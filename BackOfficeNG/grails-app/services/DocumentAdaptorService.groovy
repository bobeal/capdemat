import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentAction;
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService

/**
 * More than a simple adaptor service :
 *  - support out of account requests
 *  - decouple management of provided documents and new documents
 *  - TODO - refactor DocumentService
 */
public class DocumentAdaptorService {

    def messageSource
    InstructionService instructionService
    RequestAdaptorService requestAdaptorService

    IRequestTypeService requestTypeService
    IRequestDocumentService requestDocumentService
    IDocumentService documentService
    IDocumentTypeService documentTypeService

    def MAX_SIZE_MO = 4
    def MAX_SIZE = MAX_SIZE_MO * 1024 * 1024

    def getDocumentTypes(Request cRequest, String sessionUuid) {
        def documentTypes = requestTypeService.getAllowedDocuments(cRequest.requestType.id)
        def result = [:]
        def documentTypeList = []
        documentTypes.each {
            def providedAssociatedDocs = 
                SecurityContext.currentEcitizen ? getProvidedAssociatedDocuments(cRequest, it) : []
            def newAssociatedDocs = getNewAssociatedDocuments(sessionUuid, it) 
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

    private List getProvidedAssociatedDocuments(Request cRequest, DocumentType docType) {
        def documents = cRequest.documents?.collect { documentService.getById(it.documentId) }
        def docTypeDocuments = documents.findAll { 
            it.documentType.id == docType.id && it.sessionUuid == null
        }
        def result = []
        docTypeDocuments.each {
            result.add(['id':it.id, 'isNew':false,
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
            return provideds.findAll{ !associatedIds.contains(it.id) && it.sessionUuid == null}
        } else return []
    }

    private List getNewAssociatedDocuments(String sessionUuid, DocumentType docType) {
        def documents = documentService.getBySessionUuid(sessionUuid)
        def result = []
        def docTypeDocuments = documents.findAll{
            it.documentType.id == docType.id
        }
        docTypeDocuments.each {
            result.add(['id':it.id, 'isNew':true,
                'endValidityDate':it.endValidityDate, 'ecitizenNote':it.ecitizenNote])
        }

        return result
    }

    def getDocument(id) {
        def doc = documentService.getById(id)
        return adaptDocument(doc)
    }

    def adaptDocument(Document doc) {
        def result = [
            'id' : doc.id,
            'ecitizenNote' : doc.ecitizenNote,
            'datas' : [],
            'documentType' : doc.documentType
        ]

        doc.datas.eachWithIndex { page, index ->
            result['datas'].add(['id': page.id, 'pageNumber': index])
        }

        return result
    }

    def adaptDocumentAction(DocumentAction action) {
        def resultingState = null
        if (action.label.equals(IDocumentService.STATE_CHANGE_ACTION))
            resultingState = "document.state.${StringUtils.pascalToCamelCase(action.resultingState.toString())}"

        return [
            'id': action.id,
            'note': action.note,
            'date': action.date,
            'label':messageSource.getMessage(CapdematUtils.adaptDocumentActionLabel(action.label),null,SecurityContext.currentLocale),
            'agentName': instructionService.getActionPosterDetails(action.agentId),
            'resultingState': resultingState
        ]
    }

    def adaptDocumentType(Long id) {
        def docType = documentTypeService.getDocumentTypeById(id)
        return ['id':docType.id, 'i18nKey':CapdematUtils.adaptDocumentTypeName(docType.name)]
    }

    def addDocumentPage(docId, binaryData) {
        if (binaryData.length == 0 || binaryData.length > MAX_SIZE)
            return getDocument(docId)

        def newDocBinary = new DocumentBinary(binaryData)
        documentService.addPage(docId, newDocBinary)

        return getDocument(docId)
    }

    def modifyDocumentPage(docParam, request) {
        int pageIndex = Integer.valueOf(docParam.dataPageNumber)
        def file = request.getFile('documentData-' + (pageIndex + 1))
        if (file.size == 0 || file.size > MAX_SIZE)
            return getDocument(docParam.id)

        def doc = documentService.getById(docParam.id)
        DocumentBinary newDocBinary = doc.datas[pageIndex]
        newDocBinary.data = file.bytes
        documentService.modifyPage(docParam.id, newDocBinary)
        doc.datas[pageIndex] = newDocBinary

        return adaptDocument(doc)
    }

    def deleteDocumentPage(docParam) {
        def pageNumber = Integer.valueOf(docParam.dataPageNumber)
        documentService.deletePage(docParam.id, pageNumber)

        return getDocument(docParam.id)
    }

    def modifyDocumentNote(docParam, ecitizenNote) {
        Document document = documentService.getById(docParam.id)
        document.ecitizenNote = ecitizenNote
        documentService.modify(document)

        return document
    }
}
