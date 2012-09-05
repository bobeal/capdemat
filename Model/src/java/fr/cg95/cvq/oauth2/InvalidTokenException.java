package fr.cg95.cvq.oauth2;

public class InvalidTokenException extends OAuth2Exception {

    public InvalidTokenException() {
        super(401, "invalid_token", "The access token provided is expired," +
                " revoked, malformed, or invalid for other reasons.");
    }

}
