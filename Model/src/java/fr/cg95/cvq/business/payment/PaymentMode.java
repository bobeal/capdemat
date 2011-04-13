package fr.cg95.cvq.business.payment;

/**
 * @author bor@zenexity.fr
 */
public enum PaymentMode {

    INTERNET("Internet"),
    CARD("Card");

    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private PaymentMode(String mode) {
        this.name = mode;
    }

    /**
     * @deprecated, only for backward, use values() instead
     */
    public static final PaymentMode[] allPaymentModes = values();

    public static PaymentMode forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return INTERNET;

        if (enumAsString.equals(INTERNET.toString()))
            return INTERNET;
        else if (enumAsString.equals(CARD.toString()))
            return CARD;

        return CARD;
    }

    @Override
    public String toString() {
        return name;
    }
}
