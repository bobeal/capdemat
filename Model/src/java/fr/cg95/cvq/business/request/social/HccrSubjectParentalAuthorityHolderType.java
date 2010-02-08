package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrSubjectParentalAuthorityHolderType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrSubjectParentalAuthorityHolderType FATHER = new HccrSubjectParentalAuthorityHolderType("Father");
  
    public static final HccrSubjectParentalAuthorityHolderType MOTHER = new HccrSubjectParentalAuthorityHolderType("Mother");
  
    public static final HccrSubjectParentalAuthorityHolderType OTHER = new HccrSubjectParentalAuthorityHolderType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrSubjectParentalAuthorityHolderType(String value) {
        super(value);
    }

    public HccrSubjectParentalAuthorityHolderType() {}

    public static HccrSubjectParentalAuthorityHolderType[] allHccrSubjectParentalAuthorityHolderTypes = {
        FATHER,
        MOTHER,
        OTHER
    };

    public static HccrSubjectParentalAuthorityHolderType getDefaultHccrSubjectParentalAuthorityHolderType() {
        return null;
    }

    public static HccrSubjectParentalAuthorityHolderType forString(final String enumAsString) {
        for (HccrSubjectParentalAuthorityHolderType value : allHccrSubjectParentalAuthorityHolderTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSubjectParentalAuthorityHolderType();
    }
}
