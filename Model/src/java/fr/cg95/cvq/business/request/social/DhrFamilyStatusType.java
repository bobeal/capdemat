package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrFamilyStatusType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrFamilyStatusType SINGLE = new DhrFamilyStatusType("Single");
    public static final DhrFamilyStatusType MARRIED = new DhrFamilyStatusType("Married");
    public static final DhrFamilyStatusType P_A_C_S = new DhrFamilyStatusType("PACS");
    public static final DhrFamilyStatusType COMMON_LAW_MARRIAGE = new DhrFamilyStatusType("CommonLawMarriage");
    public static final DhrFamilyStatusType DIVORCED = new DhrFamilyStatusType("Divorced");
    public static final DhrFamilyStatusType WIDOW = new DhrFamilyStatusType("Widow");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrFamilyStatusType(String value) {
       super(value);
    }


    public DhrFamilyStatusType() {}



    public static DhrFamilyStatusType[] allDhrFamilyStatusTypes = {
        SINGLE,
        MARRIED,
        P_A_C_S,
        COMMON_LAW_MARRIAGE,
        DIVORCED,
        WIDOW
    };


    public static DhrFamilyStatusType getDefaultDhrFamilyStatusType() {
        return null;
    }


    public static DhrFamilyStatusType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrFamilyStatusType();

        if (enumAsString.equals(SINGLE.toString()))
            return SINGLE;
        else if (enumAsString.equals(MARRIED.toString()))
            return MARRIED;
        else if (enumAsString.equals(P_A_C_S.toString()))
            return P_A_C_S;
        else if (enumAsString.equals(COMMON_LAW_MARRIAGE.toString()))
            return COMMON_LAW_MARRIAGE;
        else if (enumAsString.equals(DIVORCED.toString()))
            return DIVORCED;
        else if (enumAsString.equals(WIDOW.toString()))
            return WIDOW;

        return getDefaultDhrFamilyStatusType();
    }
}
