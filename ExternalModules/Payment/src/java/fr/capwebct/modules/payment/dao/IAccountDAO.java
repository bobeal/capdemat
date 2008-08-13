package fr.capwebct.modules.payment.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

	List<Account> search(String accountId, String accountLabel, Date accountDateStart,
			Date accountDateEnd, String efaId, long externalApplicationId)
            throws DataAccessException;

	List<Account> findByExternalId(String externalFamilyAccountId,
			long externalApplicationId) throws DataAccessException;
    
	Account findByExternalAndAccountId(String externalFamilyAccountId,
	        long externalApplicationId, String accountId) throws DataAccessException;
}