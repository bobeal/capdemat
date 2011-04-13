package fr.cg95.cvq.business.request;


public enum CategoryProfile {

    READ_ONLY("R/O"),
    READ_WRITE("R/W"),
    MANAGER("Manager");

    private String name;

    private CategoryProfile(String name) {
        this.name = name;
    }

    /**
     * A vector of all possible {@link CategoryProfile categoryProfiles}.
     * @deprecated only for backward, use values() instead
     */
    public static final CategoryProfile[] allCategoryProfiles = CategoryProfile.values();
}
