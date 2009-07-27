package fr.capwebct.modules.payment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class FamilyAccountServiceTest extends ServiceTestCase {

	public void testCreateFamilyAccountBinding() {
	    try {
	        familyAccountService.createExternalFamilyAccount("10", externalApplication.getId());
			familyAccountService.createExternalFamilyAccount("11", externalApplication.getId());
			List<ExternalFamilyAccount> fetchList = familyAccountService.getAllExternalFamilyAccounts();
			assertEquals(2, fetchList.size());
		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, false, false);
		}
	}

	public void testAddExternalIndividual() {
		ExternalIndividual individual = 
            BusinessObjectsFactory.gimmeExternalIndividual("fikra", "fikra");
		ExternalIndividual individual2 = 
            BusinessObjectsFactory.gimmeExternalIndividual("fikra2", "fikra2");
		try {
			ExternalFamilyAccount externalFamilyAccount = 
                familyAccountService.createExternalFamilyAccount("10", externalApplication.getId());
			externalFamilyAccount = 
                familyAccountService.addExternalIndividual(externalFamilyAccount, individual);
			externalFamilyAccount = 
                familyAccountService.addExternalIndividual(externalFamilyAccount, individual2);
			assertEquals(externalFamilyAccount.getIndividuals().size(), 2);
			
			externalFamilyAccount = 
                familyAccountService.removeExternalIndividual(externalFamilyAccount, individual2);
			assertEquals(externalFamilyAccount.getIndividuals().size(), 1);
		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, false, false);
		}
	}

	public void testSaveAndLoadFamilyAccountBinding2() {
		CapwebctFamilyAccount capwebctFamilyAccount = 
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(15);
		try {
			ExternalFamilyAccount externalFamilyAccount = 
                familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 
                        capwebctFamilyAccount.getCapwebctFamilyAccountId());
			ExternalFamilyAccount externalFamilyAccount2 = 
                familyAccountService.getExternalFamilyAccount(externalFamilyAccount.getId());

			assertEquals(externalFamilyAccount.getExternalFamilyAccountId(), 
                    externalFamilyAccount2.getExternalFamilyAccountId());
			assertEquals(externalFamilyAccount.getCapwebctFamilyAccount(), 
                    externalFamilyAccount2.getCapwebctFamilyAccount());

		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}

	public void testSaveAnLoadFamilyAccountBinding3() {
		try {
			ExternalFamilyAccount externalFamilyAccount = 
                familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 
                        15, "capwebct");
			ExternalFamilyAccount externalFamilyAccount2 = 
                familyAccountService.getExternalFamilyAccount(externalFamilyAccount.getId());

			assertEquals(externalFamilyAccount.getExternalFamilyAccountId(), 
                    externalFamilyAccount2.getExternalFamilyAccountId());
			assertEquals(externalFamilyAccount.getCapwebctFamilyAccount(), 
                    externalFamilyAccount2.getCapwebctFamilyAccount());

		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}

	public void testGetByCapwebctFamilyAccountId() {
		try {
			familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 16, "capwebct");
			familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 16, "capwebct");
			familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11, "capwebct");
			familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11, "capwebct");
			familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11, "capwebct");

			List fetchList = familyAccountService.getByCapWebctFamilyAccountId(16);
			assertEquals(fetchList.size(), 2);

			fetchList = familyAccountService.getByCapWebctFamilyAccountId(11);
			assertEquals(fetchList.size(), 3);

		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}
	
	// TODO Solve NullPointer Exception Error in bindIndividual
	public void testBindIndividuals() {
		ExternalFamilyAccount externalFamilyAccount = 
            BusinessObjectsFactory.gimmeExternalFamilyAccount("family", "family");
		CapwebctFamilyAccount capwebctFamilyAccount = 
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(10);
		try {
			familyAccountService.addExternalIndividual(externalFamilyAccount, 
                    BusinessObjectsFactory.gimmeExternalIndividual("family_in", "family_in"));
			familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, 
                    BusinessObjectsFactory.gimmeCapwebctIndividual("capwect_ind",1));
			familyAccountService.bindFamilyAccounts(externalFamilyAccount,capwebctFamilyAccount);
			
			ExternalIndividual externalIndividual = 
                externalFamilyAccount.getIndividuals().toArray(new ExternalIndividual[]{})[0];
			CapwebctIndividual capwebctIndividual = 
                capwebctFamilyAccount.getIndividuals().toArray(new CapwebctIndividual[]{})[0];
			
			// Bind
			familyAccountService.bindIndividuals(externalIndividual, capwebctIndividual);
			assertEquals(externalIndividual.getCapwebctIndividual(), capwebctIndividual);
			
			// Unbind
			familyAccountService.bindFamilyAccounts(externalFamilyAccount, null);
			assertEquals(externalFamilyAccount.getCapwebctFamilyAccount(), null);
			
		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}

	public void testSearchFamilyAccountBinding() {
		try {
			familyAccountService.bindFamilyAccounts("99", externalApplication.getId(), 17, "FIKRA");
			familyAccountService.bindFamilyAccounts("88", externalApplication.getId(), 13, "BLOP");
			familyAccountService.bindFamilyAccounts("77", externalApplication.getId(), 15, "BOR");

			List fetchList = familyAccountService.getAllExternalFamilyAccounts();
			assertEquals(3, fetchList.size());

            ExternalFamilyAccount efa = 
                familyAccountService.getExternalFamilyAccount("99", externalApplication.getId());
			assertNotNull(efa);

			fetchList = familyAccountService.getByCapWebctFamilyAccountId(17);
			assertEquals(1, fetchList.size());

			fetchList = 
                familyAccountService.getByExternalApplication(externalApplication.getId());
			assertEquals(3, fetchList.size());

		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}

	public void testCreateAndModifyCapwebctFamilyAccount() {
		try {
			CapwebctFamilyAccount capwebctFamilyAccount = 
                familyAccountService.createCapwebctFamilyAccount(55, "55_label", null);
			assertEquals(capwebctFamilyAccount.getCapwebctFamilyAccountId(), 55);

			capwebctFamilyAccount.setCapwebctFamilyAccountId(66);

			familyAccountService.modifyCapwebctFamilyAccount(capwebctFamilyAccount);

			CapwebctFamilyAccount capwebctFamilyAccount2 = 
                familyAccountService.getCfaById(capwebctFamilyAccount.getId());
			assertEquals(capwebctFamilyAccount2.getId(), capwebctFamilyAccount.getId());
			assertEquals(capwebctFamilyAccount2.getCapwebctFamilyAccountId(), 
                    capwebctFamilyAccount.getCapwebctFamilyAccountId());
		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(false, true, false);
		}
	}

	public void testAddCapwebctIndividual() {
		CapwebctIndividual individual = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("fikra", 1);
		CapwebctIndividual individual2 = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("fikra2",2);
		try {
			CapwebctFamilyAccount capwebctFamilyAccount = 
                familyAccountService.createCapwebctFamilyAccount(10, "family", null);

			capwebctFamilyAccount = 
                familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, individual);
			capwebctFamilyAccount = 
                familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, individual2);
			assertEquals(capwebctFamilyAccount.getIndividuals().size(), 3);
			
			capwebctFamilyAccount = 
                familyAccountService.removeCapwebctIndividual(capwebctFamilyAccount, individual2);
			assertEquals(capwebctFamilyAccount.getIndividuals().size(), 2);
			
		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(false, true, false);
		}
	}

	public void testSearchCapwebctFamilyAccount() {
		try {
			familyAccountService.bindFamilyAccounts("99", externalApplication.getId(), 17, "FIKRA");
			familyAccountService.bindFamilyAccounts("88", externalApplication.getId(), 13, "FIKRA");

			List<CapwebctFamilyAccount> fetchList = 
                familyAccountService.getAllCapwebctFamilyAccounts();
			assertEquals(2, fetchList.size());

            CapwebctFamilyAccount cfa = familyAccountService.getCfaByCapwebctId(17);
            assertNotNull(cfa);

		} catch (DataAccessException e) {
			assertNull(e);
		} finally {
			// Delete localy testing data
			deleteData(true, true, false);
		}
	}
}
