package fr.capwebct.modules.payment.business.csv;

import fr.capwebct.modules.payment.business.Contract;

public class ContractWrapper {

    private String externalFamilyAccountId;    
    private String externalIndividualId;
    private Contract contract;
    
    public String getExternalIndividualId() {
        return externalIndividualId;
    }
    
    public void setExternalIndividualId(String childId) {
        this.externalIndividualId = childId;
    }
    
    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }
    
    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }    
}
