package fr.cg95.cvq.business.users;

import java.util.Arrays;
import java.util.List;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public class UserSecurityProfile extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final UserSecurityProfile READ = new UserSecurityProfile("Read");
    public static final UserSecurityProfile WRITE = new UserSecurityProfile("Write");
    public static final UserSecurityProfile MANAGE = new UserSecurityProfile("Manage");

    public UserSecurityProfile() {}

    private UserSecurityProfile(String name) {
        super(name);
    }

    public static final UserSecurityProfile[] allUserSecurityProfiles = { READ, WRITE, MANAGE };

    public static final List<UserSecurityProfile> reader = Arrays.asList(allUserSecurityProfiles);
    public static final List<UserSecurityProfile> writer = Arrays.asList(WRITE, MANAGE);

    public static UserSecurityProfile forString(String enumAsString) {
        for (UserSecurityProfile profile : allUserSecurityProfiles) {
            if (profile.toString().equals(enumAsString))
                return profile;
        }
        return null;
    }

}
