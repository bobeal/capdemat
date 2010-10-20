package fr.cg95.cvq.business.users.external;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
 
public final class MappingState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final MappingState FREE = new MappingState("Free");
    public static final MappingState BINDED = new MappingState("Binded");
    public static final MappingState IGNORED = new MappingState("Ignored");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MappingState(final String state) {
        super(state);
    }

    public MappingState() {}

    public static final MappingState[] allMappingStates = { FREE, BINDED, IGNORED };

    public static MappingState forString(final String enumAsString) {
        for (MappingState type : allMappingStates) {
            if (type.toString().equals(enumAsString)) return type;
        }
        return null;
    }
}
