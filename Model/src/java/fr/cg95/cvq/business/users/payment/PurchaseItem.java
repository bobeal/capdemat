package fr.cg95.cvq.business.users.payment;

import java.io.Serializable;

/**
 * Generic representation of an item that can be bought.
 * 
 * @hibernate.class
 *  table="purchase_item"
 *  lazy="false"
 * @hibernate.discriminator
 *  column="item_type"
 *  type="string"
 *  length="64"
 *
 * @author bor@zenexity.fr
 */
public abstract class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String label;
    private Double amount;
    private Long requestId;
    // FIXME : used for support information and effective broker
    //              maybe a renaming should be appropriate ?
    private String supportedBroker;
    
    public PurchaseItem(final String label, final Double amount,
            final Long requestId, final String supportedBroker) {
        this.label = label;
        this.amount = amount;
        this.requestId = requestId;
        this.supportedBroker = supportedBroker;
    }

    public PurchaseItem() {
    }
    
    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public final Long getId() {
        return id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="label"
     */
    public String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    public abstract String getFriendlyLabel();
    public abstract String getInformativeFriendlyLabel();
    
    /**
     * @hibernate.property
     *  column="amount"
     */
    public final Double getAmount() {
        return amount;
    }

    public final void setAmount(final Double amount) {
        this.amount = amount;
    }
    
    public float getEuroAmount() {
        return (float)(amount.floatValue()) / 100;
    }

    /**
     * @hibernate.property
     *  column="request_id"
     */
    public final Long getRequestId() {
        return requestId;
    }

    public final void setRequestId(final Long requestId) {
        this.requestId = requestId;
    }

    public final String getSupportedBroker() {
        return supportedBroker;
    }

    public final void setSupportedBroker(String supportedBroker) {
        this.supportedBroker = supportedBroker;
    }

    public String toString() {
        return getFriendlyLabel() + " / label : " + label + " / amount : " + amount;
    }
}
