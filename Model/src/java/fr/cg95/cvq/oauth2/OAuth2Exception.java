package fr.cg95.cvq.oauth2;

public class OAuth2Exception extends Exception {

    private final int status;
    private final String errorCode;

    public OAuth2Exception() {
        super("The request is missing a required parameter, includes an " +
         "unsupported parameter or parameter value, repeats the same " +
         "parameter, uses more than one method for including an access " +
         "token, or is otherwise malformed.");
        this.status = 400;
        this.errorCode = "invalid_request";
    }

    public OAuth2Exception(int status, String errorCode, String msg) {
        super(msg);
        this.status = status;
        this.errorCode = errorCode;
    }

    public int getHttpErrorCode() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getJson() {
        return "{ \"error\": \"" + getErrorCode() + ", \"error_description\": \"" + getMessage() + "\"}";
    }

}
