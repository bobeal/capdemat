package fr.capwebct.modules.payment.business.ws;

import fr.capwebct.modules.payment.schema.ban.InvoiceUpdateType;


public class InvoiceUpdate {

    private String invoiceId;
    private String externalFamilyAccountId;
    private long externalApplicationId;
    private int amount;

    public InvoiceUpdate() {
    }

    public static InvoiceUpdateType modelToXml(InvoiceUpdate invoiceUpdate) {
        if (invoiceUpdate == null)
            return null;
        InvoiceUpdateType invoiceUpdateType = InvoiceUpdateType.Factory.newInstance();
        if (invoiceUpdate.getInvoiceId() != null)
            invoiceUpdateType.setInvoiceId(invoiceUpdate.getInvoiceId());
        if (invoiceUpdate.getExternalApplicationId() != 0)
            invoiceUpdateType.setExternalApplicationId(invoiceUpdate.getExternalApplicationId());
        if (invoiceUpdate.getExternalFamilyAccountId() != null)
            invoiceUpdateType.setExternalFamilyAccountId(invoiceUpdate.getExternalFamilyAccountId());   
        invoiceUpdateType.setAmount(invoiceUpdate.getAmount());
        return invoiceUpdateType;
    }

    public static InvoiceUpdate xmlToModel(InvoiceUpdateType invoiceUpdateType) {
        if (invoiceUpdateType == null)
            return null;
        InvoiceUpdate invoiceUpdate = new InvoiceUpdate();
        if (invoiceUpdateType.getInvoiceId() != null)
            invoiceUpdate.setInvoiceId(invoiceUpdateType.getInvoiceId());
        if (invoiceUpdateType.getExternalApplicationId() != 0)
            invoiceUpdate.setExternalApplicationId(invoiceUpdateType.getExternalApplicationId());
        if (invoiceUpdateType.getExternalFamilyAccountId() != null)
            invoiceUpdate.setExternalFamilyAccountId(invoiceUpdateType.getExternalFamilyAccountId());
        invoiceUpdate.setAmount(invoiceUpdateType.getAmount());  
        return invoiceUpdate;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public long getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(long externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }
}