package fr.cg95.cvq.service.request.job;

import java.io.File;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestExportService;
import fr.cg95.cvq.service.request.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.xml.common.RequestType;

/**
 * This job is parametrized to generate and erase traced 
 * request xml files.
 * 
 * @author vba@zenexity.fr
 *
 */
public class RequestXmlGenerationJob {

    private static Logger logger = Logger.getLogger(RequestXmlGenerationJob.class);
    
    private IRequestSearchService requestSearchService;
    private IRequestExportService requestExportService;
    private IRequestExternalService requestExternalService;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IExternalService externalService;

    public void launchJob() {
        localAuthorityRegistry
            .browseAndCallback(this, "performGeneration", null);
        localAuthorityRegistry
            .browseAndCallback(this, "eraseAcknowledgedRequests", null);
    }

    public void performGeneration() throws CvqException {
        
        Set<String> requestTypes = requestExternalService.getGenerableRequestTypes();
        if (requestTypes.isEmpty()) {
            logger.warn("no request types to handle, returning");
            return;
        }

        Set<Critere> criteriaSet = new HashSet<Critere>(2);
        criteriaSet.add(new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL,
            requestExternalService.getGenerableRequestTypes(), Critere.IN));
        criteriaSet.add(new Critere(Request.SEARCH_BY_VALIDATION_DATE,
            DateUtils.getShiftedDate(Calendar.DAY_OF_YEAR, -2), Critere.GTE));
        Critere statusCritere =
            new Critere(ExternalServiceTrace.SEARCH_BY_STATUS,
                TraceStatusEnum.ACKNOWLEDGED, Critere.EQUALS);
        for (Request r : requestSearchService.get(criteriaSet, null, null, 0, 0)) {
            criteriaSet.clear();
            criteriaSet.add(statusCritere);
            criteriaSet.add(new Critere(ExternalServiceTrace.SEARCH_BY_KEY,
                String.valueOf(r.getId()), Critere.EQUALS));
            if (!xmlFileExists(r.getId())
                && externalService.getTraces(criteriaSet, null, null).isEmpty()) {
                
                // TODO : port this properly in 4.2
                XmlObject xmlObject = requestExportService.fillRequestXml(r);
                RequestType requestType = null;
                try {
                    requestType =  (fr.cg95.cvq.xml.common.RequestType) xmlObject.getClass().getMethod("get" + xmlObject.getClass().getSimpleName().replace("DocumentImpl", "")).invoke(xmlObject);
                } catch (Exception e) {
                    logger.error("performGeneration() Unexpected exception while converting to XML "
                            + e.getMessage());
                }

                localAuthorityRegistry.saveLocalAuthorityResource(
                    Type.REQUEST_XML, String.valueOf(r.getId()),
                    requestType.xmlText().getBytes());
            }
        }
    }
    
    public void eraseAcknowledgedRequests() {
        Set<Critere> criteres = new HashSet<Critere>();
        criteres.add(new Critere(ExternalServiceTrace.SEARCH_BY_STATUS,
            TraceStatusEnum.ACKNOWLEDGED, Critere.EQUALS));
        for (ExternalServiceTrace t :
            externalService.getTraces(criteres, null, null)) {
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

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        this.requestExternalService = requestExternalService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }

    public void setRequestExportService(IRequestExportService requestExportService) {
        this.requestExportService = requestExportService;
    }
}
