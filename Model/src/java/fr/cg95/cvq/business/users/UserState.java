package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class UserState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final UserState NEW = new UserState("New");
    public static final UserState VALID = new UserState("Valid");
    public static final UserState MODIFIED = new UserState("Modified");
    public static final UserState INVALID = new UserState("Invalid");
    public static final UserState ARCHIVED = new UserState("Archived");

    private UserState(final String state) {
        super(state);
    }

    public UserState() {}

    public static final UserState[] allUserStates = { NEW, VALID, MODIFIED, INVALID, ARCHIVED };

    public static UserState forString(final String enumAsString) {
        for (UserState state : allUserStates) {
            if (state.toString().equals(enumAsString)) return state;
        }
        return NEW;
    }
}
