package fr.capwebct.capdemat.plugins.externalservices.cirilelections.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.ws.client.core.WebServiceTemplate;

import fr.capwebct.modules.payment.schema.sre.SendRequestRequestDocument;
import fr.capwebct.modules.payment.schema.sre.SendRequestRequestDocument.SendRequestRequest;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.impl.ExternalProviderServiceAdapter;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.election.StandardElectoralRollRegistrationRequestDocument.StandardElectoralRollRegistrationRequest;

public class CirilElectionsService extends ExternalProviderServiceAdapter {

    private static Logger logger = Logger.getLogger(CirilElectionsService.class);
    
    private String label;

    private WebServiceTemplate webServiceTemplate;

    private Map<String, ExternalServiceBean> localAuthoritySpecificConfiguration =
            new HashMap<String, ExternalServiceBean>();

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId, 
            String externalHomeFolderId, String externalId)
        throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems, String cvqReference,
            String bankReference, Long homeFolderId, String externalHomeFolderId, String externalId, 
            Date validationDate) throws CvqException {
        
    }

    @Override
    public String sendRequest(XmlObject requestXml) throws CvqException {
        
        SendRequestRequestDocument sendRequestRequestDocument =
            SendRequestRequestDocument.Factory.newInstance();
        SendRequestRequest sendRequestRequest =
            sendRequestRequestDocument.addNewSendRequestRequest();

        RequestType request = (RequestType) requestXml;

        if (request instanceof StandardElectoralRollRegistrationRequest)
            sendRequestRequest.setStandardElectoralRollRegistrationRequest((StandardElectoralRollRegistrationRequest) request);
        else
            sendRequestRequest.setRequest(request);
        sendRequestRequest.setRequestTypeLabel(request.getRequestTypeLabel());
        logger.debug("sendRequest() sending " + sendRequestRequestDocument.xmlText());
        webServiceTemplate.marshalSendAndReceive(getConfigurationProperty("sendRequest"), sendRequestRequestDocument);
        return "";
    }

    @Override
    public boolean supportsConsumptions() {
        return false;
    }

    @Override
    public boolean handlesTraces() {
        return false;
    }

    @Override
    public List<String> checkExternalReferential(final XmlObject requestXml) {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject requestXml)
        throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
        throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean, String localAuthorityName)
        throws CvqConfigurationException {
        localAuthoritySpecificConfiguration.put(localAuthorityName, externalServiceBean);
    }

    private String getConfigurationProperty(String propertyName) {
        String propertySpecificValue = (String)
            localAuthoritySpecificConfiguration.get(SecurityContext.getCurrentSite().getName()).getProperty(propertyName); 
        return propertySpecificValue;
    }

    /** ***** Not Implemented methods ****** */
    /** *********************************** */

    @Override
    public String helloWorld() throws CvqException {
        return null;
    }

    /** ******************************* */

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
}
