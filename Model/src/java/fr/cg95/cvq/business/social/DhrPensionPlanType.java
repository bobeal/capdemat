package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DhrPensionPlanType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrPensionPlanType C_R_A_M_I_F = new DhrPensionPlanType("CRAMIF");
    public static final DhrPensionPlanType C_N_A_V = new DhrPensionPlanType("CNAV");
    public static final DhrPensionPlanType M_S_A = new DhrPensionPlanType("MSA");
    public static final DhrPensionPlanType C_R_A_M = new DhrPensionPlanType("CRAM");
    public static final DhrPensionPlanType M_G_E_N = new DhrPensionPlanType("MGEN");
    public static final DhrPensionPlanType S_N_C_F = new DhrPensionPlanType("SNCF");
    public static final DhrPensionPlanType OTHER = new DhrPensionPlanType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrPensionPlanType(String value) {
       super(value);
    }


    public DhrPensionPlanType() {}



    public static DhrPensionPlanType getDefaultDhrPensionPlanType() {
        return null;
    }


    public static DhrPensionPlanType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrPensionPlanType();

        if (enumAsString.equals(C_R_A_M_I_F.toString()))
            return C_R_A_M_I_F;
        else if (enumAsString.equals(C_N_A_V.toString()))
            return C_N_A_V;
        else if (enumAsString.equals(M_S_A.toString()))
            return M_S_A;
        else if (enumAsString.equals(C_R_A_M.toString()))
            return C_R_A_M;
        else if (enumAsString.equals(M_G_E_N.toString()))
            return M_G_E_N;
        else if (enumAsString.equals(S_N_C_F.toString()))
            return S_N_C_F;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultDhrPensionPlanType();
    }
}
