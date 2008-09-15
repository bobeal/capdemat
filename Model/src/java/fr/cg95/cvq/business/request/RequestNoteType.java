package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class RequestNoteType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestNoteType DEFAULT_NOTE = 
        new RequestNoteType("Default Note");
    public static final RequestNoteType INSTRUCTION_INTERNAL = 
        new RequestNoteType("Instruction Internal");
    public static final RequestNoteType INSTRUCTION_EXTERNAL = 
        new RequestNoteType("Instruction External");
    public static final RequestNoteType DELIVERY_INTERNAL = 
        new RequestNoteType("Delivery Internal");
    public static final RequestNoteType DELIVERY_EXTERNAL = 
        new RequestNoteType("Delivery External");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestNoteType(String type) {
        super(type);
    }

    public RequestNoteType() {
    }
}
