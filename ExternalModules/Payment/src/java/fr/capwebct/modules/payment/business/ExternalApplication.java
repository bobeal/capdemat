package fr.capwebct.modules.payment.business;

import java.util.HashSet;
import java.util.Set;

public class ExternalApplication {

    private long id;
    
    private String label;
    private String description;
    private Set<String> brokers;
    private Set<ExternalFamilyAccount> externalFamilyAccounts;
    
    public ExternalApplication() {
    }

    public Set<String> getBrokers() {
        return brokers;
    }

    public String getFormattedBrokers() {
        if (brokers == null || brokers.size() == 0)
            return "";
        
        StringBuffer sb = new StringBuffer();
        for (String broker : brokers) {
            sb.append(broker).append(" / ");
        }
        
        String result = sb.toString();
        return result.substring(0, result.length() - 2);
    }
    
    public void setBrokers(Set<String> brokers) {
        this.brokers = brokers;
    }

    public void addBroker(String broker) {
        if (brokers == null)
            brokers = new HashSet<String>();
        brokers.add(broker);
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<ExternalFamilyAccount> getExternalFamilyAccounts() {
        return externalFamilyAccounts;
    }

    public void setExternalFamilyAccounts(
            Set<ExternalFamilyAccount> externalFamilyAccounts) {
        this.externalFamilyAccounts = externalFamilyAccounts;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ExternalApplication))
            return false;
        ExternalApplication externalApplication = (ExternalApplication) object;
        return (this.getLabel().equals(externalApplication.getLabel()));
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }

}
