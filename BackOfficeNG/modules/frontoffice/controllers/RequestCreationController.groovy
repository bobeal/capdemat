import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Address
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IMeansOfContactService
import fr.cg95.cvq.service.users.IIndividualService

class RequestCreationController {
    
    IRequestServiceRegistry requestServiceRegistry
    ILocalAuthorityRegistry localAuthorityRegistry
    IMeansOfContactService meansOfContactService
    IIndividualService individualService
    
    def translationService
    
    def defaultAction = 'edit'
    def currentTab = 'subject'
    
    // TODO - define in a hidden field
    def steps = [
      'subject',
      'familyReferent',
      'spouse',
      'dwelling',
      'resources',
      'taxes',
      'document',
      'validation'
    ]
    
    
    def edit = {
        if (params.label == null)
          return;
        def stepStates
        if (stepStates == null) {
            stepStates = [:]
            steps.each {
                stepStates.put(it, ['cssClass': 'tag-pending', 'i18nKey': 'request.step.state.uncomplete'] )
            }
        }
        session['stepStates'] = stepStates

        def requestService = requestServiceRegistry.getRequestService(params.label)
        
        def cRequest
        if (session["cRequest"] == null)
            cRequest = requestService.getSkeletonRequest()

        session["cRequest"] = cRequest

        render( view: "frontofficeRequestType/domesticHelpRequest/edit", 
                model:
                  ["request": cRequest, 
                    currentTab: currentTab, 
                    subjects: getAuthorizedSubjects(requestService),
                    help: getHelp(),
                    documentTypes: getDocumentTypes(requestService),
                    meansOfContact: getMeansOfContact(),
                    requestTypeLabel: params.label, 
                    stepStates: stepStates
                  ])
    }
    

    def step = {
        def requestService = requestServiceRegistry.getRequestService(params.requestTypeLabel)
        def cRequest = session["cRequest"]
        bind(cRequest)
        
        

        log.debug("POST step() - start")
        println("cRequest -> " + cRequest.dhrRequesterBirthPlace)
        
        println("params -> " + params)
        session["cRequest"] = cRequest
//        session['stepStates'].subject = 
//            ['cssClass': 'tag-complete', 'i18nKey': 'request.step.state.complete'] 
       
        render(view: "frontofficeRequestType/domesticHelpRequest/edit", 
               model:
                ["request": cRequest,
                  currentTab:'subject',
                  subjects:getAuthorizedSubjects(requestService),
                  help:getHelp(),
                  documentTypes:getDocumentTypes(requestService),
                  meansOfContact:getMeansOfContact(),
                  requestTypeLabel: params.requestTypeLabel, 
                  stepStates:session['stepStates']
                ])
    }

    
    def getAuthorizedSubjects = { requestService ->
        def subjects = [:]
        def authorizedSubjects = requestService.getAuthorizedSubjects(SecurityContext.currentEcitizen.homeFolder.id)
        authorizedSubjects.each { subjectId, seasonsSet ->
            def subject = individualService.getById(subjectId)
            subjects[subjectId] = subject.lastName + " " + subject.firstName
        }
        return subjects
    }
    
    def getMeansOfContact = {
        def result = []
        def meansOfContact = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact()
        meansOfContact.each {
            result.add([
                        key:it.type,
                        label: message(code:"request.meansOfContact." + StringUtils.pascalToCamelCase(it.type.toString()))])
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
    
    def getHelp = {
        def help = [:]
        steps.each {
            help[it] = localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelp("domesticHelpRequest",it)
        }
        return help
    }
    
    def checkConditions = {
    	  log.debug("checkConditions - START")
    }
    
}
