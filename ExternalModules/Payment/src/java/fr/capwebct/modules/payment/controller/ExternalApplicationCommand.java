package fr.capwebct.modules.payment.controller;

import fr.capwebct.modules.payment.business.ExternalApplication;

public class ExternalApplicationCommand {
    
    private String id;
    private String label;
    private String description;
    private String mode;
    private String broker1;
    private String broker2;
    private String broker3;
    
    public ExternalApplicationCommand(ExternalApplication externalApplication) {
        this.id = String.valueOf(externalApplication.getId());
        this.label = externalApplication.getLabel();
        this.description = externalApplication.getDescription();
        int i = 0;
        for (String broker : externalApplication.getBrokers()) {
            if (i == 0)
                this.broker1 = broker;
            else if (i == 1)
                this.broker2 = broker;
            else if (i == 2)
                this.broker3 = broker;
            else 
                break;
            i++;
        }
    }

    public ExternalApplicationCommand() {
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
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
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBroker1() {
        return broker1;
    }

    public void setBroker1(String broker1) {
        this.broker1 = broker1;
    }

    public String getBroker2() {
        return broker2;
    }

    public void setBroker2(String broker2) {
        this.broker2 = broker2;
    }

    public String getBroker3() {
        return broker3;
    }

    public void setBroker3(String broker3) {
        this.broker3 = broker3;
    }
}
