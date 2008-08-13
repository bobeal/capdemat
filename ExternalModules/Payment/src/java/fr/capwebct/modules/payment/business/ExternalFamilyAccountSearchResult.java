package fr.capwebct.modules.payment.business;

public class ExternalFamilyAccountSearchResult {

    private String efaId;
    private String efaLastName;
    private String efaFirstName;
    private String efaAddress;
    private String externalApplicationLabel;
    private long cfaId;
    private String cfaResponsible;
    
    public long getCfaId() {
        return cfaId;
    }
    
    public void setCfaId(long cfaId) {
        this.cfaId = cfaId;
    }
    
    public String getCfaResponsible() {
        return cfaResponsible;
    }
    
    public void setCfaResponsible(String cfaResponsible) {
        this.cfaResponsible = cfaResponsible;
    }
    
    public String getEfaFirstName() {
        return efaFirstName;
    }
    
    public void setEfaFirstName(String efaFirstName) {
        this.efaFirstName = efaFirstName;
    }
    
    public String getEfaFullName() {
        return this.efaLastName + " " + this.efaFirstName;
    }
    
    public String getEfaId() {
        return efaId;
    }
    
    public void setEfaId(String efaId) {
        this.efaId = efaId;
    }
    
    public String getEfaLastName() {
        return efaLastName;
    }
    
    public void setEfaLastName(String efaLastName) {
        this.efaLastName = efaLastName;
    }
    
    public String getEfaAddress() {
        return efaAddress;
    }

    public void setEfaAddress(String efaAddress) {
        this.efaAddress = efaAddress;
    }

    public String getExternalApplicationLabel() {
        return externalApplicationLabel;
    }
    
    public void setExternalApplicationLabel(String externalApplicationLabel) {
        this.externalApplicationLabel = externalApplicationLabel;
    }
}
