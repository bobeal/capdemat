import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.exception.CvqModelException

class FrontofficeRequestDocumentController {

    IRequestLockService requestLockService
    IRequestSearchService requestSearchService
    IRequestDocumentService requestDocumentService
    IDocumentService documentService
    IDocumentTypeService documentTypeService

    DocumentAdaptorService documentAdaptorService
    RequestTypeAdaptorService requestTypeAdaptorService

    // TODO : Must we update rqt.stepState.document as far as document step id is optionnal
    def edit = {
        def rqt = getAndLockRequest()
        if (request.get) {
            def documentType = documentAdaptorService.adaptDocumentType(Long.valueOf(params.documentTypeId))
            def document = params.documentId ? documentAdaptorService.getDocument(Long.valueOf(params.documentId)) : null
            def requestTypeResources = requestTypeAdaptorService.requestTypeResources(rqt.requestType.label)
            render(view: "/frontofficeRequestType/${requestTypeResources.requestTypeLabelAsDir}/edit", model: [
                'isRequestCreation': true,
                'rqt': rqt,
                'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
                'currentStep': 'document',
                'documentTypes': documentAdaptorService.getDocumentTypes(rqt),
                'document': document,
                'documentType': documentType,
                'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                'isEdition' : !RequestState.DRAFT.equals(rqt.state)
            ].plus(requestTypeResources))
        }
        else if (request.post) {
            def document = params.documentId ? documentService.getById(Long.valueOf(params.documentId)) : null
            def documentType = documentTypeService.getDocumentTypeById(Long.valueOf(params.documentTypeId))
            try {
                if (document == null) {
                    if (request.getFile('documentData-0').empty)
                        throw new CvqModelException('document.error.mustHaveAtLeastOnePage')
                    document = new Document(SecurityContext.currentEcitizen?.homeFolder?.id,
                        params.ecitizenNote, documentType)
                    documentService.create(document)
                    requestDocumentService.addDocument(rqt, document.id)
                }
                document.ecitizenNote = params.ecitizenNote
                // update existing page
                document.datas.eachWithIndex { data, index ->
                    documentService.modifyPage(document.id, index, request.getFile('documentData-' + index)?.bytes)  
                }
                // add new page
                def index = document.datas?.isEmpty() ? 0 : document.datas.size()
                documentService.addPage(document.id, request.getFile('documentData-' + index)?.bytes)
            } catch (CvqModelException e) {
                flash.errorMessage = message(code : ExceptionUtils.getModelI18nKey(e))
            }
            if (params.saveAndBackDocument) {
                redirect(controller:'frontofficeRequest', action:'edit', params:[
                    'id':rqt.id, 'currentStep': 'document'])
            } else {
                redirect(action:'edit', params:[
                    'requestId':rqt.id, 'documentTypeId':documentType.id, 'documentId': document?.id])
            }
        }
    }

    def deletePage = {
        def document = documentService.getById(Long.valueOf(params.documentId))
        documentService.deletePage(document.id, Integer.valueOf(params.pageIndex))
        redirect(action:'edit', params:[
            'requestId':params.requestId, 'documentTypeId':params.documentTypeId, 'documentId': document.id])
    }

    def delete = {
        requestDocumentService.removeDocument(getAndLockRequest(), Long.valueOf(params.documentId))
        documentService.delete(Long.valueOf(params.documentId))
        redirect(controller:'frontofficeRequest', action:'edit', params:[
            'id':params.requestId, 'currentStep': 'document'])
    }

    def associate = {
        requestDocumentService.addDocument(getAndLockRequest(), Long.valueOf(params.documentId))
        redirect(controller:'frontofficeRequest', action:'edit', params:[
            'id':params.requestId, 'currentStep': 'document'])
    }

    def unassociate = {
        requestDocumentService.removeDocument(getAndLockRequest(), Long.valueOf(params.documentId))
        redirect(controller:'frontofficeRequest', action:'edit', params:[
            'id':params.requestId, 'currentStep': 'document'])
    }

    def getAndLockRequest() {
        def requestId = Long.valueOf(params.requestId)
        requestLockService.lock(requestId)
        return requestSearchService.getById(requestId, true)
    }
}
