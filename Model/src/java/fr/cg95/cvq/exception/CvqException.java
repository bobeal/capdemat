package fr.cg95.cvq.exception;

//import org.apache.log4j.Logger;

/**
 * Base class for application's checked exceptions class hierarchy.
 *
 * @author bor@zenexity.fr
 */
public class CvqException extends Exception {

    private static final long serialVersionUID = 1L;
    
//    protected static Logger logger = Logger.getLogger(CvqException.class);

    private String i18nKey;
    private String[] i18nArgs;

    /**
     * @deprecated No more used
     */
    public CvqException() {
        super();
    }

    public CvqException(final String i18nKey) {
        this(i18nKey, null);
        this.i18nKey = i18nKey;
    }
    
    public CvqException(String i18nKey, String[] i18nArgs) {
        super(i18nKey);
        this.i18nKey = i18nKey;
        this.i18nArgs = i18nArgs;
    }

    public String getI18nKey() {
        return i18nKey;
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
