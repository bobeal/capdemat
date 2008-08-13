package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class RequesterQualityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RequesterQualityType REQUESTER = new RequesterQualityType("Requester");
    public static final RequesterQualityType SPOUSE = new RequesterQualityType("Spouse");
    public static final RequesterQualityType PARENT = new RequesterQualityType("Parent");
    public static final RequesterQualityType GRAND_PARENT = new RequesterQualityType("GrandParent");
    public static final RequesterQualityType CHILD = new RequesterQualityType("Child");
    public static final RequesterQualityType LEGAL_REPRESENTANT = new RequesterQualityType("LegalRepresentant");
    public static final RequesterQualityType AGENT = new RequesterQualityType("Agent");
    public static final RequesterQualityType HEIR_FAMILY = new RequesterQualityType("HeirFamily");
    public static final RequesterQualityType HEIR = new RequesterQualityType("Heir");
    public static final RequesterQualityType AUTHORIZED = new RequesterQualityType("Authorized");
    public static final RequesterQualityType LAWYER_NOTARY = new RequesterQualityType("LawyerNotary");
    public static final RequesterQualityType OTHER = new RequesterQualityType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequesterQualityType(String value) {
       super(value);
    }


    public RequesterQualityType() {}



    public static RequesterQualityType getDefaultRequesterQualityType() {
        return null;
    }


    public static RequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRequesterQualityType();

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

        return getDefaultRequesterQualityType();
    }
}
