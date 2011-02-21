import fr.cg95.cvq.service.request.school.IHolidayCampRegistrationRequestService;

class FrontofficeHolidayCampRegistrationController {
    
        IHolidayCampRegistrationRequestService holidayCampRegistrationRequestService
    
        def holidayCamps = {
            return [
                'holidayCamps': holidayCampRegistrationRequestService
                    .getHolidayCamps(Long.valueOf(params.childId))
            ]
        }
    }