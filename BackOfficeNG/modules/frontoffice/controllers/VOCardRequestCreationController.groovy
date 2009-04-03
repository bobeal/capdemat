import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.request.MeansOfContactEnum
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Address
import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.business.users.TitleType
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService
import fr.cg95.cvq.exception.CvqException

import grails.converters.JSON

class VOCardRequestCreationController {

    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    IRequestTypeService requestTypeService
    IVoCardRequestService voCardRequestService
    IHomeFolderService homeFolderService

    def jcaptchaService

    def defaultAction = 'edit'

    def edit = {
            def cRequest = voCardRequestService.getSkeletonRequest();

            def uuidString = UUID.randomUUID().toString()

            def requestService = requestServiceRegistry.getRequestService(cRequest)

            def adults = []
            def children = []
            def childrenLegalResponsibles = [:]
            def account = ['question':null,
                           'answer':null,
                           'password':null,
                           'confirmPassword':null,
                           'homeFolderResponsible':null,
                           ]
            def currentChild = ['id': 0,
                                'child': new Child(),
                                'adultLegalResponsibles': [],
                                'legalResponsibles': []
                                ]

            session[uuidString] = [:]
            session[uuidString].put('cRequest', cRequest)

            session[uuidString].put('adults', adults)
            session[uuidString].put('children', children)
            session[uuidString].put('account', account)
            session[uuidString].put('childrenLegalResponsibles', childrenLegalResponsibles)
            session[uuidString].put('currentChild', currentChild)

            def viewPath = "frontofficeRequestType/vOCardRequest/edit"

            render(view: viewPath, model: [
                 'rqt': cRequest,
                 'meansOfContact': getMeansOfContact(meansOfContactService, account, adults),
                 'currentStep': 'adults',
                 'requestTypeLabel': params.label,
                 'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
                 'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(params.label)),
                 'uuidString': uuidString,
                 'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
                 'documentTypes': getDocumentTypes(requestService, cRequest),
                 'isDocumentEditMode': false,
                 'adults': adults,
                 'children':children,
                 'account': account,
                 'childrenLegalResponsibles': childrenLegalResponsibles,
                 'currentChild': currentChild,
                 'isChildLegalResponsibleEdit': false,
                  ])
    }

