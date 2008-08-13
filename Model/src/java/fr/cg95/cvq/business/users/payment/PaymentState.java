package fr.cg95.cvq.business.users.payment;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public class PaymentState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final PaymentState INITIALIZED = new PaymentState("Initialized");
    public static final PaymentState VALIDATED = new PaymentState("Validated");
    public static final PaymentState REFUSED = new PaymentState("Refused");
    public static final PaymentState CANCELLED = new PaymentState("Cancelled");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private PaymentState(String state) {
        super(state);
    }

    public PaymentState() {}
    
    public static final PaymentState[] allPaymentStates = 
        { INITIALIZED, VALIDATED, REFUSED, CANCELLED };
}
