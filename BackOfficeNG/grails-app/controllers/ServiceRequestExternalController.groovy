import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestDocumentService;

class ServiceRequestExternalController {
    
    IExternalService externalService
    IRequestDocumentService requestDocumentService
    
    // C/C from Provisioning
    // TODO : mutualize, if possible, authentication infrastructure between both after branches merge
    def beforeInterceptor = {
        def authorization = request.getHeader("Authorization")
        if (authorization == null) {
            response.setHeader("WWW-Authenticate", "Basic")
            render(text: "", status : 401)
            return false
        }
        def credentials = StringUtils.split(new String(Base64.decodeBase64(authorization.substring(6).bytes), "8859_1"), ":")
        if (credentials == null || credentials.length < 2 
                || !externalService.authenticate(credentials[0], credentials[1])) {
            response.setHeader("WWW-Authenticate", "Basic")
            render(text: "", status : 401)
            return false
        }
        SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT)
        SecurityContext.setCurrentExternalService(credentials[0])
    }

    def requestDocuments = {
        try {
            render(text:requestDocumentService.getAssociatedFullDocuments(params.long('requestId')), 
                contentType:"text/xml",encoding:"UTF-8", status: 200)
        } catch (CvqObjectNotFoundException confe) {
            render(text: "", status: 404)
        } catch (PermissionException pe) {
            render(text: "", status: 403)
        }

        return false
    }
    
    def requestDocument = {
            try {
                render(text:requestDocumentService.getAssociatedDocument(params.long('requestId'),
                    params.long('documentId'), params.mergeDocument ? true : false), 
                    contentType:"text/xml",encoding:"UTF-8", status: 200)
            } catch (CvqObjectNotFoundException confe) {
                render(text: "", status: 404)
            } catch (PermissionException pe) {
                render(text: "", status: 403)
            }

            return false
    }
}
