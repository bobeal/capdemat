import fr.cg95.cvq.business.authority.LocalAuthority
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.business.request.MeansOfContact
import grails.converters.JSON

class LocalAuthorityController {
    
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService

    def defaultAction = "setupDrafts"

    def beforeInterceptor = { 
        session["currentMenu"] = "localAuthority"
        StringUtils.initMetaHelpers()
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
        def result = [means:[]]
        for(MeansOfContact mean : meansOfContactService.availableMeansOfContact) {
            result.means.add(
                'id': mean.id,
                'enabled' : mean.enabled,
                'name' : mean.type.toString().unCapitalize(),
                'status' : mean.enabled ? 'associated' : 'unassociated',
                'verb' : !mean.enabled ? 'associate' : 'unassociate'
            )
        }
        return result
    }
    
    def processMean = {
        def mean = meansOfContactService.getById(Long.valueOf(params.meanId))
        if(params.verb == 'associate') meansOfContactService.enableMeansOfContact(mean)
        else if(params.verb == 'unassociate') meansOfContactService.disableMeansOfContact(mean)
        render ([status:"success", message:message(code:"message.updateDone")] as JSON)
    }
}