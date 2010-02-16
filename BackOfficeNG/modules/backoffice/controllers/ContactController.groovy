import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.security.SecurityContext

import grails.converters.JSON

import org.springframework.web.context.request.RequestContextHolder

// mostly taken from RequestInstructionController,
// so still dependent on a request
// TODO request decoupling
class ContactController {

    IRequestLockService requestLockService
    IRequestSearchService requestSearchService

    def groovyPagesTemplateEngine
    def individualService
    def individualAdaptorService
    def localAuthorityRegistry
    def meansOfContactService
    def messageSource
    def pdfService
    def requestActionService
    def requestTypeService
	def translationService
	def instructionService
	def homeFolderService
	
    // directly taken from RequestInstructionController
    // TODO request decoupling
    def panel = {
        if (!request.get) return false
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(params.id))
        // FIXME RDJ - if no requester use homefolder responsible
        def requester
        if (rqt.requesterId != null)
            requester = individualService.getById(rqt.requesterId)
        else
            requester =
                homeFolderService.getHomeFolderResponsible(rqt.homeFolderId)

        def requesterMeansOfContacts = []
        meansOfContactService.getAdultEnabledMeansOfContact(requester).each {
            requesterMeansOfContacts.add(
                CapdematUtils.adaptCapdematEnum(it.type, "request.meansOfContact"))
        }

        def requestForms = []
        requestTypeService.getRequestTypeForms(rqt.requestType.id,
            RequestFormType.REQUEST_MAIL_TEMPLATE).each {
            String data = ""
            if (it.personalizedData) data = new String(it.personalizedData)

            requestForms.add([
                "id": it.id,
                "shortLabel": it.shortLabel,
                "type": CapdematUtils.adaptCapdematEnum(it.type,
                    "request.meansOfContact")
            ])
        }

        // this task must maybe be done by a service
        def defaultContactRecipient
        if (rqt.meansOfContact?.type == MeansOfContactEnum.EMAIL)
            defaultContactRecipient = requester.email
        else if (rqt.meansOfContact?.type == MeansOfContactEnum.SMS)
            defaultContactRecipient = requester.mobilePhone

        requesterMeansOfContacts.each() {
            it.i18nKey = message(code:it.i18nKey)
        }

        return [
            "requesterMeansOfContacts": requesterMeansOfContacts,
            "requestForms": requestForms,
            "defaultContactRecipient": defaultContactRecipient,
            "requester": requester,
            "rqt": [
                "id" : rqt.id,
                "state": CapdematUtils.adaptCapdematEnum(rqt.state,
                    "request.state"),
                "requesterMobilePhone": requester.mobilePhone,
                "requesterEmail": requester.email,
                "meansOfContact": CapdematUtils
                    .adaptCapdematEnum(rqt.meansOfContact?.type,
                        "request.meansOfContact")
            ]
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
        def requestId = Long.valueOf(params.requestId)
        def requestFormId
        if (params.requestFormId)
            requestFormId = Long.valueOf(params.requestFormId)
        def notification
        switch (MeansOfContactEnum.forString(params.meansOfContact)) {
            case MeansOfContactEnum.MAIL :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.templateMessage, params.note,
                    params.requestFormId ?
                        preparePdf(params.requestId, params.requestFormId,
                            params.templateMessage, params.meansOfContact) : null)
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
                    params.templateMessage, params.note, pdf)
                meansOfContactService.notifyByEmail(
                    requestSearchService.getById(requestId).requestType
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
                    null, params.note, null)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
            case MeansOfContactEnum.SMS :
                requestActionService.addAction(
                    requestId,
                    RequestActionType.CONTACT_CITIZEN,
                    params.smsMessage, params.note, null)
                meansOfContactService.notifyBySms(params.mobilePhone, params.smsMessage)
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
                            params.templateMessage, params.meansOfContact) : null)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
        }
        render(notification as JSON)
    }

    private preparePdf(requestId, requestFormId, templateMessage, meansOfContact) {
        return pdfService.htmlToPdf(prepareTemplate(requestId, requestFormId,
            templateMessage?.encodeAsXML().replaceAll(/\n/, "<br />"), meansOfContact, "PDF"))
    }

    // directly taken from RequestInstructionController
    // TODO request decoupling
    private prepareTemplate(requestId,formId,observations,meansOfContact,type) {

        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        def form = requestTypeService.getRequestFormById(Long.valueOf(formId))
        def rqt = requestLockService.getAndTryToLock(Long.valueOf(requestId))

        // FIXME RDJ - if no requester use homefolder responsible
        def requester
        if (rqt.requesterId != null)
            requester = individualService.getById(rqt.requesterId)
        else
            requester =
                homeFolderService.getHomeFolderResponsible(rqt.homeFolderId)

        def address = requester.getHomeFolder().getAdress()
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
                "MOC" : message(code : "request.meansOfContact." + StringUtils.pascalToCamelCase(meansOfContact)),
                "RQ_ID" : rqt.id,
                "RQ_TP_LABEL" : type == "HTML" ? 
                    translationService.translateRequestTypeDescription(rqt.requestType.label).toLowerCase().encodeAsHTML() :
                    translationService.translateRequestTypeDescription(rqt.requestType.label).toLowerCase(),
                "RQ_CAT" : rqt.requestType.category.name,
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
