package fr.cg95.cvq.service.payment.external;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.util.Critere;

public class ExternalApplicationProviderService implements IExternalProviderService {

    private IPaymentService paymentService;

    @Override
    public String getLabel() {
        return IExternalApplicationService.EXTERNAL_APPLICATION_LABEL;
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        Map<String, List<ExternalAccountItem>> results = new HashMap<String, List<ExternalAccountItem>>();

        Set<Critere> criteres = new HashSet<Critere>();
        criteres.add(new Critere(Payment.SEARCH_BY_HOME_FOLDER_ID, homeFolderId.toString(), Critere.EQUALS));
        criteres.add(new Critere(ExternalAccountItem.SEARCH_BY_EXTERNAL_SERVICE_LABEL, getLabel(), Critere.EQUALS));

        results.put(IPaymentService.EXTERNAL_INVOICES, paymentService.getInvoices(criteres, null, null, 0, 0));
        results.put(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS, paymentService.getDepositAccounts(criteres, null, null, 0, 0));
        results.put(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS, paymentService.getTicketingContracts(criteres, null, null, 0, 0));
        return results;
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        // lazy loading hibernate hack
        for (ExternalInvoiceItemDetail eiid : eii.getInvoiceDetails())
            eiid.toString();
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        // lazy loading hibernate hack
        for (ExternalDepositAccountItemDetail edaid : edai.getAccountDetails())
            edaid.toString();
    }

    @Override
    public boolean handlesTraces() {
        return false;
    }

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean)
            throws CvqConfigurationException {
    }

    @Override
    public List<String> checkExternalReferential(XmlObject requestXml) {
        return Collections.emptyList();
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
            throws CvqException {
        for (PurchaseItem purchaseItem : purchaseItems) {
            if (purchaseItem instanceof ExternalInvoiceItem) {
                ExternalInvoiceItem eii = (ExternalInvoiceItem)purchaseItem;
                eii.setIsPaid(true);
                eii.setPaymentDate(new Date());
            } else if (purchaseItem instanceof ExternalDepositAccountItem) {
                ExternalDepositAccountItem edai = (ExternalDepositAccountItem) purchaseItem;
                edai.setOldValue(edai.getOldValue() + edai.getAmount());
                edai.setOldValueDate(new Date());
            } else if (purchaseItem instanceof ExternalTicketingContractItem) {
                ExternalTicketingContractItem etci = (ExternalTicketingContractItem)purchaseItem;
                etci.setAmount(etci.getAmount() + (etci.getUnitPrice() * etci.getQuantity()));
                etci.setOldQuantity(etci.getOldQuantity() + etci.getQuantity());
            }
        }
    }

    @Override
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public String helloWorld() throws CvqException {
        return null;
    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject requestXml) throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public String sendRequest(XmlObject requestXml) throws CvqException {
        return null;
    }

    @Override
    public boolean supportsConsumptions() {
        return false;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
