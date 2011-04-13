package fr.cg95.cvq.business.payment;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="INTERNAL_INVOICE_ITEM")
public class InternalInvoiceItem extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    private Integer quantity;

    @Column(name="unit_price")
    private Double unitPrice;

    /**
     * Identifier used by the key owner to retrieve data.
     */
    private String key;

    /**
     * Owner of the key, typically an application, eg CapDemat.
     */    
    @Column(name="key_owner")
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

    public final Integer getQuantity() {
        return quantity;
    }
    
    public final void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public final Double getUnitPrice() {
        return unitPrice;
    }
    
    public final void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyOwner() {
        return keyOwner;
    }

    public void setKeyOwner(String keyOwner) {
        this.keyOwner = keyOwner;
    }

    @Override
    public String getInformativeFriendlyLabel() {
        return getLabel();
    }
}
