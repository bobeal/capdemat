package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.election.*;

/**
 *
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
        return null;
    }


    public static ElectoralMotiveType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultElectoralMotiveType();

        if (enumAsString.equals(NEW_CITY_RESIDENT.toString()))
            return NEW_CITY_RESIDENT;
        else if (enumAsString.equals(DIRECT_CITY_CONTRIBUTION.toString()))
            return DIRECT_CITY_CONTRIBUTION;
        else if (enumAsString.equals(CIVIL_SERVANT_OBLIGATORY_RESIDENT.toString()))
            return CIVIL_SERVANT_OBLIGATORY_RESIDENT;
        else if (enumAsString.equals(FUTURE_AUTHORIZED_CITIZEN.toString()))
            return FUTURE_AUTHORIZED_CITIZEN;

        return getDefaultElectoralMotiveType();
    }
}
