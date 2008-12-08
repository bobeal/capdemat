package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarLegalAccessRepresentativeKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarLegalAccessRepresentativeKindType FAMILY_MEMBER = new HarLegalAccessRepresentativeKindType("FamilyMember");
    public static final HarLegalAccessRepresentativeKindType AGENCY = new HarLegalAccessRepresentativeKindType("Agency");
    public static final HarLegalAccessRepresentativeKindType OTHER = new HarLegalAccessRepresentativeKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarLegalAccessRepresentativeKindType(String value) {
       super(value);
    }


    public HarLegalAccessRepresentativeKindType() {}



    public static HarLegalAccessRepresentativeKindType[] allHarLegalAccessRepresentativeKindTypes = {
        FAMILY_MEMBER,
        AGENCY,
        OTHER
    };


    public static HarLegalAccessRepresentativeKindType getDefaultHarLegalAccessRepresentativeKindType() {
        return null;
    }


    public static HarLegalAccessRepresentativeKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarLegalAccessRepresentativeKindType();

        if (enumAsString.equals(FAMILY_MEMBER.toString()))
            return FAMILY_MEMBER;
        else if (enumAsString.equals(AGENCY.toString()))
            return AGENCY;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarLegalAccessRepresentativeKindType();
    }
}
