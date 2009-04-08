package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class CurrentStudiesType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final CurrentStudiesType LICENCE = new CurrentStudiesType("licence");
    public static final CurrentStudiesType LICENCE_PRO = new CurrentStudiesType("licencePro");
    public static final CurrentStudiesType MASTER = new CurrentStudiesType("master");
    public static final CurrentStudiesType BTS = new CurrentStudiesType("bts");
    public static final CurrentStudiesType DUT = new CurrentStudiesType("dut");
    public static final CurrentStudiesType OTHER_STUDIES = new CurrentStudiesType("otherStudies");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CurrentStudiesType(String value) {
       super(value);
    }


    public CurrentStudiesType() {}



    public static CurrentStudiesType[] allCurrentStudiesTypes = {
        LICENCE,
        LICENCE_PRO,
        MASTER,
        BTS,
        DUT,
        OTHER_STUDIES
    };


    public static CurrentStudiesType getDefaultCurrentStudiesType() {
        return null;
    }


    public static CurrentStudiesType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultCurrentStudiesType();

        if (enumAsString.equals(LICENCE.toString()))
            return LICENCE;
        else if (enumAsString.equals(LICENCE_PRO.toString()))
            return LICENCE_PRO;
        else if (enumAsString.equals(MASTER.toString()))
            return MASTER;
        else if (enumAsString.equals(BTS.toString()))
            return BTS;
        else if (enumAsString.equals(DUT.toString()))
            return DUT;
        else if (enumAsString.equals(OTHER_STUDIES.toString()))
            return OTHER_STUDIES;

        return getDefaultCurrentStudiesType();
    }
}
