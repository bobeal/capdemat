package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class EuropeanNationalityType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final EuropeanNationalityType NONE = new EuropeanNationalityType("none");
  
    public static final EuropeanNationalityType DE = new EuropeanNationalityType("de");
  
    public static final EuropeanNationalityType AD = new EuropeanNationalityType("ad");
  
    public static final EuropeanNationalityType AT = new EuropeanNationalityType("at");
  
    public static final EuropeanNationalityType BE = new EuropeanNationalityType("be");
  
    public static final EuropeanNationalityType BG = new EuropeanNationalityType("bg");
  
    public static final EuropeanNationalityType CY = new EuropeanNationalityType("cy");
  
    public static final EuropeanNationalityType DK = new EuropeanNationalityType("dk");
  
    public static final EuropeanNationalityType ES = new EuropeanNationalityType("es");
  
    public static final EuropeanNationalityType EE = new EuropeanNationalityType("ee");
  
    public static final EuropeanNationalityType FI = new EuropeanNationalityType("fi");
  
    public static final EuropeanNationalityType GR = new EuropeanNationalityType("gr");
  
    public static final EuropeanNationalityType HU = new EuropeanNationalityType("hu");
  
    public static final EuropeanNationalityType IE = new EuropeanNationalityType("ie");
  
    public static final EuropeanNationalityType IT = new EuropeanNationalityType("it");
  
    public static final EuropeanNationalityType LV = new EuropeanNationalityType("lv");
  
    public static final EuropeanNationalityType LT = new EuropeanNationalityType("lt");
  
    public static final EuropeanNationalityType LU = new EuropeanNationalityType("lu");
  
    public static final EuropeanNationalityType MT = new EuropeanNationalityType("mt");
  
    public static final EuropeanNationalityType NL = new EuropeanNationalityType("nl");
  
    public static final EuropeanNationalityType PL = new EuropeanNationalityType("pl");
  
    public static final EuropeanNationalityType PT = new EuropeanNationalityType("pt");
  
    public static final EuropeanNationalityType CZ = new EuropeanNationalityType("cz");
  
    public static final EuropeanNationalityType RO = new EuropeanNationalityType("ro");
  
    public static final EuropeanNationalityType GB = new EuropeanNationalityType("gb");
  
    public static final EuropeanNationalityType SI = new EuropeanNationalityType("si");
  
    public static final EuropeanNationalityType SK = new EuropeanNationalityType("sk");
  
    public static final EuropeanNationalityType SE = new EuropeanNationalityType("se");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private EuropeanNationalityType(String value) {
        super(value);
    }

    public EuropeanNationalityType() {}

    public static EuropeanNationalityType[] allEuropeanNationalityTypes = {
        NONE,
        DE,
        AD,
        AT,
        BE,
        BG,
        CY,
        DK,
        ES,
        EE,
        FI,
        GR,
        HU,
        IE,
        IT,
        LV,
        LT,
        LU,
        MT,
        NL,
        PL,
        PT,
        CZ,
        RO,
        GB,
        SI,
        SK,
        SE
    };

    public static EuropeanNationalityType getDefaultEuropeanNationalityType() {
        return null;
    }

    public static EuropeanNationalityType forString(final String enumAsString) {
        for (EuropeanNationalityType value : allEuropeanNationalityTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultEuropeanNationalityType();
    }
}
