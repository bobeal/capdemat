import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.business.document.DepositOrigin
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.external.IExternalService
import fr.cg95.cvq.exception.CvqObjectNotFoundException
import fr.cg95.cvq.security.PermissionException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.users.IUserNotificationService
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService
import fr.cg95.cvq.util.translation.ITranslationService
import java.text.SimpleDateFormat
import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils

class ServiceHomeFolderExternalController {

    IUserSearchService userSearchService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    ITranslationService translationService
    ILocalAuthorityRegistry localAuthorityRegistry
    IExternalHomeFolderService externalHomeFolderService
    IExternalService externalService
    IUserNotificationService userNotificationService

    def beforeInterceptor = {
        def authorization = request.getHeader("Authorization")
        if (authorization == null) {
            response.setHeader('WWW-Authenticate', 'Basic')
            render(text: 'Authentication required', status: 401)
            return false
        }
        def credentials = StringUtils.split(new String(Base64.decodeBase64(authorization.substring(6).bytes), "UTF-8"), ":")
        if (credentials == null || credentials.length < 2
                || !externalService.authenticate(credentials[0], credentials[1])) {
            response.setHeader('WWW-Authenticate', 'Basic')
            render(text: 'Credentials do not match', status: 401)
            return false
        }
        SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT)
        SecurityContext.setCurrentExternalService(
            externalService.getExternalServiceByLogin(credentials[0]).getLabel())
    }

    /**
     * curl -v -i -X POST -u"login:pass" -F "documentTypeId=42" -F "data=@file.pdf" http://localhost:8080/CapDemat/service/homefolder/c2f4d616-4c8e-457d-ae30-b47b3b07ca56/document
     */
    def addDocument = {
        if (!request.getHeader("Content-Type")?.toLowerCase().contains("multipart/form-data")) {
            render(text: 'Bad content-type : multipart/form-data required.', status: 401)
            return false
        }
        def docId = null
        try {
            def ext_hf_id = params.get('externalHomeFolderId')

            def hf_mapping = externalHomeFolderService.getHomeFolderMapping(
                SecurityContext.getCurrentExternalService(), ext_hf_id)

            if (hf_mapping == null) {
                throw new CvqObjectNotFoundException("No home folder with external id : " + ext_hf_id)
            }

            def hf_id = hf_mapping.getHomeFolderId()

            String ecitizenNote = params.ecitizenNote != null ? params.ecitizenNote : ""

            DocumentType documentType = documentTypeService.getDocumentTypeByType(params.int('documentTypeId'))
            if (documentType == null) {
                throw new CvqObjectNotFoundException("No document type with id:"+params.int('documentTypeId'))
            }

            log.debug("adding new document of type "+documentType.getId()+" to home folder "+ext_hf_id)

            Document document = new Document(hf_id, ecitizenNote, documentType, DocumentState.PENDING)
            document.depositOrigin = DepositOrigin.EXTERNAL

            if (params.endValidityDate != null){
                document.endValidityDate = new SimpleDateFormat('yyyy-MM-dd').parse(params.endValidityDate)
            }

            if(params.agentNote != null) {
                document.setAgentNote(params.agentNote);
            }

            docId = this.documentService.create(document)

            def data = request.getFile("data").getBytes()
            log.debug("data length : " + data.length)
            documentService.addPage(docId, data)

            documentService.validate(docId, document.endValidityDate, '')

            String filename = translationService.translateDocumentTypeName(documentType.name)

            userNotificationService.notifyByEmail(
                null,
                userSearchService.getHomeFolderResponsible(hf_id).email,
                message(code: 'mail.ecitizenContact.subject'),
                message(code: 'mail.ecitizenContact.body'),
                document.getDatas().get(0).getData(),
                filename + '.pdf'
            )

           log.debug(filename + '.pdf has been attached to home folder ' + hf_id)

            render(text: filename + '.pdf has been attached to home folder ' + ext_hf_id, status: 201)
        } catch (CvqObjectNotFoundException confe) {
            log.error("Unable to find some object(s), parameters : HomeFolder = "+params.get("homeFolderId")+", documentTypeId = "+params.get("documentTypeId"))
            render(text: message(code: confe.message), status: 404)
            if (docId != null)
                documentService.delete(docId)
        } catch (PermissionException pe) {
            log.error("Not enough rights to process")
            render(text: message(code: pe.message), status: 403)
            if (docId != null)
                documentService.delete(docId)
        } catch (Exception e) {
            log.error("Unexpected error, parameters : HomeFolder = "+params.get("homeFolderId")+", documentTypeId = "+params.get("documentTypeId"))
            render(text: message(code: e.message), status: 500)
            if (docId != null)
                documentService.delete(docId)
        }
        return false
    }
}
