package fr.capwebct.modules.payment.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private long id;

    private String contractId;
    private String contractLabel;
    private int contractValue;
    private Date contractDate;
    private int buyPrice;
    private int buyMin;
    private int buyMax;

    private ExternalFamilyAccount externalFamilyAccount;
    private ExternalIndividual externalIndividual;
    private String broker;
    
    private List<ContractDetail> contractDetailList;

    public Contract() {
    }

    public int getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(int buyMax) {
        this.buyMax = buyMax;
    }

    public int getBuyMin() {
        return buyMin;
    }

    public void setBuyMin(int buyMin) {
        this.buyMin = buyMin;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractLabel() {
        return contractLabel;
    }

    public void setContractLabel(String contractLabel) {
        this.contractLabel = contractLabel;
    }

    public int getContractValue() {
        return contractValue;
    }

    public void setContractValue(int contractValue) {
        this.contractValue = contractValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public ExternalFamilyAccount getExternalFamilyAccount() {
        return externalFamilyAccount;
    }

    public void setExternalFamilyAccount(ExternalFamilyAccount externalFamilyAccount) {
        this.externalFamilyAccount = externalFamilyAccount;
    }

    public ExternalIndividual getExternalIndividual() {
        return externalIndividual;
    }

    public void setExternalIndividual(ExternalIndividual externalIndividual) {
        this.externalIndividual = externalIndividual;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public void addContractDetail(ContractDetail contractDetail) {
        if (contractDetailList == null)
            contractDetailList = new ArrayList<ContractDetail>();
        if (contractDetail != null)
            contractDetailList.add(contractDetail);
    }
    
    public boolean removeContractDetail(ContractDetail contractDetail) {
        if (contractDetail == null && contractDetailList == null)
            return false;
        return contractDetailList.remove(contractDetail);
    }
    
    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Contract))
            return false;
        Contract contract = (Contract) object;
        if (this.id == 0 && contract.id == 0) {
            return this.contractId.equals(contract.getContractId())
                && this.externalFamilyAccount.equals(contract.getExternalFamilyAccount());
        } else {
            return this.id == contract.id;
        }
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
