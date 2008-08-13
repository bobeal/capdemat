package fr.capwebct.modules.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.exception.CpmBusinessException;

public interface IAccountService {
    
    /**
     * Save an account. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if an account has no external family account associated
     */
    void saveAccount(Account account) 
        throws DataAccessException, CpmBusinessException;
    
    /**
     * Save a list of accounts. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if an account has no external family account associated
     */
    void saveAccounts(List<Account> accountList) 
        throws DataAccessException, CpmBusinessException;

    /**
     * Import a list of accounts for the given external application. Existing accounts
     * for this external application will first be deleted.
     * 
     * @throws CpmBusinessException if an account has no external family account associated
     */
    void importAccounts(List<Account> accountList, long externalApplicationId) 
        throws DataAccessException, CpmBusinessException;

    Account getAccount(long id, boolean loadCollection) throws DataAccessException;

    Account getAccountDetails(long id) throws DataAccessException;

    List<Account> getAllAccounts() throws DataAccessException;

    List<Account> search(String accountId, String accountLabel, Date accountDateStart,
            Date accountDateEnd, String efaId, long externalApplicationId) 
            throws DataAccessException;

    List<Account> getByExternalId(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException;

    /**
     * Load account with the given references.
     */
    Account getByExternalAndAccountId(String externalFamilyAccountId,
            long externalApplicationId, String accountId) throws DataAccessException;

    List<AccountDetail> getAccountDetails(String externalFamilyAccountId,
            long externalApplicationId, String accountId, Date detailStartDate,
            Date detailEndDate) throws DataAccessException;

    /**
     * Delete detail list for the given account.
     */
    void deleteAccountDetails(Account account) throws DataAccessException;
    
    void deleteAccount(Account account) throws DataAccessException;

    void deleteAccounts(List<Account> accountList) throws DataAccessException;

    void deleteAllAccounts() throws DataAccessException;
}
