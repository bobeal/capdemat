import fr.cg95.cvq.business.authority.LocalAuthority
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.business.request.MeansOfContact
import grails.converters.JSON
import org.apache.commons.lang.StringUtils

class LocalAuthorityController {
    
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService

    def defaultAction = "setupDrafts"

    def beforeInterceptor = { 
        session["currentMenu"] = "localAuthority"
    }

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
    
    def meansOfContact = {
        def result = [moCs:[]]
        for(MeansOfContact moc : meansOfContactService.availableMeansOfContact) {
            result.moCs.add(
                'id': moc.id,
                'enabled' : moc.enabled,
                'name' : StringUtils.uncapitalize(moc.type.toString()),
                'status' : moc.enabled ? 'associated' : 'unassociated',
                'verb' : !moc.enabled ? 'associate' : 'unassociate'
            )
        }
        return result
    }
    
    def processMoC = {
        def moc = meansOfContactService.getById(Long.valueOf(params.meanId))
        if(params.verb == 'associate') meansOfContactService.enableMeansOfContact(moc)
        else if(params.verb == 'unassociate') meansOfContactService.disableMeansOfContact(moc)
        render ([status:"success", message:message(code:"message.updateDone")] as JSON)
    }
}