package fr.capwebct.modules.payment.business.ws;

import fr.capwebct.modules.payment.schema.ban.ContractUpdateType;

public class ContractUpdate {
    private String contractId;
    
    private String externalIndividualId;
    private String externalFamilyAccountId;
    private long externalApplicationId;
    private long capwebctIndividualId;
    private int quantity;
    private int price;
    private int amount;

    public ContractUpdate() {
    }

    public static ContractUpdateType modelToXml(ContractUpdate contractUpdate) {
        if (contractUpdate == null)
            return null;
        ContractUpdateType contractUpdateType = ContractUpdateType.Factory.newInstance();
        if (contractUpdate.getContractId() != null)
            contractUpdateType.setContractId(contractUpdate.getContractId());
        if (contractUpdate.getExternalIndividualId() != null)
            contractUpdateType.setExternalIndividualId(contractUpdate.getExternalIndividualId());
        if (contractUpdate.getExternalApplicationId() != 0)
            contractUpdateType.setExternalApplicationId(contractUpdate.getExternalApplicationId());
        if (contractUpdate.getExternalFamilyAccountId() != null)
            contractUpdateType.setExternalFamilyAccountId(contractUpdate.getExternalFamilyAccountId());
        contractUpdateType.setCapwebctIndividualId(contractUpdate.getCapwebctIndividualId());
        contractUpdateType.setQuantity(contractUpdate.getQuantity());
        contractUpdateType.setPrice(contractUpdate.getPrice());
        contractUpdateType.setAmount(contractUpdate.getAmount());        
        return contractUpdateType;
    }

    public static ContractUpdate xmlToModel(ContractUpdateType contractUpdateType) {
        if (contractUpdateType == null)
            return null;
        ContractUpdate contractUpdate = new ContractUpdate();
        if (contractUpdateType.getContractId() != null)
            contractUpdate.setContractId(contractUpdateType.getContractId());
        if (contractUpdateType.getExternalIndividualId() != null)
            contractUpdate.setExternalIndividualId(contractUpdateType.getExternalIndividualId());  
        if (contractUpdateType.getExternalApplicationId() != 0)
            contractUpdate.setExternalApplicationId(contractUpdateType.getExternalApplicationId());
        if (contractUpdateType.getExternalFamilyAccountId() != null)
            contractUpdate.setExternalFamilyAccountId(contractUpdateType.getExternalFamilyAccountId());
        contractUpdate.setCapwebctIndividualId(contractUpdateType.getCapwebctIndividualId());
        contractUpdate.setQuantity(contractUpdateType.getQuantity());
        contractUpdate.setPrice(contractUpdateType.getPrice());
        contractUpdate.setAmount(contractUpdateType.getAmount());
        return contractUpdate;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getCapwebctIndividualId() {
        return capwebctIndividualId;
    }

    public void setCapwebctIndividualId(long childId) {
        this.capwebctIndividualId = childId;
    }

    public String getContractId() {
        return contractId;
    }
    
    public String getExternalFamilyAccountId() {
        return externalFamilyAccountId;
    }

    public void setExternalFamilyAccountId(String externalFamilyAccountId) {
        this.externalFamilyAccountId = externalFamilyAccountId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getExternalIndividualId() {
        return externalIndividualId;
    }

    public void setExternalIndividualId(String externalIndividualId) {
        this.externalIndividualId = externalIndividualId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(long externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }
}

