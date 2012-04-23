import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IUserSearchService
import grails.converters.JSON

class ServiceUserController {
    IUserSearchService userSearchService

    /**
     * Send back a JSON object {"connected": false}
     *                      or {"connected": true, "firstname": "Jean", "lastname": "DUPONT"}
     *
     * By default, the JSON object is wrapped in JSONP.
     * But it can be sent as it if we're asked explicitly for JSON (http://…/login.json)
     *
     * See http://jsfiddle.net/HjCc2/6/ for usage.
     */
    def login = {
        def user
        try {
            SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT)
            if (session.currentEcitizenId) {
                SecurityContext.setCurrentEcitizen(session.currentEcitizenId)
                user = userSearchService.getById(session.currentEcitizenId)
            }
        } catch (Exception e) {
            log.error e.message
            render status: 500
        }
        def map
        if (user)
            map = [connected:true, firstname:user.firstName, lastName:user.lastName]
        else
            map = [connected:false]

        withFormat {
            js {
                render text: (params.callback ?: 'callback') + '(' + (map as JSON) + ')',
                       contentType: 'text/javascript',
                       status: 200
            }
            json {
                // Note: '*' can't be used with credentials.
                response.setHeader 'Access-Control-Allow-Origin', request.getHeader('Origin')
                response.setHeader 'Access-Control-Allow-Credentials', 'true'
                render text: map as JSON,
                       contentType: 'application/json',
                       status: 200
            }
        }
    }
}
