import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlObject
import org.apache.xmlbeans.XmlOptions

import fr.cg95.cvq.business.request.LocalReferentialType
import fr.cg95.cvq.dao.request.xml.LocalReferentialXml
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential.Data
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestDocumentService;

class ServiceRequestExternalController {
    
    IExternalService externalService
    IRequestDocumentService requestDocumentService
    ILocalReferentialService localReferentialService

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

    def localReferential = {
        XmlOptions xmlOptions = new XmlOptions().setDocumentType(LocalReferentialDocument.type)
        LocalReferential lr
        try {
            lr = (LocalReferential)XmlObject.Factory.parse(params.data.getInputStream(), xmlOptions).changeType(LocalReferential.type)
        } catch (Exception e) {
            render(text: "Unable to parse XML.", status: 400)
            return false
        }
        ArrayList<Object> validationErrors = new ArrayList<Object>()
        XmlOptions validationOptions = new XmlOptions()
        validationOptions.setErrorListener(validationErrors)
        if (!lr.validate(validationOptions)) {
            render(text: "XML is not valid.", status: 400)
            return false
        }
        Data data = lr.getDataArray(0);
        LocalReferentialType lrt = LocalReferentialXml.xmlToModel(data)
        lrt.setManager(SecurityContext.getCurrentExternalService())
        try {
            localReferentialService.saveLocalReferentialType(params.requestTypeLabel, lrt)
            render(text: 'Local referential updated for "' + params.requestTypeLabel + '".', status:200)
        } catch (PermissionException pe) {
            render(text: message(code: pe.message), status: 403)
        } catch (CvqException ce) {
            render(text: message(code: ce.message), status: 500)
        }
        return false
    }
}
