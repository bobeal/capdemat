import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.business.request.MeansOfContact

import grails.converters.JSON

class BackofficeRequestAdminController {

    IMeansOfContactService meansOfContactService
    IRequestTypeService requestTypeService

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
            render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
        }
    }

    def requests = {
        if (request.get) {
            return [
                "subMenuEntries" : subMenuEntries,
                "globalRequestTypeConfiguration" :
                    requestTypeService.getGlobalRequestTypeConfiguration(),
                "documentDigitalizationEnabled" :
                    SecurityContext.getCurrentSite().documentDigitalizationEnabled,
            ]
        } else if (request.post) {
            bind(SecurityContext.getCurrentSite())
            bind(requestTypeService.getGlobalRequestTypeConfiguration())
            render ([status:"success", success_msg:message(code:"message.updateDone")] as JSON)
            return false
        }
    }
}
