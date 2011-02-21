import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService;

import org.apache.soap.*;
import org.apache.soap.rpc.*;

class FrontofficeLeisureCenterRegistrationController {

    ILeisureCenterRegistrationRequestService leisureCenterRegistrationRequestService

    def leisureCenters = {
        return [
            'leisureCenters': leisureCenterRegistrationRequestService
                .getLeisureCenters(Long.valueOf(params.childId))
        ]
    }

    def lines = {
        return [
            'lines': leisureCenterRegistrationRequestService
                .getTransportLines(Long.valueOf(params.childId))
        ]
    }

    def stops = {
        return [
            'stops': leisureCenterRegistrationRequestService
                .getTransportStops(Long.valueOf(params.childId),params.lineId)
        ]
    }
}