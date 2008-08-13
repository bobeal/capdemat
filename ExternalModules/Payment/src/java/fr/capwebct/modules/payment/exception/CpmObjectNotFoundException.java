package fr.capwebct.modules.payment.exception;

public class CpmObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CpmObjectNotFoundException() {
        super();
    }
    
    public CpmObjectNotFoundException(final String reason) {
        super(reason);
    }

}
