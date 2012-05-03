package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ElectoralSituationType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ElectoralSituationType FIRST_SUBSCRIPTION = new ElectoralSituationType("FirstSubscription");
  
    public static final ElectoralSituationType MOVE_SUBSCRIPTION = new ElectoralSituationType("MoveSubscription");
  
    public static final ElectoralSituationType MOVE_OTHER_SUBSCRIPTION = new ElectoralSituationType("MoveOtherSubscription");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ElectoralSituationType(String value) {
        super(value);
    }

    public ElectoralSituationType() {}

    public static ElectoralSituationType[] allElectoralSituationTypes = {
        FIRST_SUBSCRIPTION,
        MOVE_SUBSCRIPTION,
        MOVE_OTHER_SUBSCRIPTION
    };

    public static ElectoralSituationType getDefaultElectoralSituationType() {
        return FIRST_SUBSCRIPTION;
    }

    public static ElectoralSituationType forString(final String enumAsString) {
        for (ElectoralSituationType value : allElectoralSituationTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultElectoralSituationType();
    }
}
