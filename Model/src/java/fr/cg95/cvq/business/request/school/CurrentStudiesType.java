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

    public static final CurrentStudiesType LICENCE1 = new CurrentStudiesType("licence1");
    public static final CurrentStudiesType LICENCE2 = new CurrentStudiesType("licence2");
    public static final CurrentStudiesType LICENCE3 = new CurrentStudiesType("licence3");
    public static final CurrentStudiesType LICENCE_PRO = new CurrentStudiesType("licencePro");
    public static final CurrentStudiesType MASTER = new CurrentStudiesType("master");
    public static final CurrentStudiesType MASTER1 = new CurrentStudiesType("master1");
    public static final CurrentStudiesType MASTER2 = new CurrentStudiesType("master2");
    public static final CurrentStudiesType BTS1 = new CurrentStudiesType("bts1");
    public static final CurrentStudiesType BTS2 = new CurrentStudiesType("bts2");
    public static final CurrentStudiesType DUT1 = new CurrentStudiesType("dut1");
    public static final CurrentStudiesType DUT2 = new CurrentStudiesType("dut2");
    public static final CurrentStudiesType SANDWICH_COURSES = new CurrentStudiesType("sandwichCourses");
    public static final CurrentStudiesType ABROAD_INTERNSHIP = new CurrentStudiesType("abroadInternship");
    public static final CurrentStudiesType OTHER_STUDIES = new CurrentStudiesType("otherStudies");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CurrentStudiesType(String value) {
       super(value);
    }


    public CurrentStudiesType() {}



    public static CurrentStudiesType[] allCurrentStudiesTypes = {
        LICENCE1,
        LICENCE2,
        LICENCE3,
        LICENCE_PRO,
        MASTER,
        MASTER1,
        MASTER2,
        BTS1,
        BTS2,
        DUT1,
        DUT2,
        SANDWICH_COURSES,
        ABROAD_INTERNSHIP,
        OTHER_STUDIES
    };


    public static CurrentStudiesType getDefaultCurrentStudiesType() {
        return null;
    }


    public static CurrentStudiesType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultCurrentStudiesType();

        if (enumAsString.equals(LICENCE1.toString()))
            return LICENCE1;
        else if (enumAsString.equals(LICENCE2.toString()))
            return LICENCE2;
        else if (enumAsString.equals(LICENCE3.toString()))
            return LICENCE3;
        else if (enumAsString.equals(LICENCE_PRO.toString()))
            return LICENCE_PRO;
        else if (enumAsString.equals(MASTER.toString()))
            return MASTER;
        else if (enumAsString.equals(MASTER1.toString()))
            return MASTER1;
        else if (enumAsString.equals(MASTER2.toString()))
            return MASTER2;
        else if (enumAsString.equals(BTS1.toString()))
            return BTS1;
        else if (enumAsString.equals(BTS2.toString()))
            return BTS2;
        else if (enumAsString.equals(DUT1.toString()))
            return DUT1;
        else if (enumAsString.equals(DUT2.toString()))
            return DUT2;
        else if (enumAsString.equals(SANDWICH_COURSES.toString()))
            return SANDWICH_COURSES;
        else if (enumAsString.equals(ABROAD_INTERNSHIP.toString()))
            return ABROAD_INTERNSHIP;
        else if (enumAsString.equals(OTHER_STUDIES.toString()))
            return OTHER_STUDIES;

        return getDefaultCurrentStudiesType();
    }
}
