import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere

class FrontofficeRequestTypeController {

    IIndividualService individualService
    ILocalAuthorityRegistry localAuthorityRegistry
    IRequestSearchService requestSearchService
    IRequestWorkflowService requestWorkflowService
    IRequestServiceRegistry requestServiceRegistry
    def requestAdaptorService
    def requestTypeService
    def requestTypeAdaptorService
    def documentAdaptorService
    
    def index = {
        def adult = individualService.getAdultById(session.currentEcitizenId)
        return ['groups':requestTypeAdaptorService.getDisplayGroups(adult?.homeFolder)]
    }

    def start = {
        def label = params.id
        if (label == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        if (SecurityContext.currentEcitizen == null) {
            redirect(controller : "frontofficeRequestType", action : "login", params : ["requestTypeLabel" : label])
            return false
        }
        def requestType = requestTypeService.getRequestTypeByLabel(label)
        def intro = localAuthorityRegistry.getFileContent(
            localAuthorityRegistry.getLocalAuthorityResourceFile(
                LocalAuthorityResource.Type.HTML,
                "request/" + CapdematUtils.requestTypeLabelAsDir(label) + "/introduction",
                false))
        def lastRequests = requestWorkflowService.getRenewableRequests(label)
        def seasons = requestTypeService.isOfRegistrationKind(requestType.id) ?
            requestTypeService.getOpenSeasons(requestType) : []
        def criterias = [] as Set
        def critere = new Critere()
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_LABEL
        critere.value = label
        criterias.add(critere)
        critere = new Critere()
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request.SEARCH_BY_STATE
        critere.value = RequestState.DRAFT
        criterias.add(critere)
        def drafts = requestSearchService.get(criterias, null, null, 0, 0, false)
        if (intro == null && lastRequests.isEmpty() && seasons.isEmpty() && drafts.isEmpty()) {
            redirect(controller : "frontofficeRequest", action : "create", params : ["label" : label])
            return false
        }
        return [
            "requestTypeLabel" : label,
            "documentTypes" : documentAdaptorService.getDocumentTypes(requestType.id),
            "acronym" : requestTypeAdaptorService.generateAcronym(label),
            "intro" : intro,
            "lastRequests" : lastRequests,
            "seasons" : seasons,
            "drafts" : requestAdaptorService.prepareRecords(["all" : drafts, "count" : drafts.size(), "records" : []]).records
        ]
    }

    def login = {
        return ["temporary" : requestServiceRegistry.getRequestService(params.requestTypeLabel)
            .supportUnregisteredCreation()]
    }
}
