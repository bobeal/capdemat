package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * A list of all types of forms associated to requests.
 * 
 * Currently, only deals with certificates but will be extended to other types (requests for
 * information, notification of request reception, ...).
 * 
 * @author bor@zenexity.fr
 */
public class RequestFormType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestFormType REQUEST_CERTIFICAT = 
        new RequestFormType("Request Certificate");
    public static final RequestFormType REQUEST_MAIL_TEMPLATE =
        new RequestFormType("Request Mail Template");

    public RequestFormType() {
    }

    private RequestFormType(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link RequestFormType requests forms types}.
     */
    public static final RequestFormType[] allRequestFormType = { 
        REQUEST_CERTIFICAT,
        REQUEST_MAIL_TEMPLATE
    };
}
