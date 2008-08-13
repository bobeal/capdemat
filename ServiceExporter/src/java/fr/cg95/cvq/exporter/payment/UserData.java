package fr.cg95.cvq.exporter.payment;

public class UserData {

    private String homeFolderId;
    private String requestId;
    private String amount;
    
    public String getAmount() {
        return amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getHomeFolderId() {
        return homeFolderId;
    }
    
    public void setHomeFolderId(String homeFolderId) {
        this.homeFolderId = homeFolderId;
    }
    
    public String getRequestId() {
        return requestId;
    }
    
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
