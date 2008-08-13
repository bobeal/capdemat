package fr.capwebct.modules.payment.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccountSearchResult;

public interface IExternalFamilyAccountDAO extends IGenericDAO<ExternalFamilyAccount, Long> {

	List<ExternalFamilyAccountSearchResult> search(String externalFamilyAccountId, 
	        String externalResponsibleLastName, long externalApplicationId,
			long capwebctFamilyAccountId, String capwebctIndividualLastName, 
            int results, int startIndex, String sort, String dir) 
		throws DataAccessException;
	
    Long countForSearch(String externalFamilyAccountId, 
            String externalResponsibleLastName, long externalApplicationId,
            long capwebctFamilyAccountId, String capwebctIndividualLastName)
        throws DataAccessException;

    List<ExternalFamilyAccount> searchForAutocomplete(final String externalResponsibleLastName,
            final long externalApplicationId)
        throws DataAccessException;
    
	List<ExternalFamilyAccount> getByCfa(long capwebctFamilyAccountId) 
	    throws DataAccessException;

    List<ExternalFamilyAccount> getByExternalApplication(long externalApplicationId)
        throws DataAccessException;
    
    ExternalFamilyAccount getByExternalFamilyAccount(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException;
    
    ExternalFamilyAccount getByCfaAndExternalApplication(long cfaId, long externalApplicationId)
        throws DataAccessException;
    
    /**
     * Get all external family accounts that are associated to a CapWebCT family account
     * for the given external application.
     */
    List<ExternalFamilyAccount> getAssociatedAccounts(final long externalApplicationId, 
            String cfaResponsible, final int results, final int startIndex, final String sort, final String dir)
        throws DataAccessException;
    
    /**
     * Get the count of all external family accounts that are associated to a CapWebCT 
     * family account for the given external application.
     */
    Long getCountForAssociatedAccounts(final long externalApplicationId, String cfaResponsible)
        throws DataAccessException;
}
