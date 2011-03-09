import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.users.MeansOfContactEnum
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.users.IUserNotificationService
import fr.cg95.cvq.security.SecurityContext

import grails.converters.JSON

import org.springframework.web.context.request.RequestContextHolder
import org.xhtmlrenderer.pdf.ITextRenderer

// mostly taken from RequestInstructionController,
// so still dependent on a request
// TODO request decoupling
class BackofficeContactController {

    IRequestLockService requestLockService
    IRequestSearchService requestSearchService
    IRequestTypeService requestTypeService
    IUserNotificationService userNotificationService

    def groovyPagesTemplateEngine
    def individualService
    def individualAdaptorService
    def localAuthorityRegistry
    def meansOfContactService
    def messageSource
    def requestActionService
	def translationService
	def instructionService
	def homeFolderService

    def beforeInterceptor = {
        if (params.requestId) requestLockService.tryToLock(Long.valueOf(params.requestId))
    }

    // directly taken from RequestInstructionController
    // TODO request decoupling
    def panel = {
        if (!request.get) return false
        def rqt
        if (params.requestId)
            rqt = requestSearchService.getById(Long.valueOf(params.requestId), false)
        def user
        if (rqt) {
            if (rqt.requesterId)
                user = individualService.getById(rqt.requesterId)
            else
                user = homeFolderService.getHomeFolderResponsible(rqt.homeFolderId)
        } else {
            user = homeFolderService.getHomeFolderResponsible(Long.valueOf(params.homeFolderId))
        }
        def meansOfContacts = []
        meansOfContactService.getAdultEnabledMeansOfContact(user).each {
            meansOfContacts.add(
                CapdematUtils.adaptCapdematEnum(it.type, "meansOfContact"))
        }
        meansOfContacts.each() {
            it.i18nKey = message(code:it.i18nKey)
        }
        def defaultMeansOfContact = rqt ?
            CapdematUtils.adaptCapdematEnum(rqt.meansOfContact?.type, "meansOfContact") :
            CapdematUtils.adaptCapdematEnum(MeansOfContactEnum.EMAIL, "meansOfContact")
        def requestForms = []
        if (rqt) {
            requestTypeService.getRequestTypeForms(rqt.requestType.id,
                RequestFormType.REQUEST_MAIL_TEMPLATE).each {
                String data = ""
                if (it.personalizedData) data = new String(it.personalizedData)
                requestForms.add([
                    "id": it.id,
                    "shortLabel": it.shortLabel,
                    "type": CapdematUtils.adaptCapdematEnum(it.type, "meansOfContact")
                ])
            }
            rqt = [
                "id" : rqt.id,
                "state": CapdematUtils.adaptCapdematEnum(rqt.state, "request.state")
            ]
        }
        return [
            "meansOfContacts": meansOfContacts,
            "defaultMeansOfContact" : defaultMeansOfContact,
            "requestForms": requestForms,
            "user": user,
            "rqt": rqt
        ]
    }

    def preview = {
        if (!request.post) return false
        if (params.previewFormat == "HTML") {
            response.contentType = "text/html; charset=utf-8"
            render prepareTemplate(params.requestId, params.requestFormId,
                params.templateMessage?.encodeAsHTML(), params.meansOfContact,
                params.previewFormat)
        } else if (params.previewFormat == "PDF") {
            def b = preparePdf(params.requestId, params.requestFormId,
                params.templateMessage, params.meansOfContact)
            response.contentType = "application/pdf"
            response.setHeader("Content-disposition",
                "attachment; filename=letter.pdf")
            response.contentLength = b.length
            response.outputStream << b
            response.outputStream.flush()
        }
    }

    def view = {
        if (!request.get) return false
        response.contentType = "application/pdf"
        response.setHeader("Content-disposition",
            "attachment; filename=letter.pdf")
        def data = requestActionService.getAction(Long.valueOf(params.requestId),
            Long.valueOf(params.requestActionId)).file
        response.contentLength = data.length
        response.outputStream << data
        response.outputStream.flush()
    }

