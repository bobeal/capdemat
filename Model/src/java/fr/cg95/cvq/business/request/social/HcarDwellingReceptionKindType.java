package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarDwellingReceptionKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarDwellingReceptionKindType INTERNSHIP = new HcarDwellingReceptionKindType("Internship");
  
    public static final HcarDwellingReceptionKindType CLERKSHIP = new HcarDwellingReceptionKindType("Clerkship");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarDwellingReceptionKindType(String value) {
        super(value);
    }

    public HcarDwellingReceptionKindType() {}

    public static HcarDwellingReceptionKindType[] allHcarDwellingReceptionKindTypes = {
        INTERNSHIP,
        CLERKSHIP
    };

    public static HcarDwellingReceptionKindType getDefaultHcarDwellingReceptionKindType() {
        return null;
    }

    public static HcarDwellingReceptionKindType forString(final String enumAsString) {
        for (HcarDwellingReceptionKindType value : allHcarDwellingReceptionKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarDwellingReceptionKindType();
    }
}
