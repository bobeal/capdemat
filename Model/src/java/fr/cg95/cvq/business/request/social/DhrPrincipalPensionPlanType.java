package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrPrincipalPensionPlanType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrPrincipalPensionPlanType C_N_A_V = new DhrPrincipalPensionPlanType("CNAV");
    public static final DhrPrincipalPensionPlanType M_S_A = new DhrPrincipalPensionPlanType("MSA");
    public static final DhrPrincipalPensionPlanType C_R_A_M = new DhrPrincipalPensionPlanType("CRAM");
    public static final DhrPrincipalPensionPlanType M_G_E_N = new DhrPrincipalPensionPlanType("MGEN");
    public static final DhrPrincipalPensionPlanType S_N_C_F = new DhrPrincipalPensionPlanType("SNCF");
    public static final DhrPrincipalPensionPlanType OTHER = new DhrPrincipalPensionPlanType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrPrincipalPensionPlanType(String value) {
       super(value);
    }


    public DhrPrincipalPensionPlanType() {}



    public static DhrPrincipalPensionPlanType[] allDhrPrincipalPensionPlanTypes = {
        C_N_A_V,
        M_S_A,
        C_R_A_M,
        M_G_E_N,
        S_N_C_F,
        OTHER
    };


    public static DhrPrincipalPensionPlanType getDefaultDhrPrincipalPensionPlanType() {
        return null;
    }


    public static DhrPrincipalPensionPlanType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrPrincipalPensionPlanType();

        if (enumAsString.equals(C_N_A_V.toString()))
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

        return getDefaultDhrPrincipalPensionPlanType();
    }
}
