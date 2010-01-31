package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
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
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class FakeExternalServiceTest extends ServiceTestCase {

    private IExternalService externalService;
    private IExternalProviderService fakeExternalService;

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        externalService = (IExternalService) getBean("externalService");
        fakeExternalService = (IExternalProviderService) getBean("fakeExternalService");
    }
    
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
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Long homeFolderId = homeFolder.getId();

        // register the mock external provider service with the LACB
        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        esb.setSupportAccountsByHomeFolder(true);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);

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
        Assert.assertNotNull(etciToPayOn.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY));

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
                Assert.assertEquals(2, edai.getAccountDetails().size());
                boolean foundCheque = false;
                for (ExternalDepositAccountItemDetail edaiDetail : edai.getAccountDetails()) {
                    Assert.assertEquals("ORIHUELA", edaiDetail.getHolderSurname());
                    Assert.assertEquals("Benoit", edaiDetail.getHolderName());
                    if (edaiDetail.getPaymentType().equals("Chèque")) {
                        foundCheque = true;
                        Assert.assertEquals(20345, edaiDetail.getValue().intValue());
                        Assert.assertEquals("0101566442", edaiDetail.getPaymentId());
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
                Assert.assertEquals(Boolean.FALSE, eii.isPaid());
                externalService.loadInvoiceDetails(eii);
                Assert.assertEquals(2, eii.getInvoiceDetails().size());
                boolean foundPedro = false;
                for (ExternalInvoiceItemDetail eiiDetail : eii.getInvoiceDetails()) {
                    Assert.assertEquals("ORIHUELA", eiiDetail.getSubjectSurname());
                    if (eiiDetail.getSubjectName().equals("Pedro")) {
                        foundPedro = true;
                        Assert.assertEquals("Repas restauration scolaire", eiiDetail.getLabel());
                        Assert.assertEquals(2300, eiiDetail.getUnitPrice().intValue());
                        Assert.assertEquals(2.5, eiiDetail.getQuantity().doubleValue());
                        Assert.assertEquals(4600, eiiDetail.getValue().intValue());
                    }
                }
                if (!foundPedro)
                    fail("did not find Lolita !");
            }
        }
    }
}
