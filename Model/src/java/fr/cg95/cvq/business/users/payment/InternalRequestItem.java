package fr.cg95.cvq.business.users.payment;

import fr.cg95.cvq.business.request.Request;

/**
 * Represent an item bought in the context of a request that is entirely managed by the application.
 * 
 * @hibernate.subclass
 *  discriminator-value="INTERNAL_REQUEST_ITEM"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class InternalRequestItem extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double unitPrice;
    
    public InternalRequestItem() {
    }
    
    public InternalRequestItem(final String label, final Double amount,
            final Request request, final String supportedBroker, final Integer quantity,
            final Double unitPrice) {
        
        super(label, amount, request == null ? null : request.getId(), supportedBroker);
        
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
