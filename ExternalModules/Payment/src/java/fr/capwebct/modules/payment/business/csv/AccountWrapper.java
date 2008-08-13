package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.Account;

public class AccountWrapper {

    private String externalFamilyAccountId;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }

    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }
}
