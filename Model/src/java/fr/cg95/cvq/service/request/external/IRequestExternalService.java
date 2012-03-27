package fr.cg95.cvq.service.request.external;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.workflow.event.impl.WorkflowGenericEvent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.common.RequestType;

public interface IRequestExternalService {

    /**
     * Get the list of external provider services interested in events about the given request type.
     */
    Set<IExternalProviderService> getExternalServicesByRequestType(final String requestTypeLabel);

    /**
     * Get the first external service object of getExternalServicesByRequestType(),
     * since there is usually only one external service interested in a particular request type
     */
    IExternalProviderService getExternalServiceByRequestType(final String requestTypeLabel);

    /**
     * Return whether given request type has at least an associated external service.
     */
    boolean hasMatchingExternalService(final String requestLabel);

    /**
     * Get the list of request types labels associated to the given external service.
     */
    Collection<String> getRequestTypesForExternalService(final String externalServiceLabel);

    /**
     * Get all the requests that are sendable to this external service
     *
     * @deprecated Only used by Edemande, for its own, incompatible workflow.
     */
    @Deprecated
    List<Request> getSendableRequests(String externalServiceLabel);

    /**
     * Check the coherence of CapDemat's local referentials and external service's referentials
     * for each external service interested in this request (usually none or one).
     * 
     * @return a list of reasons for failed tests.
     */
    List<String> checkExternalReferential(@IsRequest Request request) throws CvqException; // FIXME rename it checkExternalReferentials()

    /**
     * Ask to send a request to its associated external services.
     */
    void sendRequest(@IsRequest Request request)
        throws CvqException;

    /**
     * Send a batch of requests asynchronously, and notify provided email on completion
     */
    void sendRequests(Set<Critere> ids, String email)
        throws CvqException;

    List<String> getKeys(Set<Critere> criterias);

    /**
     * Asks the external services for informations they know about the request
     * (for example, its state) to display them to the ecitizen
     * 
     * @return The map of corresponding i18nKey - value
     */
    Map<String, Object> loadExternalInformations(@IsRequest Request request)
        throws CvqException;

    /**
     * Get consumptions for a specific request.
     *
     * @param request the request we want associated consumptions of
     * @param dateFrom date down limit for the returned consumptions for this request
     * @param dateTo date up limit for the returned consumptions for this request
     */
    Map<Date, String> getConsumptions(@IsRequest final Long requestId,
        final Date dateFrom, final Date dateTo)
        throws CvqException;

    void publish(WorkflowGenericEvent wfEvent)throws CvqException;

    public RequestType getRequestType(@IsRequest Request request) throws CvqException;

    /**
     * Get the payload to send.
     * 
     * @param request
     * @param externalProviderService
     * @return the payload to send
     * @throws CvqException
     */
    public RequestType getRequestPayload(@IsRequest Request request, IExternalProviderService externalProviderService) throws CvqException;

    boolean isAgentCreatorRequest(Request request);
}
