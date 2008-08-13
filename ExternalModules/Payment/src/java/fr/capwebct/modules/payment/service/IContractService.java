package fr.capwebct.modules.payment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.exception.CpmBusinessException;

public interface IContractService {
    
    /**
     * Save a contract. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if a contract has no external family account associated
     */
    void saveContract(Contract contract) throws DataAccessException, CpmBusinessException;
	
    /**
     * Save a list of contracts. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if a contract has no external family account associated
     */
	void saveContracts(List<Contract> contractList) 
        throws DataAccessException, CpmBusinessException;

    /**
     * Import a list of contracts for the given external application. Existing contracts
     * for this external application will first be deleted.
     * 
     * @throws CpmBusinessException if an contract has no external family account associated
     */
    void importContracts(List<Contract> contractList, long externalApplicationId) 
        throws DataAccessException, CpmBusinessException;

    Contract getContract(long id, boolean loadCollection) 
        throws DataAccessException;

    Contract getByExternalAndAccountId(String externalFamilyAccountId, 
            long externalApplicationId, String externalIndividualId,
            String contractId) throws DataAccessException;
    
	List<Contract> getAllContracts(boolean loadCollection) 
        throws DataAccessException;

	List<Contract> getByExternalId(String externalFamilyAccountId, 
	        long externalApplicationId, String externalIndividualId)
	        throws DataAccessException;
	
    List<Contract> search(String contractId, String contractLabel,
            String externalIndividualId, String efaId, long externalApplicationId) 
        throws DataAccessException;

    void deleteContract(Contract contract) throws DataAccessException;
	
	void deleteContracts(List<Contract> contractList) throws DataAccessException;

	void deleteAllContracts() throws DataAccessException;
}
