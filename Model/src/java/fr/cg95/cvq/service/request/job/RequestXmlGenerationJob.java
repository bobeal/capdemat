package fr.cg95.cvq.service.request.job;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.util.helpers.SetHelper;


/**
 * This job is parametrized to generate and erase traced 
 * request xml files.
 * 
 * @author vba@zenexity.fr
 *
 */
public class RequestXmlGenerationJob {

    private IRequestDAO              requestDAO;
    private ILocalAuthorityRegistry  localAuthorityRegistry;
    private IExternalService externalService;
    
    public void launchJob() throws CvqException, IOException {
        localAuthorityRegistry.browseAndCallback(this, "performGeneration", null);
        localAuthorityRegistry.browseAndCallback(this, "eraseAcknowledgedRequests", null);
    }
    
    public void performGeneration() throws CvqException, IOException, 
        InstantiationException, IllegalAccessException, ClassNotFoundException {
        
        Set<String> types = externalService.getGenerableRequestTypes();
        
        Set<String> statuses = new HashSet<String>();
        statuses.add(TraceStatusEnum.ACKNOWLEDGED.toString());

        Set<Long> requestIds = externalService.getValidatedRequestIds(types, -2);
        requestIds = SetHelper.MakeRelativeComplement(
            externalService.getTraceKeysByStatus(requestIds,statuses), 
            requestIds);
        
        for (Long id : requestIds) {
            if (!xmlFileExists(id)) {
                Request r = (Request) requestDAO.findById(Request.class, id);
                localAuthorityRegistry.saveLocalAuthorityResource(
                    Type.REQUEST_XML, String.valueOf(id),
                    r.modelToXmlString().getBytes());
            }
        }
    }
    
    public void eraseAcknowledgedRequests() {
        Set<ExternalServiceTrace> traces = 
            externalService.getTracesByStatus(TraceStatusEnum.ACKNOWLEDGED);
        
        for (ExternalServiceTrace t : traces) {
            localAuthorityRegistry.removeLocalAuthorityResource(
                Type.REQUEST_XML, t.getKey());
        }
    }
    
    protected boolean xmlFileExists(Long id) {
        File file = localAuthorityRegistry.getLocalAuthorityResourceFile(
            Type.REQUEST_XML, String.valueOf(id), false);
        if (file == null) return false;
        else return file.exists();
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
