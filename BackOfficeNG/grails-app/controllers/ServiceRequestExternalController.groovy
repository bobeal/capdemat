import java.util.Set
import java.text.SimpleDateFormat

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlObject
import org.apache.xmlbeans.XmlOptions

import fr.capwebct.modules.payment.schema.rts.RequestTypeSeasonResponseDocument
import fr.capwebct.modules.payment.schema.rts.RequestTypeSeasonResponseDocument.RequestTypeSeasonResponse

import fr.cg95.cvq.business.document.DepositOrigin
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DocumentType
import fr.cg95.cvq.business.request.LocalReferentialType
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestSeason
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.dao.request.xml.LocalReferentialXml
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.exception.CvqInvalidTransitionException
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential.Data
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.IRequestDocumentService;
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IUserNotificationService
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.util.translation.ITranslationService
import fr.cg95.cvq.xml.common.RequestSeasonType;

class ServiceRequestExternalController {

    IExternalService externalService
    IRequestDocumentService requestDocumentService
    IRequestWorkflowService requestWorkflowService
    IRequestSearchService requestSearchService
    IUserSearchService userSearchService
    IDocumentTypeService documentTypeService
    IDocumentService documentService
    IRequestActionService requestActionService
    IRequestTypeService requestTypeService
    IUserNotificationService userNotificationService
    ITranslationService translationService
    ILocalReferentialService localReferentialService

    // C/C from Provisioning
    // TODO : mutualize, if possible, authentication infrastructure between both after branches merge
    def beforeInterceptor = {
        def authorization = request.getHeader("Authorization")
        if (authorization == null) {
            response.setHeader('WWW-Authenticate', 'Basic')
            render(text: '', status: 401)
            return false
        }
        def credentials = StringUtils.split(new String(Base64.decodeBase64(authorization.substring(6).bytes), "8859_1"), ":")
        if (credentials == null || credentials.length < 2 
                || !externalService.authenticate(credentials[0], credentials[1])) {
            response.setHeader('WWW-Authenticate', 'Basic')
            render(text: '', status: 401)
            return false
        }
        SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT)
        SecurityContext.setCurrentExternalService(credentials[0])
    }

    def requestDocuments = {
        try {
            render(text: requestDocumentService.getAssociatedFullDocuments(params.long('requestId')),
                contentType: 'text/xml', encoding: 'UTF-8', status: 200)
        } catch (CvqObjectNotFoundException confe) {
            render(text: "", status: 404)
        } catch (PermissionException pe) {
            render(text: "", status: 403)
        }
        return false
    }

    def requestDocument = {
        switch(request.method){
            case 'POST':
                Long documentId
                try {
                    Request rqt = requestSearchService.getById(params.long('requestId'), false)
                    Adult requester = userSearchService.getAdultById(rqt.requesterId)

                    DocumentType documentType =
                        documentTypeService.getDocumentTypeByType(params.int('documentTypeId'))
                    Document document = new Document(rqt.homeFolderId, null, documentType,
                        DocumentState.PENDING)
                    document.individualId = rqt.subjectId
                    document.depositOrigin = DepositOrigin.AGENT
                    if (params.endValidityDate != null)
                        document.endValidityDate = new SimpleDateFormat('yyyy-MM-dd').parse(params.endValidityDate)

                    documentId = documentService.create(document)
                    documentService.addPage(documentId, Base64.decodeBase64(params.data.bytes))
                    documentService.validate(documentId, document.endValidityDate, '') // message unused btw
                    document = documentService.getById(documentId)

                    String filename = translationService.translateDocumentTypeName(documentType.name)

                    userNotificationService.notifyByEmail(
                        rqt.requestType.category.primaryEmail,
                        requester.email,
                        message(code: 'mail.ecitizenContact.subject'),
                        message(code: 'mail.ecitizenContact.body'),
                        document.getDatas().get(0).getData(),
                        filename + '.pdf'
                    )

                    requestActionService.addAction(
                        params.long('requestId'),
                        RequestActionType.CONTACT_CITIZEN,
                        '',
                        message(code: 'mail.sentToUserBy') + ' ' + SecurityContext.getCurrentExternalService(),
                        document.getDatas().get(0).getData(),
                        filename + '.pdf'
                    )

                    render(text: filename + '.pdf has been attached to request ' + params.long('requestId'), status: 200)
                } catch (CvqObjectNotFoundException confe) {
                    render(text: message(code: confe.message), status: 404)
                    if (documentId != null)
                        documentService.delete(documentId)
                } catch (PermissionException pe) {
                    // pe is more likely to be a confe converted by an aspect, so we use 404 instead of 403
                    render(text: message(code: pe.message), status: 404)
                    if (documentId != null)
                        documentService.delete(documentId)
                } catch (Exception e) {
                    render(text: message(code: e.message), status: 500)
                    if (documentId != null)
                        documentService.delete(documentId)
                }
                return false
            case 'GET':
                try {
                    render(text: requestDocumentService.getAssociatedDocument(params.long('requestId'),
                        params.long('documentId'), params.mergeDocument ? true : false),
                        contentType: 'text/xml', encoding: 'UTF-8', status: 200)
                } catch (CvqObjectNotFoundException confe) {
                    render(text: '', status: 404)
                } catch (PermissionException pe) {
                    render(text: '', status: 403)
                }
                return false
        }
    }

    // Handling POST. Be careful: non idempotent operation
    def requestState = {
        try {
            String note = message(code: 'request.message.stateChangedBy') + ' ' +
                SecurityContext.getCurrentExternalService() + '.'
            if (params.message != null)
                note += ' ' + message(code: 'request.message.changeReason') + ' ' + params.message
            requestWorkflowService.updateRequestState(params.long('requestId'),
                RequestState.forString(params.state), note)
            render(text: 'Request ' + params.long('requestId') + ' changed to ' + params.state, status: 200)
//        } catch (CvqObjectNotFoundException confe) {
//            render(text: message(code: confe.message), status: 404)
        } catch (CvqInvalidTransitionException cite) {
            render(text: message(code: cite.message), status: 403)
        } catch (PermissionException pe) {
            // pe is more likely to be a confe converted by the aspect, so we use 404 instead of 403
            render(text: message(code: pe.message), status: 404)
        } catch (Exception e) {
            render(text: message(code: e.message), status: 500)
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

    def requestTypeSeason = {
            try {
                RequestType requestType = requestTypeService.getRequestTypeByLabel(params.requestTypeLabel)
                Set<RequestSeason> openSeasons = requestTypeService.getOpenSeasons(requestType)
                RequestTypeSeasonResponseDocument rtsrDocument =
                    RequestTypeSeasonResponseDocument.Factory.newInstance();
                RequestTypeSeasonResponse rtsr = rtsrDocument.addNewRequestTypeSeasonResponse();
                RequestSeasonType[] xmlRequestSeasons = new RequestSeasonType[openSeasons.size()]
                int i = 0
                for (RequestSeason requestSeason : openSeasons) {
                    RequestSeasonType xmlRequestSeason = RequestSeason.modelToXml(requestSeason)
                    xmlRequestSeasons[i] = xmlRequestSeason
                    i++
                }
                rtsr.setSeasonArray(xmlRequestSeasons)
                render(text:rtsrDocument.xmlText(), status:200)
            } catch (CvqObjectNotFoundException confe) {
                render(text: message(code: confe.message), status: 404)
            } catch (PermissionException pe) {
                render(text: message(code: pe.message), status: 403)
            } catch (Exception e) {
                render(text: message(code: e.message), status: 500)
            }
            return false
    }
}
