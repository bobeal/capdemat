import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.dao.request.IRequestDAO
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.impl.RequestActionService;
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService
import fr.cg95.cvq.oauth2.InsufficientScopeException
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.business.users.TitleType

import grails.converters.JSON

class ServiceRequestController {

    IUserSearchService userSearchService
    IExternalHomeFolderService externalHomeFolderService
    IRequestDAO requestDAO
    IRequestActionService requestActionService

    def beforeInterceptor = {
        def token = request.getAttribute("accessToken")
        if (!token?.sufficientScope("request", params.requestTypeLabel)) {
            forward(controller: 'OAuth2', action: 'invalidScope')
            return false;
        }
    }

    def defaultAction = 'requestByIndividualAndType'

    def requestByIndividualAndType = {
        def token = request.getAttribute("accessToken")

        def user = userSearchService.getByLogin(token.resourceOwnerName)
        def individual = externalHomeFolderService.getIndividualMapping(params.individual)
        if (!user?.homeFolder?.id.equals(individual?.homeFolderMapping?.homeFolderId)) {
            response.status = 403
            render ([error: 'Invalid or unauthorized individual identifier.'] as JSON)
            return false
        }

        def requests = requestDAO.listBySubjectAndLabel(
            individual?.individualId, params.requestTypeLabel.replaceAll("_", " "), null, false)
        def requestList = new ArrayList()
        for (Request r: requests) {
            def map = new HashMap()
            map.put("id", r.id)
            map.put("state", r.state.name())
            map.put("creationDate", r.creationDate)
            map.put("lastModificationDate", r.lastModificationDate)
            map.put("subjectId", r.subjectId)
            requestList.add(map)
        }
        render(requestList as JSON)
    }
}

