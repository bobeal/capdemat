package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class UserState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final UserState NEW = new UserState("New", 0);
    public static final UserState VALID = new UserState("Valid", 1);
    public static final UserState MODIFIED = new UserState("Modified", 2);
    public static final UserState INVALID = new UserState("Invalid", 3);
    public static final UserState ARCHIVED = new UserState("Archived", 4);

    private Integer order;

    private UserState(final String state, int order) {
        super(state);
        this.order = order;
    }

    public UserState() {}

    public static final UserState[] allUserStates = { NEW, VALID, MODIFIED, INVALID, ARCHIVED };

    public static UserState forString(final String enumAsString) {
        for (UserState state : allUserStates) {
            if (state.toString().equals(enumAsString)) return state;
        }
        return NEW;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof UserState) return order.compareTo(((UserState)o).order);
        return super.compareTo(o);
    }
}
