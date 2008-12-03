package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarAdultLegalAccessRepresentativeKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarAdultLegalAccessRepresentativeKindType FAMILY_MEMBER = new HarAdultLegalAccessRepresentativeKindType("FamilyMember");
    public static final HarAdultLegalAccessRepresentativeKindType AGENCY = new HarAdultLegalAccessRepresentativeKindType("Agency");
    public static final HarAdultLegalAccessRepresentativeKindType OTHER = new HarAdultLegalAccessRepresentativeKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarAdultLegalAccessRepresentativeKindType(String value) {
       super(value);
    }


    public HarAdultLegalAccessRepresentativeKindType() {}



    public static HarAdultLegalAccessRepresentativeKindType[] allHarAdultLegalAccessRepresentativeKindTypes = {
        FAMILY_MEMBER,
        AGENCY,
        OTHER
    };


    public static HarAdultLegalAccessRepresentativeKindType getDefaultHarAdultLegalAccessRepresentativeKindType() {
        return null;
    }


    public static HarAdultLegalAccessRepresentativeKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarAdultLegalAccessRepresentativeKindType();

        if (enumAsString.equals(FAMILY_MEMBER.toString()))
            return FAMILY_MEMBER;
        else if (enumAsString.equals(AGENCY.toString()))
            return AGENCY;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarAdultLegalAccessRepresentativeKindType();
    }
}
