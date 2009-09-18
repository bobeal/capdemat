import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.RequestFormType
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.security.SecurityContext

import grails.converters.JSON

import org.springframework.web.context.request.RequestContextHolder

// mostly taken from RequestInstructionController,
// so still dependent on a request
// TODO request decoupling
class ContactController {

    def defaultRequestService
    def groovyPagesTemplateEngine
    def individualService
    def individualAdaptorService
    def localAuthorityRegistry
    def meansOfContactService
    def messageSource
    def pdfService
    def requestActionService
    def requestTypeService

    // directly taken from RequestInstructionController
    // TODO request decoupling
    def panel = {
        if (!request.get) return false
        def request =
            defaultRequestService.getAndTryToLock(Long.valueOf(params.id))
        // FIXME RDJ - if no requester use homefolder responsible
        def requester
        if (request.requesterId != null)
            requester = individualService.getById(request.requesterId)
        else
            requester =
                homeFolderService.getHomeFolderResponsible(request.homeFolderId)

        def requesterMeansOfContacts = []
        meansOfContactService.getAdultEnabledMeansOfContact(requester).each {
            requesterMeansOfContacts.add(
                CapdematUtils.adaptCapdematEnum(it.type, "request.meansOfContact"))
        }

        def requestForms = []
        requestTypeService.getRequestTypeForms(request.requestType.id,
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
        if (request.meansOfContact?.type == MeansOfContactEnum.EMAIL)
            defaultContactRecipient = requester.email
        else if (request.meansOfContact?.type == MeansOfContactEnum.SMS)
            defaultContactRecipient = requester.mobilePhone

        requesterMeansOfContacts.each() {
            it.i18nKey = message(code:it.i18nKey)
        }

        return [
            "requesterMeansOfContacts": requesterMeansOfContacts,
            "requestForms": requestForms,
            "defaultContactRecipient": defaultContactRecipient,
            "requester": requester,
            "request": [
                "id" : request.id,
                "state": CapdematUtils.adaptCapdematEnum(request.state,
                    "request.state"),
                "requesterMobilePhone": requester.mobilePhone,
                "requesterEmail": requester.email,
                "meansOfContact": CapdematUtils
                    .adaptCapdematEnum(request.meansOfContact?.type,
                        "request.meansOfContact")
            ]
        ]
    }

    def preview = {
        if (!request.post) return false
        if (params.previewFormat == "HTML") {
            response.contentType = "text/html; charset=utf-8"
            render prepareTemplate(params.requestId, params.requestFormId,
                params.templateMessage?.encodeAsHTML(), params.previewFormat)
        } else if (params.previewFormat == "PDF") {
            def b = preparePdf(params.requestId, params.requestFormId,
                params.templateMessage)
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
        def data = requestActionService.getAction(Long.valueOf(params.requestActionId)).file
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
                    IRequestActionService.REQUEST_CONTACT_CITIZEN,
                    params.templateMessage, params.note,
                    preparePdf(params.requestId, params.requestFormId,
                        params.templateMessage))
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
            case MeansOfContactEnum.EMAIL :
                def pdf =
                    preparePdf(requestId, requestFormId, params.templateMessage)
                requestActionService.addAction(
                    requestId,
                    IRequestActionService.REQUEST_CONTACT_CITIZEN,
                    params.templateMessage, params.note, pdf)
                meansOfContactService.notifyByEmail(
                    defaultRequestService.getById(requestId).requestType
                        .category.primaryEmail,
                    params.email,
                    message(code:"mail.ecitizenContact.subject"),
                    message(code:"mail.ecitizenContact.body"),
                    pdf,
                    "${requestTypeService.getRequestFormById(requestFormId).label}.pdf")
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
                    IRequestActionService.REQUEST_CONTACT_CITIZEN,
                    null, params.note, null)
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
            case MeansOfContactEnum.SMS :
                requestActionService.addAction(
                    requestId,
                    IRequestActionService.REQUEST_CONTACT_CITIZEN,
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
                    IRequestActionService.REQUEST_CONTACT_CITIZEN,
                    params.templateMessage, params.note,
                    preparePdf(params.requestId, params.requestFormId,
                        params.templateMessage))
                notification = [
                    status : "ok",
                    success_msg : message(code : "message.actionTraced")
                ]
                break;
        }
        render(notification as JSON)
    }

    private preparePdf(requestId, requestFormId, templateMessage) {
        return pdfService.htmlToPdf(prepareTemplate(requestId, requestFormId,
            templateMessage?.encodeAsXML().replaceAll(/\n/, "<br />"), "PDF"))
    }

    // directly taken from RequestInstructionController
    // TODO request decoupling
    private prepareTemplate(requestId,formId,message,type) {

        def requestAttributes = RequestContextHolder.currentRequestAttributes()
        def form = requestTypeService.getRequestFormById(Long.valueOf(formId))
        def request =
            defaultRequestService.getAndTryToLock(Long.valueOf(requestId))

        // FIXME RDJ - if no requester use homefolder responsible
        def requester
        if (request.requesterId != null)
            requester = individualService.getById(request.requesterId)
        else
            requester =
                homeFolderService.getHomeFolderResponsible(request.homeFolderId)

        def address = requester.getHomeFolder().getAdress()
        def subjectObject = null
        if (request.subjectId) {
            subjectObject = individualService.getById(request.subjectId)
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
            if (type == "pdf") {
                File logoFile =
                    localAuthorityRegistry.getLocalAuthorityResourceFile("logoPdf", false)
                logoLink = logoFile.absolutePath
            }

            def template = groovyPagesTemplateEngine.createTemplate(templateFile);
            def out = new StringWriter();
            def originalOut = requestAttributes.getOut()
            requestAttributes.setOut(out)
            template.make([
                "forms" : forms, "type" : type, "logoLink" : logoLink
            ]).writeTo(out);
            requestAttributes.setOut(originalOut)

            String content = out.toString().replace('#{','${')
            def model = [
                "DATE" :
                    java.text.DateFormat.getDateInstance().format(new Date()),
                "RQ_ID" : request.id,
                "RQ_TP_LABEL" : request.requestType.label,
                "RQ_CDATE" : request.creationDate,
                "RQ_DVAL" : request.validationDate,
                "RQ_OBSERV" : message,
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
                "SU_TITLE" : subject.firstName == "" ? "" :
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
