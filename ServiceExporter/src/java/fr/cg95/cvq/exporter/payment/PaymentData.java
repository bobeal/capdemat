package fr.cg95.cvq.exporter.payment;

public class PaymentData {

    private String cardNumber;
    private String cardKey;
    private String email;
    private String cvqReference;
    private String callbackUrl;
    
    public final String getCardKey() {
        return cardKey;
    }
    
    public final void setCardKey(String cardKey) {
        this.cardKey = cardKey;
    }
    
    public final String getCardNumber() {
        return cardNumber;
    }
    
    public final void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = email;
    }

    public final String getCvqReference() {
        return cvqReference;
    }

    public final void setCvqReference(String cvqReference) {
        this.cvqReference = cvqReference;
    }

    public final String getCallbackUrl() {
        return callbackUrl;
    }

    public final void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
