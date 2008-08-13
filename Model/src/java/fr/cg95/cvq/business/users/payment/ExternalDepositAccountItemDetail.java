package fr.cg95.cvq.business.users.payment;

import java.util.Date;

public class ExternalDepositAccountItemDetail {

    private Date date;
    private String holderName;
    private String holderSurname;
    private Integer value;
    private String paymentType;
    private String paymentId;
    private String bankReference;

    public ExternalDepositAccountItemDetail() {
    }
    
    public final Date getDate() {
        return date;
    }
    
    public final void setDate(Date date) {
        this.date = date;
    }
    
    public final String getHolderName() {
        return holderName;
    }
    
    public final void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    
    public final String getHolderSurname() {
        return holderSurname;
    }
    
    public final void setHolderSurname(String holderSurname) {
        this.holderSurname = holderSurname;
    }
    
    public final String getPaymentId() {
        return paymentId;
    }
    
    public final void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public final String getPaymentType() {
        return paymentType;
    }
    
    public final void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public final Integer getValue() {
        return value;
    }
    
    public final void setValue(Integer value) {
        this.value = value;
    }

    public final String getBankReference() {
        return bankReference;
    }

    public final void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }
}
