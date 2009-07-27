package fr.capwebct.modules.payment.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.dao.IContractDAO;
import fr.capwebct.modules.payment.dao.IObjectDAO;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IContractService;

public class ContractService implements IContractService {

    private static Log log = LogFactory.getLog(ContractService.class);

    private IContractDAO contractDAO;
    private IObjectDAO objectDAO;

    public ContractService() {
        super();
    }
    
    public void saveContract(Contract contract) 
        throws DataAccessException, CpmBusinessException {
        
        ExternalFamilyAccount externalFamilyAccount = contract.getExternalFamilyAccount();
        if (externalFamilyAccount == null)
            throw new CpmBusinessException("contract.external_family_account_required");
        externalFamilyAccount.addContract(contract);
        objectDAO.update(externalFamilyAccount);
    }

    public void saveContracts(List<Contract> contractList)
        throws DataAccessException, CpmBusinessException {
    
        for (Contract contract : contractList)
            saveContract(contract);
    }

    public void importContracts(List<Contract> contractList,
            long externalApplicationId, String broker) 
        throws DataAccessException, CpmBusinessException {

        if (externalApplicationId == 0) {
            log.warn("importContracts() no external application id provided !");
            return;
        }

        List<Contract> contracts =
            contractDAO.findByExternalApplicationAndBroker(externalApplicationId, broker);
        deleteContracts(contracts);

        saveContracts(contractList);
    }
    
    public Contract getContract(long id, boolean loadCollection) throws DataAccessException {
        Contract contract = (Contract) contractDAO.read(Contract.class, id);
        if (loadCollection)
            contractDAO.initializeProxy(contract.getContractDetailList());
        return contract;
    }

    public Contract getByExternalAndAccountId(String externalFamilyAccountId, 
            long externalApplicationId, String externalIndividualId, String contractId) 
        throws DataAccessException {

        return contractDAO.findByExternalAndContractId(externalFamilyAccountId, 
                externalApplicationId, externalIndividualId, contractId);
    }
    
    public List<Contract> getAllContracts(boolean loadCollection)
            throws DataAccessException {

        if (!loadCollection) {
            return contractDAO.findAll();
        } else {
            List<Contract> contracts = contractDAO.findAll();
            for (Contract contract : contracts)
                contractDAO.initializeProxy(contract.getContractDetailList());

            return contracts;
        }
    }

    public List<Contract> getByExternalId(String externalFamilyAccountId,
            long externalApplicationId, String externalIndividualId) 
        throws DataAccessException {
        return contractDAO.findByExternalId(externalFamilyAccountId, 
                externalApplicationId, externalIndividualId);
    }

    public List<Contract> search(String contractId, String contractLabel,
            String externalIndividualId, String efaId, long externalApplicationId) 
        throws DataAccessException {

        return contractDAO.search(contractId, contractLabel, externalIndividualId, 
                efaId, externalApplicationId);
    }

    public void deleteContract(Contract contract) throws DataAccessException {
        contract.getExternalFamilyAccount().removeContract(contract);
        contractDAO.delete(contract);
    }

    public void deleteContracts(List<Contract> contractList) throws DataAccessException {
        for (Contract contract : contractList)
            deleteContract(contract);
    }

    public void deleteAllContracts() throws DataAccessException {
        deleteContracts(getAllContracts(false));
    }
    
    public void setContractDAO(IContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public void setObjectDAO(IObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }
}
