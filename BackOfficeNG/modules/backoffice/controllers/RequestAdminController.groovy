import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.business.request.MeansOfContact

import grails.converters.JSON

class RequestAdminController {

    IMeansOfContactService meansOfContactService

    def defaultAction = 'requests'
        
    def subMenuEntries = [
        'requestAdmin.requests',
        'displayGroup.list'
    ]

    def beforeInterceptor = { 
        session['currentMenu'] = 'requestAdmin'
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

    def requests = {
        if (request.get) {
        	def currentSite = SecurityContext.getCurrentSite()
            return ["subMenuEntries" : subMenuEntries,
                    "draftLiveDuration" : currentSite.draftLiveDuration,
                    "draftNotificationBeforeDelete" : currentSite.draftNotificationBeforeDelete,
                    "requestsCreationNotificationEnabled" : currentSite.requestsCreationNotificationEnabled,
                    "documentDigitalizationEnabled" : currentSite.documentDigitalizationEnabled,
                    "instructionAlertsEnabled" : currentSite.instructionAlertsEnabled,
                    "instructionAlertsDetailed" : currentSite.instructionAlertsDetailed,
                    "instructionDefaultMaxDelay" : currentSite.instructionDefaultMaxDelay,
                    "instructionDefaultAlertDelay" : currentSite.instructionDefaultAlertDelay,
                    "requestLockMaxDelay" : currentSite.requestLockMaxDelay]
        } else if (request.post) {
            bind(SecurityContext.getCurrentSite())
            render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
            return false
        }
    }
}
