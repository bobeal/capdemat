package fr.cg95.cvq.business.users.payment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.payment.PaymentUtils;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.util.DateUtils;

/**
 * Represent an invoice managed by an external service. This invoice can be already paid
 * or to be paid.
 * 
 * @hibernate.subclass
 *  discriminator-value="EXTERNAL_INVOICE_ITEM"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class ExternalInvoiceItem extends ExternalAccountItem {

    private static final long serialVersionUID = 1L;

    private Date issueDate;
    private Date expirationDate;
    /** only available for already paid invoices */
    private Date paymentDate;
    private Boolean isPaid;
    
    private Set<ExternalInvoiceItemDetail> invoiceDetails;
    
    public ExternalInvoiceItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final Date issueDate, final Date expirationDate, final Date paymentDate,
            final Boolean isPaid, final String broker) {
        super(label, amount, externalServiceLabel, externalItemId, broker);
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
    }

    public ExternalInvoiceItem() {
        super();
    }
    
    /**
     * @hibernate.property
     *  column="issue_date"
     */
    public final Date getIssueDate() {
        return issueDate;
    }

    public final void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public final Boolean isPaid() {
        return isPaid;
    }

    public final void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    @Override
    public String getFriendlyLabel() {

        StringBuffer sb = 
            new StringBuffer().append("Facture n°").append(getExternalItemId())
                .append(" du ").append(DateUtils.format(this.issueDate))
                .append(" - ").append(PaymentUtils.formatPrice(getAmount().intValue()))
                .append(" &euro; (").append(getLabel()).append(")");

        return sb.toString();
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
        return invoiceDetails;
    }

    public final void setInvoiceDetails(Set<ExternalInvoiceItemDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
    
    public final void addInvoiceDetail(ExternalInvoiceItemDetail invoiceDetail) {
        if (this.invoiceDetails == null)
            this.invoiceDetails = new HashSet<ExternalInvoiceItemDetail>();
        this.invoiceDetails.add(invoiceDetail);
    }

    /**
     * @hibernate.property
     *  column="expiration_date"
     */
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
}
