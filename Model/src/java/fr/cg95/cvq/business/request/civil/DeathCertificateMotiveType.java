package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DeathCertificateMotiveType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DeathCertificateMotiveType NOTARY_ACT = new DeathCertificateMotiveType("NotaryAct");
  
    public static final DeathCertificateMotiveType MARRIAGE = new DeathCertificateMotiveType("Marriage");
  
    public static final DeathCertificateMotiveType PASSPORT = new DeathCertificateMotiveType("Passport");
  
    public static final DeathCertificateMotiveType PENSION = new DeathCertificateMotiveType("Pension");
  
    public static final DeathCertificateMotiveType OTHER = new DeathCertificateMotiveType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathCertificateMotiveType(String value) {
        super(value);
    }

    public DeathCertificateMotiveType() {}

    public static DeathCertificateMotiveType[] allDeathCertificateMotiveTypes = {
        NOTARY_ACT,
        MARRIAGE,
        PASSPORT,
        PENSION,
        OTHER
    };

    public static DeathCertificateMotiveType getDefaultDeathCertificateMotiveType() {
        return null;
    }

    public static DeathCertificateMotiveType forString(final String enumAsString) {
        for (DeathCertificateMotiveType value : allDeathCertificateMotiveTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDeathCertificateMotiveType();
    }
}
