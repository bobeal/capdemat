package fr.cg95.cvq.business.payment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.service.payment.PaymentUtils;
import fr.cg95.cvq.util.DateUtils;

/**
 * 
 * @hibernate.subclass
 *  discriminator-value="EXTERNAL_DEPOSIT_ACCOUNT_ITEM"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class ExternalDepositAccountItem extends ExternalAccountItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_DEPOSIT_ACCOUNT_ID = "externalDepositAccountId";

    private Double oldValue;
    private Date oldValueDate;

    private Set<ExternalDepositAccountItemDetail> accountDetails;

    public ExternalDepositAccountItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final Date oldValueDate, final Double oldValue,
            final String broker) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.oldValue = oldValue;
        this.oldValueDate = oldValueDate;
    }
    
    public ExternalDepositAccountItem() {
        super();
    }
    
    /**
     * @hibernate.property
     *  column="old_value"
     */
    public final Double getOldValue() {
        return oldValue;
    }
    
    public final void setOldValue(Double oldValue) {
        this.oldValue = oldValue;
    }
    
    /**
     * @hibernate.property
     *  column="old_value_date"
     */
    public final Date getOldValueDate() {
        return oldValueDate;
    }
    
    public final void setOldValueDate(Date oldValueDate) {
        this.oldValueDate = oldValueDate;
    }

    @Override
    public String getInformativeFriendlyLabel() {

        StringBuffer sb = 
            new StringBuffer().append("Compte n°").append(getExternalItemId())
                .append(" (").append(getLabel()).append(")");
            
        return sb.toString();
    }

    /**
     * Get the details of operations performed on this account. Details are not automatically
     * loaded from external services, you have to call 
     * {@link IHomeFolderService#loadExternalDepositAccountDetails(ExternalDepositAccountItem)}
     * to load them into this object.
     */
    /**
     * @hibernate.set
     *  lazy="true"
     *  cascade="all"
     *  inverse="true"
     * @hibernate.key
     *  column="external_deposit_account_item_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail"
     */
    public final Set<ExternalDepositAccountItemDetail> getAccountDetails() {
        if (accountDetails == null)
            return new HashSet<ExternalDepositAccountItemDetail>();
        return accountDetails;
    }

    public final void setAccountDetails(Set<ExternalDepositAccountItemDetail> accountDetails) {
        this.accountDetails = accountDetails;
    }
    
    public final void addAccountDetail(ExternalDepositAccountItemDetail accountDetail) {
        if (this.accountDetails == null)
            this.accountDetails = new HashSet<ExternalDepositAccountItemDetail>();
        this.accountDetails.add(accountDetail);
        accountDetail.setExternalDepositAccountItem(this);
    }
}
