package fr.capwebct.modules.payment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class ContractServiceTest extends ServiceTestCase {

	public void testSaveAndLoadContractList() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
		List<Contract> contractList = 
            BusinessObjectsFactory.gimmeTenContracts("contract", externalFamilyAccount);
		try {
			contractService.saveContracts(contractList);
			Contract contract = 
                contractService.getContract(contractList.get(1).getId(), false);
			assertEquals(contract, contractList.get(1));
			assertNotNull(contract.getExternalFamilyAccount());
			assertNotNull(contract.getExternalIndividual());
            
			List<Contract> fetchContractList = contractService.getAllContracts(false);
			assertEquals(fetchContractList.size(), 10);

		} catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
        } finally {
			// Delete local test data
			contractService.deleteContracts(contractList);
		}
	}

	public void testFindByExternalId() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        List<Contract> contractList = 
            BusinessObjectsFactory.gimmeTenContracts("contract", externalFamilyAccount);
		try {
            contractService.saveContracts(contractList);
			List<Contract> fetchList = 
				contractService.getByExternalId("FAMILY_1", externalApplication.getId(), null);
			assertEquals(10, fetchList.size());
			fetchList = contractService.getByExternalId("FAMILY_1", -1, null);
			assertEquals(0, fetchList.size());
		} catch (DataAccessException e) {
		    e.printStackTrace();
            fail();
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete local test data
			contractService.deleteContracts(contractList);
		}
	}
	
	public void testImportContracts() {
        
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        
        List<Contract> contractList = 
            BusinessObjectsFactory.gimmeTenContracts("contract", externalFamilyAccount);
		try {
			contractService.importContracts(contractList, externalApplication.getId(), 
                    externalApplication.getBrokers().iterator().next());
			
			List fetchList = contractService.getAllContracts(false);
			assertEquals(10, fetchList.size());
			
		} catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete local test data
			contractService.deleteContracts(contractList);
		}
	}
	
	public void testDeleteContract() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        List<Contract> contractList = 
            BusinessObjectsFactory.gimmeTenContracts("contract", externalFamilyAccount);
		try {
			contractService.saveContracts(contractList);
			
			contractService.deleteContracts(contractList);
			List fetchList = contractService.getAllContracts(false);
			assertEquals(fetchList.size(), 0);
			
		} catch (DataAccessException e) {
            e.printStackTrace();
            fail();
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		}
	}
}
