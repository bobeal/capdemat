package fr.cg95.cvq.service.authority;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.PaymentServiceBean;

/**
 * A bean used to store configuration specific to a local authority.
 * 
 * This bean can be retrieved via the local authority registry.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @see ILocalAuthorityRegistry#getCurrentLocalAuthorityBean()
 */
public final class LocalAuthorityConfigurationBean {

    private static Logger logger = Logger.getLogger(LocalAuthorityConfigurationBean.class);

    private String name;
    private String postalCode;
    private List urls;

    /**
     * Whether an email alert is sent to notify of requests whose instruction is in late, 
     * defaults to false.
     */
    private Boolean instructionAlertsEnabled;
    
    /**
     * Whether, if instruction alerts are enabled, the email sent displays a detailed resume of 
     * requests to instruct, defaults to false.
     */
    private Boolean instructionAlertsDetailed;
    
    /**
     * Whether an email alert is sent to notify of newly created requests, defaults to false.
     */
    private Boolean requestsCreationNotificationEnabled;
    
    private Integer instructionDefaultMaxDelay;
    private Integer instructionDefaultAlertDelay;
    private List instructionDoneStates;
    
    private String displayTitle;
    private List foAccountTabs;
    
    /**
     * Whether document digitalization is enabled for this local authority, defaults to true.
     */
    private Boolean documentDigitalizationEnabled;
    
    private SessionFactory sessionFactory;
    
    private Map<IPaymentProviderService, PaymentServiceBean> paymentServices;
    private Map<IExternalService, ExternalServiceBean> externalServices;
    
    private Map<String, String> ecitizenCreationNotifications;
    private Map ecitizenValidationNotifications;
    private Map agentNotifications;
    private Map paymentNotifications;

    public Object getExternalServiceProperty(Class serviceClass, String propertyName) {
        if (externalServices == null || externalServices.isEmpty())
            return null;

        logger.debug("getExternalServiceProperty() Searching property " + propertyName
                     + " for service " + serviceClass);

        for (IExternalService service : externalServices.keySet()) {
            logger.debug("getExternalServiceProperty() Looking at " + service.getClass());
            if (service.getClass().equals(serviceClass)) {
                logger.debug("getExternalServiceProperty() Got a matching service");
                ExternalServiceBean esb = externalServices.get(service);
                return esb.getProperty(propertyName);
            }
        }
        
        return null;
    }

    /**
     * Get the list of external services objects for the current local authority
     * interested in events about the given request type.
     *
     * @return a list of objects implementing the {@link IExternalService} interface
     */
    public Set<IExternalService> getExternalServicesByRequestType(final String requestTypeLabel) {
        if (externalServices == null || externalServices.isEmpty())
            return null;

        Set<IExternalService> resultSet = new HashSet<IExternalService>();
        for (IExternalService service : externalServices.keySet()) {
            ExternalServiceBean esb = externalServices.get(service);
            if (esb.supportRequestType(requestTypeLabel)) {
                resultSet.add(service);
            }
        }

        return resultSet;
    }

    public IExternalService getExternalServiceByLabel(final String externalServiceLabel) {
        
        if (externalServices == null || externalServices.isEmpty())
            return null;

        for (IExternalService service : externalServices.keySet()) {
            if (service.getLabel().equals(externalServiceLabel)) 
                return service;
        }

        return null;
    }
    
    /**
     * Get the list of external services objects for the current local authority.
     *
     * @return a list of objects implementing the {@link IExternalService} interface
     */
    public Set<IExternalService> getExternalServicesObjects() {
        if (externalServices == null || externalServices.isEmpty())
            return null;

        return externalServices.keySet();
    }

    /**
     * Return the service bean associated to the given external service.
     */
    public ExternalServiceBean getExternalServiceBean(IExternalService service) {
        if (externalServices == null || externalServices.isEmpty())
            return null;

        return externalServices.get(service);
    }

    /**
     * Return the service bean associated to the given external service label.
     */
    public ExternalServiceBean getExternalServiceBean(String serviceLabel) {
        if (externalServices == null || externalServices.isEmpty())
            return null;

        for (IExternalService service : externalServices.keySet()) {
            if (service.getLabel().equals(serviceLabel))
                return externalServices.get(service);
        }
        
        return null;
    }

