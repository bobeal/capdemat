import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.MeansOfContactEnum
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.exception.CvqValidationException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IAutofillService
import fr.cg95.cvq.service.request.IConditionService
import fr.cg95.cvq.service.users.IMeansOfContactService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.external.IRequestExternalService
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestNoteService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.users.IUserService
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.service.users.IUserWorkflowService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.util.translation.ITranslationService
import fr.cg95.cvq.service.payment.IRequestPaymentService
import fr.cg95.cvq.service.payment.IPaymentService

import grails.converters.JSON
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class FrontofficeRequestController {

    RequestAdaptorService requestAdaptorService
    ITranslationService translationService
    DocumentAdaptorService documentAdaptorService
    RequestTypeAdaptorService requestTypeAdaptorService
    IndividualAdaptorService individualAdaptorService
    SecurityService securityService

    IAutofillService autofillService
    IConditionService conditionService
    IUserService userService
    IUserSearchService userSearchService
    IUserWorkflowService userWorkflowService
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IRequestExternalService requestExternalService
    IRequestLockService requestLockService
    IRequestNoteService requestNoteService
    IRequestActionService requestActionService
    IRequestTypeService requestTypeService
    IRequestWorkflowService requestWorkflowService
    IRequestSearchService requestSearchService
    IRequestServiceRegistry requestServiceRegistry
    IPaymentService paymentService

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
            if (![RequestState.ARCHIVED.toString(),
                    RequestState.DRAFT.toString()].contains(it.state)) {
                it.externalInformations = requestExternalService.loadExternalInformations(
                    requestSearchService.getById(it.id, true))
                it.lastAgentNote = requestAdaptorService.prepareNote(
                    requestNoteService.getLastAgentNote(it.id, null))
            }
        }
        
        return ([
            'state': state,
            'pageState' : (new JSON(state)).toString(),
            'individuals': currentEcitizen.homeFolder.individuals.sort { it.fullName },
            'allRequestTypes' : requestAdaptorService.translateAndSortRequestTypes(),
            'requests': requests,
            'requestStates' : RequestState.allRequestStates.collect{ it.toString().toLowerCase()}
        ]);
    }

    def create = {
        if (params.label == null) {
            redirect(controller : "frontofficeRequestType")
            return false
        }
        def requestType = requestTypeService.getRequestTypeByLabel(params.label)
        def requestSeasonId = params.long("requestSeasonId")
        if (!requestWorkflowService.validateSeason(requestType,
            requestTypeService.getRequestSeason(requestType.id, requestSeasonId))) {
            redirect(controller : "frontofficeRequestType", action : "start", id : params.label)
            return false
        }
        Request rqt
        if (params.renewedId) {
            rqt = requestWorkflowService.getRequestClone(Long.valueOf(params.renewedId), params.long("requestSeasonId"))
        } else {
            rqt = requestWorkflowService.getSkeletonRequest(params.label, params.long("requestSeasonId"))
        }
        redirect(action : "edit", id : rqt.id)
    }

    def edit = {
        def id = Long.valueOf(params.id)
        requestLockService.lock(id)
        Request rqt = requestSearchService.getById(id, true)
        def isEdition = !RequestState.DRAFT.equals(rqt.state)
        def temporary = SecurityContext.currentCredentialBean.ecitizen?.homeFolder.temporary
        if (request.post) {
            try {
                DataBindingUtils.initBind(rqt, params)
                bind(rqt)
                // clean empty collections elements
                DataBindingUtils.cleanBind(rqt, params)
                if (params.currentStep == 'validation' && params.send) {
                    if (!params.useAcceptance) {
                        rqt.stepStates.get('validation').invalidFields = ['useAcceptance']
                        throw new CvqValidationException('request.error.useAcceptanceRequired')
                    }
                    // bind the selected means of contact into request
                    MeansOfContactEnum moce = MeansOfContactEnum.forString(params.meansOfContact)
                    rqt.setMeansOfContact(meansOfContactService.getMeansOfContactByType(moce))
                    requestWorkflowService.validate(rqt, null)
                    def parameters = [:]
                    if (!RequestState.DRAFT.equals(rqt.state)) {
                        parameters.isEdition = true
                        if (RequestState.UNCOMPLETE.equals(rqt.state)) {
                            requestWorkflowService.rewindWorkflow(rqt, params.requestNote && !params.requestNote.trim().isEmpty() ? params.requestNote : null)
                        }
                    } else {
                        rqt.state = RequestState.PENDING
                        requestWorkflowService.create(rqt,
                            params.requestNote && !params.requestNote.trim().isEmpty() ? params.requestNote : null)
                    }
                    parameters.id = rqt.id
                    parameters.label = rqt.requestType.label
                    if (params.returnUrl != "") {
                        parameters.returnUrl = params.returnUrl
                    }
                    parameters.temporary = temporary
                    parameters.requesterLogin = userSearchService.getHomeFolderResponsible(rqt.homeFolderId).login

                    if (requestServiceRegistry.getRequestService(rqt) instanceof IRequestPaymentService) {
                        def payment = requestServiceRegistry.getRequestService(rqt).buildPayment(rqt)
                        payment.addPaymentSpecificData('scheme',request.scheme)
                        payment.addPaymentSpecificData('domainName',request.serverName)
                        payment.addPaymentSpecificData('port',request.serverPort.toString())
                        payment.addPaymentSpecificData('callbackUrl',createLink(action:'exit', params:parameters).toString())
                        redirect(url:paymentService.initPayment(payment).toString())
                        return
                    } else {
                        redirect(action:'exit', params:parameters)
                    }
                    return
                } else {
                    requestWorkflowService.validate(rqt, [params.currentStep])
                    if (params.currentCollection != null) {
                        // hack : reset step to uncomplete,
                        // to force step validation irrespective of collection elements manipulation
                        rqt.stepStates[params.currentStep].state = "uncomplete"
                        // hack : remove collection parameters to go back to step display,
                        params.currentCollection = null
                        params.collectionIndex = null
                    }
                    if ("complete".equals(rqt.stepStates.get(params.currentStep).state)) {
                        flash.confirmationMessage = message(
                            code : "request.step.message.validated",
                            args : [
                                message(code :  params.currentStep == "document" ?  "request.step.document.label" :
                                    translationService.generateInitialism(rqt.requestType.label) + ".step." + params.currentStep + ".label")
                            ]
                        )
                    }
                }
            } catch (CvqException ce) {
                log.error ce.getMessage()
                rqt.stepStates.get(params.currentStep).state = "invalid"
                rqt.stepStates.get(params.currentStep).errorMsg = message(
                    code : ExceptionUtils.getModelI18nKey(ce),
                    args : ExceptionUtils.getModelI18nArgs(ce)
                )
                if (!(ce instanceof CvqValidationException))
                    session.doRollback = true
            }
        }
        def requestTypeLabelAsDir = CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label)
        def viewPath = "/frontofficeRequestType/${requestTypeLabelAsDir}/edit"
        def nextWebflowStep = webflowNextStep(rqt, params.currentStep)

        render(view: viewPath, model: [
            'rqt': rqt,
            'requester': SecurityContext.currentEcitizen,
            'homeFolderResponsible' : SecurityContext.currentEcitizen,
            //'individuals' : individuals,
            'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
            'temporary' : temporary,
            'subjects': individualAdaptorService.adaptSubjects(requestWorkflowService.getAuthorizedSubjects(rqt)),
            'meansOfContact': individualAdaptorService.adaptMeansOfContact(meansOfContactService.getAdultEnabledMeansOfContact(SecurityContext.currentEcitizen)),
            'currentStep': nextWebflowStep,
            'currentCollection': params.currentCollection,
            'collectionIndex': params.collectionIndex ? Integer.valueOf(params.collectionIndex) : null,
            'documentTypes': documentAdaptorService.getDocumentTypes(rqt),
            'documentsByTypes': ['document','validation'].contains(nextWebflowStep) ? documentAdaptorService.getDocumentsByType(rqt) : [],
            'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
            'isEdition' : isEdition,
            'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(rqt.requestType.label),
            'requestTypeLabelAsDir' : requestTypeLabelAsDir, 
            'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(requestTypeLabelAsDir),
            'availableRules' : localAuthorityRegistry.getLocalAuthorityRules(requestTypeLabelAsDir),
            'customJS' : requestTypeAdaptorService.getCustomJS(rqt.requestType.label),
            "subjectPolicy" : requestTypeService.getSubjectPolicy(rqt.requestType.id),
            'customReferential' : requestServiceRegistry.getRequestService(rqt).getBusinessReferential()
        ])
    }

    def collectionRemove = {
        def id = Long.valueOf(params.id)
        requestLockService.lock(id)
        Request rqt = requestSearchService.getById(id, true)
        rqt[params.currentCollection].remove(Integer.valueOf(params.collectionIndex))
        requestWorkflowService.validate(rqt, [params.currentStep])
        // hack : reset step to uncomplete,
        // to force step validation irrespective of collection elements manipulation
        rqt.stepStates[params.currentStep].state = "uncomplete"
        redirect(action:'edit', params:['id':params.id, 'currentStep':params.currentStep])
        return false
    }

    def webflowNextStep(rqt, step) {
        if (step == null)
            return rqt.stepStates.keySet().iterator().next()
        if (rqt.stepStates[step].state == 'invalid' && params.nextStep)
            return step
        def stepStates = []
        for (entry in rqt.stepStates) {
            if (entry.key == 'administration'
                || (entry.key == 'document' && documentAdaptorService.getDocumentTypes(rqt).isEmpty()))
            continue
            stepStates.add(entry.key)
        }
        for (def i = 0; i < stepStates.size(); i++) {
            if (stepStates[i].equals(step)) {
                if (params.nextStep) { updateStepState(rqt, step); return stepStates[i + 1] }
                if (params.previousStep) return stepStates[i - 1]
            }
        }
        return step
    }

    def updateStepState(rqt, step) {
        def afterCurrentStep = false
        def it = rqt.stepStates.entrySet().iterator()
        while (it.hasNext()) {
            def entry = it.next()
            if (entry.key == step) {
                afterCurrentStep = true
                continue 
            }
            def stepState = entry.value
            if (afterCurrentStep) {
                if (stepState.state == 'unavailable') {
                    stepState.state = 'uncomplete'
                    stepState.errorMsg = null
                    stepState.invalidFields = []
                }
                if (stepState.required) 
                    break
            }
        }
        if (requestWorkflowService.getMissingSteps(rqt).size() > 0)
            rqt.stepStates.validation.state = 'unavailable'
        else if (rqt.stepStates.validation.state == 'unavailable')
            rqt.stepStates.validation.state = 'uncomplete'
    }

    def individual = {
        def id = Long.valueOf(params.requestId)
        requestLockService.lock(id)
        def rqt = requestSearchService.getById(id, true)
        def currentStep = rqt.stepStates.keySet().iterator().next()
        if (params.cancel) {
            rqt.stepStates.remove(currentStep + '-' + params.type)
            redirect(action : "edit", id : id)
            return false
        } else {
            if (!["adult", "child"].contains(params.type)) {
                redirect(controller : "frontofficeHome")
                return false
            }
            rqt.stepStates[currentStep + '-' + params.type] = [:]
            rqt.stepStates[currentStep + '-' + params.type].state = "uncomplete"
            rqt.stepStates[currentStep + '-' + params.type].required = Boolean.FALSE
        }
        def individual
        if (params.type == "adult") {
            individual = new Adult()
            // hack : WTF is an unknown title ?
            individual.title = null
            individual.address = SecurityContext.currentEcitizen.address.clone()
        } else {
            individual = new Child()
            // hack : WTF is an unknown sex ?
            individual.sex = null
        }
        def requestTypeLabelAsDir = CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label)
        def viewPath = "/frontofficeRequestType/${requestTypeLabelAsDir}/edit"
        def model = [
            "rqt" : rqt,
            "hasHomeFolder" : SecurityContext.currentEcitizen ? true : false,
            "currentStep" : currentStep,
            "missingSteps" : requestWorkflowService.getMissingSteps(rqt),
            "documentTypes" : documentAdaptorService.getDocumentTypes(rqt),
            "documentsByTypes" : ["document", "validation"].contains(currentStep) ? documentAdaptorService.getDocumentsByType(rqt) : [],
            "returnUrl" : (params.returnUrl != null ? params.returnUrl : ""),
            "isEdition" : !RequestState.DRAFT.equals(rqt.state),
            "lrTypes" : requestTypeAdaptorService.getLocalReferentialTypes(rqt.requestType.label),
            "requestTypeLabelAsDir" : requestTypeLabelAsDir,
            "helps" : localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(requestTypeLabelAsDir),
            "availableRules" : localAuthorityRegistry.getLocalAuthorityRules(requestTypeLabelAsDir),
            "customJS" : requestTypeAdaptorService.getCustomJS(rqt.requestType.label),
            "subjectPolicy" : requestTypeService.getSubjectPolicy(rqt.requestType.id),
            "individual" : individual,
            "adults" : userSearchService.getAdults(SecurityContext.currentEcitizen.homeFolder.id),
            "currentUser" : SecurityContext.currentEcitizen
        ]
        if (request.post) {
            try {
                if (params.type == "adult") addAdult(individual)
                else if (params.type == "child") addChild(individual)
                rqt.subjectId = individual.id
                redirect(action : "edit", id : id)
            } catch (CvqValidationException e) {
                rqt.stepStates[currentStep + '-' + params.type].state = "invalid"
                rqt.stepStates[currentStep + '-' + params.type].invalidFields = e.invalidFields
                session.doRollback = true
            }
        }
        render(view : viewPath, model : model)
    }

    private addAdult(individual) throws CvqValidationException {
        DataBindingUtils.initBind(individual, params)
        bind(individual)
        def invalidFields = userService.validate(individual)
        if (!invalidFields.isEmpty())
            throw new CvqValidationException(invalidFields)
        userWorkflowService.add(SecurityContext.currentEcitizen.homeFolder, individual, false)
    }

    private addChild(individual) throws CvqValidationException {
        bind(individual)
        userWorkflowService.add(SecurityContext.currentEcitizen.homeFolder, individual)
        params.roles.each {
            if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                userWorkflowService.link(
                    userSearchService.getById(Long.valueOf(it.value.owner)),
                    individual, [RoleType.forString(it.value.type)])
            }
        }
        def invalidFields = userService.validate(individual)
        if (!invalidFields.isEmpty())
            throw new CvqValidationException(invalidFields)
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
        requestLockService.release(requestId)
        def temporary = params.boolean("temporary")
        if (temporary) {
            securityService.logout(session)
        }
        render(
            view : "/frontofficeRequestType/exit",
            model : [
                'translatedRequestTypeLabel': translationService.translateRequestTypeLabel(params.label).encodeAsHTML(),
                'requestTypeLabel': params.label,
                'requestId': requestId,
                'requesterLogin': params.requesterLogin,
                'temporary': temporary,
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
            return [
                "rqt" : requestAdaptorService.prepareRecord(
                    requestSearchService.getById(Long.valueOf(params.id), false)),
                "from" : params.from
            ]
        }
    }

    def summary = {
        def rqt = requestSearchService.getById(Long.parseLong(params.id), true)
        def requestTypeLabel =
            translationService.translateRequestTypeLabel(rqt.requestType.label).encodeAsHTML()
        def requester = rqt.requesterId != null ? userSearchService.getById(rqt.requesterId) : null
        def subject = rqt.subjectId != null ? userSearchService.getById(rqt.subjectId) : null
        def subjects = [:]
        subjects[rqt.subjectId] = subject instanceof Child && !subject.born ? message(code:'request.subject.childNoBorn', args:[subject.getFullName()]) : "${rqt.subjectLastName} ${rqt.subjectFirstName}"
        return ['rqt': rqt,
                'requestTypeLabel':requestTypeLabel,
                'requester':requester,
                'subjects': subjects,
                'requestNotes' : requestAdaptorService.prepareNotes(
                    requestNoteService.getNotes(Long.parseLong(params.id), null)),
                'externalInformations' : requestExternalService.loadExternalInformations(rqt),
                "documentsByTypes" : documentAdaptorService.getDocumentsByType(rqt),
                "lrTypes" : requestTypeAdaptorService.getLocalReferentialTypes(rqt.requestType.label),
                'validationTemplateDirectory':CapdematUtils.requestTypeLabelAsDir(rqt.requestType.label)
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
