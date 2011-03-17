import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService
import grails.converters.JSON

class FrontofficeLeisureCenterRegistrationController {

    ILeisureCenterRegistrationRequestService leisureCenterRegistrationRequestService

    def leisureCenters = {
        render(
            leisureCenterRegistrationRequestService.getLeisureCenters(Long.valueOf(params.childId))
        as JSON)
    }

    def lines = {
        render(
            leisureCenterRegistrationRequestService.getTransportLines(Long.valueOf(params.childId))
        as JSON)
    }

    def stops = {
        render(
            leisureCenterRegistrationRequestService.getTransportStops(Long.valueOf(params.childId),params.lineId)
        as JSON)
    }
}
