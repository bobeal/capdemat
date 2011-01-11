import fr.cg95.cvq.service.request.school.IGlobalSchoolRegistrationRequestService;

import org.apache.soap.*;
import org.apache.soap.rpc.*;

class FrontofficeGlobalSchoolRegistrationController {

    IGlobalSchoolRegistrationRequestService globalSchoolRegistrationRequestService

    def schoolSectors = {
        return [
            'schoolSectors': globalSchoolRegistrationRequestService
                .getSchools(Long.valueOf(params.childId)).get("schoolSectors")
        ]
    }

    def schoolDerogs = {
        return [
            'schoolDerogs' : globalSchoolRegistrationRequestService
                .getSchools(Long.valueOf(params.childId)).get("schoolDerogs")
        ]
    }
}