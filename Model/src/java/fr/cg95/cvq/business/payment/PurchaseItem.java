package fr.cg95.cvq.business.payment;

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

    /**
     * Convey broker information for this item. It can't be null.
     */
    private String supportedBroker;
    
    public PurchaseItem(final String label, final Double amount,
            final String supportedBroker) {
        this.label = label;
        this.amount = amount;
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
        return amount.floatValue() / 100;
    }

    /**
     * @hibernate.property
     *  column="supported_broker"
     */
    public final String getSupportedBroker() {
        return supportedBroker;
    }

    public final void setSupportedBroker(String supportedBroker) {
        this.supportedBroker = supportedBroker;
    }

    @Override
    public String toString() {
        return getInformativeFriendlyLabel();
    }
}
