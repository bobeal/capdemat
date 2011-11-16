package fr.cg95.cvq.business.payment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import fr.cg95.cvq.util.DateUtils;

@Entity
@DiscriminatorValue(value="EXTERNAL_TICKETING_CONTRACT_ITEM")
public class ExternalTicketingContractItem extends ExternalAccountItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_TICKETING_CONTRACT_ID = "externalTicketingContractId";

    @Column(name="subject_id")
    private Long subjectId;

    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name="min_buy")
    private Integer minBuy;

    @Column(name="max_buy")
    private Integer maxBuy;

    private Integer quantity;
    
    @Column(name="old_quantity")
    private Integer oldQuantity;

    @Column(name="creation_date")
    private Date creationDate;

	  @Column(name="external_url")
    private String externalUrl;

    public ExternalTicketingContractItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final Long subjectId, final Double unitPrice, final Integer minBuy,
            final Integer maxBuy, final Date creationDate,
            final String broker, final String externalUrl) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.subjectId = subjectId;
        this.unitPrice = unitPrice;
        this.minBuy = minBuy;
        this.maxBuy = maxBuy;
        this.creationDate = creationDate;
        this.oldQuantity = (new Double(amount / unitPrice)).intValue();
				this.externalUrl = externalUrl;
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

    public final Date getCreationDate() {
        return creationDate;
    }

    public final void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public final Integer getMaxBuy() {
        return maxBuy;
    }

    public final void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }

    public final Integer getMinBuy() {
        return minBuy;
    }

    public final void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    public final Integer getQuantity() {
        return quantity;
    }

    public final void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public final Long getSubjectId() {
        return subjectId;
    }

    public final void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public final Double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public final String getExternalUrl() {
        return externalUrl;
    }

    public final void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

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
