import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.users.IIndividualService




class RequestTypeController {

    IRequestService defaultRequestService
    ICategoryService categoryService
    IIndividualService individualService
    
    
    def instructionService
    
    def index = {
        def individual = this.individualService.getByLogin(session.currentUser)
        return ['groups':instructionService.getDisplayGroups(true,individual.homeFolder)]
    }
}
