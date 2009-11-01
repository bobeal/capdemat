package fr.cg95.cvq.external.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqRemoteException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.users.IHomeFolderService;

/**
 * A fake implementation of the {@link IExternalProviderService external provider service interface}
 * that is meant to be used for demonstration purposes only.
 *
 * TODO : this service has to be migrated to use the XML schemas APIs 
 * instead of custom XML mapping.
 * 
 * @author bor@zenexity.fr
 */
public class FakeExternalService implements IExternalProviderService {

    private static Logger logger = Logger.getLogger(FakeExternalService.class);

    private IRequestServiceRegistry requestServiceRegistry;
    private IHomeFolderService homeFolderService;
    
    private String label;
    private String authorizingRequestLabel;
    private String testDataDirectory;
    private String xmlDirectory;
    private String consumptionsFile;
    private String accountsFile;
    private String depositAccountDetailsFile;
    private String invoiceDetailsFile;

    public final String sendRequest(XmlObject requestXml) throws CvqException {
        logger.debug("sendRequest() sending request data " + requestXml.xmlText());
        return null;
    }

    public final void creditHomeFolderAccounts(final Collection<PurchaseItem> purchaseItems, 
            final String cvqReference, final String bankReference, final Long homeFolderId, 
            String externalHomeFolderId, String externalId, final Date validationDate)
        throws CvqException {

        logger.debug("creditHomeFolderAccounts() Gonna credit home folder " + homeFolderId);
        logger.debug("creditHomeFolderAccounts() for transaction " + cvqReference + " / "
                + bankReference);
        // TODO : port it to the new XML schemas
//        HomeFolder homeFolder = homeFolderService.getById(homeFolderId);
//        try {
//            String xmlPayment = ExternalServiceUtils.paymentToXml(purchaseItems, cvqReference, 
//                    bankReference, homeFolder, validationDate);
//            logger.debug("creditHomeFolderAccounts() got XML payment " + xmlPayment);
//        } catch (IOException ioe) {
//            logger.error("creditHomeFolderAccounts() Error while preparing XML payment"
//                    + ioe.getMessage());
//            throw new CvqException("Error while preparing XML payment");
//        }
    }

