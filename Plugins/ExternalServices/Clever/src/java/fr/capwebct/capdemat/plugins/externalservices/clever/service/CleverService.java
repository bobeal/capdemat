package fr.capwebct.capdemat.plugins.externalservices.clever.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import cleversms.services.CleverSMSServiceProvider;
import cleversms.services.soap.CleverSMSContactSEI;
import cleversms.services.soap.Contact;
import cleversms.services.soap.ContactNotFoundException;
import cleversms.services.soap.ExtendValue;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.impl.ExternalProviderServiceAdapter;
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;
import fr.cg95.cvq.xml.request.leisure.SmsNotificationRequestDocument;

public class CleverService extends ExternalProviderServiceAdapter {
    private static Logger logger = Logger.getLogger(CleverService.class);
    
    private static final String YES_LABEL = "oui";
    private static final String NO_LABEL = "non";
    private String label;

    private CleverSMSServiceProvider provider;
    private ILocalReferentialService localReferentialService;
    private IRequestService smsNotificationRequestService;
    private IUserSearchService userSearchService;

    private String endportpath;
    private String username;
    private String password;

    public String sendRequest(XmlObject requestXml) throws CvqException {
        try {

            if (!(requestXml instanceof SmsNotificationRequestDocument)) {
                logger.warn("sendRequest() received an un-managed request type, ignoring it");
                return null;
            }
            
            // CleverSMS Service Provider
            provider = new CleverSMSServiceProvider(endportpath, username, password);
            CleverSMSContactSEI contactService = provider.getContactService();

            SmsNotificationRequestDocument snr = (SmsNotificationRequestDocument) requestXml;
            Adult adult = userSearchService.getAdultById(snr.getSmsNotificationRequest().getSubject().getIndividual().getId());

            Integer cleverSmsContactId = null;
            if (snr.getSmsNotificationRequest().getCleverSmsContactId() != null && snr.getSmsNotificationRequest().getCleverSmsContactId().length() > 0)
                cleverSmsContactId = new Integer(snr.getSmsNotificationRequest().getCleverSmsContactId());

            // Build a CleverSMS Contact from the SmsNotificationRequest's
            // subject
            Contact cleverSmsContact = new Contact();
            cleverSmsContact.setName(adult.getLastName());
            cleverSmsContact.setFirstname(adult.getFirstName());
            cleverSmsContact.setGsm(adult.getMobilePhone());
            // Subscriber's interests
            List<LocalReferentialDataType> interests = Arrays.asList(snr.getSmsNotificationRequest().getInterestsArray());
            List<ExtendValue> values = new ArrayList<ExtendValue>();
            for (LocalReferentialDataType interest : interests) {
                ExtendValue value = new ExtendValue();
                value.setKey(interest.getName());
                value.setValue(YES_LABEL);
                values.add(value);
            }
            // Not Subscribers's interests
            LocalReferentialType lrt = localReferentialService.getLocalReferentialType(
                smsNotificationRequestService.getLabel(), "Interests");
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
            else if (snr.getSmsNotificationRequest().getSubscription()) {
                cleverSmsContact.setId(cleverSmsContactId);
                try {
                    logger.debug("sendRequest() calling CleverSMSContactSEI.updateContact("
                            + cleverSmsContactId + ")");
                    contactService.updateContact(cleverSmsContact);
                    return snr.getSmsNotificationRequest().getCleverSmsContactId();
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

    public void checkConfiguration(ExternalServiceBean externalServiceBean, String localAuthorityName)
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

    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        logger.info("getConsumptionsByRequest() no action associated");
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

    public void setSmsNotificationRequestService(IRequestService smsNotificationRequestService) {
        this.smsNotificationRequestService = smsNotificationRequestService;
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    public boolean supportsConsumptions() {
        return false;
    }

    public boolean handlesTraces() {
        return false;
    }

    public List<String> checkExternalReferential(final XmlObject requestXml) {
        return new ArrayList<String>(0);
    }

    public Map<String, Object> loadExternalInformations(XmlObject requestXml)
        throws CvqException {
        return Collections.emptyMap();
    }
}
