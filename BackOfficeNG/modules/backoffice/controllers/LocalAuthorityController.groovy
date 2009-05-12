import fr.cg95.cvq.business.authority.LocalAuthority
import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.business.request.MeansOfContact
import grails.converters.JSON
import org.apache.commons.lang.StringUtils

class LocalAuthorityController {
    
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService

    def localAuthorityResourceAdaptorService

    def defaultAction = "requests"

    def beforeInterceptor = { 
        session["currentMenu"] = "localAuthority"
    }

    def moCs = {
        if (request.get) {
            render(template : "meansOfContact", model : ["moCs" : meansOfContactService.availableMeansOfContact])
        } else if (request.post) {
            def moc = meansOfContactService.getById(Long.valueOf(params.id))
            if(params.enabled == 'true') meansOfContactService.disableMeansOfContact(moc)
            else if (params.enabled == 'false') meansOfContactService.enableMeansOfContact(moc)
            render ([status:"success", message:message(code:"message.updateDone")] as JSON)
        }
    }

    def aspect = {
        def localAuthorityResources = localAuthorityResourceAdaptorService.getLocalAuthorityResources()
        if (request.get) {
            if (params.id) {
                render(template : localAuthorityResources[params.id].template,
                       model : [
                           "subMenuEntries" : subMenuEntries,
                           "id" : params.id,
                           "rand" : UUID.randomUUID().toString(),
                           "hasCurrent" : localAuthorityRegistry.hasLocalAuthorityResource(
                               params.id, LocalAuthorityResource.Version.CURRENT),
                           "currentCode" : LocalAuthorityResource.Version.CURRENT.name(),
                           "hasOld" : localAuthorityRegistry.hasLocalAuthorityResource(
                               params.id, LocalAuthorityResource.Version.OLD),
                           "oldCode" : LocalAuthorityResource.Version.OLD.name()])
                return false
            }
        } else if (request.post) {
            localAuthorityRegistry.replaceLocalAuthorityResource(params.id, request.getFile("content").getBytes())
            response.contentType = 'text/html; charset=utf-8'
            render (new JSON([status:"success", success_msg:message(code:"message.updateDone")]).toString())
            return false
        }
    }

    def pdf = {
        def localAuthorityResources = localAuthorityResourceAdaptorService.getLocalAuthorityResources()
        if (request.get) {
            if (params.id) {
                render(template : localAuthorityResources[params.id].template,
                       model : [
                           "subMenuEntries" : subMenuEntries,
                           "id" : params.id,
                           "hasCurrent" : localAuthorityRegistry.hasLocalAuthorityResource(
                               params.id, LocalAuthorityResource.Version.CURRENT),
                           "currentCode" : LocalAuthorityResource.Version.CURRENT.name(),
                           "hasOld" : localAuthorityRegistry.hasLocalAuthorityResource(
                               params.id, LocalAuthorityResource.Version.OLD),
                           "oldCode" : LocalAuthorityResource.Version.OLD.name()])
                return false
            }
        } else if (request.post) {
            localAuthorityRegistry.replaceLocalAuthorityResource(params.id, request.getFile("content").getBytes())
            response.contentType = 'text/html; charset=utf-8'
            render (new JSON([status:"success", success_msg:message(code:"message.updateDone")]).toString())
            return false
        }
    }

    def identity = {
        if (request.get) {
            def serverNames = SecurityContext.getCurrentSite().serverNames.join("\n")
            return ["subMenuEntries" : subMenuEntries,
                    "postalCode" : SecurityContext.getCurrentSite().postalCode,
                    "displayTitle" : SecurityContext.getCurrentSite().displayTitle,
                    "adminEmail" : SecurityContext.getCurrentSite().adminEmail,
                    "serverNames" : serverNames]
        } else if (request.post) {
            bind(SecurityContext.getCurrentSite())
            def serverNames = new TreeSet()
            params.serverNames.split(["\n"]).each{
                it = it.trim()
                if (!it.isEmpty()) {
                    serverNames.add(it)
                }
            }
            localAuthorityRegistry.setLocalAuthorityServerNames(serverNames)
            render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
            return false
        }
    }

    def requests = {
        if (request.get) {
            return ["subMenuEntries" : subMenuEntries,
                    "draftLiveDuration" : SecurityContext.getCurrentSite().draftLiveDuration,
                    "draftNotificationBeforeDelete" : SecurityContext.getCurrentSite().draftNotificationBeforeDelete,
                    "requestsCreationNotificationEnabled" : SecurityContext.getCurrentSite().requestsCreationNotificationEnabled,
                    "documentDigitalizationEnabled" : SecurityContext.getCurrentSite().documentDigitalizationEnabled,
                    "instructionAlertsEnabled" : SecurityContext.getCurrentSite().instructionAlertsEnabled,
                    "instructionAlertsDetailed" : SecurityContext.getCurrentSite().instructionAlertsDetailed,
                    "instructionDefaultMaxDelay" : SecurityContext.getCurrentSite().instructionDefaultMaxDelay,
                    "instructionDefaultAlertDelay" : SecurityContext.getCurrentSite().instructionDefaultAlertDelay]
        } else if (request.post) {
            bind(SecurityContext.getCurrentSite())
            render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
            return false
        }
    }

    def rollback = {
        localAuthorityRegistry.rollbackLocalAuthorityResource(params.id)
        render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
        return false
    }

    def subMenuEntries = ["requests", "aspect", "pdf", "identity"]

}
