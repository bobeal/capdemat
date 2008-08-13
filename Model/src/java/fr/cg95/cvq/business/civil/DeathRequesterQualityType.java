package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DeathRequesterQualityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DeathRequesterQualityType SPOUSE = new DeathRequesterQualityType("Spouse");
    public static final DeathRequesterQualityType PARENT = new DeathRequesterQualityType("Parent");
    public static final DeathRequesterQualityType GRAND_PARENT = new DeathRequesterQualityType("GrandParent");
    public static final DeathRequesterQualityType CHILD = new DeathRequesterQualityType("Child");
    public static final DeathRequesterQualityType LEGAL_REPRESENTANT = new DeathRequesterQualityType("LegalRepresentant");
    public static final DeathRequesterQualityType AGENT = new DeathRequesterQualityType("Agent");
    public static final DeathRequesterQualityType HEIR_FAMILY = new DeathRequesterQualityType("HeirFamily");
    public static final DeathRequesterQualityType HEIR = new DeathRequesterQualityType("Heir");
    public static final DeathRequesterQualityType AUTHORIZED = new DeathRequesterQualityType("Authorized");
    public static final DeathRequesterQualityType LAWYER_NOTARY = new DeathRequesterQualityType("LawyerNotary");
    public static final DeathRequesterQualityType OTHER = new DeathRequesterQualityType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathRequesterQualityType(String value) {
       super(value);
    }


    public DeathRequesterQualityType() {}



    public static DeathRequesterQualityType getDefaultDeathRequesterQualityType() {
        return null;
    }


    public static DeathRequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDeathRequesterQualityType();

        if (enumAsString.equals(SPOUSE.toString()))
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

        return getDefaultDeathRequesterQualityType();
    }
}
