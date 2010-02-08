package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ALevelsType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ALevelsType ES = new ALevelsType("es");
  
    public static final ALevelsType L = new ALevelsType("l");
  
    public static final ALevelsType S = new ALevelsType("s");
  
    public static final ALevelsType STG = new ALevelsType("stg");
  
    public static final ALevelsType STI = new ALevelsType("sti");
  
    public static final ALevelsType STL = new ALevelsType("stl");
  
    public static final ALevelsType ST2S = new ALevelsType("st2s");
  
    public static final ALevelsType STAV = new ALevelsType("stav");
  
    public static final ALevelsType TMD = new ALevelsType("tmd");
  
    public static final ALevelsType H = new ALevelsType("h");
  
    public static final ALevelsType P = new ALevelsType("p");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ALevelsType(String value) {
        super(value);
    }

    public ALevelsType() {}

    public static ALevelsType[] allALevelsTypes = {
        ES,
        L,
        S,
        STG,
        STI,
        STL,
        ST2S,
        STAV,
        TMD,
        H,
        P
    };

    public static ALevelsType getDefaultALevelsType() {
        return null;
    }

    public static ALevelsType forString(final String enumAsString) {
        for (ALevelsType value : allALevelsTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultALevelsType();
    }
}
