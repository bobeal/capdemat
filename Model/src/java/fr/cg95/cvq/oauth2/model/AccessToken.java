package fr.cg95.cvq.oauth2.model;

import java.util.Date;

public class AccessToken {

    private final String resourceServerName;
    private final String resourceOwnerName;
    private final String scope;
    private final long expiration;

    public AccessToken(String resourceServerName, String resourceOwnerName, String scope,
            long expiration) {
        super();
        this.resourceServerName = resourceServerName;
        this.resourceOwnerName = resourceOwnerName;
        this.scope = scope;
        this.expiration = expiration;
    }

    public String getResourceServerName() {
        return resourceServerName;
    }

    public String getResourceOwnerName() {
        return resourceOwnerName;
    }

    public String getScope() {
        return scope;
    }

    public long getExpiration() {
        return expiration;
    }

    public boolean isValid(String resourceServerName) {
        return isValid() && this.resourceServerName.equals(resourceServerName);
    }

    public boolean isValid(){
        return
            resourceServerName != null && !resourceServerName.trim().isEmpty() &&
            resourceOwnerName != null && !resourceOwnerName.trim().isEmpty() &&
            scope != null && !scope.trim().isEmpty() &&
            expiration > (new Date()).getTime();
    }

}
