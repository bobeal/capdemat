import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;
import fr.cg95.cvq.oauth2.InsufficientScopeException;

import grails.converters.JSON

class ServiceIndividualController {

    IUserSearchService userSearchService
    IExternalHomeFolderService externalHomeFolderService

    def beforeInterceptor = {
        def token = request.getAttribute("accessToken")
        if (!token?.sufficientScope("individual")) {
            forward(controller: 'OAuth2', action: 'invalidScope')
            return false;
        }
    }

    def defaultAction = 'userInfo'

    def userInfo = {
        def token = request.getAttribute("accessToken")
        def user = userSearchService.getByLogin(token.resourceOwnerName)

        def individualMapping = externalHomeFolderService.
                getIndividualMapping(user, SecurityContext.getCurrentExternalService())
        if (individualMapping != null) {
            user.setExternalCapDematId(individualMapping.getExternalCapDematId())
            user.setExternalId(individualMapping.getExternalId())
        }

        render ([externalCapdematId:user.externalCapDematId, externalId:user.externalId,
             email: user.email, firstname: user.firstName, lastname: user.lastName] as JSON)
    }

}
