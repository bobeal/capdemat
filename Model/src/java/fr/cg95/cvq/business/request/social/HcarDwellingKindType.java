package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
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
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarDwellingKindType();

        if (enumAsString.equals(PLACE_OF_RESIDENCE.toString()))
            return PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(THIRD_PARTY_PLACE_OF_RESIDENCE.toString()))
            return THIRD_PARTY_PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHcarDwellingKindType();
    }
}
