package fr.cg95.cvq.exception;

/**
 * Exception class used to raise XML exceptions while manipulating place reservation referential data.
 * 
 * @author bor@zenexity.fr
 */
public class CvqPlaceReservationReferentialException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqPlaceReservationReferentialException() {
        super();
    }

    public CvqPlaceReservationReferentialException(final String key) {
        super(key);
    }
}
