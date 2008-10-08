package fr.cg95.cvq.exporter.service.endpoint;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetRequestsRequestDocument;
import fr.capwebct.capdemat.GetRequestsResponseDocument;
import fr.capwebct.capdemat.GetRequestsRequestDocument.GetRequestsRequest;
import fr.capwebct.capdemat.GetRequestsResponseDocument.GetRequestsResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.util.helpers.SetHelper;
import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.criterias.CrossJoinCriteria;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;
import fr.cg95.cvq.util.quering.criterias.InCriteria;
import fr.cg95.cvq.util.quering.criterias.SimpleCriteria;
import fr.cg95.cvq.xml.common.RequestType;

public class RequestServiceEndpoint extends SecuredServiceEndpoint {
    
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService defaultRequestService;
    private IExternalService externalService;
    
    private final String noPermissions = "Access denied! No permissions granted"; 
    
    @Override
    protected Object invokeInternal(Object request) throws Exception {
        
        GetRequestsResponseDocument responseDocument = 
            GetRequestsResponseDocument.Factory.newInstance();
        GetRequestsResponse response = responseDocument.addNewGetRequestsResponse();
        
        Set<String> requestTypesLabels =
            externalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());
        
        GetRequestsRequest typedRequest = 
            ((GetRequestsRequestDocument)request).getGetRequestsRequest(); 
        Set<ISearchCriteria> criterias = new HashSet<ISearchCriteria>();

        if (typedRequest.getRequestTypeLabel() != null) {
            if (requestTypesLabels.contains(typedRequest.getRequestTypeLabel())) {
                criterias.add(new SimpleCriteria("requestType.label",BaseOperator.EQUALS,
                        typedRequest.getRequestTypeLabel()));
            } else {
                response.setError(noPermissions);
                return response;
            }
        } else {
            if (requestTypesLabels != null && !requestTypesLabels.isEmpty()) {
                criterias.add(new InCriteria("requestType.label",BaseOperator.IN, requestTypesLabels));
            } else {
                response.setError(noPermissions);
                return response;
            }
        }
        
        SimpleCriteria criteria = new SimpleCriteria();
        criteria.setName("date");
        criteria.setOperator(BaseOperator.LTE);
        criteria.setEntityType(RequestAction.class);
        if (typedRequest.getDateTo() == null) {
            criteria.setValue(this.addDaysToDate(new Date(), 1));
        } else {
            criteria.setValue(this.addDaysToDate(typedRequest.getDateTo().getTime(),1));
        }
        criterias.add(criteria);
        
        if (typedRequest.getDateFrom() != null)
            criterias.add(new SimpleCriteria(RequestAction.class,"date",
                    BaseOperator.GTE,typedRequest.getDateFrom().getTime()));
        if (typedRequest.getState() != null)
            criterias.add(new SimpleCriteria(RequestAction.class,"resultingState",
                    BaseOperator.EQUALS,typedRequest.getState().toString()));
        
        criterias.add(new CrossJoinCriteria("id",BaseOperator.EQUALS,
                CrossJoinCriteria.prepareOperand("request", RequestAction.class)));
        
        try {
            Set<Long> ids = externalService.getRequestIds(criterias);
            // do not send again requests that have already been acknowledged
            Set<String> statuses = new HashSet<String>();
            statuses.add(TraceStatusEnum.ACKNOWLEDGED.toString());
            ids = SetHelper.MakeRelativeComplement(
                externalService.getTraceKeysByStatus(ids,statuses), ids);
            Set<RequestType> resultArray = new HashSet<RequestType>();
            for (Long id : ids) {
                RequestType rt = null;
                
                if (this.isCached(id)) {
                    rt = RequestType.Factory.parse(this.localAuthorityRegistry.getRequestXmlResource(id));
                } else {
                    Request r = this.defaultRequestService.getById(id);
                    rt = r.modelToXmlRequest();
                }
                resultArray.add(rt);
                
                ExternalServiceTrace trace = new ExternalServiceTrace();
                trace.setKeyOwner("capdemat");
                trace.setKey(id);
                trace.setStatus(TraceStatusEnum.SENT);
                
                externalService.addTrace(trace);
            }
            response.setRequestArray(resultArray.toArray(new RequestType[0]));
            
        } catch (CvqException e) {
            response.setError(e.getMessage());
        }

        return response;
    }

    public boolean isCached(Long id) {
        return localAuthorityRegistry.getRequestXmlResource(id).exists();
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

    protected Date addDaysToDate(Date date,int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        return calendar.getTime();
    }
    
}
