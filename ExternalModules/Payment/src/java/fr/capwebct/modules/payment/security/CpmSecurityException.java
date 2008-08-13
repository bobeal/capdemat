package fr.capwebct.modules.payment.security;

public class CpmSecurityException extends Exception {

    private static final long serialVersionUID = 1L;

    public CpmSecurityException() {
        super();
    }
    
    public CpmSecurityException(final String reason) {
        super(reason);
    }
}
