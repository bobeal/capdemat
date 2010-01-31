package fr.cg95.cvq.business.payment;

/**
 * Represent an item that is entirely managed by the application.
 * 
 * @hibernate.subclass
 *  discriminator-value="INTERNAL_INVOICE_ITEM"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class InternalInvoiceItem extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double unitPrice;
    
    /**
     * Identifier used by the key owner to retrieve data.
     */
    private String key;
    
    /**
     * Owner of the key, typically an application, eg CapDemat.
     */    
    private String keyOwner;
    
    public InternalInvoiceItem() {
    }
    
    public InternalInvoiceItem(final String label, final Double amount,
            final String key, final String keyOwner, final String supportedBroker, 
            final Integer quantity, final Double unitPrice) {
        
        super(label, amount, supportedBroker);
        
        this.key = key;
        this.keyOwner = keyOwner;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    /**
     * @hibernate.property
     *  column="quantity"
     */
    public final Integer getQuantity() {
        return quantity;
    }
    
    public final void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    /**
     * @hibernate.property
     *  column="unit_price"
     */
    public final Double getUnitPrice() {
        return unitPrice;
    }
    
    public final void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @hibernate.property
     *  column="key"
     */
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @hibernate.property
     *  column="key_owner"
     */
    public String getKeyOwner() {
        return keyOwner;
    }

    public void setKeyOwner(String keyOwner) {
        this.keyOwner = keyOwner;
    }

    @Override
    public String getFriendlyLabel() {

        StringBuffer sb = new StringBuffer().append(getLabel())
            .append(" - ").append(getEuroAmount()).append(" (")
            .append(getQuantity()).append(" * ").append(getUnitPrice())
            .append(")");

        return sb.toString();
    }

    @Override
    public String getInformativeFriendlyLabel() {

        StringBuffer sb = new StringBuffer().append(getLabel());

        return sb.toString();
    }
}
