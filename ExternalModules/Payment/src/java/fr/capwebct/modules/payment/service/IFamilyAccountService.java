package fr.capwebct.modules.payment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccountSearchResult;
import fr.capwebct.modules.payment.business.ExternalIndividual;

/**
 * Service dedicated to the management of family accounts.
 * 
 * It managed CapWebCT as well as external family accounts. It is also in charge of
 * managing the relationships between the two.
 */
public interface IFamilyAccountService {

    /* *************************** Management of external family accounts ************************/

    ExternalFamilyAccount createExternalFamilyAccount(ExternalFamilyAccount externalFamilyAccount)
        throws DataAccessException;

	ExternalFamilyAccount addExternalIndividual(ExternalFamilyAccount externalFamilyAccount,
			ExternalIndividual individual) throws DataAccessException;

	ExternalFamilyAccount removeExternalIndividual(ExternalFamilyAccount externalFamilyAccount,
			ExternalIndividual individual) throws DataAccessException;
	
    ExternalFamilyAccount getExternalFamilyAccount(long id) throws DataAccessException;

    ExternalFamilyAccount getExternalFamilyAccount(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException;
    
    List<ExternalFamilyAccount> getAllExternalFamilyAccounts() throws DataAccessException;

    List<ExternalFamilyAccount> getByCapWebctFamilyAccountId(long capwebctFamilyAccountId)
            throws DataAccessException;

    List<ExternalFamilyAccount> getByExternalApplication(long externalApplicationId)
            throws DataAccessException;
    
    List<ExternalFamilyAccountSearchResult> searchExternalFamilyAccount(String externalFamilyAccountId,
            String externalResponsibleLastName, long externalApplicationId,
            long capwebctFamilyAccountId, String capwebctIndividualLastName, 
            int results, int startIndex, String sort, String dir) 
        throws DataAccessException;

    Long getCountForSearchExternalFamilyAccount(String externalFamilyAccountId,
            String externalResponsibleLastName, long externalApplicationId,
            long capwebctFamilyAccountId, String capwebctIndividualLastName)
        throws DataAccessException;

    List<ExternalFamilyAccount> searchForAutocomplete(final String externalResponsibleLastName,
            long externalApplicationId)
        throws DataAccessException;
    
    /**
     * Get all external accounts from the given external application that are currently
     * associated to a CapWebCT family account.
     */
    List<ExternalFamilyAccount> getAssociatedAccounts(final long externalApplicationId, 
            String cfaResponsible, final int results, final int startIndex, 
            final String sort, final String dir)
        throws DataAccessException;

    /**
     * Get the count of all external family accounts from the given external application that are currently
     * associated to a CapWebCT family account.
     */
    Long getCountForAssociatedAccounts(final long externalApplicationId, String cfaResponsible)
        throws DataAccessException;

    void deleteExternalFamilyAccount(ExternalFamilyAccount externalFamilyAccount)
            throws DataAccessException;

    /* ***** Management of associations between external family accounts and CapWebCT accounts ***/

	/**
	 * Bind an external family account and a CapWebCT family account.
     * 
     *  External family account is created, updated or left unchanged according to its
     *  current state.
     *  
     *  @return the newly binded EFA or null if none was found.
     */
    ExternalFamilyAccount bindFamilyAccounts(String externalFamilyAccountId,
			long externalApplicationId, long capwebctFamilyAccountId)
			throws DataAccessException;

    /**
     * Bind external individual from external family account to CapWebCT individual
     * from CapWebCT family account.
     */
    void bindIndividuals(ExternalFamilyAccount efa, String externalIndividualId,
            CapwebctFamilyAccount cfa, long cfaId)
        throws DataAccessException;
    
    /**
     * Unbind an external family account from any CapWebCT family account.
     */
    void unbindFamilyAccount(String externalFamilyAccountId, 
            long externalApplicationId) throws DataAccessException;
    
    /**
     * Hide the given CapWebCT family account when searching for not associated accounts
     * for the given external application.
     */
    void hideFamilyAccount(long cfaId, long externalApplicationId) throws DataAccessException;
    
	/* ************* Management of CapWebCT family accounts **************************************/
    
    /**
     * Import a list of CapWebCT family accounts.
     * 
     * Non-existing accounts are created. Existing accounts are not modified but new individuals 
     * inside them are created.
     *  
     * @return a tab of long : the first being the number of created accounts, the second the 
     *                number of modified accounts.
     */
    long[] importCapwebctFamilyAccounts(List<CapwebctFamilyAccount> capWebctFamilyAccounts);

    /**
     * Called upon the creation of an external application : initialize the associations
     * summary with this external application for all known CapWebCT family accounts.
     */
    void initializeCfaAssociations(long externalApplicationId)
        throws DataAccessException;
    
    /**
     * Called upon the creation of an external application : remove the associations
     * summary with this external application for all known CapWebCT family accounts.
     * 
     * @todo not implemented
     */
    void removeCfaAssociations(long externalApplicationId)
        throws DataAccessException;
    
    /**
     * Create a CapWebCT family account with all associated individuals.
     * 
     * @return the newly created {@link CapwebctFamilyAccount}
     */
    CapwebctFamilyAccount createCapwebctFamilyAccount(CapwebctFamilyAccount cfa)
        throws DataAccessException;
    
    CapwebctFamilyAccount modifyCapwebctFamilyAccount(
			CapwebctFamilyAccount capwebctFamilyAccount) throws DataAccessException;

	CapwebctFamilyAccount addCapwebctIndividual(CapwebctFamilyAccount capwebctFamilyAccount,
			CapwebctIndividual individual) throws DataAccessException;
    
	CapwebctFamilyAccount removeCapwebctIndividual(CapwebctFamilyAccount capwebctFamilyAccount,
			CapwebctIndividual individual) throws DataAccessException;

	CapwebctFamilyAccount getCfaById(long id) throws DataAccessException;
	
    CapwebctFamilyAccount getCfaByCapwebctId(long capwebctFamilyAccountId)
        throws DataAccessException;
    
    /**
     * Get all CapWebCT family accounts that have no associated EFA for the given
     * external application.
     * 
     * @param state the state of the CapWebCT family account, either "not_associated"
     * or "no_meaning"
     */
    List<CapwebctFamilyAccount> getForStateAndExternalApplication(final String state, 
            final long externalApplicationId, String cfaResponsible, final int results,
            final int startIndex, final String sort, final String dir)
        throws DataAccessException;

    /**
     * Get the count of all CapWebCT family accounts that have no associated EFA for the given
     * external application.
     * 
     * @param state the state of the CapWebCT family account, either "not_associated"
     * or "no_meaning"
     */
    Long getCountForStateAndExternalApplication(final String state, 
            final long externalApplicationId, String cfaResponsible)
        throws DataAccessException;

   List<CapwebctFamilyAccount> getAllCapwebctFamilyAccounts() throws DataAccessException;
    
    List<CapwebctFamilyAccount> searchCapwebctFamilyAccount(long capwebctFamilyAccountId,
            String capwebctIndividualLastName, int results, int startIndex, String sort, String dir) 
            throws DataAccessException;

    Long getCountForSearchCapwebctFamilyAccount(long capwebctFamilyAccountId,
            String capwebctIndividualLastName)
            throws DataAccessException;
	
   void deleteCapwebctFamilyAccount(CapwebctFamilyAccount capwebctFamilyAccount)
        throws DataAccessException;
}
