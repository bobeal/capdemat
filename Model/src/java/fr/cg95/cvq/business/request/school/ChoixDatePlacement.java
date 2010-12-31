package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ChoixDatePlacement extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ChoixDatePlacement CONNUE = new ChoixDatePlacement("Connue");
  
    public static final ChoixDatePlacement POSSIBLE = new ChoixDatePlacement("Possible");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ChoixDatePlacement(String value) {
        super(value);
    }

    public ChoixDatePlacement() {}

    public static ChoixDatePlacement[] allChoixDatePlacements = {
        CONNUE,
        POSSIBLE
    };

    public static ChoixDatePlacement getDefaultChoixDatePlacement() {
        return null;
    }

    public static ChoixDatePlacement forString(final String enumAsString) {
        for (ChoixDatePlacement value : allChoixDatePlacements)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixDatePlacement();
    }
}
