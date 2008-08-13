package fr.capwebct.modules.payment.business.ws;

import java.util.Calendar;
import java.util.Date;

import fr.capwebct.modules.payment.schema.ban.AccountUpdateType;

/**
 * Represent an account update in the context of a credit operation. It is part of a
 * {@link PaymentTransaction}.
 */
public class AccountUpdate {

    private String accountId;
    private String externalFamilyAccountId;
    private long externalApplicationId;
    
    private int accountOldValue;
    private Date accountOldValueDate;
    private int accountNewValue;

    public AccountUpdate() {
    }

    public static AccountUpdateType modelToXml(AccountUpdate accountUpdate) {
        if (accountUpdate == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        AccountUpdateType accountUpdateType = AccountUpdateType.Factory.newInstance();
        if (accountUpdate.getAccountId() != null)
            accountUpdateType.setAccountId(accountUpdate.getAccountId());
        if (accountUpdate.getExternalApplicationId() != 0)
            accountUpdateType.setExternalApplicationId(accountUpdate.getExternalApplicationId());
        if (accountUpdate.getExternalFamilyAccountId() != null)
            accountUpdateType.setExternalFamilyAccountId(accountUpdate.getExternalFamilyAccountId());
        if (accountUpdate.getAccountOldValueDate() != null) {
            calendar.setTime(accountUpdate.getAccountOldValueDate());
            accountUpdateType.setAccountOldValueDate(calendar);
        }
        accountUpdateType.setAccountOldValue(accountUpdate.getAccountOldValue());
        accountUpdateType.setAccountNewValue(accountUpdate.getAccountNewValue());
        
        return accountUpdateType;
    }

    public static AccountUpdate xmlToModel(AccountUpdateType accountUpdateType) {
        if (accountUpdateType == null)
            return null;
        AccountUpdate accountUpdate = new AccountUpdate();
        if (accountUpdateType.getAccountId() != null)
            accountUpdate.setAccountId(accountUpdateType.getAccountId());
        if (accountUpdateType.getExternalApplicationId() != 0)
            accountUpdate.setExternalApplicationId(accountUpdateType.getExternalApplicationId());
        if (accountUpdateType.getExternalFamilyAccountId() != null)
            accountUpdate.setExternalFamilyAccountId(accountUpdateType.getExternalFamilyAccountId());
        if (accountUpdateType.getAccountOldValueDate() != null)
            accountUpdate.setAccountOldValueDate(accountUpdateType.getAccountOldValueDate().getTime());
        accountUpdate.setAccountOldValue(accountUpdateType.getAccountOldValue());
        accountUpdate.setAccountNewValue(accountUpdateType.getAccountNewValue());
        return accountUpdate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAccountNewValue() {
        return accountNewValue;
    }

    public void setAccountNewValue(int accountNewValue) {
        this.accountNewValue = accountNewValue;
    }

    public int getAccountOldValue() {
        return accountOldValue;
    }

    public void setAccountOldValue(int accountOldValue) {
        this.accountOldValue = accountOldValue;
    }

    public Date getAccountOldValueDate() {
        return accountOldValueDate;
    }

    public void setAccountOldValueDate(Date accountOldValueDate) {
        this.accountOldValueDate = accountOldValueDate;
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
