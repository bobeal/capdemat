import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.external.IRequestExternalService
import fr.cg95.cvq.service.request.IRequestNoteService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.util.translation.ITranslationService;

import grails.converters.JSON

class FrontofficeRequestController {

    RequestAdaptorService requestAdaptorService
    ITranslationService translationService
    DocumentAdaptorService documentAdaptorService
    RequestTypeAdaptorService requestTypeAdaptorService
    IndividualAdaptorService individualAdaptorService

    IIndividualService individualService
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IRequestExternalService requestExternalService
    IRequestNoteService requestNoteService
    IRequestActionService requestActionService
    IRequestWorkflowService requestWorkflowService
    IRequestSearchService requestSearchService
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
            if (!it.state.equals(RequestState.ARCHIVED.toString())) {
                it.externalInformations = requestExternalService.loadExternalInformations(
                    requestSearchService.getById(it.id, true))
                it.lastAgentNote = requestAdaptorService.prepareNote(
                    requestNoteService.getLastAgentNote(it.id, null))
            }
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

    def edit = {
        if (params.label == null && params.id == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        flash.isOutOfAccountRequest = (SecurityContext.currentEcitizen == null)
        Request rqt
        if (params.id) {
            def id = Long.valueOf(params.id)
            requestLockService.lock(id)
            rqt = requestSearchService.getById(id, true)
        } else {
            rqt = requestWorkflowService.getSkeletonRequest(params.label, params.long("requestSeasonId"))
        }
        if (rqt == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        if (request.post) {
            DataBindingUtils.initBind(rqt, params)
            bind(rqt)
            // clean empty collections elements
            DataBindingUtils.cleanBind(rqt, params)
            if (currentStep == 'validation') {
                // bind the selected means of contact into request
                MeansOfContactEnum moce = MeansOfContactEnum.forString(params.meansOfContact)
                rqt.setMeansOfContact(meansOfContactService.getMeansOfContactByType(moce))
                checkCaptcha(params)
                validateRequest(cRequest, null)
                //def docs = documentService.getBySessionUuid(uuidString)
                def parameters = [:]
                if (!RequestState.DRAFT.equals(rqt.state)) {
                    requestWorkflowService.rewindWorkflow(cRequest/*, docs*/)
                    parameters.isEdition = true
                } else {
                    rqt.state = RequestState.PENDING
                    if (SecurityContext.currentEcitizen == null)
                        requestWorkflowService.create(cRequest, objectToBind.requester,
                            params.requestNote && !params.requestNote.trim().isEmpty() ? params.requestNote : null)
                    else
                        requestWorkflowService.create(cRequest,
                            params.requestNote && !params.requestNote.trim().isEmpty() ? params.requestNote : null)
                }

                parameters.id = cRequest.id
                parameters.label = requestTypeInfo.label
                if (params.returnUrl != "") {
                    parameters.returnUrl = params.returnUrl
                }
                parameters.canFollowRequest = params.'_homeFolderResponsible.activeHomeFolder'
                parameters.requesterLogin = homeFolderService.getHomeFolderResponsible(rqt.homeFolderId).login
                redirect(action:'exit', params:parameters)
                return
            } else {
                validateRequest(cRequest, [currentStep])
                // add a check that currentStep is indeed complete, because, for VO Card,
                // no exception is thrown when validating the request (since it is empty)
                if ("complete".equals(rqt.stepStates?.get(currentStep).state)) {
                    flash.confirmationMessage = message(code : "request.step.message.validated",
                            args : [message(code :  currentStep == "document" ?  "request.step.document.label" :
                                translationService.generateInitialism(requestTypeInfo.label) + ".step." + currentStep + ".label")
                                ]
                    )
                }
            }
        }
        def viewPath = "/frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label)}/edit"
        render(view: viewPath, model: [
            'isRequestCreation': true,
            'rqt': rqt,
            'requester': SecurityContext.currentEcitizen,
            'homeFolderResponsible' : SecurityContext.currentEcitizen,
            //'individuals' : individuals,
            'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
            'subjects': individualAdaptorService.adaptSubjects(requestWorkflowService.getAuthorizedSubjects(rqt)),
            'meansOfContact': individualAdaptorService.adaptMeansOfContact(meansOfContactService.getAdultEnabledMeansOfContact(SecurityContext.currentEcitizen)),
            'currentStep': 'firstStep',
            'stepStates': rqt.stepStates?.size() != 0 ? rqt.stepStates : null,
            'missingSteps': requestWorkflowService.getMissingSteps(rqt),
            'documentTypes': [],//documentAdaptorService.getDocumentTypes(rqt, uuidString),
            'isDocumentEditMode': false,
            'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
            'isEdition' : !RequestState.DRAFT.equals(rqt.state)
        ].plus(fillCommonRequestModel(rqt.requestType.label)))
    }

    def fillCommonRequestModel(requestTypeLabel) {
        return [
            'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(requestTypeLabel),
            'requestTypeLabel': requestTypeLabel,
            'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(requestTypeLabel)),
            'availableRules' : localAuthorityRegistry.getLocalAuthorityRules(CapdematUtils.requestTypeLabelAsDir(requestTypeLabel)),
            'customJS' : requestTypeAdaptorService.getCustomJS(requestTypeLabel),
            'displayChildrenInAccountCreation': SecurityContext.currentConfigurationBean.isDisplayChildrenInAccountCreation(),
            'displayTutorsInAccountCreation': SecurityContext.currentConfigurationBean.isDisplayTutorsInAccountCreation(),
        ]
    }

    def condition = {
        def result = []

        if (params.requestTypeLabel == null) {
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
            return
        }

        try {
            for (Map entry : (JSON.parse(params.conditionsContainer) as List)) {
                result.add([
                    success_msg: message(code:'message.conditionTested'),
                    test: conditionService.isConditionFilled(params.requestTypeLabel, entry),
                    status: 'ok'
                ])
            }
            render(result as JSON)
        } catch (CvqException ce) {
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
        }
    }

    def autofill = {
        render(autofillService.getValues(params.triggerName, Long.valueOf(params.triggerValue),
            JSON.parse(params.autofillContainer) as Map) as JSON)
    }

    def exit = {
        def requestId = Long.parseLong(params.id)
        if (SecurityContext.currentEcitizen)
            requestLockService.release(requestId)
        render(
            view : "/frontofficeRequestType/exit",
            model : [
                'translatedRequestTypeLabel': translationService.translateRequestTypeLabel(params.label).encodeAsHTML(),
                'requestTypeLabel': params.label,
                'requestId': requestId,
                'requesterLogin': params.requesterLogin,
                'hasHomeFolder': (SecurityContext.currentEcitizen ? true : false) || (new Boolean(params.canFollowRequest) || params.label == 'VO Card'),
                'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                'isEdition' : params.isEdition
            ]
        )
    }

    def deleteDraft = {
        if (request.post) {
            requestWorkflowService.delete(Long.valueOf(params.id))
            redirect(controller:'frontofficeHome')
        } else {
            def rqt = requestSearchService.getById(Long.valueOf(params.id), false)
            return ['rqt':requestAdaptorService.prepareRecord(rqt)]
        }
    }

    def summary = {
        def rqt = requestSearchService.getById(Long.parseLong(params.id), true)
        def individuals = [:]
        if (rqt.requestType.label == 'VO Card' || rqt.requestType.label == 'Home Folder Modification') {
            def homeFolderId = SecurityContext.currentEcitizen.homeFolder.id
            individuals.adults = homeFolderService.getAdults(homeFolderId)
            individuals.children = homeFolderService.getChildren(homeFolderId)
        }
        def requestTypeLabel =
            translationService.translateRequestTypeLabel(rqt.requestType.label).encodeAsHTML()
        def requester = rqt.requesterId != null ? individualService.getById(rqt.requesterId) : null
        def subject = rqt.subjectId != null ? individualService.getById(rqt.subjectId) : null
        def subjects = [:]
        subjects[rqt.subjectId] = subject instanceof Child && !subject.isChildBorn ? message(code:'request.subject.childNoBorn', args:[subject.getFullName()]) : "${rqt.subjectLastName} ${rqt.subjectFirstName}"
        return ['rqt': rqt,
                'requestTypeLabel':requestTypeLabel,
                'requester':requester,
                'subjects': subjects,
                'requestNotes' : requestAdaptorService.prepareNotes(
                    requestNoteService.getNotes(Long.parseLong(params.id), null)),
                'externalInformations' : requestExternalService.loadExternalInformations(rqt),
                'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(rqt.requestType.label),
                'documentTypes': documentAdaptorService.getDocumentTypes(rqt, null),
                'validationTemplateDirectory':CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label),
                'individuals':individuals
        ]
    }

    def download = {
        if (!request.get) return false
        response.contentType = "application/pdf"
        response.setHeader("Content-disposition", "attachment; filename=request.pdf")
        def data = requestSearchService.getCertificate(Long.valueOf(params.id))
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
            'all' : requestSearchService.get(criteriaSet, Request.SEARCH_BY_CREATION_DATE,
                'desc', max, offset, false),
            'count' : requestSearchService.getCount(criteriaSet),
            'records' : []
        ]
    }
}
