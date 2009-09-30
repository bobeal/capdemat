import fr.cg95.cvq.service.users.IIndividualService


class RequestTypeController {

    IIndividualService individualService
    def requestTypeService
    def requestTypeAdaptorService
    
    def index = {
        def individual = individualService.getByLogin(session.currentEcitizen)
        return ['groups':requestTypeAdaptorService.getDisplayGroups(individual?.homeFolder)]
    }

    def seasons = {
        if (params.label == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        return [
            "label" : params.label,
            "seasons" : requestTypeService.getOpenSeasons(
                requestTypeService.getRequestTypeByLabel(params.label))
        ]
    }
}
