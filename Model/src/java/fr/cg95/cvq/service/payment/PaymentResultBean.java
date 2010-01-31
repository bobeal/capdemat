package fr.cg95.cvq.service.payment;

public class PaymentResultBean {

    private PaymentResultStatus status;
    private String cvqReference;
    private String bankReference;
    
    public PaymentResultBean() {
        this.status = PaymentResultStatus.UNKNOWN;
    }

    public PaymentResultBean(PaymentResultStatus status, 
            String cvqReference, String bankReference) {
        this.status = status;
        this.cvqReference = cvqReference;
        this.bankReference = bankReference;
    }
    
    public final String getBankReference() {
        return bankReference;
    }
    
    public final void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }
    
    public final String getCvqReference() {
        return cvqReference;
    }
    
    public final void setCvqReference(String cvqReference) {
        this.cvqReference = cvqReference;
    }
    
    public final PaymentResultStatus getStatus() {
        return status;
    }
    
    public final void setStatus(PaymentResultStatus status) {
        this.status = status;
    }
}
