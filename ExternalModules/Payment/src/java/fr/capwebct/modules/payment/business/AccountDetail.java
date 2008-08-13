package fr.capwebct.modules.payment.business;

import java.util.Calendar;

import fr.capwebct.modules.payment.schema.acc.AccountDetailType;

public class AccountDetail {

    private long id;

    private String holderName;
    private String holderSurname;
    private int value;
    
    private Payment payment;

    public AccountDetail() {
    }

    public static AccountDetailType modelToXml(AccountDetail accountDetail) {
        if (accountDetail == null)
            return null;

        AccountDetailType accountDetailType = AccountDetailType.Factory.newInstance();
        if (accountDetail.getHolderName() != null)
            accountDetailType.setHolderName(accountDetail.getHolderName());
        if (accountDetail.getHolderSurname() != null)
            accountDetailType.setHolderSurname(accountDetail.getHolderSurname());
        accountDetailType.setValue(accountDetail.getValue());

        Payment payment = accountDetail.getPayment();
        if (payment != null) {
            if (payment.getPaymentDate() != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(payment.getPaymentDate());
                accountDetailType.setDate(calendar);
            }
            if (payment.getPaymentAck() != null)
                accountDetailType.setPaymentAck(payment.getPaymentAck());
            if (payment.getCvqAck() != null)
                accountDetailType.setCvqAck(payment.getCvqAck());
        
            accountDetailType.setPaymentType(payment.getPaymentType());
        }

        return accountDetailType;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderSurname() {
        return holderSurname;
    }

    public void setHolderSurname(String holderSurname) {
        this.holderSurname = holderSurname;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof AccountDetail))
            return false;
        AccountDetail accountDetail = (AccountDetail) object;
        return this.id == accountDetail.id;
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
