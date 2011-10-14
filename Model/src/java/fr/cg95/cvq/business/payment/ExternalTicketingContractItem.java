package fr.cg95.cvq.business.payment;

import java.util.Date;

/**
 * 
 * @hibernate.subclass
 *  discriminator-value="EXTERNAL_TICKETING_CONTRACT_ITEM"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class ExternalTicketingContractItem extends ExternalAccountItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_TICKETING_CONTRACT_ID = "externalTicketingContractId";

    private Long subjectId;
    private Double unitPrice;
    private Integer minBuy;
    private Integer maxBuy;
    private Integer quantity;
    private Integer oldQuantity;
    private Date creationDate;
    
    public ExternalTicketingContractItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final Long subjectId, final Double unitPrice, final Integer minBuy,
            final Integer maxBuy, final Date creationDate,
            final String broker) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.subjectId = subjectId;
        this.unitPrice = unitPrice;
        this.minBuy = minBuy;
        this.maxBuy = maxBuy;
        this.creationDate = creationDate;
        this.oldQuantity = (new Double(amount / unitPrice)).intValue();
    }

    @Deprecated
    public ExternalTicketingContractItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final Long subjectId, final Double unitPrice, final Integer minBuy,
            final Integer maxBuy, final Integer quantity, final Date creationDate,
            final Integer oldQuantity, final String broker) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.subjectId = subjectId;
        this.unitPrice = unitPrice;
        this.minBuy = minBuy;
        this.maxBuy = maxBuy;
        this.creationDate = creationDate;
        this.quantity = quantity;
        this.oldQuantity = oldQuantity;
    }

    public ExternalTicketingContractItem() {
        super();
    }
    
    /**
     * @hibernate.property
     *  column="creation_date"
     *  
     * @fixme is this the contract creation date or the contract state date ??
     */
    public final Date getCreationDate() {
        return creationDate;
    }

    public final void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @hibernate.property
     *  column="max_buy"
     */
    public final Integer getMaxBuy() {
        return maxBuy;
    }

    public final void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }

    /**
     * @hibernate.property
     *  column="min_buy"
     */
    public final Integer getMinBuy() {
        return minBuy;
    }

    public final void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
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
     *  column="subject_id"
     */
    public final Long getSubjectId() {
        return subjectId;
    }

    public final void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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
     *  column="old_quantity"
     */
    public final Integer getOldQuantity() {
        return oldQuantity;
    }

    public final void setOldQuantity(Integer oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    @Override
    public String getInformativeFriendlyLabel() {

        StringBuffer sb = new StringBuffer().append(getLabel())
            .append(" (n° ").append(getExternalItemId()).append(") - Numéro de carte : ")
            .append(getExternalServiceSpecificDataByKey("child-csn"));
    
        return sb.toString();
    }
}
