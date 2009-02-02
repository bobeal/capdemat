import fr.cg95.cvq.business.authority.LocalAuthority
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

class LocalAuthorityController {
    
    ILocalAuthorityRegistry localAuthorityRegistry

    def defaultAction = "setupDrafts"

    def beforeInterceptor = { session["currentMenu"] = "localAuthority" }

    def setupDrafts = {
        def entity = [:]
        
        if (request.get) {
            LocalAuthority localAuthority = SecurityContext.getCurrentSite()
            entity.draftLiveDuration = localAuthority.draftLiveDuration
            entity.draftNotificationBeforeDelete = localAuthority.draftNotificationBeforeDelete
        } else {
            localAuthorityRegistry.updateDraftSettings(
                Integer.parseInt(params.draftLiveDuration),
                Integer.parseInt(params.draftNotificationBeforeDelete)
            )
            entity.draftLiveDuration = params.draftLiveDuration
            entity.draftNotificationBeforeDelete = params.draftNotificationBeforeDelete
            entity.posted = ['state':'success','message':message(code:"message.updateDone")]
        }
        return ["entity":entity]
    }

}