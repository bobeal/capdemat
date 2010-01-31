package fr.cg95.cvq.business.payment;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public final class PaymentMode extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

    public static final PaymentMode INTERNET = new PaymentMode("Internet");
    public static final PaymentMode CARD = new PaymentMode("Card");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private PaymentMode(String mode) {
        super(mode);
    }

    public PaymentMode() {}
    
    public static final PaymentMode[] allPaymentModes = { CARD, INTERNET };

    public static PaymentMode forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return INTERNET;

        if (enumAsString.equals(INTERNET.toString()))
            return INTERNET;
        else if (enumAsString.equals(CARD.toString()))
            return CARD;

        return CARD;
    }
}
