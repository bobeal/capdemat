package fr.cg95.cvq.payment;

import fr.cg95.cvq.exception.CvqException;

public class CvqInvalidBrokerException extends CvqException {

    public CvqInvalidBrokerException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqInvalidBrokerException() {
        super();
    }
    
    public CvqInvalidBrokerException(final String reason) {
        super(reason);
    }
}