    public final Map<Date, String> getConsumptionsByRequest(final Request request, 
            final Date dateFrom, final Date dateTo) throws CvqException {

        logger.debug("getConsumptionsByRequest() request " + request.getId());
        logger.debug("getConsumptionsByRequest() from " + dateFrom);
        logger.debug("getConsumptionsByRequest() to " + dateTo);

        if (request instanceof SchoolCanteenRegistrationRequest)
            return null;

        try {
            Map<Date, String> results = new LinkedHashMap<Date, String>();
            String pathToFile = testDataDirectory + xmlDirectory + "/" + consumptionsFile;
            File file = new File(pathToFile);
            Document consumptionXMLDocument = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(file);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            XPath xpath = new DOMXPath("//events/event");
            List eventNodes = xpath.selectNodes(consumptionXMLDocument);
            for (int i = 0; i < eventNodes.size(); i++) {
                Node event = (Node) eventNodes.get(i);
                NamedNodeMap attributes = event.getAttributes();
                Node dateNode = attributes.getNamedItem("event-date");
                Node labelNode = attributes.getNamedItem("event-label3");
                Date eventDate = simpleDateFormat.parse(dateNode.getNodeValue());
                logger.debug("adding label " + labelNode.getNodeValue() 
                        + " with date " + eventDate);
                results.put(eventDate, labelNode.getNodeValue());
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Map<String, List<ExternalAccountItem> > getAccountsByHomeFolder(final Long homeFolderId, String externalHomeFolderId, String externalId) 
        throws CvqException {
        
        logger.debug("getAccountsByHomeFolder() home folder " + homeFolderId);

        Map<String, List<ExternalAccountItem> > results = 
            new LinkedHashMap<String, List<ExternalAccountItem> >();

        try {
            IRequestService requestService = 
                requestServiceRegistry.getDefaultRequestService();
            List<Request> requests = 
                requestService.getByHomeFolderIdAndRequestLabel(homeFolderId,
                        authorizingRequestLabel);
            if (requests == null || requests.size() == 0)
                return null;
            // pick the first request
            Request request = requests.get(0);
            logger.debug("getAccountsByHomeFolder() using request : " + request.getId());
            
            String pathToFile = testDataDirectory + xmlDirectory + "/" + accountsFile;
            File file = new File(pathToFile);
            logger.debug("getAccountsByHomeFolder() got file " + file);
            Document accountsXMLDocument = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(file);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");

            // deposit accounts
            XPath xpath = new DOMXPath("//account");
            List accountsElements = (List) xpath.evaluate(accountsXMLDocument);
            List<ExternalAccountItem> depositAccounts = new ArrayList<ExternalAccountItem>();
            for (Iterator i = accountsElements.iterator(); i.hasNext();) {
                Node node = (Node) i.next();
                String accountId = node.getAttributes().getNamedItem("account-id").getNodeValue();
                String accountLabel = node.getAttributes().getNamedItem("account-label").getNodeValue();
                String accountValue = node.getAttributes().getNamedItem("account-value").getNodeValue();
                Date accountDate = simpleDateFormat.parse(node.getAttributes().getNamedItem(
                        "account-date").getNodeValue());

                ExternalDepositAccountItem edai = 
                    new ExternalDepositAccountItem(accountLabel, Double.valueOf(accountValue), 
                            getLabel(), accountId, accountDate, Double.parseDouble(accountValue),
                            null);
                depositAccounts.add(edai);
            }
            results.put(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS, depositAccounts);

            // bill accounts
            xpath = new DOMXPath("//bill");
            List billElements = (List) xpath.evaluate(accountsXMLDocument);
            List<ExternalAccountItem> bills = new ArrayList<ExternalAccountItem>();
            for (Iterator i = billElements.iterator(); i.hasNext();) {
                Node node = (Node) i.next();
                NamedNodeMap nodeAttrs = node.getAttributes();
                String billId = nodeAttrs.getNamedItem("bill-id").getNodeValue();
                String billLabel = nodeAttrs.getNamedItem("bill-label").getNodeValue();
                String billAmount = nodeAttrs.getNamedItem("bill-value").getNodeValue();
                String billTotalValue = nodeAttrs.getNamedItem("bill-total-value").getNodeValue();
                Date billIssueDate = 
                    simpleDateFormat.parse(nodeAttrs.getNamedItem("bill-date").getNodeValue());
                Date billExpirationDate = 
                    simpleDateFormat.parse(nodeAttrs.getNamedItem("bill-date-expiration").getNodeValue());
                Date billPaymentDate = null;
                if (nodeAttrs.getNamedItem("bill-date-payment") != null)
                    billPaymentDate = 
                        simpleDateFormat.parse(nodeAttrs.getNamedItem("bill-date-payment").getNodeValue());
                String billPayed = node.getAttributes().getNamedItem("bill-payed").getNodeValue();
                Boolean isPayed = billPayed.equals("1") ? true : false;
                    
                ExternalInvoiceItem eii = 
                    new ExternalInvoiceItem(billLabel, Double.valueOf(billAmount),
                            Double.valueOf(billTotalValue), getLabel(), billId, billIssueDate,
                            billExpirationDate, billPaymentDate, isPayed, null);
                bills.add(eii);
            }
            results.put(IPaymentService.EXTERNAL_INVOICES, bills);

            // contracts accounts
            xpath = new DOMXPath("//child");
            int i = 0;
            List childElements = (List) xpath.evaluate(accountsXMLDocument);
            List<ExternalAccountItem> ticketingAccounts = new ArrayList<ExternalAccountItem>();
            for (Iterator iter = childElements.iterator(); iter.hasNext();) {
                Node node = (Node) iter.next();
                String childCsn = node.getAttributes().getNamedItem("child-csn").getNodeValue();
                logger.debug("getAccountsByHomeFolder() card CSN : " + childCsn);
                String childId = node.getAttributes().getNamedItem("child-id").getNodeValue();
                logger.debug("getAccountsByHomeFolder() child id : " + childId);

                NodeList contractsNodes = node.getChildNodes();
                for (int j = 0; j < contractsNodes.getLength(); j++) {
                    Node contractNode = contractsNodes.item(j);
                    if (contractNode.getNodeName() != null
                            && contractNode.getNodeName().equals("contract")) {
                        String contractId = 
                            contractNode.getAttributes().getNamedItem("contract-id").getNodeValue();
                        String contractValue = 
                            contractNode.getAttributes().getNamedItem("contract-value").getNodeValue();
                        String contractLabel = 
                            contractNode.getAttributes().getNamedItem("contract-label").getNodeValue();
                        Date contractDate = simpleDateFormat.parse(contractNode.getAttributes()
                            .getNamedItem("contract-date").getNodeValue());
                        int buyPrice = Integer.parseInt(contractNode.getAttributes().getNamedItem(
                            "buy-price").getNodeValue());
                        int minBuy = Integer.parseInt(contractNode.getAttributes().getNamedItem(
                            "min-buy").getNodeValue());
                        int maxBuy = Integer.parseInt(contractNode.getAttributes().getNamedItem(
                            "max-buy").getNodeValue());

                        Long subjectId = request.getSubjectId();
                        List<Individual> individuals = 
                            homeFolderService.getIndividuals(request.getHomeFolderId());
                        Individual subject = null;
                        for (Individual individual : individuals) {
                            if (individual.getId().equals(subjectId)) {
                                subject = individual;
                                break;
                            }
                        }
                        HomeFolder homeFolder = 
                            homeFolderService.getById(request.getHomeFolderId());
                        if (subject == null) {
                            int k = i % homeFolder.getIndividuals().size();
                            subject = (Individual) homeFolder.getIndividuals().toArray()[k];
                        }
                        ExternalTicketingContractItem etci = 
                            new ExternalTicketingContractItem(contractLabel, 
                                    null, getLabel(), contractId, subject.getId(),
                                    Double.valueOf(buyPrice), Integer.valueOf(minBuy), 
                                    Integer.valueOf(maxBuy), null, contractDate,
                                    Integer.valueOf(contractValue), null);
                        etci.addExternalServiceSpecificData("child-csn", childCsn);

                        ticketingAccounts.add(etci);
                        logger.debug("getHomeFolderAccounts() adding contract " + contractId);
                    }
                }
                i++;
            }
            results.put(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS, ticketingAccounts);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return results;
    }


    public Map<Individual, Map<String, String>> getIndividualAccountsInformation(Long homeFolderId, String externalHomeFolderId, String externalId) 
        throws CvqException {
        
        Map<Individual, Map<String, String> > results =
            new HashMap<Individual, Map<String, String> >();

        try {
            IRequestService requestService = 
                requestServiceRegistry.getDefaultRequestService();
            List<Request> requests = 
                requestService.getByHomeFolderIdAndRequestLabel(homeFolderId,
                        authorizingRequestLabel);
            if (requests == null || requests.size() == 0)
                return null;
            // pick the first request
            Request request = requests.get(0);
            logger.debug("getIndividualAccountsInformation() using request : " + request.getId());
            
            String pathToFile = testDataDirectory + xmlDirectory + "/" + accountsFile;
            File file = new File(pathToFile);
            logger.debug("getIndividualAccountsInformation() got file " + file);
            Document accountsXMLDocument = 
                DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            //  contracts accounts
            XPath xpath = new DOMXPath("//child");
            int i = 0;
            List childElements = (List) xpath.evaluate(accountsXMLDocument);
            for (Iterator iter = childElements.iterator(); iter.hasNext();) {
                Node node = (Node) iter.next();
                String childCsn = node.getAttributes().getNamedItem("child-csn").getNodeValue();

                List<Individual> individuals = 
                    homeFolderService.getIndividuals(request.getHomeFolderId());
                Individual subject = null;
                for (Individual individual : individuals) {
                    if (individual.getId().equals(request.getSubjectId())) {
                        subject = individual;
                        break;
                    }
                }
                HomeFolder homeFolder = 
                    homeFolderService.getById(request.getHomeFolderId());
                if (subject == null) {
                    int k = i % homeFolder.getIndividuals().size();
                    subject = (Individual) homeFolder.getIndividuals().toArray()[k]; 
                }

                Map<String, String> individualData = new HashMap<String, String>();
                individualData.put("child-csn", childCsn);
                results.put(subject, individualData);
                
                i++;
            }
            
        } catch (JaxenException jaxe) {
            throw new CvqException("Failed to parse received data : " + jaxe.getMessage());
        } catch (SAXException sae) {
            throw new CvqException("Failed to parse received data : " + sae.getMessage());
        } catch (IOException ioe) {
            throw new CvqRemoteException("Failed to read received data : " + ioe.getMessage());
        } catch (ParserConfigurationException pce) {
            throw new CvqException("Failed to parse received data : " + pce.getMessage());
        }

        return results;
    }

    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        logger.debug("loadDepositAccountDetails()");

        try {

            String pathToFile = testDataDirectory + xmlDirectory + "/" + depositAccountDetailsFile;
            File file = new File(pathToFile);
            logger.debug("loadDepositAccountDetails() got file " + file);
            Document depositAccountDetailsDocument = 
                DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");
            XPath xpath = new DOMXPath("//accountDetails[@account-id='" 
                    + edai.getExternalItemId() + "']/accountDetail");
            List accountDetailNodes = xpath.selectNodes(depositAccountDetailsDocument);
            for (int i = 0; i < accountDetailNodes.size(); i ++) {
                Node accountDetailNode = (Node) accountDetailNodes.get(i);
                ExternalDepositAccountItemDetail edaiDetail =
                    new ExternalDepositAccountItemDetail();
                NodeList accountDetailChildren = accountDetailNode.getChildNodes();
                for (int j = 0; j < accountDetailChildren.getLength(); j++) {
                    Node childNode = accountDetailChildren.item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        if (childNode.getNodeName().equals("date")) {
                            edaiDetail.setDate(simpleDateFormat.parse(childNode.getTextContent()));
                        } else if (childNode.getNodeName().equals("holder-name")){
                            edaiDetail.setHolderName(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("holder-surname")) {
                            edaiDetail.setHolderSurname(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("value")) {
                            edaiDetail.setValue(Integer.valueOf(childNode.getTextContent()));
                        } else if (childNode.getNodeName().equals("payment-type")) {
                            edaiDetail.setPaymentType(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("payment-id")) {
                            edaiDetail.setPaymentId(childNode.getTextContent());
                        }
                    }
                }
                edai.addAccountDetail(edaiDetail);
            }
        } catch (RemoteException re) {
            throw new CvqRemoteException("Failed to connect to Horanet Service" + re.getMessage());
        } catch (SAXException saxe) {
            throw new CvqRemoteException("Failed to parse The schoolCanteen Registration to send to Horanet" + saxe.getMessage());
        } catch (IOException ioe) {
            throw new CvqRemoteException("Failed to parse The schoolCanteen Registration to send to Horanet" + ioe.getMessage());
        } catch (JaxenException jaxe) {
            throw new CvqRemoteException("Failed to parse consumption XML file" + jaxe.getMessage());
        } catch (ParseException pe) {
            throw new CvqRemoteException("Failed to parse Dates" + pe.getMessage());
        } catch (ParserConfigurationException pce) {
            throw new CvqException("Erreur de configuration XML dans l'envoi de doc Horanet: " + pce.getMessage());
        }
    }


    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        logger.debug("loadInvoiceDetails()");

        try {

            String pathToFile = testDataDirectory + xmlDirectory + "/" + invoiceDetailsFile;
            File file = new File(pathToFile);
            logger.debug("loadInvoiceDetails() got file " + file);
            Document invoiceDetailsDocument = 
                DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            XPath xpath = new DOMXPath("//invoiceDetails[@invoice-id='" 
                    + eii.getExternalItemId() + "']/invoiceDetail");
            List invoiceDetailNodes = xpath.selectNodes(invoiceDetailsDocument);
            for (int i = 0; i < invoiceDetailNodes.size(); i ++) {
                Node invoiceDetailNode = (Node) invoiceDetailNodes.get(i);
                ExternalInvoiceItemDetail eiiDetail =
                    new ExternalInvoiceItemDetail();
                NodeList invoiceDetailChildren = invoiceDetailNode.getChildNodes();
                for (int j = 0; j < invoiceDetailChildren.getLength(); j++) {
                    Node childNode = invoiceDetailChildren.item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        if (childNode.getNodeName().equals("label")) {
                            eiiDetail.setLabel(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("child-name")){
                            eiiDetail.setSubjectName(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("child-surname")) {
                            eiiDetail.setSubjectSurname(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("value")) {
                            eiiDetail.setValue(Integer.valueOf(childNode.getTextContent()));
                        } else if (childNode.getNodeName().equals("quantity")) {
                            eiiDetail.setQuantity(new BigDecimal(childNode.getTextContent()));
                        } else if (childNode.getNodeName().equals("unit-price")) {
                            eiiDetail.setUnitPrice(Integer.valueOf(childNode.getTextContent()));
                        }
                    }
                }
                eii.addInvoiceDetail(eiiDetail);
            }
        } catch (RemoteException re) {
            throw new CvqRemoteException("Failed to connect to external service" 
                    + re.getMessage());
        } catch (SAXException saxe) {
            throw new CvqRemoteException("Failed to parse data from external service" 
                    + saxe.getMessage());
        } catch (IOException ioe) {
            throw new CvqRemoteException("Failed to parse data from external service" 
                    + ioe.getMessage());
        } catch (JaxenException jaxe) {
            throw new CvqRemoteException("Failed to parse data from external service" 
                    + jaxe.getMessage());
        } catch (ParserConfigurationException pce) {
            throw new CvqException("Erreur de configuration XML dans l'envoi de doc Horanet: " + pce.getMessage());
        }
    }

    public final void checkConfiguration(final ExternalServiceBean externalServiceBean)
            throws CvqConfigurationException {
    }

    public final String helloWorld() throws CvqException {
        return "Hello World";
    }

    public final void setXmlDirectory(final String xmlDirectory) {
        this.xmlDirectory = xmlDirectory;
    }

    public final void setConsumptionsFile(final String consumptionsFile) {
        this.consumptionsFile = consumptionsFile;
    }

    public void setAccountsFile(final String accountsFile) {
        this.accountsFile = accountsFile;
    }

    public void setTestDataDirectory(String testDataDirectory) {
        this.testDataDirectory = testDataDirectory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public final void setAuthorizingRequestLabel(String authorizingRequestLabel) {
        this.authorizingRequestLabel = authorizingRequestLabel;
    }

    public final void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }

    public final void setDepositAccountDetailsFile(String depositAccountDetailsFile) {
        this.depositAccountDetailsFile = depositAccountDetailsFile;
    }

    public final void setInvoiceDetailsFile(String invoiceDetailsFile) {
        this.invoiceDetailsFile = invoiceDetailsFile;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public boolean supportsConsumptions() {
        return true;
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
