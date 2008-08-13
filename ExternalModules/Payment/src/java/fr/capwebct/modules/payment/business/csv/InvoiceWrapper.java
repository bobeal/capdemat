package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.Invoice;

public class InvoiceWrapper {

    private String externalFamilyAccountId;
    private Invoice invoice;
    
    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }
    
    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }
    
    public Invoice getInvoice() {
        return invoice;
    }
    
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
