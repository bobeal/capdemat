import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Address
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService

import grails.converters.JSON

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class RequestCreationController {
    
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    
    def translationService
    def defaultAction = 'edit'
    
     
    def edit = {
        if (params.label == null)
          redirect(uri: '/frontoffice/requestType')

        def requestService = requestServiceRegistry.getRequestService(params.label)
        def cRequest = requestService.getSkeletonRequest()
        def uuidString = UUID.randomUUID().toString()
        
        session[uuidString] = [:]
        session[uuidString].put('cRequest', cRequest)
        
        render( view: 'frontofficeRequestType/domesticHelpRequest/edit', 
                model:
                    ['rqt': cRequest, 
                    'subjects': getAuthorizedSubjects(requestService),
                    'documentTypes': getDocumentTypes(requestService),
                    'meansOfContact': getMeansOfContact(),
                    'currentStep': 'subject',
                    'requestTypeLabel': params.label,
                    'uuidString': uuidString
                    ])
    }
    

    def step = {
        log.debug('POST step() - start')
        
        if (params.requestTypeInfo == null || params.uuidString == null)
            redirect(uri: '/frontoffice/requestType')
            
        def uuid = params.uuidString
        def requestTypeInfo = JSON.parse(params.requestTypeInfo)
        def currentStep
        
        def requestService = requestServiceRegistry.getRequestService(requestTypeInfo.label)
        def cRequest = session[uuid].cRequest
        
        params.each {
            // manage construction of null objectin databinding object-graph
            if (it.value.getClass() == GrailsParameterMap.class) {
                def getterName = 'get' + StringUtils.firstCase(it.key.tokenize('.')[0], 'Upper')
                def getterMethod = cRequest.class.getMethod(getterName)
                if (getterMethod.invoke(cRequest, null) == null) {
                    def setterMethod = cRequest.class.getMethod(
                            'set' + StringUtils.firstCase(it.key.tokenize('.')[0], 'Upper')
                            ,[getterMethod.returnType] as Class[])
                    def fieldConstructor = getterMethod.returnType.getConstructor(null)
                    setterMethod.invoke(cRequest, [fieldConstructor.newInstance(null)] as Object[])
                }
            }
            
            // Set current step
            if (it.key.startsWith('stepSubmit-'))
                currentStep = it.key.replace('stepSubmit-', '')
        }
    
        bind(cRequest)
        session[uuid].cRequest = cRequest
        
        if (session[uuid].stepStates == null) {
            session[uuid].stepStates = [:]
            requestTypeInfo.steps.each {
                session[uuid].stepStates.put(it, ['cssClass': 'tag-uncomplete', 'i18nKey': 'request.step.state.uncomplete'])
            }
        }
        
        session[uuid].stepStates.get(currentStep).cssClass = 'tag-complete'
        session[uuid].stepStates.get(currentStep).i18nKey = 'request.step.state.complete'
        
        if (currentStep == "validation")
            requestService.create(cRequest)
          
        render( view: 'frontofficeRequestType/domesticHelpRequest/edit',
                model:
                    ['rqt': cRequest,
                    'subjects': getAuthorizedSubjects(requestService),
                    'documentTypes': getDocumentTypes(requestService),
                    'meansOfContact': getMeansOfContact(),
                    'currentStep': currentStep,
                    'requestTypeLabel': requestTypeInfo.label,
                    'stepStates': session[uuid].stepStates,
                    'uuidString': uuid
                    ])
    }

    
    def getAuthorizedSubjects = { requestService ->
        def subjects = [:]
        def authorizedSubjects = requestService.getAuthorizedSubjects(SecurityContext.currentEcitizen.homeFolder.id)
        authorizedSubjects.each { subjectId, seasonsSet ->
            def subject = individualService.getById(subjectId)
            subjects[subjectId] = subject.lastName + ' ' + subject.firstName
        }
        return subjects
    }
    
    def getMeansOfContact = {
        def result = []
        def meansOfContact = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact()
        meansOfContact.each {
            result.add([
                        key:it.type,
                        label: message(code:'request.meansOfContact.' + StringUtils.pascalToCamelCase(it.type.toString()))])
        }
        return result.sort {it.label}
    }
    
    def getDocumentTypes = { requestService ->
        def requestType = requestService.getRequestTypeByLabel(requestService.getLabel())
        def documentTypes = requestService.getAllowedDocuments(requestType.getId())
        def result = [:]
        documentTypes.each {
            result[it.id] = CapdematUtils.adaptDocumentTypeName(it.name)
        }
        return result
    }
    
    
    def conditions = {
    	  log.debug('checkConditions - START')
    }
    
}
