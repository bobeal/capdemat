package fr.cg95.cvq.payment.impl;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.InternalRequestItem;
import fr.cg95.cvq.business.users.payment.Invoice;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.dao.users.IPaymentDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.CvqInvalidBrokerException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.payment.PaymentResultBean;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.payment.PaymentServiceBean;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.util.Critere;

public final class PaymentService implements IPaymentService, BeanFactoryAware {

    private static Logger logger = Logger.getLogger(PaymentService.class);

    private IPaymentDAO paymentDAO;
    private IRequestService requestService;
    private IHomeFolderService homeFolderService;
    private IExternalService externalService;

    private ListableBeanFactory beanFactory;

    public void init() {
        this.homeFolderService = (IHomeFolderService)
            beanFactory.getBeansOfType(IHomeFolderService.class, false, false).values().iterator().next();
        this.externalService = (IExternalService)
            beanFactory.getBeansOfType(IExternalService.class, false, true).values().iterator().next();
        Map<String, IRequestService> beans = beanFactory.getBeansOfType(IRequestService.class, false, true);
        for (String beanName : beans.keySet()) {
            if (beanName.equals("defaultRequestService")) {
                this.requestService = beans.get(beanName);
                break;
            }
        }
    }
    
    public Map<String, String> getAllBrokers() throws CvqException {
        
        Map<IPaymentProviderService, PaymentServiceBean> paymentProviders = 
            SecurityContext.getCurrentConfigurationBean().getPaymentServices();
        if (paymentProviders == null || paymentProviders.isEmpty())
            return null;
        Map<String, String> brokers = new HashMap<String, String>();
        for (IPaymentProviderService paymentProviderService : paymentProviders.keySet()) {
                PaymentServiceBean psb = paymentProviders.get(paymentProviderService);
                brokers.put(psb.getBroker(), psb.getFriendlyLabel());
        }

        return brokers;
    }
	
    
    public final Payment createPaymentContainer(PurchaseItem purchaseItem, PaymentMode paymentMode) 
        throws CvqModelException, CvqInvalidBrokerException, CvqException {

        checkPurchaseItem(purchaseItem);
        
        Payment payment = new Payment();
        String broker = getBrokerForPurchaseItem(purchaseItem, paymentMode);
        if (broker == null || broker.equals(""))
            throw new CvqInvalidBrokerException("payment.missing_broker");
        else if (payment.getPurchaseItems() == null || payment.getPurchaseItems().isEmpty())
            payment.setBroker(broker);
        else if (!broker.equals(payment.getBroker()))
            throw new CvqInvalidBrokerException("payment.incompatible_broker");
        payment.setBroker(broker);
        processPurchaseItemAmount(purchaseItem);
        payment.setAmount(purchaseItem.getAmount());
        payment.setHomeFolder(SecurityContext.getCurrentEcitizen().getHomeFolder());
        payment.setRequester(SecurityContext.getCurrentEcitizen());
        Set<PurchaseItem> purchaseItems = new HashSet<PurchaseItem>();
        purchaseItems.add(purchaseItem);
        payment.setPurchaseItems(purchaseItems);
        payment.setPaymentMode(paymentMode);

        return payment;
    }

    public final void addPurchaseItemToPayment(Payment payment, PurchaseItem purchaseItem)
        throws CvqInvalidBrokerException, CvqModelException, CvqException, 
            CvqObjectNotFoundException {

        checkPurchaseItem(purchaseItem);

        String broker = getBrokerForPurchaseItem(purchaseItem, payment.getPaymentMode());
        if (broker == null || broker.equals(""))
            throw new CvqInvalidBrokerException("payment.missing_broker");
        if (payment.getBroker().equals(""))
            payment.setBroker(broker);
        else if (!broker.equals(payment.getBroker()))
            throw new CvqInvalidBrokerException("payment.incompatible_broker");

        processPurchaseItemAmount(purchaseItem);
        payment.getPurchaseItems().add(purchaseItem);
        double newAmount = payment.getAmount().doubleValue()
            + purchaseItem.getAmount().doubleValue();
        payment.setAmount(Double.valueOf(newAmount));
    }

    public final void removePurchaseItemFromPayment(Payment payment, PurchaseItem purchaseItem) {

        double newAmount = payment.getAmount().doubleValue() 
            - purchaseItem.getAmount().doubleValue(); 
        payment.setAmount(Double.valueOf(newAmount));
        payment.getPurchaseItems().remove(purchaseItem);
        if (payment.getPurchaseItems().isEmpty()) 
            payment.setBroker("");
    }

    /**
     * Perform business checking of a purchase item.
     */
    private void checkPurchaseItem(PurchaseItem purchaseItem) 
        throws CvqModelException {
        
        if (purchaseItem instanceof ExternalInvoiceItem) {
            ExternalInvoiceItem eii = (ExternalInvoiceItem) purchaseItem;
            if (eii.isPaid()) 
                throw new CvqModelException("payment.item_not_buyable");
        }
    }
    
