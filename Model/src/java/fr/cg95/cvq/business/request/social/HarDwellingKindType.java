package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarDwellingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarDwellingKindType PLACE_OF_RESIDENCE = new HarDwellingKindType("PlaceOfResidence");
    public static final HarDwellingKindType THIRD_PARTY_PLACE_OF_RESIDENCE = new HarDwellingKindType("ThirdPartyPlaceOfResidence");
    public static final HarDwellingKindType OTHER = new HarDwellingKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarDwellingKindType(String value) {
       super(value);
    }


    public HarDwellingKindType() {}



    public static HarDwellingKindType[] allHarDwellingKindTypes = {
        PLACE_OF_RESIDENCE,
        THIRD_PARTY_PLACE_OF_RESIDENCE,
        OTHER
    };


    public static HarDwellingKindType getDefaultHarDwellingKindType() {
        return null;
    }


    public static HarDwellingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarDwellingKindType();

        if (enumAsString.equals(PLACE_OF_RESIDENCE.toString()))
            return PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(THIRD_PARTY_PLACE_OF_RESIDENCE.toString()))
            return THIRD_PARTY_PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarDwellingKindType();
    }
}
