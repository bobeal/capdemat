package fr.capwebct.modules.payment.controller;

public class PaymentCommand {

    private String paymentDateStart;
    private String paymentDateEnd;
    private String paymentAck;
    private String cvqAck;
    /**
     * unused
     */
    private String externalApplicationId;
    private String cfaId;
    private String broker;
    
    public PaymentCommand() {
    }
    
    public String getCvqAck() {
        return cvqAck;
    }

    public void setCvqAck(String cvqAck) {
        this.cvqAck = cvqAck;
    }

    public String getPaymentAck() {
        return paymentAck;
    }

    public void setPaymentAck(String paymentAck) {
        this.paymentAck = paymentAck;
    }

    public String getPaymentDateStart() {
        return paymentDateStart;
    }

    public void setPaymentDateStart(String paymentDate) {
        this.paymentDateStart = paymentDate;
    }

    public String getPaymentDateEnd() {
        return paymentDateEnd;
    }

    public void setPaymentDateEnd(String paymentDateEnd) {
        this.paymentDateEnd = paymentDateEnd;
    }

    public String getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(String externalApplicationLabel) {
        this.externalApplicationId = externalApplicationLabel;
    }

    public String getCfaId() {
        return cfaId;
    }

    public void setCfaId(String cfaId) {
        this.cfaId = cfaId;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }
}
