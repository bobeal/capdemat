package fr.cg95.cvq.service.request;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.annotation.IsRequest;

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
     */
    List<Request> getSendableRequests(String externalServiceLabel);

    /**
     * Get the list of request types for which a pre-generation is asked.
     */
    Set<String> getGenerableRequestTypes();

    /**
     * Check the coherence of CapDemat's local referentials and external service's referentials
     * for each external service interested in this request (usually none or one).
     * 
     * @return a list of reasons for failed tests.
     */
    List<String> checkExternalReferential(@IsRequest Request request) throws CvqException;

    /**
     * Ask to send a request to its associated external services.
     */
    void sendRequest(@IsRequest final Request request)
        throws CvqException;

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
    Map<Date, String> getConsumptionsByRequest(@IsRequest final Long requestId,
        final Date dateFrom, final Date dateTo)
        throws CvqException;
}
