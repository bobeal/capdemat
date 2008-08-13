package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class CardState extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final CardState ACTIVE = new CardState("Active");
    public static final CardState BLOCKED = new CardState("Blocked");
    public static final CardState DEBLOCKED = new CardState("Deblocked");
    public static final CardState LOST = new CardState("Lost");
    public static final CardState STOLEN = new CardState("Stolen");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CardState(String state) {
	super(state);
    }

    public CardState() {}
}
