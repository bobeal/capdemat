package fr.cg95.cvq.business.request.military;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.military.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class ChildDiplomaType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final ChildDiplomaType B_A_C = new ChildDiplomaType("BAC");
    public static final ChildDiplomaType B_E_P = new ChildDiplomaType("BEP");
    public static final ChildDiplomaType B_E_P_C = new ChildDiplomaType("BEPC");
    public static final ChildDiplomaType BREVET = new ChildDiplomaType("Brevet");
    public static final ChildDiplomaType C_F_G = new ChildDiplomaType("CFG");
    public static final ChildDiplomaType C_A_P = new ChildDiplomaType("CAP");
    public static final ChildDiplomaType D_A_E_U = new ChildDiplomaType("DAEU");
    public static final ChildDiplomaType D_E_A = new ChildDiplomaType("DEA");
    public static final ChildDiplomaType D_E_U_G = new ChildDiplomaType("DEUG");
    public static final ChildDiplomaType LICENCE = new ChildDiplomaType("Licence");
    public static final ChildDiplomaType MAITRISE = new ChildDiplomaType("Maitrise");
    public static final ChildDiplomaType UNKNOWN = new ChildDiplomaType("Unknown");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ChildDiplomaType(String value) {
       super(value);
    }


    public ChildDiplomaType() {}



    public static ChildDiplomaType getDefaultChildDiplomaType() {
        return UNKNOWN;
    }


    public static ChildDiplomaType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultChildDiplomaType();

        if (enumAsString.equals(B_A_C.toString()))
            return B_A_C;
        else if (enumAsString.equals(B_E_P.toString()))
            return B_E_P;
        else if (enumAsString.equals(B_E_P_C.toString()))
            return B_E_P_C;
        else if (enumAsString.equals(BREVET.toString()))
            return BREVET;
        else if (enumAsString.equals(C_F_G.toString()))
            return C_F_G;
        else if (enumAsString.equals(C_A_P.toString()))
            return C_A_P;
        else if (enumAsString.equals(D_A_E_U.toString()))
            return D_A_E_U;
        else if (enumAsString.equals(D_E_A.toString()))
            return D_E_A;
        else if (enumAsString.equals(D_E_U_G.toString()))
            return D_E_U_G;
        else if (enumAsString.equals(LICENCE.toString()))
            return LICENCE;
        else if (enumAsString.equals(MAITRISE.toString()))
            return MAITRISE;
        else if (enumAsString.equals(UNKNOWN.toString()))
            return UNKNOWN;

        return getDefaultChildDiplomaType();
    }
}
