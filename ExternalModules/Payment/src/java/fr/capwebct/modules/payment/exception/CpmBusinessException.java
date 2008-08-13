package fr.capwebct.modules.payment.exception;

public class CpmBusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    public CpmBusinessException() {
        super();
    }
    
    public CpmBusinessException(final String reason) {
        super(reason);
    }
}
