package fr.cg95.cvq.external.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.context.ApplicationListener;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentEvent;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.external.IExternalHomeFolderDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceUtils;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.annotation.RequestFilter;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.xml.common.HomeFolderType;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.RequestType;

public class ExternalService implements IExternalService, ApplicationListener<PaymentEvent> {

    private static Logger logger = Logger.getLogger(ExternalService.class);

    private IExternalHomeFolderService externalHomeFolderService;

    private IExternalServiceTraceDAO externalServiceTraceDAO;

    @Override
    public boolean authenticate(String externalServiceLabel, String password) {
        IExternalProviderService externalProviderService =
            getExternalServiceByLabel(externalServiceLabel);
        if (externalProviderService == null) {
            logger.warn("authenticate() unable to find a matching service for " + externalServiceLabel);
            return false;
        }

        ExternalServiceBean esb = getBeanForExternalService(externalProviderService);
        if (esb.getPassword().equals(password))
            return true;

        logger.warn("authenticate() authentication failed for service " + externalServiceLabel);
        return false;
    }

    @Override
    public List<String> checkExternalReferential(XmlObject request, 
            Set<IExternalProviderService> externalProviderServices) {

        List<String> errors = new ArrayList<String>();
        for (IExternalProviderService eps : externalProviderServices) {
            errors.addAll(eps.checkExternalReferential(request));
        }

        return errors;
    }

