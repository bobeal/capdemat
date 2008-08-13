package fr.capwebct.modules.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class AccountServiceTest extends ServiceTestCase {

	public void testSaveAndLoadAccountList() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.saveAccounts(accountList);

            Account account = accountService.getAccountDetails(accountList.get(1).getId());
			assertEquals(account, accountList.get(1));
            assertNotNull(account.getAccountDetailList());
			assertEquals(10, account.getAccountDetailList().size());
			assertEquals("account", account.getAccountLabel());
            ExternalFamilyAccount efa = account.getExternalFamilyAccount();
            assertNotNull(efa);
			assertEquals("FAMILY_1", efa.getExternalFamilyAccountId());

			List fetchList = accountService.getAllAccounts();
			assertEquals(fetchList.size(), 10);
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			accountService.deleteAccounts(accountList);
		}
	}

	public void testSearchAccount() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.saveAccounts(accountList);
			List fetchList = accountService.search(null, "account", null, null, null, 0);
			assertEquals(10, fetchList.size());
			fetchList = accountService.search("account_3", null, null, null, null, 0);
			assertEquals(1, fetchList.size());
			fetchList = accountService.search(null, "acc", null, new Date(), null, 0);
			assertEquals(10, fetchList.size(), 10);
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			accountService.deleteAccounts(accountList);
		}
	}

	public void testFindByExternalId() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.saveAccounts(accountList);
			List<Account> fetchList = 
                accountService.getByExternalId("FAMILY_1", externalApplication.getId());
			assertEquals(10, fetchList.size());
			fetchList = accountService.getByExternalId("FAMILY_1", -1);
			assertEquals(0, fetchList.size());
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			accountService.deleteAccounts(accountList);
		}
	}
	
	public void testFindByExternalAndAccountId() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.saveAccounts(accountList);
			Account account = 
                accountService.getByExternalAndAccountId("FAMILY_1", 
                        externalApplication.getId(), "account_1");
			assertEquals(account, accountService.getAccount(accountList.get(1).getId(), false));
			account = accountService.getByExternalAndAccountId("", -1, "");
			assertEquals(account, null);
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			accountService.deleteAccounts(accountList);
		}
	}

	public void testImportAccounts() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.importAccounts(accountList, externalApplication.getId());

			List<Account> importedAccounts = accountService.getAllAccounts();
			assertEquals(importedAccounts.size(), 10);
			for (Account account : importedAccounts) {
			    assertNotNull(account.getExternalFamilyAccount());
            }
            
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			accountService.deleteAccounts(accountList);
		}
	}

	public void testDeleteAccount() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
		try {
			accountService.saveAccounts(accountList);

            List fetchList = accountService.getAllAccounts();
            assertEquals(10, fetchList.size());

            accountService.deleteAccounts(accountList);
            fetchList = accountService.getAllAccounts();
			assertEquals(0, fetchList.size());

		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		}
	}
}
