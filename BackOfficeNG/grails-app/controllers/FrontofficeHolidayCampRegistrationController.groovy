import fr.cg95.cvq.service.request.school.IHolidayCampRegistrationRequestService
import grails.converters.JSON

class FrontofficeHolidayCampRegistrationController {

    IHolidayCampRegistrationRequestService holidayCampRegistrationRequestService

    def holidayCamps = {
        render(
            holidayCampRegistrationRequestService.getHolidayCamps(Long.valueOf(params.requestId), Long.valueOf(params.childId))
        as JSON)
    }
}
