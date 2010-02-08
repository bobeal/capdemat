package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ElectoralMotiveType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ElectoralMotiveType NEW_CITY_RESIDENT = new ElectoralMotiveType("NewCityResident");
  
    public static final ElectoralMotiveType DIRECT_CITY_CONTRIBUTION = new ElectoralMotiveType("DirectCityContribution");
  
    public static final ElectoralMotiveType CIVIL_SERVANT_OBLIGATORY_RESIDENT = new ElectoralMotiveType("CivilServantObligatoryResident");
  
    public static final ElectoralMotiveType FUTURE_AUTHORIZED_CITIZEN = new ElectoralMotiveType("FutureAuthorizedCitizen");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ElectoralMotiveType(String value) {
        super(value);
    }

    public ElectoralMotiveType() {}

    public static ElectoralMotiveType[] allElectoralMotiveTypes = {
        NEW_CITY_RESIDENT,
        DIRECT_CITY_CONTRIBUTION,
        CIVIL_SERVANT_OBLIGATORY_RESIDENT,
        FUTURE_AUTHORIZED_CITIZEN
    };

    public static ElectoralMotiveType getDefaultElectoralMotiveType() {
        return NEW_CITY_RESIDENT;
    }

    public static ElectoralMotiveType forString(final String enumAsString) {
        for (ElectoralMotiveType value : allElectoralMotiveTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultElectoralMotiveType();
    }
}
