package fr.cg95.cvq.business.payment;

/**
 * @author bor@zenexity.fr
 */
public enum PaymentState {

    INITIALIZED("Initialized"),
    VALIDATED("Validated"),
    REFUSED("Refused"),
    CANCELLED("Cancelled");

    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private PaymentState(String state) {
        this.name = state;
    }

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final PaymentState[] allPaymentStates = values();

    public static PaymentState forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals("")) return INITIALIZED;

        if (enumAsString.equals(INITIALIZED.toString()))  return INITIALIZED;
        else if (enumAsString.equals(VALIDATED.toString())) return VALIDATED;
        else if (enumAsString.equals(CANCELLED.toString())) return CANCELLED;
        else if (enumAsString.equals(REFUSED.toString())) return REFUSED;

        return INITIALIZED;
    }

    @Override
    public String toString() {
        return name;
    }
}
