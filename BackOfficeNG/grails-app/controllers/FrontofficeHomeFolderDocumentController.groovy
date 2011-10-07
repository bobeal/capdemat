import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.exception.CvqModelException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.users.IHomeFolderDocumentService

class FrontofficeHomeFolderDocumentController {
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IHomeFolderDocumentService homeFolderDocumentService

    def documentAdaptorService

    def homeFolderId
    def callback

    def beforeInterceptor = {
        homeFolderId = SecurityContext.getCurrentEcitizen().getHomeFolder().id
        session["menu"] = "users"
        Map.metaClass.reduce << { List keys ->
            def reducedMap = [:]
            keys.each {
                if (delegate.get(it) != null)
                    reducedMap.put(it, delegate.get(it))
            }
            return reducedMap
        }
        callback = callback()
    }

    /**
    * Guess a callback url using the "params" map.
    * @return an object [ controller:… action:… params:… ] to redirect to after link / unlink / delete / edit.
    */
   private callback() {
       //Callback defaults to the home folder index.
       def result = [
           'controller' : 'frontofficeHomeFolder',
           'action' : 'index',
           'params' : null ]

       //No other callback used for now…

       return result
   }

    def link = {
        homeFolderDocumentService.link(homeFolderId, Long.valueOf(params.documentId))
        redirect(controller : callback.controller, action : callback.action, params : callback.params)
    }

    def unlink = {
        homeFolderDocumentService.unlink(homeFolderId, Long.valueOf(params.documentId))
        redirect(controller : callback.controller, action : callback.action, params : callback.params)
    }

    def delete = {
        documentService.delete(Long.valueOf(params.documentId))
        redirect(controller : callback.controller, action : callback.action, params : callback.params)
    }

    def replace = {
        homeFolderDocumentService.unlink(homeFolderId, Long.valueOf(params.documentId))
        redirect(action : 'edit', params : [
            'documentTypeId' : params.documentTypeId
        ].plus(callback.params ? callback.params : [:]))
    }

    /**
     * GET: view to edit document pages (add / delete pages)
     *
     * POST: post selected document, or new / edited document.
     */
    def edit = {
        def document = params.documentId ? documentAdaptorService.getDocument(Long.valueOf(params.documentId)) : null
        def documentType = documentAdaptorService.adaptDocumentType(Long.valueOf(params.documentTypeId))

        if (request.get) {

        //TODO return different views based on callback.
        return [
                'document' : document,
                'documentType' : documentType,
                'documentsByTypes' : documentAdaptorService.homeFolderDocumentsByType(homeFolderId),
                'callback' : callback
            ]
        }
        else if (request.post) {
            try {
                if (document == null) {
                    if (request.getFile('documentData-0').empty)
                        throw new CvqModelException('document.error.mustHaveAtLeastOnePage')
                    document = new Document(homeFolderId,
                        params.ecitizenNote,
                        documentTypeService.getDocumentTypeById(Long.valueOf(params.documentTypeId)),
                        DocumentState.PENDING)
                    documentService.create(document)
                    homeFolderDocumentService.link(homeFolderId, document.id)
                }
                document.ecitizenNote = params.ecitizenNote
                //Update existing page
                document.datas.eachWithIndex { data, index ->
                    documentService.modifyPage(document.id, index, request.getFile('documentData-' + index)?.bytes)
                }
                //Add new page
                def index = document.datas?.isEmpty() ? 0 : document.datas.size()
                documentService.addPage(document.id, request.getFile('documentData-' + index)?.bytes)
            } catch (CvqModelException e) {
                flash.errorMessage = message(code : e.i18nKey, args : e.i18nArgs as List)
            }

            redirect(action : 'edit', params : [
                'documentId' : document?.id,
                'documentTypeId' : documentType.id
            ].plus(callback.params ? callback.params : [:]))
        }
    }

    def deletePage = {
        documentService.deletePage(Long.valueOf(params.documentId), Integer.valueOf(params.pageIndex))
        redirect(action : 'edit', params : [
            'documentId' : params.documentId,
            'documentTypeId' : params.documentTypeId
        ].plus(callback.params ? callback.params : [:]))
    }
}
