package fr.cg95.cvq.business.users.payment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.payment.PaymentUtils;
import fr.cg95.cvq.service.users.IHomeFolderService;
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
    public String getFriendlyLabel() {

        StringBuffer sb = 
            new StringBuffer().append("Compte n°").append(getExternalItemId())
                .append(" - Valeur au ").append(DateUtils.format(getOldValueDate())).append(" : ")
                .append(PaymentUtils.formatPrice(getOldValue().intValue()))
                .append(" &euro; (").append(getLabel()).append(")");
            
        return sb.toString();
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
    public final Set<ExternalDepositAccountItemDetail> getAccountDetails() {
        return accountDetails;
    }

    public final void setAccountDetails(Set<ExternalDepositAccountItemDetail> accountDetails) {
        this.accountDetails = accountDetails;
    }
    
    public final void addAccountDetail(ExternalDepositAccountItemDetail accountDetail) {
        if (this.accountDetails == null)
            this.accountDetails = new HashSet<ExternalDepositAccountItemDetail>();
        this.accountDetails.add(accountDetail);
    }
}
