package fr.capwebct.modules.payment.controller;

public class GenericAccountCommand {

    // common properties
    private String id;
    private String label;
    private String efaId;
    private String externalApplicationId;
    
    // invoice specific properties
    private String paymentDateStart;
    private String paymentDateEnd;

    // contract / child account specific properties
    private String externalIndividualId;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEfaId() {
        return efaId;
    }

    public void setEfaId(String efaId) {
        this.efaId = efaId;
    }

    public String getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(String externalApplicationLabel) {
        this.externalApplicationId = externalApplicationLabel;
    }

    public String getPaymentDateEnd() {
        return paymentDateEnd;
    }
    
    public void setPaymentDateEnd(String paymentDateEnd) {
        this.paymentDateEnd = paymentDateEnd;
    }
    
    public String getPaymentDateStart() {
        return paymentDateStart;
    }
    
    public void setPaymentDateStart(String paymentDateStart) {
        this.paymentDateStart = paymentDateStart;
    }

    public String getExternalIndividualId() {
        return externalIndividualId;
    }

    public void setExternalIndividualId(String externalIndividualId) {
        this.externalIndividualId = externalIndividualId;
    }
}
