import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestNoteType
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IAutofillService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IHomeFolderService

import grails.converters.JSON
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestCreationController {
    
    IRequestTypeService requestTypeService
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IHomeFolderService homeFolderService
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
    
    def draft = {
        
        def requestService = null
        
        flash.fromDraft = true
        def targetAction
        def newParams = [:]
        if (request.post) {
            requestService = requestServiceRegistry.getRequestService(params.requestTypeLabel)
            def cRequest = session[params.uuidString].cRequest
            cRequest.homeFolderId = SecurityContext.getCurrentEcitizen().getHomeFolder().getId()
            requestService.processDraft(cRequest)
            flash.cRequest = cRequest
            flash.confirmationMessage = message(code:'request.message.savedAsDraft')
            flash.confirmationMessageNotice = message(code:'request.message.savedAsDraftNotice')
            targetAction = 'step'
            newParams.uuidString = params.uuidString
            newParams.requestTypeInfo = params.requestTypeInfo
            if (!params.currentTabIndex) params.currentTabIndex = 0
            newParams.('submit-draft-' + JSON.parse(params.requestTypeInfo).steps.get(Integer.valueOf(params.currentTabIndex)).tokenize('-')[0]) = params.'submit-draft'
        } else if (request.get) {
            requestService = requestServiceRegistry.getRequestService(Long.parseLong(params.id))
            def cRequest = requestService.getAndLock(Long.parseLong(params.id))
            if (cRequest.stepStates == null)
               cRequest.stepStates = [:]
            flash.cRequest = cRequest
            targetAction = 'edit'
            newParams.label = requestService.label
        }
        redirect(controller : controllerName, action : targetAction, params : newParams)
        return false
    }
    
    def edit = {
        if (params.label == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }

        if (SecurityContext.currentEcitizen == null)
            flash.isOutOfAccountRequest = true

        def requestService = requestServiceRegistry.getRequestService(params.label)
        if (requestService == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }

        def cRequest = flash.cRequest ? flash.cRequest : requestService.getSkeletonRequest()

        def requestType = requestTypeService.getRequestTypeByLabel(params.label)
        // allow setting of request season only on creation
        if (params.requestSeasonId && cRequest.id == null) {
            cRequest.requestSeason =
                requestTypeService.getRequestSeason(requestType.id, Long.valueOf(params.requestSeasonId))
        }
        // check we have a request season if and only if the service needs one
        if ((requestService.isOfRegistrationKind()
                && requestTypeService.getOpenSeasons(requestType).size() > 0
                && cRequest.requestSeason == null)) {
            redirect(uri : "/frontoffice/requestType")
            return false
        }

        def requester = SecurityContext.currentEcitizen
        if (requester == null) {
            requester = new Adult()
            homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE)
        }

        if (cRequest.id == null) {
            def i18accessErrors =
                requestTypeAdaptorService.requestTypeNotAccessibleMessages(
                    requestTypeService.getRequestTypeByLabel(params.label),
                    requester.homeFolder)
            if (!i18accessErrors.isEmpty())
                throw new CvqException(params.label + " is not accessible",
                i18accessErrors.get(0))
        }

        def individuals
        if (params.label != 'Home Folder Modification') individuals = new HomeFolderDTO()
        else individuals = new HomeFolderDTO(requester.homeFolder, getAllRoleOwners(requester.homeFolder))

        def newDocuments = [] as Set

        if (params.label == 'Home Folder Modification') {
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
        session[uuidString].newDocuments = newDocuments
        session[uuidString].documentCounter = 0
        session[uuidString].draftVisible = false

        def viewPath = "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(params.label)}/edit"
        render(view: viewPath, model: [
            'isRequestCreation': true,
            'rqt': cRequest,
            'requester': requester,
            'homeFolderResponsible' : requester,
            'individuals' : individuals,
            'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
            'draftVisible': session[uuidString].draftVisible,
            'subjects': getAuthorizedSubjects(requestService, cRequest),
            'meansOfContact': getMeansOfContact(meansOfContactService, requester),
            'currentStep': 'firstStep',
            'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
            'uuidString': uuidString,
            'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
            'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, uuidString, newDocuments),
            'isDocumentEditMode': false,
            'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
            'isEdition' : cRequest.id != null && !cRequest.draft
        ].plus(fillCommonRequestModel(params.label)))
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
        
        def requestService = requestServiceRegistry.getRequestService(requestTypeInfo.label)
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
                if (cRequest.id) requestService.release(cRequest.id)
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
                	// we are saving a previously added document
                    doc = documentAdaptorService.getDocument(docParam.id, uuidString)
            	    documentAdaptorService.modifyDocumentNote(docParam, uuidString, 
            	    		params.ecitizenNote)
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
                } else if (request.getFile('documentData-0').bytes.size() > 0) {
                    def addParam = 
                    	targetAsMap("documentTypeId:${docParam.documentTypeId}_id:${doc?.id?doc.id:''}")
                    doc = makeDocument(docParam, uuidString)
                    doc = documentAdaptorService.addDocumentPage(addParam, doc, request, uuidString)
                }
                newDocuments += doc.id
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
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
                requestService.addDocument(cRequest, Long.valueOf(docParam.id))
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'documentUnassociate') {
                def docParam = targetAsMap(submitAction[3])
                requestService.removeDocument(cRequest, Long.valueOf(docParam.id))
                isDocumentEditMode = false
                requestAdaptorService.stepState(cRequest.stepStates.get(currentStep), 'uncomplete', '')
            }
            else if (submitAction[1] == 'documentCancel') { 
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentAddPage') {
                def docParam = targetAsMap(submitAction[3])
                def doc = makeDocument(docParam, uuidString)
                document = documentAdaptorService.addDocumentPage(docParam, doc, request, uuidString)
                documentType = documentAdaptorService.getDocumentType(document.documentType.id)
                isDocumentEditMode = true
            }
            else if (submitAction[1] == 'documentModifyPage') {
                def docParam = targetAsMap(submitAction[3])
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
                requestAdaptorService.stepState(cRequest.stepStates.get('account'), 'uncomplete', '')
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
                // do nothing as the draft has already been saved
            }
            // standard save action
            else {
                if (params.objectToBind != null)
                    bindObject(objectToBind[params.objectToBind], params)
                
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
                    checkCaptcha(params)
                    // bind the selected means of contact into request
                    MeansOfContactEnum moce = MeansOfContactEnum.forString(params.meansOfContact)
                    cRequest.setMeansOfContact(meansOfContactService.getMeansOfContactByType(moce))
        
                    def docs = documentAdaptorService.deserializeDocuments(newDocuments, uuidString)
                    def parameters = [:]
                    if (cRequest.id && !cRequest.draft) {
                        requestService.rewindWorkflow(cRequest, docs)
                        parameters.isEdition = true
                    } else if (requestTypeInfo.label == 'Home Folder Modification') {
                        requestService.create(cRequest, objectToBind.requester.homeFolder.id)
                        requestService.modify(cRequest, objectToBind.individuals.adults, 
                        		objectToBind.individuals.children, 
                        		objectToBind.individuals.foreignAdults, 
                        		objectToBind.homeFolderResponsible.adress, docs)
                    } else if (requestTypeInfo.label == 'VO Card') {
                        requestService.create(cRequest, objectToBind.individuals.adults, 
                        		objectToBind.individuals.children, 
                        		objectToBind.individuals.foreignAdults, 
                        		objectToBind.homeFolderResponsible.adress, docs)
                        securityService.setEcitizenSessionInformation(objectToBind.homeFolderResponsible.login, 
                        		session)
                    } else if (SecurityContext.currentEcitizen == null) { 
                        requestService.create(cRequest, objectToBind.requester, null, docs)
                    } else if (!cRequest.draft) { 
                        requestService.create(cRequest, docs)
                    } else { 
                        requestService.finalizeDraft(cRequest, docs)
                    }
                    
                    if (params.requestNote && !params.requestNote.trim().isEmpty()) {
                        requestService.addNote(cRequest.id, RequestNoteType.PUBLIC, 
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
                }
            }
            session[uuidString].cRequest = cRequest
            session[uuidString].requester = objectToBind.requester
            session[uuidString].homeFolderResponsible = objectToBind.homeFolderResponsible
            session[uuidString].individuals = objectToBind.individuals
            session[uuidString].newDocuments = newDocuments
        } catch (CvqException ce) {
            ce.printStackTrace()
            requestAdaptorService.stepState(cRequest.stepStates?.get(currentStep), 'invalid',
                    message(code:ExceptionUtils.getModelI18nKey(ce),
                    		args:ExceptionUtils.getModelI18nArgs(ce)))
        }

        render( view: "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)}/edit",
                model:
                    ['isRequestCreation': true,
                     'askConfirmCancel': askConfirmCancel, 
                     'rqt': cRequest,
                     'requester': objectToBind.requester,
                     'homeFolderResponsible': objectToBind.homeFolderResponsible,
                     'individuals' : objectToBind.individuals,
                     'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
                     'draftVisible': session[uuidString].draftVisible,                     
                     'subjects': getAuthorizedSubjects(requestService, cRequest),
                     'meansOfContact': getMeansOfContact(meansOfContactService, objectToBind.homeFolderResponsible),
                     'currentStep': currentStep,
                     'stepStates': cRequest.stepStates,
                     'uuidString': uuidString,
                     'editList': editList,
                     'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
                     'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, uuidString, newDocuments),
                     'isDocumentEditMode': isDocumentEditMode,
                     'documentType': documentType,
                     'document': document,
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                     'isEdition' : cRequest.id != null && !cRequest.draft
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
            IRequestService service = requestServiceRegistry.getRequestService(params.requestTypeLabel)
            for(Map entry : (JSON.parse(params.conditionsContainer) as List)) {
                result.add([
                    success_msg: message(code:'message.conditionTested'),
                    test: service.isConditionFilled(entry),
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
        def requestService = requestServiceRegistry.getRequestService(params.label)
        def cRequest = requestService.getById(Long.parseLong(params.id))
        requestService.release(cRequest.id)
        render( view: "frontofficeRequestType/exit",
                model:
                    ['translatedRequestTypeLabel': translationService.translateRequestTypeLabel(cRequest.requestType.label).encodeAsHTML(),
                     'requestTypeLabel': cRequest.requestType.label,
                     'requestId': cRequest.id,
                     'requesterLogin': params.requesterLogin,
                     'hasHomeFolder': (SecurityContext.currentEcitizen ? true : false) || (new Boolean(params.canFollowRequest) || params.label == 'VO Card'),
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : ""),
                     'isEdition' : params.isEdition
                    ])
    }
    
    /* Step and Validation
     * ------------------------------------------------------------------------------------------- */
    
    def getAuthorizedSubjects(requestService, cRequest) {
        def subjects = [:]
        if (SecurityContext.currentEcitizen != null 
        		&& !requestService.subjectPolicy.equals(IRequestService.SUBJECT_POLICY_NONE)) {
            def authorizedSubjects = requestService.getAuthorizedSubjects(SecurityContext.currentEcitizen.homeFolder.id)
           authorizedSubjects.each { subjectId, seasonsSet ->
                if (cRequest.requestSeason == null
                    || seasonsSet.contains(cRequest.requestSeason)) {
                    def subject = individualService.getById(subjectId)
                    subjects[subjectId] =
                        subject.lastName + ' ' + subject.firstName
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
     
    // TODO - refactor. Maybe move to Request class ...
    def isRequestCreatable(stepStates) {
        if (stepStates == null || stepStates.size() == 0)
            return false;
        def steps = stepStates.findAll {
            it.value.required && it.value.state != 'complete'
        }
        if (steps.size() == 0) return true;
        else return false;
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
