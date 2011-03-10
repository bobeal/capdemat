package fr.cg95.cvq.service.payment.external;

import java.util.Set;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IPaymentExternalService {
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
    Set<ExternalAccountItem> getExternalAccounts(@IsUser final Long homeFolderId,
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
}
