import fr.cg95.cvq.service.request.school.IGlobalSchoolRegistrationRequestService
import grails.converters.JSON

class FrontofficeGlobalSchoolRegistrationController {

    IGlobalSchoolRegistrationRequestService globalSchoolRegistrationRequestService

    def schoolSectors = {
        render(
            globalSchoolRegistrationRequestService.getSchools(Long.valueOf(params.childId)).get("schoolSectors")
        as JSON)
    }

    def schoolDerogs = {
        render(
            globalSchoolRegistrationRequestService.getSchools(Long.valueOf(params.childId)).get("schoolDerogs")
        as JSON)
    }
}
