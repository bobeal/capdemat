package fr.cg95.cvq.external;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentService;

/**
 * The interface all external services must implement.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IExternalService {

    /**
     * Send a new (validated) request to an external service.
     * 
     * @param request we want to send
     * @return business id coming from the plugged application
     */
    String sendRequest(final Request request)
        throws CvqException;

    /**
     * Get consumptions for a specific request.
     *
     * @param request the request we want associated consumptions of
     * @param dateFrom date down limit for the returned consumptions for this request
     * @param dateTo date up limit for the returned consumptions for this request
     *
     * @return a map of (date, label) pairs
     */
    Map<Date, String> getConsumptionsByRequest(final Request request, final Date dateFrom, 
            final Date dateTo)
        throws CvqException;

    /**
     * Get accounts grouped by home folder.
     *
     * @return Map of accounts for this home folder, keys are
     *               {@link IPaymentService#EXTERNAL_INVOICES}, 
     *               {@link IPaymentService#EXTERNAL_TICKETING_ACCOUNTS},
     *               {@link IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS}
     */
    Map<String, List<ExternalAccountItem> > getAccountsByHomeFolder(final Long homeFolderId) 
        throws CvqException;

    /**
     * Get accounts for a given request.
     *
     * @return Map of accounts for this request, keys are
     *               {@link IPaymentService#EXTERNAL_INVOICES}, 
     *               {@link IPaymentService#EXTERNAL_TICKETING_ACCOUNTS},
     *               {@link IPaymentService#EXTERNAL_DEPOSIT_ACCOUNTS}
     */
    Map<String, List<ExternalAccountItem> > getAccountsByRequest(final Long requestId) 
        throws CvqException;

    /**
     * Get information about individual's accounts. 
     */
    Map<Individual, Map<String, String> > getIndividualAccountsInformation(final Long homeFolderId)
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
     * Credit accounts of a given home folder with the provided purchase items.
     */
    void creditHomeFolderAccounts(final Collection purchaseItems, final String cvqReference,
            final String bankReference, final Long homeFolderId, final Date validationDate)
        throws CvqException;

    /**
     * Credit accounts of a given request with the provided purchase items.
     */
    void creditRequestAccounts(final Long requestId, final String transaction,
            final Collection purchaseItems, final Date date, final String bankGrantId)
        throws CvqException;

    /**
     * Initialization callback called for each declared local authority.
     * It's then up to the external service to check that it has all the configuration
     * parameters required to function properly
     */
    void checkConfiguration(final ExternalServiceBean externalServiceBean)
        throws CvqConfigurationException;

    /**
     * Utility method that can be used for integration tests with external services
     * @fixme is it really a good idea ?
     */
    String helloWorld()
        throws CvqException;
    
    /**
     * A label to uniquely identify an external service.
     * 
     * It is currently used to know when we have to transmit payments results to an external service.
     */
    String getLabel();
}
