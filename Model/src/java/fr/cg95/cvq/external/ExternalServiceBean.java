package fr.cg95.cvq.external;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A bean used to store an external service configuration for a given
 * local authority.
 *
 * @author bor@zenexity.fr
 */
public class ExternalServiceBean {

    /** a map of service specific properties */
    protected Map serviceProperties;

    /** a list of request types this service is interested in */
    protected List<String> requestTypes;

    /**
     * whether or not this service supports retrieving of accounts information
     * according to an home folder id
     */
    protected boolean supportAccountsByHomeFolder;

    /**
     * whether or not this service supports retrieving of accounts information
     * according to a request id
     */
    protected boolean supportAccountsByRequest;

    /**
     * Retrieve a service specific property by name
     */
    public Object getProperty(String propertyName) {
        if (serviceProperties == null
            || serviceProperties.isEmpty())
            return null;

        Iterator it = serviceProperties.keySet().iterator();
        while (it.hasNext()) {
            String property = (String) it.next();
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

    public void setServiceProperties(Map serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public final List<String> getRequestTypes() {
        return requestTypes;
    }

    public void setRequestTypes(List<String> requestTypes) {
        this.requestTypes = requestTypes;
    }

    public boolean supportAccountsByHomeFolder() {
        return this.supportAccountsByHomeFolder;
    }

    public boolean supportAccountsByRequest() {
        return this.supportAccountsByRequest;
    }

    public void setSupportAccountsByHomeFolder(boolean supportAccountsByHomeFolder) {
        this.supportAccountsByHomeFolder = supportAccountsByHomeFolder;
    }

    public void setSupportAccountsByRequest(boolean supportAccountsByRequest) {
        this.supportAccountsByRequest = supportAccountsByRequest;
    }
}
