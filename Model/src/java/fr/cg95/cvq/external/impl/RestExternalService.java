package fr.cg95.cvq.external.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;

import fr.capwebct.modules.payment.schema.rei.ExternalInformationType;
import fr.capwebct.modules.payment.schema.rei.GetExternalInformationResponseDocument;
import fr.capwebct.modules.payment.schema.rei.GetExternalInformationResponseDocument.GetExternalInformationResponse;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceUtils;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.web.WS;
import fr.cg95.cvq.util.web.WS.HttpResponse;
import fr.cg95.cvq.xml.common.RequestType;

public class RestExternalService implements IExternalProviderService {

    private static Logger logger = Logger.getLogger(RestExternalService.class);
    
    private IExternalServiceTraceDAO externalServiceTraceDAO;
    
    private String label;
    private Map<String, String> urls;

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
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        return null;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public boolean handlesTraces() {
        return true;
    }

    @Override
    public String helloWorld() throws CvqException {
        return null;
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject requestXml) throws CvqException {
        RequestType requestType = (RequestType) requestXml;
        HttpResponse response = WS.url(urls.get("loadExternalInformation"))
            .setParameter("requestId", String.valueOf(requestType.getId()))
            .setParameter("localAuthority", SecurityContext.getCurrentSite().getName()).get();
        int status = response.getStatus();
        logger.debug("loadExternalInformations() got response : " + response.getString());
        if (status == 200) {
            Document doc = response.getXml("UTF-8");
            try {
                GetExternalInformationResponseDocument getExternalInformationResponseDocument =
                    GetExternalInformationResponseDocument.Factory.parse(doc, null);
                GetExternalInformationResponse getExternalInformationResponse =
                    getExternalInformationResponseDocument.getGetExternalInformationResponse();
                ExternalInformationType[] externalInformations  =
                    getExternalInformationResponse.getExternalInformationArray();
                Map<String, Object> result = new HashMap<String, Object>();
                for (int i = 0 ; i < externalInformations.length; i++) {
                    result.put(externalInformations[i].getKey(), externalInformations[i].getValue());
                }
                return result;
            } catch (XmlException e) {
                logger.error("loadExternalInformations() got an exception : " + e.getMessage());
                return Collections.emptyMap();
            }
        } else {
            logger.warn("loadExternalInformations() returned with status code : " + status);
            return Collections.emptyMap();
        }
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
    }

    @Override
    public String sendRequest(XmlObject requestXml) throws CvqException {
        RequestType requestType = (RequestType) requestXml;
        ExternalServiceTrace est = new ExternalServiceTrace(new Date(), String.valueOf(requestType.getId()), null, 
                "capdemat", null, getLabel(), null);
        String body = ExternalServiceUtils.getRequestFromFragment(requestXml);
        logger.debug("sendRequest() sending : " + body);
        HttpResponse response = WS.url(urls.get("sendRequest")).body(body).post();
        int status = response.getStatus();
        logger.debug("sendRequest() got response : " + response.getString());
        if (status == 200) {
            est.setStatus(TraceStatusEnum.SENT);
        } else if (status == 500) {
            est.setStatus(TraceStatusEnum.ERROR);
        } else if (status == 404 || status == 403 || status == 401) {
            est.setStatus(TraceStatusEnum.NOT_SENT);
            est.setMessage("Le service distant a répondu avec le code : " + status);
        }
        externalServiceTraceDAO.create(est);

        return null;
    }

    @Override
    public boolean supportsConsumptions() {
        return false;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public void setExternalServiceTraceDAO(IExternalServiceTraceDAO externalServiceTraceDAO) {
        this.externalServiceTraceDAO = externalServiceTraceDAO;
    }
}
