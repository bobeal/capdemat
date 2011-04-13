package fr.cg95.cvq.business.users.external;

public enum MappingState {

    FREE("Free"),
    BINDED("Binded"),
    IGNORED("Ignored");

    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MappingState(final String state) {
        this.name = state;
    }

    /**
     * @deprecated only for backward, use MappingState.values() instead
     */
    public static final MappingState[] allMappingStates = MappingState.values();

    public static MappingState forString(final String enumAsString) {
        for (MappingState type : values()) {
            if (type.toString().equals(enumAsString)) return type;
        }
        return null;
    }

    @Override
    public String toString() {
        return  name;
    }
}
