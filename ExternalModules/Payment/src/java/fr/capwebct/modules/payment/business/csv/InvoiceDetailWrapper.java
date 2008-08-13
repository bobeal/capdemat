package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.InvoiceDetail;

public class InvoiceDetailWrapper {

    private String invoiceId;
    private String externalFamilyAccountId;

    private InvoiceDetail invoiceDetail;
    
    public InvoiceDetail getInvoiceDetail() {
        return invoiceDetail;
    }
    
    public void setInvoiceDetail(InvoiceDetail invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }
    
    public String getInvoiceId() {
        return invoiceId;
    }
    
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }

    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }
}
