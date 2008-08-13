package fr.capwebct.modules.payment.business;

import java.util.Date;
import java.util.List;

/**
 * Represents an invoice.
 */
public class Invoice {

    public long id;

    private String invoiceId;
    private int invoiceValue;
    private String invoiceLabel;
    private Date invoiceDate;
    private Date invoiceExpirationDate;
    private Date invoicePaymentDate;
    private boolean invoicePayed;
    
    private List<InvoiceDetail> invoiceDetailList;
    
    private String broker;
    private ExternalFamilyAccount externalFamilyAccount;
    private Payment payment;

    public Invoice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceExpirationDate() {
        return invoiceExpirationDate;
    }

    public void setInvoiceExpirationDate(Date invoiceExpirationDate) {
        this.invoiceExpirationDate = invoiceExpirationDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceLabel() {
        return invoiceLabel;
    }

    public void setInvoiceLabel(String invoiceLabel) {
        this.invoiceLabel = invoiceLabel;
    }

    public boolean isInvoicePayed() {
        return invoicePayed;
    }

    public void setInvoicePayed(boolean invoicePayed) {
        this.invoicePayed = invoicePayed;
    }

    public Date getInvoicePaymentDate() {
        return invoicePaymentDate;
    }

    public void setInvoicePaymentDate(Date invoicePaymentDate) {
        this.invoicePaymentDate = invoicePaymentDate;
    }

    public int getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(int invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ExternalFamilyAccount getExternalFamilyAccount() {
        return externalFamilyAccount;
    }

    public void setExternalFamilyAccount(ExternalFamilyAccount externalFamilyAccount) {
        this.externalFamilyAccount = externalFamilyAccount;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Invoice))
            return false;
        Invoice invoice = (Invoice) object;
        if (this.id == 0 && invoice.id == 0) {
            return this.invoiceId.equals(invoice.getInvoiceId())
                && this.externalFamilyAccount.equals(invoice.getExternalFamilyAccount());
        } else {
            return this.id == invoice.id;
        }
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
