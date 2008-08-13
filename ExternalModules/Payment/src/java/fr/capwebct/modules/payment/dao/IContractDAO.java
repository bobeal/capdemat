package fr.capwebct.modules.payment.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Contract;

public interface IContractDAO extends IGenericDAO<Contract, Long> {

    Contract findByExternalAndContractId(final String externalFamilyAccountId,
            final long externalApplicationId, final String externalIndividualId,
            final String contractId) 
        throws DataAccessException;

	List<Contract> findByExternalId(final String externalFamilyAccountId,
	            final long externalApplicationId, final String externalIndividualId) 
            throws DataAccessException;
    
    List<Contract> search (final String contractId, final String contractLabel,
                final String externalIndividualId, final String efaId, 
                final long externalApplicationId)
            throws DataAccessException;
}
