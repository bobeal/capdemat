package fr.cg95.cvq.external;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;

public interface IExternalService {

    /**
     * Authenticate an external service.
     */
    boolean authenticate(final String externalServiceLabel, final String password);
    
    /**
     * Send a new (validated) request to an external service.
     */
    void sendRequest(final Request request)
        throws CvqException;

    /**
     * Dispatch a payment's information and data to the appropriate external services.
     */
    void creditHomeFolderAccounts(final Payment payment)
        throws CvqException;

    /**
     * Return whether given request type has at least an associated external service.
     */
    boolean hasMatchingExternalService(final String requestLabel)
        throws CvqException;

    /**
     * Get consumptions for a specific request.
     *
     * @param request the request we want associated consumptions of
     * @param dateFrom date down limit for the returned consumptions for this request
     * @param dateTo date up limit for the returned consumptions for this request
     */
    Map<Date, String> getConsumptionsByRequest(final Request request, final Date dateFrom, 
            final Date dateTo)
        throws CvqException;

    /**
     * Get external accounts information and state for the given home folder. Designed
     * to be called by an ecitizen from the Front Office.
     * 
     * @param homeFolderRequestTypes the request types for whom the given home folder
     *              has at least a request
     * @param type the "account type" for which we want information (one of
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_INVOICES}, 
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS},
     *        {@link fr.cg95.cvq.payment.IPaymentService#EXTERNAL_TICKETING_ACCOUNTS}
     */
    Set<ExternalAccountItem> getExternalAccounts(Long homeFolderId, 
            Set<String> homeFolderRequestTypes, String type) 
        throws CvqException;
    
    /**
     * Get information about individual's accounts. 
     */
    Map<Individual, Map<String, String> > getIndividualAccountsInformation(final Long homeFolderId, 
            Set<String> homeFolderRequestTypes)
        throws CvqException;

    /**
     * Load details of operations performed on given deposit account.
     */
    void loadDepositAccountDetails(ExternalDepositAccountItem edai)
        throws CvqException;

    /**
     * Load details of items paid along given external invoice.
     */
    void loadInvoiceDetails(ExternalInvoiceItem eii)
        throws CvqException;
    
    /**
     * Get the list of request types labels associated to the given external service.
     */
    Set<String> getRequestTypesForExternalService(final String externalServiceLabel);
    
    /**
     * Get the list of request types for which a pre-generation is asked.
     */
    Set<String> getGenerableRequestTypes();

    /**
     * Add a new mapping for the given object.
     * 
     * If a mapping already exists for the given external service label and home folder id,
     * its external id will be replaced by the given one.
     */
    void addHomeFolderMapping(ExternalServiceIdentifierMapping esim) 
            throws CvqPermissionException;
    
    /**
     * Add a new mapping for the given identifiers.
     * 
     * If a mapping already exists for the given external service label and home folder id,
     * its external id will be replaced by the given one.
     */
    void addHomeFolderMapping(final String externalServiceLabel, final Long homeFolderId,
            final String externalId) throws CvqPermissionException;
    
    /**
     * Add a new mapping for the given individual identifiers.
     * 
     * If a mapping already exists for the given individual id, it will be replaced by the 
     * new one.
     * 
     * @throws CvqException if no mapping exists for the given external service label 
     *      and home folder id.
     */
    void addIndividualMapping(final String externalServiceLabel, final Long homeFolderId,
            final Long individualId, final String externalId) throws CvqException;

    void deleteHomeFolderMapping(final String externalServiceLabel, final Long homeFolderId) 
        throws CvqPermissionException;
    
    void deleteHomeFoldersMappings(final String externalServiceLabel) 
        throws CvqPermissionException;
    
    ExternalServiceIdentifierMapping getIdentifierMapping(final String externalServiceLabel, 
            final Long homeFolderId);

    ExternalServiceIdentifierMapping getIdentifierMapping(final String externalServiceLabel, 
            final String externalId);
    
    Set<ExternalServiceIdentifierMapping> getIdentifiersMappings(final String externalServiceLabel);
    
    Long addTrace(ExternalServiceTrace trace) throws CvqPermissionException;
    
    Set<ExternalServiceTrace> getTraces(Long key, String name, 
            TraceStatusEnum status, Date dateFrom, Date dateTo);
    
    Set<ExternalServiceTrace> getTracesByStatus(TraceStatusEnum status);
    
    Set<Long> getTraceKeysByStatus(Set<Long> ids, Set<String> statuses);
    
    int deleteTraces(Long key, String keyOwner) 
        throws CvqPermissionException, CvqObjectNotFoundException;
    
    int deleteTraces(String name) throws CvqPermissionException, CvqObjectNotFoundException;
    
    /**
     * Get ids of requests that match the given search criteria.
     * 
     * TODO GENERIC DAO move to request service after DAOs improvements
     */
    Set<Long> getRequestIds(Set<ISearchCriteria> searchCriterias);
    
    /**
     * Get ids of validated requests with the given types within the given previous days.
     * 
     * TODO GENERIC DAO move to request service after DAOs improvements
     */
    Set<Long> getValidatedRequestIds(Set<String> requestTypesLabels, int numberOfDays);    
}
