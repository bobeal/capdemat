package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public final class DepositType extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final DepositType PC = new DepositType("PC");
    public static final DepositType TERMINAL = new DepositType("Terminal");
    public static final DepositType MAILED_PAPER = new DepositType("Mailed Paper");
    public static final DepositType BROUGHT_PAPER = new DepositType("Brought Paper");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DepositType(final String type) {
	super(type);
    }
    
    public DepositType() {
    }
}
