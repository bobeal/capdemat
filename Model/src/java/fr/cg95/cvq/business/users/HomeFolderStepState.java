package fr.cg95.cvq.business.users;

public enum HomeFolderStepState {

    UNNEEDED("Unneeded"),
    UNCOMPLETE("Uncomplete"),
    COMPLETE("Complete"),
    INVALID("Invalid");

    private String name;

    private HomeFolderStepState(final String state) {
        this.name = state;
    }

    public static HomeFolderStepState forString(final String enumAsString) {
        for (HomeFolderStepState state : values()) {
            if (state.toString().equals(enumAsString)) return state;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
