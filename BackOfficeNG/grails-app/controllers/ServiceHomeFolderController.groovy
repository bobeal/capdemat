import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.oauth2.InsufficientScopeException;
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService

import grails.converters.JSON

class ServiceHomeFolderController {

    IUserSearchService userSearchService
    IExternalHomeFolderService externalHomeFolderService

    def beforeInterceptor = {
        def token = request.getAttribute("accessToken")
        if (!token?.sufficientScope("homefolder")) {
            forward(controller: 'OAuth2', action: 'invalidScope')
            return false;
        }
    }

    def defaultAction = 'homeFolder'

    def homeFolder = {
        def token = request.getAttribute("accessToken")
        def user = userSearchService.getByLogin(token.resourceOwnerName)
        def homeFolder = user.getHomeFolder()
        def individuals = homeFolder.getIndividuals()

        def homeFolderMapping = externalHomeFolderService
            .getHomeFolderMapping(SecurityContext.getCurrentExternalService(), homeFolder?.id)
        if (homeFolderMapping) {
            homeFolder.externalId = homeFolderMapping.externalId
            homeFolder.externalCapDematId = homeFolderMapping.externalCapDematId
            for (Individual individual: individuals) {
                def individualMapping = externalHomeFolderService.getIndividualMapping(
                    individual, SecurityContext.getCurrentExternalService())
                individual.externalCapDematId = individualMapping.externalCapDematId
                individual.externalId = individualMapping.externalId
            }
        }

        def individualList = new ArrayList()
        for (Individual i: individuals) {
            def indMap = new HashMap()
            indMap.put("externalCapDematId", i.externalCapDematId)
            indMap.put("externalId", i.externalId)
            if (i instanceof Adult) {
                indMap.put("email", i.email)
            }
            indMap.put("firstname", i.firstName)
            indMap.put("lastname", i.lastName)
            individualList.add(indMap)
        }
        render ([
            externalCapDematId: homeFolder.externalCapDematId,
            externalId: homeFolder.externalId,
            address: [
                streetNumber: homeFolder.address.streetNumber,
                streetName: homeFolder.address.streetName,
                cp: homeFolder.address.postalCode,
                city: homeFolder.address.city
            ],
            individuals: individualList] as JSON)
    }
}
