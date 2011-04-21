import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService
import grails.converters.JSON

class FrontofficeLeisureCenterRegistrationController {

    ILeisureCenterRegistrationRequestService leisureCenterRegistrationRequestService

    def leisureCenters = {
        render(
            leisureCenterRegistrationRequestService.getLeisureCenters(Long.valueOf(params.requestId), Long.valueOf(params.childId))
        as JSON)
    }

    def lines = {
        render(
            leisureCenterRegistrationRequestService.getLeisureCenterTransportLines(Long.valueOf(params.requestId), Long.valueOf(params.childId))
        as JSON)
    }

    def stops = {
        render(
            leisureCenterRegistrationRequestService.getLeisureCenterTransportStops(Long.valueOf(params.requestId), Long.valueOf(params.childId), params.lineId)
        as JSON)
    }
}
