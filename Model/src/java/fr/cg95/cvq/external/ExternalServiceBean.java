package fr.cg95.cvq.external;

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
     * Flag that specify if generation job must be launched for an autority
     */
    protected boolean generateTracedRequest = false;
    

    /**
     *  Authentication paraphrase
     */
    protected String password = "";

    /** a map of service specific properties */
    protected Map<String, Object> serviceProperties;

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
    
    public boolean getGenerateTracedRequest() {
        return this.generateTracedRequest;
    }

    public void setGenerateTracedRequest(boolean generateTracedRequest) {
        this.generateTracedRequest = generateTracedRequest;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
