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
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("10"));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("11"));
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
                familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("10"));
            externalFamilyAccount =
                familyAccountService.addExternalIndividual(externalFamilyAccount, individual);
            externalFamilyAccount =
                familyAccountService.addExternalIndividual(externalFamilyAccount, individual2);
            assertEquals(2, externalFamilyAccount.getIndividuals().size());

            externalFamilyAccount =
                familyAccountService.removeExternalIndividual(externalFamilyAccount, individual2);
            assertEquals(1, externalFamilyAccount.getIndividuals().size());
        } catch (DataAccessException e) {
            assertNull(e);
        } finally {
            // Delete localy testing data
            deleteData(true, false, false);
        }
    }

    public void testSaveAndLoadFamilyAccountBinding2() {
        CapwebctFamilyAccount capwebctFamilyAccount =
            familyAccountService.createCapwebctFamilyAccount(
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(15));
        familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("10"));
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

    public void testGetByCapwebctFamilyAccountId() {
        try {
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(16));
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(11));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("10"));
            familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 16);
            familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 16);
            familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11);
            familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11);
            familyAccountService.bindFamilyAccounts("10", externalApplication.getId(), 11);

            List<ExternalFamilyAccount> fetchList = familyAccountService.getByCapWebctFamilyAccountId(16);
            assertEquals(0, fetchList.size());

            fetchList = familyAccountService.getByCapWebctFamilyAccountId(11);
            assertEquals(1, fetchList.size());

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
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("family"));
        CapwebctFamilyAccount capwebctFamilyAccount =
            familyAccountService.createCapwebctFamilyAccount(
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(10));
        try {
            familyAccountService.addExternalIndividual(externalFamilyAccount,
                    BusinessObjectsFactory.gimmeExternalIndividual("family_in", "family_in"));
            familyAccountService.addCapwebctIndividual(capwebctFamilyAccount,
                    BusinessObjectsFactory.gimmeCapwebctIndividual("capwect_ind",1));
            familyAccountService.bindFamilyAccounts(externalFamilyAccount.getExternalFamilyAccountId(), externalApplication.getId(), capwebctFamilyAccount.getCapwebctFamilyAccountId());

            ExternalIndividual externalIndividual =
                externalFamilyAccount.getIndividuals().toArray(new ExternalIndividual[]{})[0];
            CapwebctIndividual capwebctIndividual =
                capwebctFamilyAccount.getIndividuals().toArray(new CapwebctIndividual[]{})[0];

            // Bind
            familyAccountService.bindIndividuals(
                externalFamilyAccount, externalIndividual.getExternalIndividualId(),
                capwebctFamilyAccount, capwebctIndividual.getCapwebctIndividualId());
            assertEquals(capwebctIndividual, externalIndividual.getCapwebctIndividual());

            // Unbind
            familyAccountService.unbindFamilyAccount(externalFamilyAccount.getExternalFamilyAccountId(), externalApplication.getId());
            assertEquals(null, externalFamilyAccount.getCapwebctFamilyAccount());

        } catch (DataAccessException e) {
            assertNull(e);
        } finally {
            // Delete localy testing data
            deleteData(true, true, false);
        }
    }

    public void testSearchFamilyAccountBinding() {
        try {
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(13));
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(15));
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(17));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("77"));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("88"));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("99"));
            familyAccountService.bindFamilyAccounts("99",
                externalApplication.getId(), 17);
            familyAccountService.bindFamilyAccounts("88",
                externalApplication.getId(), 13);
            familyAccountService.bindFamilyAccounts("77",
                externalApplication.getId(), 15);

            List<ExternalFamilyAccount> fetchList = familyAccountService.getAllExternalFamilyAccounts();
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
                familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(55));
            assertEquals(55, capwebctFamilyAccount.getCapwebctFamilyAccountId());

            capwebctFamilyAccount.setCapwebctFamilyAccountId(66);

            familyAccountService.modifyCapwebctFamilyAccount(capwebctFamilyAccount);

            CapwebctFamilyAccount capwebctFamilyAccount2 =
                familyAccountService.getCfaById(capwebctFamilyAccount.getId());
            assertEquals(capwebctFamilyAccount.getId(), capwebctFamilyAccount2.getId());
            assertEquals(capwebctFamilyAccount.getCapwebctFamilyAccountId(),
                    capwebctFamilyAccount2.getCapwebctFamilyAccountId());
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
                familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(10));

            capwebctFamilyAccount =
                familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, individual);
            capwebctFamilyAccount =
                familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, individual2);
            assertEquals(2, capwebctFamilyAccount.getIndividuals().size());

            capwebctFamilyAccount =
                familyAccountService.removeCapwebctIndividual(capwebctFamilyAccount, individual2);
            assertEquals(1, capwebctFamilyAccount.getIndividuals().size());
        } catch (DataAccessException e) {
            assertNull(e);
        } finally {
            // Delete localy testing data
            deleteData(false, true, false);
        }
    }

    public void testSearchCapwebctFamilyAccount() {
        try {
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(13));
            familyAccountService.createCapwebctFamilyAccount(
                BusinessObjectsFactory.gimmeCapwebctFamilyAccount(17));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("88"));
            familyAccountService.createExternalFamilyAccount(
                BusinessObjectsFactory.gimmeExternalFamilyAccount("99"));
            familyAccountService.bindFamilyAccounts("99",
                externalApplication.getId(), 17);
            familyAccountService.bindFamilyAccounts("88",
                externalApplication.getId(), 13);

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
