package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class NationalityType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final NationalityType FRENCH = new NationalityType("French");
    public static final NationalityType EUROPEAN_UNION = new NationalityType("EuropeanUnion");
    public static final NationalityType OUTSIDE_EUROPEAN_UNION = 
        new NationalityType("OutsideEuropeanUnion");
    
    public NationalityType() {}
    
    public NationalityType(String name) {
        super(name);
    }
    
    public static final NationalityType[] allNationalityTypes = {
        FRENCH,
        EUROPEAN_UNION,
        OUTSIDE_EUROPEAN_UNION
    };
    
    public static NationalityType getDefaultNationalityType() {
        return FRENCH;
    }
    
    public static NationalityType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return FRENCH;
        
        if (enumAsString.equals(FRENCH.toString()))
            return FRENCH;
        else if (enumAsString.equals(EUROPEAN_UNION.toString()))
            return EUROPEAN_UNION;
        else if (enumAsString.equals(OUTSIDE_EUROPEAN_UNION))
            return OUTSIDE_EUROPEAN_UNION;
        
        return FRENCH;
    }
}
