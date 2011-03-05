package fr.cg95.cvq.external;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A bean used to store an external service configuration for a given
 * local authority.
 *
 * @author bor@zenexity.fr
 */
public class ExternalServiceBean {

    /**
     *  Authentication paraphrase
     */
    protected String password = "";

    /** a map of service specific properties */
    protected Map<String, Object> serviceProperties;

    /** a list of request types this service is interested in */
    protected List<String> requestTypes;

    /**
     * Retrieve a service specific property by name.
     */
    public Object getProperty(String propertyName) {
        if (serviceProperties == null || serviceProperties.isEmpty())
            return null;

        for (String property : serviceProperties.keySet()) {
            if (property.equals(propertyName)) {
                return serviceProperties.get(property);
            }
        }

        return null;
    }

    public boolean supportRequestType(String requestType) {
        if (requestTypes.contains(requestType))
            return true;

        return false;
    }

    public void setServiceProperties(Map<String, Object> serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public final List<String> getRequestTypes() {
        if (requestTypes == null) {
            return Collections.emptyList();
        }
        return requestTypes;
    }

    public void setRequestTypes(List<String> requestTypes) {
        this.requestTypes = requestTypes;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
