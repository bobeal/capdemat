package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HccrDwellingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HccrDwellingKindType PLACE_OF_RESIDENCE = new HccrDwellingKindType("PlaceOfResidence");
    public static final HccrDwellingKindType THIRD_PARTY_PLACE_OF_RESIDENCE = new HccrDwellingKindType("ThirdPartyPlaceOfResidence");
    public static final HccrDwellingKindType OTHER = new HccrDwellingKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrDwellingKindType(String value) {
       super(value);
    }


    public HccrDwellingKindType() {}



    public static HccrDwellingKindType[] allHccrDwellingKindTypes = {
        PLACE_OF_RESIDENCE,
        THIRD_PARTY_PLACE_OF_RESIDENCE,
        OTHER
    };


    public static HccrDwellingKindType getDefaultHccrDwellingKindType() {
        return null;
    }


    public static HccrDwellingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrDwellingKindType();

        if (enumAsString.equals(PLACE_OF_RESIDENCE.toString()))
            return PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(THIRD_PARTY_PLACE_OF_RESIDENCE.toString()))
            return THIRD_PARTY_PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHccrDwellingKindType();
    }
}
