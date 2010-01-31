package fr.cg95.cvq.external;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.util.Critere;

public interface IExternalService {

    /**
     * Authenticate an external service.
     */
    boolean authenticate(final String externalServiceLabel, final String password);
    
    /**
     * Send a new (validated) request to an external service.
     */
    void sendRequest(@IsRequest final Request request)
        throws CvqException;

    /**
     * Dispatch a payment's information and data to the appropriate external services.
     */
    void creditHomeFolderAccounts(final Payment payment)
        throws CvqException;

    /**
     * Get the list of external services objects for the current local authority
     * interested in events about the given request types.
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
     * Get consumptions for a specific request.
     *
     * @param request the request we want associated consumptions of
     * @param dateFrom date down limit for the returned consumptions for this request
     * @param dateTo date up limit for the returned consumptions for this request
     */
    Map<Date, String> getConsumptionsByRequest(@IsRequest final Request request,
        final Date dateFrom, final Date dateTo)
        throws CvqException;

    /**
     * Get external accounts information and state for the given home folder. Designed
     * to be called by an ecitizen from the Front Office.
     *
     * @param type the "account type" for which we want information (one of
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_INVOICES}, 
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS},
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_TICKETING_ACCOUNTS}
     *
     */
    Set<ExternalAccountItem> getExternalAccounts(@IsHomeFolder final Long homeFolderId, 
            final String type)
        throws CvqException;

    /**
     * Get external accounts information and state for the given home folder. Designed
     * to be called by an ecitizen from the Front Office.
     * 
     * @param homeFolderRequestTypes the request types for whom the given home folder
     *              has at least a request
     * @param type the "account type" for which we want information (one of
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_INVOICES}, 
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS},
     *        {@link fr.cg95.cvq.service.payment.IPaymentService#EXTERNAL_TICKETING_ACCOUNTS}
     */
    Set<ExternalAccountItem> getExternalAccounts(@IsHomeFolder Long homeFolderId,
        Set<String> homeFolderRequestTypes, String type)
        throws CvqException;
    
    /**
     * Load details of operations performed on given deposit account. Details
     * are directly loaded into the provided object.
     */
    void loadDepositAccountDetails(ExternalDepositAccountItem edai)
        throws CvqException;

    /**
     * Load details of items paid along given external invoice. Details
     * are directly loaded into the provided object.
     */
    void loadInvoiceDetails(ExternalInvoiceItem eii)
        throws CvqException;
    
    /**
     * Get the list of request types labels associated to the given external service.
     */
    Collection<String> getRequestTypesForExternalService(final String externalServiceLabel);
    
    /**
     * Get the list of request types for which a pre-generation is asked.
     */
    Set<String> getGenerableRequestTypes();

    ExternalServiceIdentifierMapping
        getIdentifierMapping(final String externalServiceLabel,
            @IsHomeFolder final Long homeFolderId);

    Long addTrace(ExternalServiceTrace trace);

    List<ExternalServiceTrace> getTraces(Set<Critere> criteriaSet, String sort,
        String dir);

    /**
     * Set the external id of an individual for the given external service.
     * 
     * The mapping for the home folder must exist prior to this action.
     * To be used on external id retrieval from the external service.
     */
    void setExternalId(String externalServiceLabel,
        @IsHomeFolder Long homeFolderId, @IsIndividual Long individualId,
        String externalId);

    /**
     * Check the coherence of CapDemat's local referentials and external service's referentials
     * for each external service interested in this request (usually none or one).
     * @return a list of reasons for failed tests.
     */
    List<String> checkExternalReferential(@IsRequest Request request);

    /**
     * Asks the external services for informations they know about the request
     * (for example, its state) to display them to the ecitizen
     * @return The map of corresponding i18nKey - value
     */
    Map<String, Object> loadExternalInformations(@IsRequest Request request)
        throws CvqException;
}
