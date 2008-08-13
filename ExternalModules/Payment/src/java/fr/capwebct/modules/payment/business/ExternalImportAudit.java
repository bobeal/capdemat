package fr.capwebct.modules.payment.business;

import java.util.Date;

public class ExternalImportAudit {

    private long id;

    private String importType;
    private ExternalDataType externalDataType;
    private String externalApplicationLabel;
    private Agent agent;
    private Date date;
    
    public Agent getAgent() {
        return agent;
    }
    
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getExternalApplicationLabel() {
        return externalApplicationLabel;
    }
    
    public void setExternalApplicationLabel(String externalApplicationLabel) {
        this.externalApplicationLabel = externalApplicationLabel;
    }
    
    public ExternalDataType getExternalDataType() {
        return externalDataType;
    }
    
    public void setExternalDataType(ExternalDataType externalDataType) {
        this.externalDataType = externalDataType;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getImportType() {
        return importType;
    }
}
