import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.external.IExternalService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

class RequestController {

    def requestAdaptorService
    def translationService
    def documentAdaptorService
    def requestTypeAdaptorService
    def requestActionService
    def pdfService

    IIndividualService individualService
    IRequestServiceRegistry requestServiceRegistry
    IRequestService defaultRequestService
    IExternalService externalService
    IHomeFolderService homeFolderService
    
    def defaultAction = 'index'
    Adult currentEcitizen

    def index = {
        def state = [:]
        def requests = [:]
        currentEcitizen = SecurityContext.getCurrentEcitizen()
        
        if (params.ps) state = JSON.parse(params.ps);
        if (params.typeFilter != null) state.typeFilter = params.typeFilter;
        if (params.stateFilter != null) state.stateFilter = params.stateFilter;
        if (params.subjectFilter != null) state.subjectFilter = params.subjectFilter;
        
        requests = filterRequests(state,params)
        requests = requestAdaptorService.prepareRecords(requests)
        requests.records.each {
            it.lastAgentNote = requestAdaptorService.prepareNote(
                defaultRequestService.getLastAgentNote(it.id, null))
        }
        
        return ([
            'state': state,
            'pageState' : (new JSON(state)).toString(),
            'individuals': currentEcitizen.homeFolder.individuals.sort { it.firstName },
            'allRequestTypes' : requestAdaptorService.translateAndSortRequestTypes(),
            'requests': requests,
            'requestStates' : RequestState.allRequestStates.collect{ it.toString().toLowerCase()}
        ]);
    }

    def deleteDraft = {
        if (request.post) {
            defaultRequestService.delete(Long.valueOf(params.id))
            redirect(controller:'frontofficeHome')
        } else {
            def rqt = defaultRequestService.getById(Long.valueOf(params.id))
            return ['rqt':requestAdaptorService.prepareRecord(rqt)]
        }
    }

    def summary = {
        def requestService = requestServiceRegistry.getRequestService(Long.parseLong(params.id))
        def rqt = defaultRequestService.getById(Long.parseLong(params.id))
        def individuals = [:]
        if (rqt.requestType.label == 'VO Card' || rqt.requestType.label == 'Home Folder Modification') {
        	def homeFolderId = SecurityContext.currentEcitizen.homeFolder.id
        	individuals.adults = homeFolderService.getAdults(homeFolderId)
        	individuals.children = homeFolderService.getChildren(homeFolderId)
        }
        def requestTypeLabel =
            translationService.translateRequestTypeLabel(rqt.requestType.label).encodeAsHTML()
        def requester = rqt.requesterId != null ? individualService.getById(rqt.requesterId) : null
        def subjects = [:]
        subjects[rqt.subjectId] = "${rqt.subjectLastName} ${rqt.subjectFirstName}"
        return ['rqt': rqt,
                'requestTypeLabel':requestTypeLabel,
                'requester':requester,
                'subjects': subjects,
                'requestNotes' : requestAdaptorService.prepareNotes(
                    defaultRequestService.getNotes(Long.parseLong(params.id), null)),
                'externalInformations' : externalService.loadExternalInformations(rqt),
                'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(rqt.requestType.label),
                'documentTypes': documentAdaptorService.getDocumentTypes(requestService, rqt, null, [] as Set),
                'validationTemplateDirectory':CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label),
                'individuals':individuals
        ]
    }
    
    def testPdf = {
        def requestService = requestServiceRegistry.getRequestService(Long.parseLong(params.id))
        def cRequest = defaultRequestService.getById(Long.parseLong(params.id))
        
        def data = pdfService.requestToPdf(cRequest)
        response.contentType = "application/pdf"
        response.setHeader("Content-disposition", "attachment; filename=request.pdf")
        response.contentLength = data.length
        response.outputStream << data
        response.outputStream.flush()
    }

    def download = {
        if (!request.get) return false
        response.contentType = "application/pdf"
        response.setHeader("Content-disposition",
            "attachment; filename=request.pdf")
        def data = defaultRequestService.getCertificate(Long.valueOf(params.id))
        response.contentLength = data.length
        response.outputStream << data
        response.outputStream.flush()
    }

    protected filterRequests(state,params) {
        Set criteriaSet = new HashSet<Critere>()
        Critere critere = new Critere()
        
        critere.comparatif = Critere.NEQUALS
        critere.attribut = Request.SEARCH_BY_STATE
        critere.value = RequestState.DRAFT
        criteriaSet.add(critere)
        
        critere = new Critere()
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID
        critere.value = currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        
        if(state.stateFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_STATE
            critere.comparatif = critere.EQUALS
            critere.value = StringUtils.firstCase(state.stateFilter,'')
            criteriaSet.add(critere)
        }
        if(state.typeFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.typeFilter
            criteriaSet.add(critere)
        }
        if(state.subjectFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_SUBJECT_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.subjectFilter
            criteriaSet.add(critere)
        }

        def max = params.max ? Integer.valueOf(params.max) : 10
        def offset = params.offset ? Integer.valueOf(params.offset) : 0
        
        return [
            'all' : defaultRequestService.get(criteriaSet, Request.SEARCH_BY_CREATION_DATE,
                'desc', max, offset),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
}
