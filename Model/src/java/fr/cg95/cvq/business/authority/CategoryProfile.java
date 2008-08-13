package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class CategoryProfile extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final CategoryProfile NONE = new CategoryProfile("None");
    public static final CategoryProfile READ_ONLY = new CategoryProfile("R/O");
    public static final CategoryProfile READ_WRITE = new CategoryProfile("R/W");
    public static final CategoryProfile MANAGER = new CategoryProfile("Manager");

    public CategoryProfile() {}

    private CategoryProfile(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link CategoryProfile categoryProfiles}.
     */
    public static final CategoryProfile[] allCategoryProfiles = {
        NONE,
        READ_ONLY,
        READ_WRITE,
        MANAGER
    };
}
