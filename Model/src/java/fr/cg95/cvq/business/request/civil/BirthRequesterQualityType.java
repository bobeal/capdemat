package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class BirthRequesterQualityType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final BirthRequesterQualityType REQUESTER = new BirthRequesterQualityType("Requester");
  
    public static final BirthRequesterQualityType SPOUSE = new BirthRequesterQualityType("Spouse");
  
    public static final BirthRequesterQualityType PARENT = new BirthRequesterQualityType("Parent");
  
    public static final BirthRequesterQualityType GRAND_PARENT = new BirthRequesterQualityType("GrandParent");
  
    public static final BirthRequesterQualityType CHILD = new BirthRequesterQualityType("Child");
  
    public static final BirthRequesterQualityType LEGAL_REPRESENTANT = new BirthRequesterQualityType("LegalRepresentant");
  
    public static final BirthRequesterQualityType AGENT = new BirthRequesterQualityType("Agent");
  
    public static final BirthRequesterQualityType HEIR_FAMILY = new BirthRequesterQualityType("HeirFamily");
  
    public static final BirthRequesterQualityType HEIR = new BirthRequesterQualityType("Heir");
  
    public static final BirthRequesterQualityType AUTHORIZED = new BirthRequesterQualityType("Authorized");
  
    public static final BirthRequesterQualityType LAWYER_NOTARY = new BirthRequesterQualityType("LawyerNotary");
  
    public static final BirthRequesterQualityType OTHER = new BirthRequesterQualityType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private BirthRequesterQualityType(String value) {
        super(value);
    }

    public BirthRequesterQualityType() {}

    public static BirthRequesterQualityType[] allBirthRequesterQualityTypes = {
        REQUESTER,
        SPOUSE,
        PARENT,
        GRAND_PARENT,
        CHILD,
        LEGAL_REPRESENTANT,
        AGENT,
        HEIR_FAMILY,
        HEIR,
        AUTHORIZED,
        LAWYER_NOTARY,
        OTHER
    };

    public static BirthRequesterQualityType getDefaultBirthRequesterQualityType() {
        return null;
    }

    public static BirthRequesterQualityType forString(final String enumAsString) {
        for (BirthRequesterQualityType value : allBirthRequesterQualityTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthRequesterQualityType();
    }
}
