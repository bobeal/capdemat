package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqRemoteException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class FakeExternalServiceTest extends ServiceTestCase {

    public void testContracts() {
        try {

            // create a vo card request (to create home folder and associates)
            // ////////////////////////////////////////////////////////////////

            SecurityContext.setCurrentSite(localAuthorityName, 
                    SecurityContext.FRONT_OFFICE_CONTEXT);

            // create a vo card request (to create home folder and associates)
            CreationBean cb = gimmeAnHomeFolder();

            Long requestId = cb.getRequestId();
            String proposedLogin = cb.getLogin();

            SecurityContext.setCurrentEcitizen(proposedLogin);

            // get the home folder id
            HomeFolder homeFolder = iHomeFolderService.getByRequestId(requestId);
            Long homeFolderId = homeFolder.getId();

            // retrieve all external accounts directly from fake external service
            Map completeAccount = iFakeExternalService.getAccountsByHomeFolder(homeFolderId);
            if (completeAccount == null) {
                logger.debug("testContracts() no contract found for home folder : " + homeFolderId);
                return;
            }
            List ticketingAccounts = (List) completeAccount.get(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS);
            Assert.assertEquals(16, ticketingAccounts.size());
            
            for (Iterator i = ticketingAccounts.iterator(); i.hasNext();) {
                ExternalTicketingContractItem etci =
                    (ExternalTicketingContractItem) i.next();
                logger.debug(etci.getFriendlyLabel());
                logger.debug(etci.getInformativeFriendlyLabel());
            }
            
            // retrieve external ticketing accounts from home folder service
            Set<ExternalAccountItem> externalAccounts = 
                iHomeFolderService.getExternalAccounts(homeFolderId, 
                        IPaymentService.EXTERNAL_TICKETING_ACCOUNTS);
            Assert.assertEquals(16, externalAccounts.size());
            ExternalTicketingContractItem etciToPayOn = null;
            for (ExternalAccountItem externalAccountItem : externalAccounts) {
                ExternalTicketingContractItem etci = 
                    (ExternalTicketingContractItem) externalAccountItem;
                if (etciToPayOn == null)
                    etciToPayOn = etci;
                Assert.assertNotNull(etci.getExternalServiceSpecificDataByKey("child-csn"));
                logger.debug(etci.getFriendlyLabel());
                logger.debug(etci.getInformativeFriendlyLabel());
            }
            
            // make a payment on choosen ticketing contract
            Collection<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
            etciToPayOn.setQuantity(Integer.valueOf(5));
            etciToPayOn.setAmount(etciToPayOn.getQuantity() * etciToPayOn.getUnitPrice());
            purchaseItems.add(etciToPayOn);
            iFakeExternalService.creditHomeFolderAccounts(purchaseItems, "cvqReference", 
                    "bankReference", homeFolderId, new Date());
            
            // retrieve external deposit accounts from home folder service
            externalAccounts = 
                iHomeFolderService.getExternalAccounts(homeFolderId,
                        IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS);
            Assert.assertEquals(2, externalAccounts.size());
            for (ExternalAccountItem externalAccountItem : externalAccounts) {
                ExternalDepositAccountItem edai =
                    (ExternalDepositAccountItem) externalAccountItem;
                logger.debug(edai.getFriendlyLabel());
                logger.debug(edai.getInformativeFriendlyLabel());
                logger.debug(edai.getExternalItemId());
                if (edai.getExternalItemId().equals("95999-3-1910782193")) {
                    iHomeFolderService.loadExternalDepositAccountDetails(edai);
                    Assert.assertEquals(2, edai.getAccountDetails().size());
                    boolean foundCheque = false;
                    for (ExternalDepositAccountItemDetail edaiDetail : edai.getAccountDetails()) {
                        Assert.assertEquals("TOULOUSE", edaiDetail.getHolderSurname());
                        Assert.assertEquals("roger", edaiDetail.getHolderName());
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
                iHomeFolderService.getExternalAccounts(homeFolderId,
                        IPaymentService.EXTERNAL_INVOICES);
            Assert.assertEquals(4, externalAccounts.size());
            for (ExternalAccountItem externalAccountItem : externalAccounts) {
                ExternalInvoiceItem eii =
                    (ExternalInvoiceItem) externalAccountItem;
                if (eii.getExternalItemId().equals("95999-3-1910782195")) {
                    Assert.assertEquals(Boolean.TRUE, eii.isPaid());
                    iHomeFolderService.loadExternalInvoiceDetails(eii);
                    Assert.assertEquals(2, eii.getInvoiceDetails().size());
                    boolean foundLolita = false;
                    for (ExternalInvoiceItemDetail eiiDetail : eii.getInvoiceDetails()) {
                        Assert.assertEquals("TOULOUSE", eiiDetail.getSubjectSurname());
                        if (eiiDetail.getSubjectName().equals("Lolita")) {
                            foundLolita = true;
                            Assert.assertEquals("carence", eiiDetail.getLabel());
                            Assert.assertEquals(2300, eiiDetail.getUnitPrice().intValue());
                            Assert.assertEquals(2, eiiDetail.getQuantity().intValue());
                            Assert.assertEquals(4600, eiiDetail.getValue().intValue());
                        }
                    }
                    if (!foundLolita)
                        fail("did not find Lolita !");
                }
            }
            
            // retrieve individuals information on external accounts
            Map<Individual, Map<String, String> > individualsInformation =
                iHomeFolderService.getIndividualExternalAccountsInformation(homeFolderId);
            Assert.assertEquals(individualsInformation.size(), 2);
            Map<String, String> individualInformation = 
                individualsInformation.values().iterator().next();
            Assert.assertEquals(individualInformation.size(), 1);
            String key = individualInformation.keySet().iterator().next();
            Assert.assertEquals(key, "child-csn");
            String value = individualInformation.get(key);
            Assert.assertNotNull(value);
        } catch (CvqRemoteException e) {
        	e.printStackTrace();
            fail("Too bad");
        } catch (CvqException e) {
        	e.printStackTrace();
            fail("Too bad");
        }
    }
}
