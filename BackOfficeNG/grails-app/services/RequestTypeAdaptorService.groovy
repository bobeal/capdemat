import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.service.authority.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IDisplayGroupService

import org.codehaus.groovy.grails.web.context.ServletContextHolder

public class RequestTypeAdaptorService {
    
    IRequestTypeService requestTypeService
    IRequestServiceRegistry requestServiceRegistry
    ILocalReferentialService localReferentialService
    IDisplayGroupService displayGroupService

    public Map getDisplayGroups(HomeFolder homeFolder) {
        def result = [:]
        
        for(DisplayGroup dg : displayGroupService.getAll()) {
            if(!result.keySet().contains(dg.name))
                result[dg.name] = ['label':dg.label,'requests':[]]
            
            for(RequestType rt : dg.requestTypes) {
                if (!rt.active) 
                    continue
                def i18nError = requestTypeNotAccessibleMessages(rt, homeFolder)
                result[dg.name].requests.add(['label': rt.label,
                                              'seasons' : requestServiceRegistry.getRequestService(rt.label).isOfRegistrationKind ? requestTypeService.getOpenSeasons(rt) : [],
                                              'enabled': i18nError.isEmpty(),
                                              'message': !i18nError.isEmpty() ? i18nError.get(0) : null
                                             ])
            }
            
            result[dg.name].requests = result[dg.name].requests.sort{it -> it.label}
        }

        // filter groups with no requests
        def tempMap = result.findAll { k,v ->
        	!v.requests.isEmpty()
        }

		return tempMap
    }

    public Map getLocalReferentialTypes(requestTypeLabel) {
        def result = [:]
        try {
            localReferentialService.getLocalReferentialDataByRequestType(requestTypeLabel).each {
                result.put(StringUtils.firstCase(it.dataName,'Lower'), it)
            }
        } catch (CvqException ce) { /* No localReferentialData found ! */ }

        return result
    }

    public Map getCustomJS(requestTypeLabel) {
        def customJS = [
            dir : "js/frontoffice/requesttype",
            file : CapdematUtils.requestTypeLabelAsDir(requestTypeLabel) + ".js"
        ]
        if (ServletContextHolder.servletContext.getResource(["", customJS.dir, customJS.file].join('/')) != null)
            return customJS
        return null
    }

    public List requestTypeNotAccessibleMessages(RequestType requestType, HomeFolder homeFolder) {
        def i18nError = []
        IRequestService service = requestServiceRegistry.getRequestService(requestType.label);
 
        if (!service.supportUnregisteredCreation() && homeFolder == null)
            i18nError.add('requestType.message.onlyRegisteredUsers')
        if (!requestTypeService.isRegistrationOpen(requestType.id))
            i18nError.add('requestType.message.registrationClosed')
        if (homeFolder != null
            && service.subjectPolicy != IRequestService.SUBJECT_POLICY_NONE
            && service.getAuthorizedSubjects(homeFolder.id)?.isEmpty())
                i18nError.add('requestType.message.noAuthorizedSubjects')

        return i18nError
    }
}
