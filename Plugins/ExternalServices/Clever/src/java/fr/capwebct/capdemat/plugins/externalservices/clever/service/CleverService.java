package fr.capwebct.capdemat.plugins.externalservices.clever.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import cleversms.services.CleverSMSServiceProvider;
import cleversms.services.soap.CleverSMSContactSEI;
import cleversms.services.soap.Contact;
import cleversms.services.soap.ContactNotFoundException;
import cleversms.services.soap.ExtendValue;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.authority.ILocalReferentialService;

public class CleverService implements IExternalProviderService {
    private static Logger logger = Logger.getLogger(CleverService.class);
    
    private static final String YES_LABEL = "oui";
    private static final String NO_LABEL = "non";
    private String label;

    private CleverSMSServiceProvider provider;
    private ILocalReferentialService localReferentialService;

    private String endportpath;
    private String username;
    private String password;

    public String sendRequest(Request request) throws CvqException {
        try {

            if (!(request instanceof SmsNotificationRequest)) {
                logger.warn("sendRequest() received an un-managed request type, ignoring it");
                return null;
            }
            
            // CleverSMS Service Provider
            provider = new CleverSMSServiceProvider(endportpath, username, password);
            CleverSMSContactSEI contactService = provider.getContactService();

            SmsNotificationRequest snr = (SmsNotificationRequest) request;
            Adult adult = (Adult) snr.getSubject();

            Integer cleverSmsContactId = null;
            if (snr.getCleverSmsContactId() != null && snr.getCleverSmsContactId().length() > 0)
                cleverSmsContactId = new Integer(snr.getCleverSmsContactId());

            // Build a CleverSMS Contact from the SmsNotificationRequest's
            // subject
            Contact cleverSmsContact = new Contact();
            cleverSmsContact.setName(adult.getLastName());
            cleverSmsContact.setFirstname(adult.getFirstName());
            cleverSmsContact.setGsm(adult.getMobilePhone());
            // Subscriber's interests
            List<LocalReferentialData> interests = snr.getInterests();
            List<ExtendValue> values = new ArrayList<ExtendValue>();
            for (LocalReferentialData interest : interests) {
                ExtendValue value = new ExtendValue();
                value.setKey(interest.getName());
                value.setValue(YES_LABEL);
                values.add(value);
            }
            // Not Subscribers's interests
            LocalReferentialType lrt = localReferentialService.getLocalReferentialDataByName("Interests");
            Set<LocalReferentialEntry> lrtEntries = lrt.getEntries();
            for (LocalReferentialEntry lrtEntry : lrtEntries) {
                String lrtEntryKey = lrtEntry.getKey();
                ExtendValue value = new ExtendValue();
                value.setKey(lrtEntryKey);
                value.setValue(YES_LABEL);
                if (!values.contains(value)) {
                    value.setValue(NO_LABEL);
                    values.add(value);
                }
            }
            cleverSmsContact.setValues(values.toArray(new ExtendValue[values.size()]));
            
            // Create Contact
            if (cleverSmsContactId == null) {
                logger.debug("sendRequest() calling CleverSMSContactSEI.createContact()");
                int id = contactService.createContact(cleverSmsContact);
                return (new Integer(id)).toString();
            }
            // Update Contact
            else if (snr.getSubscription()) {
                cleverSmsContact.setId(cleverSmsContactId);
                try {
                    logger.debug("sendRequest() calling CleverSMSContactSEI.updateContact("
                            + cleverSmsContactId + ")");
                    contactService.updateContact(cleverSmsContact);
                    return snr.getCleverSmsContactId();
                } catch (ContactNotFoundException e) {
                    // Create a new CleverSMS Contact to bind to the
                    // SmsNotificationRequest's subject
                    int id = contactService.createContact(cleverSmsContact);
                    return (new Integer(id)).toString();
                }
            }
            // Remove Contact
            else {
                cleverSmsContact.setId(cleverSmsContactId);
                try {
                    logger.debug("sendRequest() calling CleverSMSContactSEI.removeContact("
                            + cleverSmsContactId + ")");
                    contactService.removeContact(cleverSmsContact);
                    return null;
                } catch (ContactNotFoundException e) {
                    // CleverSMS Contact has been already removed ...
                    return null;
                }
            }
        } catch (RemoteException e) {
            logger.error("sendRequest() SOAP access error : " + e.getMessage());
            throw new CvqException(e.getMessage());
        } catch (ServiceException e) {
            logger.error("sendRequest() service exception : " + e.getMessage());
            throw new CvqException(e.getMessage());
        }
    }

    public void checkConfiguration(ExternalServiceBean externalServiceBean)
            throws CvqConfigurationException {
    }

    public void creditHomeFolderAccounts(Collection purchaseItems, String cvqReference,
            String bankReference, Long homeFolderId, String externalHomeFolderId, String externalId, Date validationDate) throws CvqException {
        logger.info("creditHomeFolderAccounts() no action associated");
    }

    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId, String externalHomeFolderId, String externalId)
            throws CvqException {
        logger.info("getAccountsByHomeFolder() no action associated");
        return null;
    }

    public Map<Date, String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo)
            throws CvqException {
        logger.info("getConsumptionsByRequest() no action associated");
        return null;
    }

    public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId, String externalHomeFolderId, String externalId)
            throws CvqException {
        logger.info("getIndividualAccountsInformation() no action associated");
        return null;
    }

    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        logger.info("loadDepositAccountDetails() no action associated");
    }

    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        logger.info("loadInvoiceDetails() no action associated");
    }

    public String helloWorld() throws CvqException {
        return null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setEndportpath(String endportpath) {
        this.endportpath = endportpath;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocalReferentialService(ILocalReferentialService localReferentialService) {
        this.localReferentialService = localReferentialService;
    }
}
