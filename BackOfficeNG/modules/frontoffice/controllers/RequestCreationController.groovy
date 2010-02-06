import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IAutofillService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IConditionService
import fr.cg95.cvq.service.request.IRequestDocumentService
import fr.cg95.cvq.service.request.IRequestLockService
import fr.cg95.cvq.service.request.IRequestNoteService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IHomeFolderService

import grails.converters.JSON
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestCreationController {
    
    IRequestDocumentService requestDocumentService
    IRequestLockService requestLockService
    IRequestNoteService requestNoteService
    IRequestTypeService requestTypeService
    IRequestWorkflowService requestWorkflowService
    
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IHomeFolderService homeFolderService
    
    IConditionService conditionService
    IAutofillService autofillService
    
    def documentAdaptorService
    def requestTypeAdaptorService
    def requestAdaptorService
    def translationService
    def jcaptchaService
    def securityService
    
    def defaultAction = 'edit'
    
    def beforeInterceptor = {
        documentAdaptorService.setServletContext(servletContext)
    }

    def edit = {
        if (params.label == null && params.id == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }

        if (SecurityContext.currentEcitizen == null)
            flash.isOutOfAccountRequest = true

        def cRequest
        if (params.id)
            cRequest = requestLockService.getAndLock(Long.valueOf(params.id))
        else
            cRequest = requestWorkflowService.getSkeletonRequest(params.label)
        if (cRequest == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        
        def requestType = cRequest.requestType
        
        // allow setting of request season only on creation
        if (params.requestSeasonId && cRequest.id == null) {
            cRequest.requestSeason =
                requestTypeService.getRequestSeason(requestType.id, Long.valueOf(params.requestSeasonId))
        }
        // check we have a request season if and only if the service needs one
        if ((requestTypeService.isOfRegistrationKind(requestType.id)
                && requestTypeService.getOpenSeasons(requestType).size() > 0
                && cRequest.requestSeason == null)) {
            redirect(uri : "/frontoffice/requestType")
            return false
        }

        // we need a requester that is home folder responsible to pass security checks
        def requester = SecurityContext.currentEcitizen
        if (requester == null) {
            requester = new Adult()
            homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE)
        }

        if (cRequest.id == null) {
            def i18accessErrors =
                requestTypeAdaptorService.requestTypeNotAccessibleMessages(requestType.id, requester.homeFolder)
            if (!i18accessErrors.isEmpty())
                throw new CvqException(i18accessErrors.get(0))
        }

        def individuals
        if (requestType.label != 'Home Folder Modification') individuals = new HomeFolderDTO()
        else individuals = new HomeFolderDTO(requester.homeFolder, getAllRoleOwners(requester.homeFolder))

        if (requestType.label == 'Home Folder Modification') {
            ["adults-required", "children", "foreignAdults", "account-required", "document", "validation"].each {
                def nameToken = it.tokenize('-')
                def value = ['required': nameToken.size() == 2]
                requestAdaptorService.stepState(value, 'complete', '')
                cRequest.stepStates.put(nameToken[0], value)
            }
        }

        session['javax.servlet.context.tempdir'] = 
        	servletContext['javax.servlet.context.tempdir'].absolutePath
        def uuidString = UUID.randomUUID().toString()
        session[uuidString] = [:]
        session[uuidString].cRequest = cRequest
        session[uuidString].requester = requester
        session[uuidString].homeFolderResponsible = requester
        session[uuidString].individuals = individuals
        session[uuidString].newDocuments = []
        session[uuidString].documentCounter = 0
        session[uuidString].draftVisible = false

        def viewPath = "/frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(requestType.label)}/edit"
        render(view: viewPath, model: [
            'isRequestCreation': true,
            'rqt': cRequest,
            'requester': requester,
            'homeFolderResponsible' : requester,
            'individuals' : individuals,
            'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
            'draftVisible': session[uuidString].draftVisible,
            'subjects': getAuthorizedSubjects(cRequest),
            'meansOfContact': getMeansOfContact(meansOfContactService, requester),
            'currentStep': 'firstStep',
            'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
            'uuidString': uuidString,
            'missingSteps': missingSteps(cRequest.stepStates),
            'documentTypes': documentAdaptorService.getDocumentTypes(cRequest, uuidString, []),
            'isDocumentEditMode': false,
            'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
            'isEdition' : cRequest.id != null && !RequestState.DRAFT.equals(cRequest.state)
        ].plus(fillCommonRequestModel(requestType.label)))
    }
    
    def step = {
        if (params.requestTypeInfo == null || params.uuidString == null || session[params.uuidString] == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }

        def uuidString = params.uuidString
        def requestTypeInfo = JSON.parse(params.requestTypeInfo)
        
        def submitAction = (params.keySet().find { it.startsWith('submit-') }).tokenize('-')
        def currentStep = submitAction[2]
        // FIXME BOR : maybe find a clearer name ? editedCollectionElement ?
        def editList
        
        def cRequest = session[uuidString].cRequest
        // Usefull to bind object different from cRequest
        def objectToBind = [:]
        objectToBind.requester = SecurityContext.currentEcitizen != null ? 
            SecurityContext.currentEcitizen : session[uuidString].requester
        objectToBind.homeFolderResponsible = session[uuidString].homeFolderResponsible
        objectToBind.individuals = session[uuidString].individuals
        
        def isDocumentEditMode = false
        session[uuidString].draftVisible = false
        def documentType = [:]
        def document = [:]
        // manage document create with current request (those can be deleted)
        // Do not work in draft case
        def newDocuments = session[uuidString].newDocuments 
        
        def askConfirmCancel = false
        
        if (cRequest.stepStates?.isEmpty()) {
            requestTypeInfo.steps.each {
                def nameToken = it.tokenize('-')
                def value = ['required': nameToken.size() == 2]
                requestAdaptorService.stepState(value, 'uncomplete', '')
                cRequest.stepStates.put(nameToken[0], value)
            }
        }
        
        try {
            if (submitAction[1] == 'cancelRequest') {
                askConfirmCancel = true
            }
            else if (submitAction[1] == 'confirmCancelRequest') {
                if (cRequest.id) requestLockService.release(cRequest.id)
                session.removeAttribute(uuidString)
                redirect(uri: '/frontoffice/requestType')
                return
            }
            else if (submitAction[1] == 'discardCancelRequest') {
                askConfirmCancel = false
            }
            else if (submitAction[1] == 'documentAdd') {
                def docParam = targetAsMap(submitAction[3])
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true
            }
            else if (submitAction[1] == 'documentEdit') {
                def docParam = targetAsMap(submitAction[3])
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true
                document = documentAdaptorService.getDocument(docParam.id, uuidString)
            }
            else if (submitAction[1] == 'documentSave') {
                def docParam = targetAsMap(submitAction[3]), doc = null
                
                if (docParam.id != null) {
                    if (request.getFile('documentData-0').bytes.size() == 0
                        && request.getFile('documentData-1') == null) {
                        // FIXME documentDelete duplication
                        newDocuments -= docParam.id
                        documentAdaptorService.deleteDocument(docParam.id, uuidString)
                        isDocumentEditMode = false
                        requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
                    } else {
                        // we are saving a previously added document
                        doc = documentAdaptorService.getDocument(docParam.id, uuidString)
                        documentAdaptorService.modifyDocumentNote(docParam,
                            uuidString, params.ecitizenNote)
                        def index = 0
                        // synchronize all existing binary datas
                        for (DocumentBinary page: (doc?.datas ? doc.datas : [])) {
                            if (request.getFile('documentData-' + (index + 1)).bytes.size() > 0) {
                                def modifyParam = targetAsMap("id:${doc.id}_dataPageNumber:${index}")
                                documentAdaptorService.modifyDocumentPage(modifyParam, request, uuidString)
                            }
                        }
                        // eventually add last and new page
                        if (request.getFile('documentData-0').bytes.size() > 0) {
                            def addParam = targetAsMap("documentTypeId:${docParam.documentTypeId}_id:${doc.id}")
                            documentAdaptorService.addDocumentPage(addParam, doc, request, uuidString)
                        }
                    }
                } else if (request.getFile('documentData-0').bytes.size() > 0) {
                    def addParam = 
                    	targetAsMap("documentTypeId:${docParam.documentTypeId}_id:${doc?.id?doc.id:''}")
                    doc = makeDocument(docParam, uuidString)
                    doc = documentAdaptorService.addDocumentPage(addParam, doc, request, uuidString)
                }
                if (doc) {
                    newDocuments += doc.id
                    isDocumentEditMode = false
                    requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
                } else {
                    flash.errorMessage = message(code : "document.message.pageFileCantBeEmpty")
                    isDocumentEditMode = true
                    documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                }
            }
            else if (submitAction[1] == 'documentDelete') {
                def docParam = targetAsMap(submitAction[3])
                newDocuments -= docParam.id
                documentAdaptorService.deleteDocument(docParam.id, uuidString)
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'documentAssociate') {
                def docParam = targetAsMap(submitAction[3])
                requestDocumentService.addDocument(cRequest.id, Long.valueOf(docParam.id))
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'documentUnassociate') {
                def docParam = targetAsMap(submitAction[3])
                requestDocumentService.removeDocument(cRequest, Long.valueOf(docParam.id))
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'documentCancel') {
                if (request.getFile('documentData-0').bytes.size() == 0
                    && request.getFile('documentData-1') == null) {
                    def docParam = targetAsMap(submitAction[3])
                    // FIXME documentDelete duplication
                    newDocuments -= docParam.id
                    documentAdaptorService.deleteDocument(docParam.id, uuidString)
                    requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
                }
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentAddPage') {
                if (params."documentData-0".size == 0)
                    flash.errorMessage = message(code : "document.message.pageFileCantBeEmpty")
                def docParam = targetAsMap(submitAction[3])
                def doc = makeDocument(docParam, uuidString)
                document = documentAdaptorService.addDocumentPage(docParam, doc, request, uuidString)
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true
            }
            else if (submitAction[1] == 'documentModifyPage') {
                def docParam = targetAsMap(submitAction[3])
                if (params["documentData-" + docParam.dataPageNumber].size == 0)
                    flash.errorMessage = message(code : "document.message.pageFileCantBeEmpty")
                document = documentAdaptorService.modifyDocumentPage(docParam, request, uuidString)
                documentType = documentAdaptorService.getDocumentType(document.documentType.id)
                isDocumentEditMode = true
            }
            else if (submitAction[1] == 'documentDeletePage') {
                def docParam = targetAsMap(submitAction[3])
                document = documentAdaptorService.deleteDocumentPage(docParam, request, uuidString)
                documentType = documentAdaptorService.getDocumentType(document.documentType.id)
                isDocumentEditMode = true
            }
            // removal of a collection element
            else if (submitAction[1] == 'collectionDelete') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def listWrapper = params.objectToBind == null ? cRequest : objectToBind[params.objectToBind]
                if (listWrapper[listFieldToken[0]].size() > Integer.valueOf(listFieldToken[1]))
                    listWrapper[listFieldToken[0]].remove(Integer.valueOf(listFieldToken[1]))
                
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
                if (['VO Card','Home Folder Modification'].contains(requestTypeInfo.label)) {
                    requestAdaptorService.stepState(cRequest.stepStates.get('account'), 'uncomplete', '')
                }
            }
            // edition of a collection element
            else if (submitAction[1] == 'collectionEdit') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def objectToManage = params."objectToManage[${listFieldToken[1]}]"
                def listWrapper = objectToManage == null ? cRequest : objectToBind[objectToManage] 
                
                editList = ['name': listFieldToken[0], 
                            'index': listFieldToken[1],
                            (listFieldToken[0]): listWrapper[listFieldToken[0]].get(Integer.valueOf(listFieldToken[1]))
                           ]
            }
            else if (submitAction[1] == 'addRole' && params."owner-${submitAction[3]}" != '' && params."role-${submitAction[3]}" != '') {
                def roleParam = targetAsMap(submitAction[3])
                def homeFolderId = params.homeFolderId.length() > 0 ? Long.valueOf(params.homeFolderId) : null
                def ownerIndex = Integer.valueOf(params."owner-${submitAction[3]}")
                def owner = objectToBind.individuals."${roleParam.ownerType}"[ownerIndex]
                def role = RoleType.forString(params."role-${submitAction[3]}")
                def individual = null
                if (roleParam.individualIndex != null) {
                    individual = objectToBind.individuals."${roleParam.individualType}"[Integer.valueOf("${roleParam.individualIndex}")]
                }
                if (role == RoleType.HOME_FOLDER_RESPONSIBLE) {
                    objectToBind.individuals.adults.eachWithIndex { adult, index ->
                        if (SecurityContext.currentEcitizen == null) homeFolderService.removeRole(adult, null, role)
                        else homeFolderService.removeRole(adult, null, homeFolderId, role)
                    }
                    objectToBind.homeFolderResponsible = owner
                }

                if (SecurityContext.currentEcitizen == null) homeFolderService.addRole(owner, individual, role)
                else homeFolderService.addRole(owner, individual, homeFolderId, role)
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'removeRole') {
                def roleParam = targetAsMap(submitAction[3])
                def homeFolderId = params.homeFolderId.length() > 0 ? Long.valueOf(params.homeFolderId) : null
                def owner = objectToBind.individuals."${roleParam.ownerType}"[Integer.valueOf("${roleParam.ownerIndex}")]
                def role = RoleType.forString(roleParam.role)
                def individual = null
                if (roleParam.individualIndex != null) {
                    individual = objectToBind.individuals."${roleParam.individualType}"[Integer.valueOf("${roleParam.individualIndex}")]
                }

                if (SecurityContext.currentEcitizen == null) homeFolderService.removeRole(owner, individual, role)
                else homeFolderService.removeRole(owner, individual, homeFolderId, role)
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'draft') {
                cRequest.homeFolderId = SecurityContext.getCurrentEcitizen().getHomeFolder().getId()
                cRequest.state = RequestState.DRAFT
                requestWorkflowService.create(cRequest)
                flash.confirmationMessage = message(code:'request.message.savedAsDraft')
                flash.confirmationMessageNotice = message(code:'request.message.savedAsDraftNotice')
            }
            // standard save action
            else {
                // remove databinding when saving a step of account creation/modification
                // to disable transparent adult/child addition
                // but allow it on validation step for question/answer etc.
                if (params.objectToBind != null
                    && (submitAction[1] != "step" || currentStep == "validation"
                        || !['VO Card','Home Folder Modification']
                            .contains(requestTypeInfo.label))) {
                    bindObject(objectToBind[params.objectToBind], params)
                }
                DataBindingUtils.initBind(cRequest, params)
                bind(cRequest)
                // clean empty collections elements
                DataBindingUtils.cleanBind(cRequest, params)
                session[uuidString].draftVisible = true
                                                                    
                if (submitAction[1] == 'step') {
                    if (currentStep == 'account') objectToBind.individuals.checkRoles()
                    requestAdaptorService.stepState(cRequest.stepStates?.get(currentStep), 'complete', '')
                }
                
                if (['VO Card','Home Folder Modification'].contains(requestTypeInfo.label)) {
                    if (['collectionAdd'].contains(submitAction[1])) {
                        requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
                        requestAdaptorService.stepState(cRequest.stepStates.get('account'), 'uncomplete', '')
                    }
                    if (submitAction[1] == 'step' && currentStep == 'adults'
                            && (objectToBind.individuals.adults == null || objectToBind.individuals.adults.isEmpty())){
                        requestAdaptorService.stepState(cRequest.stepStates.get('adults'), 'uncomplete', '')
                    }
                }
                
                if (currentStep == 'validation') {
                    // bind the selected means of contact into request
                    MeansOfContactEnum moce = MeansOfContactEnum.forString(params.meansOfContact)
                    cRequest.setMeansOfContact(meansOfContactService.getMeansOfContactByType(moce))
                    checkCaptcha(params)
                    def docs = documentAdaptorService.deserializeDocuments(newDocuments, uuidString)
                    def parameters = [:]
                    if (cRequest.id && !RequestState.DRAFT.equals(cRequest.state)) {
                        requestWorkflowService.rewindWorkflow(cRequest, docs)
                        parameters.isEdition = true
                    } else if (requestTypeInfo.label == 'Home Folder Modification') {
                        requestWorkflowService.createAccountModificationRequest(cRequest, 
                                objectToBind.individuals.adults, 
                        		objectToBind.individuals.children, 
                        		objectToBind.individuals.foreignAdults, 
                        		objectToBind.homeFolderResponsible.adress, docs)
                    } else if (requestTypeInfo.label == 'VO Card') {
                        requestWorkflowService.createAccountCreationRequest(cRequest, 
                                objectToBind.individuals.adults, 
                        		objectToBind.individuals.children, 
                        		objectToBind.individuals.foreignAdults, 
                        		objectToBind.homeFolderResponsible.adress, docs)
                        securityService.setEcitizenSessionInformation(objectToBind.homeFolderResponsible.login, 
                        		session)
                    } else {
                        cRequest.state = RequestState.PENDING
                        if (SecurityContext.currentEcitizen == null)
                            requestWorkflowService.create(cRequest, objectToBind.requester, docs)
                        else
                            requestWorkflowService.create(cRequest, docs)
                    }
                    
                    if (params.requestNote && !params.requestNote.trim().isEmpty()) {
                        requestNoteService.addNote(cRequest.id, RequestNoteType.PUBLIC, 
                        		params.requestNote.trim())
                    }
                    
                    session.removeAttribute(uuidString)
                    parameters.id = cRequest.id
                    parameters.label = requestTypeInfo.label
                    if (params.returnUrl != "") {
                        parameters.returnUrl = params.returnUrl
                    }
                    parameters.canFollowRequest = params.'_homeFolderResponsible.activeHomeFolder'
                    parameters.requesterLogin = objectToBind.homeFolderResponsible.login
                    redirect(action:'exit', params:parameters)
                    return
                } else {
                    if (submitAction[1] == "step") {
                        flash.confirmationMessage = message(
                            code : "request.step.message.validated",
                            args : [
                                message(code :
                                    currentStep == "document" ?
                                        "request.step.document.label" :
                                    translationService
                                        .generateInitialism(requestTypeInfo.label)
                                        + ".step." + currentStep + ".label")
                            ]
                        )
                    } else if (submitAction[1] == "collectionAdd") {
                        flash.confirmationMessage = message(
                            code : translationService
                                .generateInitialism(requestTypeInfo.label)
                                + ".property."
                                + submitAction[3].tokenize('[]')[0]
                                + ".elementAdditionSuccess")
                    }
                }
            }
            session[uuidString].cRequest = cRequest
            session[uuidString].requester = objectToBind.requester
            session[uuidString].homeFolderResponsible = objectToBind.homeFolderResponsible
            session[uuidString].individuals = objectToBind.individuals
            session[uuidString].newDocuments = newDocuments
        } catch (CvqException ce) {
            log.error ce.getMessage()
            requestAdaptorService.stepState(cRequest.stepStates?.get(currentStep), 'invalid',
                    message(code:ExceptionUtils.getModelI18nKey(ce),
                    		args:ExceptionUtils.getModelI18nArgs(ce)))
        }
        render( view: "/frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)}/edit",
                model:
                    ['isRequestCreation': true,
                     'askConfirmCancel': askConfirmCancel, 
                     'rqt': cRequest,
                     'requester': objectToBind.requester,
                     'homeFolderResponsible': objectToBind.homeFolderResponsible,
                     'individuals' : objectToBind.individuals,
                     'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
                     'draftVisible': session[uuidString].draftVisible,                     
                     'subjects': getAuthorizedSubjects(cRequest),
                     'meansOfContact': getMeansOfContact(meansOfContactService, objectToBind.homeFolderResponsible),
                     'currentStep': currentStep,
                     'stepStates': cRequest.stepStates,
                     'uuidString': uuidString,
                     'editList': editList,
                     'missingSteps': missingSteps(cRequest.stepStates),
                     'documentTypes': documentAdaptorService.getDocumentTypes(cRequest, uuidString, newDocuments),
                     'isDocumentEditMode': isDocumentEditMode,
                     'documentType': documentType,
                     'document': document,
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                     'isEdition' : cRequest.id != null && !RequestState.DRAFT.equals(cRequest.state),
                     'requestNote' : params.requestNote
                    ].plus(fillCommonRequestModel(requestTypeInfo.label)))
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
            for(Map entry : (JSON.parse(params.conditionsContainer) as List)) {
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
        render(autofillService.getValues(params.triggerName, Long.valueOf(params.triggerValue), JSON.parse(params.autofillContainer) as Map) as JSON)
    }

    def exit = {
        def requestId = Long.parseLong(params.id)
        requestLockService.release(requestId)
        render( view: "/frontofficeRequestType/exit",
                model:
                    ['translatedRequestTypeLabel': translationService.translateRequestTypeLabel(params.label).encodeAsHTML(),
                     'requestTypeLabel': params.label,
                     'requestId': requestId,
                     'requesterLogin': params.requesterLogin,
                     'hasHomeFolder': (SecurityContext.currentEcitizen ? true : false) || (new Boolean(params.canFollowRequest) || params.label == 'VO Card'),
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                     'isEdition' : params.isEdition
                    ])
    }
    
    /* Step and Validation
     * ------------------------------------------------------------------------------------------- */
    
    def getAuthorizedSubjects(cRequest) {
        def subjects = [:]
        if (SecurityContext.currentEcitizen != null 
        		&& !requestTypeService.getSubjectPolicy(cRequest.requestType.id).equals(IRequestWorkflowService.SUBJECT_POLICY_NONE)) {
            def authorizedSubjects = 
                requestWorkflowService.getAuthorizedSubjects(cRequest.requestType, 
                    SecurityContext.currentEcitizen.homeFolder.id)
            authorizedSubjects.each { subjectId, seasonsSet ->
                if (cRequest.requestSeason == null
                    || seasonsSet.contains(cRequest.requestSeason)) {
                    def subject = individualService.getById(subjectId)
                    subjects[subjectId] = subject.lastName + ' ' + subject.firstName
                }
            }
            
            if(cRequest.subjectId && !subjects.containsKey(cRequest.subjectId))
                subjects[cRequest.subjectId] = "${cRequest.subjectLastName} ${cRequest.subjectFirstName}"
        }
        return subjects
    }
    
    def getMeansOfContact(meansOfContactService, requester) {
        def result = []
        meansOfContactService.getAdultEnabledMeansOfContact(requester).each {
            result.add([key:it.type,
                        label: message(code:'request.meansOfContact.' + StringUtils.pascalToCamelCase(it.type.toString()))])
        }
        return result.sort {it.label}
    }
     
    // FIXME : when first entering the request creation process, stepStates is empty
    // so return null and add a generic message in view
    def missingSteps(stepStates) {
        if (stepStates == null || stepStates.size() == 0)
            return null
        return stepStates.collect { stepState ->
            stepState.value.required && stepState.value.state != 'complete' ? stepState.key : null
        }.findAll { stepName -> stepName != null && stepName != "validation" }
    }
    
    def bindObject(object, params) {
        def paramKeyPrefix = params.objectToBind ? params.objectToBind : ''
        params.each { param ->
            if (param.value.getClass() == GrailsParameterMap.class && param.key == '_' + paramKeyPrefix) {
                if (paramKeyPrefix == 'homeFolderResponsible')
                    checkAdultPassword(param.value)
                DataBindingUtils.initBind(object, param.value)
                bindParam (object, param.value)
                DataBindingUtils.cleanBind(object, param.value)
            }
        }
    }
    
    def checkAdultPassword (params) {
        flash.activeHomeFolder = params.activeHomeFolder == 'true' ? true : false
        if (params.password == null || params.activeHomeFolder == 'false')
            return
        if (params.password.length() < 8)
            throw new CvqException(message(code:"request.step.validation.error.tooShortPassword"))
        if (params.password != params.confirmPassword)
            throw new CvqException(message(code:"request.step.validation.error.password"))
    }
    
    def checkCaptcha (params) {
        if (SecurityContext.currentEcitizen == null && 
            !jcaptchaService.validateResponse("captchaImage", session.id, params.captchaText))
            throw new CvqException(message(code:"request.step.validation.error.captcha"))
    }
    
    /* Document step
     * ------------------------------------------------------------------------------------------- */
     
    def makeDocument(docParam, sessionUuid) {
        def doc
        if (docParam.id == null) {
            doc = new Document()
            doc.id = (session[sessionUuid].documentCounter)++
            doc.homeFolderId = SecurityContext.currentEcitizen ? SecurityContext.currentEcitizen.homeFolder.id : null
            doc.ecitizenNote = params.ecitizenNote
            doc.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(docParam.documentTypeId))
            doc.datas = new ArrayList<DocumentBinary>()
        }
        return doc
    }
    
    /* Home Folder Modification
     * ------------------------------------------------------------------------------------------- */
    
    // Usefull to retrieve individuals having a role on homefolder's individuals or on homefolder
    def getAllRoleOwners(homeFolder) {
        def owners = [] as Set
        homeFolder.individuals.each {
            owners += homeFolderService.getBySubjectRoles(it.id, RoleType.allRoleTypes)
        }
        owners += homeFolderService.listByHomeFolderRoles(homeFolder.id, RoleType.homeFolderRoleTypes)
        return owners
    }
    
    /* Utils
     * ------------------------------------------------------------------------------------------- */
    
    // Convert a substring of <input type=submit name="" /> representing target object of action in a map
    def targetAsMap(stringTarget) {
        def result = [:]
        stringTarget.tokenize('_').each {
            def property = it.tokenize(':')
            result[property[0]] = property[1]
        }
        return result
    }
    
}
