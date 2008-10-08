package fr.cg95.cvq.exporter.service.endpoint;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.AckRequestType;
import fr.capwebct.capdemat.AckRequestsRequestDocument;
import fr.capwebct.capdemat.AckRequestsResponseDocument;
import fr.capwebct.capdemat.AckRequestsRequestDocument.AckRequestsRequest;
import fr.capwebct.capdemat.AckRequestsResponseDocument.AckRequestsResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;

/**
 * 
 * @author vba@zenexity.fr
 *
 */
public class AckRequestServiceEndpoint extends SecuredServiceEndpoint {
    
    private IExternalService externalService;
    
    public AckRequestServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object o) throws Exception {
        
        AckRequestsResponseDocument responseDocument = AckRequestsResponseDocument.Factory.newInstance();
        AckRequestsResponse response = responseDocument.addNewAckRequestsResponse();
        AckRequestsRequest request = ((AckRequestsRequestDocument)o).getAckRequestsRequest();
        
        try {
            for (int i=0; i<request.getAckElementsArray().length; i++) {
                AckRequestType type = request.getAckElementsArray()[i];
                
                ExternalServiceTrace trace = new ExternalServiceTrace();
                trace.setKey(type.getRequestId());
                trace.setKeyOwner("capdemat");
                
                if (type.getErroneous())
                    trace.setStatus(TraceStatusEnum.ERROR);
                else
                    trace.setStatus(TraceStatusEnum.ACKNOWLEDGED);
                
                externalService.addTrace(trace);
                response.setAccomplished(true);
            }
        } catch (CvqException e) {
            response.setAccomplished(false);
        }
        
        return response;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
