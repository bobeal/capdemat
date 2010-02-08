package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarLegalAccessKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarLegalAccessKindType SAFEGUARDING_JUSTICE = new HcarLegalAccessKindType("safeguardingJustice");
  
    public static final HcarLegalAccessKindType GUARDIANSHIP = new HcarLegalAccessKindType("guardianship");
  
    public static final HcarLegalAccessKindType CURATORSHIP = new HcarLegalAccessKindType("curatorship");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarLegalAccessKindType(String value) {
        super(value);
    }

    public HcarLegalAccessKindType() {}

    public static HcarLegalAccessKindType[] allHcarLegalAccessKindTypes = {
        SAFEGUARDING_JUSTICE,
        GUARDIANSHIP,
        CURATORSHIP
    };

    public static HcarLegalAccessKindType getDefaultHcarLegalAccessKindType() {
        return null;
    }

    public static HcarLegalAccessKindType forString(final String enumAsString) {
        for (HcarLegalAccessKindType value : allHcarLegalAccessKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarLegalAccessKindType();
    }
}
