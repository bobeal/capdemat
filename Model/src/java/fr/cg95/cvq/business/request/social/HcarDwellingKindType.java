package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarDwellingKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarDwellingKindType PLACE_OF_RESIDENCE = new HcarDwellingKindType("PlaceOfResidence");
  
    public static final HcarDwellingKindType THIRD_PARTY_PLACE_OF_RESIDENCE = new HcarDwellingKindType("ThirdPartyPlaceOfResidence");
  
    public static final HcarDwellingKindType OTHER = new HcarDwellingKindType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarDwellingKindType(String value) {
        super(value);
    }

    public HcarDwellingKindType() {}

    public static HcarDwellingKindType[] allHcarDwellingKindTypes = {
        PLACE_OF_RESIDENCE,
        THIRD_PARTY_PLACE_OF_RESIDENCE,
        OTHER
    };

    public static HcarDwellingKindType getDefaultHcarDwellingKindType() {
        return null;
    }

    public static HcarDwellingKindType forString(final String enumAsString) {
        for (HcarDwellingKindType value : allHcarDwellingKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarDwellingKindType();
    }
}
