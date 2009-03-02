import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.exception.CvqException

import grails.converters.JSON

class RequestCreationController {
    
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    def documentAdaptorService
    
    def defaultAction = 'edit'
    
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
            'label':requestService.label,'currentTabIndex': params?.currentTabIndex])
        return false
    }
    
    def edit = {
        if (params.label == null)
            redirect(uri: '/frontoffice/requestType')

        def requestService = requestServiceRegistry.getRequestService(params.label)
        if (requestService == null) {
            redirect(uri: '/frontoffice/requestType')
            return false
        }
        
        def cRequest
        if (flash.cRequest) cRequest = flash.cRequest 
        else cRequest = requestService.getSkeletonRequest()
        
        def newDocuments = []
        
        def uuidString = UUID.randomUUID().toString()
        
        session[uuidString] = [:]
        session[uuidString].cRequest = cRequest
        session[uuidString].newDocuments = newDocuments
        session[uuidString].draftVisible = (cRequest.draft && !flash.fromDraft)
        
        def viewPath = "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(params.label)}/edit"
        render(view: viewPath, model: [
            'isRequestCreation': true,
            'rqt': cRequest,
            'draftVisible': session[uuidString].draftVisible,
            'subjects': getAuthorizedSubjects(requestService, cRequest),
            'meansOfContact': getMeansOfContact(meansOfContactService),
            'currentStep': 'subject',
            'requestTypeLabel': params.label,
            'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
            'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(params.label)),
            'uuidString': uuidString,
            'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
            'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, newDocuments),
            'isDocumentEditMode': false
        ])
    }
    
    def step = {
        if (params.requestTypeInfo == null || params.uuidString == null || session[params.uuidString] == null)
            redirect(uri: '/frontoffice/requestType')
            
        def uuidString = params.uuidString
        def requestTypeInfo = JSON.parse(params.requestTypeInfo)
        
        def submitAction = (params.keySet().find { it.startsWith('submit-') }).tokenize('-')
        def currentStep = submitAction[2]
        def editList
        
        def requestService = requestServiceRegistry.getRequestService(requestTypeInfo.label)
        def cRequest = session[uuidString].cRequest
        
        def isDocumentEditMode = false
        def documentType = [:]
        def document = [:]
        // manage document create with current request (those can be deleted)
        // Do not work in draft case
        def newDocuments = session[uuidString].newDocuments 
        
        def askConfirmCancel = false
        
        if (cRequest.stepStates.size() == 0) {
            session[uuidString].stepStates = [:]
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
            if (submitAction[1] != 'discardCancelRequest')
                session[uuidString].draftVisible = true
            
            if (submitAction[1] == 'cancelRequest') {
                session[uuidString].draftVisibleBackUp = session[uuidString].draftVisible
                session[uuidString].draftVisible = false
                askConfirmCancel = true
            }
            else if (submitAction[1] == 'confirmCancelRequest') {
                session.removeAttribute(uuidString)
                redirect(uri: '/frontoffice/requestType')
                return
            }
            else if (submitAction[1] == 'discardCancelRequest') {
                session[uuidString].draftVisible = session[uuidString].draftVisibleBackUp
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
                document = documentAdaptorService.getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentSave') {
                def docParam = targetAsMap(submitAction[3])
                isDocumentEditMode = false
                if (docParam.id != null) {
                    def doc = documentService.getById(Long.valueOf(docParam.id))
                    doc.ecitizenNote = params.ecitizenNote
                }
            }
            else if (submitAction[1] == 'documentDelete') {
                def docParam = targetAsMap(submitAction[3])
                requestService.removeDocument(cRequest, Long.valueOf(docParam.id))
                documentService.delete(Long.valueOf(docParam.id))  
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
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;
                
                def newDocBinary = new DocumentBinary()
                if (docParam.id == null) {
                    def newDoc = new Document()
                    newDoc.homeFolderId = SecurityContext.currentEcitizen.homeFolder.id
                    newDoc.ecitizenNote = params.ecitizenNote
                    newDoc.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(docParam.documentTypeId))
                    docParam.id = documentService.create(newDoc)
                    requestService.addDocument(cRequest, Long.valueOf(docParam.id))
                    newDocuments.add(docParam.id)
                }
                newDocBinary.data = request.getFile('documentData-0').bytes
                documentService.addPage(Long.valueOf(docParam.id), newDocBinary)
                document = documentAdaptorService.getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentModifyPage') {
                def docParam = targetAsMap(submitAction[3])
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true
                def newDocBinary = documentService.getPage(Long.valueOf(docParam.id), Integer.valueOf(docParam.dataPageNumber))
                newDocBinary.data = request.getFile('documentData-' + docParam.dataPageNumber).bytes
                documentService.modifyPage(Long.valueOf(docParam.id), newDocBinary)
                document = documentAdaptorService.getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentDeletePage') {
                def docParam = targetAsMap(submitAction[3])
                documentType = documentAdaptorService.getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true
                documentService.deletePage(Long.valueOf(docParam.id), Integer.valueOf(docParam.dataPageNumber))
                document = documentAdaptorService.getDocument(Long.valueOf(docParam.id))
            }
            // removal of a collection element
            else if (submitAction[1] == 'collectionDelete') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def getterMethod = cRequest.class.getMethod('get' + StringUtils.firstCase(listFieldToken[0], 'Upper'))
                        
                getterMethod.invoke(cRequest, null).remove(Integer.valueOf(listFieldToken[1]).intValue())
            }
            // edition of a collection element
            else if (submitAction[1] == 'collectionEdit') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def getterMethod = cRequest.class.getMethod('get' + StringUtils.firstCase(listFieldToken[0], 'Upper'))
                        
                editList = ['name': listFieldToken[0], 
                            'index': listFieldToken[1],
                            (listFieldToken[0]): getterMethod.invoke(cRequest, null).get(Integer.valueOf(listFieldToken[1]).intValue())
                           ]
            }
            // standard save action
            else {
                DataBindingUtils.initBind(cRequest, params)
                bind(cRequest)
                // clean empty collections elements
                DataBindingUtils.cleanBind(cRequest, params)
                
                if (submitAction[1] == 'step') {
                    cRequest.stepStates.get(currentStep).state = 'complete'
                    cRequest.stepStates.get(currentStep).cssClass = 'tag-complete'
                    cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.complete'
                    cRequest.stepStates.get(currentStep).errorMsg = ''
                }
                
                if (currentStep == "validation") {
                    if (!cRequest.draft) requestService.create(cRequest)
                    else requestService.finalizeDraft(cRequest)
                }
            }        
            session[uuidString].cRequest = cRequest
            session[uuidString].newDocuments = newDocuments
        
        } catch (CvqException ce) {
            cRequest.stepStates.get(currentStep).state = 'invalid'
            cRequest.stepStates.get(currentStep).cssClass = 'tag-invalid'
            cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.error'
            cRequest.stepStates.get(currentStep).errorMsg = ce.message

            // FIXME BOR : what does it do ???
            if(!session[uuidString].cRequest.draft && !session[uuidString].draftVisible)
                session[uuidString].draftVisible = false
        }

        render( view: "frontofficeRequestType/${CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)}/edit",
                model:
                    ['isRequestCreation': true,
                     'askConfirmCancel': askConfirmCancel, 
                     'rqt': cRequest,
                     'draftVisible': session[uuidString].draftVisible,                     
                     'subjects': getAuthorizedSubjects(requestService, cRequest),
                     'meansOfContact': getMeansOfContact(meansOfContactService),
                     'currentStep': currentStep,
                     'requestTypeLabel': requestTypeInfo.label,
                     'stepStates': cRequest.stepStates,
                     'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)),
                     'uuidString': uuidString,
                     'editList': editList,
                     'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
                     'documentTypes': documentAdaptorService.getDocumentTypes(requestService, cRequest, newDocuments),
                     'isDocumentEditMode': isDocumentEditMode,
                     'documentType': documentType,
                     'document': document
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
    
    
    /* Step and Validation
     * ------------------------------------------------------------------------------------------- */
    
    def getAuthorizedSubjects(requestService, cRequest) {
        def subjects = [:]
        def authorizedSubjects = requestService.getAuthorizedSubjects(SecurityContext.currentEcitizen.homeFolder.id)
        authorizedSubjects.each { subjectId, seasonsSet ->
            def subject = individualService.getById(subjectId)
            subjects[subjectId] = subject.lastName + ' ' + subject.firstName
        }
        
        if(cRequest.draft && cRequest.subjectId && !subjects.containsKey(cRequest.subjectId))
            subjects[cRequest.subjectId] = "${cRequest.subjectLastName} ${cRequest.subjectFirstName}"
            
        return subjects
    }
    
    def getMeansOfContact(meansOfContactService) {
        def result = []
        def meansOfContact = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact()
        meansOfContact.each {
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

