package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DhrDwellingKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DhrDwellingKindType PLACE_OF_RESIDENCE = new DhrDwellingKindType("placeOfResidence");
  
    public static final DhrDwellingKindType RETIREMENT_HOME = new DhrDwellingKindType("retirementHome");
  
    public static final DhrDwellingKindType OTHER = new DhrDwellingKindType("other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrDwellingKindType(String value) {
        super(value);
    }

    public DhrDwellingKindType() {}

    public static DhrDwellingKindType[] allDhrDwellingKindTypes = {
        PLACE_OF_RESIDENCE,
        RETIREMENT_HOME,
        OTHER
    };

    public static DhrDwellingKindType getDefaultDhrDwellingKindType() {
        return null;
    }

    public static DhrDwellingKindType forString(final String enumAsString) {
        for (DhrDwellingKindType value : allDhrDwellingKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrDwellingKindType();
    }
}
