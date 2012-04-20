import java.util.HashMap
import java.util.Map

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
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getTransportLines(request, child) : new HashMap<String,String>()
        render( result as JSON)
    }

    def stops = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getTransportStops(request, child, params.lineId) : new HashMap<String,String>()
        render( result as JSON)
    }

    def schoolSectors = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getSchools(userSearchService.getChildById(params.long('childId'))) :
        new HashMap<String, Map<String,String>>()
        render( result.get("schoolSectors") as JSON)
    }

    def schoolDerogs = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def result =
        (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getSchools(userSearchService.getChildById(params.long('childId'))) :
        new HashMap<String, Map<String,String>>()
        render( result.get("schoolDerogs") as JSON)
    }

    def leisureCenters = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getLeisureCenters(request, child) :
        new HashMap<String,String>()
        render( result as JSON)
    }

    def leisureCenterWithDate = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getLeisureCenterWithDate(request, child) :
        new HashMap<String, Map<String, String>>()
        render( result as JSON)
    }

    def holidayCamps = {
        def service = requestExternalService.getExternalServiceByRequestType(params.requestTypeLabel)
        def request = requestSearchService.getById(params.long('requestId'), false)
        def child = userSearchService.getChildById(params.long('childId'))
        def result = (service instanceof IScholarBusinessProviderService)?
        ((IScholarBusinessProviderService) service).getHolidayCamps(request, child) :
        new HashMap<String,String>()
        render( result as JSON)
    }

}