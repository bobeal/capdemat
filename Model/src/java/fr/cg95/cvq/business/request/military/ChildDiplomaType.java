package fr.cg95.cvq.business.request.military;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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

    public static ChildDiplomaType[] allChildDiplomaTypes = {
        B_A_C,
        B_E_P,
        B_E_P_C,
        BREVET,
        C_F_G,
        C_A_P,
        D_A_E_U,
        D_E_A,
        D_E_U_G,
        LICENCE,
        MAITRISE,
        UNKNOWN
    };

    public static ChildDiplomaType getDefaultChildDiplomaType() {
        return null;
    }

    public static ChildDiplomaType forString(final String enumAsString) {
        for (ChildDiplomaType value : allChildDiplomaTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChildDiplomaType();
    }
}
