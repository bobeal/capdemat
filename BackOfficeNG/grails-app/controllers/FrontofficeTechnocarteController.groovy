import java.util.HashMap

import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.external.IRequestExternalService
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService
import fr.cg95.cvq.service.users.IUserSearchService
import grails.converters.JSON

class FrontofficeTechnocarteController {
    def IRequestExternalService requestExternalService
    def IUserSearchService userSearchService
    def IRequestSearchService requestSearchService

    def transportLines = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result
        if (service instanceof IScholarBusinessProviderService) {
            result = ((IScholarBusinessProviderService) service).getTransportLines(request, child)
        } else {
            result = new HashMap<String,String>()
        }
        render( result as JSON)
    }

    def stops = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result
        if (service instanceof IScholarBusinessProviderService) {
            result = ((IScholarBusinessProviderService) service).getTransportStops(request, child, params.lineId);
        } else {
            result = new HashMap<String,String>();
        }
        render( result as JSON)
    }
}