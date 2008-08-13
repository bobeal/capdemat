package fr.capwebct.modules.payment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.dao.IAccountDAO;
import fr.capwebct.modules.payment.dao.IObjectDAO;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IAccountService;

public class AccountService implements IAccountService {

    private IObjectDAO objectDAO;
    private IAccountDAO accountDAO;
    
    private static Log log = LogFactory.getLog(AccountService.class);

    public AccountService() {
        super();
    }

    public void saveAccount(Account account) 
        throws DataAccessException, CpmBusinessException {

        ExternalFamilyAccount externalFamilyAccount = account.getExternalFamilyAccount();
        if (externalFamilyAccount == null)
            throw new CpmBusinessException("account.external_family_account_required");
        externalFamilyAccount.addAccount(account);
        
        objectDAO.update(externalFamilyAccount);
    }
    
    public void saveAccounts(List<Account> accountList) 
        throws DataAccessException, CpmBusinessException {
        
        for (Account account : accountList) {
            saveAccount(account);
        }
    }

    public void importAccounts(List<Account> accountList, long externalApplicationId) 
        throws DataAccessException, CpmBusinessException {

        if (externalApplicationId == 0) {
            log.warn("importAccounts() no external application label provided !");
            return;
        }

        // delete existing accounts for given external application
        List<Account> oldAccounts = getByExternalId(null, externalApplicationId);
        if (oldAccounts != null) {
            deleteAccounts(oldAccounts);
        }

        saveAccounts(accountList);
    }

    public Account getAccount(long id, boolean loadCollection) throws DataAccessException {
        Account account = accountDAO.read(id);
        if (loadCollection)
            accountDAO.initializeProxy(account.getAccountDetailList());
        return account;
    }

    public Account getAccountDetails(long id) throws DataAccessException {
        return getAccount(id, true);
    }

    public List<Account> getAllAccounts() throws DataAccessException {
        return accountDAO.findAll();
    }

    public List<Account> search(String accountId, String accountLabel, Date accountDateStart,
                Date accountDateEnd, String efaId, long externalApplicationId) 
            throws DataAccessException {
        return accountDAO.search(accountId, accountLabel, accountDateStart, accountDateEnd,
                efaId, externalApplicationId);
    }

    public List<Account> getByExternalId(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException {
        return accountDAO.findByExternalId(externalFamilyAccountId, externalApplicationId);
    }

    public Account getByExternalAndAccountId(String externalFamilyAccountId,
            long externalApplicationId, String accountId) throws DataAccessException {

        Account account = accountDAO.findByExternalAndAccountId(externalFamilyAccountId,
                externalApplicationId, accountId);
        if (account != null)
            accountDAO.initializeProxy(account.getAccountDetailList());
        return account;
    }

    public List<AccountDetail> getAccountDetails(String externalFamilyAccountId, 
            long externalApplicationId, String accountId, Date detailStartDate, Date detailEndDate) 
            throws DataAccessException {
        
        Account account = getByExternalAndAccountId(externalFamilyAccountId,
                externalApplicationId, accountId);
        if (account == null)
            return null;
        if (account.getAccountDetailList() != null) {
            List<AccountDetail> results = new ArrayList<AccountDetail>();
            for (AccountDetail accountDetail : account.getAccountDetailList()) {
                if ((detailStartDate != null 
                        && accountDetail.getPayment().getPaymentDate().before(detailStartDate))
                        || (detailEndDate != null 
                                && accountDetail.getPayment().getPaymentDate().after(detailEndDate)))
                    continue;
                results.add(accountDetail);
            }
            return results;
        } else {
            return null;
        }
    }

    public void deleteAccountDetails(Account account) throws DataAccessException {
        List<AccountDetail> accountDetails = account.getAccountDetailList();
        if (accountDetails != null) {
            account.setAccountDetailList(null);
            for (AccountDetail accountDetail : accountDetails) {
                objectDAO.delete(accountDetail);
            }
        }
    }
    
    public void deleteAccount(Account account) throws DataAccessException {
        account.getExternalFamilyAccount().removeAccount(account);
        accountDAO.delete(account);
    }

    public void deleteAccounts(List<Account> accountList) throws DataAccessException {
        for (Account account : accountList)
            deleteAccount(account);
    }

    public void deleteAllAccounts() throws DataAccessException {
        deleteAccounts(getAllAccounts());
    }

    public void setObjectDAO(IObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    public void setAccountDAO(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