    def step = {
        if (params.requestTypeInfo == null || params.uuidString == null)
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

        def adults = session[uuidString].adults
        def children = session[uuidString].children
        def account = session[uuidString].account
        def childrenLegalResponsibles = session[uuidString].childrenLegalResponsibles
        def currentChild = session[uuidString].currentChild

        def isChildLegalResponsibleEdit = false
        
        def askConfirmCancel = false

        if (cRequest.stepStates.size() == 0) {
            session[uuidString].stepStates = [:]
            requestTypeInfo.steps.each {
                def nameToken = it.tokenize('-')
                def value = ['state': 'uncomplete',
                             'required': nameToken.size() == 2 ? true : false,
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
            // documents
            else if (submitAction[1] == 'documentAdd') {
                def docParam = targetAsMap(submitAction[3])
                documentType = getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;
            }
            else if (submitAction[1] == 'documentEdit') {
                def docParam = targetAsMap(submitAction[3])
                documentType = getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;
                document = getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentSave') {
                isDocumentEditMode = false;
            }
            else if (submitAction[1] == 'documentCancel') {
                // TODO : implement clean associted document policy
                isDocumentEditMode = false;
            }
            else if (submitAction[1] == 'documentAddPage') {
                def docParam = targetAsMap(submitAction[3])
                documentType = getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;

                def newDocBinary = new DocumentBinary()
                if (docParam.id == null) {
                    def newDoc = new Document()
                    //newDoc.homeFolderId = SecurityContext.currentEcitizen.homeFolder.id
                    newDoc.ecitizenNote = params.ecitizenNote
                    newDoc.documentType = documentTypeService.getDocumentTypeById(Long.valueOf(docParam.documentTypeId))
                    docParam.id = documentService.create(newDoc)
                    requestService.addDocument(cRequest, Long.valueOf(docParam.id))
                }
                newDocBinary.data = request.getFile('documentData-0').bytes
                documentService.addPage(Long.valueOf(docParam.id), newDocBinary)
                document = getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentModifyPage') {
                def docParam = targetAsMap(submitAction[3])
                documentType = getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;
                def newDocBinary = documentService.getPage(Long.valueOf(docParam.id), Integer.valueOf(docParam.dataPageNumber))
                newDocBinary.data = request.getFile('documentData-' + docParam.dataPageNumber).bytes
                documentService.modifyPage(Long.valueOf(docParam.id), newDocBinary)
                document = getDocument(Long.valueOf(docParam.id))
            }
            else if (submitAction[1] == 'documentDeletePage') {
                def docParam = targetAsMap(submitAction[3])
                documentType = getDocumentType(Long.valueOf(docParam.documentTypeId))
                isDocumentEditMode = true;
                documentService.deletePage(Long.valueOf(docParam.id), Integer.valueOf(docParam.dataPageNumber))
                document = getDocument(Long.valueOf(docParam.id))
            }
            // removal of a collection element
            else if (submitAction[1] == 'collectionDelete') {
                def listFieldToken = submitAction[3].tokenize('[]')
                def index = Integer.valueOf(listFieldToken[1]).intValue()
                if (listFieldToken[0] == 'adults'){
                     adults.remove(Integer.valueOf(listFieldToken[1]).intValue())
                     removeChildrenLegalResponsible(childrenLegalResponsibles, 'adults[' + index + ']')
                     if (adults.isEmpty()) {
                        cRequest.stepStates.get("adults").state = 'uncomplete'
                        cRequest.stepStates.get("adults").cssClass = 'tag-uncomplete'
                        cRequest.stepStates.get("adults").i18nKey = 'request.step.state.uncomplete'
                        cRequest.stepStates.get("adults").errorMsg = ''
                     }
                }
                else if (listFieldToken[0] == 'children') {
                    children.remove(index)
                    removeChildLegalResponsibles(childrenLegalResponsibles, "children[" + index + "]")
                    currentChild.id = currentChild.id == index ? children.size : (currentChild.id > index ? currentChild.id -1 : currentChild.id)
                    currentChild.legalResponsibles = []
                }
                else if (listFieldToken[0] == 'currentLegalResponsibles') {
                    removeCurrentChildLegalResponsible(currentChild, index);
                    if (submitAction[4] == 'fromChildren') {
                        def adultLegalResponsibles = [:]
                        adults.eachWithIndex{ adult, i ->
                            adultLegalResponsibles.put('adults[' + i + ']', params.find{it.key == "LR_adults[$i]"} != null ? true : false)
                        }
                        bind(currentChild.child)
                        currentChild.adultLegalResponsibles = adultLegalResponsibles
                    }
                    else
                        isChildLegalResponsibleEdit = true
                } 
            }
            // edition of a collection element
            else if (submitAction[1] == 'collectionEdit') {
                def element
                def listFieldToken = submitAction[3].tokenize('[]')
                if (listFieldToken[0] == 'children') {
                    def index = Integer.valueOf(listFieldToken[1]).intValue()
                    currentChild = ['id': index,
                                    'child': children.get(index),
                                    'adultLegalResponsibles': adaptAdultLegalResponsibles(childrenLegalResponsibles, adults, "children[" + index + "]" ),
                                    'legalResponsibles': adaptLegalResponsibles(childrenLegalResponsibles, "children[" + index + "]" )]
                } else {
                    if (listFieldToken[0] == 'adults')
                        element = adults.get(Integer.valueOf(listFieldToken[1]).intValue())
                    else if (listFieldToken[0] == 'currentLegalResponsibles') {
                        if (submitAction[4] == 'fromChildren') {
                            def adultLegalResponsibles = [:]
                            adults.eachWithIndex{ adult, i ->
                                adultLegalResponsibles.put('adults[' + i + ']', params.find{it.key == "LR_adults[$i]"} != null ? true : false)
                            }
                            bind(currentChild.child)
                            currentChild.adultLegalResponsibles = adultLegalResponsibles
                        }
                        element = currentChild.legalResponsibles.get(Integer.valueOf(listFieldToken[1]).intValue())
                        isChildLegalResponsibleEdit = true
                    }
                    editList = ['name': listFieldToken[0],
                                'index': listFieldToken[1],
                                (listFieldToken[0]): element]
                }
            }
            // addition or modification of a collection element
            else if (submitAction[1] == 'collectionAdd' || submitAction[1] == 'collectionModify') {
                def index = Integer.valueOf(submitAction[3].tokenize('[]')[1])
                if (currentStep == "adults") {
                    adults[index] = bind(getAdult())
                    if(submitAction[1] == 'collectionModify')
                        updateChildrenLegalResponsible(childrenLegalResponsibles, adults[index], "adults["+ index + "]")
                }
                else if (currentStep == "children") {
                    if (submitAction[3].tokenize('[]')[0] == "children") {
                        if (params.findAll{it.key.startsWith("LR_")}.isEmpty() || params.findAll{it.key.startsWith("LR_")}.size() > 3) {
                            bind(currentChild.child)
                            cRequest.stepStates.get(currentStep).errorMsg = message(code:"vcr.error.legalResponsiblesRequired")
                        } else {
                            children[index] = bind(currentChild.child)
                            addChildrenLegalResponsibles(childrenLegalResponsibles, adults, currentChild.legalResponsibles,
                                "children[" + index + "]", params.findAll{it.key.startsWith("LR_")})
                            currentChild = ['id': children.size(),
                                            'child': new Child(),
                                            'adultLegalResponsibles': [],
                                            'legalResponsibles': []]
                            cRequest.stepStates.get(currentStep).errorMsg = ''
                        }
                    } else {
                        isChildLegalResponsibleEdit = true
                        currentChild.legalResponsibles[index] = ['id': index,
                                                                 'individual': bind(getAdult()),
                                                                 'role': params.role.tokenize('_')[1]] 
                    }
                }
            }
            else if (submitAction[1] == 'collectionCancel') {
                def listFieldToken = submitAction[3].tokenize('[]')
                if (currentStep == "children") {
                    if (listFieldToken[0] == 'children') {
                        currentChild = ['id': children.size(),
                                        'child': new Child(),
                                        'adultLegalResponsibles': [],
                                        'legalResponsibles': []]
                    } else
                        isChildLegalResponsibleEdit = true
                }
            }
            // edition of a legal responsible
            else if (submitAction[1] == 'legalResponsibleAdd') {
                def index = Integer.valueOf(submitAction[3].tokenize('[]')[1])
                def adultLegalResponsibles = [:]
                adults.eachWithIndex{ adult, i ->
                    adultLegalResponsibles.put('adults[' + i + ']', params.find{it.key == "LR_adults[$i]"} != null ? true : false)
                }
                bind(currentChild.child)
                currentChild.adultLegalResponsibles = adultLegalResponsibles
                isChildLegalResponsibleEdit = true
            }
            // step validation
            else {
                if (currentStep == "adults") {
                    if (adults.size() == 0)
                       throw new CvqException(message(code:"vcr.error.adultRequired"))
                } 
                else if (currentStep == "account") {
                    bindAccountData(account, params)
                    if (params.confirmPassword != params.password) {
                        account.confirmPassword = ''
                        throw new CvqException(message(code:"vcr.error.password"))
                    }
                }
                else if (currentStep == "validation") {
                    if(!jcaptchaService.validateResponse("image", session.id, params.response))
                            throw new CvqException(message(code:"vcr.error.captcha"))
                    def homeFolderResponsible = addHomeFolderResponsible(adults, account)
                    addIndividualRoles(children, childrenLegalResponsibles)
                    voCardRequestService.create(cRequest, getAdults(adults, childrenLegalResponsibles), children, homeFolderResponsible.adress)
                    redirect( action:'success',
                              params:['requestId': cRequest.id,
                                      'login': homeFolderResponsible.login])
                }
                if (submitAction[1] == 'step') {
                    cRequest.stepStates.get(currentStep).state = 'complete'
                    cRequest.stepStates.get(currentStep).cssClass = 'tag-complete'
                    cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.complete'
                    cRequest.stepStates.get(currentStep).errorMsg = ''
                }
            }

            if (account.homeFolderResponsible != null
                && adults[Integer.valueOf(account.homeFolderResponsible.tokenize("[]")[1])] == null) {
                account.homeFolderResponsible = null
                cRequest.stepStates.get("account").state = 'uncomplete'
                cRequest.stepStates.get("account").cssClass = 'tag-uncomplete'
                cRequest.stepStates.get("account").i18nKey = 'request.step.state.uncomplete'
                cRequest.stepStates.get("account").errorMsg = ''
            }

            if (!validateChildrenLegalResponsibles(childrenLegalResponsibles)){
                cRequest.stepStates.get("children").state = 'invalid'
                cRequest.stepStates.get("children").cssClass = 'tag-invalid'
                cRequest.stepStates.get("children").i18nKey = 'request.step.state.error'
                cRequest.stepStates.get("children").errorMsg = message(code:"vcr.error.childrenLegalResponsibles")
            }
            
            session[uuidString].cRequest = cRequest
            session[uuidString].currentChild = currentChild
            session[uuidString].adults = adults
            session[uuidString].children = children
            session[uuidString].account = account
            session[uuidString].childrenLegalResponsibles = childrenLegalResponsibles

        } catch (CvqException ce) {
            cRequest.stepStates.get(currentStep).state = 'invalid'
            cRequest.stepStates.get(currentStep).cssClass = 'tag-invalid'
            cRequest.stepStates.get(currentStep).i18nKey = 'request.step.state.error'
            cRequest.stepStates.get(currentStep).errorMsg = ce.message
        }

        def viewPath = "frontofficeRequestType/vOCardRequest/edit"

        render( view: viewPath,
                model:
                    [ 'rqt': cRequest,
                      'askConfirmCancel': askConfirmCancel,
                      'meansOfContact': getMeansOfContact(meansOfContactService, account, adults),
                      'currentStep': currentStep,
                      'requestTypeLabel': requestTypeInfo.label,
                      'stepStates': cRequest.stepStates?.size() != 0 ? cRequest.stepStates : null,
                      'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(CapdematUtils.requestTypeLabelAsDir(requestTypeInfo.label)),
                      'uuidString': uuidString,
                      'editList': editList,
                      'isRequestCreatable': isRequestCreatable(cRequest.stepStates),
                      'documentTypes': getDocumentTypes(requestService, cRequest),
                      'isDocumentEditMode': isDocumentEditMode,
                      'documentType': documentType,
                      'document': document,
                      'adults': adults,
                      'children': children,
                      'account': account,
                      'childrenLegalResponsibles': childrenLegalResponsibles,
                      'currentChild': currentChild,
                      'isChildLegalResponsibleEdit': isChildLegalResponsibleEdit,
                     ])
    }

    def success = {
        render (view:"frontofficeRequestType/vOCardRequest/success", 
                model:['requestId': params.requestId,
                       'login': params.login
                       ])
    }
    
    def condition = {
        def result = []
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

    def getMeansOfContact(meansOfContactService, account, adults) {
        def result = []
        def meansOfContact
        if (account.homeFolderResponsible != null) {
            def index = Integer.valueOf(account.homeFolderResponsible.tokenize("[]")[1])
            meansOfContact = meansOfContactService.getAdultEnabledMeansOfContact(adults[index])
        } else
            meansOfContact = meansOfContactService.getEnabledMeansOfContact()
        
        meansOfContact.each {
            result.add([
                        key:it.type,
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

    def addChildrenLegalResponsibles(childrenLegalResponsibles, adults, currentLegalResponsibles, childRef, params) {
        def role
        def childLegalResponsibles = [:]
        def individual
        def key
        
        params.each {
            def listFieldToken = it.key.tokenize('[]')
            if (listFieldToken[0] == "LR_adults") {
                individual = adults[Integer.valueOf(listFieldToken[1])]
                role = getRoleTypeByTitle(individual.title)
            } else {
                individual = currentLegalResponsibles[Integer.valueOf(listFieldToken[1])].individual
                role = currentLegalResponsibles[Integer.valueOf(listFieldToken[1])].role
            }
             def legalResponsible = ['individual': individual,
                                     'role': role
                                     ]
             childLegalResponsibles.put(it.key.replace("LR_", ""),legalResponsible)
        }
        childrenLegalResponsibles.put(childRef ,childLegalResponsibles)
    }

    def removeChildrenLegalResponsible(childrenLegalResponsibles, adultLegalResponsibleRef) {
        childrenLegalResponsibles.each {
           it.value.remove(adultLegalResponsibleRef)
        }
    }

    def removeChildLegalResponsibles(childrenLegalResponsibles, childRef) {
        def childId = Integer.valueOf(childRef.tokenize('[]')[1])
        childrenLegalResponsibles.remove(childRef)
        childrenLegalResponsibles.each {
            def index = Integer.valueOf(it.key.tokenize('[]')[1])
            if (index > childId)
                 childrenLegalResponsibles.put('children[' + --index + ']', it.value)
        }
        if (childrenLegalResponsibles.size() > 1)
            childrenLegalResponsibles.remove('children['+ (childrenLegalResponsibles.size() - 1) +']')

    }

    def updateChildrenLegalResponsible(childrenLegalResponsibles, individual, individualRef) {
        childrenLegalResponsibles.each {
            it.value.findAll {
                it.key == individualRef
            }.each {
                it.value.individual = individual
                it.value.role = getRoleTypeByTitle(individual.title)
            }
        }
    }

    def validateChildrenLegalResponsibles(childrenLegalResponsibles) {
        return childrenLegalResponsibles.find {it.value.isEmpty()} == null && childrenLegalResponsibles.find {it.value.size() > 3} == null
    }

    def removeCurrentChildLegalResponsible(currentChild, index) {
        currentChild.legalResponsibles.remove(index)
        currentChild.legalResponsibles.eachWithIndex { it, i ->
            it.id = i
       }
    }

    def adaptLegalResponsibles(childrenLegalResponsibles, childId ){
        def legalResponsibles = []
        childrenLegalResponsibles.get(childId).each {
            if (it.key.tokenize('[]')[0] == "legalResponsibles") {
                legalResponsibles.add(['id': it.key.tokenize('[]')[1],
                                       'individual': it.value.individual,
                                       'role': it.value.role,
                                       ])
            }
        }
        return legalResponsibles.sort{ it.id }
    }

    def adaptAdultLegalResponsibles(childrenLegalResponsibles, adults, childId) {
        def adultLegalResponsibles = [:]
        adults.eachWithIndex{ adult, i ->
            adultLegalResponsibles.put('adults[' + i + ']',
                childrenLegalResponsibles.get(childId).find{ it.key =="adults[" + i + "]"} != null ? true : false)
        }
        return adultLegalResponsibles
    }

    def childHasLegalResponsibles(currentChild) {
        return !currentChild.adultLegalResponsibles.isEmpty() || !currentChild.legalResponsibles.isEmpty()
    }

    def getRoleTypeByTitle(title) {
        def role

        if (title.equals(TitleType.MISTER))
            role = RoleType.CLR_FATHER
        else if (title.equals(TitleType.AGENCY))
            role = RoleType.CLR_TUTOR
        else
            role = RoleType.CLR_MOTHER

        return role
    }

    def getRoleType(role) {
        return RoleType.forString(role)
    }

    def bindAccountData(account, params) {
        account.question = params.question
        account.answer = params.answer
        account.password = params.password
        account.confirmPassword = params.confirmPassword
        account.homeFolderResponsible = params.homeFolderResponsible
    }

    def getAdult() {
        Adult adult = new Adult();
        adult.setAdress(new Address())
        return adult
    }

    def getAdults(adults, childrenLegalResponsibles) {
        def result = adults
        childrenLegalResponsibles.each {
            it.value.each {
                if (it.key.tokenize('[]')[0] == "legalResponsibles") 
                    result.add(it.value.individual)
            }
        }
        return result
    }

    /* Home Folder Service
     * ------------------------------------------------------------------------------------------- */

    def addHomeFolderResponsible(adults, account) {
        def index = Integer.valueOf(account.homeFolderResponsible.tokenize('[]')[1])
        adults[index].question = account.question
        adults[index].answer = account.answer
        adults[index].password = account.password
        homeFolderService.addHomeFolderRole(adults[index],RoleType.HOME_FOLDER_RESPONSIBLE)
        return adults[index]
    }

    def addIndividualRoles(children, childrenLegalResponsibles) {
        childrenLegalResponsibles.each {
            def childRef = it.key
            def role
            it.value.each {
                if (it.key.tokenize('[]')[0] == "legalResponsibles")
                    role = getRoleType(it.value.role)
                else
                    role = it.value.role

                homeFolderService.addIndividualRole(it.value.individual,
                        children[Integer.valueOf(childRef.tokenize('[]')[1])],
                        role)
            }
        }
    }


    /* Documents
     * ------------------------------------------------------------------------------------------- */

    def getDocumentTypes(requestService, cRequest) {
        def requestType = requestTypeService.getRequestTypeByLabel(requestService.getLabel())
        def documentTypes = requestTypeService.getAllowedDocuments(requestType.getId())

        def result = [:]
        documentTypes.each {
            def requestDocType = [:]
            requestDocType.i18nKey = CapdematUtils.adaptDocumentTypeName(it.name)
            requestDocType.associated = getAssociatedDocuments(requestService, cRequest, it)
            //requestDocType.provided = documentService.getProvidedDocuments(it, SecurityContext.currentEcitizen.homeFolder.id, null)
            result[it.id] = requestDocType
        }
        return result
    }

    def  getAssociatedDocuments(requestService, cRequest, docType) {
        def requestDocuments = requestService.getAssociatedDocuments(cRequest)
        def documents = requestDocuments.collect{ documentService.getById(it.documentId) }
        return documents.findAll{ it.documentType.id == docType.id }
    }

    def getDocument(id) {
        def doc = documentService.getById(id)
        def result = [:]
        result.id = doc.id
        result.ecitizenNote = doc.ecitizenNote
        result.datas = []
        doc.datas.each {
            result.datas.add(['id': it.id, 'pageNumber':it.pageNumber])
        }
        return result
    }

    def getDocumentType(id) {
        def result = [:]
        def docType = documentTypeService.getDocumentTypeById(id)
        result.id = docType.id
        result.i18nKey = CapdematUtils.adaptDocumentTypeName(docType.name)
        return (result)
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

