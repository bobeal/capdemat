package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class RequestStep extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final RequestStep INSTRUCTION = new RequestStep("Instruction");
    public static final RequestStep DELIVERY = new RequestStep("Delivery");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestStep(String step) {
	super(step);
    }

    public RequestStep() {}

    public static RequestStep forString(String enumAsString) {
	if (enumAsString == null || enumAsString.equals(""))
	    return INSTRUCTION;

	if (enumAsString.equals(INSTRUCTION.toString()))
	    return INSTRUCTION;
	else if (enumAsString.equals(DELIVERY.toString()))
	    return DELIVERY;

	return INSTRUCTION;
    }
}
