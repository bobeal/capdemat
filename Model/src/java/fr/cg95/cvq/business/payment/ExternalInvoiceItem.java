package fr.cg95.cvq.business.payment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import fr.cg95.cvq.service.payment.PaymentUtils;
import fr.cg95.cvq.util.DateUtils;

@Entity
@Inheritance
@DiscriminatorValue(value="EXTERNAL_INVOICE_ITEM")
public class ExternalInvoiceItem extends ExternalAccountItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_INVOICE_ID = "externalInvoiceId";
    public static final String SEARCH_BY_EXPIRATION_DATE = "expirationDate";
    public static final String SEARCH_BY_INVOICE_STATE = "isPaid";

    @Column(name="issue_date")
    private Date issueDate;

    @Column(name="expiration_date")
    private Date expirationDate;

    /** only available for already paid invoices */
    @Column(name="payment_date")
    private Date paymentDate;

    @Column(name="is_paid")
    private Boolean isPaid;

    @Transient private Double totalValue;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="externalInvoiceItem")
    private Set<ExternalInvoiceItemDetail> invoiceDetails;

    public ExternalInvoiceItem(final String label, final Double amount, final Double totalValue,
            final String externalServiceLabel, final String externalItemId,
            final Date issueDate, final Date expirationDate, final Date paymentDate,
            final Boolean isPaid, final String broker) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
        this.totalValue = totalValue;
    }

    public ExternalInvoiceItem() {
        super();
    }

    public final Date getIssueDate() {
        return issueDate;
    }

    public final void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public final Boolean getIsPaid() {
        return isPaid;
    }

    public final void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String getInformativeFriendlyLabel() {
        StringBuffer sb = 
            new StringBuffer().append("Facture n°").append(getExternalItemId())
                .append(" du ").append(DateUtils.format(this.issueDate))
                .append("(").append(getLabel()).append(")");

        return sb.toString();
    }

    /**
     * If this invoice is paid, get the details of items covered by this invoice. 
     * Details are not automatically loaded from external services, you have to call 
     * {@link IHomeFolderService#loadExternalInvoiceDetails(ExternalInvoiceItem)}
     * to load them into this object.
     */
    public final Set<ExternalInvoiceItemDetail> getInvoiceDetails() {
        if (this.invoiceDetails == null)
            return new HashSet<ExternalInvoiceItemDetail>();
        return invoiceDetails;
    }

    public final void setInvoiceDetails(Set<ExternalInvoiceItemDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public final void addInvoiceDetail(ExternalInvoiceItemDetail invoiceDetail) {
        if (this.invoiceDetails == null)
            this.invoiceDetails = new HashSet<ExternalInvoiceItemDetail>();
        this.invoiceDetails.add(invoiceDetail);
        invoiceDetail.setExternalInvoiceItem(this);
    }

    public final Date getExpirationDate() {
        return expirationDate;
    }

    public final void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public final Date getPaymentDate() {
        return paymentDate;
    }

    public final void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
