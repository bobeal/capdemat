package fr.cg95.cvq.business.document;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public final class DepositOrigin extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final DepositOrigin AGENT = new DepositOrigin("Agent");
    public static final DepositOrigin ECITIZEN = new DepositOrigin("ECitizen");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DepositOrigin(String origin) {
	super(origin);
    }

    public DepositOrigin() {}
}
