package fr.cg95.cvq.payment;

import java.util.List;
import java.util.Map;

/**
 * A bean used to store a payment provider configuration for a given
 * broker and local authority.
 *
 * @author bor@zenexity.fr
 */
public class PaymentServiceBean {

    protected String broker;
    protected String friendlyLabel;
    
    /** a map of service specific properties. */
    protected Map<String, Object> serviceProperties;

    /** a list of request types this service is interested in. */
    protected List<String> requestTypes;

    public final Object getProperty(final String propertyName) {
        if (serviceProperties == null || serviceProperties.isEmpty())
            return null;

        return serviceProperties.get(propertyName);
    }

    public final void setServiceProperties(final Map<String, Object>  serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public final void setRequestTypes(final List<String> requestTypes) {
        this.requestTypes = requestTypes;
    }

    public final List<String> getRequestTypes() {
        return this.requestTypes;
    }
    
    public final String getBroker() {
        return broker;
    }

    public final void setBroker(String broker) {
        this.broker = broker;
    }

    public final String getFriendlyLabel() {
        return friendlyLabel;
    }

    public final void setFriendlyLabel(String friendlyLabel) {
        this.friendlyLabel = friendlyLabel;
    }
}
