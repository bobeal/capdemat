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
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

import org.codehaus.groovy.grails.web.context.ServletContextHolder

public class RequestTypeAdaptorService {
    
    IRequestTypeService requestTypeService
    IRequestServiceRegistry requestServiceRegistry
    IRequestWorkflowService requestWorkflowService
    ILocalReferentialService localReferentialService
    IDisplayGroupService displayGroupService
    ILocalAuthorityRegistry localAuthorityRegistry

    public Map getDisplayGroups(HomeFolder homeFolder) {
        def result = [:]
        
        for(DisplayGroup dg : displayGroupService.getAll()) {
            if(!result.keySet().contains(dg.name))
                result[dg.name] = ['label':dg.label,'requests':[]]
            
            for(RequestType rt : dg.requestTypes) {
                if (!rt.active) 
                    continue
                def i18nError = null
                try {
                    requestWorkflowService.checkRequestTypePolicy(rt, homeFolder)
                } catch (CvqException e) {
                    i18nError = e.i18nKey
                }
                result[dg.name].requests.add(['label': rt.label,
                                              'seasons' : requestServiceRegistry.getRequestService(rt.label).isOfRegistrationKind() ? requestTypeService.getOpenSeasons(rt) : [],
                                              'enabled': i18nError == null,
                                              'message': i18nError
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

    public String generateAcronym(label) {
        def acronym = ''
        label.split(' ').each {
            acronym += it[0].toLowerCase()
        }
        return acronym + 'r'
    }

    public Map requestTypeResources(requestTypeLabel) {
        def requestTypeLabelAsDir = CapdematUtils.requestTypeLabelAsDir(requestTypeLabel)
        return [
            'lrTypes': getLocalReferentialTypes(requestTypeLabel),
            'requestTypeLabel': requestTypeLabel,
            'requestTypeLabelAsDir' : requestTypeLabelAsDir,
            'helps': localAuthorityRegistry.getBufferedCurrentLocalAuthorityRequestHelpMap(requestTypeLabelAsDir),
            'availableRules' : localAuthorityRegistry.getLocalAuthorityRules(requestTypeLabelAsDir),
            'customJS' : getCustomJS(requestTypeLabel)
         ]
    }
}
