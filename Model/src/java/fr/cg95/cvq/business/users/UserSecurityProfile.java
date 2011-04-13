package fr.cg95.cvq.business.users;

import java.util.Arrays;
import java.util.List;


public enum UserSecurityProfile {

    READ("Read"),
    WRITE("Write"),
    MANAGE("Manage");

    private String name;

    private UserSecurityProfile(String name) {
        this.name = name;
    }

    /**
     * @deprecated only for backward, use UserSecurityType.values() instead
     */
    public static final UserSecurityProfile[] allUserSecurityProfiles = UserSecurityProfile.values();

    public static final List<UserSecurityProfile> reader = Arrays.asList(allUserSecurityProfiles);
    public static final List<UserSecurityProfile> writer = Arrays.asList(WRITE, MANAGE);

    public static UserSecurityProfile forString(String enumAsString) {
        for (UserSecurityProfile profile : allUserSecurityProfiles) {
            if (profile.toString().equals(enumAsString))
                return profile;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
