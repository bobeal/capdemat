package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class HarDwellingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarDwellingKindType DOMICILE = new HarDwellingKindType("Domicile");
    public static final HarDwellingKindType THIRD_PARTY_DOMICILE = new HarDwellingKindType("ThirdPartyDomicile");
    public static final HarDwellingKindType OTHER = new HarDwellingKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarDwellingKindType(String value) {
       super(value);
    }


    public HarDwellingKindType() {}



    public static HarDwellingKindType getDefaultHarDwellingKindType() {
        return null;
    }


    public static HarDwellingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarDwellingKindType();

        if (enumAsString.equals(DOMICILE.toString()))
            return DOMICILE;
        else if (enumAsString.equals(THIRD_PARTY_DOMICILE.toString()))
            return THIRD_PARTY_DOMICILE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarDwellingKindType();
    }
}
