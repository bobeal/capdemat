package fr.cg95.cvq.external;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.util.Critere;

public interface IExternalService {

    /**
     * Authenticate an external service.
     */
    boolean authenticate(final String externalServiceLabel, final String password);
    
    /**
     * Check the coherence of CapDemat's local referentials and external service's referentials
     * for each external service interested in this request (usually none or one).
     * @return a list of reasons for failed tests.
     */
    List<String> checkExternalReferential(XmlObject request, 
        Set<IExternalProviderService> externalProviderServices);

    /**
     * Send a new (validated) request to an external service.
     */
    void sendRequest(XmlObject xmlObject, Set<IExternalProviderService> externalProviderServices) 
        throws CvqException;

    /**
     * Asks the external services for informations they know about the request
     * (for example, its state) to display them to the ecitizen
     * @return The map of corresponding i18nKey - value
     */
    Map<String, Object> loadExternalInformations(XmlObject xmlObject)
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
     * Get consumptions for a specific request.
     *
     * @param request the key used to retrieve consumptions (eg request id)
     * @param dateFrom date down limit for the returned consumptions for this request
     * @param dateTo date up limit for the returned consumptions for this request
     */
    Map<Date, String> getConsumptions(final Long key, final Date dateFrom, final Date dateTo,
            Set<IExternalProviderService> externalProviderServices)
        throws CvqException;


    Long addTrace(ExternalServiceTrace trace);

    List<ExternalServiceTrace> getTraces(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset);

    Long getTracesCount(Set<Critere> criteriaSet);

    List<ExternalServiceTrace> getLastTraces(Set<Critere> criteriaSet, String sort,
            String dir, int count, int offset);

    Long getLastTracesCount(Set<Critere> criteriaSet);

    IExternalProviderService getExternalServiceByLabel(final String externalServiceLabel);

    ExternalServiceBean getBeanForExternalService(IExternalProviderService externalProviderService);
}