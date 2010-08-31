package fr.cg95.cvq.exception;

public class CvqConcurrentModificationException extends CvqException {

    private static final long serialVersionUID = 1L;

    public static enum Target {
        document;
    }

    public CvqConcurrentModificationException(Target target, Long id) {
        super(target + ".error.concurrentModification", id != null ? new String[]{ id.toString() } : null);
    }
}
