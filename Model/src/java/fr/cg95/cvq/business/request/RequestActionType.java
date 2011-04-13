package fr.cg95.cvq.business.request;


/**
 * @author jsb@zenexity.fr
 *
 */
public enum RequestActionType {


    DRAFT_DELETE_NOTIFICATION("DraftDeleteNotification"),
    CREATION_NOTIFICATION("CreationNotification"),
    ORANGE_ALERT_NOTIFICATION("OrangeAlertNotification"),
    RED_ALERT_NOTIFICATION("RedAlertNotification"),
    CREATION("Creation"),
    STATE_CHANGE("StateChange"),
    CONTACT_CITIZEN("ContactCitizen");

    private String name;

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final RequestActionType[] allRequestActionTypes = RequestActionType.values();
    private RequestActionType(String type) {
        this.name = type;
    }

    public static RequestActionType forString(String enumAsString) {
        for (RequestActionType type : values()) {
            if (type.toString().equals(enumAsString)) return type;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
