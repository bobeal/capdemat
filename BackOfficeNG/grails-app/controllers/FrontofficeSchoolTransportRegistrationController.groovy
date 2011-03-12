import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService

class FrontofficeSchoolTransportRegistrationController {

    ISchoolTransportRegistrationRequestService schoolTransportRegistrationRequestService

    def transportLines = {
        return [
            'lines': schoolTransportRegistrationRequestService.transportLines(params.long('childId'))
        ]
    }

    def stops = {
        return [
            'stops': schoolTransportRegistrationRequestService.stops(params.long('childId'), params.lineId)
        ]
    }
}
