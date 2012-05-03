import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.exception.CvqModelException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.service.request.IRequestWorkflowService
import fr.cg95.cvq.service.request.IDisplayGroupService

import org.codehaus.groovy.grails.web.context.ServletContextHolder

public class RequestTypeAdaptorService {
    
    IRequestTypeService requestTypeService
    IRequestServiceRegistry requestServiceRegistry
    IRequestWorkflowService requestWorkflowService
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
                                              'seasons' : requestServiceRegistry.getRequestService(rt.label).isOfRegistrationKind() ? requestTypeService.getOpenSeasons(rt) : [],
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

    // FIXME - feature duplicated in CertificateService
    // TODO - mutualize
    public Map getLocalReferentialTypes(requestTypeLabel) {
        def result = [:]
        try {
            localReferentialService.getLocalReferentialTypes(requestTypeLabel).each {
                result.put(StringUtils.firstCase(it.name,'Lower'), it)
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
 
        if (!requestType.active)
            i18nError.add('requestType.message.inactive')
        if (!service.supportUnregisteredCreation() && homeFolder == null)
            i18nError.add('requestType.message.onlyRegisteredUsers')
        if (!requestTypeService.isRegistrationOpen(requestType.id))
            i18nError.add('requestType.message.registrationClosed')
        if (homeFolder != null
            && service.subjectPolicy != IRequestWorkflowService.SUBJECT_POLICY_NONE
            && requestWorkflowService.getAuthorizedSubjects(requestType, homeFolder.id)?.isEmpty())
                i18nError.add('requestType.message.noAuthorizedSubjects')
        if (requestType.label.equals(IRequestTypeService.HOME_FOLDER_MODIFICATION_REQUEST)) {
            try {
                requestWorkflowService.isAccountModificationRequestAuthorized(SecurityContext.currentEcitizen.homeFolder)
            } catch (CvqModelException cvqme) {
                i18nError.add(cvqme.i18nKey)
            }
        }

        return i18nError
    }
    
    public String generateAcronym(label) {
        def acronym = ''
        label.split(' ').each {
            acronym += it[0].toLowerCase()
        }
        return acronym + 'r'
    }
}
