package fr.cg95.cvq.business.request;

/**
 * A list of all types of forms associated to requests.
 * 
 * Currently, only deals with certificates but will be extended to other types (requests for
 * information, notification of request reception, ...).
 * 
 * @author bor@zenexity.fr
 */
public enum RequestFormType {


    REQUEST_CERTIFICAT("Request Certificate"),
    REQUEST_MAIL_TEMPLATE("Request Mail Template");

    private static final long serialVersionUID = 1L;
    private String name;


    private RequestFormType(String name) {
        this.name = name;
    }

    /**
     * A vector of all possible {@link RequestFormType requests forms types}.
     * @deprecated only for backward, use values() instead
     */
    static RequestFormType[] allRequestFormType = RequestFormType.values();

    @Override
    public String toString() {
        return name;
    }
}
