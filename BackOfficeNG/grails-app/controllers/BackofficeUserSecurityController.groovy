import fr.cg95.cvq.service.users.IUserSecurityService
import fr.cg95.cvq.business.users.UserSecurityProfile
import fr.cg95.cvq.business.users.UserSecurityRule

import grails.converters.JSON

class BackofficeUserSecurityController {

    IUserSecurityService userSecurityService

    def beforeInterceptor = {
        session["currentMenu"] = "users"
    }

    def defaultAction = "index"
    def subMenuEntries = ["userSecurity.index", "homeFolder.meansOfContact", "homeFolder.importHomeFolders"]

    def index = {
        return [
            "subMenuEntries" : subMenuEntries,
            "view": "allowed",
            "agents": userSecurityService.listAgents(true),
            "mapRules" : userSecurityService.mapRules()
        ]
    }

    def agents = {
        render( template: "agents", model: [
            "view": params.view, 
            "agents": userSecurityService.listAgents(params.view == "allowed"),
            "mapRules" : userSecurityService.mapRules()
        ])
    }

    def agent = {
        def rule = userSecurityService.getRule(Long.valueOf(params.id))
        render(template: "agent", model: [
            "securityRule": rule != null ? rule : new UserSecurityRule(Long.valueOf(params.id), null),
            "profiles": UserSecurityProfile.writer
         ])
    }

    def allow = {
        userSecurityService.allow(Long.valueOf(params.id), UserSecurityProfile.forString(params.profile))
        render ([status:"success", "message":message(code:"message.updateDone")] as JSON)
    }

    def disallow = {
        userSecurityService.disallow(Long.valueOf(params.id))
        render ([status:"success", "message":message(code:"message.updateDone")] as JSON)
    }

}
