package fr.cg95.cvq.exception;

public class CvqTicketBookingException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqTicketBookingException(String reason) {
        super(reason);
    }

    public CvqTicketBookingException(String reason, String key) {
        super(key);
    }
    
    public CvqTicketBookingException(String key, String[] args) {
        super(key, args);
    }
}
