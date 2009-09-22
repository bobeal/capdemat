package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author jsb@zenexity.fr
 *
 */
public class RequestActionType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestActionType DRAFT_DELETE_NOTIFICATION =
        new RequestActionType("DraftDeleteNotification");
    public static final RequestActionType CREATION_NOTIFICATION =
        new RequestActionType("CreationNotification");
    public static final RequestActionType ORANGE_ALERT_NOTIFICATION =
        new RequestActionType("OrangeAlertNotification");
    public static final RequestActionType RED_ALERT_NOTIFICATION =
        new RequestActionType("RedAlertNotification");
    public static final RequestActionType CREATION =
        new RequestActionType("Creation");
    public static final RequestActionType STATE_CHANGE =
        new RequestActionType("StateChange");
    public static final RequestActionType CONTACT_CITIZEN =
        new RequestActionType("ContactCitizen");

    public static final RequestActionType[] allRequestActionTypes = {
        DRAFT_DELETE_NOTIFICATION,
        CREATION_NOTIFICATION,
        ORANGE_ALERT_NOTIFICATION,
        RED_ALERT_NOTIFICATION,
        CREATION,
        STATE_CHANGE,
        CONTACT_CITIZEN
    };

    private RequestActionType(String type) {
        super(type);
    }

    public RequestActionType() { /* Empty constructor for Hibernate */ }

    public static RequestActionType forString(String enumAsString) {
        for (RequestActionType type : allRequestActionTypes) {
            if (type.toString().equals(enumAsString)) return type;
        }
        return null;
    }
}
