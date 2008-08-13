package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.ExternalIndividual;

public class ExternalFamilyAccountWrapper {

    private String externalFamilyAccountId;
    private String address;
    private ExternalIndividual externalIndividual;
    
    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }

    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }

    public ExternalIndividual getExternalIndividual() {
        return externalIndividual;
    }

    public void setExternalIndividual(ExternalIndividual externalIndividual) {
        this.externalIndividual = externalIndividual;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
