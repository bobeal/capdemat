package fr.capwebct.modules.payment.business;

public enum ExternalDataType {

    ACCOUNT ("account", "business.accounts"),
    INVOICE("invoice", "business.invoices"),
    CONTRACT("contract", "business.contracts"),
    INVOICE_DETAIL("invoice-detail", "business.invoices_details"),
    ACCOUNT_DETAIL("account-detail", "business.accounts_details"),
    EXTERNAL_FAMILY_ACCOUNT("external-family-account", "business.external_family_accounts");
    
    private final String key;
    private final String i18nKey;
    
    ExternalDataType(final String key, final String i18nKey) {
        this.key = key;
        this.i18nKey = i18nKey;
    }
    
    public static ExternalDataType forKey(final String key) {
        
        if (key == null || key.equals(""))
            return null;
        
        if (key.equals(ExternalDataType.INVOICE.getKey())) {
            return INVOICE;
        } else if (key.equals(ExternalDataType.ACCOUNT.getKey())) {
            return ACCOUNT;
        } else if (key.equals(ExternalDataType.CONTRACT.getKey())) {
            return CONTRACT;
        } else if (key.equals(ExternalDataType.INVOICE_DETAIL.getKey())) {
            return INVOICE_DETAIL;
        } else if (key.equals(ExternalDataType.ACCOUNT_DETAIL.getKey())) {
            return ACCOUNT_DETAIL;
        } else if (key.equals(ExternalDataType.EXTERNAL_FAMILY_ACCOUNT.getKey())) {
            return EXTERNAL_FAMILY_ACCOUNT;
        }
        
        return null;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getI18nKey() {
        return i18nKey;
    }
    
    @Override
    public String toString() {
        return key;
    }
}
