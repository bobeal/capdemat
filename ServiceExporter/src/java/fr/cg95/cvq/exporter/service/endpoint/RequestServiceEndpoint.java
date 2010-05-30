package fr.cg95.cvq.exporter.service.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetRequestsRequestDocument;
import fr.capwebct.capdemat.GetRequestsResponseDocument;
import fr.capwebct.capdemat.GetRequestsRequestDocument.GetRequestsRequest;
import fr.capwebct.capdemat.GetRequestsResponseDocument.GetRequestsResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.DateUtils;
import fr.cg95.cvq.xml.common.RequestType;

public class RequestServiceEndpoint extends SecuredServiceEndpoint {
    
    private static Logger logger = Logger.getLogger(RequestServiceEndpoint.class);
    
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService defaultRequestService;
    private IRequestDAO requestDAO;
    private IExternalService externalService;
    
    private final String noPermissions = "Access denied! No permissions granted"; 
    
    @Override
    protected Object invokeInternal(Object request) throws Exception {
        
        GetRequestsResponseDocument responseDocument = 
            GetRequestsResponseDocument.Factory.newInstance();
        GetRequestsResponse response = responseDocument.addNewGetRequestsResponse();
        
        Collection<String> authorizedRequestTypesLabels =
            externalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());

        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
        
        GetRequestsRequest typedRequest =
            ((GetRequestsRequestDocument)request).getGetRequestsRequest();

        // Check external service permissions wrt configured request types labels 
        // and add request types labels filter if authorized
        List<String> selectedRequestTypesLabels = new ArrayList<String>();
        if (typedRequest.getRequestTypeLabel() != null) {
            if (authorizedRequestTypesLabels.contains(typedRequest.getRequestTypeLabel())) {
                selectedRequestTypesLabels.add(typedRequest.getRequestTypeLabel());
            } else {
                response.setError(noPermissions);
                return response;
            }
        } else {
            if (authorizedRequestTypesLabels != null && !authorizedRequestTypesLabels.isEmpty()) {
                selectedRequestTypesLabels.addAll(authorizedRequestTypesLabels);
            } else {
                response.setError(noPermissions);
                return response;
            }
        }
        
        // if a request id is specified, return the request whatever states and dates are set to
        if (typedRequest.getId() != 0) {
            Request askedRequest = defaultRequestService.getById(typedRequest.getId());
            if (askedRequest != null 
                    && authorizedRequestTypesLabels.contains(askedRequest.getRequestType().getLabel())) {
                List<Request> requests = new ArrayList<Request>();
                requests.add(askedRequest);

                response.setRequestArray(prepareRequestsForResponse(requests));
                
            } else {
                response.setError(noPermissions);
            }

            // Reset to original context
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(currentExternalService);

            return response;
        }
        
        RequestState requestedState = 
            typedRequest.getState() != null ? RequestState.forString(typedRequest.getState().toString()) : RequestState.VALIDATED;
        Date requestedDateFrom = null;
        if (typedRequest.getDateFrom() != null)
            requestedDateFrom = typedRequest.getDateFrom().getTime();
        else
            requestedDateFrom = DateUtils.getShiftedDate(Calendar.DAY_OF_MONTH, -1);
        Date requestedDateTo = null;
        if (typedRequest.getDateTo() != null)
            requestedDateTo = typedRequest.getDateTo().getTime();
        else
            requestedDateTo = DateUtils.getShiftedDate(Calendar.DAY_OF_MONTH, 1);

        try {
            List<Request> requests =
                requestDAO.listRequestsToExport(requestedState.toString(), requestedDateFrom, 
                        requestedDateTo, selectedRequestTypesLabels);
            List<Request> selectedRequests = new ArrayList<Request>();
            for (Request eligibleRequest : requests) {
                // do not send again requests that have already been acknowledged ...
                Set<Critere> criteriaSet = new HashSet<Critere>(2);
                criteriaSet.add(new Critere(
                        ExternalServiceTrace.SEARCH_BY_STATUS,
                        TraceStatusEnum.ACKNOWLEDGED, Critere.EQUALS));

                criteriaSet.add(new Critere(
                        ExternalServiceTrace.SEARCH_BY_KEY,
                        String.valueOf(eligibleRequest.getId()), Critere.EQUALS));
                if (externalService.getTracesCount(criteriaSet) == 0)
                    selectedRequests.add(eligibleRequest);
            }
            
            response.setRequestArray(prepareRequestsForResponse(selectedRequests));
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }

        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);

        return response;
    }

    private RequestType[] prepareRequestsForResponse(List<Request> requests) throws Exception {
        
        Set<RequestType> resultArray = new HashSet<RequestType>();
        for (Request r : requests) {
            RequestType rt = null;
            
            if (localAuthorityRegistry.getRequestXmlResource(r.getId()).exists()) {
                rt = RequestType.Factory.parse(localAuthorityRegistry.getRequestXmlResource(r.getId()));
            } else {
                // TODO : port this properly in 4.2
                XmlObject xmlObject = defaultRequestService.fillRequestXml(r); 
                try {
                    rt =  (fr.cg95.cvq.xml.common.RequestType) xmlObject.getClass().getMethod("get" + xmlObject.getClass().getSimpleName().replace("DocumentImpl", "")).invoke(xmlObject);
                } catch (Exception e) {
                    logger.error("prepareRequestsForResponse() Unexpected exception while converting to XML "
                            + e.getMessage());
                }
            }
            resultArray.add(rt);
            
            ExternalServiceTrace trace = new ExternalServiceTrace();
            trace.setKeyOwner("capdemat");
            trace.setKey(String.valueOf(r.getId()));
            trace.setStatus(TraceStatusEnum.SENT);
            
            externalService.addTrace(trace);
        }
        
        logger.debug("prepareRequestsForResponse() number of returned requests " + requests.size());
        return resultArray.toArray(new RequestType[0]);
    }
    
    public RequestServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
    
    public void setDefaultRequestService(IRequestService defaultRequestService) {
        this.defaultRequestService = defaultRequestService;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