    @Override
    public void sendRequest(XmlObject xmlObject, 
            Set<IExternalProviderService> externalProviderServices) throws CvqException {

        RequestType xmlRequest = ExternalServiceUtils.getRequestTypeFromXmlObject(xmlObject);
        HomeFolderType xmlHomeFolder = xmlRequest.getHomeFolder();
        for (IExternalProviderService externalProviderService : externalProviderServices) {
            // before sending the request to the external service, eventually set 
            // the external identifiers if they are known ...
            String externalServiceLabel = externalProviderService.getLabel();
            HomeFolderMapping esim = 
                externalHomeFolderService.getHomeFolderMapping(externalServiceLabel, xmlHomeFolder.getId());
            if (esim != null) {
                fillRequestWithEsim(xmlRequest, esim);
            } else {
                // no existing external service mapping : create a new one to store
                // the CapDemat external identifier
                esim = new HomeFolderMapping(externalServiceLabel, xmlHomeFolder.getId(), 
                        UUID.randomUUID().toString(), null);
                for (IndividualType xmlIndividual : xmlHomeFolder.getIndividualsArray()) {
                    esim.addIndividualMapping(xmlIndividual.getId(), UUID.randomUUID().toString(), null);
                }

                externalHomeFolderService.createHomeFolderMapping(esim);

                // Need to flush if we want EPSs to see the newly created ESIM
                HibernateUtil.getSession().flush();

                fillRequestWithEsim(xmlRequest, esim);
            }

            ExternalServiceTrace est = null;
            if (!externalProviderService.handlesTraces()) {
                est = new ExternalServiceTrace(new Date(), String.valueOf(xmlRequest.getId()),
                        null, "capdemat", null, externalServiceLabel, null);
            }
            try {
                logger.debug("sendRequest() routing request to external service " 
                        + externalServiceLabel);
                String externalId = externalProviderService.sendRequest(xmlRequest);
                if (externalId != null && !externalId.equals("")) {
                    esim.setExternalId(externalId);
                    externalHomeFolderService.modifyHomeFolderMapping(esim);
                }
                if (!externalProviderService.handlesTraces()) {
                    est.setStatus(TraceStatusEnum.SENT);
                }
            } catch (CvqException ce) {
                logger.error("sendRequest() error while sending request to " 
                        + externalServiceLabel);
                if (!externalProviderService.handlesTraces()) {
                    est.setStatus(TraceStatusEnum.NOT_SENT);
                }
            }
            if (!externalProviderService.handlesTraces()) {
                externalServiceTraceDAO.create(est);
            }
        }
    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject xmlObject)
        throws CvqException {
        
        RequestType xmlRequest = ExternalServiceUtils.getRequestTypeFromXmlObject(xmlObject);
        List<HomeFolderMapping> esimList = 
            externalHomeFolderService.getHomeFolderMappings(xmlRequest.getHomeFolder().getId());
        if (esimList == null || esimList.isEmpty())
            return Collections.emptyMap();
        
        Map<String, Object> informations = new TreeMap<String, Object>();
        for (HomeFolderMapping esim : esimList) {
            IExternalProviderService externalProviderService = 
                getExternalServiceByLabel(esim.getExternalServiceLabel());
            if (externalProviderService == null) {
                logger.warn("loadExternalInformations() External service " + esim.getExternalServiceLabel() 
                        + " is no longer existing");
                continue;
            }
            fillRequestWithEsim(xmlRequest, esim);
            try {
                informations.putAll(externalProviderService.loadExternalInformations(xmlRequest));
            } catch (CvqException e) {
                logger.warn("loadExternalInformations()" +
                    "Failed to retrieve information for " + externalProviderService.getLabel());
            }            
        }
        
        return informations;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Set<ExternalAccountItem> getExternalAccounts(Long homeFolderId, String type) 
        throws CvqException {
        
        // FIXME : this can cause backward compatibility problems
        //         not sure that all existing accounts have a mapping
        List<HomeFolderMapping> esimList = 
            externalHomeFolderService.getHomeFolderMappings(homeFolderId);
        if (esimList == null || esimList.isEmpty())
            return Collections.emptySet();
        
        Set<ExternalAccountItem> accountsInfoSet = new HashSet<ExternalAccountItem>();
        for (HomeFolderMapping esim : esimList) {
            IExternalProviderService externalProviderService = 
                getExternalServiceByLabel(esim.getExternalServiceLabel());
            if (externalProviderService == null) {
                logger.warn("getExternalAccounts() External service " + esim.getExternalServiceLabel() 
                        + " is no longer existing");
                continue;
            }
            ExternalServiceBean esb = getBeanForExternalService(externalProviderService);
            // ask accounts information by home folder or by request
            // according to what the external service supports
            if (esb.supportAccountsByHomeFolder()) {
                Map<String, List<ExternalAccountItem>> homeFolderAccounts = 
                    externalProviderService.getAccountsByHomeFolder(homeFolderId, 
                            esim.getExternalCapDematId(), esim.getExternalId());
                if (homeFolderAccounts != null && homeFolderAccounts.get(type) != null) {
                    accountsInfoSet.addAll(homeFolderAccounts.get(type));
                }
            } else if (esb.supportAccountsByRequest()) {
                logger.warn("getExternalAccounts() accounts by request is currently not supported");
            }
            
        }
        
        return accountsInfoSet;
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
                        + purchaseItem.getFriendlyLabel());
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
                HomeFolderMapping esim = 
                    externalHomeFolderService.getHomeFolderMapping(externalServiceLabel, payment.getHomeFolderId());
                service.creditHomeFolderAccounts(externalServicesToNotify.get(externalServiceLabel), 
                        payment.getCvqReference(), payment.getBankReference(), 
                        payment.getHomeFolderId(), 
                        esim == null ? null : esim.getExternalCapDematId(), 
                        esim == null ? null : esim.getExternalId(), payment.getCommitDate());
            }
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo,
            Set<IExternalProviderService> externalProviderServices)
        throws CvqException {

        Map<Date, String> resultMap = new HashMap<Date, String>();
        for (IExternalProviderService externalProviderService : externalProviderServices) {
            Map<Date, String> serviceMap = 
                externalProviderService.getConsumptions(key, dateFrom, dateTo);
            if (serviceMap != null && !serviceMap.isEmpty())
                resultMap.putAll(serviceMap);            
        }
        
        return resultMap;
    }

    private void fillRequestWithEsim(RequestType xmlRequest, HomeFolderMapping esim) {
        
        HomeFolderType xmlHomeFolder = xmlRequest.getHomeFolder();
        xmlHomeFolder.setExternalId(esim.getExternalId());
        xmlHomeFolder.setExternalCapdematId(esim.getExternalCapDematId());

        for (IndividualMapping esimInd : esim.getIndividualsMappings()) {
            if (esimInd.getIndividualId() == null) {
                logger.warn("fillRequestWithEsim() Got an ESIM without individual id " + esimInd.getExternalCapDematId());
                continue;
            }
            
            if (esimInd.getIndividualId().equals(xmlRequest.getRequester().getId())) {
                xmlRequest.getRequester().setExternalCapdematId(esimInd.getExternalCapDematId());
                xmlRequest.getRequester().setExternalId(esimInd.getExternalId());
            }
            
            if (xmlRequest.getSubject() != null && xmlRequest.getSubject().getChild() != null) {
                IndividualType individualType = null;
                if (xmlRequest.getSubject().getChild() != null)
                    individualType = xmlRequest.getSubject().getChild();
                else if (xmlRequest.getSubject().getAdult() != null)
                    individualType = xmlRequest.getSubject().getAdult();
                else if (xmlRequest.getSubject().getIndividual() != null)
                    individualType = xmlRequest.getSubject().getIndividual();
                
                if (individualType == null) {
                    logger.warn("fillRequestWithEsim() Unable to extract individual from requets " + xmlRequest.getId());
                } else if (esimInd.getIndividualId().equals(individualType.getId())) {
                    individualType.setExternalCapdematId(esimInd.getExternalCapDematId());
                    individualType.setExternalId(esimInd.getExternalId());
                }
            }
            
            for (IndividualType xmlIndividual : xmlHomeFolder.getIndividualsArray()) {
                if (esimInd.getIndividualId().equals(xmlIndividual.getId())) {
                    xmlIndividual.setExternalId(esimInd.getExternalId());
                    xmlIndividual.setExternalCapdematId(esimInd.getExternalCapDematId());
                }
            }
        }
    }
    
    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public Long addTrace(ExternalServiceTrace trace) {
        trace.setDate(new Date());
        return externalServiceTraceDAO.create(trace);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    @RequestFilter(privilege = ContextPrivilege.READ)
    public List<ExternalServiceTrace> getTraces(Set<Critere> criteriaSet,
        String sort, String dir, int count, int offset) {
        return externalServiceTraceDAO.get(criteriaSet, sort, dir, count, offset, false);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    @RequestFilter(privilege = ContextPrivilege.READ)
    public Long getTracesCount(Set<Critere> criteriaSet) {
        return externalServiceTraceDAO.getCount(criteriaSet, false);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    @RequestFilter(privilege = ContextPrivilege.READ)
    public List<ExternalServiceTrace> getLastTraces(Set<Critere> criteriaSet,
        String sort, String dir, int count, int offset) {
        return externalServiceTraceDAO.get(criteriaSet, sort, dir, count, offset, true);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    @RequestFilter(privilege = ContextPrivilege.READ)
    public Long getLastTracesCount(Set<Critere> criteriaSet) {
        return externalServiceTraceDAO.getCount(criteriaSet, true);
    }


    /**
     * Get the configuration bean associated to the given external provider service.
     */
    @Override
    public ExternalServiceBean getBeanForExternalService(IExternalProviderService externalProviderService) {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        return lacb.getExternalServices().get(externalProviderService);
    }

    /**
     * Get the external provider service that has the given label.
     */
    @Override
    public IExternalProviderService getExternalServiceByLabel(final String externalServiceLabel) {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Map<IExternalProviderService, ExternalServiceBean> externalProviderServices = 
            lacb.getExternalServices();
        if (externalProviderServices == null || externalProviderServices.isEmpty())
            return null;

        for (IExternalProviderService service : externalProviderServices.keySet()) {
            if (service.getLabel().equals(externalServiceLabel))
                return service;
        }

        return null;
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

    public void setExternalServiceTraceDAO(IExternalServiceTraceDAO externalServiceTraceDAO) {
        this.externalServiceTraceDAO = externalServiceTraceDAO;
    }

    public void setExternalHomeFolderService(IExternalHomeFolderService externalHomeFolderService) {
        this.externalHomeFolderService = externalHomeFolderService;
    }

}
