package fr.cg95.cvq.payment;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;


/**
 * Service dedicated to the management and monitoring of payments.
 *
 * @author bor@zenexity.fr
 */
public interface IPaymentService {

    String SERVICE_NAME = "paymentService";
    
    String EXTERNAL_INVOICES = "ExternalInvoices";
    String EXTERNAL_DEPOSIT_ACCOUNTS = "ExternalDepositAccounts";
    String EXTERNAL_TICKETING_ACCOUNTS = "ExternalTicketingAccounts";

    String DATE_TYPE_INITIALIZATION = "dateTypeInitialization";
    String DATE_TYPE_COMMIT = "dateTypeCommit";
    
    /**
     * Get the list of all known brokers and their associated friendly labels 
     * for the current local authority.
     * 
     * @return a map of (broker, friendly label)
     */
    Map<String, String> getAllBrokers(PaymentMode paymentMode) throws CvqException;
    
    /**
     * Create a payment container object "based" on the given purchase item.
     * 
     * @throws CvqException if payment container could not be created (security requirement, ...)
     */
    Payment createPaymentContainer(PurchaseItem purchaseItem, PaymentMode paymentMode)
        throws CvqException;
    
    /**
     * Add a purchase item to the user's payment and update payment information accordingly.
     * 
     * @throws CvqInvalidBrokerException if the item to be added has a broker different
     *         than already added items.
     */
    void addPurchaseItemToPayment(Payment payment, PurchaseItem purchaseItem)
        throws CvqInvalidBrokerException, CvqModelException;
    
    /**
     * Remove a purchase item from the user's payment and update payment information accordingly.
     */
    void removePurchaseItemFromPayment(Payment payment, PurchaseItem purchaseItem);
    
    /**
     * Initialize a payment transaction with the payment provider associated to chosen items.
     */
    URL initPayment(Payment payment)
        throws CvqException;

    /**
     * Commit a payment initialized by {@link #initPayment}.
     *
     * @param parameters a map of all other needed HTTP request parameters received 
     *        from the payment provider.
     *
     * @return payment commit status
     *         (see {@link #UNKNOWN_RETURN}, {@link #OK_RETURN}, {@link #CANCELLED_RETURN}, 
     *              {@link #REFUSED_RETURN}).
     */
    PaymentResultStatus commitPayment(final Map<String, String> parameters)
        throws CvqException;
    
    PaymentResultStatus getStateFromParameters(final Map<String, String> parameters)
        throws CvqException;
    
    /**
     * Get all payments issued by the given home folder.
     */
    List<Payment> getByHomeFolder(final HomeFolder homeFolder);
    
    /**
     * Get all payments matching the given criteria.
     * 
     * @param dateType to specify whether provided dates relate to initialization date or 
     *                 commit date (see {@link #DATE_TYPE_INITIALIZATION} and
     *                                  {@link #DATE_TYPE_COMMIT}).
     */
    List<Payment> get(final Date from, final Date to, final String dateType, 
            final PaymentState paymentState, final String cvqReference, 
            final String bankReference, final String broker, final Long homeFolderId, 
            final String lastName);
    
    /**
     * Get a constrained list of payments according to a set of criteria and requirements.
     *
     * @param sort an ordering to apply to results. 
     * @param dir the direction of the sort (asc or desc)
     * @param recordsReturned the number of records to return
     * @param startIndex the start index of the records to return
     */
    List<Payment> extendedGet(final Date initDateFrom, final Date initDateTo, 
            final Date commitDateFrom, final Date commitDateTo, final PaymentState paymentState, 
            final String cvqReference, final String bankReference, final String broker, 
            final Long homeFolderId, final String requesterLastName, final String sort, 
            final String dir, final int recordsReturned, final int startIndex);
    
    long getPaymentCount(final Date initDateFrom, final Date initDateTo, final Date commitDateFrom,
            final Date commitDateTo, final PaymentState paymentState, 
            final String cvqReference, final String bankReference, final String broker, 
            final Long homeFolderId, final String requesterLastName) throws CvqException;
   
    /**
     * Get a payment by id.
     */
    Payment getById(final Long id) throws CvqException, CvqObjectNotFoundException;
    
    /**
     * Delete a payment.
     */
    void delete(final Long id) throws CvqException, CvqObjectNotFoundException;

    /**
     * Delete a payment.
     */
    void delete(final Payment payment) throws CvqException;
}