    /**
     * Process a given purchase item to add some business data to it (eg amount).
     */
    private void processPurchaseItemAmount(PurchaseItem purchaseItem) {
        if (purchaseItem instanceof ExternalTicketingContractItem) {
            ExternalTicketingContractItem etci =
                (ExternalTicketingContractItem) purchaseItem;
            Double amount = Double.valueOf(etci.getQuantity().intValue() 
                    * etci.getUnitPrice().intValue());
                
            purchaseItem.setAmount(amount);
        }
    }
    
    public final URL initPayment(Payment payment)
        throws CvqException {
    
        IPaymentProviderService paymentProviderService =
            getPaymentServiceByBrokerAndMode(payment.getBroker(), payment.getPaymentMode());
        if (paymentProviderService == null) {
            throw new CvqException("payment.provider_not_found");
        }
        PaymentServiceBean psb = getPaymentServiceBean(paymentProviderService);
        URL url = paymentProviderService.doInitPayment(payment, psb);
      
        payment.setState(PaymentState.INITIALIZED);
        payment.setInitializationDate(new Date());
        paymentDAO.create(payment);
        
        return url;
    }

    public final PaymentResultStatus commitPayment(final Map<String, String> parameters)
        throws CvqException {
        
        logger.debug("commitPayment() got a commit order");

        IPaymentProviderService paymentProviderService = 
            getPaymentProviderFromParameters(parameters);
        if (paymentProviderService == null) {
            throw new CvqException("payment.provider_not_found");
        }

        logger.debug("commitPayment() redirecting to " + paymentProviderService);
        PaymentServiceBean psb = getPaymentServiceBean(paymentProviderService);
        PaymentResultBean paymentResultBean = 
            paymentProviderService.doCommitPayment(parameters, psb);
        
        PaymentResultStatus paymentStatus = paymentResultBean.getStatus();
        if (paymentStatus.equals(PaymentResultStatus.UNKNOWN) 
                || paymentStatus.equals(PaymentResultStatus.OTHER))
            return paymentStatus;
        
        logger.debug("commitPayment() looking for CVQ reference : " 
                + paymentResultBean.getCvqReference());
        Payment payment = paymentDAO.findByCvqReference(paymentResultBean.getCvqReference());
        payment.setBankReference(paymentResultBean.getBankReference());
        payment.setCommitDate(new Date());

        if (paymentStatus.equals(PaymentResultStatus.OK))
            payment.setState(PaymentState.VALIDATED);
        else if (paymentStatus.equals(PaymentResultStatus.CANCELLED))
            payment.setState(PaymentState.CANCELLED);
        else if (paymentStatus.equals(PaymentResultStatus.REFUSED))
            payment.setState(PaymentState.REFUSED);
        paymentDAO.update(payment);
        
        requestService.notifyPaymentResult(payment);
        homeFolderService.notifyPaymentByMail(payment);
        
        return paymentStatus;
    }
    
    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters) 
        throws CvqException {

        IPaymentProviderService paymentProviderService = 
            getPaymentProviderFromParameters(parameters);
        if (paymentProviderService == null) {
            throw new CvqException("payment.provider_not_found");
        }

        PaymentServiceBean psb = getPaymentServiceBean(paymentProviderService);
        
        return paymentProviderService.getStateFromParameters(parameters, psb);
    }

    private IPaymentProviderService getPaymentProviderFromParameters(Map<String, String> parameters) {

        if (parameters.get("cvqReference") != null) {
            Payment payment = paymentDAO.findByCvqReference(parameters.get("cvqReference"));
            return getPaymentServiceByBrokerAndMode(payment.getBroker(), payment.getPaymentMode());
        } else {
            
            // search the payment provider that will recognize the parameters
            // sounds dirty but don't have anything better for the moment ...
            Set<IPaymentProviderService> paymentProviderServices =
                SecurityContext.getCurrentConfigurationBean().getPaymentServicesObjects();
            for (IPaymentProviderService tempPps : paymentProviderServices) {
                if (tempPps.handleParameters(parameters))
                    return tempPps;
            }
        }

        return null;
    }
    
    public final List<Payment> getByHomeFolder(final HomeFolder homeFolder) {
        return paymentDAO.findByHomeFolder(homeFolder);
    }

    public final Payment getById(final Long id) throws CvqException, CvqObjectNotFoundException {
        return (Payment) paymentDAO.findById(Payment.class, id);
    }

    public List<Payment> get(Set<Critere> criteriaSet, final String sort, final String dir,
            final int recordsReturned, final int startIndex)
            throws CvqException {

        if (criteriaSet == null)
            criteriaSet = new HashSet<Critere>();

        return paymentDAO.search(criteriaSet, sort, dir, recordsReturned, startIndex);
    }    
    
    public Long getCount(Set<Critere> criteriaSet)
            throws CvqException {

        if (criteriaSet == null)
            criteriaSet = new HashSet<Critere>();

        return paymentDAO.count(criteriaSet);
    }
    
    public void delete(Long id) throws CvqException, CvqObjectNotFoundException {
        Payment payment = (Payment) paymentDAO.findById(Payment.class, id);
        delete(payment);
    }

    public void delete(Payment payment) throws CvqException {
        payment.setRequester(null);
        paymentDAO.delete(payment);
    }

    /**
     * Return the service bean associated to the given payment service. 
     */
    private PaymentServiceBean getPaymentServiceBean(IPaymentProviderService paymentProviderService) {

        Map<IPaymentProviderService, PaymentServiceBean> paymentServices = 
            SecurityContext.getCurrentConfigurationBean().getPaymentServices();
        if (paymentServices == null || paymentServices.isEmpty())
            return null;
        
        return paymentServices.get(paymentProviderService);
    }
    
    /**
     * Return the payment service associated to the given broker and payment mode.
     */
    private IPaymentProviderService getPaymentServiceByBrokerAndMode(String broker, 
            PaymentMode paymentMode) {

        Map<IPaymentProviderService, PaymentServiceBean>  paymentServices = 
            SecurityContext.getCurrentConfigurationBean().getPaymentServices();
        if (paymentServices == null || paymentServices.isEmpty())
            return null;

        for (IPaymentProviderService service : paymentServices.keySet()) {
            if (service.getPaymentMode().equals(paymentMode)) {
                PaymentServiceBean psb = paymentServices.get(service);
                if (broker.equals(psb.getBroker()))
                    return service;
            }
        }

        return null;
    }

    /**
     * Find the broker associated with the given item according to its type and to the given
     * payment mode.
     * TODO : to be validated
     */
    private String getBrokerForPurchaseItem(PurchaseItem purchaseItem, PaymentMode paymentMode) 
        throws CvqInvalidBrokerException, CvqModelException, CvqObjectNotFoundException,
            CvqException {
        
        String broker = null;
        if (purchaseItem instanceof Invoice) {
            broker = purchaseItem.getSupportedBroker();
        } else if (purchaseItem instanceof InternalRequestItem) {
            if (purchaseItem.getRequestId() == null)
                throw new CvqModelException("payment.internal_request_item.missing_request");
            // it item carries its broker, return it
            // else get it from its associated request type
            if (purchaseItem.getSupportedBroker() != null)
                return purchaseItem.getSupportedBroker();
            Request request = requestService.getById(purchaseItem.getRequestId());
            RequestType requestType = request.getRequestType();
            broker = getBrokerFromRequestType(requestType.getLabel(), paymentMode);
        } else if (purchaseItem instanceof ExternalAccountItem) {
            // there are two cases for an external account item :
            //    * either it carries broker information within it (case of MPG items)
            //    * either it does not and we find it by request type
            ExternalAccountItem eai = (ExternalAccountItem) purchaseItem;
            if (eai.getSupportedBroker() != null)
                return eai.getSupportedBroker();

            Set<String> requestTypes = 
                externalService.getRequestTypesForExternalService(eai.getExternalServiceLabel());
            for (String requestType : requestTypes) {
                broker = getBrokerFromRequestType(requestType, paymentMode);
                if (broker != null)
                    break;
            }
        }
        
        return broker;
    }
    
    /**
     * Find the broker associated with the given request type and payment mode.
     */
    private String getBrokerFromRequestType(String requestType, PaymentMode paymentMode) {
        Map<IPaymentProviderService, PaymentServiceBean> paymentProviders = 
            SecurityContext.getCurrentConfigurationBean().getPaymentServices();
        if (paymentProviders == null || paymentProviders.isEmpty())
            return null;
        for (IPaymentProviderService paymentProviderService : paymentProviders.keySet()) {
            if (paymentProviderService.getPaymentMode().equals(paymentMode)) {
                PaymentServiceBean psb = paymentProviders.get(paymentProviderService);
                List<String> requestTypes = psb.getRequestTypes();
                if (requestTypes == null || requestTypes.isEmpty())
                    continue;
                for (int i = 0 ; i < requestTypes.size(); i++) {
                    if (requestType.equals(requestTypes.get(i)))
                        return psb.getBroker();
                }
            }
        }

        return null;
    }

    public final void setPaymentDAO(IPaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public final void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }
    
    public void setHomeFolderService(IHomeFolderService homeFolderService) {
		this.homeFolderService = homeFolderService;
	}

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        this.beanFactory = (ListableBeanFactory) arg0;
    }
}
