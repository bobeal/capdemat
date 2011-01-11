import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService

class FrontofficeSchoolTransportRegistrationController {

    ISchoolTransportRegistrationRequestService schoolTransportRegistrationRequestService

    def transportLines = {
        return [
            'lines': schoolTransportRegistrationRequestService.transportLines(params.childId)
        ]
    }

    def stops = {
        return [
            'stops': schoolTransportRegistrationRequestService.stops(params.childId, params.lineId)
        ]
    }
}
