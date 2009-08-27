package fr.cg95.cvq.dao;

public class CvqDaoException extends RuntimeException {

    private static final long serialVersionUID = 7984804081448559598L;

    /** Root cause of this nested exception */
    private Throwable cause;

    public CvqDaoException(String msg) {
        super(msg);
    }
    
    public CvqDaoException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }
    
    /**
     * Return the nested cause, or <code>null</code> if none.
     * <p>Note that this will only check one level of nesting.
     * Use {@link #getRootCause()} to retrieve the innermost cause.
     */
    @Override
    public Throwable getCause() {
        // Even if you cannot set the cause of this exception other than through
        // the constructor, we check for the cause being "this" here, as the cause
        // could still be set to "this" via reflection: for example, by a remoting
        // deserializer like Hessian's.
        return (this.cause == this ? null : this.cause);
    }
}
