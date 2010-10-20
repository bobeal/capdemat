package fr.cg95.cvq.service.payment.external.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentEvent;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.impl.ExternalService;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.payment.external.IPaymentExternalService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;


public class PaymentExternalService extends ExternalService implements IPaymentExternalService , ApplicationListener<PaymentEvent>{

    private static Logger logger = Logger.getLogger(PaymentExternalService.class);

    private IExternalHomeFolderService externalHomeFolderService;

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Set<ExternalAccountItem> getExternalAccounts(Long homeFolderId, String type) 
        throws CvqException {

        // FIXME : this can cause backward compatibility problems
        //         not sure that all existing accounts have a mapping
        List<HomeFolderMapping> mappings = 
            externalHomeFolderService.getHomeFolderMappings(homeFolderId);
        if (mappings == null || mappings.isEmpty())
            return Collections.emptySet();

        Set<ExternalAccountItem> externalAccountItems = new HashSet<ExternalAccountItem>();
        for (HomeFolderMapping mapping : mappings) {
            IExternalProviderService externalProviderService =
                getExternalServiceByLabel(mapping.getExternalServiceLabel());
            if (externalProviderService == null) {
                logger.warn("getExternalAccounts() External service " + mapping.getExternalServiceLabel()
                        + " is no longer existing");
                continue;
            }
            Map<String, List<ExternalAccountItem>> mappingAccounts =
                externalProviderService.getAccountsByHomeFolder(homeFolderId,
                        mapping.getExternalCapDematId(), mapping.getExternalId());
            if (mappingAccounts != null && mappingAccounts.get(type) != null) {
                externalAccountItems.addAll(mappingAccounts.get(type));
            }
        }
        return externalAccountItems;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        IExternalProviderService externalProviderService =
            getExternalServiceByLabel(edai.getExternalServiceLabel());
        externalProviderService.loadDepositAccountDetails(edai);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        IExternalProviderService externalProviderService =
            getExternalServiceByLabel(eii.getExternalServiceLabel());
        externalProviderService.loadInvoiceDetails(eii);
    }

    @Context(types = {ContextType.SUPER_ADMIN})
    private void creditHomeFolderAccounts(Payment payment)
        throws CvqException {

        Map<String, List<PurchaseItem>> externalServicesToNotify =
            new HashMap<String, List<PurchaseItem>>();
        Set<PurchaseItem> purchaseItems = payment.getPurchaseItems();
        for (PurchaseItem purchaseItem : purchaseItems) {

            // if purchase item is managed by an external service, 
            // stack it for notification of the associated external service
            if (purchaseItem instanceof ExternalAccountItem) {
                logger.debug("creditHomeFolderAccounts() item managed by an external service : "
                        + purchaseItem.getInformativeFriendlyLabel());
                ExternalAccountItem externalAccountItem = (ExternalAccountItem) purchaseItem;
                externalAccountItem.setSupportedBroker(payment.getBroker());
                String externalServiceLabel = externalAccountItem.getExternalServiceLabel();
                if (externalServicesToNotify.get(externalServiceLabel) == null) {
                    externalServicesToNotify.put(externalServiceLabel,
                            new ArrayList<PurchaseItem>());
                }
                externalServicesToNotify.get(externalServiceLabel).add(purchaseItem);
            }
        }

        if (!externalServicesToNotify.isEmpty()) {
            for (String externalServiceLabel : externalServicesToNotify.keySet()) {
                IExternalProviderService service = getExternalServiceByLabel(externalServiceLabel);
                if (service == null) {
                    logger.error("notifyPayments() No external service with label " + 
                            externalServiceLabel + " has been found");
                    continue;
                }
                HomeFolderMapping mapping = 
                    externalHomeFolderService.getHomeFolderMapping(externalServiceLabel, payment.getHomeFolderId());
                service.creditHomeFolderAccounts(externalServicesToNotify.get(externalServiceLabel),
                        payment.getCvqReference(), payment.getBankReference(),
                        payment.getHomeFolderId(), 
                        mapping == null ? null : mapping.getExternalCapDematId(),
                        mapping == null ? null : mapping.getExternalId(), payment.getCommitDate());
            }
        }
    }

    @Override
    public void onApplicationEvent(PaymentEvent paymentEvent) {
        logger.debug("onApplicationEvent() got a payment event of type " + paymentEvent.getEvent());
        if (paymentEvent.getEvent().equals(PaymentEvent.EVENT_TYPE.PAYMENT_VALIDATED))
            try {
                creditHomeFolderAccounts(paymentEvent.getPayment());
            } catch (CvqException e) {
                // FIXME : we have nothing to handle this 
                logger.error("onApplicationEvent() unable to credit home folder account");
                e.printStackTrace();
            }
    }

    public void setExternalHomeFolderService(IExternalHomeFolderService externalHomeFolderService) {
        this.externalHomeFolderService = externalHomeFolderService;
    }

}
