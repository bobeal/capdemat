import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IAutofillService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IHomeFolderService

import grails.converters.JSON
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestCreationController {
    
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
    def translationService
    def jcaptchaService
    
    def defaultAction = 'edit'
    
    def beforeInterceptor = {
        documentAdaptorService.setServletContext(servletContext)
    }
    
    def draft = {
        
        def requestService = null
        
        flash.fromDraft = true
        
        if(request.post) {
            requestService = requestServiceRegistry.getRequestService(params.requestTypeLabel)
            def cRequest = session[params.uuidString].cRequest
            requestService.prepareDraft(cRequest)
            requestService.processDraft(cRequest)
            flash.cRequest = cRequest
            flash.confirmationMessage = message(code:'message.savedAsDraft')
        } else if (request.get) {
            requestService = requestServiceRegistry.getRequestService(Long.parseLong(params.id))
            flash.cRequest = requestService.getById(Long.parseLong(params.id))
        }
        redirect(controller:controllerName, params:[
            'label':requestService.label,'currentTabIndex': params.currentTabIndex])
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
        
        def cRequest
        if (flash.cRequest) cRequest = flash.cRequest 
        else cRequest = requestService.getSkeletonRequest()
        
        def requester = SecurityContext.currentEcitizen
        if (requester == null) {
            requester = new Adult()
            homeFolderService.addHomeFolderRole(requester, RoleType.HOME_FOLDER_RESPONSIBLE)
        }
        
        def individuals = new HomeFolderDTO()
        
        def newDocuments = [] as Set
        
        session['javax.servlet.context.tempdir'] = servletContext['javax.servlet.context.tempdir'].absolutePath
        def uuidString = UUID.randomUUID().toString()
        session[uuidString] = [:]
        session[uuidString].cRequest = cRequest
        session[uuidString].requester = requester
        session[uuidString].individuals = individuals
        session[uuidString].newDocuments = newDocuments
        session[uuidString].documentCounter = 0
        session[uuidString].draftVisible = false //(cRequest.draft && !flash.fromDraft)
        
        def viewPath = "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(params.label)}/edit"
        render(view: viewPath, model: [
            'isRequestCreation': true,
            'rqt': cRequest,
            'requester': requester,
            'individuals' : individuals,
            'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
            'draftVisible': session[uuidString].draftVisible,
            'subjects': getAuthorizedSubjects(requestService, cRequest),
            'meansOfContact': getMeansOfContact(meansOfContactService, requester),
            'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(params.label),
            'currentStep': 'firstStep',
            'requestTypeLabel': params.label,
            'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
            'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(params.label)),
            'availableRules' : localAuthorityRegistry.getLocalAuthorityRules(CapdematUtils.requestTypeLabelAsDir(params.label)),
            'uuidString': uuidString,
            'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
            'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, uuidString, newDocuments),
            'isDocumentEditMode': false,
            'returnUrl' : (params.returnUrl != null ? params.returnUrl : "")
        ])
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
        objectToBind.individuals = session[uuidString].individuals
        
        def isDocumentEditMode = false
        session[uuidString].draftVisible = false
        def documentType = [:]
        def document = [:]
        // manage document create with current request (those can be deleted)
        // Do not work in draft case
        def newDocuments = session[uuidString].newDocuments 
        
        def askConfirmCancel = false
        
        if (cRequest.stepStates.isEmpty()) {
            requestTypeInfo.steps.each {
                def nameToken = it.tokenize('-')
                def value = ['state': 'uncomplete',
                             'required': nameToken.size() == 2,
                             'cssClass': 'tag-uncomplete',
                             'i18nKey': 'request.step.state.uncomplete'
                             ]
                cRequest.stepStates.put(nameToken[0], value)
            }
        }
        
        try {
            if (submitAction[1] == 'cancelRequest') {
                askConfirmCancel = true
            }
            else if (submitAction[1] == 'confirmCancelRequest') {
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
                def docParam = targetAsMap(submitAction[3]), index = 0, doc = null
                
                if (docParam.id != null) {
                    doc = documentAdaptorService.getDocument(docParam.id, uuidString)
                    for (DocumentBinary page: (doc?.datas ? doc.datas : [])) {
                        if (request.getFile('documentData-' + (index + 1)).bytes.size() > 0) {
                            def modifyParam = targetAsMap("id:${doc.id}_dataPageNumber:${index}")
                            documentAdaptorService.modifyDocumentPage(modifyParam, request, uuidString)
                        }
                    }
                }
                if (request.getFile('documentData-0').bytes.size() > 0) {
                    def addParam = targetAsMap("documentTypeId:${docParam.documentTypeId}_id:${doc?.id?doc.id:''}")
                    if (docParam.id == null) 
                        doc = makeDoument(docParam, uuidString)
                    doc = documentAdaptorService.addDocumentPage(addParam, doc, request, uuidString)
                }
                              
                newDocuments += doc.id
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentDelete') {
                def docParam = targetAsMap(submitAction[3])
                newDocuments -= docParam.id
                documentAdaptorService.deleteDocument(docParam.id, uuidString)
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentAssociate') {
                def docParam = targetAsMap(submitAction[3])
                requestService.addDocument(cRequest, Long.valueOf(docParam.id))
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentUnassociate') {
                def docParam = targetAsMap(submitAction[3])
                requestService.removeDocument(cRequest, Long.valueOf(docParam.id))
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentCancel') { 
                isDocumentEditMode = false
            }
            else if (submitAction[1] == 'documentAddPage') {
                def docParam = targetAsMap(submitAction[3])
                def doc = makeDoument(docParam, uuidString)
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
                def pageNumber = Integer.valueOf(docParam.dataPageNumber)
                def doc = documentAdaptorService.deserializeDocument(docParam.id, uuidString)
                doc.datas.remove(pageNumber)                
                documentAdaptorService.serializeDocument(doc, uuidString)
                document = documentAdaptorService.adaptDocument(doc)
                documentType = documentAdaptorService.getDocumentType(doc.documentType.id)
                isDocumentEditMode = true
            }
            // removal of a collection element
            else if (submitAction[1] == 'collectionDelete') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def listWrapper = params.objectToBind == null ? cRequest : objectToBind[params.objectToBind]
                listWrapper[listFieldToken[0]].remove(Integer.valueOf(listFieldToken[1]))
            }
            // edition of a collection element
            else if (submitAction[1] == 'collectionEdit') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def listWrapper = params.objectToManage == null ? cRequest : objectToBind[params.objectToManage] 
                
                editList = ['name': listFieldToken[0], 
                            'index': listFieldToken[1],
                            (listFieldToken[0]): listWrapper[listFieldToken[0]].get(Integer.valueOf(listFieldToken[1]))
                           ]
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
                    cRequest.stepStates.get(currentStep).state = 'complete'
                    cRequest.stepStates.get(currentStep).cssClass = 'tag-complete'
                    cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.complete'
                    cRequest.stepStates.get(currentStep).errorMsg = ''
                }
                
                if (currentStep == 'validation') {
                    checkCaptcha (params);
                    // bind the selected means of contact into request
                    MeansOfContactEnum moce = MeansOfContactEnum.forString(params.meansOfContact)
                    cRequest.setMeansOfContact(meansOfContactService.getMeansOfContactByType(moce))
                    
                    def docs = documentAdaptorService.deserializeDocuments(newDocuments, uuidString)
                    if (SecurityContext.currentEcitizen == null) 
                        requestService.create(cRequest, objectToBind.requester, null, docs)
                    else if (!cRequest.draft) 
                        requestService.create(cRequest, docs)
                    else 
                        requestService.finalizeDraft(cRequest)
                    
                    session.removeAttribute(uuidString)
                    def parameters = ['id':cRequest.id, 'label':requestTypeInfo.label]
                    if (params.returnUrl != "") {
                        parameters.returnUrl = params.returnUrl
                    }
                    redirect(action:'exit', params:parameters)
                    return
                }
            }        
            session[uuidString].cRequest = cRequest
            session[uuidString].requester = objectToBind.requester
            session[uuidString].individuals = objectToBind.individuals
            session[uuidString].newDocuments = newDocuments
        
        } catch (CvqException ce) {
            ce.printStackTrace()
            cRequest.stepStates.get(currentStep).state = 'invalid'
            cRequest.stepStates.get(currentStep).cssClass = 'tag-invalid'
            cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.error'
            cRequest.stepStates.get(currentStep).errorMsg = ce.message
        }

        render( view: "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)}/edit",
                model:
                    ['isRequestCreation': true,
                     'askConfirmCancel': askConfirmCancel, 
                     'rqt': cRequest,
                     'requester': objectToBind.requester,
                     'individuals' : objectToBind.individuals,
                     'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
                     'draftVisible': session[uuidString].draftVisible,                     
                     'subjects': getAuthorizedSubjects(requestService, cRequest),
                     'meansOfContact': getMeansOfContact(meansOfContactService, objectToBind.requester),
                     'lrTypes': requestTypeAdaptorService.getLocalReferentialTypes(requestTypeInfo.label),
                     'currentStep': currentStep,
                     'requestTypeLabel': requestTypeInfo.label,
                     'stepStates': cRequest.stepStates,
                     'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)),
                     'availableRules' : localAuthorityRegistry.getLocalAuthorityRules(CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)),
                     'uuidString': uuidString,
                     'editList': editList,
                     'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
                     'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, uuidString, newDocuments),
                     'isDocumentEditMode': isDocumentEditMode,
                     'documentType': documentType,
                     'document': document,
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : "")
                    ])
    }  
    
    def condition = {
        def result = []
        
        if (params.requestTypeLabel == null)
            render ([status: 'error', error_msg:message(code:'error.unexpected')] as JSON)
        
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
        def requester = individualService.getById(cRequest.requesterId)
        render( view: "frontofficeRequestType/exit",
                model:
                    ['requestTypeLabel': translationService.getEncodedRequestTypeLabelTranslation(cRequest.requestType.label),
                     'rqt': cRequest,
                     'requester': requester,
                     'hasHomeFolder': SecurityContext.currentEcitizen ? true : false,
                     'returnUrl' : (params.returnUrl != null ? params.returnUrl : "")
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
                def subject = individualService.getById(subjectId)
                subjects[subjectId] = subject.lastName + ' ' + subject.firstName
            }
            
            if(cRequest.draft && cRequest.subjectId && !subjects.containsKey(cRequest.subjectId))
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
                if (paramKeyPrefix == 'requester')
                    checkRequesterPassword(param.value)
                DataBindingUtils.initBind(object, param.value)
                bindParam (object, param.value)
            }
        }
    }
    
    def checkRequesterPassword (params) {
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
     
    def makeDoument(docParam, sessionUuid) {
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
    
    /* Utils
     * ------------------------------------------------------------------------------------------- */
    
    // Convert a substring of <input type=submit name > representing target object of action in a map
    def targetAsMap(stringTarget) {
        def result = [:]
        stringTarget.tokenize('_').each {
            def property = it.tokenize(':')
            result[property[0]] = property[1]
        }
        return result
    }
    
}
