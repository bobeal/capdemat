import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService
import grails.converters.JSON

class FrontofficeSchoolTransportRegistrationController {

    ISchoolTransportRegistrationRequestService schoolTransportRegistrationRequestService

    def transportLines = {
        render(
            schoolTransportRegistrationRequestService.transportLines(params.long('childId'))
        as JSON)
    }

    def stops = {
        render(
            schoolTransportRegistrationRequestService.stops(params.long('childId'), params.lineId)
        as JSON)
    }
}
