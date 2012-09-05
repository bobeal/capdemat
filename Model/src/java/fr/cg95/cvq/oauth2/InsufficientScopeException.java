package fr.cg95.cvq.oauth2;

public class InsufficientScopeException extends OAuth2Exception {

    public InsufficientScopeException() {
        super(403, "insufficient_scope", "The request requires higher privileges" +
                " than provided by the access token.");
    }

}
