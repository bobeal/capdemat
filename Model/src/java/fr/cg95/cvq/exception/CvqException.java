package fr.cg95.cvq.exception;

/**
 * Base class for application's checked exceptions class hierarchy.
 *
 * @author bor@zenexity.fr
 */
public class CvqException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private String i18nKey;
    private String[] i18nArgs;

    /**
     * @deprecated No more used
     */
    public CvqException() {
        super();
    }

    public CvqException(final String reason) {
        super(reason);
        this.i18nKey = reason;
    }
    
    public CvqException(final String reason, String key) {
        super(reason);
        this.i18nKey = key;
    }

    public CvqException(final String reason, String key, String[] args) {
        super(reason);
        this.i18nKey = key;
        this.i18nArgs = args;
    }

    public String getI18nKey() {
        return this.i18nKey;
    }

    public void setI18nKey(String key) {
        this.i18nKey = key;
    }

    public String[] getI18nArgs() {
        return this.i18nArgs;
    }

    public void setI18nArgs(String[] args) {
        this.i18nArgs = args;
    }
}
