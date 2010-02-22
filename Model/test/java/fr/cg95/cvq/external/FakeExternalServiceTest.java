package fr.cg95.cvq.external;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.IPaymentService;

public class FakeExternalServiceTest extends ExternalServiceTestCase {

    @Test
    public void testContracts() throws CvqException {

        // create a vo card request (to create home folder and associates)
        // ////////////////////////////////////////////////////////////////

        SecurityContext.setCurrentSite(localAuthorityName, 
                SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        String proposedLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = homeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();

        registerFakeExternalService();

        // retrieve all external accounts directly from fake external service
        Map<String, List<ExternalAccountItem>> completeAccount = 
            fakeExternalService.getAccountsByHomeFolder(homeFolderId, null, null);
        if (completeAccount == null) {
            logger.debug("testContracts() no contract found for home folder : " + homeFolderId);
            return;
        }
        assertEquals(2, completeAccount.get(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS).size());
        assertEquals(4, completeAccount.get(IPaymentService.EXTERNAL_INVOICES).size());
        assertEquals(3, completeAccount.get(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS).size());
        
        // retrieve external ticketing accounts from home folder service
        List<ExternalAccountItem> externalAccounts = 
            completeAccount.get(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS);
        ExternalTicketingContractItem etciToPayOn = 
            (ExternalTicketingContractItem) externalAccounts.get(0);
        assertNotNull(etciToPayOn.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY));

        // make a payment on choosen ticketing contract
        Collection<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
        etciToPayOn.setQuantity(Integer.valueOf(5));
        etciToPayOn.setAmount(etciToPayOn.getQuantity() * etciToPayOn.getUnitPrice());
        purchaseItems.add(etciToPayOn);
        fakeExternalService.creditHomeFolderAccounts(purchaseItems, "cvqReference", 
                "bankReference", homeFolderId, null, null, new Date());

        // retrieve external deposit accounts from home folder service
        externalAccounts = 
            completeAccount.get(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS);
        for (ExternalAccountItem externalAccountItem : externalAccounts) {
            ExternalDepositAccountItem edai =
                (ExternalDepositAccountItem) externalAccountItem;
            logger.debug(edai.getFriendlyLabel());
            logger.debug(edai.getInformativeFriendlyLabel());
            logger.debug(edai.getExternalItemId());
            if (edai.getExternalItemId().equals("95999-3-1910782193")) {
                externalService.loadDepositAccountDetails(edai);
                assertEquals(2, edai.getAccountDetails().size());
                boolean foundCheque = false;
                for (ExternalDepositAccountItemDetail edaiDetail : edai.getAccountDetails()) {
                    assertEquals("ORIHUELA", edaiDetail.getHolderSurname());
                    assertEquals("Benoit", edaiDetail.getHolderName());
                    if (edaiDetail.getPaymentType().equals("Chèque")) {
                        foundCheque = true;
                        assertEquals(20345, edaiDetail.getValue().intValue());
                        assertEquals("0101566442", edaiDetail.getPaymentId());
                    }
                }
                if (!foundCheque)
                    fail("did not find cheque payment !");
            }
        }

        // retrieve external invoices from home folder service
        externalAccounts = 
            completeAccount.get(IPaymentService.EXTERNAL_INVOICES);
        for (ExternalAccountItem externalAccountItem : externalAccounts) {
            ExternalInvoiceItem eii =
                (ExternalInvoiceItem) externalAccountItem;
            if (eii.getExternalItemId().equals("95999-3-1910782195")) {
                assertEquals(Boolean.FALSE, eii.isPaid());
                externalService.loadInvoiceDetails(eii);
                assertEquals(2, eii.getInvoiceDetails().size());
                boolean foundPedro = false;
                for (ExternalInvoiceItemDetail eiiDetail : eii.getInvoiceDetails()) {
                    assertEquals("ORIHUELA", eiiDetail.getSubjectSurname());
                    if (eiiDetail.getSubjectName().equals("Pedro")) {
                        foundPedro = true;
                        assertEquals("Repas restauration scolaire", eiiDetail.getLabel());
                        assertEquals(2300, eiiDetail.getUnitPrice().intValue());
                        assertEquals(BigDecimal.valueOf(2.5), eiiDetail.getQuantity());
                        assertEquals(4600, eiiDetail.getValue().intValue());
                    }
                }
                if (!foundPedro)
                    fail("did not find Lolita !");
            }
        }
        
        unregisterFakeExternalService();
    }
}
