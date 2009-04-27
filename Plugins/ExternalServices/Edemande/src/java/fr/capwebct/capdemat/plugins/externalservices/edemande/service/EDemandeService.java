package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;

public class EDemandeService implements IExternalProviderService {

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean)
            throws CvqConfigurationException {
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
            throws CvqException {
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    @Override
    public Map<Date, String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo)
            throws CvqException {
        return null;
    }

    @Override
    public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public String helloWorld() throws CvqException {
        return null;
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
    }

    @Override
    public String sendRequest(Request request) throws CvqException {
        return null;
    }

}
