import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService

import grails.converters.JSON

class BackofficeRequestArchivesController {

    InstructionService instructionService
    ILocalAuthorityRegistry localAuthorityRegistry
    IRequestActionService requestActionService
    IRequestSearchService requestSearchService
    IRequestTypeService requestTypeService

    def static subMenuEntries = BackofficeRequestAdminController.subMenuEntries

    def beforeInterceptor = {
        session['currentMenu'] = 'requestAdmin'
        if (params.action != "password" && !session.hasAccessToRequestArchives) {
            redirect(action : "password")
        }
    }

    def index = {
        return [
            "archives" :
                localAuthorityRegistry.getLocalAuthorityResourceFileNames(Type.REQUEST_ARCHIVE),
            "subMenuEntries" : subMenuEntries
        ]
    }

    def archive = {
        def file
        if (request.get || !params.archiveIds.class.isArray()) {
            response.contentType = "application/pdf"
            response.setHeader("Content-disposition", "attachment; filename=$params.archiveIds")
            file = requestSearchService.getArchives([params.archiveIds])
        } else {
            response.contentType = "application/zip"
            response.setHeader("Content-disposition", "attachment; filename=archives.zip")
            file = requestSearchService.getArchives(params.archiveIds as List)
        }
        response.contentLength = file.length()
        file.withInputStream { is->
            response.outputStream << is
        }
        response.outputStream.flush()
    }

    def deleteArchives = {
        if (!request.post) return false
        def archiveIds
        if (params.archiveIds.class.isArray()) {
            archiveIds = params.archiveIds as List
        } else {
            archiveIds = [params.archiveIds]
        }
        def failures = requestSearchService.deleteArchives(archiveIds)
        if (failures.isEmpty()) {
            render(["status" : "success", "success_msg" : message(code : "message.deleteDone")] as JSON)
        } else {
            render(["status" : "error", "failures" : failures] as JSON)
        }
    }

    def password = {
        if (request.get) {
            return ["subMenuEntries" : subMenuEntries]
        } else if (request.post) {
            if (requestTypeService.checkArchivesPassword(params.password)) {
                session.hasAccessToRequestArchives = true
                redirect(action : "index")
            } else {
                return ["subMenuEntries" : subMenuEntries]
            }
        } else if (request.method.toLowerCase() == "delete") {
            requestTypeService.generateArchivesPassword()
            render ([status:"success", success_msg:message(code:"requestAdmin.message.archivesPasswordResetDone")] as JSON)
        }
    }

    def history = {
        def actions = requestActionService.adminActions
        def history = []
        actions.each {
            history << [
                "admin" : instructionService.getActionPosterDetails(it.adminId),
                "type" : CapdematUtils.adaptCapdematEnum(it.type, "requestAdminAction.type"),
                "date" : it.date,
                "complementaryData" : it.complementaryData
            ]
        }
        render(template : "history", model : ["history" : history])
    }
}
