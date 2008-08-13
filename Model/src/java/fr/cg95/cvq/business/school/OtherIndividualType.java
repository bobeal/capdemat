package fr.cg95.cvq.business.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class OtherIndividualType extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

    public static final OtherIndividualType CONTACT_PERSON =
        new OtherIndividualType("ContactPerson");
    public static final OtherIndividualType PICKUP_PERSON =
        new OtherIndividualType("PickupPerson");

    public OtherIndividualType() {}

    private OtherIndividualType(String name) {
        super(name);
    }

    public static OtherIndividualType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return null;

        if (enumAsString.equals(CONTACT_PERSON.toString()))
            return CONTACT_PERSON;
        else if (enumAsString.equals(PICKUP_PERSON.toString()))
            return PICKUP_PERSON;

        return null;
    }
}
