package fr.capwebct.modules.payment.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represent a deposit account.
 */
public class Account {

    private long id;

    private String accountId;
    private int accountValue;
    private Date accountDate;
    private String accountLabel;
    private String broker;

    private ExternalFamilyAccount externalFamilyAccount;
    
    private List<AccountDetail> accountDetailList;

    public Account() {
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountLabel() {
        return accountLabel;
    }

    public void setAccountLabel(String accountLabel) {
        this.accountLabel = accountLabel;
    }

    public int getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(int accountValue) {
        this.accountValue = accountValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AccountDetail> getAccountDetailList() {
        return accountDetailList;
    }

    public void setAccountDetailList(List<AccountDetail> accountDetailList) {
        this.accountDetailList = accountDetailList;
    }
    
    public void addAccountDetail(AccountDetail accountDetail) {
        if (accountDetailList == null)
            accountDetailList = new ArrayList<AccountDetail>();
        if (accountDetail != null)
            accountDetailList.add(accountDetail);
    }
    
    public boolean removeAccountDetail(AccountDetail accountDetail) {
        if (accountDetail == null && accountDetailList == null)
            return false;
        return accountDetailList.remove(accountDetail);
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
        if (!(object instanceof Account))
            return false;
        Account account = (Account) object;
        if (this.id == 0 && account.id == 0) {
            return this.accountId.equals(account.getAccountId())
                && this.externalFamilyAccount.equals(account.getExternalFamilyAccount());
        } else {
            return this.id == account.id;
        }
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