    def contact = {
        if (!request.post) return false
        def notification
        if (params.requestId) {
        // FIXME : no indentation to avoid fake rewriting of this action from git's POV
        def requestId = Long.valueOf(params.requestId)
        def requestFormId
        def requestFormLabel = null
        if (params.requestFormId) {
            requestFormId = Long.valueOf(params.requestFormId)
            def requestForm = requestTypeService.getRequestFormById(requestFormId)
            requestFormLabel = requestForm.getLabel()
        }
        switch (MeansOfContactEnum.forString(params.meansOfContact)) {
            case MeansOfContactEnum.MAIL :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.templateMessage, params.note,
                    params.requestFormId ?
                        preparePdf(params.requestId, params.requestFormId,
                            params.templateMessage, params.meansOfContact) : null, requestFormLabel)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
            case MeansOfContactEnum.EMAIL :
                def pdf
                if (params.requestFormId)
                    pdf = preparePdf(requestId, requestFormId,
                        params.templateMessage, params.meansOfContact)
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.templateMessage, params.note, pdf, requestFormLabel)
                userNotificationService.notifyByEmail(
                    requestSearchService.getById(requestId, false).requestType
                        .category.primaryEmail,
                    params.email,
                    message(code:"mail.ecitizenContact.subject"),
                    params.requestFormId ?
                        message(code:"mail.ecitizenContact.body") :
                        params.templateMessage,
                    pdf,
                    params.requestFormId ?
                        "${requestTypeService.getRequestFormById(requestFormId).label}.pdf"
                        : null)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.emailSent")
                ]
                break;
            case MeansOfContactEnum.HOME_PHONE :
            case MeansOfContactEnum.OFFICE_PHONE :
            case MeansOfContactEnum.MOBILE_PHONE :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    null, params.note, null,null)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
            case MeansOfContactEnum.SMS :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.smsMessage, params.note, null,null)
                userNotificationService.notifyBySms(params.mobilePhone, params.smsMessage)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.smsSent")
                ]
                break;
            case MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.templateMessage, params.note,
                    params.requestFormId ?
                        preparePdf(params.requestId, params.requestFormId,
                            params.templateMessage, params.meansOfContact) : null, requestFormLabel)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
        }
        } else {
            def user = individualService.getById(params.long("id"))
            def moc = MeansOfContactEnum.forString(params.meansOfContact)
            switch (moc) {
                case MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE :
                case MeansOfContactEnum.MAIL :
                    userNotificationService.contact(user, moc, null, params.templateMessage, params.note)
                    notification = [
                        status : "ok",
                        success_msg : message(code : "message.actionTraced")
                    ]
                    break
                case MeansOfContactEnum.EMAIL :
                    userNotificationService.contact(user, moc, params.email, params.templateMessage, params.note)
                    notification = [
                        status : "ok",
                        success_msg : message(code : "message.emailSent")
                    ]
                    break
                case MeansOfContactEnum.HOME_PHONE :
                case MeansOfContactEnum.OFFICE_PHONE :
                case MeansOfContactEnum.MOBILE_PHONE :
                    userNotificationService.contact(user, moc, null, null, params.note)
                    notification = [
                        status : "ok",
                        success_msg : message(code : "message.actionTraced")
                    ]
                    break
                case MeansOfContactEnum.SMS :
                    userNotificationService.contact(user, moc, params.mobilePhone, params.smsMessage, params.note)
                    notification = [
                        status : "ok",
                        success_msg : message(code : "message.smsSent")
                    ]
                    break
            }
        }
        render(notification as JSON)
    }

    private preparePdf(requestId, requestFormId, templateMessage, meansOfContact) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ITextRenderer renderer = new ITextRenderer()
        renderer.setDocumentFromString(prepareTemplate(
            requestId, requestFormId,
            templateMessage?.encodeAsXML().replaceAll(/\n/, "<br />"),
            meansOfContact, "PDF"))
        renderer.layout()
        renderer.createPDF(baos)
        return baos.toByteArray()
    }

    // directly taken from RequestInstructionController
    // TODO request decoupling
    private prepareTemplate(requestId,formId,observations,meansOfContact,type) {

        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        def form = requestTypeService.getRequestFormById(Long.valueOf(formId))
        def rqt = requestSearchService.getById(Long.valueOf(requestId), false)

        // FIXME RDJ - if no requester use homefolder responsible
        def requester
        if (rqt.requesterId != null)
            requester = individualService.getById(rqt.requesterId)
        else
            requester =
                homeFolderService.getHomeFolderResponsible(rqt.homeFolderId)

        def address = requester.getHomeFolder().getAddress()
        def subjectObject = null
        if (rqt.subjectId) {
            subjectObject = individualService.getById(rqt.subjectId)
        }
        def subject =
            individualAdaptorService.getIndividualDescription(subjectObject)
        def forms = []
        forms.add(form)

        def templateFile = localAuthorityRegistry
            .getLocalAuthorityResourceFile(Type.MAIL_TEMPLATES,
                form.getTemplateName(), false)
        if (templateFile.exists()) {

            // FIXME BOR : is there a better way to do this ?
            def logoLink = ""
            def footerLink = ""
            if (type == "PDF") {
                try {
                    logoLink =
                        localAuthorityRegistry.getLocalAuthorityResourceFile(
                            LocalAuthorityResource.LOGO_PDF.id)
                            .absolutePath
                } catch (Exception e) {
                    log.error("Exception while looking for JPEG logo : "
                        + e.getMessage())
                }
                try {
                    footerLink =
                        localAuthorityRegistry.getLocalAuthorityResourceFile(
                            LocalAuthorityResource.FOOTER_PDF.getId())
                            .absolutePath
                } catch (Exception e) {
                    log.error("Exception while looking for JPEG footer : "
                        + e.getMessage())
                }
            }

            def template = groovyPagesTemplateEngine.createTemplate(templateFile);
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make([
                "forms" : forms, "type" : type, "logoLink" : logoLink,
                "footerLink" : footerLink
            ]).writeTo(out);
            requestAttributes.setOut(originalOut)

            String content = out.toString().replace('#{','${')
            def model = [
                "DATE" : DateUtils.dateToFullString(new Date()),
                "LAST_AGENT_NAME" : instructionService.getActionPosterDetails(rqt.lastInterveningUserId),
                "MOC" : message(code : "meansOfContact." + StringUtils.pascalToCamelCase(meansOfContact)),
                "RQ_ID" : rqt.id,
                "RQ_CAT" : rqt.requestType.category.name,
                "RQ_CAT_EMAIL" : rqt.requestType.category.primaryEmail,
                "RQ_TP_LABEL" : type == "HTML" ? 
                    translationService.translateRequestTypeDescription(rqt.requestType.label).toLowerCase().encodeAsHTML() :
                    translationService.translateRequestTypeDescription(rqt.requestType.label).toLowerCase(),
                "RQ_CDATE" : DateUtils.dateToFullString(rqt.creationDate),
                "RQ_DVAL" : rqt.validationDate ? DateUtils.dateToFullString(rqt.validationDate) : '',
                "RQ_OBSERV" : observations,
                "HF_ID" : requester.homeFolder.id,
                "RR_FNAME" : requester.firstName,
                "RR_LNAME" : requester.lastName,
                "RR_TITLE" :
                    messageSource.getMessage(
                        "homeFolder.adult.title.${requester.title.toString().toLowerCase()}",
                        null, SecurityContext.currentLocale),
                "RR_LOGIN" : requester.login,
                "RR_QUESTION" : requester.question,
                "RR_ANSWER" : requester.answer,
                "SU_FNAME" : subject?.firstName,
                "SU_LNAME" : subject?.lastName,
                "SU_TITLE" : subject?.firstName == "" ? "" :
                    messageSource.getMessage("homeFolder.adult.title.${subject?.title.toString().toLowerCase()}",
                        null, SecurityContext.currentLocale),
                "HF_ADDRESS_ADI" : address.additionalDeliveryInformation,
                "HF_ADDRESS_AGI" : address.additionalGeographicalInformation,
                "HF_ADDRESS_SNAME" : address.streetName,
                "HF_ADDRESS_SNUM" : address.streetNumber,
                "HF_ADDRESS_PNS" : address.placeNameOrService,
                "HF_ADDRESS_ZIP" : address.postalCode,
                "HF_ADDRESS_TOWN" : address.city,
                "HF_ADDRESS_CN" : address.countryName
            ]
            model.each { k, v -> if (v == null) model[k] = "" }

            template = groovyPagesTemplateEngine.createTemplate(content, "tmp")
            out = new StringWriter();
            originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make(model).writeTo(out);
            requestAttributes.setOut(originalOut)
            return out.toString()
        } else {
            return ""
        }
    }
}
