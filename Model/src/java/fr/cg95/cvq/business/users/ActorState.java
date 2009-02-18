package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class ActorState extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final ActorState PENDING = new ActorState("Pending");
    public static final ActorState VALID = new ActorState("Valid");
    public static final ActorState INVALID = new ActorState("Invalid");
    public static final ActorState ARCHIVED = new ActorState("Archived");
    
    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ActorState(final String state) {
        super(state);
    }

    public ActorState() {}
    
    public static final ActorState[] allActorStates = { PENDING, VALID, INVALID, ARCHIVED };
    
    public static ActorState forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return PENDING;

        if (enumAsString.equals(PENDING.toString()))
            return PENDING;
        else if (enumAsString.equals(VALID.toString()))
            return VALID;
        else if (enumAsString.equals(INVALID.toString()))
            return INVALID;
        else if (enumAsString.equals(ARCHIVED.toString()))
            return ARCHIVED;

        return PENDING;
    }
}
