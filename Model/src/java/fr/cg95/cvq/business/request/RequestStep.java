package fr.cg95.cvq.business.request;

/**
 * @author bor@zenexity.fr
 */
public enum RequestStep {

    INSTRUCTION("Instruction"),
    DELIVERY("Delivery");

    private static final long serialVersionUID = 1L;
    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestStep(String step) {
        this.name = step;
    }

    public static RequestStep forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return INSTRUCTION;

        if (enumAsString.equals(INSTRUCTION.toString()))
            return INSTRUCTION;
        else if (enumAsString.equals(DELIVERY.toString()))
            return DELIVERY;

        return INSTRUCTION;
    }

    @Override
    public String toString() {
        return name;
    }
}