    /**
     * Get the list of payment services objects for the current local authority.
     *
     * @return a list of objects implementing the {@link IPaymentProviderService} interface
     */
    public Set<IPaymentProviderService> getPaymentServicesObjects() {
        if (paymentServices == null || paymentServices.isEmpty())
            return null;

        return paymentServices.keySet();
    }
    
    public Collection<PaymentServiceBean> getPaymentServicesBeans() {
        if (paymentServices == null || paymentServices.isEmpty())
            return null;

        return paymentServices.values();
    }
    
    /**
     * Return whether the given request type has ecitizen notification enabled for the local
     * authority associated to this bean.
     */
    public boolean hasEcitizenValidationNotification(final String requestTypeLabel) {
        if (ecitizenValidationNotifications == null)
            return false;
        
        if (ecitizenValidationNotifications.get(requestTypeLabel) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given request type
     * label.
     */
    public String getEcitizenValidationNotificationData(final String requestTypeLabel,
            final String dataKey) {
        if (ecitizenValidationNotifications == null)
            return null;
        
        if (ecitizenValidationNotifications.get(requestTypeLabel) == null)
            return null;

        Map data = (Map) ecitizenValidationNotifications.get(requestTypeLabel);
        return (String) data.get(dataKey);
    }

    public Map<String, String> getEcitizenCreationNotifications() {
        return ecitizenCreationNotifications;
    }

    public void setEcitizenCreationNotifications(Map<String, String> ecitizenCreationNotifications) {
        this.ecitizenCreationNotifications = ecitizenCreationNotifications;
    }

    /**
     * Return whether the given key has agent notification enabled for the local
     * authority associated to this bean.
     */
    
    public boolean hasAgentNotification(final String agentNotificationKey) {
        if (agentNotifications== null)
            return false;
        
        if (agentNotifications.get(agentNotificationKey) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given 
     * agent's notification key
     */
    public String getAgentNotificationData(final String agentNotificationKey,
            final String dataKey) {
        if (agentNotifications== null)
            return null;
        
        if (agentNotifications.get(agentNotificationKey) == null)
            return null;

        Map data = (Map) agentNotifications.get(agentNotificationKey);
        return (String) data.get(dataKey);
    }
    
    /**
     * Return whether the given key has agent notification enabled for the local
     * authority associated to this bean.
     */
    public boolean hasPaymentNotification(final String paymentNotificationKey) {
        if (paymentNotifications == null)
            return false;
        
        if (paymentNotifications.get(paymentNotificationKey) != null)
            return true;
        
        return false;
    }
    
    /**
     * Return configuration data associated to the given data key for the given 
     * agent's notification key
     */
    public String getPaymentNotificationData(final String paymentNotificationKey,
            final String dataKey) {
        if (paymentNotifications == null)
            return null;
        
        if (paymentNotifications.get(paymentNotificationKey) == null)
            return null;

        Map data = (Map) paymentNotifications.get(paymentNotificationKey);
        return (String) data.get(dataKey);
    }
    
    /**
     * Return whether the given URL is mapped to this local authority
     */
    public boolean supportUrl(String url) {
        if (this.urls.contains(url))
            return true;

        return false;
    }

    public void init() throws CvqConfigurationException {

        if (urls == null) {
            logger.error("init() No url mapped to site " + name);
            throw new CvqConfigurationException("No url mapped to site " + name);
        }

        // FIXME : this should be done by the payment service
        if (paymentServices != null && paymentServices.size() > 0) {
            for (IPaymentProviderService service : paymentServices.keySet()) {
                logger.debug("init() Looking at " + service.getClass());
                service.checkConfiguration(paymentServices.get(service));
            }
        }

        if (externalServices != null && externalServices.size() > 0) {
            Iterator it = externalServices.keySet().iterator();
            while (it.hasNext()) {
                IExternalService service = (IExternalService) it.next();
                logger.debug("init() Looking at " + service.getClass());
                service.checkConfiguration((ExternalServiceBean) externalServices.get(service));
            }
        }

        if (documentDigitalizationEnabled == null)
            documentDigitalizationEnabled = Boolean.TRUE;
        if (instructionAlertsEnabled == null)
            instructionAlertsEnabled = Boolean.FALSE;
        if (instructionAlertsDetailed == null)
            instructionAlertsDetailed = Boolean.FALSE;
        if (requestsCreationNotificationEnabled == null)
            requestsCreationNotificationEnabled = Boolean.FALSE;
    }
    
    /**
     * Extract email information ("Send to", "Subject", "Body") from the notifications properties
     * of the current local authority.
     * 
     * @param hasNotificationMethodName name of method that check email existence
     * @param getNotificationDataMethodName name of method that get email field
     * @param mailKey key of the email to extract
     */
    public Map<String, String> getMailAsMap(String hasNotificationMethodName, 
            String getNotificationDataMethodName, String mailKey) {
        
		try {
			Method hasNotificationMethod = 
				getClass().getDeclaredMethod(hasNotificationMethodName, 
                        new Class[] { String.class });
			Method getNotificationDataMethod = 
				getClass().getDeclaredMethod(getNotificationDataMethodName, 
                        new Class[] { String.class, String.class });
			
			if ((Boolean) hasNotificationMethod.invoke(this, new Object[] {mailKey}))  {
                Map<String, String> mailMap = new HashMap<String, String>();
                
				String mailSubject = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailSubject"});
				mailMap.put("mailSubject", mailSubject);
				String mailSendTo = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailSendTo"});
				mailMap.put("mailSendTo", mailSendTo);
				String mailData = 
                    (String) getNotificationDataMethod.invoke(this, new Object[] {mailKey, "mailData"});
				mailMap.put("mailData", mailData);
                
                return mailMap;
			}

            return null;
		} catch(Exception exception) {
			logger.error("getMailAsMap() reflection method call exception");
			exception.printStackTrace();
			return null;
		}
	}
    
    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUrls(final List urls) {
        this.urls = urls;
    }

    public List getUrls() {
        return this.urls;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setPaymentServices(final Map<IPaymentProviderService, PaymentServiceBean> paymentServices) {
        this.paymentServices = paymentServices;
    }

    public final Map<IPaymentProviderService, PaymentServiceBean> getPaymentServices() {
        return paymentServices;
    }

    public void setExternalServices(final Map<IExternalService, ExternalServiceBean> externalServices) {
        this.externalServices = externalServices;
    }

    public void setEcitizenValidationNotifications(Map ecitizenValidationNotifications) {
        this.ecitizenValidationNotifications = ecitizenValidationNotifications;
    }
    
	public void setAgentNotifications(Map agentNotifications) {
		this.agentNotifications = agentNotifications;
	}
	
	public void setPaymentNotifications(Map paymentNotifications) {
		this.paymentNotifications = paymentNotifications;
	}
	
    public Boolean isDocumentDigitalizationEnabled() {
        return this.documentDigitalizationEnabled;
    }

    public void setDocumentDigitalizationEnabled(final String documentDigitalizationEnabled) {
        this.documentDigitalizationEnabled = Boolean.valueOf(documentDigitalizationEnabled);
    }

	public void setInstructionDefaultAlertDelay(Integer instructionDefaultAlertDelay) {
		this.instructionDefaultAlertDelay = instructionDefaultAlertDelay;
	}

	public void setInstructionDefaultMaxDelay(Integer instructionDefaultMaxDelay) {
		this.instructionDefaultMaxDelay = instructionDefaultMaxDelay;
	}

	public void setInstructionDoneStates(List instructionDoneStates) {
		this.instructionDoneStates = instructionDoneStates;
	}

	public Integer getInstructionDefaultAlertDelay() {
		return instructionDefaultAlertDelay;
	}

	public Integer getInstructionDefaultMaxDelay() {
		return instructionDefaultMaxDelay;
	}

	public List getInstructionDoneStates() {
		return instructionDoneStates;
	}

	public Boolean getInstructionAlertsEnabled() {
		return instructionAlertsEnabled;
	}

	public void setInstructionAlertsEnabled(Boolean instructionAlertsEnabled) {
		this.instructionAlertsEnabled = instructionAlertsEnabled;
	}

	public Boolean getRequestsCreationNotificationEnabled() {
		return requestsCreationNotificationEnabled;
	}

	public void setRequestsCreationNotificationEnabled(Boolean requestsCreationNotificationEnabled) {
		this.requestsCreationNotificationEnabled = requestsCreationNotificationEnabled;
	}

	public Boolean getInstructionAlertsDetailed() {
		return instructionAlertsDetailed;
	}

	public void setInstructionAlertsDetailed(Boolean instructionAlertsDetailed) {
		this.instructionAlertsDetailed = instructionAlertsDetailed;
	}

    public List getFoAccountTabs() {
        return foAccountTabs;
    }

    public void setFoAccountTabs(final List displayProperties) {
        this.foAccountTabs = displayProperties;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(final String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
