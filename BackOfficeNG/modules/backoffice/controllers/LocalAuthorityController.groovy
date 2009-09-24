import fr.cg95.cvq.business.authority.LocalAuthority
import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.business.request.MeansOfContact
import grails.converters.JSON

class LocalAuthorityController {
    
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService

    def localAuthorityResourceAdaptorService

    def defaultAction = "requests"

    def subMenuEntries = [
      'localAuthority.aspect',
      'localAuthority.pdf', 
      "localAuthority.information",
      'localAuthority.identity'
    ]

    def beforeInterceptor = { 
        session["currentMenu"] = "localAuthority"
    }

    def moCs = {
        if (request.get) {
            render(template : "meansOfContact", 
                model : ["moCs" : meansOfContactService.availableMeansOfContact])
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

    def information = {
        if (request.get) {
            def managedMessages = [
                LocalAuthorityResource.INFORMATION_MESSAGE_FO
            ]
            def messages = []
            managedMessages.each {
                def file = localAuthorityRegistry.getLocalAuthorityResourceFile(
                    it.id, false)
                if (!file.exists()) {
                    localAuthorityRegistry.saveLocalAuthorityResource(it.id,
                        "".bytes)
                    file = localAuthorityRegistry.getLocalAuthorityResourceFile(
                        it.id, false)
                }
                messages.add(["id" : it.id, "text" : file.text])
            }
            render(view : "information", model : [
                "subMenuEntries" : subMenuEntries, "messages" : messages
            ])
        } else if (request.post) {
            localAuthorityRegistry.saveLocalAuthorityResource(params.id,
                params.editor.toString().bytes);
            render([
                status:"ok",
                success_msg : message(code : "message.updateDone")
            ] as JSON)
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
        session['currentMenu'] = 'requests'
        if (request.get) {
            return ["subMenuEntries" : ['localAuthority.requests', 'displayGroup.list'],
                    "draftLiveDuration" : SecurityContext.getCurrentSite().draftLiveDuration,
                    "draftNotificationBeforeDelete" : SecurityContext.getCurrentSite().draftNotificationBeforeDelete,
                    "requestsCreationNotificationEnabled" : SecurityContext.getCurrentSite().requestsCreationNotificationEnabled,
                    "documentDigitalizationEnabled" : SecurityContext.getCurrentSite().documentDigitalizationEnabled,
                    "instructionAlertsEnabled" : SecurityContext.getCurrentSite().instructionAlertsEnabled,
                    "instructionAlertsDetailed" : SecurityContext.getCurrentSite().instructionAlertsDetailed,
                    "instructionDefaultMaxDelay" : SecurityContext.getCurrentSite().instructionDefaultMaxDelay,
                    "instructionDefaultAlertDelay" : SecurityContext.getCurrentSite().instructionDefaultAlertDelay,
                    "requestLockMaxDelay" : SecurityContext.currentSite.requestLockMaxDelay]
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
}
