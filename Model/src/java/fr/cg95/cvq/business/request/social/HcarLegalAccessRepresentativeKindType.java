package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarLegalAccessRepresentativeKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarLegalAccessRepresentativeKindType FAMILY_MEMBER = new HcarLegalAccessRepresentativeKindType("FamilyMember");
  
    public static final HcarLegalAccessRepresentativeKindType AGENCY = new HcarLegalAccessRepresentativeKindType("Agency");
  
    public static final HcarLegalAccessRepresentativeKindType OTHER = new HcarLegalAccessRepresentativeKindType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarLegalAccessRepresentativeKindType(String value) {
        super(value);
    }

    public HcarLegalAccessRepresentativeKindType() {}

    public static HcarLegalAccessRepresentativeKindType[] allHcarLegalAccessRepresentativeKindTypes = {
        FAMILY_MEMBER,
        AGENCY,
        OTHER
    };

    public static HcarLegalAccessRepresentativeKindType getDefaultHcarLegalAccessRepresentativeKindType() {
        return null;
    }

    public static HcarLegalAccessRepresentativeKindType forString(final String enumAsString) {
        for (HcarLegalAccessRepresentativeKindType value : allHcarLegalAccessRepresentativeKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarLegalAccessRepresentativeKindType();
    }
}
