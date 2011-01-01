package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ModeAccueilType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ModeAccueilType COLLECTIF = new ModeAccueilType("Collectif");
  
    public static final ModeAccueilType FAMILIAL = new ModeAccueilType("Familial");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ModeAccueilType(String value) {
        super(value);
    }

    public ModeAccueilType() {}

    public static ModeAccueilType[] allModeAccueilTypes = {
        COLLECTIF,
        FAMILIAL
    };

    public static ModeAccueilType getDefaultModeAccueilType() {
        return null;
    }

    public static ModeAccueilType forString(final String enumAsString) {
        for (ModeAccueilType value : allModeAccueilTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultModeAccueilType();
    }
}
