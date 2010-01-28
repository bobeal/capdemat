package fr.cg95.cvq.exporter.service.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetRequestsRequestDocument;
import fr.capwebct.capdemat.GetRequestsResponseDocument;
import fr.capwebct.capdemat.GetRequestsRequestDocument.GetRequestsRequest;
import fr.capwebct.capdemat.GetRequestsResponseDocument.GetRequestsResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
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
        Set<Critere> criterias = new HashSet<Critere>();

        // Check external service permissions wrt configured request types labels 
        // and add request types labels filter if authorized
        if (typedRequest.getRequestTypeLabel() != null) {
            if (authorizedRequestTypesLabels.contains(typedRequest.getRequestTypeLabel())) {
                criterias.add(new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL,
                    typedRequest.getRequestTypeLabel(), Critere.EQUALS));
            } else {
                response.setError(noPermissions);
                return response;
            }
        } else {
            if (authorizedRequestTypesLabels != null && !authorizedRequestTypesLabels.isEmpty()) {
                criterias.add(new Critere(Request.SEARCH_BY_REQUEST_TYPE_LABEL,
                    authorizedRequestTypesLabels, Critere.IN));
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
                requests.add(defaultRequestService.getById(typedRequest.getId()));

                response.setRequestArray(prepareRequestsForResponse(requests));
                
                // Reset to original context
                SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
                SecurityContext.setCurrentExternalService(currentExternalService);
            } else {
                response.setError(noPermissions);
            }

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
            // get a first subset of eligible requests from above parameters
            // they will be filtered first according to requested states and dates
            // then according to trace status (an acknowledged request won't be resent) 
            List<Request> requests =
                defaultRequestService.get(criterias, null, null, 0, 0);
            List<Request> selectedRequests = new ArrayList<Request>();
            for (Request eligibleRequest : requests) {
                boolean keepIt = false;
                for (RequestAction action : eligibleRequest.getActions()) {
                    if (action.getResultingState() != null
                            && action.getResultingState().equals(requestedState)
                            && action.getDate().after(requestedDateFrom)
                            && action.getDate().before(requestedDateTo)) {
                        keepIt = true;
                        break;
                    }
                }

                if (!keepIt)
                    continue;
                
                // do not send again requests that have already been acknowledged ...
                Set<Critere> criteriaSet = new HashSet<Critere>(2);
                criteriaSet.add(new Critere(
                        ExternalServiceTrace.SEARCH_BY_STATUS,
                        TraceStatusEnum.ACKNOWLEDGED, Critere.EQUALS));
                criteriaSet.add(new Critere(
                        ExternalServiceTrace.SEARCH_BY_KEY,
                        String.valueOf(eligibleRequest.getId()), Critere.EQUALS));
                if (externalService.getTraces(criteriaSet, null, null).isEmpty())
                    selectedRequests.add(eligibleRequest);
            }
            
            response.setRequestArray(prepareRequestsForResponse(selectedRequests));
            
            // Reset to original context
            SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentExternalService(currentExternalService);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }

        return response;
    }

    private RequestType[] prepareRequestsForResponse(List<Request> requests) throws Exception {
        
        Set<RequestType> resultArray = new HashSet<RequestType>();
        for (Request r : requests) {
            RequestType rt = null;
            
            if (localAuthorityRegistry.getRequestXmlResource(r.getId()).exists()) {
                rt = RequestType.Factory.parse(localAuthorityRegistry.getRequestXmlResource(r.getId()));
            } else {
                rt = r.modelToXmlRequest();
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

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
