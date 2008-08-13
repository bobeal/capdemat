package fr.capwebct.modules.payment.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;

public interface ICapwebctFamilyAccountDAO extends IGenericDAO<CapwebctFamilyAccount, Long> {

	List<CapwebctFamilyAccount> search(long capwebctFamilyAccountId,
	        String capwebctIndividualLastName, final int results, final int startIndex,
	        final String sort, final String dir) throws DataAccessException;
    
    Long countForSearch(long capwebctFamilyAccountId,
            String capwebctIndividualLastName) throws DataAccessException;
    
    List<CapwebctFamilyAccount> getForStateAndExternalApplication(final String state,
            final long externalApplicationId, String cfaResponsible, final int results,
            final int startIndex, final String sort, final String dir) throws DataAccessException;

    Long getCountForStateAndExternalApplication(final String state,
            final long externalApplicationId, String cfaResponsible) throws DataAccessException;
    
    CapwebctFamilyAccount getByCfaId(final long cfaId) throws DataAccessException;
}
