import fr.cg95.cvq.service.users.IIndividualService


class RequestTypeController {

    IIndividualService individualService
    
    def requestTypeAdaptorService
    
    def index = {
        def individual = individualService.getByLogin(session.currentUser)
        return ['groups':requestTypeAdaptorService.getDisplayGroups(true,individual.homeFolder)]
    }
}
