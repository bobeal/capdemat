package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.AccountDetail;

public class AccountDetailWrapper {

    private String accountId;
    private String externalFamilyAccountId;
    
    private AccountDetail accountDetail;
    
    public AccountDetail getAccountDetail() {
        return accountDetail;
    }
    
    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String invoiceId) {
        this.accountId = invoiceId;
    }

    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }

    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }
}
