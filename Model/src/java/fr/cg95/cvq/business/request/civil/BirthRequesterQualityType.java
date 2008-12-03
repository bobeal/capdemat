package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
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
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultBirthRequesterQualityType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(SPOUSE.toString()))
            return SPOUSE;
        else if (enumAsString.equals(PARENT.toString()))
            return PARENT;
        else if (enumAsString.equals(GRAND_PARENT.toString()))
            return GRAND_PARENT;
        else if (enumAsString.equals(CHILD.toString()))
            return CHILD;
        else if (enumAsString.equals(LEGAL_REPRESENTANT.toString()))
            return LEGAL_REPRESENTANT;
        else if (enumAsString.equals(AGENT.toString()))
            return AGENT;
        else if (enumAsString.equals(HEIR_FAMILY.toString()))
            return HEIR_FAMILY;
        else if (enumAsString.equals(HEIR.toString()))
            return HEIR;
        else if (enumAsString.equals(AUTHORIZED.toString()))
            return AUTHORIZED;
        else if (enumAsString.equals(LAWYER_NOTARY.toString()))
            return LAWYER_NOTARY;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultBirthRequesterQualityType();
    }
}
